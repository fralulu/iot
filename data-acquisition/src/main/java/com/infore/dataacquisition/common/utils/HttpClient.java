package com.infore.dataacquisition.common.utils;


import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import com.infore.platform.core.base.Response;
import com.infore.platform.core.common.errorcode.PlatformErrorEnum;

/**
 * All rights Reserved, Designed By www.infore.com
 *
 * @version V1.0
 * @Title: HttpClient
 * @Package com.infore.platform.common.http
 * @Description: http client
 * @author: xing.guanghui
 * @date: 2017/9/9 14:13
 * @company: 深圳盈峰环境网络技术有限公司
 * @Copyright: 2017 www.infore.com Inc. All rights reserved.
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
public class HttpClient {
    private PoolingHttpClientConnectionManager connMgr;
    private RequestConfig requestConfig;
    private final int MAX_TIMEOUT = 10000;
    private final String CODE = "UTF-8";

    {
        // 设置连接池
        connMgr = new PoolingHttpClientConnectionManager();
        // 设置连接池大小
        connMgr.setMaxTotal(100);
        connMgr.setDefaultMaxPerRoute(connMgr.getMaxTotal());

        RequestConfig.Builder configBuilder = RequestConfig.custom()
                .setConnectTimeout(MAX_TIMEOUT) // 设置连接超时
                .setSocketTimeout(MAX_TIMEOUT) // 设置读取超时
                .setConnectionRequestTimeout(MAX_TIMEOUT); // 设置从连接池获取连接实例的超时
        requestConfig = configBuilder.build();
    }

    /**
     * 填充请求头参数至get请求中
     *
     * @param httpGet http get请求
     * @param headers 请求头参数
     * @return HttpGet
     */
    private HttpGet setHeadersToGet(HttpGet httpGet, Map<String, String> headers) {
        if (headers != null && headers.size() != 0) {
            for (String key : headers.keySet()) {
                httpGet.addHeader(key, headers.get(key));
            }
        }
        return httpGet;
    }


    /**
     * 填充请求头参数至Post请求中
     *
     * @param httpPost post 请求
     * @param headers  请求头参数
     * @return HttpPost
     */
    private HttpPost setHeadersToPost(HttpPost httpPost, Map<String, String> headers) {
        if (headers != null && headers.size() != 0) {
            for (String key : headers.keySet()) {
                httpPost.addHeader(key, headers.get(key));
            }
        }
        return httpPost;
    }


    /**
     * 填充请求头参数至Put请求中
     *
     * @param httpPut put请求
     * @param headers 请求头参数
     * @return HttpPut
     */
    private HttpPut setHeadersToPut(HttpPut httpPut, Map<String, String> headers) {
        if (headers != null && headers.size() != 0) {
            for (String key : headers.keySet()) {
                httpPut.addHeader(key, headers.get(key));
            }
        }
        return httpPut;
    }


    /**
     * 填充请求体参数至Post请求中
     *
     * @param httpPost post请求
     * @param params   参数
     * @return post
     */
    private HttpPost setParamsToRequest(HttpPost httpPost, Map<String, Object> params) {

        List<NameValuePair> pairList = new ArrayList<>(params.size());
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            NameValuePair pair;
            if (entry.getValue() == null) {
                pair = new BasicNameValuePair(entry.getKey(), null);
            } else {
                pair = new BasicNameValuePair(entry.getKey(), entry
                        .getValue().toString());
            }
            pairList.add(pair);
        }
        httpPost.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName("UTF-8")));
        return httpPost;
    }


    /**
     * 发送 GET 请求（HTTP），不带输入数据
     *
     * @param url 请求url地址
     * @return Response
     */
    public Response get(String url) {
        return get(url, new HashMap<>(), new HashMap<>());
    }

    /**
     * 发送 GET 请求（HTTP）,K-V形式,无请求头参数
     *
     * @param url    请求地址
     * @param params 参数
     * @return Response
     */
    public Response get(String url, Map<String, Object> params) {
        return get(url, params, null);
    }

    /**
     * 发送 GET 请求（HTTP），K-V形式，有请求头参数
     *
     * @param url     API接口URL
     * @param params  参数map
     * @param headers 请求头参数
     * @return Response
     */
    public Response get(String url, Map<String, Object> params, Map<String, String> headers) {

        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();
        HttpGet httpGet;
        HttpResponse response = null;
        Response responseValue = new Response();
        String apiUrl = url;
        StringBuffer param = new StringBuffer();
        int i = 0;
        if (params != null && params.size() > 0) {
            for (String key : params.keySet()) {
                if (i == 0) {
                    param.append("?");
                } else {
                    param.append("&");
                }
                param.append(key).append("=").append(params.get(key));
                i++;
            }
        }
        apiUrl += param;
        String result;
        try {
            HttpEntity entity = null;
            httpGet = new HttpGet(apiUrl);
            httpGet = setHeadersToGet(httpGet, headers);
            response = httpClient.execute(httpGet);
            if (response != null) {
                entity = response.getEntity();
            }

            if (entity != null) {
                InputStream instream = entity.getContent();
                result = IOUtils.toString(instream, "UTF-8");
                responseValue.setData(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.setCode(responseValue, response);
        }
        return responseValue;
    }

    /**
     * 发送 POST 请求（HTTP），不带输入数据
     *
     * @param url 请求url地址
     * @return Response
     */
    public Response post(String url) {
        return post(url, new HashMap<>(), new HashMap<>());
    }

    /**
     * 发送 POST 请求（HTTP），JSON形式，无请求头参数
     *
     * @param url  请求url地址
     * @param json json对象
     * @return Response
     */
    public Response post(String url, Object json) {
        return post(url, json, null);
    }

    /**
     * 发送 POST 请求（HTTP）,K-V形式,无请求头参数
     *
     * @param url    请求url地址
     * @param params 请求参数
     * @return Response
     */
    public Response post(String url, Map<String, Object> params) {
        return post(url, params, null);
    }

    /**
     * 发送 POST 请求（HTTP），K-V形式 ，有请求头参数
     *
     * @param url     API接口URL
     * @param params  参数map
     * @param headers 请求头参数
     * @return Response
     */
    public Response post(String url, Map<String, Object> params, Map<String, String> headers) {
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();
        Response esponseValue = new Response();
        String httpStr = null;
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;

        try {

            httpPost.setConfig(requestConfig);
            httpPost = setHeadersToPost(httpPost, headers);
            httpPost = setParamsToRequest(httpPost, params);
            response = httpClient.execute(httpPost);
            if (response != null) {
                HttpEntity entity = response.getEntity();
                httpStr = EntityUtils.toString(entity, "UTF-8");
            }
            esponseValue.setData(httpStr);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            this.setCode(esponseValue, response);
        }
        return esponseValue;
    }

    private void setCode(Response resp, HttpResponse response) {
        if (response == null) {
            resp.setCode(PlatformErrorEnum.FAIL.getMessageCode());
            return;
        }
        int code = response.getStatusLine().getStatusCode();
        if (code == 200) {
            resp.setCode(PlatformErrorEnum.OK.getMessageCode());
            return;
        }
        resp.setCode(PlatformErrorEnum.ERROR.getMessageCode());
    }

    /**
     * 发送 POST 请求（HTTP），JSON形式，有请求头参数
     *
     * @param url     请求url地址
     * @param json    json对象
     * @param headers 请求头参数
     * @return Response
     */
    public Response post(String url, Object json, Map<String, String> headers) {
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();
        Response resp = new Response();
        String httpStr = null;
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;

        try {
            httpPost.setConfig(requestConfig);
            httpPost = setHeadersToPost(httpPost, headers);
            StringEntity stringEntity = new StringEntity(json.toString(), "UTF-8");//解决中文乱码问题
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            if (response != null) {
                HttpEntity entity = response.getEntity();
                httpStr = EntityUtils.toString(entity, "UTF-8");
            }
            resp.setData(httpStr);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            this.setCode(resp, response);
        }
        return resp;
    }

    /**
     * 发送 SSL POST 请求（HTTPS），无K-V形式参数，无请求头参数
     *
     * @param url API接口URL
     * @return Response
     */
    public Response postSSL(String url) {
        return postSSL(url, null, null);
    }

    /**
     * 发送 SSL POST 请求（HTTPS），K-V形式，无请求头参数
     *
     * @param url    API接口URL
     * @param params 参数map
     * @return Response
     */
    public Response postSSL(String url, Map<String, Object> params) {
        return postSSL(url, params, null);
    }

    /**
     * 发送 SSL POST 请求（HTTPS），K-V形式，有请求头参数
     *
     * @param url     API接口URL
     * @param params  参数map
     * @param headers 请求头参数
     * @return Response
     */
    public Response postSSL(String url, Map<String, Object> params, Map<String, String> headers) {
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(createSSLConnSocketFactory())
                .setConnectionManager(connMgr).setDefaultRequestConfig(requestConfig).build();
        Response resp = new Response();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        String httpStr;

        try {
            HttpEntity entity = null;
            httpPost.setConfig(requestConfig);

            httpPost = setHeadersToPost(httpPost, headers);
            httpPost = setParamsToRequest(httpPost, params);
            response = httpClient.execute(httpPost);
            if (response != null) {
                int statusCode = response.getStatusLine().getStatusCode();
                entity = response.getEntity();
                resp.setCode(statusCode);
                if (statusCode != HttpStatus.SC_OK || entity == null) {
                    return resp;
                }
            }
            httpStr = EntityUtils.toString(entity, "utf-8");
            resp.setData(httpStr);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return resp;
    }

    /**
     * 发送 SSL POST 请求（HTTPS），JSON形式，有请求头参数
     *
     * @param url  API接口URL
     * @param json JSON对象
     * @return Response
     */
    public Response postSSL(String url, Object json) {
        return postSSL(url, json, null);
    }

    /**
     * 发送 SSL POST 请求（HTTPS），JSON形式，有请求头参数
     *
     * @param url     API接口URL
     * @param json    JSON对象
     * @param headers 请求头参数
     * @return Response
     */
    public Response postSSL(String url, Object json, Map<String, String> headers) {
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(createSSLConnSocketFactory()).setConnectionManager(connMgr).setDefaultRequestConfig(requestConfig).build();
        Response resp = new Response();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        String httpStr = null;

        try {
            HttpEntity entity = null;
            httpPost.setConfig(requestConfig);
            httpPost = setHeadersToPost(httpPost, headers);
            StringEntity stringEntity = new StringEntity(json.toString(), "UTF-8");//解决中文乱码问题
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            if (response != null) {
                int statusCode = response.getStatusLine().getStatusCode();
                entity = response.getEntity();
                resp.setCode(statusCode);
                if (statusCode != HttpStatus.SC_OK || entity == null) {
                    return resp;
                }
            }

            httpStr = EntityUtils.toString(entity, "utf-8");
            resp.setData(httpStr);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            this.setCode(resp, response);
        }
        return resp;
    }

    /**
     * 发送 SSL GET 请求（HTTPs），无参数，无请求头参数
     *
     * @param url API接口URL
     * @return Response
     */
    public Response getSSL(String url) {
        return getSSL(url, null, null);
    }

    /**
     * 发送 SSL GET 请求（HTTPs），K-V形式，无请求头参数
     *
     * @param url    API接口URL
     * @param params 参数map
     * @return
     */
    public Response getSSL(String url, Map<String, Object> params) {
        return getSSL(url, params, null);
    }

    /**
     * 发送 SSL GET 请求（HTTPs），K-V形式，有请求头参数
     *
     * @param url     API接口URL
     * @param params  参数map
     * @param headers 请求头参数
     * @return Response
     */
    public Response getSSL(String url, Map<String, Object> params, Map<String, String> headers) {

        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(createSSLConnSocketFactory()).setConnectionManager(connMgr).setDefaultRequestConfig(requestConfig).build();
        HttpGet httpGet;
        HttpResponse response = null;
        Response resp = new Response();
        String apiUrl = url;
        StringBuffer param = new StringBuffer();
        int i = 0;
        if (params != null && params.size() > 0) {
            for (String key : params.keySet()) {
                if (i == 0) {
                    param.append("?");
                } else {
                    param.append("&");
                }
                param.append(key).append("=").append(params.get(key));
                i++;
            }
        }
        apiUrl += param;
        String result;
        try {
            HttpEntity entity = null;
            httpGet = new HttpGet(apiUrl);
            httpGet.setConfig(requestConfig);
            httpGet = setHeadersToGet(httpGet, headers);
            response = httpclient.execute(httpGet);
            if (response != null) {
                entity = response.getEntity();
            }

            if (entity != null) {
                InputStream instream = entity.getContent();
                result = IOUtils.toString(instream, "UTF-8");
                resp.setData(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            resp.setCode(response.getStatusLine().getStatusCode());
        }
        return resp;
    }


    /**
     * 发送 PUT 请求（HTTP），无参数，无请求头参数
     *
     * @param url API接口URL
     * @return Response
     */
    public Response put(String url) {
        return put(url, null, null);
    }

    /**
     * 发送 PUT 请求（HTTP），K-V形式，无请求头参数
     *
     * @param url    API接口URL
     * @param params 参数map
     * @return Response
     */
    public Response put(String url, Map<String, String> params) {
        return put(url, params, null);
    }

    /**
     * 发送 PUT 请求（HTTP），K-V形式，有请求头参数
     *
     * @param url     API接口URL
     * @param params  参数map
     * @param headers 请求头参数
     * @return Response
     */
    public Response put(String url, Map<String, String> params, Map<String, String> headers) {
        CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();
        HttpEntity entity = null;
        Response resp = new Response();
        CloseableHttpResponse response = null;
        String httpStr;
        try {
            HttpPut httpPut = new HttpPut(url);
            if (headers != null) {
                Set<String> set = headers.keySet();
                for (String item : set) {
                    String value = headers.get(item);
                    httpPut.addHeader(item, value);
                }
            }
            if (params != null) {
                List<NameValuePair> paramList = new ArrayList<>();
                for (Map.Entry<String, String> param : params.entrySet()) {
                    NameValuePair pair = new BasicNameValuePair(param.getKey(), param.getValue());
                    paramList.add(pair);
                }
                httpPut.setEntity(new UrlEncodedFormEntity(paramList, CODE));
            }
            response = client.execute(httpPut);
            if (response != null) {
                int statusCode = response.getStatusLine().getStatusCode();
                entity = response.getEntity();
                resp.setCode(statusCode);
                if (statusCode != HttpStatus.SC_OK || entity == null) {
                    return resp;
                }
            }

            httpStr = EntityUtils.toString(entity, "utf-8");
            resp.setData(httpStr);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    EntityUtils.consume(response.getEntity());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resp;
    }


    /**
     * 发送 SSL PUT 请求（HTTP），JSON形式，无请求头参数
     *
     * @param url  API接口URL
     * @param json JSON对象
     * @return Response
     */
    public Response put(String url, Object json) {
        return put(url, json, null);
    }

    /**
     * 发送 PUT 请求（HTTP），JSON形式，有请求头参数
     *
     * @param url     API接口URL
     * @param json    JSON对象
     * @param headers 请求头参数
     * @return Response
     */
    public Response put(String url, Object json, Map<String, String> headers) {
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();
        Response resp = new Response();
        HttpPut httpPut = new HttpPut(url);
        CloseableHttpResponse response = null;
        String httpStr = null;

        try {
            HttpEntity entity = null;
            httpPut.setConfig(requestConfig);
            httpPut = setHeadersToPut(httpPut, headers);
            StringEntity stringEntity = new StringEntity(json.toString(), "UTF-8");//解决中文乱码问题
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json");
            httpPut.setEntity(stringEntity);
            response = httpClient.execute(httpPut);
            if (response != null) {
                int statusCode = response.getStatusLine().getStatusCode();
                entity = response.getEntity();
                resp.setCode(statusCode);
                if (statusCode != HttpStatus.SC_OK || entity == null) {
                    return resp;
                }
            }

            httpStr = EntityUtils.toString(entity, "utf-8");
            resp.setData(httpStr);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            this.setCode(resp, response);
        }
        return resp;
    }

    /**
     * 发送 DELETE 请求（HTTP）,无参数
     *
     * @param url API接口URL
     * @return Response
     */
    public Response delete(String url) {
        return delete(url, null, null);
    }

    /**
     * 发送 DELETE 请求（HTTP），K-V形式，无请求头参数
     *
     * @param url    API接口URL
     * @param params 参数map
     * @return Response
     */
    public Response delete(String url, Map<String, String> params) {
        return delete(url, params, null);
    }

    /**
     * 发送 DELETE 请求（HTTP），K-V形式，有请求头参数
     *
     * @param url     API接口URL
     * @param params  参数map
     * @param headers 请求头参数
     * @return Response
     */
    public Response delete(String url, Map<String, String> params, Map<String, String> headers) {
        CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();
        HttpEntity entity = null;
        Response resp = new Response();
        CloseableHttpResponse response = null;
        String httpStr = null;
        try {
            HttpDelete httpDelete = new HttpDelete(url);
            if (headers != null) {
                Set<String> set = headers.keySet();
                for (String item : set) {
                    String value = headers.get(item);
                    httpDelete.addHeader(item, value);
                }
            }
            if (params != null) {
                URIBuilder uriBuilder = new URIBuilder(url);
                for (String key : params.keySet()) {
                    uriBuilder.setParameter(key, params.get(key));
                }
                URI uri = uriBuilder.build();
                httpDelete.setURI(uri);
            }
            response = client.execute(httpDelete);
            if (response != null) {
                int statusCode = response.getStatusLine().getStatusCode();
                entity = response.getEntity();
                resp.setCode(statusCode);
                if (statusCode != HttpStatus.SC_OK || entity == null) {
                    return resp;
                }
            }

            httpStr = EntityUtils.toString(entity, "utf-8");
            resp.setData(httpStr);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    EntityUtils.consume(response.getEntity());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resp;
    }

    /**
     * 创建SSL安全连接
     *
     * @return socket factory
     */
    private SSLConnectionSocketFactory createSSLConnSocketFactory()  {
        SSLConnectionSocketFactory sslsf = null;
        SSLContextBuilder builder = new SSLContextBuilder();
        try {
            // 全部信任 不做身份鉴定
            builder.loadTrustMaterial(null, (TrustStrategy) (x509Certificates, s) -> true);
            sslsf = new SSLConnectionSocketFactory(builder.build(), new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.2"}, null,
                    NoopHostnameVerifier.INSTANCE);
        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
            e.printStackTrace();
        }
        return sslsf;
    }
}
