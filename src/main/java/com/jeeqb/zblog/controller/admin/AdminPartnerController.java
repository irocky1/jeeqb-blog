package com.jeeqb.zblog.controller.admin;

import com.jeeqb.zblog.service.PartnerService;
import com.jeeqb.zblog.util.ResultInfo;
import com.jeeqb.zblog.util.ResultInfoFactory;
import com.jeeqb.zblog.vo.Pager;
import com.jeeqb.zblog.vo.Partner;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.net.URLDecoder;

/**
 *
 * 后台管理员的友链操作contributor
 * FILE: com.jeeqb.zblog.controller.admin.PartnerController.java
 */
@RestController
@RequestMapping("/admin/partner")
public class AdminPartnerController {
    @Resource
    private PartnerService partnerService;

    @RequestMapping("/initPage")
    public Pager initPage(Pager pager){
        partnerService.initPage(pager);
        return pager;
    }

    /**
     * 保存友链
     * @param partner
     * @return
     */
    @RequestMapping("/save")
    public ResultInfo savePartner(Partner partner){
        try {
            partner.setSiteName(URLDecoder.decode(partner.getSiteName(), "utf-8"));
            partner.setSiteDesc(URLDecoder.decode(partner.getSiteDesc(), "utf-8"));
            partner.setSiteUrl(URLDecoder.decode(partner.getSiteUrl(), "utf-8"));
            partnerService.savePartner(partner);
        }catch (Exception e){

            return ResultInfoFactory.getErrorResultInfo();
        }
       return ResultInfoFactory.getSuccessResultInfo();

    }

    /**
     * 更新友链
     * @param partner
     * @return
     */
    @RequestMapping("/update")
    public ResultInfo updatePartner(Partner partner) {
        try {
            partner.setSiteName(URLDecoder.decode(partner.getSiteName(), "utf-8"));
            partner.setSiteDesc(URLDecoder.decode(partner.getSiteDesc(), "utf-8"));
            partner.setSiteUrl(URLDecoder.decode(partner.getSiteUrl(), "utf-8"));
            if (partner.getSort()==null){
                partner.setSort(0);
            }
            partnerService.updatePartner(partner);
        } catch (Exception e) {
            return ResultInfoFactory.getErrorResultInfo();
        }
       return ResultInfoFactory.getSuccessResultInfo();

    }

    /**
     * 删除友链
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    public ResultInfo deletePartner(@PathVariable Integer id){
        try {
            partnerService.deletePartner(id);
        }catch (Exception e){
            return ResultInfoFactory.getErrorResultInfo();
        }
        return ResultInfoFactory.getSuccessResultInfo();
    }
}
