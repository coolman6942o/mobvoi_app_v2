package com.mobvoi.android.common.ipc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.o;
import com.mobvoi.android.common.utils.t;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ServiceConnector.java */
/* loaded from: classes2.dex */
public abstract class c<IServiceInterface> {
    private static final long CONNECT_TIMEOUT_CHECK_INTERVAL = 5000;
    private static final boolean DEV_LOG = false;
    private static final long FORCE_REBIND_TIME = 30000;
    private static final int MSG_CONNECT_TIMEOUT_CHECK = 3;
    private static final int MSG_NOTIFY_LISTENERS = 2;
    private static final int MSG_RECONNECT = 1;
    public static final int STATE_CONNECTED = 3;
    public static final int STATE_CONNECTING = 2;
    public static final int STATE_DISCONNECTED = 1;
    private static final String TAG = "ServiceConnector";
    protected Context mAppContext;
    private long mConnectStartTime;
    protected IServiceInterface mService;
    private ServiceConnection mServiceConnection;
    protected String mServiceName;
    protected t<com.mobvoi.android.common.ipc.a> mStateListeners = new t<>();
    private final Object mConnectWaitLock = new Object();
    private AtomicInteger mState = new AtomicInteger(1);
    private Handler mConnectHandler = new b(getConnectLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ServiceConnector.java */
    /* loaded from: classes2.dex */
    public class a implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        private boolean f15278a = false;

        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            k.i(c.TAG, "[%s] service connected, cn: %s, mConnectLost: %s", c.this.mServiceName, componentName, Boolean.valueOf(this.f15278a));
            if (!this.f15278a) {
                c cVar = c.this;
                cVar.mService = (IServiceInterface) cVar.asInterface(iBinder);
                c.this.mConnectHandler.removeMessages(3);
                c.this.updateConnectState(3);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            k.i(c.TAG, "[%s] service disconnected, cn: %s, mConnectLost: %s", c.this.mServiceName, componentName, Boolean.valueOf(this.f15278a));
            if (!this.f15278a) {
                this.f15278a = true;
                c.this.disconnect();
                c.this.mConnectHandler.sendEmptyMessageDelayed(1, 1000L);
            }
        }
    }

    /* compiled from: ServiceConnector.java */
    /* loaded from: classes2.dex */
    class b extends Handler {

        /* compiled from: ServiceConnector.java */
        /* loaded from: classes2.dex */
        class a implements t.b<com.mobvoi.android.common.ipc.a> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f15281a;

            a(b bVar, int i10) {
                this.f15281a = i10;
            }

            /* renamed from: a */
            public void notify(com.mobvoi.android.common.ipc.a aVar) {
                aVar.onStateChanged(this.f15281a);
            }
        }

        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                k.c(c.TAG, "[%s] delayed reconnect fires...", c.this.mServiceName);
                c.this.connect();
            } else if (i10 == 2) {
                c.this.mStateListeners.notifyListeners(new a(this, message.arg1));
            } else if (i10 == 3) {
                k.a(c.TAG, "checking connect timeout");
                int i11 = c.this.mState.get();
                if (SystemClock.elapsedRealtime() - c.this.mConnectStartTime >= 30000) {
                    k.c(c.TAG, "[%s] connect timeout, state: %s", c.this.mServiceName, Integer.valueOf(i11));
                    if (i11 == 2) {
                        c.this.connectServiceIfNeeded(true);
                    }
                } else if (i11 == 2) {
                    c.this.mConnectHandler.sendEmptyMessageDelayed(3, c.CONNECT_TIMEOUT_CHECK_INTERVAL);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, String str) {
        this.mAppContext = context.getApplicationContext();
        this.mServiceName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectServiceIfNeeded(boolean z10) {
        boolean z11;
        if (this.mService != null) {
            k.c(TAG, "[%s] service is connected", this.mServiceName);
            return;
        }
        if (!z10) {
            if (!this.mState.compareAndSet(1, 2)) {
                k.c(TAG, "[%s] Service is under connecting", this.mServiceName);
                return;
            }
            updateConnectState(2);
        }
        this.mConnectStartTime = SystemClock.elapsedRealtime();
        Intent serviceIntent = getServiceIntent();
        List<ResolveInfo> queryIntentServices = this.mAppContext.getPackageManager().queryIntentServices(serviceIntent, 0);
        if (queryIntentServices == null || queryIntentServices.size() == 0) {
            k.s(TAG, "[%s] no service component available, cannot connect", this.mServiceName);
            updateConnectState(1);
            return;
        }
        ComponentName selectTargetService = selectTargetService(queryIntentServices);
        if (selectTargetService == null) {
            k.s(TAG, "[%s] no expected service component found, cannot connect", this.mServiceName);
            updateConnectState(1);
            return;
        }
        serviceIntent.setComponent(selectTargetService);
        this.mServiceConnection = new a();
        k.i(TAG, "[%s] connecting service...", this.mServiceName);
        try {
            z11 = this.mAppContext.bindService(serviceIntent, this.mServiceConnection, 1);
        } catch (Exception unused) {
            k.q(TAG, "bindService failed");
            z11 = false;
        }
        if (!z11) {
            k.s(TAG, "[%s] cannot connect", this.mServiceName);
            updateConnectState(1);
            return;
        }
        this.mConnectHandler.removeMessages(3);
        this.mConnectHandler.sendEmptyMessageDelayed(3, CONNECT_TIMEOUT_CHECK_INTERVAL);
    }

    public static String stateToStr(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? GrsBaseInfo.CountryCodeSource.UNKNOWN : "CONNECTED" : "CONNECTING" : "DISCONNECTED";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateConnectState(int i10) {
        if (i10 != 2) {
            this.mState.set(i10);
        }
        this.mConnectHandler.obtainMessage(2, i10, 0).sendToTarget();
    }

    public void addListener(com.mobvoi.android.common.ipc.a aVar) {
        this.mStateListeners.addListener(aVar);
    }

    protected abstract IServiceInterface asInterface(IBinder iBinder);

    public void connect() {
        connectServiceIfNeeded(false);
    }

    public void disconnect() {
        k.i(TAG, "[%s] disconnect service...", this.mServiceName);
        this.mConnectHandler.removeMessages(3);
        this.mConnectHandler.removeMessages(1);
        this.mConnectHandler.removeMessages(2);
        this.mService = null;
        ServiceConnection serviceConnection = this.mServiceConnection;
        if (serviceConnection != null) {
            this.mAppContext.unbindService(serviceConnection);
            this.mServiceConnection = null;
        }
        updateConnectState(1);
    }

    protected Looper getConnectLooper() {
        return Looper.getMainLooper();
    }

    public int getConnectState() {
        return this.mState.get();
    }

    public IServiceInterface getService() {
        return this.mService;
    }

    protected abstract Intent getServiceIntent();

    public boolean isServiceExist() {
        List<ResolveInfo> queryIntentServices = this.mAppContext.getPackageManager().queryIntentServices(getServiceIntent(), 0);
        return (queryIntentServices == null || queryIntentServices.size() <= 0 || selectTargetService(queryIntentServices) == null) ? false : true;
    }

    public void removeListener(com.mobvoi.android.common.ipc.a aVar) {
        this.mStateListeners.removeListener(aVar);
    }

    protected ComponentName selectTargetService(List<ResolveInfo> list) {
        o.a(list.size() >= 1);
        ServiceInfo serviceInfo = list.get(0).serviceInfo;
        Iterator<ResolveInfo> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ResolveInfo next = it.next();
            if (!validatePermission(next.serviceInfo.permission)) {
                ServiceInfo serviceInfo2 = next.serviceInfo;
                k.s(TAG, "Skip not-matched permission candidate: %s, perm: %s", serviceInfo2.name, serviceInfo2.permission);
            } else {
                ServiceInfo serviceInfo3 = next.serviceInfo;
                if ((serviceInfo3.applicationInfo.flags & 1) == 1) {
                    serviceInfo = serviceInfo3;
                    break;
                }
            }
        }
        if (validatePermission(serviceInfo.permission)) {
            return new ComponentName(serviceInfo.packageName, serviceInfo.name);
        }
        return null;
    }

    protected boolean validatePermission(String str) {
        return true;
    }

    public void waitForConnected() {
        waitForConnected(-1L);
    }

    public void waitForConnected(long j10) {
        o.d();
        char c10 = 0;
        if (this.mService != null) {
            k.c(TAG, "[%s] already connected", this.mServiceName);
            return;
        }
        synchronized (this.mConnectWaitLock) {
            connect();
            long j11 = 50;
            long j12 = 0;
            while (true) {
                Object[] objArr = new Object[5];
                objArr[c10] = this.mServiceName;
                objArr[1] = this.mService;
                objArr[2] = Integer.valueOf(this.mState.get());
                objArr[3] = Long.valueOf(j12);
                objArr[4] = Long.valueOf(j10);
                k.c(TAG, "[%s] checking, service: %s, state: %d, time: %d/%d", objArr);
                if (this.mService != null || this.mState.get() == 1 || (j10 >= 0 && j12 >= j10)) {
                    break;
                }
                connect();
                try {
                    Thread.sleep(j11);
                    j12 += j11;
                    j11 *= 2;
                    if (j11 > 1000) {
                        j11 = 1000;
                    }
                    c10 = 0;
                } catch (InterruptedException e10) {
                    k.r(TAG, "interrupted", e10, new Object[0]);
                }
            }
        }
    }
}
