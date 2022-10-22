package com.huawei.hms.scankit;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.DetailRect;
import com.huawei.hms.hmsscankit.api.IRemoteCreator;
import com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate;
import com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate;
import com.huawei.hms.hmsscankit.api.IRemoteViewDelegate;
import com.huawei.hms.hmsscankit.j;
import com.huawei.hms.scankit.util.a;
import com.huawei.hms.scankit.util.b;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes2.dex */
public class Creator extends IRemoteCreator.Stub {
    private static final String TAG = "Creator";
    private q iRemoteViewDelegate = null;
    private BinderC0649r iRemoteDecoderDelegate = null;
    private t iRemoteHmsDecoderDelegate = null;

    @Override // com.huawei.hms.hmsscankit.api.IRemoteCreator
    public IRemoteDecoderDelegate newRemoteDecoderDelegate() throws RemoteException {
        a.c(TAG, "newRemoteDecoderDelegate()");
        BinderC0649r a10 = BinderC0649r.a();
        this.iRemoteDecoderDelegate = a10;
        return a10;
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteCreator
    public IRemoteHmsDecoderDelegate newRemoteHmsDecoderDelegate() throws RemoteException {
        a.c(TAG, "newRemoteHmsDecoderDelegate()");
        t a10 = t.a();
        this.iRemoteHmsDecoderDelegate = a10;
        return a10;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a6  */
    @Override // com.huawei.hms.hmsscankit.api.IRemoteCreator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public IRemoteViewDelegate newRemoteViewDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        boolean z10;
        Parcelable parcelable;
        int i10;
        boolean z11;
        boolean z12;
        if (iObjectWrapper == null) {
            a.b("ScankitRemoteS", "Context is null");
            return null;
        }
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        boolean z13 = true;
        boolean z14 = false;
        if (iObjectWrapper2 != null) {
            Object unwrap2 = ObjectWrapper.unwrap(iObjectWrapper2);
            if (unwrap2 instanceof Bundle) {
                Bundle bundle = (Bundle) unwrap2;
                z14 = bundle.getBoolean(DetailRect.CUSTOMED_FLAG, false);
                int i11 = bundle.getInt(DetailRect.FORMAT_FLAG, 0);
                Parcelable parcelable2 = bundle.getParcelable(DetailRect.RECT_FLAG);
                int i12 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.TYPE_TRANS, 0);
                DetailRect.HMSSCAN_SDK_VALUE = i12;
                if (i12 < 2) {
                    z13 = false;
                }
                if (z13) {
                    i11 = b.b(i11);
                }
                boolean z15 = bundle.getBoolean(DetailRect.RETURN_BITMAP, false);
                boolean z16 = bundle.getBoolean(DetailRect.SCAN_NEW_UI, false);
                if (z16 && (unwrap instanceof Context)) {
                    try {
                        j.a((Context) unwrap);
                    } catch (ClassNotFoundException unused) {
                        a.a(TAG, "ClassNotFoundException");
                    } catch (IllegalAccessException unused2) {
                        a.a(TAG, "IllegalAccessException");
                    } catch (NoSuchMethodException unused3) {
                        a.a(TAG, "NoSuchMethodException");
                    } catch (InvocationTargetException unused4) {
                        a.a(TAG, "InvocationTargetException");
                    }
                }
                z12 = z16;
                z10 = z15;
                z11 = z13;
                parcelable = parcelable2;
                i10 = i11;
                if (!z14) {
                    if (unwrap instanceof Context) {
                        this.iRemoteViewDelegate = new q((Context) unwrap, i10, parcelable, iObjectWrapper2, z11, z10, !z12);
                    }
                } else if (unwrap instanceof Context) {
                    if (z12) {
                        this.iRemoteViewDelegate = new v((Context) unwrap, i10, iObjectWrapper2, z11, false);
                    } else {
                        this.iRemoteViewDelegate = new y((Context) unwrap, i10, iObjectWrapper2, z11, true);
                    }
                }
                return this.iRemoteViewDelegate;
            }
        } else {
            iObjectWrapper2 = ObjectWrapper.wrap(new Bundle());
        }
        parcelable = null;
        z12 = false;
        z11 = false;
        i10 = 0;
        z10 = false;
        if (!z14) {
        }
        return this.iRemoteViewDelegate;
    }
}
