package com.google.android.gms.wearable;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import c7.e;
import c7.x0;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.ChannelClient;
import com.google.android.gms.wearable.a;
import com.google.android.gms.wearable.h;
import com.google.android.gms.wearable.internal.g;
import com.google.android.gms.wearable.internal.zzah;
import com.google.android.gms.wearable.internal.zzaw;
import com.google.android.gms.wearable.internal.zzfe;
import com.google.android.gms.wearable.internal.zzfo;
import com.google.android.gms.wearable.internal.zzi;
import com.google.android.gms.wearable.internal.zzl;
import h6.p;
import java.util.List;
/* loaded from: classes.dex */
public class m extends Service implements a.AbstractC0116a, com.google.android.gms.wearable.c, com.google.android.gms.wearable.d, h.a {
    public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
    private ComponentName service;
    private c zzad;
    private IBinder zzae;
    private Intent zzaf;
    private Looper zzag;
    private boolean zzai;
    private final Object zzah = new Object();
    private e zzaj = new e(new a());

    /* loaded from: classes.dex */
    class a extends ChannelClient.a {
        private a() {
        }

        @Override // com.google.android.gms.wearable.ChannelClient.a
        public final void a(ChannelClient.Channel channel, int i10, int i11) {
            m.this.onChannelClosed(channel, i10, i11);
        }

        @Override // com.google.android.gms.wearable.ChannelClient.a
        public final void b(ChannelClient.Channel channel) {
            m.this.onChannelOpened(channel);
        }

        @Override // com.google.android.gms.wearable.ChannelClient.a
        public final void c(ChannelClient.Channel channel, int i10, int i11) {
            m.this.onInputClosed(channel, i10, i11);
        }

        @Override // com.google.android.gms.wearable.ChannelClient.a
        public final void d(ChannelClient.Channel channel, int i10, int i11) {
            m.this.onOutputClosed(channel, i10, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements ServiceConnection {
        private b(m mVar) {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class c extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private boolean f10321a;

        /* renamed from: b  reason: collision with root package name */
        private final b f10322b;

        c(Looper looper) {
            super(looper);
            this.f10322b = new b();
        }

        @SuppressLint({"UntrackedBindService"})
        private final synchronized void b() {
            if (!this.f10321a) {
                if (Log.isLoggable("WearableLS", 2)) {
                    String valueOf = String.valueOf(m.this.service);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 13);
                    sb2.append("bindService: ");
                    sb2.append(valueOf);
                    Log.v("WearableLS", sb2.toString());
                }
                m mVar = m.this;
                mVar.bindService(mVar.zzaf, this.f10322b, 1);
                this.f10321a = true;
            }
        }

        @SuppressLint({"UntrackedBindService"})
        private final synchronized void c(String str) {
            if (this.f10321a) {
                if (Log.isLoggable("WearableLS", 2)) {
                    String valueOf = String.valueOf(m.this.service);
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 17 + valueOf.length());
                    sb2.append("unbindService: ");
                    sb2.append(str);
                    sb2.append(", ");
                    sb2.append(valueOf);
                    Log.v("WearableLS", sb2.toString());
                }
                try {
                    m.this.unbindService(this.f10322b);
                } catch (RuntimeException e10) {
                    Log.e("WearableLS", "Exception when unbinding from local service", e10);
                }
                this.f10321a = false;
            }
        }

        final void a() {
            getLooper().quit();
            c("quit");
        }

        @Override // android.os.Handler
        public final void dispatchMessage(Message message) {
            b();
            try {
                super.dispatchMessage(message);
            } finally {
                if (!hasMessages(0)) {
                    c("dispatch");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class d extends g {

        /* renamed from: a  reason: collision with root package name */
        private volatile int f10324a;

        private d() {
            this.f10324a = -1;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0074 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0075  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final boolean m1(Runnable runnable, String str, Object obj) {
            boolean z10;
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", String.format("%s: %s %s", str, m.this.service.toString(), obj));
            }
            int callingUid = Binder.getCallingUid();
            if (callingUid != this.f10324a) {
                if (x0.a(m.this).e("com.google.android.wearable.app.cn") && p.b(m.this, callingUid, "com.google.android.wearable.app.cn")) {
                    this.f10324a = callingUid;
                } else if (p.a(m.this, callingUid)) {
                    this.f10324a = callingUid;
                } else {
                    StringBuilder sb2 = new StringBuilder(57);
                    sb2.append("Caller is not GooglePlayServices; caller UID: ");
                    sb2.append(callingUid);
                    Log.e("WearableLS", sb2.toString());
                    z10 = false;
                    if (z10) {
                        return false;
                    }
                    synchronized (m.this.zzah) {
                        if (m.this.zzai) {
                            return false;
                        }
                        m.this.zzad.post(runnable);
                        return true;
                    }
                }
            }
            z10 = true;
            if (z10) {
            }
        }

        @Override // com.google.android.gms.wearable.internal.f
        public final void C0(zzfe zzfeVar) {
            m1(new w(this, zzfeVar), "onMessageReceived", zzfeVar);
        }

        @Override // com.google.android.gms.wearable.internal.f
        public final void D(DataHolder dataHolder) {
            v vVar = new v(this, dataHolder);
            try {
                String valueOf = String.valueOf(dataHolder);
                int count = dataHolder.getCount();
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 18);
                sb2.append(valueOf);
                sb2.append(", rows=");
                sb2.append(count);
                if (m1(vVar, "onDataItemChanged", sb2.toString())) {
                }
            } finally {
                dataHolder.close();
            }
        }

        @Override // com.google.android.gms.wearable.internal.f
        public final void M1(zzl zzlVar) {
            m1(new b0(this, zzlVar), "onNotificationReceived", zzlVar);
        }

        @Override // com.google.android.gms.wearable.internal.f
        public final void T(zzfo zzfoVar) {
            m1(new x(this, zzfoVar), "onPeerConnected", zzfoVar);
        }

        @Override // com.google.android.gms.wearable.internal.f
        public final void a(zzaw zzawVar) {
            m1(new d0(this, zzawVar), "onChannelEvent", zzawVar);
        }

        @Override // com.google.android.gms.wearable.internal.f
        public final void a0(zzah zzahVar) {
            m1(new a0(this, zzahVar), "onConnectedCapabilityChanged", zzahVar);
        }

        @Override // com.google.android.gms.wearable.internal.f
        public final void s1(zzfo zzfoVar) {
            m1(new y(this, zzfoVar), "onPeerDisconnected", zzfoVar);
        }

        @Override // com.google.android.gms.wearable.internal.f
        public final void t0(zzi zziVar) {
            m1(new c0(this, zziVar), "onEntityUpdate", zziVar);
        }

        @Override // com.google.android.gms.wearable.internal.f
        public final void z2(List<zzfo> list) {
            m1(new z(this, list), "onConnectedNodes", list);
        }
    }

    public Looper getLooper() {
        if (this.zzag == null) {
            HandlerThread handlerThread = new HandlerThread("WearableListenerService");
            handlerThread.start();
            this.zzag = handlerThread.getLooper();
        }
        return this.zzag;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        if (BIND_LISTENER_INTENT_ACTION.equals(intent.getAction())) {
            return this.zzae;
        }
        return null;
    }

    @Override // com.google.android.gms.wearable.a.AbstractC0116a
    public void onCapabilityChanged(com.google.android.gms.wearable.b bVar) {
        throw null;
    }

    @Override // com.google.android.gms.wearable.c
    public void onChannelClosed(Channel channel, int i10, int i11) {
    }

    public void onChannelClosed(ChannelClient.Channel channel, int i10, int i11) {
    }

    @Override // com.google.android.gms.wearable.c
    public void onChannelOpened(Channel channel) {
    }

    public void onChannelOpened(ChannelClient.Channel channel) {
    }

    public void onConnectedNodes(List<j> list) {
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.service = new ComponentName(this, getClass().getName());
        if (Log.isLoggable("WearableLS", 3)) {
            String valueOf = String.valueOf(this.service);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 10);
            sb2.append("onCreate: ");
            sb2.append(valueOf);
            Log.d("WearableLS", sb2.toString());
        }
        this.zzad = new c(getLooper());
        Intent intent = new Intent(BIND_LISTENER_INTENT_ACTION);
        this.zzaf = intent;
        intent.setComponent(this.service);
        this.zzae = new d();
    }

    @Override // com.google.android.gms.wearable.d
    public void onDataChanged(e eVar) {
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (Log.isLoggable("WearableLS", 3)) {
            String valueOf = String.valueOf(this.service);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 11);
            sb2.append("onDestroy: ");
            sb2.append(valueOf);
            Log.d("WearableLS", sb2.toString());
        }
        synchronized (this.zzah) {
            this.zzai = true;
            c cVar = this.zzad;
            if (cVar != null) {
                cVar.a();
            } else {
                String valueOf2 = String.valueOf(this.service);
                StringBuilder sb3 = new StringBuilder(valueOf2.length() + 111);
                sb3.append("onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()? component=");
                sb3.append(valueOf2);
                throw new IllegalStateException(sb3.toString());
            }
        }
        super.onDestroy();
    }

    public void onEntityUpdate(o oVar) {
    }

    @Override // com.google.android.gms.wearable.c
    public void onInputClosed(Channel channel, int i10, int i11) {
    }

    public void onInputClosed(ChannelClient.Channel channel, int i10, int i11) {
    }

    @Override // com.google.android.gms.wearable.h.a
    public void onMessageReceived(i iVar) {
        throw null;
    }

    public void onNotificationReceived(p pVar) {
    }

    @Override // com.google.android.gms.wearable.c
    public void onOutputClosed(Channel channel, int i10, int i11) {
    }

    public void onOutputClosed(ChannelClient.Channel channel, int i10, int i11) {
    }

    public void onPeerConnected(j jVar) {
    }

    public void onPeerDisconnected(j jVar) {
    }
}
