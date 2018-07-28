package com.jiangbo.weixin_demo.dao;

import com.jiangbo.weixin_demo.entity.TbArea;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface TbAreaMapper {
    @Delete({
        "delete from tb_area",
        "where area_id = #{areaId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer areaId);

    @Insert({
        "insert into tb_area (area_id, area_name, ",
        "priority, create_time, ",
        "last_edit_time)",
        "values (#{areaId,jdbcType=INTEGER}, #{areaName,jdbcType=VARCHAR}, ",
        "#{priority,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{lastEditTime,jdbcType=TIMESTAMP})"
    })
    int insert(TbArea record);

    @InsertProvider(type=TbAreaSqlProvider.class, method="insertSelective")
    int insertSelective(TbArea record);

    @Select({
        "select",
        "area_id, area_name, priority, create_time, last_edit_time",
        "from tb_area",
        "where area_id = #{areaId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="area_name", property="areaName", jdbcType=JdbcType.VARCHAR),
        @Result(column="priority", property="priority", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_edit_time", property="lastEditTime", jdbcType=JdbcType.TIMESTAMP)
    })
    TbArea selectByPrimaryKey(Integer areaId);

    @UpdateProvider(type=TbAreaSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TbArea record);

    @Update({
        "update tb_area",
        "set area_name = #{areaName,jdbcType=VARCHAR},",
          "priority = #{priority,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "last_edit_time = #{lastEditTime,jdbcType=TIMESTAMP}",
        "where area_id = #{areaId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TbArea record);

    @Select({
            "select",
            "area_id, area_name, priority, create_time, last_edit_time",
            "from tb_area",
    })
    @Results({
            @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="area_name", property="areaName", jdbcType=JdbcType.VARCHAR),
            @Result(column="priority", property="priority", jdbcType=JdbcType.INTEGER),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="last_edit_time", property="lastEditTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TbArea> selectAll();
}