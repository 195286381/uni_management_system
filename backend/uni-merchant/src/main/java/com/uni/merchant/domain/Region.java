package com.uni.merchant.domain;

import lombok.*;
import com.uni.common.annotation.Excel;
import com.uni.common.core.domain.BaseEntity;
/**
 * 区域管理对象 tb_region
 *
 * @author uni
 * @date 2024-07-31
 */
@Data
public class Region extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 区域ID */
    private Long id;

    /** 区域名称 */
    @Excel(name = "区域名称")
    private String regionName;

}
