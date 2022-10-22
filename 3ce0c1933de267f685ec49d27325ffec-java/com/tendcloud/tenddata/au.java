package com.tendcloud.tenddata;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* compiled from: td */
/* loaded from: classes2.dex */
public class au {

    /* renamed from: a  reason: collision with root package name */
    private int f22656a;

    /* renamed from: b  reason: collision with root package name */
    private long f22657b;

    /* renamed from: c  reason: collision with root package name */
    private List<ar> f22658c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, ar> f22659d;

    public int a() {
        return this.f22656a;
    }

    public long b() {
        return this.f22657b;
    }

    public List<ar> c() {
        return this.f22658c;
    }

    public au d() {
        au auVar = new au();
        auVar.setTimestamp(this.f22656a);
        auVar.setPoiId(this.f22657b);
        LinkedList linkedList = new LinkedList();
        for (ar arVar : this.f22658c) {
            linkedList.add(arVar.f());
        }
        auVar.setBsslist(linkedList);
        return auVar;
    }

    public void setBsslist(List<ar> list) {
        this.f22658c = list;
    }

    public void setPoiId(long j10) {
        this.f22657b = j10;
    }

    public void setTimestamp(int i10) {
        this.f22656a = i10;
    }

    public Map<String, ar> a(boolean z10) {
        if (this.f22659d == null || z10) {
            this.f22659d = new HashMap();
            for (ar arVar : this.f22658c) {
                this.f22659d.put(arVar.b(), arVar);
            }
        }
        return this.f22659d;
    }
}
