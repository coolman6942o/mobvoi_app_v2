package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
final class f implements Callable<String> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ SharedPreferences f9076a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f9077b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f9078c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SharedPreferences sharedPreferences, String str, String str2) {
        this.f9076a = sharedPreferences;
        this.f9077b = str;
        this.f9078c = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        return this.f9076a.getString(this.f9077b, this.f9078c);
    }
}
