package com.infore.dataacquisition.datahandler.model.receive;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 统计数据
 * @author 周文涛
 *
 *
 */
public class StatisData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer stationID; 
	private Integer projectID;
	private Timestamp sendTime;
	private Timestamp endTime;
	private Double flowValue;
	private Double dataValue;
	private String timeType;
	private Integer totalCount;
	public Timestamp getSendTime() {
		return sendTime;
	}
	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public Double getFlowValue() {
		return flowValue;
	}
	public void setFlowValue(Double flowValue) {
		this.flowValue = flowValue;
	}
	public String getTimeType() {
		return timeType;
	}
	public void setTimeType(String timeType) {
		this.timeType = timeType;
	}
	public Double getDataValue() {
		return dataValue;
	}
	public void setDataValue(Double dataValue) {
		this.dataValue = dataValue;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getStationID() {
		return stationID;
	}
	public void setStationID(Integer stationID) {
		this.stationID = stationID;
	}
	public Integer getProjectID() {
		return projectID;
	}
	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
	}
	
	
}
