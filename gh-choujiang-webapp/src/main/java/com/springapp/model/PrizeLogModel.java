package com.springapp.model;

import java.util.Date;

/**
 * Created by songlinwei on 17/1/13.
 */
public class PrizeLogModel {
    private Integer id;
    private Integer activityId;
    private Integer prizeId;
    private String uName;
    private Date prizeLogDate;
    private Date createDate;
    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPrizeLogDate() {
        return prizeLogDate;
    }

    public void setPrizeLogDate(Date prizeLogDate) {
        this.prizeLogDate = prizeLogDate;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Integer prizeId) {
        this.prizeId = prizeId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
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
        return "PrizeLogModel{" +
                "id=" + id +
                ", activityId='" + activityId + '\'' +
                ", prizeId='" + prizeId + '\'' +
                ", uName='" + uName + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
