package com.huawei.hms.scankit.aiscan.common;

import com.huawei.hms.scankit.p.C0595i;
/* compiled from: DetectorResult.java */
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final C0595i f14216a;

    /* renamed from: b  reason: collision with root package name */
    private final z[] f14217b;

    /* renamed from: c  reason: collision with root package name */
    private z[] f14218c;

    /* renamed from: d  reason: collision with root package name */
    private float f14219d;

    public g(C0595i iVar, z[] zVarArr) {
        this.f14218c = null;
        this.f14216a = iVar;
        this.f14217b = zVarArr;
    }

    public final C0595i a() {
        return this.f14216a;
    }

    public z[] b() {
        return this.f14218c;
    }

    public float c() {
        return this.f14219d;
    }

    public final z[] d() {
        return this.f14217b;
    }

    public g(C0595i iVar, z[] zVarArr, z[] zVarArr2, float f10) {
        this.f14218c = null;
        this.f14216a = iVar;
        this.f14217b = zVarArr;
        this.f14218c = zVarArr2;
        this.f14219d = f10;
    }
}
