package com.hfut.glxy.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hfut.glxy.dto.Result;
import com.hfut.glxy.entity.KnowledgePoint;
import com.hfut.glxy.relation.Chapter_KnowledgePoint;
import com.hfut.glxy.service.ChapterService;
import com.hfut.glxy.service.Chapter_KnowledgePointService;
import com.hfut.glxy.service.KnowledgePointService;
import com.hfut.glxy.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @Author: Jessiecaicai
 * @Description: 知识点管理是在教学单元管理下的，教学单元下会有相应知识点的管理。
 *               并且章处能显示该章所有的知识点，然后点击知识点弹出包含有该知识点对应的教学单元任用户选中。
 *               知识点和教学单元是多对一的关系；
 * @Date: Created in 16:16 2017/12/7
 * @Modified By:
 */
@RestController
@RequestMapping(value = "/knowledgePoint")
public class KnowledgePointController {

    private Chapter_KnowledgePointService chapter_knowledgePointService;
    private KnowledgePointService knowledgePointService;

    @Autowired
    protected KnowledgePointController(KnowledgePointService knowledgePointService) {
        this.knowledgePointService=knowledgePointService;
    }

    /**
     * @Author: Jessiecaicai
     * @Description: 根据章分页知识点 pageNum表示当前页码 ok
     * @Date: 20:10 2017/12/17
     * @param:  * @param null
     */
    @GetMapping("/{pageNum}")
    public Result listKnowledgePoints(@PathVariable(value="pageNum",required = false)int pageNum, HttpSession session){
        String chapterId=(String)session.getAttribute("chapterId");
        if(pageNum<=0){
            pageNum=1;
        }
        try{
            Page<KnowledgePoint> page=knowledgePointService.selectPage(new Page<>(pageNum,4),
                    new EntityWrapper<KnowledgePoint>()
            .eq("is_delete",0)
            .eq("id",chapterId));
            return ResultUtil.success(page);
        }catch(Exception e){
            e.printStackTrace();
            return ResultUtil.selectError();
        }
    }

    /**
     * @Author: Jessiecaicai
     * @Description: 知识点分页1  size 一页显示数量  current 当前页码 ok
     * @Date: 21:22 2017/12/25
     * @param:  * @param null
     */
    @GetMapping("/page")
    public Result pageKnowledgePoints2(Page<KnowledgePoint> page){
        try{
            page=knowledgePointService.selectPage(page);
            return ResultUtil.success(page);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.selectError();
        }

    }


    /**
     * @Author: Jessiecaicai
     * @Description: 更新知识点 ok
     * @Date: 20:17 2017/12/17
     * @param:  * @param null
     */
    @PutMapping
    public Result updateKnowledgePoint(@RequestBody KnowledgePoint knowledgePoint){
        try{
            if(knowledgePointService.updateById(knowledgePoint)){
                return ResultUtil.OK();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return ResultUtil.updateError();
    }

    /**
     * @Author: Jessiecaicai
     * @Description: 增加知识点 ok
     * @Date: 20:19 2017/12/17
     * @param:  * @param null
     */
    @PostMapping
    public Result insertKnowledgePoint(@RequestBody @Valid KnowledgePoint knowledgePoint, BindingResult result){
        if(result.hasErrors()){
            return ResultUtil.fail(result.getAllErrors().toString());
        }
        try{
            if(knowledgePointService.insert(knowledgePoint)) {
                return ResultUtil.OK();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.success("success",knowledgePoint);
    }
}
