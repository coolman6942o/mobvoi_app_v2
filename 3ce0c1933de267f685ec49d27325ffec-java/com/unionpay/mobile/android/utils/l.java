package com.unionpay.mobile.android.utils;

import android.os.Handler;
import com.unionpay.mobile.android.nocard.views.b;
import org.simalliance.openmobileapi.SEService;
/* loaded from: classes2.dex */
public final class l implements SEService.CallBack {

    /* renamed from: a  reason: collision with root package name */
    private static SEService f24153a;

    /* renamed from: b  reason: collision with root package name */
    private b f24154b;

    /* renamed from: c  reason: collision with root package name */
    private Handler.Callback f24155c = new m(this);

    /* renamed from: d  reason: collision with root package name */
    private Handler f24156d = new Handler(this.f24155c);

    public static SEService a() {
        return f24153a;
    }

    public final void serviceConnected(SEService sEService) {
        k.c("uppay", "se service connected");
        k.c("uppay", "mSEService:" + f24153a);
        k.c("uppay", "mSEService.isConnected:" + f24153a.isConnected());
        this.f24156d.sendEmptyMessage(1);
    }
}
