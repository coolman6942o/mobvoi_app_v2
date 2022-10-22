package com.mobvoi.health.common.data.sync.net;

import com.mobvoi.health.common.data.sync.net.g;
import java.util.List;
import uf.a;
import yf.b;
import yf.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseApiService.java */
/* loaded from: classes2.dex */
public abstract class d<Request extends c, Reply extends c> implements g.a<Request, Reply> {

    /* renamed from: a  reason: collision with root package name */
    private final of.g f17973a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(of.g gVar) {
        this.f17973a = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(List list, final b bVar) {
        try {
            final List<Reply> e10 = e(this.f17973a.i(), list);
            this.f17973a.m().post(new Runnable() { // from class: com.mobvoi.health.common.data.sync.net.c
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.a(e10, null);
                }
            });
        } catch (Throwable th2) {
            this.f17973a.m().post(new Runnable() { // from class: com.mobvoi.health.common.data.sync.net.b
                @Override // java.lang.Runnable
                public final void run() {
                    yf.b.this.a(null, th2);
                }
            });
        }
    }

    @Override // com.mobvoi.health.common.data.sync.net.g.a
    public void a(final List<Request> list, final b<Reply> bVar) {
        this.f17973a.k().execute(new Runnable() { // from class: com.mobvoi.health.common.data.sync.net.a
            @Override // java.lang.Runnable
            public final void run() {
                d.this.h(list, bVar);
            }
        });
    }

    protected abstract List<Reply> e(a aVar, List<Request> list) throws Throwable;
}
