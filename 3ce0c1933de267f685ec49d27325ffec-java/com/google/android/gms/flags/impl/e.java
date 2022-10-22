package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
final class e implements Callable<Long> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ SharedPreferences f9073a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f9074b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Long f9075c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SharedPreferences sharedPreferences, String str, Long l10) {
        this.f9073a = sharedPreferences;
        this.f9074b = str;
        this.f9075c = l10;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Long call() throws Exception {
        return Long.valueOf(this.f9073a.getLong(this.f9074b, this.f9075c.longValue()));
    }
}
