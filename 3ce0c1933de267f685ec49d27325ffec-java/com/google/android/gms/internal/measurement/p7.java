package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.crash.FirebaseCrash;
import java.util.concurrent.ExecutorService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p7 implements AppMeasurement.c {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f9595a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f9596b;

    /* renamed from: c  reason: collision with root package name */
    private final FirebaseCrash.a f9597c;

    public p7(Context context, ExecutorService executorService, FirebaseCrash.a aVar) {
        this.f9596b = context.getApplicationContext();
        this.f9595a = executorService;
        this.f9597c = aVar;
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.c
    public final void a(String str, String str2, Bundle bundle, long j10) {
        FirebaseCrash.a aVar;
        if (str != null && !str.equals(AppMeasurement.CRASH_ORIGIN) && (aVar = this.f9597c) != null) {
            this.f9595a.submit(new h7(this.f9596b, aVar, str2, j10, bundle));
        }
    }
}
