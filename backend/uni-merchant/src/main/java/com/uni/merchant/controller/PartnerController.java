package com.uni.merchant.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.uni.common.utils.SecurityUtils;
import com.uni.merchant.domain.vo.PartnerVO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.uni.common.annotation.Log;
import com.uni.common.core.controller.BaseController;
import com.uni.common.core.domain.AjaxResult;
import com.uni.common.enums.BusinessType;
import com.uni.merchant.domain.Partner;
import com.uni.merchant.service.IPartnerService;
import com.uni.common.utils.poi.ExcelUtil;
import com.uni.common.core.page.TableDataInfo;

/**
 * 合作商管理Controller
 * 
 * @author uni
 * @date 2024-07-31
 */
@RestController
@RequestMapping("/region/partner")
public class PartnerController extends BaseController
{
    @Autowired
    private IPartnerService partnerService;

    /**
     * 查询合作商管理列表(带点位节点)
     */
    @PreAuthorize("@ss.hasPermi('region:partner:list')")
    @GetMapping("/list")
    public TableDataInfo list(Partner partner)
    {
        startPage();
        List<PartnerVO> list = partnerService.selectPartnerVOList(partner);
        return getDataTable(list);
    }

    /**
     * 导出合作商管理列表
     */
    @PreAuthorize("@ss.hasPermi('region:partner:export')")
    @Log(title = "合作商管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Partner partner)
    {
        List<Partner> list = partnerService.selectPartnerList(partner);
        ExcelUtil<Partner> util = new ExcelUtil<Partner>(Partner.class);
        util.exportExcel(response, list, "合作商管理数据");
    }

    /**
     * 获取合作商管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('region:partner:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(partnerService.selectPartnerById(id));
    }

    /**
     * 新增合作商管理
     */
    @PreAuthorize("@ss.hasPermi('region:partner:add')")
    @Log(title = "合作商管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Partner partner)
    {
        // 对用户密码加密存储.
        partner.setPassword(SecurityUtils.encryptPassword(partner.getPassword()));
        return toAjax(partnerService.insertPartner(partner));
    }

    /**
     * 修改合作商管理
     */
    @PreAuthorize("@ss.hasPermi('region:partner:edit')")
    @Log(title = "合作商管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Partner partner)
    {
        return toAjax(partnerService.updatePartner(partner));
    }

    /**
     * 删除合作商管理
     */
    @PreAuthorize("@ss.hasPermi('region:partner:remove')")
    @Log(title = "合作商管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(partnerService.deletePartnerByIds(ids));
    }


    /**
     *  重置合作商密码
     *  注意每个请求都有权限控制和日志信息
     */
    @PreAuthorize("@ss.hasPermi('region:partner:edit')")
    @Log(title = "合作商管理", businessType = BusinessType.UPDATE)
    @PutMapping("resetPwd/{id}")
    public AjaxResult edit(@PathVariable("id") Long id)
    {
        final String  INIT_PASSWORD = "123456";
    // 接收请求参数.
        Partner partner = new Partner();
        partner.setId(id);
        partner.setPassword(SecurityUtils.encryptPassword(INIT_PASSWORD));
        return toAjax(partnerService.updatePartner(partner));
    }
}
