package com.ruoyi.merchant.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 菜品口味对象 tb_dish_flavor
 * 
 * @author zhuzw57
 * @date 2024-07-28
 */
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

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDishId(Long dishId) 
    {
        this.dishId = dishId;
    }

    public Long getDishId() 
    {
        return dishId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setValue(String value) 
    {
        this.value = value;
    }

    public String getValue() 
    {
        return value;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("dishId", getDishId())
            .append("name", getName())
            .append("value", getValue())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
