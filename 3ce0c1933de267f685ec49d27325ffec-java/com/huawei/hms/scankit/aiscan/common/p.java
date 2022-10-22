package com.huawei.hms.scankit.aiscan.common;

import com.huawei.hms.scankit.p.C0634v;
/* compiled from: Patch.java */
/* loaded from: classes2.dex */
public class p implements Comparable<p> {

    /* renamed from: a  reason: collision with root package name */
    public C0634v f14255a;

    /* renamed from: b  reason: collision with root package name */
    public int f14256b;

    public p(C0634v vVar, int i10) {
        this.f14255a = vVar;
        this.f14256b = i10;
    }

    /* renamed from: a */
    public int compareTo(p pVar) {
        return Float.compare((-pVar.f14255a.g()) + pVar.f14255a.h(), (-this.f14255a.g()) + this.f14255a.h());
    }
}
