package com.cxp.mybatis.po;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author CXP
 * @description
 * @date 2024-02-03 12:52
 */
@Data
public class ArticlePO {
    private Integer id;
    private Integer userId;
    private String title;
    private String summary;
    private Integer readCount;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
