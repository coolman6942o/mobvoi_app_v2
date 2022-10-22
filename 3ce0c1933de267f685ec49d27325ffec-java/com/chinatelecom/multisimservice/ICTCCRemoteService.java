package com.chinatelecom.multisimservice;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import com.chinatelecom.multisimservice.ICTCCRemoteService;
import com.chinatelecom.multisimservice.b;
import com.chinatelecom.multisimservice.c;
import com.chinatelecom.multisimservice.model.MultiSimDeviceInfo;
import com.chinatelecom.multisimservice.model.SmartWearServiceInfo;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.msgproxy.MessageInfo;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import com.mobvoi.wear.msgproxy.MessageProxyListener;
import com.mobvoi.wear.msgproxy.NodeInfo;
import java.util.List;
/* loaded from: classes.dex */
public class ICTCCRemoteService extends Service implements MessageProxyListener {

    /* renamed from: a  reason: collision with root package name */
    private com.chinatelecom.multisimservice.model.a f8205a;

    /* renamed from: b  reason: collision with root package name */
    private com.chinatelecom.multisimservice.model.b f8206b;

    /* renamed from: d  reason: collision with root package name */
    private Handler f8208d;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8207c = false;

    /* renamed from: e  reason: collision with root package name */
    private final com.mobvoi.companion.receiver.a f8209e = new a();

    /* renamed from: f  reason: collision with root package name */
    private final IBinder f8210f = new b();

    /* renamed from: g  reason: collision with root package name */
    private final IBinder f8211g = new c();

    /* loaded from: classes.dex */
    class a extends com.mobvoi.companion.receiver.a {
        a() {
        }

        @Override // com.mobvoi.companion.receiver.a
        protected void b(String str, Intent intent) {
            if ("com.mobvoi.baiding.ACTION.APOLLO_ESIM_GET_EID_RESP".equals(str)) {
                String stringExtra = intent.getStringExtra("apollo_esim_extra_imei");
                String stringExtra2 = intent.getStringExtra("apollo_esim_extra_eid");
                k.c("ICtccRemoteService", "apollo watch: imei = %s, eid = %s", stringExtra, stringExtra2);
                MultiSimDeviceInfo multiSimDeviceInfo = new MultiSimDeviceInfo();
                multiSimDeviceInfo.a(stringExtra);
                multiSimDeviceInfo.c(stringExtra2);
                multiSimDeviceInfo.d(1);
                multiSimDeviceInfo.b(2);
                if (ICTCCRemoteService.this.f8205a != null) {
                    try {
                        ICTCCRemoteService.this.f8205a.s2(multiSimDeviceInfo);
                    } catch (RemoteException e10) {
                        k.f("ICtccRemoteService", "Error happens when invoke getDeviceEUICCInfo(): %s", e10.getMessage());
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
    public class b extends b.a {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m1() {
            ICTCCRemoteService.this.f8209e.f(ICTCCRemoteService.this);
            if (ICTCCRemoteService.this.f8205a != null && !ICTCCRemoteService.this.f8207c) {
                k.a("ICtccRemoteService", "callback not null");
                MultiSimDeviceInfo multiSimDeviceInfo = new MultiSimDeviceInfo();
                multiSimDeviceInfo.d(-2);
                multiSimDeviceInfo.b(2);
                try {
                    ICTCCRemoteService.this.f8205a.s2(multiSimDeviceInfo);
                } catch (RemoteException unused) {
                    k.a("ICtccRemoteService", "callback null");
                }
            }
        }

        @Override // com.chinatelecom.multisimservice.b
        public void B0(String str) {
            k.h("ICtccRemoteService", str);
            MessageProxyClient.getInstance().sendMessage(WearPath.Lpa.START_DOWNLOAD_PATH, str.getBytes());
            Intent intent = new Intent("com.mobvoi.baiding.ACTION.APOLLO_ESIM_DOWNLOAD_PROFILE_REQ");
            intent.putExtra("apollo_esim_extra_activation_code", str);
            b1.a.b(ICTCCRemoteService.this).d(intent);
        }

        @Override // com.chinatelecom.multisimservice.b
        public void Z(com.chinatelecom.multisimservice.model.a aVar) {
            k.a("ICtccRemoteService", "registerCallback");
            ICTCCRemoteService.this.f8205a = aVar;
            ICTCCRemoteService.this.f8209e.d(ICTCCRemoteService.this);
        }

        @Override // com.chinatelecom.multisimservice.b
        public void i0(com.chinatelecom.multisimservice.model.a aVar) {
            k.a("ICtccRemoteService", "unregisterCallback");
            ICTCCRemoteService.this.f8209e.f(ICTCCRemoteService.this);
            ICTCCRemoteService.this.f8205a = null;
        }

        @Override // com.chinatelecom.multisimservice.b
        public void p() {
            k.a("ICtccRemoteService", "getAttachedDeviceMultiSimInfo");
            b1.a.b(ICTCCRemoteService.this).d(new Intent("com.mobvoi.baiding.ACTION.APOLLO_ESIM_GET_EID_REQ"));
            MessageProxyClient.getInstance().sendMessage(WearPath.Lpa.GET_IEMI_AND_EID_PATH);
            ICTCCRemoteService.this.f8208d.postDelayed(new Runnable() { // from class: com.chinatelecom.multisimservice.a
                @Override // java.lang.Runnable
                public final void run() {
                    ICTCCRemoteService.b.this.m1();
                }
            }, 5000L);
        }
    }

    /* loaded from: classes.dex */
    class c extends c.a {
        c() {
        }

        @Override // com.chinatelecom.multisimservice.c
        public IBinder M0(String str, String str2) throws RemoteException {
            if (ICTCCRemoteService.this.getPackageManager().getPackagesForUid(Binder.getCallingUid()) == null) {
                return null;
            }
            for (String str3 : ICTCCRemoteService.this.getPackageManager().getPackagesForUid(Binder.getCallingUid())) {
                if ("com.ct.client".equals(str3)) {
                    k.a("ICtccRemoteService", "Auth Pass!");
                    return ICTCCRemoteService.this.f8210f;
                }
            }
            return null;
        }

        @Override // com.chinatelecom.multisimservice.c
        public void g0(com.chinatelecom.multisimservice.model.b bVar) {
            k.a("ICtccRemoteService", "unregisterCallback");
            ICTCCRemoteService.this.f8206b = null;
        }

        @Override // com.chinatelecom.multisimservice.c
        public void r2() {
            if (ICTCCRemoteService.this.f8206b != null) {
                k.a("ICtccRemoteService", "serviceCallBack ! = null");
                SmartWearServiceInfo smartWearServiceInfo = new SmartWearServiceInfo();
                smartWearServiceInfo.a(ICTCCRemoteService.this.getPackageName());
                smartWearServiceInfo.b("1.0");
                try {
                    ICTCCRemoteService.this.f8206b.m(smartWearServiceInfo);
                } catch (RemoteException e10) {
                    k.e("ICtccRemoteService", "getSmartWearServiceInfo Exception, ", e10);
                }
            }
        }

        @Override // com.chinatelecom.multisimservice.c
        public void x(com.chinatelecom.multisimservice.model.b bVar) {
            k.a("ICtccRemoteService", "registerCallback");
            ICTCCRemoteService.this.f8206b = bVar;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        k.a("ICtccRemoteService", "onBind");
        MessageProxyClient.getInstance().addListener(this);
        this.f8208d = new Handler(getMainLooper());
        return this.f8211g;
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
    public void onConnectedNodesChanged(List<NodeInfo> list) {
        k.a("ICtccRemoteService", "onConnectedNodesChanged, " + list);
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
    public void onMessageReceived(MessageInfo messageInfo) {
        k.a("ICtccRemoteService", "onMessageReceived() A message from watch was received:" + messageInfo.getNodeId() + " " + messageInfo.getPath());
        if (WearPath.Lpa.IEMI_AND_EID_RESULT_PATH.equals(messageInfo.getPath())) {
            String[] split = new String(messageInfo.getPayload()).split("###");
            try {
                if (this.f8205a != null) {
                    k.a("ICtccRemoteService", "callback not null");
                    this.f8207c = true;
                    if (this.f8208d != null) {
                        k.a("ICtccRemoteService", "Remove handler message");
                        this.f8208d.removeCallbacksAndMessages(null);
                    }
                    if (split.length >= 2) {
                        MultiSimDeviceInfo multiSimDeviceInfo = new MultiSimDeviceInfo();
                        multiSimDeviceInfo.a(split[0]);
                        multiSimDeviceInfo.c(split[1]);
                        k.c("ICtccRemoteService", "imei = %s, eid = %s", split[0], split[1]);
                        multiSimDeviceInfo.d(1);
                        multiSimDeviceInfo.b(2);
                        this.f8205a.s2(multiSimDeviceInfo);
                        return;
                    }
                    k.a("ICtccRemoteService", "results null");
                } else {
                    k.a("ICtccRemoteService", "callback null");
                }
                MultiSimDeviceInfo multiSimDeviceInfo2 = new MultiSimDeviceInfo();
                multiSimDeviceInfo2.d(0);
                this.f8205a.s2(multiSimDeviceInfo2);
            } catch (RemoteException e10) {
                k.e("ICtccRemoteService", "RemoteException,", e10);
            }
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        k.a("ICtccRemoteService", "onUnBind");
        this.f8209e.f(this);
        MessageProxyClient.getInstance().removeListener(this);
        this.f8208d.removeCallbacksAndMessages(null);
        return super.onUnbind(intent);
    }
}
