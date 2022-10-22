package com.cmcc.server;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import com.cmcc.server.ICMCCRemoteService;
import com.cmcc.server.b;
import com.cmcc.server.c;
import com.cmcc.server.model.MultiSimDeviceInfo;
import com.mobvoi.android.common.utils.f;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.msgproxy.MessageInfo;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import com.mobvoi.wear.msgproxy.MessageProxyListener;
import com.mobvoi.wear.msgproxy.NodeInfo;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ICMCCRemoteService extends Service implements MessageProxyListener {

    /* renamed from: a  reason: collision with root package name */
    private com.cmcc.server.model.a f8232a;

    /* renamed from: c  reason: collision with root package name */
    private Handler f8234c;

    /* renamed from: b  reason: collision with root package name */
    private boolean f8233b = false;

    /* renamed from: d  reason: collision with root package name */
    private final com.mobvoi.companion.receiver.a f8235d = new a();

    /* renamed from: e  reason: collision with root package name */
    private final IBinder f8236e = new b();

    /* renamed from: f  reason: collision with root package name */
    private final IBinder f8237f = new c();

    /* loaded from: classes.dex */
    class a extends com.mobvoi.companion.receiver.a {
        a() {
        }

        @Override // com.mobvoi.companion.receiver.a
        protected void b(String str, Intent intent) {
            if ("com.mobvoi.baiding.ACTION.APOLLO_ESIM_GET_EID_RESP".equals(str)) {
                String stringExtra = intent.getStringExtra("apollo_esim_extra_imei");
                String stringExtra2 = intent.getStringExtra("apollo_esim_extra_eid");
                k.c("ICmccRemoteService", "apollo watch: imei = %s, eid = %s", stringExtra, stringExtra2);
                MultiSimDeviceInfo multiSimDeviceInfo = new MultiSimDeviceInfo();
                multiSimDeviceInfo.a(stringExtra);
                multiSimDeviceInfo.c(stringExtra2);
                multiSimDeviceInfo.d(1);
                multiSimDeviceInfo.b(2);
                if (ICMCCRemoteService.this.f8232a != null) {
                    try {
                        ICMCCRemoteService.this.f8232a.j1(multiSimDeviceInfo);
                    } catch (RemoteException e10) {
                        k.f("ICmccRemoteService", "Error happens when invoke getDeviceEUICCInfo(): %s", e10.getMessage());
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
            ICMCCRemoteService.this.f8235d.f(ICMCCRemoteService.this);
            if (ICMCCRemoteService.this.f8232a != null && !ICMCCRemoteService.this.f8233b) {
                k.a("ICmccRemoteService", "callback not null");
                MultiSimDeviceInfo multiSimDeviceInfo = new MultiSimDeviceInfo();
                multiSimDeviceInfo.d(-2);
                multiSimDeviceInfo.b(2);
                try {
                    ICMCCRemoteService.this.f8232a.j1(multiSimDeviceInfo);
                } catch (RemoteException unused) {
                    k.a("ICmccRemoteService", "callback null");
                }
            }
        }

        @Override // com.cmcc.server.b
        public void K0(String str) throws RemoteException {
            k.i("ICmccRemoteService", "The raw activationCode from ICMCCRemoteService is %s.", str);
            MessageProxyClient.getInstance().sendMessage(WearPath.Lpa.START_DOWNLOAD_PATH, str.getBytes());
            Intent intent = new Intent("com.mobvoi.baiding.ACTION.APOLLO_ESIM_DOWNLOAD_PROFILE_REQ");
            intent.putExtra("apollo_esim_extra_activation_code", str);
            b1.a.b(ICMCCRemoteService.this).d(intent);
        }

        @Override // com.cmcc.server.b
        public void O(com.cmcc.server.model.a aVar) throws RemoteException {
            k.a("ICmccRemoteService", "unregisterCallback");
            ICMCCRemoteService.this.f8235d.f(ICMCCRemoteService.this);
            ICMCCRemoteService.this.f8232a = null;
        }

        @Override // com.cmcc.server.b
        public void p() throws RemoteException {
            k.a("ICmccRemoteService", "getAttachedDeviceMultiSimInfo");
            b1.a.b(ICMCCRemoteService.this).d(new Intent("com.mobvoi.baiding.ACTION.APOLLO_ESIM_GET_EID_REQ"));
            MessageProxyClient.getInstance().sendMessage(WearPath.Lpa.GET_IEMI_AND_EID_PATH);
            ICMCCRemoteService.this.f8234c.postDelayed(new Runnable() { // from class: com.cmcc.server.a
                @Override // java.lang.Runnable
                public final void run() {
                    ICMCCRemoteService.b.this.m1();
                }
            }, 5000L);
        }

        @Override // com.cmcc.server.b
        public void t(com.cmcc.server.model.a aVar) throws RemoteException {
            k.a("ICmccRemoteService", "registerCallback");
            ICMCCRemoteService.this.f8232a = aVar;
            ICMCCRemoteService.this.f8235d.d(ICMCCRemoteService.this);
        }
    }

    /* loaded from: classes.dex */
    class c extends c.a {
        c() {
        }

        @Override // com.cmcc.server.c
        public IBinder d(String str) throws RemoteException {
            String[] packagesForUid;
            if (ICMCCRemoteService.this.getPackageManager().getPackagesForUid(Binder.getCallingUid()) == null) {
                return null;
            }
            for (String str2 : ICMCCRemoteService.this.getPackageManager().getPackagesForUid(Binder.getCallingUid())) {
                if (!ICMCCRemoteService.this.l(str2)) {
                    ICMCCRemoteService iCMCCRemoteService = ICMCCRemoteService.this;
                    if (!iCMCCRemoteService.k(iCMCCRemoteService, str2)) {
                    }
                }
                return ICMCCRemoteService.this.f8236e;
            }
            return null;
        }
    }

    private String i(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return f.m(bArr);
        } catch (NoSuchAlgorithmException e10) {
            k.d("ICmccRemoteService", e10.getMessage());
            return null;
        }
    }

    private List<String> j(Context context, String str) {
        SigningInfo signingInfo;
        Signature[] signatureArr;
        ArrayList arrayList = new ArrayList();
        Signature[] signatureArr2 = null;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 134217728);
                if (!(packageInfo == null || (signingInfo = packageInfo.signingInfo) == null)) {
                    if (signingInfo.hasMultipleSigners()) {
                        signatureArr = packageInfo.signingInfo.getApkContentsSigners();
                    } else {
                        signatureArr = packageInfo.signingInfo.getSigningCertificateHistory();
                    }
                    signatureArr2 = signatureArr;
                }
            } else {
                PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(str, 64);
                if (packageInfo2 != null) {
                    signatureArr2 = packageInfo2.signatures;
                }
            }
        } catch (PackageManager.NameNotFoundException e10) {
            k.d("ICmccRemoteService", e10.getMessage());
        }
        if (signatureArr2 != null) {
            for (Signature signature : signatureArr2) {
                arrayList.add(i(signature.toByteArray()));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k(Context context, String str) {
        if (!"com.cmic.heduohao".equals(str)) {
            return false;
        }
        return j(context, str).contains("22c9ba96ca6a001ecde33596a969f837fcfbcf22");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(String str) {
        return "com.cmcc.numberportable".equals(str) || "com.greenpoint.android.mc10086.activity".equals(str);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        k.a("ICmccRemoteService", "onBind");
        MessageProxyClient.getInstance().addListener(this);
        this.f8234c = new Handler(getMainLooper());
        return this.f8237f;
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
    public void onConnectedNodesChanged(List<NodeInfo> list) {
        k.a("ICmccRemoteService", "onConnectedNodesChanged, " + list);
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
    public void onMessageReceived(MessageInfo messageInfo) {
        k.a("ICmccRemoteService", "onMessageReceived() A message from watch was received:" + messageInfo.getNodeId() + " " + messageInfo.getPath());
        if (WearPath.Lpa.IEMI_AND_EID_RESULT_PATH.equals(messageInfo.getPath())) {
            String[] split = new String(messageInfo.getPayload()).split("###");
            try {
                if (this.f8232a != null) {
                    k.a("ICmccRemoteService", "callback not null");
                    this.f8233b = true;
                    if (this.f8234c != null) {
                        k.a("ICmccRemoteService", "Remove handler message");
                        this.f8234c.removeCallbacksAndMessages(null);
                    }
                    if (split.length >= 2) {
                        MultiSimDeviceInfo multiSimDeviceInfo = new MultiSimDeviceInfo();
                        multiSimDeviceInfo.a(split[0]);
                        multiSimDeviceInfo.c(split[1]);
                        k.c("ICmccRemoteService", "imei = %s, eid = %s", split[0], split[1]);
                        multiSimDeviceInfo.d(1);
                        multiSimDeviceInfo.b(2);
                        this.f8232a.j1(multiSimDeviceInfo);
                        return;
                    }
                    k.a("ICmccRemoteService", "results null");
                } else {
                    k.a("ICmccRemoteService", "callback null");
                }
                MultiSimDeviceInfo multiSimDeviceInfo2 = new MultiSimDeviceInfo();
                multiSimDeviceInfo2.d(0);
                this.f8232a.j1(multiSimDeviceInfo2);
            } catch (RemoteException e10) {
                k.e("ICmccRemoteService", "RemoteException,", e10);
            }
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        k.a("ICmccRemoteService", "onUnbind");
        this.f8235d.f(this);
        MessageProxyClient.getInstance().removeListener(this);
        this.f8234c.removeCallbacksAndMessages(null);
        return super.onUnbind(intent);
    }
}
