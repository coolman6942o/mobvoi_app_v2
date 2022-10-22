package com.laser.tsm.sdk.http;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes2.dex */
public class RequestParams {
    public static final String APPLICATION_OCTET_STREAM = "application/octet-stream";
    protected String contentEncoding;
    protected final ConcurrentHashMap<String, FileWrapper> fileParams;
    private boolean isRepeatable;
    protected final ConcurrentHashMap<String, String> urlParams;
    protected final ConcurrentHashMap<String, Object> urlParamsWithObjects;

    /* loaded from: classes2.dex */
    public static class FileWrapper {
        public final String contentType;
        public final File file;

        public FileWrapper(File file, String str) {
            this.file = file;
            this.contentType = str;
        }
    }

    public RequestParams() {
        this(null);
    }

    private HttpEntity createFormEntity() {
        try {
            return new UrlEncodedFormEntity(getParamsList(), this.contentEncoding);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public HttpEntity getEntity(ResponseHandlerInterface responseHandlerInterface) throws IOException {
        return createFormEntity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getParamString() {
        return URLEncodedUtils.format(getParamsList(), this.contentEncoding);
    }

    protected List<BasicNameValuePair> getParamsList() {
        LinkedList linkedList = new LinkedList();
        for (Map.Entry<String, String> entry : this.urlParams.entrySet()) {
            linkedList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        linkedList.addAll(getParamsList(null, this.urlParamsWithObjects));
        return linkedList;
    }

    public void put(String str, String str2) {
        if (str != null && str2 != null) {
            this.urlParams.put(str, str2);
        }
    }

    public void setHttpEntityIsRepeatable(boolean z10) {
        this.isRepeatable = z10;
    }

    public RequestParams(Map<String, String> map) {
        this.urlParams = new ConcurrentHashMap<>();
        this.urlParamsWithObjects = new ConcurrentHashMap<>();
        this.fileParams = new ConcurrentHashMap<>();
        this.contentEncoding = "UTF-8";
        this.isRepeatable = false;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void put(String str, Object obj) {
        if (str != null && obj != null) {
            this.urlParamsWithObjects.put(str, obj);
        }
    }

    public void put(String str, File file, String str2) throws FileNotFoundException {
        if (file == null || !file.exists()) {
            throw new FileNotFoundException();
        } else if (str != null) {
            this.fileParams.put(str, new FileWrapper(file, str2));
        }
    }

    private List<BasicNameValuePair> getParamsList(String str, Object obj) {
        Object obj2;
        LinkedList linkedList = new LinkedList();
        if (obj instanceof Map) {
            Map map = (Map) obj;
            ArrayList arrayList = new ArrayList(map.keySet());
            Collections.sort(arrayList);
            for (Object obj3 : arrayList) {
                if ((obj3 instanceof String) && (obj2 = map.get(obj3)) != null) {
                    linkedList.addAll(getParamsList(str == null ? (String) obj3 : String.format("%s[%s]", str, obj3), obj2));
                }
            }
        } else if (obj instanceof List) {
            List list = (List) obj;
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                linkedList.addAll(getParamsList(String.format("%s[%d]", str, Integer.valueOf(i10)), list.get(i10)));
            }
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            for (int i11 = 0; i11 < length; i11++) {
                linkedList.addAll(getParamsList(String.format("%s[%d]", str, Integer.valueOf(i11)), objArr[i11]));
            }
        } else if (obj instanceof Set) {
            for (Object obj4 : (Set) obj) {
                linkedList.addAll(getParamsList(str, obj4));
            }
        } else {
            linkedList.add(new BasicNameValuePair(str, obj.toString()));
        }
        return linkedList;
    }

    public void put(String str, int i10) {
        if (str != null) {
            this.urlParams.put(str, String.valueOf(i10));
        }
    }

    public void put(String str, long j10) {
        if (str != null) {
            this.urlParams.put(str, String.valueOf(j10));
        }
    }
}
