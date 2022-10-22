package com.unionpay.mobile.android.pro.views;

import com.unionpay.mobile.android.model.c;
import com.unionpay.mobile.android.nocard.views.l;
import com.unionpay.mobile.android.pro.pboc.engine.a;
import com.unionpay.mobile.android.utils.k;
import java.util.ArrayList;
/* loaded from: classes2.dex */
final class i implements a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f23934a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f23934a = hVar;
    }

    @Override // com.unionpay.mobile.android.pro.pboc.engine.a
    public final void a(ArrayList<c> arrayList) {
        k.a("uppay", "deviceReady +++");
        if (arrayList != null && arrayList.size() > 0) {
            h hVar = this.f23934a;
            if (((l) hVar).f23706s == null) {
                ((l) hVar).f23706s = new ArrayList(arrayList.size());
            }
            ((l) this.f23934a).f23706s.addAll(arrayList);
        }
        this.f23934a.w();
        k.a("uppay", "deviceReady ---");
    }
}
