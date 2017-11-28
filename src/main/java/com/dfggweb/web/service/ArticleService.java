package com.dfggweb.web.service;

import com.dfggweb.common.dao.PageInfo;
import com.dfggweb.entity.Article;

import java.util.List;

/**
 * @author dfggking@hotmail.com
 * @create 2017-10-23
 * @since 1.0
 */
public interface ArticleService {
    /**
     * 添加文章
     * @param article
     */
    void save(Article article);

    /**
     * 删除文章
     * @param article
     */
    void delArticle(Article article);


    /**
     * 查询文章列表
     * @param userId
     * @return List<Article>
     */
    List<Article> findByUserId(int userId, PageInfo pageInfo);

    /**
     * 根据ID查询文章
     * @param id
     * @return Article
     */
    Article findById(int id);



}
