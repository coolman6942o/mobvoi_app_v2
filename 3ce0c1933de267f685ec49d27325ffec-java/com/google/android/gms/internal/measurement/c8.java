package com.google.android.gms.internal.measurement;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c8 extends a8 {

    /* renamed from: a  reason: collision with root package name */
    private int f9207a;

    /* renamed from: b  reason: collision with root package name */
    private int f9208b;

    /* renamed from: c  reason: collision with root package name */
    private int f9209c;

    /* renamed from: d  reason: collision with root package name */
    private int f9210d;

    /* renamed from: e  reason: collision with root package name */
    private int f9211e;

    private c8(byte[] bArr, int i10, int i11, boolean z10) {
        super();
        this.f9211e = Integer.MAX_VALUE;
        this.f9207a = i11 + i10;
        this.f9209c = i10;
        this.f9210d = i10;
    }

    private final void d() {
        int i10 = this.f9207a + this.f9208b;
        this.f9207a = i10;
        int i11 = i10 - this.f9210d;
        int i12 = this.f9211e;
        if (i11 > i12) {
            int i13 = i11 - i12;
            this.f9208b = i13;
            this.f9207a = i10 - i13;
            return;
        }
        this.f9208b = 0;
    }

    @Override // com.google.android.gms.internal.measurement.a8
    public final int b() {
        return this.f9209c - this.f9210d;
    }

    public final int c(int i10) throws zzzt {
        if (i10 >= 0) {
            int b10 = i10 + b();
            int i11 = this.f9211e;
            if (b10 <= i11) {
                this.f9211e = b10;
                d();
                return i11;
            }
            throw zzzt.a();
        }
        throw zzzt.b();
    }
}
