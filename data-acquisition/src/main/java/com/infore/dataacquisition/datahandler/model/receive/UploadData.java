package com.infore.dataacquisition.datahandler.model.receive;




import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.infore.dataacquisition.common.utils.FinalModel;
import com.infore.dataacquisition.common.utils.FormatUtil;


public class UploadData implements java.io.Serializable {
	
	/** long serialVersionUID */
	private static final long serialVersionUID = 1L;	
	/* 系统编码 */
	private String ST;
	
	/* 访问密码 */
	private String PW;
	
	/* 命令编号 */
	private String CN;
	
	/* 点位的MN号 */
	private String MN;
	
	/* 指令参数，CP=&&数据区&& */
	private String CP;
	
	/* 请求编号 */
	private String QN;
	
	/* 请求回应代码 */
	private String QnRtn;
	
	/* 执行结果回应代码 */
	private String ExcRtn;
	
	/* 实时采样数据上报时间，以秒为单位 */
	private String RtdInterval;
	
	/* 超标开始时间 */
	private Date AlarmTime;
	
	/* 报警事件类型 */
	private String AlarmType;
	
	/* 数据时间信息 */
	private Date DataTime;
	
	/* 数据接收时间 */
	private Date ReceiveTime;
	
	/* 设备采样时间周期，以小时为单位 */
	private Integer CTime;
	
	private List<UploadValue> values = new ArrayList<UploadValue>();	
	
	private String Flag;
	
	public String getST() {
		return ST;
	}


	public void setST(String sT) {
		ST = sT;
	}


	public String getPW() {
		return PW;
	}


	public void setPW(String pW) {
		PW = pW;
	}


	public String getCN() {
		return CN;
	}


	public void setCN(String cN) {
		CN = cN;
	}


	public String getMN() {
		return MN;
	}


	public void setMN(String mN) {
		MN = mN;
	}


	public String getCP() {
		return CP;
	}


	public void setCP(String cP) {
		CP = cP;
	}


	public String getQN() {
		return QN;
	}


	public void setQN(String qN) {
		QN = qN;
	}


	public String getQnRtn() {
		return QnRtn;
	}


	public void setQnRtn(String qnRtn) {
		QnRtn = qnRtn;
	}


	public String getExcRtn() {
		return ExcRtn;
	}


	public void setExcRtn(String excRtn) {
		ExcRtn = excRtn;
	}


	public String getRtdInterval() {
		return RtdInterval;
	}


	public void setRtdInterval(String rtdInterval) {
		RtdInterval = rtdInterval;
	}


	public Date getAlarmTime() {
		return AlarmTime;
	}


	public void setAlarmTime(String alarmTime) {
		AlarmTime = parseDateValue(alarmTime);;
	}


	public String getAlarmType() {
		return AlarmType;
	}


	public void setAlarmType(String alarmType) {
		AlarmType = alarmType;
	}


	public Date getDataTime() {
		return DataTime;
	}


	public void setDataTime(String dataTime) {
		DataTime = parseDateValue(dataTime);
	}


	public Date getReceiveTime() {
		return ReceiveTime;
	}


	public void setReceiveTime(String receiveTime) {
		ReceiveTime = parseDateValue(receiveTime);
	}


	public Integer getCTime() {
		return CTime;
	}


	public void setCTime(Integer cTime) {
		CTime = cTime;
	}


	public List<UploadValue> getValues() {
		return values;
	}


	public void setValues(List<UploadValue> values) {
		this.values = values;
	}


	protected static Date parseDateValue( String value ) {
		try {
			if(value!=null&&value.length()>=13){
				return FormatUtil.getDate(FormatUtil.SECOND, value.substring(0, 14));
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 查询站点因子最高数据状态
	 * @Date 2017年7月12日 上午10:41:02
	 * @Author renyu
	 * @param uploadData
	 * @return
	 */
	/*public String selectStationOverState(){
		String overState = "OK";//正常
		try{
			List<UploadValue> values = this.getValues();
			Map<Integer,OverproofSet> overproofs=new FinalModel().getAllOverProofSet();
			Map<String,Factor> factors=new FinalModel().getAllProjectInstance();
			for (UploadValue uploadValue : values) {
				Factor project=factors.get(uploadValue.getCode());//获取因子
				OverproofSet overproofSet = overproofs.get(project.getId());//获取因子超标限值
				if(overproofSet==null){
					
				}else{
					double rtd = uploadValue.getRtd();
					double upper = project.getUpper()==null?20:project.getUpper();
					double lower = project.getFlower()==null?0:project.getFlower();
					if(project.getPollutionFactor()==1){
						switch(overState){
						case "OK":double ov = overproofSet.getOverproofValue();//超标
						if(rtd>=lower&&rtd<ov) break;//该因子未更新数据状态，排除直接下一个因子
						overState = "OR";
						case "OR":double hv = overproofSet.getHoverproofValue();//高报警
						if(rtd>=lower&&rtd<hv) break;//该因子未更新数据状态，排除直接下一个因子
						overState = "HR";
						case "HR":	double cv = overproofSet.getCoverproofValue();//超高报警
						if(rtd>=lower&&rtd<cv) break;//该因子未更新数据状态，排除直接下一个因子
						overState = "CR";
						case "CR":if(rtd>=lower&&rtd<=upper) break;//量程内
						overState = "AB";
						}
					}else{
						if(rtd<lower||rtd>upper) overState = "AB";
					}
				}				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return overState;
	}*/


	public String getFlag() {
		return Flag;
	}


	public void setFlag(String flag) {
		Flag = flag;
	}
}
