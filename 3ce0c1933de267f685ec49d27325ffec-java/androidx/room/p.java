package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.k;
import androidx.room.l;
import androidx.room.o;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MultiInstanceInvalidationClient.java */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    final Context f4308a;

    /* renamed from: b  reason: collision with root package name */
    final String f4309b;

    /* renamed from: c  reason: collision with root package name */
    int f4310c;

    /* renamed from: d  reason: collision with root package name */
    final o f4311d;

    /* renamed from: e  reason: collision with root package name */
    final o.c f4312e;

    /* renamed from: f  reason: collision with root package name */
    l f4313f;

    /* renamed from: g  reason: collision with root package name */
    final Executor f4314g;

    /* renamed from: j  reason: collision with root package name */
    final ServiceConnection f4317j;

    /* renamed from: h  reason: collision with root package name */
    final k f4315h = new a();

    /* renamed from: i  reason: collision with root package name */
    final AtomicBoolean f4316i = new AtomicBoolean(false);

    /* renamed from: k  reason: collision with root package name */
    final Runnable f4318k = new c();

    /* renamed from: l  reason: collision with root package name */
    final Runnable f4319l = new d();

    /* compiled from: MultiInstanceInvalidationClient.java */
    /* loaded from: classes.dex */
    class a extends k.a {

        /* compiled from: MultiInstanceInvalidationClient.java */
        /* renamed from: androidx.room.p$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0047a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String[] f4321a;

            RunnableC0047a(String[] strArr) {
                this.f4321a = strArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                p.this.f4311d.h(this.f4321a);
            }
        }

        a() {
        }

        @Override // androidx.room.k
        public void H(String[] strArr) {
            p.this.f4314g.execute(new RunnableC0047a(strArr));
        }
    }

    /* compiled from: MultiInstanceInvalidationClient.java */
    /* loaded from: classes.dex */
    class b implements ServiceConnection {
        b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            p.this.f4313f = l.a.c(iBinder);
            p pVar = p.this;
            pVar.f4314g.execute(pVar.f4318k);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            p pVar = p.this;
            pVar.f4314g.execute(pVar.f4319l);
            p.this.f4313f = null;
        }
    }

    /* compiled from: MultiInstanceInvalidationClient.java */
    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                p pVar = p.this;
                l lVar = pVar.f4313f;
                if (lVar != null) {
                    pVar.f4310c = lVar.U(pVar.f4315h, pVar.f4309b);
                    p pVar2 = p.this;
                    pVar2.f4311d.a(pVar2.f4312e);
                }
            } catch (RemoteException e10) {
                Log.w("ROOM", "Cannot register multi-instance invalidation callback", e10);
            }
        }
    }

    /* compiled from: MultiInstanceInvalidationClient.java */
    /* loaded from: classes.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            p pVar = p.this;
            pVar.f4311d.k(pVar.f4312e);
        }
    }

    /* compiled from: MultiInstanceInvalidationClient.java */
    /* loaded from: classes.dex */
    class e extends o.c {
        e(String[] strArr) {
            super(strArr);
        }

        @Override // androidx.room.o.c
        boolean a() {
            return true;
        }

        @Override // androidx.room.o.c
        public void b(Set<String> set) {
            if (!p.this.f4316i.get()) {
                try {
                    p pVar = p.this;
                    l lVar = pVar.f4313f;
                    if (lVar != null) {
                        lVar.g2(pVar.f4310c, (String[]) set.toArray(new String[0]));
                    }
                } catch (RemoteException e10) {
                    Log.w("ROOM", "Cannot broadcast invalidation", e10);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Context context, String str, o oVar, Executor executor) {
        b bVar = new b();
        this.f4317j = bVar;
        Context applicationContext = context.getApplicationContext();
        this.f4308a = applicationContext;
        this.f4309b = str;
        this.f4311d = oVar;
        this.f4314g = executor;
        this.f4312e = new e((String[]) oVar.f4283a.keySet().toArray(new String[0]));
        applicationContext.bindService(new Intent(applicationContext, MultiInstanceInvalidationService.class), bVar, 1);
    }
}
