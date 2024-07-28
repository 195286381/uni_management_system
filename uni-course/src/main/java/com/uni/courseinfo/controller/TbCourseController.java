package com.uni.courseinfo.controller;

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
import com.uni.courseinfo.domain.TbCourse;
import com.uni.courseinfo.service.ITbCourseService;
import com.uni.common.utils.poi.ExcelUtil;
import com.uni.common.core.page.TableDataInfo;

/**
 * 课程Controller
 * 
 * @author uni
 * @date 2024-07-27
 */
@RestController
@RequestMapping("/courseinfo/courseinfo")
public class TbCourseController extends BaseController
{
    @Autowired
    private ITbCourseService tbCourseService;

    /**
     * 查询课程列表
     */
    @PreAuthorize("@ss.hasPermi('courseinfo:courseinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbCourse tbCourse)
    {
        startPage();
        List<TbCourse> list = tbCourseService.selectTbCourseList(tbCourse);
        return getDataTable(list);
    }

    /**
     * 导出课程列表
     */
    @PreAuthorize("@ss.hasPermi('courseinfo:courseinfo:export')")
    @Log(title = "课程", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbCourse tbCourse)
    {
        List<TbCourse> list = tbCourseService.selectTbCourseList(tbCourse);
        ExcelUtil<TbCourse> util = new ExcelUtil<TbCourse>(TbCourse.class);
        util.exportExcel(response, list, "课程数据");
    }

    /**
     * 获取课程详细信息
     */
    @PreAuthorize("@ss.hasPermi('courseinfo:courseinfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tbCourseService.selectTbCourseById(id));
    }

    /**
     * 新增课程
     */
    @PreAuthorize("@ss.hasPermi('courseinfo:courseinfo:add')")
    @Log(title = "课程", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbCourse tbCourse)
    {
        return toAjax(tbCourseService.insertTbCourse(tbCourse));
    }

    /**
     * 修改课程
     */
    @PreAuthorize("@ss.hasPermi('courseinfo:courseinfo:edit')")
    @Log(title = "课程", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbCourse tbCourse)
    {
        return toAjax(tbCourseService.updateTbCourse(tbCourse));
    }

    /**
     * 删除课程
     */
    @PreAuthorize("@ss.hasPermi('courseinfo:courseinfo:remove')")
    @Log(title = "课程", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tbCourseService.deleteTbCourseByIds(ids));
    }
}