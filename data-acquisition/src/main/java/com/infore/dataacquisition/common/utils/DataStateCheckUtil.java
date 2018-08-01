package com.infore.dataacquisition.common.utils;


import java.util.Map;

import com.infore.dataacquisition.datahandler.model.entity.Factor;
import com.infore.dataacquisition.datahandler.model.entity.OverproofSet;

/**
 * 判断数据状态
 * @author 周文涛
 *
 *
 */
public class DataStateCheckUtil {
	/**
	 * 
	 * @Date 2017年7月12日 下午2:14:08
	 * @Author zhouwt
	 * @param uploadValue
	 * @return
	 */
	/*public static String makeRealDataState(Factor factor,Double avg){
		String state = "OK";
		if(avg==null){
			return state;
		}
		Map<Integer,OverproofSet> overproofs=new FinalModel().getAllOverProofSet();
		OverproofSet overproofSet = overproofs.get(factor.getId());//获取因子超标限值
		Double upper = factor.getUpper();
		Double lower = factor.getFlower();
		
		
		//先对超限进行判断
		if(upper!=null&&avg>upper){
			state="AB";
			return state;
		}else if(lower!=null&&avg<lower){
			state="AB";
			return state;
		}
		//若该因子没有设定超标值则直接返回
		if(overproofSet==null){			
			return state;
		}
		//如果是污染因子，则取判断超标等级
		if(factor.getPollutionFactor()==1){
			Double or=overproofSet.getOverproofValue();
			Double hr=overproofSet.getHoverproofValue();
			Double cr=overproofSet.getCoverproofValue();
			if(cr!=null&&(avg>=cr)){
				state="CR";
			}else if(hr!=null&&avg>=hr){
				state="HR";
			}else if(or!=null&&avg>=or){
				state="OR";
			}
		}
		return state;
	}*/

}
