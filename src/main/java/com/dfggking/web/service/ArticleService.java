package com.dfggking.web.service;

import java.util.List;

import com.dfggking.entity.Article;

/**
 * @author dfggking@hotmail.com
 * @create 2017-10-23
 * @since 1.0
 */
public interface ArticleService {
    
    
    List<Article> queryArticleByUserId();
    
}
