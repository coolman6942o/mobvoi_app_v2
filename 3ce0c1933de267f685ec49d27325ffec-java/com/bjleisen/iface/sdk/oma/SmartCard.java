package com.bjleisen.iface.sdk.oma;

import android.content.Context;
import h9.b;
import org.simalliance.openmobileapi.SEService;
/* loaded from: classes.dex */
public class SmartCard implements SEService.CallBack {
    private static final String TAG = "SmartCard";
    protected static EnumReaderType mReaderType = EnumReaderType.READER_TYPE_ESE;
    private static SmartCard sInstance;
    private SEService mSEService;
    private SmartCardRequest mSmartCardRequest;
    private boolean mServiceIsConnection = false;
    private Object mLock = new Object();

    private SmartCard() {
    }

    private CardResult executeSmartCardRequest(String str) {
        SEService sEService = this.mSEService;
        if (sEService == null) {
            return operFail("SEService is not connect");
        }
        if (this.mSmartCardRequest == null) {
            this.mSmartCardRequest = new SmartCardRequest(sEService);
        }
        try {
            return this.mSmartCardRequest.executeApduCmd(str);
        } catch (Exception e10) {
            e10.printStackTrace();
            return operFail("error:" + e10.getMessage());
        }
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

    private CardResult operFail(String str) {
        closeChannel();
        return new CardResult(-1, str);
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
                b.j(TAG, "SEService正常关闭");
            }
        } catch (Exception e10) {
            b.g(TAG, "SEService关闭异常" + e10.getMessage());
        }
        this.mSmartCardRequest = null;
    }

    public CardResult execute(Context context, String str) {
        if (str == null) {
            return operFail("command is null");
        }
        if (this.mSEService == null) {
            new SEService(context, this);
            b.e(TAG, "start bind SEService");
            if (!this.mServiceIsConnection) {
                synchronized (this.mLock) {
                    try {
                        try {
                            if (!this.mServiceIsConnection) {
                                b.e(TAG, "thread is waiting");
                                this.mLock.wait();
                            }
                        } catch (InterruptedException e10) {
                            return operFail("thread error:" + e10.getMessage());
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }
        return executeSmartCardRequest(str);
    }

    public void serviceConnected(SEService sEService) {
        b.e(TAG, "service is connect");
        synchronized (this.mLock) {
            if (sEService.isConnected()) {
                b.e(TAG, "bind SEService success");
                this.mSEService = sEService;
            }
            b.e(TAG, "thread notifyAll");
            this.mServiceIsConnection = true;
            this.mLock.notifyAll();
        }
    }

    public void setReaderType(EnumReaderType enumReaderType) {
        mReaderType = enumReaderType;
    }
}
