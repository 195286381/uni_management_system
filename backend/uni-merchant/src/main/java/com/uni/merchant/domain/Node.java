package com.uni.merchant.domain;

import lombok.*;
import com.uni.common.annotation.Excel;
import com.uni.common.core.domain.BaseEntity;
/**
 * 点位管理对象 tb_node
 *
 * @author uni
 * @date 2024-07-31
 */
@Data
public class Node extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 点位ID */
    private Long id;

    /** 点位名称 */
    @Excel(name = "点位名称")
    private String nodeName;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    /** 商圈类型 */
    @Excel(name = "商圈类型")
    private Long businessAreaType;

    /** 所属区域 */
    @Excel(name = "所属区域")
    private Long regionId;

    /** 所属合作商 */
    @Excel(name = "所属合作商")
    private Long partnerId;

}
