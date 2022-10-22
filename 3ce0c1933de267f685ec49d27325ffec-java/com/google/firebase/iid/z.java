package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.b;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes.dex */
public final class z {

    /* renamed from: e  reason: collision with root package name */
    private static z f12528e;

    /* renamed from: a  reason: collision with root package name */
    private final Context f12529a;

    /* renamed from: b  reason: collision with root package name */
    private final ScheduledExecutorService f12530b;

    /* renamed from: c  reason: collision with root package name */
    private b0 f12531c = new b0(this);

    /* renamed from: d  reason: collision with root package name */
    private int f12532d = 1;

    private z(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f12530b = scheduledExecutorService;
        this.f12529a = context.getApplicationContext();
    }

    private final synchronized <T> b<T> c(b<T> bVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(bVar);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 9);
            sb2.append("Queueing ");
            sb2.append(valueOf);
            Log.d("MessengerIpcClient", sb2.toString());
        }
        if (!this.f12531c.d(bVar)) {
            b0 b0Var = new b0(this);
            this.f12531c = b0Var;
            b0Var.d(bVar);
        }
        return bVar.f12463b.a();
    }

    public static synchronized z f(Context context) {
        z zVar;
        synchronized (z.class) {
            if (f12528e == null) {
                f12528e = new z(context, Executors.newSingleThreadScheduledExecutor());
            }
            zVar = f12528e;
        }
        return zVar;
    }

    private final synchronized int g() {
        int i10;
        i10 = this.f12532d;
        this.f12532d = i10 + 1;
        return i10;
    }

    public final b<Void> b(int i10, Bundle bundle) {
        return c(new a(g(), 2, bundle));
    }

    public final b<Bundle> d(int i10, Bundle bundle) {
        return c(new c(g(), 1, bundle));
    }
}
