package com.google.firebase.crash;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.measurement.m7;
import com.google.android.gms.internal.measurement.o7;
import com.google.android.gms.internal.measurement.r7;
import com.google.android.gms.internal.measurement.zzxx;
import com.google.firebase.a;
import h6.g;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final a f12444a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f12445b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f12445b = aVar.b();
        this.f12444a = aVar;
    }

    public final m7 c() {
        r7.a(this.f12445b);
        m7 m7Var = null;
        if (r7.f9647a.e().booleanValue()) {
            try {
                o7.b().a(this.f12445b);
                m7Var = o7.b().c();
                String valueOf = String.valueOf(o7.b());
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 33);
                sb2.append("FirebaseCrash reporting loaded - ");
                sb2.append(valueOf);
                Log.i("FirebaseCrash", sb2.toString());
                return m7Var;
            } catch (zzxx e10) {
                Log.e("FirebaseCrash", "Failed to load crash reporting", e10);
                g.a(this.f12445b, e10);
                return m7Var;
            }
        } else {
            Log.w("FirebaseCrash", "Crash reporting is disabled");
            return null;
        }
    }
}
