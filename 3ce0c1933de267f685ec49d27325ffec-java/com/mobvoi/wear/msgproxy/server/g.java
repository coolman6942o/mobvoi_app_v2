package com.mobvoi.wear.msgproxy.server;
/* loaded from: classes2.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GmsWearableClient f20946a;

    public /* synthetic */ g(GmsWearableClient gmsWearableClient) {
        this.f20946a = gmsWearableClient;
    }

    @Override // java.lang.Runnable
    public final void run() {
        GmsWearableClient.b(this.f20946a);
    }
}
