package com.jeeqb.zblog.service.impl;

import com.jeeqb.zblog.mapper.ArticleMapper;
import com.jeeqb.zblog.mapper.PagerMapper;
import com.jeeqb.zblog.service.PagerService;
import com.jeeqb.zblog.vo.Pager;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PagerServiceImpl implements PagerService {

    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private PagerMapper pagerMapper;
    @Override
    public void initPage(Pager pager) {
        int count = articleMapper.getArticleCount();
        pager.setTotalCount(count);
    }

    @Override
    public void loadCategoryPager(Pager pager,Integer categoryId) {
        int count = pagerMapper.loadCategoryPager(categoryId);
        pager.setTotalCount(count);
    }

    @Override
    public void loadTagPager(Pager pager, Integer tagId) {
        int count = pagerMapper.loadTagPager(tagId);
        pager.setTotalCount(count);
    }
}
