package com.cxp.trans;

import com.cxp.trans.po.ArticleDetailPO;
import com.cxp.trans.po.ArticlePO;
import com.cxp.trans.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Random;

@SpringBootTest
class TransApplicationTests {

    @Autowired
    private ArticleService articleService;

    @Test
    void testInsertArticle() {
        ArticlePO articlePO = new ArticlePO();
        articlePO.setUpdateTime(LocalDateTime.now());
        articlePO.setCreateTime(LocalDateTime.now());
        articlePO.setTitle("Spring 事务管理");
        articlePO.setSummary("基于 Spring 的注解管理事务，进行事务控制");
        articlePO.setUserId(new Random().nextInt(500));
        articlePO.setReadCount(new Random().nextInt(10000));

        String content = "基于 Spring 的注解管理事务，进行事务控制. 1.声明式 2.编程式";
        boolean add = articleService.postNewArticle(articlePO, content);
        System.out.println("发布新的文章 = " + add);
    }

    @Test
    void testInsertArticleTrans() {
        ArticlePO articlePO = new ArticlePO();
        articlePO.setUpdateTime(LocalDateTime.now());
        articlePO.setCreateTime(LocalDateTime.now());
        articlePO.setTitle("Spring 事务管理1111");
        articlePO.setSummary("基于 Spring 的注解管理事务，进行事务控制");
        articlePO.setUserId(new Random().nextInt(500));
        articlePO.setReadCount(0);

        String content = "1111基于 Spring 的注解管理事务，进行事务控制. 1.声明式 2.编程式";
        boolean add = articleService.postNewArticle(articlePO, content);
        System.out.println("发布新的文章 = " + add);
    }

}
