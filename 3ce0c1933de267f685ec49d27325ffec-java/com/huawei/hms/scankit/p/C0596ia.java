package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.z;
/* compiled from: AlignmentPattern.java */
/* renamed from: com.huawei.hms.scankit.p.ia  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0596ia extends z {

    /* renamed from: e  reason: collision with root package name */
    private final float f14815e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0596ia(float f10, float f11, float f12) {
        super(f10, f11);
        this.f14815e = f12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(float f10, float f11, float f12) {
        if (Math.abs(f11 - c()) > f10 || Math.abs(f12 - b()) > f10) {
            return false;
        }
        float abs = Math.abs(f10 - this.f14815e);
        return abs <= 1.0f || abs <= this.f14815e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0596ia b(float f10, float f11, float f12) {
        return new C0596ia((b() + f11) / 2.0f, (c() + f10) / 2.0f, (this.f14815e + f12) / 2.0f);
    }
}
