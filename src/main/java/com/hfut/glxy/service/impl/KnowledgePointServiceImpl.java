package com.hfut.glxy.service.impl;

import com.alibaba.druid.sql.ast.statement.SQLIfStatement;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hfut.glxy.entity.Chapter;
import com.hfut.glxy.entity.KnowledgePoint;
import com.hfut.glxy.entity.Unit;
import com.hfut.glxy.mapper.KnowledgePointMapper;
import com.hfut.glxy.service.KnowledgePointService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date: Created in 15:55 2017/12/5
 * @Modified By:
 */
@Service
public class KnowledgePointServiceImpl extends ServiceImpl<KnowledgePointMapper,KnowledgePoint> implements KnowledgePointService{

    @Resource
    private KnowledgePointMapper knowledgePointMapper;

    /**
     * @Author: Jessiecaicai
     * @Description: 添加知识点和教学单元之间的关联
     * @Date: 19:50 2018/1/4
     * @param:  * @param null
     */
    @Override
    public int addUnitKnowledgePointRelation(Unit unit,KnowledgePoint knowledgePoint) throws Exception{
        if(unit==null&&knowledgePoint==null){
            throw new Exception("添加知识点与教学单元的参数有误");
        }

        try {
            int result=knowledgePointMapper.addunitKnowledgePointRelation(unit.getId(),knowledgePoint.getId());
            if(result==1){
                return 1;
            }else if(result==0){
                return 0;
            }else {
                return 0;
            }

        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * @Author: Jessiecaicai
     * @Description: 根据章节id取出该章节所有的知识点
     * @Date: 19:50 2018/1/4
     * @param:  * @param null
     */
    @Override
    public List<KnowledgePoint> listKnowledgePointByChapter(String chapterId) throws Exception{
        if (chapterId==null){
            throw new Exception("取不到章节信息");
        }
        try {
            List<KnowledgePoint> list=knowledgePointMapper.listKnowledgePointByChapter(chapterId);
            return list;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
