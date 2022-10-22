package com.amap.api.mapcore2d;

import android.text.TextUtils;
import k4.c;
/* compiled from: SDKInfo.java */
@o(a = "a")
/* loaded from: classes.dex */
public class f {
    @k4.f(a = "a1", b = 6)

    /* renamed from: a  reason: collision with root package name */
    private String f6969a;
    @k4.f(a = "a2", b = 6)

    /* renamed from: b  reason: collision with root package name */
    private String f6970b;
    @k4.f(a = "a4", b = 6)

    /* renamed from: c  reason: collision with root package name */
    private String f6971c;
    @k4.f(a = "a5", b = 6)

    /* renamed from: d  reason: collision with root package name */
    private String f6972d;

    /* renamed from: e  reason: collision with root package name */
    private String f6973e;

    /* renamed from: f  reason: collision with root package name */
    private String f6974f;

    /* renamed from: g  reason: collision with root package name */
    private String f6975g;

    /* renamed from: h  reason: collision with root package name */
    private String f6976h;

    /* renamed from: i  reason: collision with root package name */
    private String f6977i;

    /* renamed from: j  reason: collision with root package name */
    private String[] f6978j;

    /* compiled from: SDKInfo.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private String f6979a;

        /* renamed from: b  reason: collision with root package name */
        private String f6980b;

        /* renamed from: c  reason: collision with root package name */
        private String f6981c;

        /* renamed from: d  reason: collision with root package name */
        private String f6982d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f6983e = true;

        /* renamed from: f  reason: collision with root package name */
        private String f6984f = "standard";

        /* renamed from: g  reason: collision with root package name */
        private String[] f6985g = null;

        public b(String str, String str2, String str3) {
            this.f6979a = str2;
            this.f6980b = str2;
            this.f6982d = str3;
            this.f6981c = str;
        }

        public b a(String[] strArr) {
            this.f6985g = (String[]) strArr.clone();
            return this;
        }

        public f b() throws co {
            if (this.f6985g != null) {
                return new f(this);
            }
            throw new co("sdk packages is null");
        }
    }

    private String b(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            for (String str : strArr) {
                sb2.append(str);
                sb2.append(";");
            }
            return sb2.toString();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    private String[] c(String str) {
        try {
            return str.split(";");
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public static String g() {
        return "a6=1";
    }

    public String a() {
        if (TextUtils.isEmpty(this.f6976h) && !TextUtils.isEmpty(this.f6969a)) {
            this.f6976h = g.j(this.f6969a);
        }
        return this.f6976h;
    }

    public String d() {
        if (TextUtils.isEmpty(this.f6974f) && !TextUtils.isEmpty(this.f6970b)) {
            this.f6974f = g.j(this.f6970b);
        }
        return this.f6974f;
    }

    public String e() {
        if (TextUtils.isEmpty(this.f6977i) && !TextUtils.isEmpty(this.f6972d)) {
            this.f6977i = g.j(this.f6972d);
        }
        if (TextUtils.isEmpty(this.f6977i)) {
            this.f6977i = "standard";
        }
        return this.f6977i;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return f.class == obj.getClass() && hashCode() == ((f) obj).hashCode();
    }

    public String[] f() {
        String[] strArr = this.f6978j;
        if ((strArr == null || strArr.length == 0) && !TextUtils.isEmpty(this.f6971c)) {
            this.f6978j = c(g.j(this.f6971c));
        }
        return (String[]) this.f6978j.clone();
    }

    public int hashCode() {
        c cVar = new c();
        cVar.h(this.f6976h).h(this.f6973e).h(this.f6974f).q(this.f6978j);
        return cVar.a();
    }

    private f() {
        this.f6978j = null;
    }

    private f(b bVar) {
        this.f6978j = null;
        this.f6973e = bVar.f6979a;
        this.f6974f = bVar.f6980b;
        this.f6976h = bVar.f6981c;
        this.f6975g = bVar.f6982d;
        boolean unused = bVar.f6983e;
        this.f6977i = bVar.f6984f;
        this.f6978j = bVar.f6985g;
        this.f6970b = g.g(this.f6974f);
        this.f6969a = g.g(this.f6976h);
        g.g(this.f6975g);
        this.f6971c = g.g(b(this.f6978j));
        this.f6972d = g.g(this.f6977i);
    }
}
