package com.huawei.hms.scankit.p;
/* compiled from: Codeword.java */
/* loaded from: classes2.dex */
final class S {

    /* renamed from: a  reason: collision with root package name */
    private final int f14636a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14637b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14638c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14639d;

    /* renamed from: e  reason: collision with root package name */
    private int f14640e = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public S(int i10, int i11, int i12, int i13) {
        this.f14636a = i10;
        this.f14637b = i11;
        this.f14638c = i12;
        this.f14639d = i13;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i10) {
        return i10 != -1 && this.f14638c == (i10 % 3) * 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f14637b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f14640e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f14636a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f14639d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f14637b - this.f14636a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return a(this.f14640e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        this.f14640e = ((this.f14639d / 30) * 3) + (this.f14638c / 3);
    }

    public String toString() {
        return this.f14640e + "|" + this.f14639d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f14638c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i10) {
        this.f14640e = i10;
    }
}
