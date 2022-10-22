package com.euicc.server;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.euicc.server.IRemoteService;
import com.euicc.server.a;
import com.euicc.server.c;
import com.euicc.server.model.EUICCDeviceInfo;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.msgproxy.MessageInfo;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import com.mobvoi.wear.msgproxy.MessageProxyListener;
import com.mobvoi.wear.msgproxy.NodeInfo;
import java.util.List;
/* loaded from: classes.dex */
public class IRemoteService extends Service implements MessageProxyListener {

    /* renamed from: a  reason: collision with root package name */
    private com.euicc.server.model.a f8254a;

    /* renamed from: c  reason: collision with root package name */
    private Handler f8256c;

    /* renamed from: b  reason: collision with root package name */
    private boolean f8255b = false;

    /* renamed from: d  reason: collision with root package name */
    private final com.mobvoi.companion.receiver.a f8257d = new a();

    /* renamed from: e  reason: collision with root package name */
    private final IBinder f8258e = new b();

    /* renamed from: f  reason: collision with root package name */
    private final IBinder f8259f = new c();

    /* loaded from: classes.dex */
    class a extends com.mobvoi.companion.receiver.a {
        a() {
        }

        @Override // com.mobvoi.companion.receiver.a
        protected void b(String str, Intent intent) {
            if ("com.mobvoi.baiding.ACTION.APOLLO_ESIM_GET_EID_RESP".equals(str)) {
                String stringExtra = intent.getStringExtra("apollo_esim_extra_imei");
                String stringExtra2 = intent.getStringExtra("apollo_esim_extra_eid");
                k.c("IRemoteService", "apollo watch: imei = %s, eid = %s", stringExtra, stringExtra2);
                EUICCDeviceInfo eUICCDeviceInfo = new EUICCDeviceInfo();
                eUICCDeviceInfo.a(stringExtra);
                eUICCDeviceInfo.c(stringExtra2);
                eUICCDeviceInfo.d(1);
                eUICCDeviceInfo.b(2);
                if (IRemoteService.this.f8254a != null) {
                    try {
                        IRemoteService.this.f8254a.y2(eUICCDeviceInfo);
                    } catch (RemoteException e10) {
                        k.f("IRemoteService", "Error happens when invoke getDeviceEUICCInfo(): %s", e10.getMessage());
                    }
                }
            }
        }

        @Override // com.mobvoi.companion.receiver.a
        protected IntentFilter c() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.mobvoi.baiding.ACTION.APOLLO_ESIM_GET_EID_RESP");
            return intentFilter;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends a.AbstractBinderC0102a {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m1() {
            IRemoteService.this.f8257d.f(IRemoteService.this);
            if (IRemoteService.this.f8254a != null && !IRemoteService.this.f8255b) {
                k.a("IRemoteService", "callback not null");
                EUICCDeviceInfo eUICCDeviceInfo = new EUICCDeviceInfo();
                eUICCDeviceInfo.d(-2);
                eUICCDeviceInfo.b(2);
                try {
                    IRemoteService.this.f8254a.y2(eUICCDeviceInfo);
                } catch (RemoteException unused) {
                    k.a("IRemoteService", "callback null");
                }
            }
        }

        @Override // com.euicc.server.a
        public void I1() throws RemoteException {
            k.a("IRemoteService", "getAttachedDeviceEUICCInfo");
            if (TextUtils.isEmpty(ta.a.s())) {
                k.a("IRemoteService", "VPA user is not logged in. Do not return EID.");
                EUICCDeviceInfo eUICCDeviceInfo = new EUICCDeviceInfo();
                eUICCDeviceInfo.d(0);
                eUICCDeviceInfo.b(2);
                try {
                    IRemoteService.this.f8254a.y2(eUICCDeviceInfo);
                } catch (RemoteException unused) {
                    k.a("IRemoteService", "callback null");
                }
            } else {
                b1.a.b(IRemoteService.this).d(new Intent("com.mobvoi.baiding.ACTION.APOLLO_ESIM_GET_EID_REQ"));
                MessageProxyClient.getInstance().sendMessage(WearPath.Lpa.GET_IEMI_AND_EID_PATH);
                IRemoteService.this.f8256c.postDelayed(new Runnable() { // from class: com.euicc.server.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        IRemoteService.b.this.m1();
                    }
                }, 5000L);
            }
        }

        @Override // com.euicc.server.a
        public void U0(com.euicc.server.model.a aVar) throws RemoteException {
            k.a("IRemoteService", "unregisterCallback");
            IRemoteService.this.f8257d.f(IRemoteService.this);
            IRemoteService.this.f8254a = null;
        }

        @Override // com.euicc.server.a
        public void n1(com.euicc.server.model.a aVar) throws RemoteException {
            k.a("IRemoteService", "registerCallback");
            IRemoteService.this.f8254a = aVar;
            IRemoteService.this.f8257d.d(IRemoteService.this);
        }

        @Override // com.euicc.server.a
        public void p1(String str) throws RemoteException {
            k.h("IRemoteService", str);
            MessageProxyClient.getInstance().sendMessage(WearPath.Lpa.START_DOWNLOAD_PATH, str.getBytes());
            Intent intent = new Intent("com.mobvoi.baiding.ACTION.APOLLO_ESIM_DOWNLOAD_PROFILE_REQ");
            intent.putExtra("apollo_esim_extra_activation_code", str);
            b1.a.b(IRemoteService.this).d(intent);
        }
    }

    /* loaded from: classes.dex */
    class c extends c.a {
        c() {
        }

        @Override // com.euicc.server.c
        public IBinder d(String str) throws RemoteException {
            if (IRemoteService.this.getPackageManager().getPackagesForUid(Binder.getCallingUid()) == null) {
                return null;
            }
            for (String str2 : IRemoteService.this.getPackageManager().getPackagesForUid(Binder.getCallingUid())) {
                if ("com.sinovatech.unicom.ui".equals(str2)) {
                    return IRemoteService.this.f8258e;
                }
            }
            return null;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        k.a("IRemoteService", "onBind");
        MessageProxyClient.getInstance().addListener(this);
        this.f8256c = new Handler(getMainLooper());
        return this.f8259f;
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
    public void onConnectedNodesChanged(List<NodeInfo> list) {
        k.a("IRemoteService", "onConnectedNodesChanged, " + list);
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
    public void onMessageReceived(MessageInfo messageInfo) {
        k.a("IRemoteService", "onMessageReceived() A message from watch was received:" + messageInfo.getNodeId() + " " + messageInfo.getPath());
        if (WearPath.Lpa.IEMI_AND_EID_RESULT_PATH.equals(messageInfo.getPath())) {
            String[] split = new String(messageInfo.getPayload()).split("###");
            try {
                if (this.f8254a != null) {
                    k.a("IRemoteService", "callback not null");
                    this.f8255b = true;
                    if (this.f8256c != null) {
                        k.a("IRemoteService", "Remove handler message");
                        this.f8256c.removeCallbacksAndMessages(null);
                    }
                    if (split.length >= 2) {
                        EUICCDeviceInfo eUICCDeviceInfo = new EUICCDeviceInfo();
                        eUICCDeviceInfo.a(split[0]);
                        eUICCDeviceInfo.c(split[1]);
                        k.c("IRemoteService", "imei = %s, eid = %s", split[0], split[1]);
                        eUICCDeviceInfo.d(1);
                        eUICCDeviceInfo.b(2);
                        this.f8254a.y2(eUICCDeviceInfo);
                        return;
                    }
                    k.a("IRemoteService", "results null");
                } else {
                    k.a("IRemoteService", "callback null");
                }
                EUICCDeviceInfo eUICCDeviceInfo2 = new EUICCDeviceInfo();
                eUICCDeviceInfo2.d(0);
                this.f8254a.y2(eUICCDeviceInfo2);
            } catch (RemoteException e10) {
                k.e("IRemoteService", "RemoteException,", e10);
            }
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        k.a("IRemoteService", "onUnbind");
        this.f8257d.f(this);
        MessageProxyClient.getInstance().removeListener(this);
        this.f8256c.removeCallbacksAndMessages(null);
        return super.onUnbind(intent);
    }
}
