package com.uni.merchant.mapper;

import java.util.List;
import com.uni.merchant.domain.Region;
import com.uni.merchant.domain.vo.RegionVO;

/**
 * 区域管理Mapper接口
 * 
 * @author uni
 * @date 2024-07-31
 */
public interface RegionMapper 
{
    /**
     * 查询区域管理
     * 
     * @param id 区域管理主键
     * @return 区域管理
     */
    public Region selectRegionById(Long id);

    /**
     * 查询区域管理列表
     * 
     * @param region 区域管理
     * @return 区域管理集合
     */
    public List<Region> selectRegionList(Region region);

    /**
     * 新增区域管理
     * 
     * @param region 区域管理
     * @return 结果
     */
    public int insertRegion(Region region);

    /**
     * 修改区域管理
     * 
     * @param region 区域管理
     * @return 结果
     */
    public int updateRegion(Region region);

    /**
     * 删除区域管理
     * 
     * @param id 区域管理主键
     * @return 结果
     */
    public int deleteRegionById(Long id);

    /**
     * 批量删除区域管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRegionByIds(Long[] ids);


    /**
     * 查询区域管理列表
     * @param region
     * @return
     */
    public List<RegionVO> selectRegionVOList(Region region);
}
