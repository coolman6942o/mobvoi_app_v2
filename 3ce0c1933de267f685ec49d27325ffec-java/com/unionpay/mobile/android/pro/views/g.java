package com.unionpay.mobile.android.pro.views;

import android.os.Bundle;
import android.os.Handler;
import com.unionpay.mobile.android.model.b;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f23931a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ HashMap f23932b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ a f23933c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar, String str, HashMap hashMap) {
        this.f23933c = aVar;
        this.f23931a = str;
        this.f23932b = hashMap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Handler handler2;
        b unused;
        a aVar = this.f23933c;
        String str = this.f23931a;
        unused = ((com.unionpay.mobile.android.nocard.views.b) aVar).f23639a;
        Bundle a10 = aVar.a(str, this.f23932b);
        handler = this.f23933c.f23914z;
        handler2 = this.f23933c.f23914z;
        if (a10 == null) {
            a10 = null;
        }
        handler.sendMessage(handler2.obtainMessage(0, a10));
    }
}
