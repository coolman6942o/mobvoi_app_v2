package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.util.b;
import java.lang.reflect.Array;
import java.util.Arrays;
/* compiled from: ByteMatrix.java */
/* loaded from: classes2.dex */
public final class sc {

    /* renamed from: a  reason: collision with root package name */
    private final byte[][] f14925a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14926b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14927c;

    public sc(int i10, int i11) {
        this.f14925a = (byte[][]) Array.newInstance(byte.class, i11, i10);
        this.f14926b = i10;
        this.f14927c = i11;
    }

    public byte a(int i10, int i11) {
        try {
            if (b.a(this.f14925a, i11) && b.a(this.f14925a[i11], i10)) {
                return this.f14925a[i11][i10];
            }
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e10) {
            throw e10;
        }
    }

    public int b() {
        return this.f14927c;
    }

    public int c() {
        return this.f14926b;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder((this.f14926b * 2 * this.f14927c) + 2);
        for (int i10 = 0; i10 < this.f14927c; i10++) {
            byte[] bArr = this.f14925a[i10];
            for (int i11 = 0; i11 < this.f14926b; i11++) {
                byte b10 = bArr[i11];
                if (b10 == 0) {
                    sb2.append(" 0");
                } else if (b10 != 1) {
                    sb2.append("  ");
                } else {
                    sb2.append(" 1");
                }
            }
            sb2.append('\n');
        }
        return sb2.toString();
    }

    public byte[][] a() {
        return this.f14925a;
    }

    public void a(int i10, int i11, int i12) {
        try {
            if (!b.a(this.f14925a, i11) || !b.a(this.f14925a[i11], i10)) {
                throw new ArrayIndexOutOfBoundsException();
            }
            this.f14925a[i11][i10] = (byte) i12;
        } catch (ArrayIndexOutOfBoundsException e10) {
            throw e10;
        }
    }

    public void a(int i10, int i11, boolean z10) {
        try {
            if (!b.a(this.f14925a, i11) || !b.a(this.f14925a[i11], i10)) {
                throw new ArrayIndexOutOfBoundsException();
            }
            this.f14925a[i11][i10] = z10 ? (byte) 1 : (byte) 0;
        } catch (ArrayIndexOutOfBoundsException e10) {
            throw e10;
        }
    }

    public void a(byte b10) {
        for (byte[] bArr : this.f14925a) {
            Arrays.fill(bArr, b10);
        }
    }
}
