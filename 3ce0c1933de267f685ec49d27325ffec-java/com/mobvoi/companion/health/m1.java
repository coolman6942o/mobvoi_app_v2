package com.mobvoi.companion.health;

import com.mobvoi.health.common.data.db.c;
import ig.b;
import io.m;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import nf.h;
import nf.k;
/* compiled from: MainViewModel.kt */
/* loaded from: classes2.dex */
public final class m1 {

    /* renamed from: b  reason: collision with root package name */
    private boolean f16883b;

    /* renamed from: a  reason: collision with root package name */
    private final Object f16882a = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final k<c.a> f16884c = new k() { // from class: com.mobvoi.companion.health.l1
        @Override // nf.k
        public final void i(h hVar, Object obj) {
            m1.c(m1.this, hVar, (c.a) obj);
        }
    };

    /* compiled from: MainViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    private final void b() {
        b.J().z().t().a(this.f16884c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(m1 this$0, h hVar, c.a aVar) {
        i.f(this$0, "this$0");
        if (aVar.f17962a == null) {
            com.mobvoi.android.common.utils.k.a("HealthRemoteDataSyncer", i.n("Health api data sync success: ThreadId ", Long.valueOf(Thread.currentThread().getId())));
            this$0.d();
            if (!this$0.f16883b) {
                this$0.f16883b = true;
                synchronized (this$0.f16882a) {
                    try {
                        this$0.f16882a.notify();
                    } catch (Exception e10) {
                        com.mobvoi.android.common.utils.k.d("HealthRemoteDataSyncer", e10.getMessage());
                    }
                    m mVar = m.f28349a;
                }
            }
        }
    }

    private final void d() {
        b.J().z().t().c(this.f16884c);
    }

    private final void f() {
        b();
    }

    public final void e() {
        com.mobvoi.android.common.utils.k.a("HealthRemoteDataSyncer", i.n("Health data api sync starts: ThreadId ", Long.valueOf(Thread.currentThread().getId())));
        f();
        long b10 = eg.c.b(System.currentTimeMillis());
        long millis = b10 - TimeUnit.HOURS.toMillis(4L);
        long millis2 = b10 + TimeUnit.DAYS.toMillis(1L);
        b.J().w(Long.valueOf(millis), Long.valueOf(millis2));
        yg.f.X().F(new Date(millis2), new Date(millis), Integer.MAX_VALUE);
        synchronized (this.f16882a) {
            try {
                this.f16882a.wait(10000L);
                d();
                com.mobvoi.android.common.utils.k.a("HealthRemoteDataSyncer", "Health data api sync finished");
            } catch (InterruptedException e10) {
                com.mobvoi.android.common.utils.k.d("HealthRemoteDataSyncer", e10.getMessage());
            }
            m mVar = m.f28349a;
        }
    }
}
