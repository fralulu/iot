package com.infore.dataacquisition.datahandler.model.entity;


import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
/**
 * null
 * 实体类对应的数据表为：  T_DATA_REAL
 * @author Jeff
 * @date 2018-07-02 16:19:22
 */
@ApiModel(value ="DataReal")
public class DataReal {
    @ApiModelProperty(value = "null")
    @NotNull
    private Integer stationId;

    @ApiModelProperty(value = "null")
    @NotNull
    private Object factorCode;

    @ApiModelProperty(value = "null")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull
    private Date sendTime;

    @ApiModelProperty(value = "null")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull
    private Date receiveTime;

    @ApiModelProperty(value = "null")
    private Double value;

    @ApiModelProperty(value = "null")
    private Object factorName;

    @ApiModelProperty(value = "null")
    private Object stationName;

    @ApiModelProperty(value = "null")
    private Object enterName;

    @ApiModelProperty(value = "null")
    private Object state;

    @ApiModelProperty(value = "null")
    private Object sign;

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Object getFactorCode() {
        return factorCode;
    }

    public void setFactorCode(Object factorCode) {
        this.factorCode = factorCode;
    }

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Object getFactorName() {
        return factorName;
    }

    public void setFactorName(Object factorName) {
        this.factorName = factorName;
    }

    public Object getStationName() {
        return stationName;
    }

    public void setStationName(Object stationName) {
        this.stationName = stationName;
    }

    public Object getEnterName() {
        return enterName;
    }

    public void setEnterName(Object enterName) {
        this.enterName = enterName;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }

    public Object getSign() {
        return sign;
    }

    public void setSign(Object sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stationId=").append(stationId);
        sb.append(", factorCode=").append(factorCode);
        sb.append(", sendTime=").append(sendTime);
        sb.append(", receiveTime=").append(receiveTime);
        sb.append(", value=").append(value);
        sb.append(", factorName=").append(factorName);
        sb.append(", stationName=").append(stationName);
        sb.append(", enterName=").append(enterName);
        sb.append(", state=").append(state);
        sb.append(", sign=").append(sign);
        sb.append("]");
        return sb.toString();
    }
}