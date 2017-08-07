package com.jeeqb.zblog.service;


import java.util.List;

import com.jeeqb.zblog.vo.ArticleCustom;
import com.jeeqb.zblog.vo.Category;
import com.jeeqb.zblog.vo.CategoryCustom;
import com.jeeqb.zblog.vo.Pager;

public interface CategoryService {



    List<ArticleCustom> loadArticleByCategory(Pager pager, Integer categoryId);

    /**
     * 初始化分类信息
     * @return
     */
    List<CategoryCustom> initCategoryList();

    Category getCategoryById(Integer id);

    List<Category> loadCategory(Pager pager, String categoryName);

    boolean checkExist(Category category);

    void saveCategory(Category category);

    void updateCategory(Category category);

    void initPage(Pager pager);

    List<Category> getCategoryList();


    List<ArticleCustom> loadArticleByArchive(String createTime, Pager pager);

    int getArticleCountByCategoryId(Integer categoryId);

    boolean deleteCategoryById(Integer categoryId);
}
