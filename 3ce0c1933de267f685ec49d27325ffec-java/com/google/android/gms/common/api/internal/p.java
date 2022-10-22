package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.b;
import com.google.android.gms.tasks.c;
/* loaded from: classes.dex */
public class p {
    public static void a(Status status, c<Void> cVar) {
        b(status, null, cVar);
    }

    public static <TResult> void b(Status status, TResult tresult, c<TResult> cVar) {
        if (status.K0()) {
            cVar.c(tresult);
        } else {
            cVar.b(new ApiException(status));
        }
    }

    @Deprecated
    public static b<Void> c(b<Boolean> bVar) {
        return bVar.h(new u1());
    }
}
