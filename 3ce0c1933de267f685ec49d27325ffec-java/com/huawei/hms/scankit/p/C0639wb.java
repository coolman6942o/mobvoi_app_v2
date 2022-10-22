package com.huawei.hms.scankit.p;
/* compiled from: Dimension.java */
/* renamed from: com.huawei.hms.scankit.p.wb  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0639wb {

    /* renamed from: a  reason: collision with root package name */
    private final int f14997a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14998b;

    public int a() {
        return this.f14998b;
    }

    public int b() {
        return this.f14997a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0639wb)) {
            return false;
        }
        C0639wb wbVar = (C0639wb) obj;
        return this.f14997a == wbVar.f14997a && this.f14998b == wbVar.f14998b;
    }

    public int hashCode() {
        return (this.f14997a * 32713) + this.f14998b;
    }

    public String toString() {
        return this.f14997a + "x" + this.f14998b;
    }
}
