package com.dfggweb.web.controller;

import com.dfggweb.entity.Article;
import com.dfggweb.web.service.ArticleService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dfggweb.common.base.BaseController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "query")
    @ResponseBody
    public List<Map<String, Object>> query(HttpServletRequest request, HttpServletResponse response) {
        List<Map<String, Object>> articleList = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < 20; i++) {
            Map<String, Object> article = new HashMap<String, Object>();
            article.put("title", "标题" + i);
            article.put("content", "内容" + i);
            articleList.add(article);
        }

        return articleList;
    }

}
