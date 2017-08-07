package com.jeeqb.zblog.controller;

import com.jeeqb.zblog.service.CategoryService;
import com.jeeqb.zblog.service.PartnerService;
import com.jeeqb.zblog.vo.ArticleCustom;
import com.jeeqb.zblog.vo.Pager;
import com.jeeqb.zblog.vo.Partner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import java.util.List;

/**
 * 展示的分类controller
 * FILE: com.jeeqb.zblog.controller.ArchiveController.java
 */
@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Resource
    CategoryService categoryService;
    @Resource
    PartnerService  partnerService;

    /**
     * 获取某个标签的分页文章
     * @param model
     * @param pager
     * @param categoryId
     * @return
     */
    @RequestMapping("/load/{categoryId}")
    public String loadArticleByCategory(Model model, Pager pager, @PathVariable Integer categoryId){
        List<ArticleCustom> articleList = categoryService.loadArticleByCategory(pager,categoryId);
        if (!articleList.isEmpty()){
            model.addAttribute("articleList",articleList);
            model.addAttribute("pager",pager);
            model.addAttribute("categoryName",articleList.get(0).getCategoryName());
        }
        return "blog/part/categorySummary";
    }

    /**
     * 跳转到分类的页面 暂时停用
     * @param model
     * @param categoryId
     * @return
     */
    @Deprecated
    @RequestMapping("/details/{categoryId}")
    public String categoryPage(Model model,@PathVariable Integer categoryId){
        List<Partner> partnerList = partnerService.findAll();
        model.addAttribute("partnerList",partnerList);
        model.addAttribute("categoryId",categoryId);
        return "category";
    }



}
