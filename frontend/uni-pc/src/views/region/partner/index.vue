<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="86px">
      <el-form-item label="合作商名称" prop="partnerName">
        <el-input
          v-model="queryParams.partnerName"
          placeholder="请输入合作商名称"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
        <el-button icon="Refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="Plus"
          @click="handleAdd"
          v-hasPermi="['region:partner:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="Edit"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['region:partner:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="Delete"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['region:partner:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="Download"
          @click="handleExport"
          v-hasPermi="['region:partner:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="partnerList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="id" />
      <el-table-column label="合作商名称" align="center" prop="partnerName" />
      <el-table-column label="点位数" align="center" prop="nodeCount" />
      <el-table-column label="账号" align="center" prop="account" />
      <el-table-column label="分成比例" align="center" prop="revenueShare">
        <!-- 显示百分比 -->
        <template #default="scope">
          {{ scope.row.revenueShare + '%' }}
        </template>
      </el-table-column>
      <el-table-column label="联系人" align="center" prop="contactPerson" />
      <el-table-column label="联系电话" align="center" prop="contactNumber" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width" width="300">
        <template #default="scope">
          <el-button link type="primary"  @click="handleResetPwd(scope.row)" v-hasPermi="['region:partner:edit']">重置密码</el-button>
          <el-button link type="primary"  @click="handleDetail(scope.row)" v-hasPermi="['region:partner:edit']">查看详情</el-button>
          <el-button link type="primary"  @click="handleUpdate(scope.row)" v-hasPermi="['region:partner:edit']">修改</el-button>
          <el-button link type="primary"  @click="handleDelete(scope.row)" v-hasPermi="['region:partner:remove']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      v-model:page="queryParams.pageNum"
      v-model:limit="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改合作商管理对话框 -->
    <el-dialog :title="title" v-model="open" width="500px" append-to-body>
      <el-form ref="partnerRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="合作商名称" prop="partnerName">
          <el-input v-model="form.partnerName" placeholder="请输入合作商名称" />
        </el-form-item>
        <el-form-item label="联系人" prop="contactPerson">
          <el-input v-model="form.contactPerson" placeholder="请输入联系人" />
        </el-form-item>
        <el-form-item label="联系电话" prop="contactNumber">
          <el-input v-model="form.contactNumber" placeholder="请输入联系电话" />
        </el-form-item>
        <el-form-item label="联系电话" prop="createTime" v-if="form.id != null">
          {{ form.createTime }}
        </el-form-item>
        <el-form-item label="分成比例" prop="revenueShare">
          <el-input v-model="form.revenueShare" placeholder="请输入分成比例">
            <!-- 增加百分比显示效果 -->
            <template #append>%</template>
          </el-input>
        </el-form-item>
        <el-form-item v-if="form.id == null" label="账号" prop="account">
          <el-input v-model="form.account" placeholder="请输入账号" />
        </el-form-item>
        <el-form-item v-if="form.id == null" label="密码" prop="password">
          <!-- 将密码改输入框为🔐显示 -->
          <el-input type="password" v-model="form.password" placeholder="请输入密码" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>

    <!-- 查看合作商详情 -->
    <el-dialog :title="title" v-model="detailOpen" width="500px" append-to-body>
      <el-form ref="partnerRef" :model="form" label-width="100px">
        <el-row>
          <el-col :span="12">
            <el-form-item label="合作商名称" prop="partnerName">
              {{form.partnerName}}
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="联系人" prop="contactPerson">
              {{form.contactPerson}}
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="联系电话" prop="contactNumber">
              {{form.contactNumber}}
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="分成比例" prop="revenueShare">
              {{form.revenueShare}}%
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
    </el-dialog>

  </div>
</template>

<script setup name="Partner">
import {listPartner, getPartner, delPartner, addPartner, updatePartner, resetPartnerPwd} from "@/api/region/partner";
import { ref } from "vue";

const { proxy } = getCurrentInstance();

const partnerList = ref([]);
const open = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref("");

const data = reactive({
  form: {},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    partnerName: null,
  },
  rules: {
    partnerName: [
      { required: true, message: "合作商名称不能为空", trigger: "blur" }
    ],
    contactPerson: [
      { required: true, message: "联系人不能为空", trigger: "blur" }
    ],
    contactNumber: [
      { required: true, message: "联系电话不能为空", trigger: "blur" }
    ],
    revenueShare: [
      { required: true, message: "分成比例不能为空", trigger: "blur" }
    ],
    account: [
      { required: true, message: "账号不能为空", trigger: "blur" }
    ],
    password: [
      { required: true, message: "密码不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询合作商管理列表 */
function getList() {
  loading.value = true;
  listPartner(queryParams.value).then(response => {
    partnerList.value = response.rows;
    total.value = response.total;
    loading.value = false;
  });
}

// 取消按钮
function cancel() {
  open.value = false;
  reset();
}

// 表单重置
function reset() {
  form.value = {
    id: null,
    partnerName: null,
    contactPerson: null,
    contactNumber: null,
    revenueShare: null,
    account: null,
    password: null,
    createTime: null,
    updateTime: null,
    createBy: null,
    updateBy: null,
    remark: null
  };
  proxy.resetForm("partnerRef");
}

/** 搜索按钮操作 */
function handleQuery() {
  queryParams.value.pageNum = 1;
  getList();
}

/** 重置按钮操作 */
function resetQuery() {
  proxy.resetForm("queryRef");
  handleQuery();
}

// 多选框选中数据
function handleSelectionChange(selection) {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
function handleAdd() {
  reset();
  open.value = true;
  title.value = "添加合作商管理";
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset();
  const _id = row.id || ids.value
  getPartner(_id).then(response => {
    form.value = response.data;
    open.value = true;
    title.value = "修改合作商管理";
  });
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["partnerRef"].validate(valid => {
    if (valid) {
      if (form.value.id != null) {
        updatePartner(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addPartner(form.value).then(response => {
          proxy.$modal.msgSuccess("新增成功");
          open.value = false;
          getList();
        });
      }
    }
  });
}

/** 删除按钮操作 */
function handleDelete(row) {
  const _ids = row.id || ids.value;
  proxy.$modal.confirm('是否确认删除合作商管理编号为"' + _ids + '"的数据项？').then(function() {
    return delPartner(_ids);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("删除成功");
  }).catch(() => {});
}

/** 重置密码按钮操作 */
function handleResetPwd(row) {
  const _ids = row.id || ids.value;
  proxy.$modal.confirm('是否确认重置合作商密码？').then(function() {
    return resetPartnerPwd(_ids);
  }).then(() => {
    // 刷新列表
    getList();
    proxy.$modal.msgSuccess("重置密码成功");
  }).catch(() => {});
}

/** 导出按钮操作 */
function handleExport() {
  proxy.download('region/partner/export', {
    ...queryParams.value
  }, `partner_${new Date().getTime()}.xlsx`)
}

const detailOpen = ref(false);
function handleDetail(row) {
  reset();
  const _id = row.id || ids.value
  getPartner(_id).then(response => {
    form.value = response.data;
    title.value = "合作商信息";
    detailOpen.value = true;
  });
}

getList();
</script>
