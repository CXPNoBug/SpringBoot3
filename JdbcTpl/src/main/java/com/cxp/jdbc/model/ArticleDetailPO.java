package com.cxp.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CXP
 * @description
 * @date 2024-02-03 12:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDetailPO {
    private Integer id;
    private Integer articleId;
    private String content;
}
