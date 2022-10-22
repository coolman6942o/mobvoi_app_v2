package com.unionpay.mobile.android.nocard.utils;

import android.content.Context;
import com.unionpay.mobile.android.net.c;
import com.unionpay.mobile.android.net.d;
/* loaded from: classes2.dex */
final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f23582a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f23583b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Context f23584c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(String str, String str2, Context context) {
        this.f23582a = str;
        this.f23583b = str2;
        this.f23584c = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        new c(new d(this.f23582a, this.f23583b.getBytes()), this.f23584c).a();
    }
}
