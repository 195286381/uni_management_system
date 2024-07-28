package com.uni.merchant.domain;

import lombok.*;
import com.uni.common.annotation.Excel;
import com.uni.common.core.domain.BaseEntity;

/**
 * 菜品口味对象 tb_dish_flavor
 *
 * @author zhuzw57
 * @date 2024-07-28
 */
@Data
public class DishFlavor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 菜品口味id */
    private Long id;

    /** 菜品id */
    @Excel(name = "菜品id")
    private Long dishId;

    /** 口味名称 */
    @Excel(name = "口味名称")
    private String name;

    /** 口味数据 */
    @Excel(name = "口味数据")
    private String value;

}
