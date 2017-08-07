package com.jeeqb.zblog.service;

import com.jeeqb.zblog.vo.Pager;

public interface PagerService {
    /**
     * 初始化分页信息
     * @return
     * @param pager
     */
    void initPage(Pager pager);

    /**
     * 初始化某个category的分页信息
     * @param pager
     * @param categoryId
     */
    void loadCategoryPager(Pager pager,Integer categoryId);

    /**
     * 初始化某个tag的分页信息
     * @param pager
     * @param tagId
     */
    void loadTagPager(Pager pager, Integer tagId);
}
