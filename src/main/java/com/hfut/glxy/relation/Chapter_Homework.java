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

import java.io.Serializable;
import java.sql.Timestamp;

public class Chapter_Homework implements Serializable {

    private String chapter_id;
    private String homework_id;
    private Timestamp createTime;
    private Timestamp updateTime;
    private int isDelete;

    @Override
    public String toString() {
        return "Chapter_Homework{" +
                "chapter_id='" + chapter_id + '\'' +
                ", homework_id='" + homework_id + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                '}';
    }

    public String getChapter_id() {
        return chapter_id;
    }

    public void setChapter_id(String chapter_id) {
        this.chapter_id = chapter_id;
    }

    public String getHomework_id() {
        return homework_id;
    }

    public void setHomework_id(String homework_id) {
        this.homework_id = homework_id;
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
}
