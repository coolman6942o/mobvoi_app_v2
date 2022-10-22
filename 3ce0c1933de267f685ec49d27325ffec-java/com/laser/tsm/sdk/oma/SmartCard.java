package com.laser.tsm.sdk.oma;

import android.content.Context;
import com.laser.tsm.sdk.util.LogUtil;
import org.simalliance.openmobileapi.SEService;
/* loaded from: classes2.dex */
public class SmartCard implements SEService.CallBack {
    private static final String TAG = "SmartCard";
    private static SmartCard sInstance;
    private SmartCardCallback mCallback;
    private SEService mSEService;
    private SmartCardRequest mSmartCardRequest;
    private boolean mServiceIsConnection = false;
    private Object mLock = new Object();

    private SmartCard() {
    }

    private void executeSmartCardRequest(String str) {
        SEService sEService = this.mSEService;
        if (sEService == null) {
            operFailure("SEService is null");
            return;
        }
        if (this.mSmartCardRequest == null) {
            this.mSmartCardRequest = new SmartCardRequest(sEService);
        }
        this.mSmartCardRequest.setRequestCommand(str);
        this.mSmartCardRequest.setSmartCardCallback(this.mCallback);
        this.mSmartCardRequest.run();
    }

    public static synchronized SmartCard getInstance() {
        SmartCard smartCard;
        synchronized (SmartCard.class) {
            if (sInstance == null) {
                sInstance = new SmartCard();
            }
            smartCard = sInstance;
        }
        return smartCard;
    }

    private void operFailure(String str) {
        if (this.mCallback != null) {
            closeChannel();
            this.mCallback.onOperFailure(new Error(str));
        }
    }

    public void closeChannel() {
        SmartCardRequest smartCardRequest = this.mSmartCardRequest;
        if (smartCardRequest != null) {
            smartCardRequest.closeChannelAndSession();
            this.mSmartCardRequest = null;
        }
    }

    public void closeService() {
        SmartCardRequest smartCardRequest = this.mSmartCardRequest;
        if (smartCardRequest != null) {
            smartCardRequest.closeChannelAndSession();
            this.mSmartCardRequest = null;
        }
        try {
            SEService sEService = this.mSEService;
            if (sEService != null && sEService.isConnected()) {
                this.mSEService.shutdown();
                this.mSEService = null;
                this.mServiceIsConnection = false;
                LogUtil.i(TAG, "SEService正常关闭");
            }
        } catch (Exception e10) {
            LogUtil.e(TAG, "SEService关闭异常" + e10.getMessage());
        }
        this.mCallback = null;
        this.mSmartCardRequest = null;
    }

    public void execute(Context context, String str) {
        if (str == null) {
            operFailure("command is null");
            return;
        }
        if (this.mSEService == null) {
            new SEService(context, this);
            LogUtil.d(TAG, "start bind SEService");
            if (!this.mServiceIsConnection) {
                synchronized (this.mLock) {
                    try {
                        if (!this.mServiceIsConnection) {
                            LogUtil.d(TAG, "thread is waiting");
                            this.mLock.wait();
                        }
                    } catch (InterruptedException e10) {
                        operFailure("thread error:" + e10.getMessage());
                    }
                }
            }
        }
        executeSmartCardRequest(str);
    }

    public void serviceConnected(SEService sEService) {
        LogUtil.d(TAG, "service is connect");
        synchronized (this.mLock) {
            if (sEService.isConnected()) {
                LogUtil.d(TAG, "bind SEService success");
                this.mSEService = sEService;
            } else {
                operFailure("SEService connect failure");
            }
            LogUtil.d(TAG, "thread notifyAll");
            this.mServiceIsConnection = true;
            this.mLock.notifyAll();
        }
    }

    public void setReaderType(EnumReaderType enumReaderType) {
        SmartCardRequest smartCardRequest = this.mSmartCardRequest;
        if (smartCardRequest != null) {
            smartCardRequest.setReaderType(enumReaderType);
        }
    }

    public SmartCard setSmartCardCallBack(SmartCardCallback smartCardCallback) {
        this.mCallback = smartCardCallback;
        return this;
    }
}
