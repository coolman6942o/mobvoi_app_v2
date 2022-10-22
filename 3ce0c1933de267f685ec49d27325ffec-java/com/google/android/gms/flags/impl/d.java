package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
final class d implements Callable<Integer> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ SharedPreferences f9070a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f9071b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Integer f9072c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SharedPreferences sharedPreferences, String str, Integer num) {
        this.f9070a = sharedPreferences;
        this.f9071b = str;
        this.f9072c = num;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Integer call() throws Exception {
        return Integer.valueOf(this.f9070a.getInt(this.f9071b, this.f9072c.intValue()));
    }
}
