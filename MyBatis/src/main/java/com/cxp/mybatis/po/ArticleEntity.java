package com.cxp.mybatis.po;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author CXP
 * @description
 * @date 2024-02-03 20:45
 */
@Data
public class ArticleEntity {
    private Integer id;
    private Integer userId;
    private String title;
    private String summary;
    private Integer readCount;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    //多个评论
    private List<CommentPO> comments;
}
