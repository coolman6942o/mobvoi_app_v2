package com.laser.tsm.sdk.apdu;

import android.content.Context;
import com.laser.tsm.sdk.bean.Capdu;
import com.laser.tsm.sdk.bean.Rapdu;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class ApduRequest implements Runnable {
    protected static final int RESULT_FAILURE = 1;
    protected static final int RESULT_SUCCESS = 0;
    protected List<Capdu> mCapduList;
    protected Context mContext;
    protected Capdu mCurrentExecuteApduBean;
    protected ApduResponseHandler mHandler;
    protected List<Rapdu> mRapduList;
    protected int mCurrentExecuteIndex = 0;
    protected boolean mIsGetLocalData = false;
    protected boolean mMayInterruptIfRunning = false;

    public ApduRequest(Context context, ApduResponseHandler apduResponseHandler) {
        this.mContext = context;
        this.mHandler = apduResponseHandler;
    }

    public void cancelRequest() {
        this.mMayInterruptIfRunning = true;
    }

    protected void clearData() {
        this.mCurrentExecuteApduBean = null;
        this.mCurrentExecuteIndex = 0;
        this.mIsGetLocalData = false;
        this.mMayInterruptIfRunning = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void createRapduBean(int i10, String str, String str2) {
        this.mRapduList.add(new Rapdu(i10, str, str2));
    }

    protected abstract void executeApdu();

    /* JADX INFO: Access modifiers changed from: protected */
    public void isGetLocalData(boolean z10) {
        this.mIsGetLocalData = z10;
    }

    protected void postDelay(Runnable runnable, long j10) {
        ApduResponseHandler apduResponseHandler = this.mHandler;
        if (apduResponseHandler != null) {
            apduResponseHandler.postDelay(runnable, j10);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        executeApdu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendErrorMessage(int i10, Error error) {
        clearData();
        ApduResponseHandler apduResponseHandler = this.mHandler;
        if (apduResponseHandler != null) {
            apduResponseHandler.sendSendNextErrorMessage(i10, this.mRapduList, error);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendFailureMessage(int i10, Error error) {
        clearData();
        ApduResponseHandler apduResponseHandler = this.mHandler;
        if (apduResponseHandler != null) {
            apduResponseHandler.sendFailureMessage(i10, error);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendMessage(int i10) {
        clearData();
        ApduResponseHandler apduResponseHandler = this.mHandler;
        if (apduResponseHandler != null) {
            apduResponseHandler.sendSendNextMessage(i10, this.mRapduList);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendSuccessMessage(Rapdu rapdu) {
        clearData();
        ApduResponseHandler apduResponseHandler = this.mHandler;
        if (apduResponseHandler != null) {
            apduResponseHandler.sendSuccessMessage(rapdu);
        }
    }

    public void setCapdu(Capdu capdu) {
        List<Capdu> list = this.mCapduList;
        if (list == null) {
            this.mCapduList = new ArrayList();
        } else {
            list.clear();
        }
        this.mCapduList.add(capdu);
        List<Rapdu> list2 = this.mRapduList;
        if (list2 == null) {
            this.mRapduList = new ArrayList();
        } else {
            list2.clear();
        }
    }

    public void setCapduList(List<Capdu> list) {
        List<Capdu> list2 = this.mCapduList;
        if (list2 == null) {
            this.mCapduList = new ArrayList();
        } else {
            list2.clear();
        }
        this.mCapduList.addAll(list);
        List<Rapdu> list3 = this.mRapduList;
        if (list3 == null) {
            this.mRapduList = new ArrayList();
        } else {
            list3.clear();
        }
    }
}
