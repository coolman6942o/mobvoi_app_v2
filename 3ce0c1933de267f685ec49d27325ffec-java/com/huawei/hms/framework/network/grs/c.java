package com.huawei.hms.framework.network.grs;

import android.content.Context;
import com.huawei.hms.framework.network.grs.a.a;
import com.huawei.hms.framework.network.grs.b.b;
import com.huawei.hms.framework.network.grs.c.m;
import java.util.Map;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Callable<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f13852a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ GrsBaseInfo f13853b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ d f13854c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, Context context, GrsBaseInfo grsBaseInfo) {
        this.f13854c = dVar;
        this.f13852a = context;
        this.f13853b = grsBaseInfo;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Boolean call() {
        com.huawei.hms.framework.network.grs.a.c cVar;
        m mVar;
        GrsBaseInfo grsBaseInfo;
        a aVar;
        m mVar2;
        com.huawei.hms.framework.network.grs.a.c cVar2;
        a aVar2;
        this.f13854c.f13938g = new m();
        this.f13854c.f13940i = new com.huawei.hms.framework.network.grs.a.c(this.f13852a);
        d dVar = this.f13854c;
        cVar = dVar.f13940i;
        mVar = this.f13854c.f13938g;
        dVar.f13939h = new a(cVar, mVar);
        d dVar2 = this.f13854c;
        grsBaseInfo = dVar2.f13934c;
        aVar = this.f13854c.f13939h;
        mVar2 = this.f13854c.f13938g;
        dVar2.f13941j = new a(grsBaseInfo, aVar, mVar2);
        new b(this.f13852a, this.f13853b).a(this.f13853b);
        d dVar3 = this.f13854c;
        cVar2 = dVar3.f13940i;
        dVar3.a((Map<String, ?>) cVar2.a());
        aVar2 = this.f13854c.f13939h;
        aVar2.b(this.f13853b, this.f13852a);
        return Boolean.valueOf(this.f13854c.f13935d = true);
    }
}
