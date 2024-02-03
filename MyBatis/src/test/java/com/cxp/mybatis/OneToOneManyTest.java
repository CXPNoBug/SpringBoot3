package com.cxp.mybatis;

import com.cxp.mybatis.mapper.ArticleCommentMapper;
import com.cxp.mybatis.mapper.ArticleOneToOneMapper;
import com.cxp.mybatis.po.Article;
import com.cxp.mybatis.po.ArticleEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author CXP
 * @description
 * @date 2024-02-03 20:26
 */
@SpringBootTest
public class OneToOneManyTest {

    @Autowired
    private ArticleOneToOneMapper oneMapper;

    @Autowired
    private ArticleCommentMapper commentMapper;

    @Test
    void testOneToOne() {
        Article article = oneMapper.selectAllArticle(2);
        System.out.println("article = " + article);
    }

    @Test
    void testOneToMany() {
        ArticleEntity articleEntity = commentMapper.selectArticleComment(2);
        System.out.println("articleEntity = " + articleEntity);
    }
}
