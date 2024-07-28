package com.uni.merchant.domain;

import java.math.BigDecimal;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.uni.common.annotation.Excel;
import com.uni.common.core.domain.BaseEntity;

/**
 * 菜品管理对象 tb_dish
 * 
 * @author zhuzw57
 * @date 2024-07-28
 */
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

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getImage() 
    {
        return image;
    }
    public void setDecription(String decription) 
    {
        this.decription = decription;
    }

    public String getDecription() 
    {
        return decription;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    public List<DishFlavor> getDishFlavorList()
    {
        return dishFlavorList;
    }

    public void setDishFlavorList(List<DishFlavor> dishFlavorList)
    {
        this.dishFlavorList = dishFlavorList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("price", getPrice())
            .append("image", getImage())
            .append("decription", getDecription())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("dishFlavorList", getDishFlavorList())
            .toString();
    }
}
