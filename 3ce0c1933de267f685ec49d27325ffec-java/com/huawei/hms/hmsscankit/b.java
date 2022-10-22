package com.huawei.hms.hmsscankit;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.api.IRemoteCreator;
import com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.hms.mlsdk.common.MLFrame;
import com.huawei.hms.scankit.p._a;
import com.huawei.hms.scankit.util.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HmsRemoteDecoder.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile IRemoteHmsDecoderDelegate f13993a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static HmsScan[] a(Context context, MLFrame mLFrame, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        DetailRect detailRect;
        HmsScan[] hmsScanArr;
        int i10;
        HmsScan[] hmsScanArr2 = new HmsScan[0];
        if (f13993a == null) {
            IRemoteCreator b10 = j.b(context);
            if (b10 == null) {
                return hmsScanArr2;
            }
            try {
                f13993a = b10.newRemoteHmsDecoderDelegate();
            } catch (RemoteException unused) {
                a.b("exception", "RemoteException");
            }
        }
        if (f13993a != null) {
            try {
                if (mLFrame.acquireProperty() != null) {
                    detailRect = new DetailRect(mLFrame.acquireProperty().getWidth(), mLFrame.acquireProperty().getHeight());
                } else {
                    detailRect = new DetailRect();
                }
                Bundle bundle = new Bundle();
                if (!(hmsScanAnalyzerOptions == null || (i10 = hmsScanAnalyzerOptions.mode) == 0)) {
                    bundle.putInt(DetailRect.FORMAT_FLAG, i10);
                }
                bundle.putInt(DetailRect.TYPE_TRANS, 3);
                bundle.putAll(_a.a(context));
                if (mLFrame.readBitmap() != null) {
                    hmsScanArr = f13993a.decodeInBitmap(detailRect, ObjectWrapper.wrap(mLFrame.readBitmap()), ObjectWrapper.wrap(bundle));
                } else {
                    hmsScanArr = f13993a.detectWithByteBuffer(detailRect, ObjectWrapper.wrap(mLFrame.acquireGrayByteBuffer()), ObjectWrapper.wrap(bundle));
                }
                if (hmsScanArr != null) {
                    return hmsScanArr;
                }
            } catch (RemoteException unused2) {
                a.b("exception", "RemoteException");
            }
        }
        return hmsScanArr2;
    }
}
