package com.hfut.glxy.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hfut.glxy.dto.Result;
import com.hfut.glxy.entity.Unit;
import com.hfut.glxy.service.UnitService;
import com.hfut.glxy.utils.ResultUtil;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.ProtectionDomain;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Jessiecaicai
 * @Description: 节的方法接口
 * @Date:Created time 2017/12/18
 * @Modified By:
 */
@RestController
@RequestMapping(value = "/unit")
public class UnitController {

    private UnitService unitService;

    @Autowired
    protected UnitController(UnitService unitService){
        this.unitService=unitService;
    }

    /**
     * @Author: Jessiecaicai
     * @Description: 按id删除节 ok
     * @Date: 19:54 2017/12/18
     * @param:  * @param null
     */
    @DeleteMapping("/{id}")
    public Result removeUnit(@PathVariable("id") String id){
        try{
            if (id!=null&&id!="0"){
                Unit unit=new Unit();
                unit.setId(id);
                unit.setIsDelete(1);
                if(unitService.updateById(unit)){
                    return ResultUtil.success("删除该节成功",null);
                }
            }else{
                return ResultUtil.fail("id为空或者格式不正确");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.deleteError();
    }

    /**
     * @Author: Jessiecaicai
     * @Description: 增加节 ok
     * @Date: 20:01 2017/12/18
     * @param:  * @param null
     */
    @PostMapping
    public Result insertUnit(@RequestBody @Valid Unit unit, BindingResult result){

        if (result.hasErrors()){
            return ResultUtil.fail(result.getAllErrors().toString());
        }
        try{
            if (unitService.insert(unit)){
                return ResultUtil.OK();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.success("success",unit);

    }

    /**
     * @Author: Jessiecaicai
     * @Description: 更新节 ok
     * @Date: 20:23 2017/12/18
     * @param:  * @param null
     */
    @PutMapping
    public Result updateUnit(@RequestBody Unit unit){
        try{
            if(unitService.updateById(unit)){
                return ResultUtil.OK();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return ResultUtil.updateError();
    }

    /**
     * @Author: Jessiecaicai
     * @Description: 根据id查找节 ok
     * @Date: 20:28 2017/12/18
     * @param:  * @param null
     */
    @GetMapping({"/{id}"})
    public Result selectUnitById(@PathVariable("id") String id, HttpSession session){
        String unitId=(String)session.getAttribute("id");

        if (id!=null&&id!="0"){
            try {
                Map<String,Object> map=new HashMap<>(4);
                map.put("is_delete",0);
                map.put("id",unitId);
                unitService.selectByMap(map);
                //Unit unit=unitService.selectById(id,
                //    /*    new EntityWrapper<Unit>()
                //                .eq("is_delete",0)
                //                .eq("id",unitId)*/);
                return ResultUtil.success(map);
            }catch (Exception e){
                e.printStackTrace();
                return ResultUtil.selectError();
            }

        }
        return ResultUtil.selectError();
    }

    /**
     * @Author: Jessiecaicai
     * @Description: 根据知识点选出教学单元
     * @Date: 18:59 2018/1/3
     * @param:  * @param null
     */


}
