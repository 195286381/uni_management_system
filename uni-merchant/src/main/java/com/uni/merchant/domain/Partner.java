package com.uni.merchant.domain;

import lombok.*;
import com.uni.common.annotation.Excel;
import com.uni.common.core.domain.BaseEntity;
/**
 * 合作商管理对象 tb_partner
 *
 * @author uni
 * @date 2024-07-31
 */
@Data
public class Partner extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 合作商ID */
    private Long id;

    /** 合作商名称 */
    @Excel(name = "合作商名称")
    private String partnerName;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contactPerson;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String contactNumber;

    /** 分成比例 */
    @Excel(name = "分成比例")
    private Long revenueShare;

    /** 账号 */
    @Excel(name = "账号")
    private String account;

    /** 密码 */
    private String password;

}
