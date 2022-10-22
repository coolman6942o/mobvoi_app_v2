package com.unionpay.mobile.android.upwidget;

import android.os.Handler;
import android.os.Message;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class t extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UPRadiationView f24129a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(UPRadiationView uPRadiationView) {
        this.f24129a = uPRadiationView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        List list;
        List list2;
        Handler handler;
        super.handleMessage(message);
        if (message.what == 0) {
            UPRadiationView.a(this.f24129a);
            this.f24129a.invalidate();
            list = this.f24129a.f24006a;
            if (list != null) {
                list2 = this.f24129a.f24006a;
                if (list2.size() > 0) {
                    handler = this.f24129a.f24010e;
                    handler.sendEmptyMessageDelayed(0, 50L);
                }
            }
        }
    }
}
