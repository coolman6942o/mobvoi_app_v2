package com.laser.tsm.sdk.apdu;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.laser.tsm.sdk.bean.Rapdu;
import java.util.List;
/* loaded from: classes2.dex */
abstract class ApduResponseHandler {
    private static final int MESSAGE_FAILURE = 2;
    private static final int MESSAGE_SENDNEXT = 1;
    private static final int MESSAGE_SENDNEXT_ERROR = 3;
    private static final int MESSAGE_SUCCESS = 0;
    private ResponseHandler mHandler;
    private boolean useSynchronousMode;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ResponseHandler extends Handler {
        private final ApduResponseHandler mResponder;

        public ResponseHandler(ApduResponseHandler apduResponseHandler) {
            this.mResponder = apduResponseHandler;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.mResponder.handleMessage(message);
        }
    }

    public ApduResponseHandler() {
        setUseSynchronousMode(true);
    }

    private Message obtainMessage(int i10, Object obj) {
        ResponseHandler responseHandler = this.mHandler;
        if (responseHandler != null) {
            return Message.obtain(responseHandler, i10, obj);
        }
        Message obtain = Message.obtain();
        if (obtain == null) {
            return obtain;
        }
        obtain.what = i10;
        obtain.obj = obj;
        return obtain;
    }

    private void sendMessage(Message message) {
        if (getUseSynchronousMode() || this.mHandler == null) {
            handleMessage(message);
        } else if (!Thread.currentThread().isInterrupted()) {
            this.mHandler.sendMessage(message);
        }
    }

    public abstract void OnSendNextError(int i10, List<Rapdu> list, Error error);

    public boolean getUseSynchronousMode() {
        return this.useSynchronousMode;
    }

    public void handleMessage(Message message) {
        Object[] objArr;
        int i10 = message.what;
        if (i10 == 0) {
            Object[] objArr2 = (Object[]) message.obj;
            if (objArr2 != null && objArr2.length >= 1) {
                onSuccess(objArr2[0] == null ? null : (Rapdu) objArr2[0]);
            }
        } else if (i10 == 1) {
            Object[] objArr3 = (Object[]) message.obj;
            if (objArr3 != null && objArr3.length >= 2) {
                onSendNext(Integer.parseInt(objArr3[0].toString()), (List) objArr3[1]);
            }
        } else if (i10 == 2) {
            Object[] objArr4 = (Object[]) message.obj;
            if (objArr4 != null && objArr4.length >= 2) {
                onFailure(Integer.parseInt(objArr4[0].toString()), (Error) objArr4[1]);
            }
        } else if (i10 == 3 && (objArr = (Object[]) message.obj) != null && objArr.length >= 3) {
            OnSendNextError(Integer.parseInt(objArr[0].toString()), (List) objArr[1], (Error) objArr[2]);
        }
    }

    public abstract void onFailure(int i10, Error error);

    public abstract void onSendNext(int i10, List<Rapdu> list);

    public abstract void onSuccess(Rapdu rapdu);

    public void postDelay(Runnable runnable, long j10) {
        this.mHandler.postDelayed(runnable, j10);
    }

    public void sendFailureMessage(int i10, Error error) {
        sendMessage(obtainMessage(2, new Object[]{Integer.valueOf(i10), error}));
    }

    public void sendSendNextErrorMessage(int i10, List<Rapdu> list, Error error) {
        sendMessage(obtainMessage(3, new Object[]{Integer.valueOf(i10), list, error}));
    }

    public void sendSendNextMessage(int i10, List<Rapdu> list) {
        sendMessage(obtainMessage(1, new Object[]{Integer.valueOf(i10), list}));
    }

    public void sendSuccessMessage(Rapdu rapdu) {
        sendMessage(obtainMessage(0, new Object[]{rapdu}));
    }

    public void setUseSynchronousMode(boolean z10) {
        if (!z10 && Looper.myLooper() == null) {
            z10 = true;
        }
        if (!z10 && this.mHandler == null) {
            this.mHandler = new ResponseHandler(this);
        } else if (z10 && this.mHandler != null) {
            this.mHandler = null;
        }
        this.useSynchronousMode = z10;
    }
}
