package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.z;
/* compiled from: FinderPattern.java */
/* loaded from: classes2.dex */
public final class Aa extends z {

    /* renamed from: e  reason: collision with root package name */
    private final float f14432e;

    /* renamed from: f  reason: collision with root package name */
    private final int f14433f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f14434g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Aa(float f10, float f11, float f12, boolean z10) {
        this(f10, f11, f12, z10, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(float f10, float f11, float f12) {
        if (Math.abs(f11 - c()) > f10 || Math.abs(f12 - b()) > f10) {
            return false;
        }
        float abs = Math.abs(f10 - this.f14432e);
        return abs <= 1.0f || abs <= this.f14432e;
    }

    @Override // com.huawei.hms.scankit.aiscan.common.z
    public boolean d() {
        return this.f14434g;
    }

    public float e() {
        return this.f14432e;
    }

    public Aa(float f10, float f11, float f12, boolean z10, int i10) {
        super(f10, f11, i10);
        this.f14432e = f12;
        this.f14433f = i10;
        this.f14434g = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Aa a(float f10, float f11, float f12, boolean z10) {
        int i10 = this.f14433f;
        int i11 = i10 + 1;
        float b10 = (i10 * b()) + f11;
        float f13 = i11;
        float f14 = b10 / f13;
        float c10 = ((this.f14433f * c()) + f10) / f13;
        float f15 = ((this.f14433f * this.f14432e) + f12) / f13;
        boolean z11 = this.f14434g;
        return new Aa(f14, c10, f15, z11 ? z10 : z11, i11);
    }
}
