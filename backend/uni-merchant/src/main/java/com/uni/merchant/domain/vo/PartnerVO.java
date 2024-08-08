package com.uni.merchant.domain.vo;


import com.uni.merchant.domain.Partner;
import lombok.Data;


// 合作伙伴视图表.
@Data
public class PartnerVO extends Partner {
    // 点位数量
    private Integer nodeCount;
}
