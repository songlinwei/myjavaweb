package com.springapp.model;

import java.util.Date;

/**
 * Created by songlinwei on 17/1/13.
 */
public class ActivityModel {
    private Integer id;
    private String activityName;
    private String activityInfo;
    private Date startDate;
    private Date endDate;
    private Date createDate;
    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityInfo() {
        return activityInfo;
    }

    public void setActivityInfo(String activityInfo) {
        this.activityInfo = activityInfo;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }


    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "ActivityModel{" +
                "id=" + id +
                ", activityName='" + activityName + '\'' +
                ", activityInfo='" + activityInfo + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
