package com.mobvoi.health.common.data.sync.net;

import android.content.Context;
import com.mobvoi.android.common.utils.m;
import com.mobvoi.wear.providers.HealthFlagsHelper;
import java.util.List;
import yf.b;
import yf.c;
import yf.d;
/* compiled from: NetClient.java */
/* loaded from: classes2.dex */
public class g<Request extends c, Reply extends c> implements d<Request, Reply> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f17974a;

    /* renamed from: b  reason: collision with root package name */
    private a<Request, Reply> f17975b;

    /* renamed from: c  reason: collision with root package name */
    private b<Reply> f17976c;

    /* compiled from: NetClient.java */
    /* loaded from: classes2.dex */
    public interface a<Request extends c, Reply extends c> {
        void a(List<Request> list, b<Reply> bVar);
    }

    private g(Context context, a<Request, Reply> aVar) {
        this.f17974a = context;
        this.f17975b = aVar;
    }

    public static <Request extends c, Reply extends c> g<Request, Reply> c(Context context, a<Request, Reply> aVar) {
        return new g<>(context, aVar);
    }

    @Override // yf.d
    public void a(b<Reply> bVar) {
        this.f17976c = bVar;
    }

    @Override // yf.d
    public void b(List<Request> list) {
        this.f17975b.a(list, this.f17976c);
    }

    @Override // yf.d
    public boolean isConnected() {
        if (eg.d.a(com.mobvoi.android.common.utils.b.e())) {
            return HealthFlagsHelper.isFeatureEnabled(HealthFlagsHelper.FLAG_NETWORK_SYNC) && m.b(this.f17974a);
        }
        eg.d.d(com.mobvoi.android.common.utils.b.e());
        return false;
    }
}
