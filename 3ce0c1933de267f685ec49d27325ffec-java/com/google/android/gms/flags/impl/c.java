package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
final class c implements Callable<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ SharedPreferences f9067a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f9068b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Boolean f9069c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SharedPreferences sharedPreferences, String str, Boolean bool) {
        this.f9067a = sharedPreferences;
        this.f9068b = str;
        this.f9069c = bool;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Boolean call() throws Exception {
        return Boolean.valueOf(this.f9067a.getBoolean(this.f9068b, this.f9069c.booleanValue()));
    }
}
