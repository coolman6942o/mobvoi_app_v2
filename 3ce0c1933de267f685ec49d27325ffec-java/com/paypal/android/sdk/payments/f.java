package com.paypal.android.sdk.payments;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    final IntentFilter f21719a;

    /* renamed from: b  reason: collision with root package name */
    final BroadcastReceiver f21720b;

    /* renamed from: c  reason: collision with root package name */
    boolean f21721c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
        this.f21719a = intentFilter;
        this.f21720b = broadcastReceiver;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("Receiver{");
        sb2.append(this.f21720b);
        sb2.append(" filter=");
        sb2.append(this.f21719a);
        sb2.append("}");
        return sb2.toString();
    }
}
