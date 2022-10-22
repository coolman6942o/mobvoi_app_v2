package com.huawei.hms.scankit.p;
/* compiled from: ModulusGF.java */
/* renamed from: com.huawei.hms.scankit.p.aa  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0564aa {

    /* renamed from: a  reason: collision with root package name */
    public static final C0564aa f14734a = new C0564aa(929, 3);

    /* renamed from: b  reason: collision with root package name */
    private final int[] f14735b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f14736c;

    /* renamed from: d  reason: collision with root package name */
    private final C0568ba f14737d;

    /* renamed from: e  reason: collision with root package name */
    private final C0568ba f14738e;

    /* renamed from: f  reason: collision with root package name */
    private final int f14739f;

    private C0564aa(int i10, int i11) {
        this.f14739f = i10;
        this.f14735b = new int[i10];
        this.f14736c = new int[i10];
        int i12 = 1;
        for (int i13 = 0; i13 < i10; i13++) {
            this.f14735b[i13] = i12;
            i12 = (i12 * i11) % i10;
        }
        for (int i14 = 0; i14 < i10 - 1; i14++) {
            this.f14736c[this.f14735b[i14]] = i14;
        }
        this.f14737d = new C0568ba(this, new int[]{0});
        this.f14738e = new C0568ba(this, new int[]{1});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0568ba a() {
        return this.f14738e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0568ba b(int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        } else if (i11 == 0) {
            return this.f14737d;
        } else {
            int[] iArr = new int[i10 + 1];
            iArr[0] = i11;
            return new C0568ba(this, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0568ba c() {
        return this.f14737d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d(int i10, int i11) {
        int i12 = this.f14739f;
        return ((i10 + i12) - i11) % i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i10, int i11) {
        return (i10 + i11) % this.f14739f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i10) {
        if (i10 != 0) {
            return this.f14736c[i10];
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i10) {
        return this.f14735b[i10];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i10, int i11) {
        if (i10 <= 0 || i11 <= 0) {
            return 0;
        }
        int[] iArr = this.f14735b;
        int[] iArr2 = this.f14736c;
        return iArr[(iArr2[i10] + iArr2[i11]) % (this.f14739f - 1)];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i10) {
        if (i10 != 0) {
            return this.f14735b[(this.f14739f - this.f14736c[i10]) - 1];
        }
        throw new ArithmeticException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f14739f;
    }
}
