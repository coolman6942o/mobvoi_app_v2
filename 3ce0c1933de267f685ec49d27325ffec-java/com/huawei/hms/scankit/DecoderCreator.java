package com.huawei.hms.scankit;

import android.os.RemoteException;
import com.huawei.hms.hmsscankit.api.IRemoteDecoderCreator;
import com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate;
/* loaded from: classes2.dex */
public class DecoderCreator extends IRemoteDecoderCreator.Stub {
    @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderCreator
    public IRemoteFrameDecoderDelegate newRemoteFrameDecoderDelegate() throws RemoteException {
        return s.a();
    }
}
