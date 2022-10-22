package com.amap.api.services.a;

import android.text.TextUtils;
/* compiled from: SDKInfo.java */
@n(a = "a")
/* loaded from: classes.dex */
public class e {
    @n4.e(a = "a1", b = 6)

    /* renamed from: a  reason: collision with root package name */
    private String f7173a;
    @n4.e(a = "a2", b = 6)

    /* renamed from: b  reason: collision with root package name */
    private String f7174b;
    @n4.e(a = "a4", b = 6)

    /* renamed from: c  reason: collision with root package name */
    private String f7175c;
    @n4.e(a = "a5", b = 6)

    /* renamed from: d  reason: collision with root package name */
    private String f7176d;

    /* renamed from: e  reason: collision with root package name */
    private String f7177e;

    /* renamed from: f  reason: collision with root package name */
    private String f7178f;

    /* renamed from: g  reason: collision with root package name */
    private String f7179g;

    /* renamed from: h  reason: collision with root package name */
    private String f7180h;

    /* renamed from: i  reason: collision with root package name */
    private String f7181i;

    /* renamed from: j  reason: collision with root package name */
    private String[] f7182j;

    /* compiled from: SDKInfo.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private String f7183a;

        /* renamed from: b  reason: collision with root package name */
        private String f7184b;

        /* renamed from: c  reason: collision with root package name */
        private String f7185c;

        /* renamed from: d  reason: collision with root package name */
        private String f7186d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f7187e = true;

        /* renamed from: f  reason: collision with root package name */
        private String f7188f = "standard";

        /* renamed from: g  reason: collision with root package name */
        private String[] f7189g = null;

        public b(String str, String str2, String str3) {
            this.f7183a = str2;
            this.f7184b = str2;
            this.f7186d = str3;
            this.f7185c = str;
        }

        public b a(String[] strArr) {
            this.f7189g = (String[]) strArr.clone();
            return this;
        }

        public e b() throws ay {
            if (this.f7189g != null) {
                return new e(this);
            }
            throw new ay("sdk packages is null");
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
        if (TextUtils.isEmpty(this.f7180h) && !TextUtils.isEmpty(this.f7173a)) {
            this.f7180h = f.j(this.f7173a);
        }
        return this.f7180h;
    }

    public String d() {
        if (TextUtils.isEmpty(this.f7178f) && !TextUtils.isEmpty(this.f7174b)) {
            this.f7178f = f.j(this.f7174b);
        }
        return this.f7178f;
    }

    public String e() {
        if (TextUtils.isEmpty(this.f7181i) && !TextUtils.isEmpty(this.f7176d)) {
            this.f7181i = f.j(this.f7176d);
        }
        if (TextUtils.isEmpty(this.f7181i)) {
            this.f7181i = "standard";
        }
        return this.f7181i;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return e.class == obj.getClass() && hashCode() == ((e) obj).hashCode();
    }

    public String[] f() {
        String[] strArr = this.f7182j;
        if ((strArr == null || strArr.length == 0) && !TextUtils.isEmpty(this.f7175c)) {
            this.f7182j = c(f.j(this.f7175c));
        }
        return (String[]) this.f7182j.clone();
    }

    public int hashCode() {
        n4.b bVar = new n4.b();
        bVar.h(this.f7180h).h(this.f7177e).h(this.f7178f).q(this.f7182j);
        return bVar.a();
    }

    private e() {
        this.f7182j = null;
    }

    private e(b bVar) {
        this.f7182j = null;
        this.f7177e = bVar.f7183a;
        this.f7178f = bVar.f7184b;
        this.f7180h = bVar.f7185c;
        this.f7179g = bVar.f7186d;
        boolean unused = bVar.f7187e;
        this.f7181i = bVar.f7188f;
        this.f7182j = bVar.f7189g;
        this.f7174b = f.f(this.f7178f);
        this.f7173a = f.f(this.f7180h);
        f.f(this.f7179g);
        this.f7175c = f.f(b(this.f7182j));
        this.f7176d = f.f(this.f7181i);
    }
}
