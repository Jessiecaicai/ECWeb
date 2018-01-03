package com.hfut.glxy.controller;

import com.hfut.glxy.service.ChapterService;
import com.hfut.glxy.service.Chapter_KnowledgePointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Jessiecaicai
 * @Description: 处理chapter与knowledgePoint之间联立关系的接口
 * @Date: Created in 13:01 2017/12/9
 * @Modified By:
 */
@RestController
@RequestMapping(value = "/chapter_knowledgePoint")
public class Chapter_KnowledgePointController {

    private Chapter_KnowledgePointService chapter_knowledgePointService;
    private ChapterService chapterService;

     @Autowired
     protected Chapter_KnowledgePointController(Chapter_KnowledgePointService chapter_knowledgePointService){
         this.chapter_knowledgePointService=chapter_knowledgePointService;
     }

     /**
      * @Author: Jessiecaicai
      * @Description: 因为章节删除而删除该章节存在的关系
      * @Date: 13:03 2017/12/9
      * @param:  * @param null
      */
     //@DeleteMapping("/{}")


}
