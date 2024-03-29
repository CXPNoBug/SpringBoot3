package com.cxp.mybatis.mapper;

import com.cxp.mybatis.po.ArticlePO;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author CXP
 * @description
 * @date 2024-02-03 14:30
 */
public interface ArticleDao {

    //1.查询某个用户的所有文章
    @Select("""
                select  article.id,article.user_id,article.title,article.summary,article.read_count,article.create_time,article.update_time
                from article where user_id = #{userId}
            """)
    @Results(id = "BaseArticleMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "title", property = "title"),
            @Result(column = "summary", property = "summary"),
            @Result(column = "read_count", property = "readCount"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ArticlePO> selectList(Integer userId);

    //2.查询某个文章，使用id
    @Select("""
              select  article.id,article.user_id,article.title,article.summary,article.read_count,article.create_time,article.update_time
              from article where id = #{id}
            """)
    //引用定义好的结果映射 value的值是@Results中的id（只能在同一个类里使用）
    //@ResultMap("BaseArticleMap")

    //使用xml中的<resultMap>的id
    @ResultMap("ArticleBaseMapper")
    ArticlePO selectById(Integer id);
}
