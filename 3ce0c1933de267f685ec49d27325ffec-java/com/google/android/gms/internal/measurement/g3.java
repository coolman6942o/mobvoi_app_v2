package com.google.android.gms.internal.measurement;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g3 implements Callable<String> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ c3 f9300a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g3(c3 c3Var) {
        this.f9300a = c3Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0072  */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ String call() throws Exception {
        b1 K;
        String str;
        String K2 = this.f9300a.r().K();
        if (K2 != null) {
            return K2;
        }
        c3 i10 = this.f9300a.i();
        String str2 = null;
        if (i10.d().N()) {
            K = i10.c().K();
            str = "Cannot retrieve app instance id from analytics worker thread";
        } else {
            i10.d();
            if (z1.z()) {
                K = i10.c().K();
                str = "Cannot retrieve app instance id from main thread";
            } else {
                long c10 = i10.b().c();
                String e02 = i10.e0(120000L);
                long c11 = i10.b().c() - c10;
                str2 = (e02 != null || c11 >= 120000) ? e02 : i10.e0(120000 - c11);
                if (str2 == null) {
                    this.f9300a.r().E(str2);
                    return str2;
                }
                throw new TimeoutException();
            }
        }
        K.a(str);
        if (str2 == null) {
        }
    }
}
