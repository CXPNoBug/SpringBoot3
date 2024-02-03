package com.cxp.mybatis.provider;

/**
 * @author CXP
 * @description
 * @date 2024-02-03 15:14
 */
public class SqlProvider {

    //定义静态方法
    public static String selectArticle() {
        return "select * from article where id = #{id}";
    }

    /**
     * 新增sql
     */
    public static String insertSql() {
        return """
                insert into article(user_id, title, summary, read_count, create_time, update_time)
                values (#{userId},#{title},#{summary},#{readCount},#{createTime},#{updateTime})
               """;
    }

    /**
     * 修改sql
     */
    public static String updateSql() {
        return "update article set update_time = #{newTime} where id = #{id}";
    }

    /**
     * 删除sql
     */
    public static String deleteSql() {
        return "delete from article where id = #{id}";
    }
}
