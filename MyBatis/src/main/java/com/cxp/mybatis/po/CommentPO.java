package com.cxp.mybatis.po;

import lombok.Data;

/**
 * @author CXP
 * @description
 * @date 2024-02-03 20:44
 */
@Data
public class CommentPO {
    private Integer id;
    private Integer articleId;
    private String content;
}
