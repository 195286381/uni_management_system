package com.uni.ict.domain;

import lombok.*;
import com.uni.common.annotation.Excel;
import com.uni.common.core.domain.TreeEntity;
/**
 * 产品类型对象 ict_product_type
 *
 * @author uni
 * @date 2024-08-09
 */
@Data
public class IctProductType extends TreeEntity {
    private static final long serialVersionUID = 1L;

    /** 类型ID */
    private Long typeId;

    /** 类型名称 */
    @Excel(name = "类型名称")
    private String typeName;

    /** 类型级别 */
    @Excel(name = "类型级别")
    private Integer level;

}
