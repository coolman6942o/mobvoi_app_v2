package com.mobvoi.health.companion.system;

import android.content.Context;
/* compiled from: HealthCommonClient.java */
/* loaded from: classes2.dex */
public interface b {

    /* compiled from: HealthCommonClient.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a(boolean z10);
    }

    /* compiled from: HealthCommonClient.java */
    /* renamed from: com.mobvoi.health.companion.system.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0221b {

        /* renamed from: a  reason: collision with root package name */
        public final Context f19014a;

        /* renamed from: b  reason: collision with root package name */
        public final String f19015b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f19016c;

        public C0221b(Context context, String str, byte[] bArr) {
            this.f19014a = context;
            this.f19015b = str;
            this.f19016c = bArr;
        }
    }

    /* compiled from: HealthCommonClient.java */
    /* loaded from: classes2.dex */
    public interface c {
        void a(C0221b bVar);
    }

    void h(String str, c cVar);

    void j(String str, String str2, boolean z10);

    hh.b k(Context context);

    WearDevices m(Context context);

    void q(String str, c cVar);
}
