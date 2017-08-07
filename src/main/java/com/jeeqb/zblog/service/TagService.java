package com.jeeqb.zblog.service;

import com.jeeqb.zblog.vo.ArticleCustom;
import com.jeeqb.zblog.vo.Pager;
import com.jeeqb.zblog.vo.Tag;

import java.util.List;

public interface TagService {
    /**
     * 获取当前tag下的文章列表
     * @param pager
     * @param tagId
     * @return
     */
    List<ArticleCustom> loadArticleByTag(Pager pager, Integer tagId);

    int getTagCount();

    Tag getTagById(Integer id);

    List<Tag> loadTagList(Pager pager, String tagName);

    void saveTag(Tag tag);

    boolean checkExist(Tag tag);

    void updateTag(Tag tag);

    void initPage(Pager pager);

    List<Tag> getTagList();

    /**
     * 初始化分页
     * @param pager
     * @param tagId
     */
    void ArticleTagPage(Pager pager, int tagId);

    /**
     * 根据id删除标签
     * @param id
     */
    void deleteTagById(int id);
}
