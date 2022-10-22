package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.m;
/* compiled from: Binarizer.java */
/* renamed from: com.huawei.hms.scankit.p.f  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0583f {

    /* renamed from: a  reason: collision with root package name */
    private final m f14788a;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC0583f(m mVar) {
        this.f14788a = mVar;
    }

    public abstract AbstractC0583f a(m mVar);

    public abstract C0591h a(int i10, C0591h hVar) throws C0550a;

    public abstract C0595i a() throws C0550a;

    public final int b() {
        return this.f14788a.a();
    }

    public final m c() {
        return this.f14788a;
    }

    public final int d() {
        return this.f14788a.c();
    }
}
