package com.springapp.model;

import java.util.Date;

/**
 * Created by songlinwei on 17/1/13.
 */
public class PrizeModel {
    private Integer id;
    private Integer activityId;
    private String prizeName;
    private String prizeInfo;
    private Integer prizeType;
    private Integer prizeNum = 0; //奖品数量
    private String prizeProbability; //概率
    private Date startDate;
    private Date endDate;
    private Date createDate;
    private Date updateDate;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public String getPrizeInfo() {
        return prizeInfo;
    }

    public void setPrizeInfo(String prizeInfo) {
        this.prizeInfo = prizeInfo;
    }

    public Integer getPrizeType() {
        return prizeType;
    }

    public void setPrizeType(Integer prizeType) {
        this.prizeType = prizeType;
    }

    public Integer getPrizeNum() {
        return prizeNum;
    }

    public void setPrizeNum(Integer prizeNum) {
        this.prizeNum = prizeNum;
    }

    public String getPrizeProbability() {
        return prizeProbability;
    }

    public void setPrizeProbability(String prizeProbability) {
        this.prizeProbability = prizeProbability;
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
        return "PrizeModel{" +
                "id=" + id +
                ", activityId=" + activityId +
                ", prizeName='" + prizeName + '\'' +
                ", prizeInfo='" + prizeInfo + '\'' +
                ", prizeType=" + prizeType +
                ", prizeNum=" + prizeNum +
                ", prizeProbability=" + prizeProbability +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
