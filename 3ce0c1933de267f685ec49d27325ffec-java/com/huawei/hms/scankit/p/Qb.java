package com.huawei.hms.scankit.p;

import java.nio.charset.StandardCharsets;
/* compiled from: EncoderContext.java */
/* loaded from: classes2.dex */
final class Qb {

    /* renamed from: a  reason: collision with root package name */
    private final String f14622a;

    /* renamed from: b  reason: collision with root package name */
    private Ub f14623b;

    /* renamed from: c  reason: collision with root package name */
    private C0639wb f14624c;

    /* renamed from: d  reason: collision with root package name */
    private C0639wb f14625d;

    /* renamed from: e  reason: collision with root package name */
    private final StringBuilder f14626e;

    /* renamed from: f  reason: collision with root package name */
    int f14627f;

    /* renamed from: g  reason: collision with root package name */
    private int f14628g;

    /* renamed from: h  reason: collision with root package name */
    private Tb f14629h;

    /* renamed from: i  reason: collision with root package name */
    private int f14630i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Qb(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb2 = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i10 = 0; i10 < length; i10++) {
            char c10 = (char) (bytes[i10] & 255);
            if (c10 != '?' || str.charAt(i10) == '?') {
                sb2.append(c10);
            } else {
                try {
                    throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
                } catch (Exception e10) {
                    throw e10;
                }
            }
        }
        this.f14622a = sb2.toString();
        this.f14623b = Ub.FORCE_NONE;
        this.f14626e = new StringBuilder(str.length());
        this.f14628g = -1;
    }

    private int l() {
        return this.f14622a.length() - this.f14630i;
    }

    public void a(Ub ub2) {
        this.f14623b = ub2;
    }

    public StringBuilder b() {
        return this.f14626e;
    }

    public char c() {
        return this.f14622a.charAt(this.f14627f);
    }

    public String d() {
        return this.f14622a;
    }

    public int e() {
        return this.f14628g;
    }

    public int f() {
        return l() - this.f14627f;
    }

    public Tb g() {
        return this.f14629h;
    }

    public boolean h() {
        return this.f14627f < l();
    }

    public void i() {
        this.f14628g = -1;
    }

    public void j() {
        this.f14629h = null;
    }

    public void k() {
        c(a());
    }

    public void a(C0639wb wbVar, C0639wb wbVar2) {
        this.f14624c = wbVar;
        this.f14625d = wbVar2;
    }

    public void b(int i10) {
        this.f14628g = i10;
    }

    public void c(int i10) {
        Tb tb2 = this.f14629h;
        if (tb2 == null || i10 > tb2.a()) {
            this.f14629h = Tb.a(i10, this.f14623b, this.f14624c, this.f14625d, true);
        }
    }

    public void a(int i10) {
        this.f14630i = i10;
    }

    public void a(String str) {
        this.f14626e.append(str);
    }

    public void a(char c10) {
        this.f14626e.append(c10);
    }

    public int a() {
        return this.f14626e.length();
    }
}
