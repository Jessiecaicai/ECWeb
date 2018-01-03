/*package com.hfut.glxy.dao;

import com.hfut.glxy.entity.KnowledgePoint;
import com.hfut.glxy.entity.Unit;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
*/
/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date: Created in 20:25 2017/11/26
 * @Modified By:
 *//*
@Mapper
@Component(value = "unit_knowledgepoint")
public interface Unit_KnowledgePointDao {
*/
    /**
     * @Author: Jessiecaicai
     * @Description: 将知识点添加进章节
     * @Date: 20:44 2017/11/28
     * @param:  * @param null
     *//*
    @Insert("insert into unit_knowledgepoint values(#{unit_id},#{knowledgepoint_id},NOW(),NOW(),0)")
    Integer addRelation(@Param("unit")Unit unit, @Param("knowledgePoint")KnowledgePoint knowledgePoint);
*/
    /**
     * @Author: Jessiecaicai
     * @Description: 将课程彻底删除
     * @Date: 20:50 2017/11/28
     * @param:  * @param null
     */
/*
    @Delete("delete from unit_knowledgepoint where unit_id=#{unit_id} and knowledgepoint_id=#{knowledgepoint_id}")
    Integer deleteRelation(@Param("unit_id") String unit_id,@Param("knowledgepoint_id")String knowledgepoint_id);
*/
    /**
     * @Author: Jessiecaicai
     * @Description: 将知识点从章节删除
     * @Date: 20:54 2017/11/28
     * @param:  * @param null
     *//*
    @Update("update unit_knowledgepoint set isDelete=1 where unit_id=#{unit_id},knowledgepoint_id=#{knowledgepoint_id}")
    Integer putToDustbin(@Param("unit_id")String unit_id,@Param("knowledgepoint_id")String knowledgepoint_id);
*/
    /**
     * @Author: Jessiecaicai
     * @Description: 根据章节id查找知识点，并且isDelete为0(嵌套查询)
     * @Date: 21:04 2017/11/28
     * @param:  * @param null
     *//*
    @Select("select * from knowledgepoint where id = (select knowledgepoint_id from unit_knowledgepoint where unit_id = #{unit_id} and isDelete=0)")
    KnowledgePoint queryKnowledgePointByUnitId(@Param("unit_id")String id);
*/
    /**
     * @Author: Jessiecaicai
     * @Description: 根据知识点id查找章节，并且idDelete为0（嵌套查询）
     * @Date: 20:04 2017/11/29
     * @param:  * @param null
     *//*
    @Select("select * from unit where id=(select unit_id from unitknowledgepoint where knowledgepoint_id=#{knowledgepoint_id} and idDelete=0)")
    Unit queryUnitByKnowledgePointId(@Param("knowledgepoint_id") String id);

}*/
