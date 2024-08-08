package com.uni.merchant.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.uni.common.annotation.Log;
import com.uni.common.core.controller.BaseController;
import com.uni.common.core.domain.AjaxResult;
import com.uni.common.enums.BusinessType;
import com.uni.merchant.domain.Node;
import com.uni.merchant.service.INodeService;
import com.uni.common.utils.poi.ExcelUtil;
import com.uni.common.core.page.TableDataInfo;

/**
 * 点位管理Controller
 * 
 * @author uni
 * @date 2024-07-31
 */
@RestController
@RequestMapping("/region/node")
public class NodeController extends BaseController
{
    @Autowired
    private INodeService nodeService;

    /**
     * 查询点位管理列表
     */
    @PreAuthorize("@ss.hasPermi('region:node:list')")
    @GetMapping("/list")
    public TableDataInfo list(Node node)
    {
        startPage();
        List<Node> list = nodeService.selectNodeList(node);
        return getDataTable(list);
    }

    /**
     * 导出点位管理列表
     */
    @PreAuthorize("@ss.hasPermi('region:node:export')")
    @Log(title = "点位管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Node node)
    {
        List<Node> list = nodeService.selectNodeList(node);
        ExcelUtil<Node> util = new ExcelUtil<Node>(Node.class);
        util.exportExcel(response, list, "点位管理数据");
    }

    /**
     * 获取点位管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('region:node:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(nodeService.selectNodeById(id));
    }

    /**
     * 新增点位管理
     */
    @PreAuthorize("@ss.hasPermi('region:node:add')")
    @Log(title = "点位管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Node node)
    {
        return toAjax(nodeService.insertNode(node));
    }

    /**
     * 修改点位管理
     */
    @PreAuthorize("@ss.hasPermi('region:node:edit')")
    @Log(title = "点位管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Node node)
    {
        return toAjax(nodeService.updateNode(node));
    }

    /**
     * 删除点位管理
     */
    @PreAuthorize("@ss.hasPermi('region:node:remove')")
    @Log(title = "点位管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(nodeService.deleteNodeByIds(ids));
    }
}