package com.uni.merchant.domain.vo;

import com.uni.merchant.domain.Region;
import lombok.Data;

/**
 * @Description: 区域视图
 * @Author: zhuzw
 * @Create: 2020/5/7
 */
@Data
public class RegionVO extends Region {
    private static final long serialVersionUID = 1L;
    //子节点数量
    private Integer nodeCount;
}
