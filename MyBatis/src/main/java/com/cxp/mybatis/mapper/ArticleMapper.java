package com.cxp.mybatis.mapper;

import com.cxp.mybatis.po.ArticlePO;
import org.apache.ibatis.annotations.*;

/**
 * @author CXP
 * @description
 * @date 2024-02-03 12:54
 */
public interface ArticleMapper {

    //按主键查询
    @Select("""
            select article.id,article.user_id,article.title,article.summary,article.read_count,article.create_time,article.update_time
            from article where id = #{articleId}
            """)
    //查询结果ResultSet 和 PO对象的属性映射
    @Results(id = "BaseArticleMap", value = {@Result(id = true, column = "id", property = "id"), @Result(column = "user_id", property = "userId"), @Result(column = "title", property = "title"), @Result(column = "summary", property = "summary"), @Result(column = "read_count", property = "readCount"), @Result(column = "create_time", property = "createTime"), @Result(column = "update_time", property = "updateTime")})
    ArticlePO selectById(@Param("articleId") Integer id);

    //增加
    @Insert("""
            insert into article(user_id, title, summary, read_count, create_time, update_time)
            values (#{userId},#{title},#{summary},#{readCount},#{createTime},#{updateTime})
            """)
    int insertArticle(ArticlePO po);

    //修改
    @Update("""
                update article set read_count = #{readCount} where id = #{id}
            """)
    int updateReadCount(Integer id, Integer readCount);

    @Delete("""
                delete from article where id = #{id}
            """)
    int deleteById(Integer id);
}
