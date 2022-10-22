package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import b6.i;
import com.google.android.gms.dynamite.DynamiteModule;
import h6.g;
/* loaded from: classes.dex */
public final class o7 {

    /* renamed from: b  reason: collision with root package name */
    private static o7 f9555b;

    /* renamed from: a  reason: collision with root package name */
    private Context f9556a;

    private o7() {
    }

    public static synchronized o7 b() {
        o7 o7Var;
        synchronized (o7.class) {
            if (f9555b == null) {
                f9555b = new o7();
            }
            o7Var = f9555b;
        }
        return o7Var;
    }

    public final void a(Context context) {
        this.f9556a = context;
    }

    public final m7 c() throws zzxx {
        try {
            DynamiteModule d10 = DynamiteModule.d(this.f9556a, DynamiteModule.f9050j, "com.google.android.gms.crash");
            i.k(d10);
            IBinder c10 = d10.c("com.google.firebase.crash.internal.api.FirebaseCrashApiImpl");
            if (c10 == null) {
                return null;
            }
            IInterface queryLocalInterface = c10.queryLocalInterface("com.google.firebase.crash.internal.IFirebaseCrashApi");
            return queryLocalInterface instanceof m7 ? (m7) queryLocalInterface : new n7(c10);
        } catch (DynamiteModule.LoadingException e10) {
            g.a(this.f9556a, e10);
            throw new zzxx(e10);
        }
    }
}
