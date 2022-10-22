package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import b6.i;
import b6.j;
import b6.o;
import com.google.android.gms.common.api.Status;
import z5.b;
@Deprecated
/* loaded from: classes.dex */
public final class f {

    /* renamed from: d  reason: collision with root package name */
    private static final Object f8595d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private static f f8596e;

    /* renamed from: a  reason: collision with root package name */
    private final String f8597a;

    /* renamed from: b  reason: collision with root package name */
    private final Status f8598b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f8599c;

    f(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(b.f37287a));
        boolean z10 = false;
        if (identifier != 0) {
            z10 = true;
            if (resources.getInteger(identifier) != 0) {
            }
            this.f8599c = !z10;
        } else {
            this.f8599c = false;
        }
        String a10 = o.a(context);
        a10 = a10 == null ? new j(context).a("google_app_id") : a10;
        if (TextUtils.isEmpty(a10)) {
            this.f8598b = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.f8597a = null;
            return;
        }
        this.f8597a = a10;
        this.f8598b = Status.f8444e;
    }

    private static f a(String str) {
        f fVar;
        synchronized (f8595d) {
            fVar = f8596e;
            if (fVar == null) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 34);
                sb2.append("Initialize must be called before ");
                sb2.append(str);
                sb2.append(".");
                throw new IllegalStateException(sb2.toString());
            }
        }
        return fVar;
    }

    public static String b() {
        return a("getGoogleAppId").f8597a;
    }

    public static Status c(Context context) {
        Status status;
        i.l(context, "Context must not be null.");
        synchronized (f8595d) {
            if (f8596e == null) {
                f8596e = new f(context);
            }
            status = f8596e.f8598b;
        }
        return status;
    }

    public static boolean d() {
        return a("isMeasurementExplicitlyDisabled").f8599c;
    }
}
