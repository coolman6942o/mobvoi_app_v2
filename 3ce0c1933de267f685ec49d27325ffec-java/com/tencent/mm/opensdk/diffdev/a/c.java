package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.mm.opensdk.diffdev.OAuthListener;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
final class c implements Runnable {

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ b f22460g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f22460g = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List list;
        ArrayList<OAuthListener> arrayList = new ArrayList();
        list = this.f22460g.f22459f.f22456c;
        arrayList.addAll(list);
        for (OAuthListener oAuthListener : arrayList) {
            oAuthListener.onQrcodeScanned();
        }
    }
}
