/*package com.hfut.glxy.dao;

import com.hfut.glxy.dao.dynamicSQLProvider.DynamicSQLProvider;
import com.hfut.glxy.entity.KnowledgePoint;
import com.hfut.glxy.entity.Unit;
import org.apache.ibatis.annotations.*;

import java.util.List;
*/
/**
 * @Author: Jessiecaicai
 * @Description: 章SQL语句封装
 * @Date: Created in 20:36 2017/11/26
 * @Modified By:
 */
/*@Mapper
public interface UnitDao {*/
    /**
     * @Author: Jessiecaicai
     * @Description: 增加章
     * @Date: 19:49 2017/11/28
     * @param:  * @param null
     *//*
    @Insert("insert into unit values (#{unit.id},#{unit.number},#{unit.name},#{unit.content},NOW(),NOW(),#{unit.isDelete})")
    Integer addUnit(@Param("unit") Unit unit);
*/
    /**
     * @Author: Jessiecaicai
     * @Description: 更新章
     * @Date: 19:56 2017/11/28
     * @param:  * @param null
     *//*
    @UpdateProvider(type = DynamicSQLProvider.class,method="updateUnit")
    Integer updateUnit(Unit unit);
*/
    /**
     * @Author: Jessiecaicai
     * @Description: 通过id删除章
     * @Date: 19:58 2017/11/28
     * @param:  * @param null
     *//*
    @Delete("delete from unit where id=#{id}")
    Integer deleteUnitById(@Param("id") String id);
*/
    /**
     * @Author: Jessiecaicai
     * @Description: 根据id查找知识点（写了没用啊）
     * @Date: 20:00 2017/11/28
     * @param:  * @param null
     *//*
    @Select("select * from unit where id=#{id}")
    Unit queryUnitById(@Param("id") String id);
*/
    /**
     * @Author: Jessiecaicai
     * @Description: 章分页方法
     * @Date: 20:06 2017/11/28
     * @param:  * @param null
     *//*
    @Select("select * from unit order by createtime desc limit #{startPage},#{pageSize}")
    List<Unit> queryUnitByPage(@Param("startPage") Integer startPage,@Param("pageSize") Integer pageSize);
*/
    /**
     * @Author: Jessiecaicai
     * @Description: 统计章数量
     * @Date: 20:09 2017/11/28
     * @param:  * @param null
     *//*
    @Select("select count(*) from unit")
    Integer getUnitTotalCount();


}*/
