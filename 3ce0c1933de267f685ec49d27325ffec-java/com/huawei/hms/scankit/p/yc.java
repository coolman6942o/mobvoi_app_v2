package com.huawei.hms.scankit.p;
/* compiled from: QRCode.java */
/* loaded from: classes2.dex */
public final class yc {

    /* renamed from: a  reason: collision with root package name */
    private Fa f15016a;

    /* renamed from: b  reason: collision with root package name */
    private EnumC0647za f15017b;

    /* renamed from: c  reason: collision with root package name */
    private Ia f15018c;

    /* renamed from: d  reason: collision with root package name */
    private int f15019d = -1;

    /* renamed from: e  reason: collision with root package name */
    private sc f15020e;

    public static boolean a(int i10) {
        return i10 >= 0 && i10 < 8;
    }

    public sc a() {
        return this.f15020e;
    }

    public void b(int i10) {
        this.f15019d = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(200);
        sb2.append("<<\n");
        sb2.append(" mode: ");
        sb2.append(this.f15016a);
        sb2.append("\n ecLevel: ");
        sb2.append(this.f15017b);
        sb2.append("\n version: ");
        sb2.append(this.f15018c);
        sb2.append("\n maskPattern: ");
        sb2.append(this.f15019d);
        sb2.append(">>\n");
        return sb2.toString();
    }

    public void a(Fa fa2) {
        this.f15016a = fa2;
    }

    public void a(EnumC0647za zaVar) {
        this.f15017b = zaVar;
    }

    public void a(Ia ia2) {
        this.f15018c = ia2;
    }

    public void a(sc scVar) {
        this.f15020e = scVar;
    }
}
