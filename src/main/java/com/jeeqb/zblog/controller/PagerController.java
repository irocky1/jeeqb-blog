package com.jeeqb.zblog.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jeeqb.zblog.service.PagerService;
import com.jeeqb.zblog.service.TagService;
import com.jeeqb.zblog.vo.Pager;

/**
 * 页面管理的controller
 */
@RestController
public class PagerController {

    @Resource
    private PagerService pagerService;  //分页的service
    @Resource
    private TagService tagService;  //标签的service

    /**
     * 初始化文章分页信息
     * @return
     */
    @RequestMapping("/pager/articles/load")
    public Pager loadArticlePager(Pager pager){
        pagerService.initPage(pager);
        return pager;
    }

    /**
     * 初始化当前分类id的文章分页信息
     * @param pager 分页对象
     * @param categoryId 分类id
     * @return
     */
    @RequestMapping("/pager/categories/{categoryId}")
    public Pager loadCategoryPager(Pager pager,@PathVariable Integer categoryId){
        pagerService.loadCategoryPager(pager,categoryId);
        return pager;
    }

    /**
     *初始化当前标签的文章分页信息
     * @param pager 分页对象
     * @param tagId 标签
     * @return
     */
    @RequestMapping("/pager/tags/{tagId}")
    @ResponseBody
    public Pager initPage(Pager pager,@PathVariable Integer tagId){
        tagService.ArticleTagPage(pager,tagId);
        return pager;
    }

}
