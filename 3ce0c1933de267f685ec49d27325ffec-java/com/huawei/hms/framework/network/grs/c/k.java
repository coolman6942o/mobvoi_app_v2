package com.huawei.hms.framework.network.grs.c;

import com.huawei.hms.framework.network.grs.a.a;
import com.huawei.hms.framework.network.grs.c.b.c;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Callable<f> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f13921a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f13922b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ m f13923c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(m mVar, c cVar, String str) {
        this.f13923c = mVar;
        this.f13921a = cVar;
        this.f13922b = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public f call() {
        a aVar;
        ExecutorService executorService;
        c cVar = this.f13921a;
        aVar = this.f13923c.f13931d;
        e eVar = new e(cVar, aVar);
        executorService = this.f13923c.f13928a;
        return eVar.a(executorService, this.f13922b);
    }
}
