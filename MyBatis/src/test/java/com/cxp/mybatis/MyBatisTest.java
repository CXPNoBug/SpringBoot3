package com.cxp.mybatis;

import com.cxp.mybatis.mapper.ArticleMapper;
import com.cxp.mybatis.po.ArticlePO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * @author CXP
 * @description
 * @date 2024-02-03 13:04
 */
@SpringBootTest
public class MyBatisTest {

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    void testSelect() {
        ArticlePO articlePO = articleMapper.selectById(1);
        System.out.println("articlePO = " + articlePO);
    }

    @Test
    void testInsert() {
        ArticlePO articlePO = new ArticlePO();
        articlePO.setTitle("TomcatWeb开发");
        articlePO.setSummary("使用Tomcat服务器");
        articlePO.setReadCount(19);
        articlePO.setUserId(new Random().nextInt(500));
        articlePO.setCreateTime(LocalDateTime.now());
        articlePO.setUpdateTime(LocalDateTime.now());

        int rows = articleMapper.insertArticle(articlePO);
        System.out.println("rows = " + rows);
    }

    @Test
    void testUpdate() {
        int rows=articleMapper.updateReadCount(3,999);
        System.out.println("rows = " + rows);
    }

    @Test
    void testDelete() {
        int rows = articleMapper.deleteById(3);
        System.out.println("rows = " + rows);
    }
}
