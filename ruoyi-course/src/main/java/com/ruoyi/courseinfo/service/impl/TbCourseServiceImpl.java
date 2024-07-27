package com.ruoyi.courseinfo.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.courseinfo.mapper.TbCourseMapper;
import com.ruoyi.courseinfo.domain.TbCourse;
import com.ruoyi.courseinfo.service.ITbCourseService;

/**
 * 课程Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-27
 */
@Service
public class TbCourseServiceImpl implements ITbCourseService 
{
    @Autowired
    private TbCourseMapper tbCourseMapper;

    /**
     * 查询课程
     * 
     * @param id 课程主键
     * @return 课程
     */
    @Override
    public TbCourse selectTbCourseById(Long id)
    {
        return tbCourseMapper.selectTbCourseById(id);
    }

    /**
     * 查询课程列表
     * 
     * @param tbCourse 课程
     * @return 课程
     */
    @Override
    public List<TbCourse> selectTbCourseList(TbCourse tbCourse)
    {
        return tbCourseMapper.selectTbCourseList(tbCourse);
    }

    /**
     * 新增课程
     * 
     * @param tbCourse 课程
     * @return 结果
     */
    @Override
    public int insertTbCourse(TbCourse tbCourse)
    {
        tbCourse.setCreateTime(DateUtils.getNowDate());
        return tbCourseMapper.insertTbCourse(tbCourse);
    }

    /**
     * 修改课程
     * 
     * @param tbCourse 课程
     * @return 结果
     */
    @Override
    public int updateTbCourse(TbCourse tbCourse)
    {
        tbCourse.setUpdateTime(DateUtils.getNowDate());
        return tbCourseMapper.updateTbCourse(tbCourse);
    }

    /**
     * 批量删除课程
     * 
     * @param ids 需要删除的课程主键
     * @return 结果
     */
    @Override
    public int deleteTbCourseByIds(Long[] ids)
    {
        return tbCourseMapper.deleteTbCourseByIds(ids);
    }

    /**
     * 删除课程信息
     * 
     * @param id 课程主键
     * @return 结果
     */
    @Override
    public int deleteTbCourseById(Long id)
    {
        return tbCourseMapper.deleteTbCourseById(id);
    }
}
