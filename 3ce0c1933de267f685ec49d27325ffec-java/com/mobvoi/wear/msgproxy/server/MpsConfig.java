package com.mobvoi.wear.msgproxy.server;

import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.msgproxy.MessageProxyConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class MpsConfig {
    private static final String TAG = "MpsConfig";
    private static MpsConfig sInstance = new MpsConfig();
    private int mDeviceType = 0;
    private boolean mSupportGms = false;
    private boolean mSupportMms = false;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    @interface DeviceType {
        public static final int PHONE = 1;
        public static final int UNKNOWN = 0;
        public static final int WATCH = 2;
    }

    MpsConfig() {
    }

    public static MpsConfig getInstance() {
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getDeviceType() {
        return this.mDeviceType;
    }

    public String getPeerNodeCapability() {
        int i10 = this.mDeviceType;
        if (i10 == 1) {
            return MessageProxyConstants.CAPABILITY_TICWATCH_WEAR_CONNECT;
        }
        if (i10 == 2) {
            return MessageProxyConstants.CAPABILITY_TICWATCH_PHONE_CONNECT;
        }
        k.s(TAG, "unknown device type: %d", Integer.valueOf(i10));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init(int i10, boolean z10, boolean z11) {
        k.i(TAG, "init, type: %d, supportGms: %s, supportMms: %s", Integer.valueOf(i10), Boolean.valueOf(z10), Boolean.valueOf(z11));
        this.mDeviceType = i10;
        this.mSupportGms = z10;
        this.mSupportMms = z11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean supportGms() {
        return this.mSupportGms;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean supportMms() {
        return this.mSupportMms;
    }
}
