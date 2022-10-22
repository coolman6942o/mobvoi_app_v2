package com.huawei.hms.framework.network.grs.local.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f13970a;

    /* renamed from: b  reason: collision with root package name */
    private String f13971b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, d> f13972c = new HashMap(16);

    /* renamed from: d  reason: collision with root package name */
    private List<b> f13973d = new ArrayList(16);

    public d a(String str) {
        return this.f13972c.get(str);
    }

    public List<b> a() {
        return this.f13973d;
    }

    public void a(String str, d dVar) {
        this.f13972c.put(str, dVar);
    }

    public void a(List<b> list) {
        this.f13973d = list;
    }

    public String b() {
        return this.f13970a;
    }

    public void b(String str) {
        this.f13970a = str;
    }

    public String c() {
        return this.f13971b;
    }

    public void c(String str) {
        this.f13971b = str;
    }
}
