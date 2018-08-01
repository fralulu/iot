package com.infore.dataacquisition.netty.thread;




import java.io.PrintWriter;
import java.net.Socket;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.infore.dataacquisition.common.utils.CRCCheck;
import com.infore.dataacquisition.common.utils.FormatUtil;
import com.infore.dataacquisition.common.utils.NumberUtils;
import com.infore.dataacquisition.datahandler.model.entity.Factor;
import com.infore.dataacquisition.datahandler.model.entity.Station;

/**
 * 执行具体的模拟数据发送与数据的拼接生成
 * @author 周文涛
 * @time
 */
public class DataRealSimuThread implements Runnable{
	protected static final Logger logger = LoggerFactory.getLogger(DataRealSimuThread.class);
	
	/*private static Integer port=51132;*/
	private static Integer port=8530;
	/*private static String sendIp="127.0.0.1";*/
	private static String sendIp="192.168.37.6";
	private Station station;
	private List<Factor> projects;
	public DataRealSimuThread(){
		
	}
	
	public DataRealSimuThread(Station station,List<Factor> projects){
		this.station=station;
		this.projects=projects;
	}
	@Override
	public void run() {
		Socket soc;
		try {
			soc = new Socket(sendIp,port);
			while(true){
				if(soc==null){
					soc = new Socket(sendIp,port);
				}
				PrintWriter socketWriter = new PrintWriter(soc.getOutputStream());
				//System.out.println(station);
				String code=getCode(station, projects);
				logger.info("发送报文：===>"+code);
				//socketWriter.write(code);
				socketWriter.print(code);
				socketWriter.flush(); 
				Thread.sleep(60000);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block				
			e1.printStackTrace();
			
		} 
		
	}
	
	//获取拼接后的字符串
	private synchronized String getCode(Station station,List<Factor> projects){
		Date date=new Date();
		String dateTime=FormatUtil.getdateFormat(FormatUtil.SECOND, date);
		String QN=FormatUtil.getdateFormat(FormatUtil.MILLISECOND, date);
		String src="QN="+QN+";ST=32;CN=2011;PW=123456;MN="+station.getStationNumber()+";CP=&&DataTime="+dateTime+";"+getProjectsCode(projects)+"&&";
		String reStr=CRCCheck.produceFinger(src);
		return reStr;
	}
	//"+((int)(Math.random()*10)%2)+"
	//获取因子数据值字符串
	private synchronized String getProjectsCode(List<Factor> projects){
		String prostr="";
		for (Factor tProject : projects) {
			String code=tProject.getFactorCode(); 
			prostr=prostr+code+"-Rtd="+getRandomValue(tProject)+","+code+"-Flag=N;";
		}
		if(prostr.length()>0){
			return prostr.substring(0, prostr.length()-1);
		}
		
		return prostr;
	}
	
	//获取随机数
	private synchronized Double getRandomValue(Factor project){
		if(project.getUpper()!=null){
			return Double.parseDouble(NumberUtils.setDecimal((project.getUpper()+5)*Math.random(), 3));
		}
		return Double.parseDouble(NumberUtils.setDecimal(Math.random(), 3));
	}
	
	public static void main(String[] args) {
		
		
	}

}
