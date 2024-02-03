package com.cxp.mybatis.mapper;

import com.cxp.mybatis.po.Article;
import com.cxp.mybatis.po.ArticleDetail;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

/**
 * @author CXP
 * @description
 * @date 2024-02-03 20:12
 */
public interface ArticleOneToOneMapper {

    //一对一查询


    //查询文章详情
    @Select("""
            select article_detail.id,article_detail.article_id,article_detail.content
            from article_detail where article_id = #{articleId}
            """)
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "article_id", property = "articleId"),
            @Result(column = "content", property = "content")
    })
    ArticleDetail selectDetail(Integer articleId);

    //查询文章属性包含详情(FetchType.LAZY：懒加载)
    @Select("""
            select article.id,article.user_id,article.title,article.summary,article.read_count,article.create_time,article.update_time
            from article where id = #{id}
            """)
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "title", property = "title"),
            @Result(column = "summary", property = "summary"),
            @Result(column = "read_count", property = "readCount"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime"),
            @Result(column = "id", property = "comments",
                    one = @One(select = "com.cxp.mybatis.mapper.ArticleOneToOneMapper.selectDetail",
                            fetchType = FetchType.LAZY)),
    })
    Article selectAllArticle(Integer id);
}
