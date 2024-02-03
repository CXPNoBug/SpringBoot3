package com.cxp.trans.mapper;

import com.cxp.trans.po.ArticleDetailPO;
import com.cxp.trans.po.ArticlePO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

/**
 * @author CXP
 * @description
 * @date 2024-02-03 21:41
 */
public interface ArticleMapper {

    //添加新的文章属性 Article
    @Insert("""
            insert into article(user_id, title, summary, read_count, create_time, update_time)
            values (#{userId},#{title},#{summary},#{readCount},#{createTime},#{updateTime})
            """)
    //可选的配置，获取自动增长主键值
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    int insertArticle(ArticlePO article);

    //添加新的文章内容 Article_Detail
    @Insert("""
            insert into article_detail(article_id, content)
            values(#{articleId},#{content})
            """)
    int insertDetail(ArticleDetailPO detail);
}
