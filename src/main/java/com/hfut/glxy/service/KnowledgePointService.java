package com.hfut.glxy.service;

import com.baomidou.mybatisplus.service.IService;
import com.hfut.glxy.entity.Chapter;
import com.hfut.glxy.entity.KnowledgePoint;
import com.hfut.glxy.entity.Unit;

import java.util.List;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date: Created in 15:59 2017/12/5
 * @Modified By:
 */
public interface KnowledgePointService extends IService<KnowledgePoint>{
    /**
     * @Author: Jessiecaicai
     * @Description: 添加课程章节与知识点之间的关系
     * @Date: 21:07 2018/1/3
     * @param:  * @param null
     */
    public int addUnitKnowledgePointRelation(Unit unit,KnowledgePoint knowledgePoint) throws Exception;

    /**
     * @Author: Jessiecaicai
     * @Description: 列出该章节所有的知识点（属性包括知识点id与内容）
     * @Date: 16:25 2018/1/4
     * @param:  * @param null
     */
    public List<KnowledgePoint> listKnowledgePointByChapter(String chapterId) throws Exception;
}
