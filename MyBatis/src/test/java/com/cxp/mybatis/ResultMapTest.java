package com.cxp.mybatis;

import com.cxp.mybatis.mapper.ArticleDao;
import com.cxp.mybatis.po.ArticlePO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author CXP
 * @description
 * @date 2024-02-03 14:36
 */
@SpringBootTest
public class ResultMapTest {

    @Autowired
    private ArticleDao articleDao;

    @Test
    void test01() {
        ArticlePO articlePO = articleDao.selectById(2);
        System.out.println("articlePO = " + articlePO);
    }

    @Test
    void test02() {
        List<ArticlePO> list = articleDao.selectList(2101);
        list.forEach(po->{
            System.out.println("po = " + po);
        });
    }
}
