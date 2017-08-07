package com.jeeqb.zblog.service;

import com.jeeqb.zblog.vo.Pager;
import com.jeeqb.zblog.vo.Partner;

import java.util.List;

public interface PartnerService {

    List<Partner> findAll();

    void savePartner(Partner partner);

    /**
     * 分页查询好友列表
     * @param pager
     * @param param
     * @return
     */
    List<Partner> loadPartner(Pager pager, String param);

    Partner getPartnerById(Integer id);

    void deletePartner(Integer id);

    void updatePartner(Partner partner);

    void initPage(Pager pager);
}
