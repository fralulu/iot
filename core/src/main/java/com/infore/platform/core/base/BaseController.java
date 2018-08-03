package com.infore.platform.core.base;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class BaseController extends BaseComponent {

    /**
     * request取值转换为Map
     *
     * @param request
     * @return
     */
    public Map<String, Object> getParametersMap(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        Enumeration<?> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paraName = (String) parameterNames.nextElement();
            map.put(paraName, request.getParameter(paraName) == null ? null : request.getParameter(paraName).trim());
        }
        return map;
    }
}
