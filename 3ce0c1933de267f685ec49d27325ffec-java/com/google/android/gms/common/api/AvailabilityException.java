package com.google.android.gms.common.api;

import android.text.TextUtils;
import androidx.collection.a;
import b6.i;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.f2;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AvailabilityException extends Exception {
    private final a<f2<?>, ConnectionResult> zaay;

    public AvailabilityException(a<f2<?>, ConnectionResult> aVar) {
        this.zaay = aVar;
    }

    public ConnectionResult getConnectionResult(c<? extends a.d> cVar) {
        f2<? extends a.d> o10 = cVar.o();
        i.b(this.zaay.get(o10) != null, "The given API was not part of the availability request.");
        return this.zaay.get(o10);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z10 = true;
        for (f2<?> f2Var : this.zaay.keySet()) {
            ConnectionResult connectionResult = this.zaay.get(f2Var);
            if (connectionResult.K0()) {
                z10 = false;
            }
            String c10 = f2Var.c();
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb2 = new StringBuilder(String.valueOf(c10).length() + 2 + valueOf.length());
            sb2.append(c10);
            sb2.append(": ");
            sb2.append(valueOf);
            arrayList.add(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder();
        if (z10) {
            sb3.append("None of the queried APIs are available. ");
        } else {
            sb3.append("Some of the queried APIs are unavailable. ");
        }
        sb3.append(TextUtils.join("; ", arrayList));
        return sb3.toString();
    }

    public final androidx.collection.a<f2<?>, ConnectionResult> zaj() {
        return this.zaay;
    }
}
