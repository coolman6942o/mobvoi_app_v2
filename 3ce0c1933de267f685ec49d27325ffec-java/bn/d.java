package bn;

import android.graphics.Bitmap;
/* loaded from: classes2.dex */
public class d implements Comparable<d> {

    /* renamed from: a  reason: collision with root package name */
    private String f5284a;

    /* renamed from: b  reason: collision with root package name */
    private String f5285b;

    /* renamed from: c  reason: collision with root package name */
    private String f5286c;

    /* renamed from: d  reason: collision with root package name */
    private String f5287d;

    /* renamed from: e  reason: collision with root package name */
    private String f5288e;

    /* renamed from: f  reason: collision with root package name */
    private String f5289f;

    /* renamed from: g  reason: collision with root package name */
    private String f5290g;

    /* renamed from: h  reason: collision with root package name */
    private int f5291h;

    public d() {
        this.f5284a = "0";
        this.f5285b = "2";
        this.f5286c = "240*240";
        this.f5287d = "";
        this.f5288e = "";
        this.f5289f = "";
        this.f5290g = "";
        this.f5291h = 0;
    }

    public d(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10) {
        this.f5284a = "0";
        this.f5285b = "2";
        this.f5286c = "240*240";
        this.f5287d = "";
        this.f5288e = "";
        this.f5289f = "";
        this.f5290g = "";
        this.f5291h = 0;
        this.f5284a = str;
        this.f5285b = str2;
        this.f5286c = str3;
        this.f5287d = str4;
        this.f5288e = str5;
        this.f5289f = str6;
        this.f5290g = str7;
        this.f5291h = i10;
    }

    /* renamed from: a */
    public int compareTo(d dVar) {
        return (!m.o().u(f()) || !m.o().u(dVar.f())) ? f().compareTo(dVar.f()) : Integer.parseInt(f()) - Integer.parseInt(dVar.f());
    }

    public String b() {
        return this.f5289f;
    }

    public String c() {
        return this.f5286c;
    }

    public String d() {
        return this.f5287d;
    }

    public String e() {
        return this.f5290g;
    }

    public String f() {
        return this.f5284a;
    }

    public String g() {
        return this.f5288e;
    }

    public int h() {
        return this.f5291h;
    }

    public String i() {
        return this.f5285b;
    }

    public void j(Bitmap bitmap) {
    }

    public void k(String str) {
        this.f5289f = str;
    }

    public void l(String str) {
        this.f5286c = str;
    }

    public void m(String str) {
        this.f5287d = str;
    }

    public void n(String str) {
        this.f5290g = str;
    }

    public void q(String str) {
        this.f5284a = str;
    }

    public void u(String str) {
        this.f5288e = str;
    }

    public void v(int i10) {
        this.f5291h = i10;
    }

    public void w(String str) {
        this.f5285b = str;
    }
}
