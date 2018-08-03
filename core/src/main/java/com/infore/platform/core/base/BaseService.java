package com.infore.platform.core.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.infore.platform.core.common.utils.map.MapUtils;
import com.infore.platform.core.exception.ServerRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.infore.platform.core.constants.PlatformConstans.*;


public abstract class BaseService<T> extends BaseComponent implements IBaseService {

    @Autowired
    protected SessionToken token;

    @Value("${user.max.page.size:50}")
    private Integer maxPageSize;

    protected static final List<Map<String, Object>> EMPTY_LIST = new ArrayList<>();
    protected static final Map<String, Object> EMPTY_MAP= new HashMap<>();

    /**
     * 获取mapper
     *
     * @return
     */
    protected abstract IBaseDao<T> getMapper();

    @Override
    public Response deleteByPrimaryKey(String id) throws ServerRuntimeException {
        try {
            int i = getMapper().deleteByPrimaryKey(id);
            if (i != 1) {
                error("Delete {} unsuccessfully.", id);
                return Response.fail();
            }
            info("Delete {} successfully.", id);
            return Response.ok();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerRuntimeException("Internal Exception");
        }
    }

    @Override
    public Response insert(Map<String, Object> record) throws ServerRuntimeException {
        try {
            String id = this.uuidGenerator.getId();
            record.put(ID, id);
            this.formatCommonColumn(this.token.getLoginName(), record);
            int i = getMapper().insert(record);
            if (i != 1) {
                error("Insert for id {} unsuccessfully.", id);
                return Response.fail();
            }
            info("Insert for id {} successfully.", id);
            return Response.ok(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerRuntimeException("Internal Exception");
        }
    }

    @Override
    public Response selectByPrimaryKey(String id) throws ServerRuntimeException {
        try {
            Map<String, Object> record = getMapper().selectByPrimaryKey(id);
            if (record == null) {
                info("Not found {}.", id);
                return Response.ok(EMPTY_MAP);
            }
            info("Get recode for {} successfully.", id);
            MapUtils.dateTimeFormat(record);
            return Response.ok(record);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerRuntimeException("Internal Exception");
        }
    }

    @Override
    public Response updateByPrimaryKey(Map<String, Object> record) throws ServerRuntimeException {
        try {
            this.formatUpdateCommonColumn(this.token.getLoginName(), record);
            int i = getMapper().updateByPrimaryKey(record);
            if (i != 1) {
                error("Update {} unsuccessfully.", record);
                return Response.fail();
            }
            info("Update {} successfully.", record.get("ID"));
            return Response.ok();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerRuntimeException("Internal Exception");
        }
    }

    @Override
    public Response updateAllColumnByPrimaryKey(Map<String, Object> record) throws ServerRuntimeException {
        try {
            this.formatUpdateCommonColumn(this.token.getLoginName(), record);
            int i = getMapper().updateAllColumnByPrimaryKey(record);
            if (i != 1) {
                error("Update {} all column unsuccessfully.", record);
                return Response.fail();
            }
            info("Update {} all column successfully.", record.get("ID"));
            return Response.ok();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerRuntimeException("Internal Exception");
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public Response selectListByPagination(Map<String, Object> paramsMap) throws ServerRuntimeException {
        try {
            if (paramsMap.get(PAGE_INDEX) == null || paramsMap.get(PAGE_SIZE) == null) {
                error("pageIndex and pageSize is null");
                return Response.fail("pageIndex and pageSize is null");
            }

            String pageSizeStr = paramsMap.get(PAGE_SIZE).toString();
            Integer pageSize = Integer.valueOf(pageSizeStr);
            if (maxPageSize >= 0 && pageSize > maxPageSize) {
                warn("Page size {} is to bigger, use default {}.", pageSize, maxPageSize);
                pageSize = maxPageSize;
            }
            String pageIndex = paramsMap.get(PAGE_INDEX).toString();
            String orderBy = (String) paramsMap.get(ORDER_BY);
            //orderBy = StringUtils.isBlank(orderBy) ? "CREATE_TIME DESC" : orderBy;
            if (orderBy != null && !"".equals(orderBy)) {
                PageHelper.startPage(Integer.valueOf(pageIndex), pageSize, orderBy);
            } else {
                PageHelper.startPage(Integer.valueOf(pageIndex), pageSize);
            }
            List<Map<String, Object>> list = getMapper().selectListByPagination(paramsMap);
            if (list == null || list.isEmpty()) {
                info("There is no page index {} size {}).", pageIndex, pageSize);
                return Response.ok(EMPTY_MAP);
            }

            // 格式化时间
            MapUtils.dataFormat4List(list);
            // 总计数
            long total = new PageInfo(list).getTotal();
            Map<String, Object> map = new HashMap<>();
            map.put(TOTAL_COUNT, total);
            map.put(LIST_DATA, list);
            info("There get {} page index {} size {}).", list.size(), pageIndex, pageSize);
            return Response.ok(map);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerRuntimeException("Internal Exception");
        }
    }

    @Override
    public int queryCount(Map<String, Object> paramsMap) throws ServerRuntimeException {
        try {
            return getMapper().queryCount(paramsMap);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerRuntimeException("Internal Exception");
        }
    }

    protected void formatCommonColumn(String uid, Map<String, Object> record) {
        record.put(CREATE_USER, uid);
        record.put(UPDATE_USER, uid);
        Timestamp now = Timestamp.from(Instant.now());
        record.put(CREATE_TIME, now);
        record.put(UPDATE_TIME, now);
    }

    protected void formatUpdateCommonColumn(String uid, Map<String, Object> record) {
        Timestamp now = Timestamp.from(Instant.now());
        record.put(UPDATE_USER, uid);
        record.put(UPDATE_TIME, now);
    }

}
