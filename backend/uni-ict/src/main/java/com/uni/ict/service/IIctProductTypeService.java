package com.uni.ict.service;

import java.util.List;
import com.uni.ict.domain.IctProductType;

/**
 * 产品类型Service接口
 * 
 * @author uni
 * @date 2024-08-09
 */
public interface IIctProductTypeService 
{
    /**
     * 查询产品类型
     * 
     * @param typeId 产品类型主键
     * @return 产品类型
     */
    public IctProductType selectIctProductTypeByTypeId(Long typeId);

    /**
     * 查询产品类型列表
     * 
     * @param ictProductType 产品类型
     * @return 产品类型集合
     */
    public List<IctProductType> selectIctProductTypeList(IctProductType ictProductType);

    /**
     * 新增产品类型
     * 
     * @param ictProductType 产品类型
     * @return 结果
     */
    public int insertIctProductType(IctProductType ictProductType);

    /**
     * 修改产品类型
     * 
     * @param ictProductType 产品类型
     * @return 结果
     */
    public int updateIctProductType(IctProductType ictProductType);

    /**
     * 批量删除产品类型
     * 
     * @param typeIds 需要删除的产品类型主键集合
     * @return 结果
     */
    public int deleteIctProductTypeByTypeIds(Long[] typeIds);

    /**
     * 删除产品类型信息
     * 
     * @param typeId 产品类型主键
     * @return 结果
     */
    public int deleteIctProductTypeByTypeId(Long typeId);
}
