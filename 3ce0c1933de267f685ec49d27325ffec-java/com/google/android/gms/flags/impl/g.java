package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
final class g implements Callable<SharedPreferences> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Context f9079a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Context context) {
        this.f9079a = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ SharedPreferences call() throws Exception {
        return this.f9079a.getSharedPreferences("google_sdk_flags", 0);
    }
}
