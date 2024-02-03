package com.cxp.trans.service;

import com.cxp.trans.po.ArticlePO;

/**
 * @author CXP
 * @description
 * @date 2024-02-03 21:48
 */
public interface ArticleService {

    //发布新的文章
    boolean postNewArticle(ArticlePO article, String content);
}
