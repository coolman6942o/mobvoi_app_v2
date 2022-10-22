package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import b6.i;
import g6.a;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b0 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    int f12466a;

    /* renamed from: b  reason: collision with root package name */
    final Messenger f12467b;

    /* renamed from: c  reason: collision with root package name */
    g0 f12468c;

    /* renamed from: d  reason: collision with root package name */
    final Queue<b<?>> f12469d;

    /* renamed from: e  reason: collision with root package name */
    final SparseArray<b<?>> f12470e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ z f12471f;

    private b0(z zVar) {
        this.f12471f = zVar;
        this.f12466a = 0;
        this.f12467b = new Messenger(new Handler(Looper.getMainLooper(), new Handler.Callback(this) { // from class: com.google.firebase.iid.c0

            /* renamed from: a  reason: collision with root package name */
            private final b0 f12472a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12472a = this;
            }

            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f12472a.c(message);
            }
        }));
        this.f12469d = new ArrayDeque();
        this.f12470e = new SparseArray<>();
    }

    private final void e() {
        ScheduledExecutorService scheduledExecutorService;
        scheduledExecutorService = this.f12471f.f12530b;
        scheduledExecutorService.execute(new Runnable(this) { // from class: com.google.firebase.iid.e0

            /* renamed from: a  reason: collision with root package name */
            private final b0 f12476a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12476a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                final b<?> poll;
                ScheduledExecutorService scheduledExecutorService2;
                Context context;
                final b0 b0Var = this.f12476a;
                while (true) {
                    synchronized (b0Var) {
                        if (b0Var.f12466a == 2) {
                            if (b0Var.f12469d.isEmpty()) {
                                b0Var.f();
                                return;
                            }
                            poll = b0Var.f12469d.poll();
                            b0Var.f12470e.put(poll.f12462a, poll);
                            scheduledExecutorService2 = b0Var.f12471f.f12530b;
                            scheduledExecutorService2.schedule(new Runnable(b0Var, poll) { // from class: com.google.firebase.iid.f0

                                /* renamed from: a  reason: collision with root package name */
                                private final b0 f12478a;

                                /* renamed from: b  reason: collision with root package name */
                                private final b f12479b;

                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    this.f12478a = b0Var;
                                    this.f12479b = poll;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f12478a.a(this.f12479b.f12462a);
                                }
                            }, 30L, TimeUnit.SECONDS);
                        } else {
                            return;
                        }
                    }
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        String valueOf = String.valueOf(poll);
                        StringBuilder sb2 = new StringBuilder(valueOf.length() + 8);
                        sb2.append("Sending ");
                        sb2.append(valueOf);
                        Log.d("MessengerIpcClient", sb2.toString());
                    }
                    context = b0Var.f12471f.f12529a;
                    Messenger messenger = b0Var.f12467b;
                    Message obtain = Message.obtain();
                    obtain.what = poll.f12464c;
                    obtain.arg1 = poll.f12462a;
                    obtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", poll.d());
                    bundle.putString("pkg", context.getPackageName());
                    bundle.putBundle("data", poll.f12465d);
                    obtain.setData(bundle);
                    try {
                        b0Var.f12468c.a(obtain);
                    } catch (RemoteException e10) {
                        b0Var.b(2, e10.getMessage());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void a(int i10) {
        b<?> bVar = this.f12470e.get(i10);
        if (bVar != null) {
            StringBuilder sb2 = new StringBuilder(31);
            sb2.append("Timing out request: ");
            sb2.append(i10);
            Log.w("MessengerIpcClient", sb2.toString());
            this.f12470e.remove(i10);
            bVar.b(new zzac(3, "Timed out waiting for response"));
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void b(int i10, String str) {
        Context context;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(str);
            Log.d("MessengerIpcClient", valueOf.length() != 0 ? "Disconnected: ".concat(valueOf) : new String("Disconnected: "));
        }
        int i11 = this.f12466a;
        if (i11 == 0) {
            throw new IllegalStateException();
        } else if (i11 == 1 || i11 == 2) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Unbinding service");
            }
            this.f12466a = 4;
            a b10 = a.b();
            context = this.f12471f.f12529a;
            b10.c(context, this);
            zzac zzacVar = new zzac(i10, str);
            for (b<?> bVar : this.f12469d) {
                bVar.b(zzacVar);
            }
            this.f12469d.clear();
            for (int i12 = 0; i12 < this.f12470e.size(); i12++) {
                this.f12470e.valueAt(i12).b(zzacVar);
            }
            this.f12470e.clear();
        } else if (i11 == 3) {
            this.f12466a = 4;
        } else if (i11 != 4) {
            int i13 = this.f12466a;
            StringBuilder sb2 = new StringBuilder(26);
            sb2.append("Unknown state: ");
            sb2.append(i13);
            throw new IllegalStateException(sb2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean c(Message message) {
        int i10 = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            StringBuilder sb2 = new StringBuilder(41);
            sb2.append("Received response to request: ");
            sb2.append(i10);
            Log.d("MessengerIpcClient", sb2.toString());
        }
        synchronized (this) {
            b<?> bVar = this.f12470e.get(i10);
            if (bVar == null) {
                StringBuilder sb3 = new StringBuilder(50);
                sb3.append("Received response for unknown request: ");
                sb3.append(i10);
                Log.w("MessengerIpcClient", sb3.toString());
                return true;
            }
            this.f12470e.remove(i10);
            f();
            Bundle data = message.getData();
            if (data.getBoolean("unsupported", false)) {
                bVar.b(new zzac(4, "Not supported by GmsCore"));
            } else {
                bVar.c(data);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized boolean d(b bVar) {
        Context context;
        ScheduledExecutorService scheduledExecutorService;
        int i10 = this.f12466a;
        if (i10 == 0) {
            this.f12469d.add(bVar);
            i.n(this.f12466a == 0);
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Starting bind to GmsCore");
            }
            this.f12466a = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            a b10 = a.b();
            context = this.f12471f.f12529a;
            if (!b10.a(context, intent, this, 1)) {
                b(0, "Unable to bind to service");
            } else {
                scheduledExecutorService = this.f12471f.f12530b;
                scheduledExecutorService.schedule(new Runnable(this) { // from class: com.google.firebase.iid.d0

                    /* renamed from: a  reason: collision with root package name */
                    private final b0 f12474a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f12474a = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f12474a.g();
                    }
                }, 30L, TimeUnit.SECONDS);
            }
            return true;
        } else if (i10 == 1) {
            this.f12469d.add(bVar);
            return true;
        } else if (i10 != 2) {
            if (!(i10 == 3 || i10 == 4)) {
                int i11 = this.f12466a;
                StringBuilder sb2 = new StringBuilder(26);
                sb2.append("Unknown state: ");
                sb2.append(i11);
                throw new IllegalStateException(sb2.toString());
            }
            return false;
        } else {
            this.f12469d.add(bVar);
            e();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void f() {
        Context context;
        if (this.f12466a == 2 && this.f12469d.isEmpty() && this.f12470e.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.f12466a = 3;
            a b10 = a.b();
            context = this.f12471f.f12529a;
            b10.c(context, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void g() {
        if (this.f12466a == 1) {
            b(1, "Timed out while binding");
        }
    }

    @Override // android.content.ServiceConnection
    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        if (iBinder == null) {
            b(0, "Null service connection");
            return;
        }
        try {
            this.f12468c = new g0(iBinder);
            this.f12466a = 2;
            e();
        } catch (RemoteException e10) {
            b(0, e10.getMessage());
        }
    }

    @Override // android.content.ServiceConnection
    public final synchronized void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        b(2, "Service disconnected");
    }
}
