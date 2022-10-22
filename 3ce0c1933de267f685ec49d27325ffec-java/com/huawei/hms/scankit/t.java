package com.huawei.hms.scankit;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.DetailRect;
import com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.p.Ta;
import com.huawei.hms.scankit.util.a;
import com.huawei.hms.scankit.util.b;
import java.nio.ByteBuffer;
/* compiled from: IRemoteHmsDecoderDelegateImpl.java */
/* loaded from: classes2.dex */
public class t extends IRemoteHmsDecoderDelegate.Stub {

    /* renamed from: a  reason: collision with root package name */
    private static volatile t f15078a = new t();

    /* renamed from: b  reason: collision with root package name */
    private volatile Ta f15079b = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static t a() {
        return f15078a;
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate
    public HmsScan[] decodeInBitmap(DetailRect detailRect, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Bundle a10 = a(iObjectWrapper2);
        if (this.f15079b == null) {
            try {
                this.f15079b = new Ta(a10, "MultiProcessor");
            } catch (RuntimeException unused) {
                a.b("IRemoteDecoderDelegateImpl", "Ha error");
            } catch (Exception unused2) {
                a.b("IRemoteDecoderDelegateImpl", "Ha error");
            }
        }
        return a(iObjectWrapper, iObjectWrapper2);
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate
    public HmsScan[] detectWithByteBuffer(DetailRect detailRect, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Bundle a10 = a(iObjectWrapper2);
        if (this.f15079b == null) {
            try {
                this.f15079b = new Ta(a10, "MultiProcessor");
            } catch (RuntimeException unused) {
                a.b("IRemoteDecoderDelegateImpl", "Ha error");
            } catch (Exception unused2) {
                a.b("IRemoteDecoderDelegateImpl", "Ha error");
            }
        }
        return a(detailRect, iObjectWrapper, iObjectWrapper2);
    }

    private Bundle a(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null || !(ObjectWrapper.unwrap(iObjectWrapper) instanceof Bundle)) {
            return new Bundle();
        }
        return (Bundle) ObjectWrapper.unwrap(iObjectWrapper);
    }

    private HmsScan[] a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        boolean z10;
        int i10;
        boolean z11;
        if (iObjectWrapper == null) {
            a.b("ScankitRemoteS", "bitmap is null");
            return new HmsScan[0];
        }
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) {
            z10 = false;
            z11 = false;
            i10 = 0;
        } else {
            z11 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.PHOTO_MODE, false);
            i10 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.FORMAT_FLAG);
            int i11 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.TYPE_TRANS, 0);
            DetailRect.HMSSCAN_SDK_VALUE = i11;
            z10 = i11 >= 2;
            if (z10) {
                i10 = b.b(i10);
            }
        }
        if (!(unwrap instanceof Bitmap)) {
            return new HmsScan[0];
        }
        HmsScan[] a10 = D.a().a((Bitmap) unwrap, i10, z11, this.f15079b);
        return !z10 ? b.a(a10) : a10;
    }

    private HmsScan[] a(DetailRect detailRect, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        boolean z10;
        boolean z11;
        int i10;
        if (iObjectWrapper == null) {
            a.b("ScankitRemoteS", "bytebuffer is null");
            return new HmsScan[0];
        }
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) {
            z10 = false;
            i10 = 0;
            z11 = false;
        } else {
            int i11 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.FORMAT_FLAG);
            z11 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.PHOTO_MODE, false);
            int i12 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.TYPE_TRANS, 0);
            DetailRect.HMSSCAN_SDK_VALUE = i12;
            z10 = i12 >= 2;
            if (z10) {
                i11 = b.b(i11);
            }
            i10 = i11;
        }
        if (!(unwrap instanceof ByteBuffer)) {
            return new HmsScan[0];
        }
        HmsScan[] a10 = D.a().a((ByteBuffer) unwrap, detailRect == null ? 1000 : detailRect.width, detailRect == null ? 1000 : detailRect.height, i10, z11, this.f15079b);
        return !z10 ? b.a(a10) : a10;
    }
}
