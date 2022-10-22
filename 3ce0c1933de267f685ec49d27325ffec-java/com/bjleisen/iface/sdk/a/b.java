package com.bjleisen.iface.sdk.a;

import android.content.Context;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AsyncHttpClient.java */
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f7627a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f7628b = true;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ a f7629c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, Context context) {
        this.f7629c = aVar;
        this.f7627a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map map;
        Map map2;
        map = this.f7629c.f7623j;
        List<f> list = (List) map.get(this.f7627a);
        if (list != null) {
            for (f fVar : list) {
                fVar.a();
            }
            map2 = this.f7629c.f7623j;
            map2.remove(this.f7627a);
        }
    }
}
