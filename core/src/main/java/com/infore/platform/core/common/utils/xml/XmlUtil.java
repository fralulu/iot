package com.infore.platform.core.common.utils.xml;
import com.infore.platform.core.common.utils.DataUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.*;
import org.dom4j.tree.DefaultElement;

import java.util.*;

/**
 * 
 * All rights Reserved, Designed By www.infore.com
 * @Title:  XmlUtil.java   
 * @Package com.infore.platform.core.common.utils.xml   
 * @Description:    XML处理器<br>   
 * @author: Administrator  
 * @date:   2017年9月12日 下午9:16:27   
 * @version V1.0 
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2017 www.infore.com Inc. All rights reserved. 
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public final class XmlUtil {
	private static Log log = LogFactory.getLog(XmlUtil.class);

	private XmlUtil() {
	}

	
	/**
	 * 
	 * @Title: parseXml2Map   
	 * @Description: 解析XML并将其节点元素压入Dto返回(基于节点值形式的XML格式) 
	 * @param:  pStrXml 待解析的XML字符串
	 * @return: Map      
	 * @throws
	 */
	public static final Map parseXml2Map(String pStrXml) {
		Map map = new HashMap();
		String strTitle = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		Document document = null;
		try {
			if (pStrXml.indexOf("<?xml") < 0) {
				pStrXml = strTitle + pStrXml;
			}
			document = DocumentHelper.parseText(pStrXml);

		} catch (DocumentException e) {
			log.error("==开发人员请注意:==\n将XML格式的字符串转换为XML DOM对象时发生错误啦!" + "\n详细错误信息如下:", e);
		}
		// 获取根节点

		Element elNode = document.getRootElement();
		// 遍历节点属性值将其压入Dto

		for (Iterator it = elNode.elementIterator(); it.hasNext();) {
			Element leaf = (Element) it.next();
			map.put(leaf.getName().toLowerCase(), leaf.getData());
		}
		return map;
	}

	
	
	/**
	 * 
	 * @Title: Dom2Map   
	 * @Description: 解析XML并将其节点元素压入Dto返回(基于节点值形式的XML格式) 应用于复杂对象  
	 * @param: @param doc 待解析的XML字符串
	 * @param: @return      
	 * @return: Map      
	 * @throws
	 */

	public static Map Dom2Map(Document doc) {
		Map map = new HashMap();
		if (doc == null) {
			return map;
		}
		Element root = doc.getRootElement();
		for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
			Element e = (Element) iterator.next();
			List list = e.elements();
			if (list.size() > 0) {
				map.put(e.getName(), Dom2Map(e));
			} else {
				map.put(e.getName(), e.getText());
			}
		}
		return map;
	}

	/**
	 * 
	 * @Title: Dom2Map   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param e
	 * @param: @return      
	 * @return: Map      
	 * @throws
	 */
	public static Map Dom2Map(Element e) {
		Map map = new HashMap();
		List list = e.elements();
		if (list.size() > 0) {
			for (Object aList : list) {
				Element iter = (Element) aList;
				List mapList = new ArrayList();

				if (iter.elements().size() > 0) {
					Map m = Dom2Map(iter);
					if (map.get(iter.getName()) != null) {
						Object obj = map.get(iter.getName());
						if (!"java.util.ArrayList".equals(obj.getClass().getName())) {
							mapList = new ArrayList();
							mapList.add(obj);
							mapList.add(m);
						}
						if ("java.util.ArrayList".equals(obj.getClass().getName())) {
							mapList = (List) obj;
							mapList.add(m);
						}
						map.put(iter.getName(), mapList);
					} else {
						map.put(iter.getName(), m);
					}
				} else {
					if (map.get(iter.getName()) != null) {
						Object obj = map.get(iter.getName());
						if (!"java.util.ArrayList".equals(obj.getClass().getName())) {
							mapList = new ArrayList();
							mapList.add(obj);
							mapList.add(iter.getText());
						}
						if ("java.util.ArrayList".equals(obj.getClass().getName())) {
							mapList = (List) obj;
							mapList.add(iter.getText());
						}
						map.put(iter.getName(), mapList);
					} else {
						map.put(iter.getName(), iter.getText());
					}
				}
			}
		} else {
			map.put(e.getName(), e.getText());
		}
		return map;
	}

	/**
	 * 
	 * @Title: parseXml2Map   
	 * @Description: 解析XML并将其节点元素压入Dto返回(基于节点值形式的XML格式)
	 * @param: @param pStrXml 待解析的XML字符串
	 * @param: @param pXPath 节点路径(例如："//paralist/row" 则表示根节点paralist下的row节点的xPath路径)
	 * @param: @return      
	 * @return: Map      
	 * @throws
	 */
	public static Map parseXml2Map(String pStrXml, String pXPath) {
		Map map = new HashMap();
		String strTitle = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		Document document = null;
		try {
			if (!pStrXml.contains("<?xml")) {
				pStrXml = strTitle + pStrXml;
			}
			document = DocumentHelper.parseText(pStrXml);
		} catch (DocumentException e) {
			log.error("==开发人员请注意:==\n将XML格式的字符串转换为XML DOM对象时发生错误啦!" + "\n详细错误信息如下:", e);
		}
		// 获取根节点

		Element elNode = document.getRootElement();
		// 遍历节点属性值将其压入Dto

		for (Iterator it = elNode.elementIterator(); it.hasNext();) {
			Element leaf = (Element) it.next();
			map.put(leaf.getName().toLowerCase(), leaf.getData());
		}
		return map;
	}

	/**
	 * 
	 * @Title: parseDto2Xml   
	 * @Description: 将Map转换为符合XML标准规范格式的字符串(基于节点值形式)  
	 * @param: @param map 传入的对象
	 * @param: @param pRootNodeName 根结点名
	 * @param: @return      
	 * @return: String      返回XML格式字符串
	 * @throws
	 */
	public static String parseDto2Xml(Map map, String pRootNodeName) {
		Document document = DocumentHelper.createDocument();
		// 增加一个根元素节点

		document.addElement(pRootNodeName);
		Element root = document.getRootElement();
		for (Object o : map.keySet()) {
			String key = (String) o;
			String value = (String) map.get(key);
			Element leaf = root.addElement(key);
			leaf.setText(value);
		}
		// 将XML的头声明信息截去

		return document.asXML().substring(39);
	}

	
	/**
	 * 
	 * @Title: parseDto2XmlHasHead   
	 * @Description: 将Dto转换为符合XML标准规范格式的字符串(基于节点值形式)
	 * @param: @param map 传入的Dto对象
	 * @param: @param pRootNodeName 根结点名
	 * @param: @return      返回XML格式字符串
	 * @return: String      
	 * @throws
	 */
	public static String parseDto2XmlHasHead(Map map, String pRootNodeName) {
		Document document = DocumentHelper.createDocument();
		// 增加一个根元素节点

		document.addElement(pRootNodeName);
		Element root = document.getRootElement();
		for (Object o : map.keySet()) {
			String key = (String) o;
			String value = (String) map.get(key);
			Element leaf = root.addElement(key);
			leaf.setText(value);
		}
		return document.asXML();
	}

	
	/**
	 * 
	 * @Title: parseMap2Xml   
	 * @Description: 将Dto转换为符合XML标准规范格式的字符串(基于属性值形式)   
	 * @param: @param map 传入的Dto对象
	 * @param: @param pRootNodeName 根节点名
	 * @param: @param pFirstNodeName 一级节点名
	 * @param: @return      
	 * @return: String      返回XML格式字符串
	 * @throws
	 */
	public static String parseMap2Xml(Map map, String pRootNodeName, String pFirstNodeName) {
		Document document = DocumentHelper.createDocument();
		// 增加一个根元素节点

		document.addElement(pRootNodeName);
		Element root = document.getRootElement();
		root.addElement(pFirstNodeName);
		Element firstEl = (Element) document.selectSingleNode("/" + pRootNodeName + "/" + pFirstNodeName);
		for (Object o : map.keySet()) {
			String key = (String) o;
			String value = (String) map.get(key);
			firstEl.addAttribute(key, value);
		}
		// 将XML的头声明信息丢去

		return document.asXML().substring(39);
	}

	/**
	 * 
	 * @Title: parseList2Xml   
	 * @Description: 将List数据类型转换为符合XML格式规范的字符串(基于节点属性值的方式)
	 * @param: @param pList  传入的List数据(List对象可以是Dto、VO、Domain的属性集)
	 * @param: @param pRootNodeName 根节点名称
	 * @param: @param pFirstNodeName 行节点名称
	 * @param: @return      
	 * @return: String      返回XML格式字符串
	 * @throws
	 */
	public static String parseList2Xml(List pList, String pRootNodeName, String pFirstNodeName) {
		Document document = DocumentHelper.createDocument();
		Element elRoot = document.addElement(pRootNodeName);
		for (Object aPList : pList) {
			Map map = (Map) aPList;
			Element elRow = elRoot.addElement(pFirstNodeName);
			for (Object o : map.entrySet()) {
				Map.Entry entry = (Map.Entry) o;
				elRow.addAttribute((String) entry.getKey(), String.valueOf(entry.getValue()));
			}
		}
		return document.asXML().substring(39);
	}

	
	/**
	 * 
	 * @Title: parseList2XmlBasedNode   
	 * @Description: 将List数据类型转换为符合XML格式规范的字符串(基于节点值的方式)   
	 * @param: @param pList 传入的List数据(List对象可以是Dto、VO、Domain的属性集)
	 * @param: @param pRootNodeName 根节点名称
	 * @param: @param pFirstNodeName 行节点名称
	 * @param: @return      
	 * @return: String   返回XML格式字符串   
	 * @throws
	 */
	public static String parseList2XmlBasedNode(List pList, String pRootNodeName, String pFirstNodeName) {
		Document document = DocumentHelper.createDocument();
		Element output = document.addElement(pRootNodeName);
		for (Object aPList : pList) {
			Map map = (Map) aPList;
			Element elRow = output.addElement(pFirstNodeName);
			for (Object o : map.entrySet()) {
				Map.Entry entry = (Map.Entry) o;
				Element leaf = elRow.addElement((String) entry.getKey());
				leaf.setText(String.valueOf(entry.getValue()));
			}
		}
		return document.asXML().substring(39);
	}

	/**
	 * 
	 * @Title: parseXml2List   
	 * @Description: 将XML规范的字符串转为List对象(XML基于节点属性值的方式)
	 * @param: @param pStrXml 传入的符合XML格式规范的字符串
	 * @param: @return      
	 * @return: List      返回List对象
	 * @throws
	 */
	public static List parseXml2List(String pStrXml) {
		List lst = new ArrayList();
		String strTitle = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		Document document = null;
		try {
			if (!pStrXml.contains("<?xml")) {
				pStrXml = strTitle + pStrXml;
			}
			document = DocumentHelper.parseText(pStrXml);
		} catch (DocumentException e) {
			log.error("==开发人员请注意:==\n将XML格式的字符串转换为XML DOM对象时发生错误啦!" + "\n详细错误信息如下:", e);
		}
		// 获取到根节点

		Element elRoot = document.getRootElement();
		// 获取根节点的所有子节点元素

		Iterator elIt = elRoot.elementIterator();
		while (elIt.hasNext()) {
			Element el = (Element) elIt.next();
			Iterator attrIt = el.attributeIterator();
			Map map = new HashMap();
			while (attrIt.hasNext()) {
				Attribute attribute = (Attribute) attrIt.next();
				map.put(attribute.getName().toLowerCase(), attribute.getData());
			}
			lst.add(map);
		}
		return lst;
	}

	/**
	 * 
	 * @Title: dom2Map   
	 * @Description: Document to map
	 * @param: @param doc
	 * @param: @return      
	 * @return: Map<String,Object>      
	 * @throws
	 */
	public static Map<String, Object> dom2Map(Document doc) {
		Map<String, Object> maproot = new HashMap<String, Object>();
		if (doc == null) {
			return maproot;
		}
		Element root = doc.getRootElement();

		List list1 = root.elements();
		for (Object obj : list1) {
			Element element = (Element) obj;
			Map<String, Object> map = new HashMap<String, Object>();
			element2Map(element, map);
			maproot.put(element.getName(), map);
		}
		return maproot;
	}

	/**
	 * 
	 * @Title: element2Map   
	 * @Description: Element to map 
	 * @param: @param e
	 * @param: @param map      
	 * @return: void      
	 * @throws
	 */
	public static void element2Map(Element e, Map<String, Object> map) {
		List<Element> list = e.elements();
		if (e.attributeCount() > 0) {
			for (Object attri : e.attributes()) {
				Attribute at = (Attribute) attri;
				map.put(at.getName(), at.getValue());
			}
		}
		if (list.size() < 1 && DataUtil.isEmpty(e.getText())) {
			return;
		} else if (list.size() < 1 && !DataUtil.isEmpty(e.getText())) {
			map.put("text", e.getText());
		}
		for (Object aList : list) {
			Element iter = (Element) aList;
			Map<String, Object> cMap = new HashMap<String, Object>();
			element2Map(iter, cMap);
			map.put(iter.getName(), cMap);
		}
	}

	/**
	 * 
	 * @Title: MqResToDto   
	 * @Description: 将mq查询结果包装成list--dto的形式，dto内容为item中的内容  
	 * @param: @param recv
	 * @param: @return      
	 * @return: Map      
	 * @throws
	 */
	public static Map MqResToDto(String recv) {
		List res = new ArrayList();
		Map map = new HashMap();
		try {
			Document doc = DocumentHelper.parseText(recv);
			List list = doc.selectNodes("//item");
			for (DefaultElement aList : (Iterable<DefaultElement>) list) {
				Map elementdto = XmlUtil.Dom2Map(aList);
				res.add(elementdto);
			}
			map.put("resultList", res);// 放入结果集

			/*
			 * 如果存在REC_MNT，说明是分页查询类，需要将总记录数返回
			 */
			Node de = doc.selectSingleNode("//REC_MNT");
			if (DataUtil.isNotEmpty(de)) {
				map.put("countInteger", de.getText());
			}
		} catch (Exception e) {
			log.error(XmlUtil.class, e);
		}
		return map;
	}

}