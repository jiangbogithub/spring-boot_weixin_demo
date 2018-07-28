package com.jiangbo.weixin_demo.dao;

import com.jiangbo.weixin_demo.entity.TbArea;
import org.apache.ibatis.jdbc.SQL;

public class TbAreaSqlProvider {

    public String insertSelective(TbArea record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("tb_area");
        
        if (record.getAreaId() != null) {
            sql.VALUES("area_id", "#{areaId,jdbcType=INTEGER}");
        }
        
        if (record.getAreaName() != null) {
            sql.VALUES("area_name", "#{areaName,jdbcType=VARCHAR}");
        }
        
        if (record.getPriority() != null) {
            sql.VALUES("priority", "#{priority,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastEditTime() != null) {
            sql.VALUES("last_edit_time", "#{lastEditTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TbArea record) {
        SQL sql = new SQL();
        sql.UPDATE("tb_area");
        
        if (record.getAreaName() != null) {
            sql.SET("area_name = #{areaName,jdbcType=VARCHAR}");
        }
        
        if (record.getPriority() != null) {
            sql.SET("priority = #{priority,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastEditTime() != null) {
            sql.SET("last_edit_time = #{lastEditTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("area_id = #{areaId,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}