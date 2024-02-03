package com.cxp.mybatis.mapper;

import com.cxp.mybatis.po.ArticleEntity;
import com.cxp.mybatis.po.CommentPO;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author CXP
 * @description
 * @date 2024-02-03 21:10
 */
public interface ArticleCommentMapper {

    //查询评论
    @Select("""
            select comment.id,comment.article_id,comment.content
            from comment where article_id = #{articleId} order by id
            """)
    @Results(id = "CommentMapper", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "article_id", property = "articleId"),
            @Result(column = "content", property = "content")
    })
    List<CommentPO> selectComments(Integer articleId);

    @Select("""
                select  article.id,article.user_id,article.title,article.summary,article.read_count,article.create_time,article.update_time
                from article where id = #{articleId}
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
                    many = @Many(select = "com.cxp.mybatis.mapper.ArticleCommentMapper.selectComments", fetchType = FetchType.LAZY))

    })
    ArticleEntity selectArticleComment(Integer id);
}
