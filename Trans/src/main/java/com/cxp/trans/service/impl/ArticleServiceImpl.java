package com.cxp.trans.service.impl;

import com.cxp.trans.mapper.ArticleMapper;
import com.cxp.trans.po.ArticleDetailPO;
import com.cxp.trans.po.ArticlePO;
import com.cxp.trans.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

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

    /**
     * Transactional：事务控制注解 位置：1.方法的上面 2.类的上面
     * <p>
     * 事务回滚：
     * 1.默认对运行时异常，执行回滚 rollback
     * 2.rollbackFor：需要回滚异常类列表
     */
//    @Transactional(rollbackFor = {IOException.class})
    @Transactional
    @Override
    public boolean postNewArticle(ArticlePO article, String content) {
        //添加新的文章
        int rows = articleMapper.insertArticle(article);

        //抛出异常
        if (article.getReadCount() < 1) {
            throw new RuntimeException("文章阅读数最小是1");
        }

        //添加文章内容
        ArticleDetailPO detail = new ArticleDetailPO();
        detail.setArticleId(article.getId());
        detail.setContent(content);
        int detailRows = articleMapper.insertDetail(detail);
        return (rows + detailRows) >= 2;
    }

    @Override
    public boolean managerArticle(ArticlePO po, String content) {
        //调用具有事务的方法
        return  postNewArticle(po,content);
    }
}
