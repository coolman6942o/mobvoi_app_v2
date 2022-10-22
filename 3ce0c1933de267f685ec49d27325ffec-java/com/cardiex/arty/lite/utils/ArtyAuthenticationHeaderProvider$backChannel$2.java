package com.cardiex.arty.lite.utils;

import kotlin.jvm.internal.Lambda;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.y;
import qo.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArtyAuthenticationHeaderProvider.kt */
/* loaded from: classes.dex */
public final class ArtyAuthenticationHeaderProvider$backChannel$2 extends Lambda implements a<y> {
    final /* synthetic */ ArtyAuthenticationHeaderProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtyAuthenticationHeaderProvider$backChannel$2(ArtyAuthenticationHeaderProvider artyAuthenticationHeaderProvider) {
        super(0);
        this.this$0 = artyAuthenticationHeaderProvider;
    }

    @Override // qo.a
    public final y invoke() {
        boolean z10;
        y.a aVar = new y.a();
        z10 = this.this$0.enableLogging;
        if (z10) {
            aVar.a(new HttpLoggingInterceptor(null, 1, null).d(HttpLoggingInterceptor.Level.BODY));
        }
        return aVar.c();
    }
}
