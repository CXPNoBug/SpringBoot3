package com.cxp.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author CXP
 * @description
 * @date 2024-02-03 12:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleMainPO {
    private Integer id;
    private Integer userId;
    private String title;
    private String summary;
    private Integer readCount;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private ArticleDetailPO detail;
}
