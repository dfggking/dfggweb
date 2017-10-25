package com.dfggking.web.service.impl;

import java.util.List;

import com.dfggking.common.base.service.BaseService;
import com.dfggking.common.dao.PageInfo;
import com.dfggking.entity.Article;
import com.dfggking.web.service.ArticleService;
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
    public Boolean save(Article article) {
        hibernateTemplate.save(article);
        return true;
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
