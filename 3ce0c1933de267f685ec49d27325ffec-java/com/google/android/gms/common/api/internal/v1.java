package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.api.j;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class v1<R extends h> extends j<R> implements i<R> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f8758a;

    /* renamed from: b  reason: collision with root package name */
    private Status f8759b;

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<d> f8760c;

    private static void b(h hVar) {
        if (hVar instanceof g) {
            try {
                ((g) hVar).release();
            } catch (RuntimeException e10) {
                String valueOf = String.valueOf(hVar);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 18);
                sb2.append("Unable to release ");
                sb2.append(valueOf);
                Log.w("TransformedResultImpl", sb2.toString(), e10);
            }
        }
    }

    private final boolean d() {
        this.f8760c.get();
        return false;
    }

    private final void e(Status status) {
        synchronized (this.f8758a) {
            this.f8759b = status;
            f(status);
        }
    }

    private final void f(Status status) {
        synchronized (this.f8758a) {
            if (d()) {
                throw null;
            }
        }
    }

    @Override // com.google.android.gms.common.api.i
    public final void a(R r10) {
        synchronized (this.f8758a) {
            if (!r10.getStatus().K0()) {
                e(r10.getStatus());
                b(r10);
            } else if (d()) {
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
    }
}
