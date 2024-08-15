package com.uni.ict.service.impl;

import java.util.List;
import com.uni.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uni.ict.mapper.IctProductTypeMapper;
import com.uni.ict.domain.IctProductType;
import com.uni.ict.service.IIctProductTypeService;

/**
 * 产品类型Service业务层处理
 * 
 * @author uni
 * @date 2024-08-09
 */
@Service
public class IctProductTypeServiceImpl implements IIctProductTypeService 
{
    @Autowired
    private IctProductTypeMapper ictProductTypeMapper;

    /**
     * 查询产品类型
     * 
     * @param typeId 产品类型主键
     * @return 产品类型
     */
    @Override
    public IctProductType selectIctProductTypeByTypeId(Long typeId)
    {
        return ictProductTypeMapper.selectIctProductTypeByTypeId(typeId);
    }

    /**
     * 查询产品类型列表
     * 
     * @param ictProductType 产品类型
     * @return 产品类型
     */
    @Override
    public List<IctProductType> selectIctProductTypeList(IctProductType ictProductType)
    {
        return ictProductTypeMapper.selectIctProductTypeList(ictProductType);
    }

    /**
     * 新增产品类型
     * 
     * @param ictProductType 产品类型
     * @return 结果
     */
    @Override
    public int insertIctProductType(IctProductType ictProductType)
    {
        ictProductType.setCreateTime(DateUtils.getNowDate());
        return ictProductTypeMapper.insertIctProductType(ictProductType);
    }

    /**
     * 修改产品类型
     * 
     * @param ictProductType 产品类型
     * @return 结果
     */
    @Override
    public int updateIctProductType(IctProductType ictProductType)
    {
        ictProductType.setUpdateTime(DateUtils.getNowDate());
        return ictProductTypeMapper.updateIctProductType(ictProductType);
    }

    /**
     * 批量删除产品类型
     * 
     * @param typeIds 需要删除的产品类型主键
     * @return 结果
     */
    @Override
    public int deleteIctProductTypeByTypeIds(Long[] typeIds)
    {
        return ictProductTypeMapper.deleteIctProductTypeByTypeIds(typeIds);
    }

    /**
     * 删除产品类型信息
     * 
     * @param typeId 产品类型主键
     * @return 结果
     */
    @Override
    public int deleteIctProductTypeByTypeId(Long typeId)
    {
        return ictProductTypeMapper.deleteIctProductTypeByTypeId(typeId);
    }
}
