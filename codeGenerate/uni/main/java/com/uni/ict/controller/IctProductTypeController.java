package com.uni.ict.controller;

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
import com.uni.ict.domain.IctProductType;
import com.uni.ict.service.IIctProductTypeService;
import com.uni.common.utils.poi.ExcelUtil;

/**
 * 产品类型Controller
 * 
 * @author uni
 * @date 2024-08-09
 */
@RestController
@RequestMapping("/ict/productType")
public class IctProductTypeController extends BaseController
{
    @Autowired
    private IIctProductTypeService ictProductTypeService;

    /**
     * 查询产品类型列表
     */
    @PreAuthorize("@ss.hasPermi('ict:productType:list')")
    @GetMapping("/list")
    public AjaxResult list(IctProductType ictProductType)
    {
        List<IctProductType> list = ictProductTypeService.selectIctProductTypeList(ictProductType);
        return success(list);
    }

    /**
     * 导出产品类型列表
     */
    @PreAuthorize("@ss.hasPermi('ict:productType:export')")
    @Log(title = "产品类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, IctProductType ictProductType)
    {
        List<IctProductType> list = ictProductTypeService.selectIctProductTypeList(ictProductType);
        ExcelUtil<IctProductType> util = new ExcelUtil<IctProductType>(IctProductType.class);
        util.exportExcel(response, list, "产品类型数据");
    }

    /**
     * 获取产品类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('ict:productType:query')")
    @GetMapping(value = "/{typeId}")
    public AjaxResult getInfo(@PathVariable("typeId") Long typeId)
    {
        return success(ictProductTypeService.selectIctProductTypeByTypeId(typeId));
    }

    /**
     * 新增产品类型
     */
    @PreAuthorize("@ss.hasPermi('ict:productType:add')")
    @Log(title = "产品类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody IctProductType ictProductType)
    {
        return toAjax(ictProductTypeService.insertIctProductType(ictProductType));
    }

    /**
     * 修改产品类型
     */
    @PreAuthorize("@ss.hasPermi('ict:productType:edit')")
    @Log(title = "产品类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody IctProductType ictProductType)
    {
        return toAjax(ictProductTypeService.updateIctProductType(ictProductType));
    }

    /**
     * 删除产品类型
     */
    @PreAuthorize("@ss.hasPermi('ict:productType:remove')")
    @Log(title = "产品类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{typeIds}")
    public AjaxResult remove(@PathVariable Long[] typeIds)
    {
        return toAjax(ictProductTypeService.deleteIctProductTypeByTypeIds(typeIds));
    }
}
