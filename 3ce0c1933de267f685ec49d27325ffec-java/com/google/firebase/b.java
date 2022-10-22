package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import b6.h;
import b6.i;
import b6.j;
import h6.o;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f12423a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12424b;

    /* renamed from: c  reason: collision with root package name */
    private final String f12425c;

    /* renamed from: d  reason: collision with root package name */
    private final String f12426d;

    /* renamed from: e  reason: collision with root package name */
    private final String f12427e;

    /* renamed from: f  reason: collision with root package name */
    private final String f12428f;

    /* renamed from: g  reason: collision with root package name */
    private final String f12429g;

    private b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        i.o(!o.a(str), "ApplicationId must be set.");
        this.f12424b = str;
        this.f12423a = str2;
        this.f12425c = str3;
        this.f12426d = str4;
        this.f12427e = str5;
        this.f12428f = str6;
        this.f12429g = str7;
    }

    public static b a(Context context) {
        j jVar = new j(context);
        String a10 = jVar.a("google_app_id");
        if (TextUtils.isEmpty(a10)) {
            return null;
        }
        return new b(a10, jVar.a("google_api_key"), jVar.a("firebase_database_url"), jVar.a("ga_trackingId"), jVar.a("gcm_defaultSenderId"), jVar.a("google_storage_bucket"), jVar.a("project_id"));
    }

    public final String b() {
        return this.f12423a;
    }

    public final String c() {
        return this.f12424b;
    }

    public final String d() {
        return this.f12427e;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return h.a(this.f12424b, bVar.f12424b) && h.a(this.f12423a, bVar.f12423a) && h.a(this.f12425c, bVar.f12425c) && h.a(this.f12426d, bVar.f12426d) && h.a(this.f12427e, bVar.f12427e) && h.a(this.f12428f, bVar.f12428f) && h.a(this.f12429g, bVar.f12429g);
    }

    public final int hashCode() {
        return h.b(this.f12424b, this.f12423a, this.f12425c, this.f12426d, this.f12427e, this.f12428f, this.f12429g);
    }

    public final String toString() {
        return h.c(this).a("applicationId", this.f12424b).a("apiKey", this.f12423a).a("databaseUrl", this.f12425c).a("gcmSenderId", this.f12427e).a("storageBucket", this.f12428f).a("projectId", this.f12429g).toString();
    }
}
