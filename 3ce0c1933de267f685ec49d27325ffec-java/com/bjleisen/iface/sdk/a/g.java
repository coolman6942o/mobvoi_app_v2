package com.bjleisen.iface.sdk.a;

import java.io.File;
import java.io.FileNotFoundException;
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
/* compiled from: RequestParams.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7654a = "application/octet-stream";

    /* renamed from: b  reason: collision with root package name */
    protected final ConcurrentHashMap<String, String> f7655b;

    /* renamed from: c  reason: collision with root package name */
    protected final ConcurrentHashMap<String, Object> f7656c;

    /* renamed from: d  reason: collision with root package name */
    protected final ConcurrentHashMap<String, a> f7657d;

    /* renamed from: e  reason: collision with root package name */
    protected String f7658e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7659f;

    /* compiled from: RequestParams.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final File f7660a;

        /* renamed from: b  reason: collision with root package name */
        public final String f7661b;

        public a(File file, String str) {
            this.f7660a = file;
            this.f7661b = str;
        }
    }

    public g() {
        this((byte) 0);
    }

    private void a(String str, String str2) {
        if (str != null && str2 != null) {
            this.f7655b.put(str, str2);
        }
    }

    private List<BasicNameValuePair> b(String str, Object obj) {
        Object obj2;
        LinkedList linkedList = new LinkedList();
        if (obj instanceof Map) {
            Map map = (Map) obj;
            ArrayList arrayList = new ArrayList(map.keySet());
            Collections.sort(arrayList);
            for (Object obj3 : arrayList) {
                if ((obj3 instanceof String) && (obj2 = map.get(obj3)) != null) {
                    linkedList.addAll(b(str == null ? (String) obj3 : String.format("%s[%s]", str, obj3), obj2));
                }
            }
        } else if (obj instanceof List) {
            List list = (List) obj;
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                linkedList.addAll(b(String.format("%s[%d]", str, Integer.valueOf(i10)), list.get(i10)));
            }
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            for (int i11 = 0; i11 < length; i11++) {
                linkedList.addAll(b(String.format("%s[%d]", str, Integer.valueOf(i11)), objArr[i11]));
            }
        } else if (obj instanceof Set) {
            for (Object obj4 : (Set) obj) {
                linkedList.addAll(b(str, obj4));
            }
        } else {
            linkedList.add(new BasicNameValuePair(str, obj.toString()));
        }
        return linkedList;
    }

    private List<BasicNameValuePair> c() {
        LinkedList linkedList = new LinkedList();
        for (Map.Entry<String, String> entry : this.f7655b.entrySet()) {
            linkedList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        linkedList.addAll(b(null, this.f7656c));
        return linkedList;
    }

    private HttpEntity d() {
        try {
            return new UrlEncodedFormEntity(c(), this.f7658e);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    private g(byte b10) {
        this.f7655b = new ConcurrentHashMap<>();
        this.f7656c = new ConcurrentHashMap<>();
        this.f7657d = new ConcurrentHashMap<>();
        this.f7658e = "UTF-8";
        this.f7659f = false;
    }

    private void a(String str, Object obj) {
        if (str != null && obj != null) {
            this.f7656c.put(str, obj);
        }
    }

    private void a(String str, File file, String str2) {
        if (file == null || !file.exists()) {
            throw new FileNotFoundException();
        } else if (str != null) {
            this.f7657d.put(str, new a(file, str2));
        }
    }

    private void a(String str, int i10) {
        if (str != null) {
            this.f7655b.put(str, String.valueOf(i10));
        }
    }

    private void a(String str, long j10) {
        if (str != null) {
            this.f7655b.put(str, String.valueOf(j10));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String a() {
        return URLEncodedUtils.format(c(), this.f7658e);
    }

    private void a(boolean z10) {
        this.f7659f = z10;
    }

    public final HttpEntity b() {
        return d();
    }
}
