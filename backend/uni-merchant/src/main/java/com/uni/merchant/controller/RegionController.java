package com.uni.merchant.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.uni.merchant.domain.vo.RegionVO;
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
import com.uni.merchant.domain.Region;
import com.uni.merchant.service.IRegionService;
import com.uni.common.utils.poi.ExcelUtil;
import com.uni.common.core.page.TableDataInfo;

/**
 * 区域管理Controller
 * 
 * @author uni
 * @date 2024-07-31
 */
@RestController
@RequestMapping("/region/region")
public class RegionController extends BaseController
{
    @Autowired
    private IRegionService regionService;

    /**
     * 查询区域管理列表
     */
    @PreAuthorize("@ss.hasPermi('region:region:list')")
    @GetMapping("/list")
    public TableDataInfo list(Region region)
    {
        startPage();
        List<RegionVO> list = regionService.selectRegionVOList(region);
        return getDataTable(list);
    }

    /**
     * 导出区域管理列表
     */
    @PreAuthorize("@ss.hasPermi('region:region:export')")
    @Log(title = "区域管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Region region)
    {
        List<Region> list = regionService.selectRegionList(region);
        ExcelUtil<Region> util = new ExcelUtil<Region>(Region.class);
        util.exportExcel(response, list, "区域管理数据");
    }

    /**
     * 获取区域管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('region:region:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(regionService.selectRegionById(id));
    }

    /**
     * 新增区域管理
     */
    @PreAuthorize("@ss.hasPermi('region:region:add')")
    @Log(title = "区域管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Region region)
    {
        return toAjax(regionService.insertRegion(region));
    }

    /**
     * 修改区域管理
     */
    @PreAuthorize("@ss.hasPermi('region:region:edit')")
    @Log(title = "区域管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Region region)
    {
        return toAjax(regionService.updateRegion(region));
    }

    /**
     * 删除区域管理
     */
    @PreAuthorize("@ss.hasPermi('region:region:remove')")
    @Log(title = "区域管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(regionService.deleteRegionByIds(ids));
    }

}
