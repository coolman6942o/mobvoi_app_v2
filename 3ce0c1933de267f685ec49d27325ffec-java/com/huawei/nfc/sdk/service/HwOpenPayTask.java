package com.huawei.nfc.sdk.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.huawei.nfc.sdk.service.ICUPOnlinePayCallBackService;
import com.huawei.nfc.sdk.service.ICUPOnlinePayService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class HwOpenPayTask {
    private static final String BANK_OPEN_API_PAY_ACTION = "com.huawei.nfc.action.OPEN_AIDL_API_PAY";
    private static final String TAG = "HwOpenPayTask";
    private static final String WALLET_PACKAGE_NAME = "com.huawei.wallet";
    private boolean haveInitService;
    private Context mContext;
    private ICUPOnlinePayService mOpenService;
    private IHwPayResultCallBack payResultCallBack;
    private IHwResultCallBack resultCallBack;
    private final byte[] lock = new byte[0];
    private ServiceConnection mNfcServiceConnection = new MyServiceConnection();
    private ICUPOnlinePayCallBackService hwPayCallBackService = new ICUPOnlinePayCallBackService.Stub() { // from class: com.huawei.nfc.sdk.service.HwOpenPayTask.1
        @Override // com.huawei.nfc.sdk.service.ICUPOnlinePayCallBackService
        public void onError(String str, String str2) {
            Log.i(HwOpenPayTask.TAG, "getUnionOnlinePayStatus---onError--- errorCode is " + str + " and errorMsg is " + str2);
            if (HwOpenPayTask.this.payResultCallBack != null) {
                HwOpenPayTask.this.payResultCallBack.onError(str, str2);
                HwOpenPayTask.this.payResultCallBack = null;
            }
            if (HwOpenPayTask.this.haveInitService) {
                HwOpenPayTask.this.disConnect();
            }
        }

        @Override // com.huawei.nfc.sdk.service.ICUPOnlinePayCallBackService
        public void onResult(Bundle bundle) {
            Log.i(HwOpenPayTask.TAG, "getUnionOnlinePayStatus---onResult---");
            if (HwOpenPayTask.this.payResultCallBack != null) {
                HwOpenPayTask.this.payResultCallBack.onResult(bundle);
                HwOpenPayTask.this.payResultCallBack = null;
            }
            if (HwOpenPayTask.this.haveInitService) {
                HwOpenPayTask.this.disConnect();
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface IHwPayResultCallBack {
        void onError(String str, String str2);

        void onResult(Bundle bundle);
    }

    /* loaded from: classes2.dex */
    public interface IHwResultCallBack {
        void onResult(int i10, Bundle bundle);
    }

    /* loaded from: classes2.dex */
    class MyServiceConnection implements ServiceConnection {
        private MyServiceConnection() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i(HwOpenPayTask.TAG, "---onServiceConnected---begin");
            synchronized (HwOpenPayTask.this.lock) {
                HwOpenPayTask.this.mOpenService = ICUPOnlinePayService.Stub.asInterface(iBinder);
                Log.i(HwOpenPayTask.TAG, "---onServiceConnected---");
                HwOpenPayTask.this.lock.notifyAll();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.i(HwOpenPayTask.TAG, "---onServiceDisconnected---begin");
            synchronized (HwOpenPayTask.this.lock) {
                Log.i(HwOpenPayTask.TAG, "---onServiceDisconnected---");
                HwOpenPayTask.this.mOpenService = null;
                HwOpenPayTask.this.lock.notifyAll();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface SupportCapacityResult {
        public static final int CAPACITY_RESULT_NOT_SUPPORT = 0;
        public static final int CAPACITY_RESULT_SUPPORT = 1;
    }

    public HwOpenPayTask(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disConnect() {
        this.haveInitService = false;
        this.mOpenService = null;
        if (this.mContext != null && this.mNfcServiceConnection != null) {
            Log.i(TAG, "---unbindService---start");
            this.mContext.unbindService(this.mNfcServiceConnection);
            Log.i(TAG, "---unbindService---end");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void failResult() {
        Log.i(TAG, "--failResult--:");
        IHwResultCallBack iHwResultCallBack = this.resultCallBack;
        if (iHwResultCallBack != null) {
            iHwResultCallBack.onResult(0, new Bundle());
        }
        IHwPayResultCallBack iHwPayResultCallBack = this.payResultCallBack;
        if (iHwPayResultCallBack != null) {
            iHwPayResultCallBack.onError("003", "WALLET VERSION LOWER");
        }
        disConnect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initNfcService() {
        String str;
        String str2;
        synchronized (this.lock) {
            if (this.mOpenService == null) {
                Intent intent = new Intent(BANK_OPEN_API_PAY_ACTION);
                intent.setPackage(WALLET_PACKAGE_NAME);
                Log.i(TAG, "---bindService---start");
                boolean bindService = this.mContext.bindService(intent, this.mNfcServiceConnection, 1);
                Log.i(TAG, "---bindService---end:" + bindService);
                if (bindService) {
                    this.haveInitService = true;
                    if (this.mOpenService == null) {
                        try {
                            Log.i(TAG, "--waiting--");
                            this.lock.wait();
                        } catch (InterruptedException unused) {
                            Log.e(TAG, "---InterruptedException--");
                        }
                    } else {
                        str = TAG;
                        str2 = "---initNfcService---isConnection mOpenService not null";
                    }
                }
                failResult();
            } else {
                str = TAG;
                str2 = "---initNfcService---mOpenService not null";
            }
            Log.i(str, str2);
        }
    }

    public void getUnionOnlinePayStatus(final IHwPayResultCallBack iHwPayResultCallBack) {
        Executors.newCachedThreadPool().execute(new Runnable() { // from class: com.huawei.nfc.sdk.service.HwOpenPayTask.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (HwOpenPayTask.this.lock) {
                    HwOpenPayTask.this.payResultCallBack = iHwPayResultCallBack;
                    HwOpenPayTask.this.initNfcService();
                    if (HwOpenPayTask.this.mOpenService != null) {
                        try {
                            Log.i(HwOpenPayTask.TAG, "getUnionOnlinePayStatus");
                            HwOpenPayTask.this.mOpenService.getUnionOnlinePayStatus(HwOpenPayTask.this.hwPayCallBackService);
                        } catch (RemoteException unused) {
                            Log.e(HwOpenPayTask.TAG, "getUnionOnlinePayStatus---RemoteException--");
                            HwOpenPayTask.this.failResult();
                        }
                    } else {
                        Log.i(HwOpenPayTask.TAG, "mOpenService is null");
                    }
                }
            }
        });
    }

    public void supportCapacity(final String str, final IHwResultCallBack iHwResultCallBack) {
        Executors.newCachedThreadPool().execute(new Runnable() { // from class: com.huawei.nfc.sdk.service.HwOpenPayTask.2
            @Override // java.lang.Runnable
            public void run() {
                HwOpenPayTask hwOpenPayTask;
                synchronized (HwOpenPayTask.this.lock) {
                    HwOpenPayTask.this.resultCallBack = iHwResultCallBack;
                    HwOpenPayTask.this.initNfcService();
                    if (HwOpenPayTask.this.mOpenService != null) {
                        try {
                            Log.i(HwOpenPayTask.TAG, "supportCapacity capacity is " + str);
                            boolean supportCapacity = HwOpenPayTask.this.mOpenService.supportCapacity(str);
                            Log.i(HwOpenPayTask.TAG, "supportCapacity result is " + supportCapacity);
                            IHwResultCallBack iHwResultCallBack2 = iHwResultCallBack;
                            if (iHwResultCallBack2 != null) {
                                iHwResultCallBack2.onResult(supportCapacity ? 1 : 0, new Bundle());
                            }
                            hwOpenPayTask = HwOpenPayTask.this;
                        } catch (RemoteException unused) {
                            Log.e(HwOpenPayTask.TAG, "supportCapacity---RemoteException--");
                            iHwResultCallBack.onResult(0, new Bundle());
                            hwOpenPayTask = HwOpenPayTask.this;
                        }
                        hwOpenPayTask.disConnect();
                    } else {
                        Log.i(HwOpenPayTask.TAG, "mOpenService is null");
                    }
                }
            }
        });
    }
}
