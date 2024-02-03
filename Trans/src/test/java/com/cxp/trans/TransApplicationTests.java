package com.cxp.trans;

import com.cxp.trans.po.ArticleDetailPO;
import com.cxp.trans.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TransApplicationTests {

    @Autowired
    private ArticleService articleService;
    @Test
    void testInsertArticle() {
    }

}
