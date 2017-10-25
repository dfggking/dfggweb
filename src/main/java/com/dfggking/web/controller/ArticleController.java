package com.dfggking.web.controller;

import com.dfggking.entity.Article;
import com.dfggking.web.service.ArticleService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dfggking.common.base.controller.BaseController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author dfggking@hotmail.com
 * @create 2017-10-22
 * @since 1.0
 */
@Controller
@RequestMapping(value = "/article")
public class ArticleController extends BaseController {
    private final static Logger LOGGER = LogManager.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;


    /**
     * 添加文章
     * @param article
     * @return
     */
    @RequestMapping(value = "/add")
    public ModelAndView add(Article article) {
        articleService.save(article);
        return null;
    }


}
