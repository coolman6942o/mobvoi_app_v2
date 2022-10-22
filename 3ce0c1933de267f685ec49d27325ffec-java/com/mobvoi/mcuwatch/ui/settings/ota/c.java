package com.mobvoi.mcuwatch.ui.settings.ota;

import android.app.Application;
import android.bluetooth.BluetoothDevice;
import androidx.lifecycle.w;
import com.google.gson.e;
import com.mobvoi.apollo.client.d;
import com.mobvoi.apollo.client.q;
import com.mobvoi.apollo.client.r;
import com.mobvoi.apollo.protocol.ble.client.ClientState;
import com.mobvoi.apollo.protocol.model.RoomInfo;
import com.mobvoi.apollo.protocol.model.WatchInfo;
import com.mobvoi.mcuwatch.ui.settings.ota.c;
import com.mobvoi.mcuwatch.ui.settings.ota.f;
import ha.l;
import ia.h;
import io.m;
import java.io.File;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import oo.g;
import rx.j;
/* compiled from: ApolloBleUpdate.kt */
/* loaded from: classes2.dex */
public final class c implements f, l.a {

    /* renamed from: a  reason: collision with root package name */
    private final l f20120a;

    /* renamed from: b  reason: collision with root package name */
    private final a f20121b;

    /* renamed from: c  reason: collision with root package name */
    private final r f20122c;

    /* renamed from: d  reason: collision with root package name */
    private f.a f20123d;

    /* renamed from: e  reason: collision with root package name */
    private h f20124e;

    /* renamed from: f  reason: collision with root package name */
    private j f20125f;

    /* renamed from: g  reason: collision with root package name */
    private String f20126g;

    /* renamed from: h  reason: collision with root package name */
    private final int f20127h = 30;

    /* renamed from: i  reason: collision with root package name */
    private final w<String> f20128i = new w<>();

    /* compiled from: ApolloBleUpdate.kt */
    /* loaded from: classes2.dex */
    public static final class a implements d.b {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(c this$0, int i10) {
            i.f(this$0, "this$0");
            f.a aVar = this$0.f20123d;
            if (aVar != null) {
                aVar.d(i10);
            }
        }

        @Override // com.mobvoi.apollo.client.d.b
        public void a(BluetoothDevice device, ClientState newState) {
            i.f(device, "device");
            i.f(newState, "newState");
            d.b.a.g(this, device, newState);
        }

        @Override // com.mobvoi.apollo.client.d.b
        public void b(ka.a packet) {
            f.a aVar;
            byte[] c10;
            i.f(packet, "packet");
            int a10 = packet.a();
            if (a10 == 352) {
                byte[] c11 = packet.c();
                if (c11 != null) {
                    c cVar = c.this;
                    WatchInfo watchInfo = (WatchInfo) new e().j(new String(c11, kotlin.text.d.f30092a), WatchInfo.class);
                    if (watchInfo != null && !i.b(watchInfo.getFotaVersion(), cVar.f20126g) && (aVar = cVar.f20123d) != null) {
                        aVar.d(4);
                    }
                }
            } else if (a10 == 404 && (c10 = packet.c()) != null) {
                final c cVar2 = c.this;
                final int i10 = c10[0] == 0 ? 3 : 5;
                com.mobvoi.android.common.utils.l.a().post(new Runnable() { // from class: com.mobvoi.mcuwatch.ui.settings.ota.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.a.f(c.this, i10);
                    }
                });
            }
        }

        @Override // com.mobvoi.apollo.client.d.b
        public void c() {
            d.b.a.f(this);
        }

        @Override // com.mobvoi.apollo.client.d.b
        public void d(int i10, int i11) {
            d.b.a.e(this, i10, i11);
        }

        @Override // com.mobvoi.apollo.client.d.b
        public void i(boolean z10) {
            d.b.a.c(this, z10);
        }

        @Override // com.mobvoi.apollo.client.d.b
        public void k(BluetoothDevice bluetoothDevice, da.a aVar) {
            d.b.a.a(this, bluetoothDevice, aVar);
        }

        @Override // com.mobvoi.apollo.client.d.b
        public void m() {
            d.b.a.d(this);
        }
    }

    /* compiled from: ApolloBleUpdate.kt */
    /* loaded from: classes2.dex */
    public static final class b implements rx.d<h> {
        b() {
        }

        /* renamed from: b */
        public void onNext(h t10) {
            i.f(t10, "t");
            c.this.f20124e = t10;
            c.this.i().m(t10.a().e());
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable e10) {
            i.f(e10, "e");
            e10.printStackTrace();
            c.this.i().m(null);
        }
    }

    /* compiled from: ApolloBleUpdate.kt */
    /* renamed from: com.mobvoi.mcuwatch.ui.settings.ota.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0232c extends Lambda implements qo.l<Boolean, m> {
        final /* synthetic */ File $file;
        final /* synthetic */ c this$0;

        /* compiled from: ApolloBleUpdate.kt */
        /* renamed from: com.mobvoi.mcuwatch.ui.settings.ota.c$c$a */
        /* loaded from: classes2.dex */
        public static final class a implements ea.c {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f20131a;

            a(c cVar) {
                this.f20131a = cVar;
            }

            @Override // ea.c
            public void a(int i10) {
                f.a aVar = this.f20131a.f20123d;
                if (aVar != null) {
                    aVar.d(5);
                }
            }

            @Override // ea.c
            public void b(int i10) {
                f.a aVar = this.f20131a.f20123d;
                if (aVar != null) {
                    aVar.b(i10);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0232c(File file, c cVar) {
            super(1);
            this.$file = file;
            this.this$0 = cVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(c this$0) {
            i.f(this$0, "this$0");
            f.a aVar = this$0.f20123d;
            if (aVar != null) {
                aVar.d(2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(c this$0) {
            i.f(this$0, "this$0");
            f.a aVar = this$0.f20123d;
            if (aVar != null) {
                aVar.d(5);
            }
        }

        public final void c(boolean z10) {
            byte[] a10;
            if (z10) {
                com.mobvoi.android.common.utils.l a11 = com.mobvoi.android.common.utils.l.a();
                final c cVar = this.this$0;
                a11.post(new Runnable() { // from class: com.mobvoi.mcuwatch.ui.settings.ota.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.C0232c.d(c.this);
                    }
                });
                q qVar = q.f15504a;
                a10 = g.a(this.$file);
                qVar.P(a10, new a(this.this$0));
                return;
            }
            com.mobvoi.android.common.utils.l a12 = com.mobvoi.android.common.utils.l.a();
            final c cVar2 = this.this$0;
            a12.post(new Runnable() { // from class: com.mobvoi.mcuwatch.ui.settings.ota.e
                @Override // java.lang.Runnable
                public final void run() {
                    c.C0232c.g(c.this);
                }
            });
        }

        @Override // qo.l
        public /* bridge */ /* synthetic */ m invoke(Boolean bool) {
            c(bool.booleanValue());
            return m.f28349a;
        }
    }

    public c() {
        Application e10 = com.mobvoi.android.common.utils.b.e();
        i.e(e10, "getApplication()");
        this.f20120a = new l(e10, this);
        a aVar = new a();
        this.f20121b = aVar;
        Application e11 = com.mobvoi.android.common.utils.b.e();
        i.e(e11, "getApplication()");
        r rVar = new r(e11);
        this.f20122c = rVar;
        this.f20126g = rVar.e();
        q.f15504a.j(aVar);
        l();
    }

    private final void l() {
        this.f20125f = this.f20120a.s().H(xp.a.b()).U(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(c this$0, int i10) {
        i.f(this$0, "this$0");
        f.a aVar = this$0.f20123d;
        if (aVar != null) {
            aVar.b(i10);
        }
    }

    @Override // com.mobvoi.mcuwatch.ui.settings.ota.f
    public String a() {
        return this.f20122c.l();
    }

    @Override // ha.l.a
    public void b() {
        h hVar = this.f20124e;
        i.d(hVar);
        ia.g a10 = hVar.a();
        File y10 = this.f20120a.y();
        q.f15504a.D(new RoomInfo(a10.e(), (int) y10.length(), a10.d()), new C0232c(y10, this));
    }

    @Override // com.mobvoi.mcuwatch.ui.settings.ota.f
    public int c() {
        return this.f20127h;
    }

    @Override // com.mobvoi.mcuwatch.ui.settings.ota.f
    public boolean d() {
        return this.f20124e != null;
    }

    @Override // com.mobvoi.mcuwatch.ui.settings.ota.f
    public void g(f.a aVar) {
        this.f20123d = aVar;
    }

    @Override // com.mobvoi.mcuwatch.ui.settings.ota.f
    public w<String> i() {
        return this.f20128i;
    }

    @Override // com.mobvoi.mcuwatch.ui.settings.ota.f
    public void j() {
        this.f20120a.w();
        f.a aVar = this.f20123d;
        if (aVar != null) {
            aVar.d(1);
        }
    }

    @Override // ha.l.a
    public void onProgress(final int i10) {
        com.mobvoi.android.common.utils.l.a().post(new Runnable() { // from class: com.mobvoi.mcuwatch.ui.settings.ota.a
            @Override // java.lang.Runnable
            public final void run() {
                c.m(c.this, i10);
            }
        });
    }

    @Override // com.mobvoi.mcuwatch.ui.settings.ota.f
    public void release() {
        q.f15504a.J(this.f20121b);
        j jVar = this.f20125f;
        if (jVar != null && !jVar.isUnsubscribed()) {
            jVar.unsubscribe();
        }
        this.f20123d = null;
    }
}
