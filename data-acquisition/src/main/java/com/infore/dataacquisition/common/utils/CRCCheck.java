package com.infore.dataacquisition.common.utils;


/**
 * 
 * @author 周文涛
 *
 *
 */
public class CRCCheck {
	//做212的格式验证
	public static String crc16(String src, int len) {
		int crc = 0x0000FFFF;
		short tc;
		char sbit;
		for (int i = 0; i < len; i++) {
			tc = (short) (crc >>> 8);
			crc = ((tc ^ src.charAt(i)) & 0x00FF);
			for (int r = 0; r < 8; r++) {
				sbit = (char) (crc & 0x01);
				crc >>>= 1; 
				if (sbit != 0)
					crc = (crc ^ 0xA001) & 0x0000FFFF;
			}
		}
		String str=Integer.toHexString(crc);
		if(str.length()==3){
			return "0"+str.toUpperCase();
		}else if(str.length()==2){
			return "00"+str.toUpperCase();
		}else if(str.length()==1){
			return "000"+str.toUpperCase();
		}
		
		
		
//		if(str.length()==3){
//			return "0"+str;
//		}
		return str.toUpperCase();
	}
	
	
	//产生最终发送数据
	public static String produceFinger(String cmd){
		String lenth=cmd.length()+"";
		if(lenth.toString().length()==3){
			lenth="0"+lenth;
		}else if(lenth.toString().length()==2){
			lenth="00"+lenth;
		}else if(lenth.toString().length()==1){
			lenth="000"+lenth;
		}
		String crc=CRCCheck.crc16(cmd, Integer.parseInt(lenth));
		String rtcmd="##"+lenth+cmd+crc+"\r\n";
		return rtcmd;
	}
	
	public static void main(String[] args) {
		System.out.println("QN=20171222091613400;ST=31;CN=2011;PW=123456;MN=31011500043310;CP=&&DataTime=20171222091500;a21001-Rtd=10.842,a21001-Flag=N&&".length());
		System.out.println(crc16("ST=32;CN=2011;PW=123456;MN=454406060000BS;CP=&&DataTime=20140320155443;001-Rtd=5.84,001-Flag=N;B01-Rtd=13.62,B01-Flag=N;011-Rtd=14.84,011-Flag=N;028-Rtd=0.00,028-Flag=N&&", 170));
	}
}
