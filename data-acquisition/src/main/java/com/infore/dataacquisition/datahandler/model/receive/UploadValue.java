package com.infore.dataacquisition.datahandler.model.receive;

import java.util.Map;



/**
 * @author 黄晓峰
 * @Description: 上传数据的具体监测值
 * 2015-5-5  上午1:27:13
 * @version v1.0
 */
public class UploadValue implements java.io.Serializable {
	
	/** long serialVersionUID */
	private static final long serialVersionUID = 1L;

	/* 因子的编码 */
	private String code;
	
	/* 污染物实时采样数据 */
	private Double Rtd;
	
	/* 污染物指定时间内最小值 */
	private Double Min;
	
	/* 污染物指定时间内平均值 */
	private Double Avg;
	
	/* 最大值 */
	private Double Max;
	
	/* 折算数据 */
	private Double ZsRtd;
	
	/* 最小值折算 */
	private Double ZsMin;
	
	/* 平均值折算 */
	private Double ZsAvg;
	
	/* 最大折算值 */
	private Double ZsMax;
	/* 
	 * 监测污染物实时数据标记
	 * 对于污染源（P：电源故障、F：排放源停运、C：校验、M：维护、T：超测上限、D：故障、S：设定值、N：正常）
	 * 对于空气检测站（0：校准数据、1：气象参数、2：异常数据、3 正常数据） 
	 */
	private String Flag;
	
	/* 累计值 */
	private Double Cou;
	
	//未定义属性
	private String RS;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getRtd() {
		return Rtd;
	}

	public void setRtd(String rtd) {
		Rtd = Double.parseDouble(rtd);
	}

	public Double getMin() {
		return Min;
	}

	public void setMin(String min) {
		Min = Double.parseDouble(min);
	}

	public Double getAvg() {
		return Avg;
	}

	public void setAvg(String avg) {
		Avg = Double.parseDouble(avg);
	}

	public Double getMax() {
		return Max;
	}

	public void setMax(String max) {
		Max = Double.parseDouble(max);
	}

	public Double getZsRtd() {
		return ZsRtd;
	}

	public void setZsRtd(String zsRtd) {
		ZsRtd = Double.parseDouble(zsRtd);
	}

	public Double getZsMin() {
		return ZsMin;
	}

	public void setZsMin(String zsMin) {
		ZsMin = Double.parseDouble(zsMin);
	}

	public Double getZsAvg() {
		return ZsAvg;
	}

	public void setZsAvg(String zsAvg) {
		ZsAvg = Double.parseDouble(zsAvg);
	}

	public Double getZsMax() {
		return ZsMax;
	}

	public void setZsMax(String zsMax) {
		ZsMax =Double.parseDouble(zsMax);
	}

	public String getFlag() {
		return Flag;
	}

	public void setFlag(String flag) {
		Flag = flag;
	}

	public Double getCou() {
		return Cou;
	}

	public void setCou(String cou) {
		Cou = Double.parseDouble(cou);
	}

	public String getRS() {
		return RS;
	}

	public void setRS(String rS) {
		RS = rS;
	}


	
}
