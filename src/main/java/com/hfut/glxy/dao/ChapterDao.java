/*package com.hfut.glxy.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hfut.glxy.dao.dynamicSQLProvider.DynamicSQLProvider;
import com.hfut.glxy.entity.Chapter;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
*/
/**
 * @Author: Jessiecaicai
 * @Description: 节SQL语句封装
 * @Date: Created in 20:15 2017/11/29
 * @Modified By:
 */
/*@Mapper
public interface ChapterDao {*/
    /**
     * @Author: Jessiecaicai
     * @Description: 增加节
     * @Date: 20:16 2017/11/29
     * @param:  * @param null
     */
    /*@Insert("insert into chapter values (#{chapter.id},#{chapter.number},#{chapter.name},NOW(),NOW(),#{chapter.isDelete}")
    Integer addChapter(@Param("chapter")Chapter chapter);*/
    /**
     * @Author: Jessiecaicai
     * @Description: 更新节
     * @Date: 20:19 2017/11/29
     * @param:  * @param null
     */
    /*@UpdateProvider(type= DynamicSQLProvider.class,method="updateChapter")
    Integer updateChapter(Chapter chapter);
    */
    /**
     * @Author: Jessiecaicai
     * @Description: 通过id删除节
     * @Date: 20:21 2017/11/29
     * @param:  * @param null
     */
    /*@Delete("delete from chapter where id =#{id}")
    Integer deleteChapterById(@Param("id")String id);
    */
    /**
     * @Author: Jessiecaicai
     * @Description: 根据id查找知识点
     * @Date: 20:22 2017/11/29
     * @param:  * @param null
     */
    /*@Select("select * from chapter where id=#{id}")
    Integer queryChapterById(@Param("id")String id);
    */
    /**
     * @Author: Jessiecaicai
     * @Description: 节分页（感觉不需要暂时不写）
     * @Date: 20:24 2017/11/29
     * @param:  * @param null
     */
/*}*/
