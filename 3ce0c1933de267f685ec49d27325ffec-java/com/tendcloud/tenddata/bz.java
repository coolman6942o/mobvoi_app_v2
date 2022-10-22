package com.tendcloud.tenddata;

import android.os.Process;
import java.util.Properties;
import java.util.zip.CRC32;
/* compiled from: td */
/* loaded from: classes2.dex */
public class bz extends Properties implements Comparable<bz> {

    /* renamed from: a  reason: collision with root package name */
    private String f22779a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f22780b;

    /* renamed from: c  reason: collision with root package name */
    private int f22781c;

    /* renamed from: d  reason: collision with root package name */
    private int f22782d;

    /* renamed from: e  reason: collision with root package name */
    private CRC32 f22783e;

    /* compiled from: td */
    /* loaded from: classes2.dex */
    public static final class a {
        public static final String DATA = "data";
        public static final String LENGTH = "length";
        public static final String RCS32 = "rcs32";
    }

    public bz(String str) {
        this.f22779a = str;
    }

    public static String a() {
        return System.currentTimeMillis() + "_" + Long.toString(Process.myPid());
    }

    public String b() {
        return this.f22779a;
    }

    public byte[] c() {
        return this.f22780b;
    }

    public int d() {
        return this.f22781c;
    }

    public int e() {
        return this.f22782d;
    }

    public final void writeData(byte[] bArr) {
        if (bArr != null) {
            if (this.f22783e == null) {
                this.f22783e = new CRC32();
            }
            byte[] bArr2 = new byte[bArr.length];
            this.f22780b = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.f22782d = this.f22780b.length;
            this.f22783e.reset();
            this.f22783e.update(this.f22780b);
            this.f22781c = (int) this.f22783e.getValue();
        }
    }

    public int a(String str, int i10) {
        String str2 = (String) setProperty(str, String.valueOf(i10));
        if (str2 == null) {
            return 0;
        }
        return Integer.parseInt(str2);
    }

    public byte[] b(String str) {
        return c(super.getProperty(str));
    }

    public byte[] c(String str) {
        if (str != null) {
            return str.getBytes();
        }
        return null;
    }

    public bz(byte[] bArr) {
        this(a(), bArr);
    }

    private bz(String str, byte[] bArr) {
        this(str);
        this.f22783e = new CRC32();
        writeData(bArr);
    }

    public byte[] a(String str, byte[] bArr) {
        String str2 = (String) setProperty(str, a(bArr));
        if (str2 == null) {
            return null;
        }
        return c(str2);
    }

    public int a(String str) {
        return Integer.parseInt(super.getProperty(str));
    }

    public String a(byte[] bArr) {
        return new String(bArr);
    }

    /* renamed from: a */
    public int compareTo(bz bzVar) {
        return b().compareTo(bzVar.b());
    }
}
