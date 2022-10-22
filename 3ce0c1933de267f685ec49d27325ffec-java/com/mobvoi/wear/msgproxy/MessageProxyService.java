package com.mobvoi.wear.msgproxy;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.msgproxy.IMessageProxyService;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class MessageProxyService extends Service {
    private static final String TAG = "MessageProxyService";
    private IMessageProxyService.Stub mBinder = new IMessageProxyService.Stub() { // from class: com.mobvoi.wear.msgproxy.MessageProxyService.1
        @Override // com.mobvoi.wear.msgproxy.IMessageProxyService
        public List<NodeInfo> getConnectedNodes() throws RemoteException {
            try {
                return MessageProxyService.this.getConnectedNodes();
            } catch (Throwable th2) {
                k.e(MessageProxyService.TAG, "getConnectedNodes() failed", th2);
                MessageProxyService.this.forceCrashForDebug(th2);
                throw th2;
            }
        }

        @Override // com.mobvoi.wear.msgproxy.IMessageProxyService
        public boolean hasConnectedNodes() throws RemoteException {
            try {
                return MessageProxyService.this.hasConnectedNodes();
            } catch (Throwable th2) {
                k.e(MessageProxyService.TAG, "hasConnectedNodes() failed", th2);
                MessageProxyService.this.forceCrashForDebug(th2);
                throw th2;
            }
        }

        @Override // com.mobvoi.wear.msgproxy.IMessageProxyService
        public void sendMessage(String str, String str2, byte[] bArr) throws RemoteException {
            try {
                MessageProxyService.this.sendMessage(str, str2, bArr);
            } catch (Throwable th2) {
                k.e(MessageProxyService.TAG, "sendMessage() failed", th2);
                MessageProxyService.this.forceCrashForDebug(th2);
                throw th2;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void forceCrashForDebug(final Throwable th2) {
        if (k.j()) {
            new Thread() { // from class: com.mobvoi.wear.msgproxy.MessageProxyService.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    throw new RuntimeException("force crash", th2);
                }
            }.start();
        }
    }

    public abstract List<NodeInfo> getConnectedNodes();

    public abstract boolean hasConnectedNodes();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        k.c(TAG, "onBind: %s", intent);
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        k.a(TAG, "onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        k.a(TAG, "onDestroy");
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        k.c(TAG, "onUnbind: %s", intent);
        return super.onUnbind(intent);
    }

    public abstract void sendMessage(String str, String str2, byte[] bArr);
}
