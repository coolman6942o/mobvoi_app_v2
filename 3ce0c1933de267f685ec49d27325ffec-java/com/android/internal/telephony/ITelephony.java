package com.android.internal.telephony;

import android.os.IInterface;
import android.os.RemoteException;
/* loaded from: classes.dex */
public interface ITelephony extends IInterface {
    void answerRingingCall();

    boolean endCall() throws RemoteException;
}
