package com.huawei.hms.framework.network.grs.c;

import com.huawei.hms.framework.network.grs.b;
import com.huawei.hms.framework.network.grs.c.b.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f13924a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f13925b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ b f13926c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ m f13927d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(m mVar, c cVar, String str, b bVar) {
        this.f13927d = mVar;
        this.f13924a = cVar;
        this.f13925b = str;
        this.f13926c = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        m mVar = this.f13927d;
        mVar.a(mVar.a(this.f13924a, this.f13925b), this.f13926c);
    }
}
