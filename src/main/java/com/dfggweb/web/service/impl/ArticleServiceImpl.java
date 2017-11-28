package com.dfggweb.web.service.impl;

import java.util.List;

import com.dfggweb.common.base.BaseService;
import com.dfggweb.common.dao.PageInfo;
import com.dfggweb.entity.Article;
import com.dfggweb.web.service.ArticleService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * @author dfggking@hotmail.com
 * @create 2017-10-23
 * @since 1.0
 */
@Service
public class ArticleServiceImpl extends BaseService implements ArticleService {
    private final static Logger LOGGER = LogManager.getLogger(ArticleServiceImpl.class);

    /**
     * 添加文章
     *
     * @param article
     * @return
     */
    @Override
    public void save(Article article) {
        hibernateTemplate.save(article);
    }

    /**
     * 删除文章
     *
     * @param article
     */
    @Override
    public void delArticle(Article article) {
        hibernateTemplate.delete(article);
    }


    /**
     * 查询文章列表
     *
     * @param userId
     * @return List<Article>
     */
    @Override
    public List<Article> findByUserId(int userId, PageInfo pageInfo) {



        return null;
    }

    /**
     * 根据ID查询文章
     *
     * @param id
     * @return Article
     */
    @Override
    public Article findById(int id) {
        hibernateTemplate.get(Article.class, id);
        return null;
    }
}
