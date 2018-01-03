/*package com.hfut.glxy.dao;

import com.hfut.glxy.dao.dynamicSQLProvider.DynamicSQLProvider;
import com.hfut.glxy.entity.KnowledgePoint;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
*//**
 * @Author: Jessiecaicai
 * @Description: 知识点SQL语句封装
 * @Date: Created in 20:27 2017/11/26
 * @Modified By:
 */
/*
@Mapper
public interface KnowledgePointDao {
*/
    /**
     * @Author: Jessiecaicai
     * @Description: 增加知识点
     * @Date: 21:07 2017/11/26
     * @param:  knowledgePoint
     */
    /*@Insert("insert into knowledgepoint(id,content,createtime,updatetime,isDelete) values (#{knowledgePoint.id},#{knowledgePoint.content},NOW(), NOW(),#{knowledgePoint.isDelete})")
    Integer addKnowledgePoint(@Param("knowledgePoint") KnowledgePoint knowledgePoint);
    */
    /**
     * @Author: Jessiecaicai
     * @Description: 更新知识点
     * @Date: 21:42 2017/11/26
     * @param:  * @param null
     *//*
    @UpdateProvider(type=DynamicSQLProvider.class,method="updateKnowledgePoint")
    Integer updateKnowledgePoint(KnowledgePoint knowledgePoint);*/

    /**
     * @Author: Jessiecaicai
     * @Description: 通过id删除知识点
     * @Date: 21:47 2017/11/26
     * @param:  * @param null
     *//*
    @Delete("delete from knowledgepoint where id=#{id}")
    Integer deleteKnowledgePointById(@Param("id") String id);
    */
    /**
     * @Author: Jessiecaicai
     * @Description: 根据id查找知识点
     * @Date: 21:50 2017/11/26
     * @param:  * @param null
     *//*
    @Select("select * from knowledgepoint where id=#{id}")
    KnowledgePoint queryKnowledgePointById(@Param("id") String id);
    */
    /**
     * @Author: Jessiecaicai
     * @Description: 知识点分页（感觉不太需要）
     * @Date: 21:52 2017/11/26
     * @param:  * @param null
     *//*
    @Select("select * from knowledgepoint order by createtime desc limit #{startPage},#{pageSize}")
    List<KnowledgePoint> queryKnowledgePointByPage(@Param("startPage") Integer startPage,@Param("pageSize") Integer pageSize);
    */
    /**
     * @Author: Jessiecaicai
     * @Description: 统计知识点总数
     * @Date: 19:19 2017/11/27
     * @param:  * @param null
     *//*
    @Select("select count(*) from knowledgepoint")
    Integer getKnowledgePointTotalCount();

}*/




















