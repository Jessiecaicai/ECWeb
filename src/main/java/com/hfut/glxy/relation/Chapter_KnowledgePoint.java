/*
 * ClassName: CoursesApplication <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2017年11月21日 <br/>
 *
 * @author students_ManagementSchool
 * @version
 * @since JDK 1.8
 */

/*
 * ClassName: CoursesApplication <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2017年11月21日 <br/>
 *
 * @author students_ManagementSchool
 * @version
 * @since JDK 1.8
 */

package com.hfut.glxy.relation;

import com.baomidou.mybatisplus.activerecord.Model;
import com.hfut.glxy.entity.Chapter;
import com.hfut.glxy.entity.KnowledgePoint;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class Chapter_KnowledgePoint  extends Model<Chapter_KnowledgePoint> {


    private String chapter_id;
    private String knowledgePoint_id;
    private Timestamp createTime;
    private Timestamp updateTime;
    private int isDelete;

    public String getChapter_id() {
        return chapter_id;
    }

    public void setChapter_id(String chapter_id) {
        this.chapter_id = chapter_id;
    }

    public String getKnowledgePoint_id() {
        return knowledgePoint_id;
    }

    public void setKnowledgePoint_id(String knowledgePoint_id) {
        this.knowledgePoint_id = knowledgePoint_id;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Chapter_KnowledgePoint{" +
                "chapter_id='" + chapter_id + '\'' +
                ", knowledgePoint_id='" + knowledgePoint_id + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                '}';
    }

    @Override
    protected Serializable pkVal() {
        return chapter_id;
    }
}
