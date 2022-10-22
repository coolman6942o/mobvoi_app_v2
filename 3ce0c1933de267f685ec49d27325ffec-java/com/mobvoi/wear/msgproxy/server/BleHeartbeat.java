package com.mobvoi.wear.msgproxy.server;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.o;
import com.mobvoi.wear.common.R;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import com.mobvoi.wear.msgproxy.MessageInfo;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import com.mobvoi.wear.msgproxy.MessageProxyListener;
import com.mobvoi.wear.msgproxy.NodeInfo;
import java.util.List;
import t9.a;
import t9.d;
/* loaded from: classes2.dex */
public class BleHeartbeat {
    private static final long PING_MIN_INTERVAL = 30000;
    private static final long PING_PERIOD = 600000;
    private static final long PING_TIMEOUT = 10000;
    private static final String TAG = "BleHeartbeat";
    private Callback mCallback;
    private SharedWearInfoHelper mInfoHelper;
    private long mLastPingSuccessTimestamp;
    private long mPingStartTimestamp;
    private String mSupportPingCapability;
    private boolean mBleConnected = false;
    private boolean mEnabled = false;
    private Runnable mPingTask = new Runnable() { // from class: com.mobvoi.wear.msgproxy.server.b
        @Override // java.lang.Runnable
        public final void run() {
            BleHeartbeat.this.lambda$new$0();
        }
    };
    private Runnable mTimeoutCheckTask = new Runnable() { // from class: com.mobvoi.wear.msgproxy.server.a
        @Override // java.lang.Runnable
        public final void run() {
            BleHeartbeat.this.lambda$new$1();
        }
    };
    private MessageProxyListener mMpsListener = new MessageProxyListener() { // from class: com.mobvoi.wear.msgproxy.server.BleHeartbeat.1
        @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
        public void onConnectedNodesChanged(List<NodeInfo> list) {
        }

        @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
        public void onMessageReceived(MessageInfo messageInfo) {
            if (WearPath.Ios.PING_REPLY.equals(messageInfo.getPath())) {
                k.a(BleHeartbeat.TAG, "ping ack");
                BleHeartbeat.this.mPingStartTimestamp = 0L;
                BleHeartbeat.this.mLastPingSuccessTimestamp = SystemClock.elapsedRealtime();
                BleHeartbeat.this.mTaskScheduler.h();
                BleHeartbeat.this.mTaskScheduler.l(BleHeartbeat.this.mPingTask, BleHeartbeat.PING_PERIOD);
            }
        }
    };
    private d mTaskScheduler = new d(new a(Looper.getMainLooper()), TAG);

    /* loaded from: classes2.dex */
    public interface Callback {
        void onRemoteDeviceLost();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BleHeartbeat(Context context, Callback callback) {
        o.e(callback);
        this.mCallback = callback;
        this.mSupportPingCapability = context.getString(R.string.capability_ble_heartbeat);
        this.mInfoHelper = SharedWearInfoHelper.getInstance(context);
        MessageProxyClient.getInstance().addListener(this.mMpsListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        pingRemoteDevice("Period");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1() {
        if (this.mPingStartTimestamp > 0) {
            k.a(TAG, "ping timeout");
            this.mPingStartTimestamp = 0L;
            this.mCallback.onRemoteDeviceLost();
        }
    }

    private void pingRemoteDevice(String str) {
        if (!this.mInfoHelper.getCompanionCapabilities().contains(this.mSupportPingCapability)) {
            k.a(TAG, "ping not supported");
        } else if (!this.mEnabled) {
            k.a(TAG, "not enabled yet, skip");
        } else if (this.mPingStartTimestamp > 0) {
            k.a(TAG, "in progress of ping, skip");
        } else if (SystemClock.elapsedRealtime() - this.mLastPingSuccessTimestamp < 30000) {
            k.a(TAG, "too frequently ping, skip");
        } else {
            k.c(TAG, "ping...[%s]", str);
            this.mPingStartTimestamp = SystemClock.elapsedRealtime();
            this.mTaskScheduler.l(this.mTimeoutCheckTask, PING_TIMEOUT);
            MessageProxyClient.getInstance().sendMessage(WearPath.Ios.PING);
        }
    }

    public void onBleConnectionChange(boolean z10) {
        this.mBleConnected = z10;
        if (this.mPingStartTimestamp > 0) {
            k.a(TAG, "onBleConnectionChange, cancel ping timeout");
        }
        this.mTaskScheduler.h();
        this.mPingStartTimestamp = 0L;
        if (z10) {
            this.mTaskScheduler.l(this.mPingTask, PING_PERIOD);
        } else {
            this.mEnabled = false;
        }
    }

    public void onDataReceived() {
        this.mEnabled = true;
        if (this.mPingStartTimestamp > 0) {
            k.a(TAG, "onDataReceived, cancel ping timeout");
        }
        this.mTaskScheduler.h();
        this.mPingStartTimestamp = 0L;
        this.mTaskScheduler.l(this.mPingTask, PING_PERIOD);
    }

    public void onScreenOn() {
        if (this.mBleConnected) {
            pingRemoteDevice("ScreenOn");
        }
    }
}
