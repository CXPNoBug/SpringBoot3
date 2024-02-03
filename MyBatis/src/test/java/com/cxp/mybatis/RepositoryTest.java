package com.cxp.mybatis;

import com.cxp.mybatis.mapper.ArticleRepository;
import com.cxp.mybatis.po.ArticlePO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * @author CXP
 * @description
 * @date 2024-02-03 15:21
 */
@SpringBootTest
public class RepositoryTest {

    @Autowired
    private ArticleRepository dao;

    @Test
    void test01() {
        ArticlePO articlePO = dao.selectByPrimary(2);
        System.out.println("articlePO = " + articlePO);
    }

    @Test
    void test02() {
        int rows = dao.updateTime(2, LocalDateTime.now());
        System.out.println("rows = " + rows);
    }

    @Test
    void test03() {
        ArticlePO articlePO = new ArticlePO();
        articlePO.setTitle("TomcatWeb开发");
        articlePO.setSummary("使用Tomcat服务器");
        articlePO.setReadCount(19);
        articlePO.setUserId(new Random().nextInt(500));
        articlePO.setCreateTime(LocalDateTime.now());
        articlePO.setUpdateTime(LocalDateTime.now());
        int rows = dao.insertArticle(articlePO);
        System.out.println("rows = " + rows);
    }

    @Test
    void test04() {
        int rows = dao.deleteArticle(4);
        System.out.println("rows = " + rows);
    }
}
