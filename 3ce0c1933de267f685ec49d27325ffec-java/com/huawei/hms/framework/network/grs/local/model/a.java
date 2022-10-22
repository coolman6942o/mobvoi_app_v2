package com.huawei.hms.framework.network.grs.local.model;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f13963a;

    /* renamed from: b  reason: collision with root package name */
    private long f13964b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, c> f13965c = new HashMap(16);

    public c a(String str) {
        return this.f13965c.get(str);
    }

    public String a() {
        return this.f13963a;
    }

    public void a(long j10) {
        this.f13964b = j10;
    }

    public void a(String str, c cVar) {
        this.f13965c.put(str, cVar);
    }

    public Map<String, c> b() {
        return this.f13965c;
    }

    public void b(String str) {
        this.f13963a = str;
    }
}
