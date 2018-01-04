package com.hfut.glxy.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hfut.glxy.entity.KnowledgePoint;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: Jessiecaicai
 * @Description: 知识点的mapper映射
 * @Date: Created in 15:14 2017/12/5
 * @Modified By:
 */
@Component
public interface KnowledgePointMapper extends BaseMapper<KnowledgePoint>{

    /**
     * @Author: Jessiecaicai
     * @Description: 增加知识点和教学单元的关系
     * @Date: 20:52 2018/1/3
     * @param:  * @param null
     */
    @Insert("insert into unit_knowledge_point values(#{unit_id},#{knowledge_point_id},NOW(),NOW(),0)")
    Integer addunitKnowledgePointRelation(@Param("unit_id") String unit_id,@Param("knowledge_point_id") String knowledge_point_id);

    //@Select("select id,content from knowledge_point,chapter,uni ")
    //@Select("select * from knowledge_point,unit_knowledge_point,chapter_unit where chapter_unit.unit_id=unit_knowledge_point.unit_id and knowledge_point.id=unit_knowledge_point.knowledge_point_id and chapter_id=#{chapter_id} and chapter_unit.is_delete=0 and unit_knowledge_point.is_delete=0 and knowledge_point.is_delete=0")
    @Select("select * from knowledge_point where id in(\n" +
            "\tselect knowledge_point_id from unit_knowledge_point where unit_id in(\n" +
            "\t\tselect unit_id from chapter_unit where chapter_id=1\n" +
            "\t\t)\n" +
            "\t)")
    List<KnowledgePoint> listKnowledgePointByChapter(@Param("chapter_id") String Chapter_id);
}
