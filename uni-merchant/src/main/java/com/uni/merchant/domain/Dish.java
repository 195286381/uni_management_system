package com.uni.merchant.domain;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;
import com.uni.common.annotation.Excel;
import com.uni.common.core.domain.BaseEntity;
/**
 * 菜品管理对象 tb_dish
 *
 * @author zhuzw57
 * @date 2024-07-28
 */
@Data
public class Dish extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 菜品id */
    private Long id;

    /** 菜品名称 */
    @Excel(name = "菜品名称")
    private String name;

    /** 菜品单价 */
    @Excel(name = "菜品单价")
    private BigDecimal price;

    /** 图片 */
    @Excel(name = "图片")
    private String image;

    /** 描述 */
    private String decription;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 菜品口味信息 */
    private List<DishFlavor> dishFlavorList;

}
