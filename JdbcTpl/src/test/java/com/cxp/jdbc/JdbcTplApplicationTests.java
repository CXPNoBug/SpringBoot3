package com.cxp.jdbc;

import com.cxp.jdbc.model.ArticleDetailPO;
import com.cxp.jdbc.model.ArticleMainPO;
import com.cxp.jdbc.model.ArticlePO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class JdbcTplApplicationTests {

    //注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void test01() {
        String sql = "select count(*) as ct from article";
        Long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println("记录行数=" + count);
    }

    //查询结果为单杠记录 使用？作为参数占位符
    @Test
    void test02() {
        String sql = "select * from article where id = ?";
        ArticlePO articleP0 = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(ArticlePO.class), 1);
        System.out.println("articleP0=" + articleP0);
    }

    /**
     * 单条查询
     */
    @Test
    void test03() {
        String sql = "select * from article where id = 1";
        ArticlePO articleP0 = jdbcTemplate.queryForObject(sql, (rs, rownum) -> {
            System.out.println("rs=" + rs);
            //从rs获取列值
            var id = rs.getInt("id");
            var userId = rs.getInt("user_id");
            var title = rs.getString("title");
            var summary = rs.getString("summary");
            var readCount = rs.getInt("read_count");
            var createTime = new Timestamp(rs.getTimestamp("create_time").getTime()).toLocalDateTime();
            var updateTime = new Timestamp(rs.getTimestamp("update_time").getTime()).toLocalDateTime();
            return new ArticlePO(id, userId, title, summary, readCount, createTime, updateTime);
        });
        System.out.println("articleP0 = " + articleP0);
    }

    /**
     * 查询列表
     */
    @Test
    void testList() {
        String sql = "select * from article order by id";
        //一个list成员一行记录，Map是列名和值
        List<Map<String, Object>> listMap = jdbcTemplate.queryForList(sql);
        listMap.forEach(el->{
            el.forEach((filed,value)->{
                System.out.println("字段名称：" + filed+"，列值："+value);
            });
            System.out.println("==============================");
        });
    }

    /**
     * 修改
     */
    @Test
    void testUpdate() {
        String sql = "update article set title = ? where id = ?";
        int rows = jdbcTemplate.update(sql, "Java编程实现", 2);
        System.out.println("rows = " + rows);
    }


    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * 命名参数
     */
    @Test
    void testNameParameter() {
        String sql = "select count(*) as ct from article where user_id = :uid and read_count > :num";
        //给参数赋值
        Map<String,Object> map =new HashMap<>();
        map.put("uid",2101);
        map.put("num",111111);
        Long readCounts = namedParameterJdbcTemplate.queryForObject(sql, map, Long.class);
        System.out.println("readCounts = " + readCounts);
    }

    @Test
    void testQueryContent() {
        String sql = """
                select m.*, d.id as detail_id ,d.article_id,d.content
                from article m join article_detail d
                on m.id = d.article_id
                where m.id = :id
                """;
        Map<String,Object> param=new HashMap<>();
        param.put("id",1);
        List<ArticleMainPO> list = namedParameterJdbcTemplate.query(sql, param, (rs, num) -> {
            var id = rs.getInt("id");
            var userId = rs.getInt("user_id");
            var title = rs.getString("title");
            var summary = rs.getString("summary");
            var readCount = rs.getInt("read_count");
            var createTime = new Timestamp(rs.getTimestamp("create_time").getTime()).toLocalDateTime();
            var updateTime = new Timestamp(rs.getTimestamp("update_time").getTime()).toLocalDateTime();

            //文章内容
            var detailId = rs.getInt("detail_id");
            var articleId = rs.getInt("article_id");
            var content = rs.getString("content");
            ArticleDetailPO detailPO = new ArticleDetailPO(detailId, articleId, content);
            return new ArticleMainPO(id, userId, title, summary, readCount, createTime, updateTime, detailPO);
        });

        list.forEach(m->{
            System.out.println("m.getId() = " + m.getId());
            System.out.println("m.getDetail() = " + m.getDetail());
        });
    }
}
