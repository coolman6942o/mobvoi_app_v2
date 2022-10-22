package com.unionpay.mobile.android.pro.views;

import android.os.Bundle;
import android.os.Handler;
import com.unionpay.mobile.android.model.b;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f23958a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ HashMap f23959b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ k f23960c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(k kVar, String str, HashMap hashMap) {
        this.f23960c = kVar;
        this.f23958a = str;
        this.f23959b = hashMap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Handler handler2;
        b unused;
        k kVar = this.f23960c;
        String str = this.f23958a;
        unused = ((com.unionpay.mobile.android.nocard.views.b) kVar).f23639a;
        Bundle a10 = kVar.a(str, this.f23959b);
        handler = this.f23960c.f23949z;
        handler2 = this.f23960c.f23949z;
        if (a10 == null) {
            a10 = null;
        }
        handler.sendMessage(handler2.obtainMessage(0, a10));
    }
}
