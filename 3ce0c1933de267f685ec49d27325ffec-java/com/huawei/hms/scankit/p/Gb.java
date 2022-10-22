package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.util.b;
import java.util.LinkedList;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: State.java */
/* loaded from: classes2.dex */
public final class Gb {

    /* renamed from: a  reason: collision with root package name */
    static final Gb f14533a = new Gb(Hb.f14540a, 0, 0, 0);

    /* renamed from: b  reason: collision with root package name */
    private final int f14534b;

    /* renamed from: c  reason: collision with root package name */
    private final Hb f14535c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14536d;

    /* renamed from: e  reason: collision with root package name */
    private final int f14537e;

    private Gb(Hb hb2, int i10, int i11, int i12) {
        this.f14535c = hb2;
        this.f14534b = i10;
        this.f14536d = i11;
        this.f14537e = i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f14536d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f14537e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f14534b;
    }

    public String toString() {
        try {
            String[] strArr = Eb.f14508a;
            if (b.a(strArr, this.f14534b)) {
                return String.format(Locale.ENGLISH, "%s bits=%d bytes=%d", strArr[this.f14534b], Integer.valueOf(this.f14537e), Integer.valueOf(this.f14536d));
            }
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e10) {
            throw e10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Gb a(int i10, int i11) {
        int i12 = this.f14537e;
        Hb hb2 = this.f14535c;
        int i13 = this.f14534b;
        if (i10 != i13) {
            int i14 = Eb.f14509b[i13][i10];
            int i15 = 65535 & i14;
            int i16 = i14 >> 16;
            hb2 = hb2.a(i15, i16);
            i12 += i16;
        }
        int i17 = i10 == 2 ? 4 : 5;
        return new Gb(hb2.a(i11, i17), i10, 0, i12 + i17);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Gb b(int i10, int i11) {
        Hb hb2 = this.f14535c;
        int i12 = this.f14534b;
        int i13 = i12 == 2 ? 4 : 5;
        if (i12 >= 0) {
            int[][] iArr = Eb.f14511d;
            if (i12 < iArr.length && i10 > 0 && i10 < iArr[i12].length) {
                hb2 = hb2.a(iArr[i12][i10], i13);
            }
        }
        return new Gb(hb2.a(i11, 5), this.f14534b, 0, this.f14537e + i13 + 5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Gb a(int i10) {
        Hb hb2 = this.f14535c;
        int i11 = this.f14534b;
        int i12 = this.f14537e;
        if (i11 == 4 || i11 == 2) {
            int i13 = Eb.f14509b[i11][0];
            int i14 = 65535 & i13;
            int i15 = i13 >> 16;
            hb2 = hb2.a(i14, i15);
            i12 += i15;
            i11 = 0;
        }
        int i16 = this.f14536d;
        Gb gb2 = new Gb(hb2, i11, i16 + 1, i12 + ((i16 == 0 || i16 == 31) ? 18 : i16 == 62 ? 9 : 8));
        return gb2.f14536d == 2078 ? gb2.b(i10 + 1) : gb2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Gb b(int i10) {
        int i11 = this.f14536d;
        return i11 == 0 ? this : new Gb(this.f14535c.b(i10 - i11, i11), this.f14534b, 0, this.f14537e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Gb gb2) {
        int i10;
        int i11 = this.f14537e + (Eb.f14509b[this.f14534b][gb2.f14534b] >> 16);
        int i12 = gb2.f14536d;
        if (i12 > 0 && ((i10 = this.f14536d) == 0 || i10 > i12)) {
            i11 += 10;
        }
        return i11 <= gb2.f14537e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0591h a(byte[] bArr) {
        LinkedList<Hb> linkedList = new LinkedList();
        for (Hb hb2 = b(bArr.length).f14535c; hb2 != null; hb2 = hb2.a()) {
            linkedList.addFirst(hb2);
        }
        C0591h hVar = new C0591h();
        for (Hb hb3 : linkedList) {
            hb3.a(hVar, bArr);
        }
        return hVar;
    }
}
