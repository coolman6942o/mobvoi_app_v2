package com.unionpay.mobile.android.utils;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.nocard.views.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class m implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l f24157a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.f24157a = lVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001a, code lost:
        r3 = r2.f24157a.f24154b;
        ((com.unionpay.mobile.android.nocard.views.l) r3).r();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
        if (r3 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0018, code lost:
        if (r3 != null) goto L10;
     */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean handleMessage(Message message) {
        b bVar;
        b bVar2;
        int i10 = message.what;
        if (i10 == 1) {
            bVar = this.f24157a.f24154b;
        } else if (i10 == 2) {
            bVar2 = this.f24157a.f24154b;
        }
        return true;
    }
}
