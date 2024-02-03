package com.cxp.trans.service.impl;

import com.cxp.trans.mapper.ArticleMapper;
import com.cxp.trans.po.ArticleDetailPO;
import com.cxp.trans.po.ArticlePO;
import com.cxp.trans.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CXP
 * @description
 * @date 2024-02-03 21:49
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    //注入mapper
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public boolean postNewArticle(ArticlePO article, String content) {
        //添加新的文章
        int rows = articleMapper.insertArticle(article);

        //添加文章内容
        ArticleDetailPO detail = new ArticleDetailPO();
        detail.setArticleId(article.getId());
        detail.setContent(content);
        int detailRows = articleMapper.insertDetail(detail);
        return (rows + detailRows) >= 2;
    }
}
