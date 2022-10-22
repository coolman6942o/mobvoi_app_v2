package com.unionpay.mobile.android.pro.views;

import android.os.Bundle;
import android.os.Handler;
import com.unionpay.mobile.android.model.c;
import com.unionpay.mobile.android.pro.pboc.engine.b;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f23918a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ c f23919b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f23920c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ HashMap f23921d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ y f23922e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(y yVar, b bVar, c cVar, String str, HashMap hashMap) {
        this.f23922e = yVar;
        this.f23918a = bVar;
        this.f23919b = cVar;
        this.f23920c = str;
        this.f23921d = hashMap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.unionpay.mobile.android.model.b bVar;
        com.unionpay.mobile.android.model.b bVar2;
        Handler handler;
        Handler handler2;
        b bVar3 = this.f23918a;
        c cVar = this.f23919b;
        String str = this.f23920c;
        bVar = ((com.unionpay.mobile.android.nocard.views.b) this.f23922e).f23639a;
        HashMap<String, String> hashMap = bVar.f23540p;
        HashMap<String, String> hashMap2 = this.f23921d;
        bVar2 = ((com.unionpay.mobile.android.nocard.views.b) this.f23922e).f23639a;
        Bundle a10 = bVar3.a(cVar, str, hashMap, hashMap2, bVar2.f23537m);
        handler = this.f23922e.D;
        handler2 = this.f23922e.D;
        if (a10 == null) {
            a10 = null;
        }
        handler.sendMessage(handler2.obtainMessage(0, a10));
    }
}
