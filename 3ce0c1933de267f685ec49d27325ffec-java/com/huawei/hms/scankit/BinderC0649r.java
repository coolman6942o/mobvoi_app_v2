package com.huawei.hms.scankit;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.DetailRect;
import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate;
import com.huawei.hms.ml.scan.HmsBuildBitmapOption;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.p.C0645yb;
import com.huawei.hms.scankit.p.Ta;
import com.huawei.hms.scankit.p.Ya;
import com.huawei.hms.scankit.util.a;
import com.huawei.hms.scankit.util.b;
/* compiled from: IRemoteDecoderDelegateImpl.java */
/* renamed from: com.huawei.hms.scankit.r  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class BinderC0649r extends IRemoteDecoderDelegate.Stub {

    /* renamed from: a  reason: collision with root package name */
    private static volatile BinderC0649r f15071a = new BinderC0649r();

    /* renamed from: b  reason: collision with root package name */
    private volatile Ta f15072b = null;

    /* renamed from: c  reason: collision with root package name */
    private volatile Ya f15073c = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BinderC0649r a() {
        return f15071a;
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
    public IObjectWrapper buildBitmap(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (iObjectWrapper == null || !(ObjectWrapper.unwrap(iObjectWrapper) instanceof Bundle)) {
            throw new RemoteException("Bundle is Null");
        }
        Bundle bundle = (Bundle) ObjectWrapper.unwrap(iObjectWrapper);
        String string = bundle.getString(HmsBuildBitmapOption.TYPE_BUILD_BITMAP_CONTENT);
        int i10 = bundle.getInt(HmsBuildBitmapOption.TYPE_BUILD_BITMAP_FOTMAT);
        int i11 = bundle.getInt(HmsBuildBitmapOption.TYPE_BUILD_BITMAP_WIDTH);
        int i12 = bundle.getInt(HmsBuildBitmapOption.TYPE_BUILD_BITMAP_HEIGHT);
        int i13 = bundle.getInt(HmsBuildBitmapOption.TYPE_BUILD_BITMAP_MARGIN, 1);
        int i14 = bundle.getInt(HmsBuildBitmapOption.TYPE_BUILD_BITMAP_COLOR, -1);
        try {
            Bitmap a10 = new C0645yb().a(string, i10, i11, i12, new HmsBuildBitmapOption.Creator().setBitmapMargin(i13).setBitmapColor(i14).setBitmapBackgroundColor(bundle.getInt(HmsBuildBitmapOption.TYPE_BUILD_BITMAP_BACKCOLOR, -1)).create());
            if (a10 != null) {
                return ObjectWrapper.wrap(a10);
            }
            throw new RemoteException("Bitmap is Null");
        } catch (WriterException e10) {
            throw new RemoteException(e10.getMessage());
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
    public void buildBitmapLog(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper != null && (ObjectWrapper.unwrap(iObjectWrapper) instanceof Bundle)) {
            Bundle bundle = (Bundle) ObjectWrapper.unwrap(iObjectWrapper);
            try {
                if (this.f15073c == null) {
                    try {
                        try {
                            this.f15073c = new Ya();
                            if (this.f15073c == null) {
                                return;
                            }
                        } catch (RuntimeException e10) {
                            a.b("IRemoteDecoderDelegateImpl", e10.getMessage());
                            if (this.f15073c == null) {
                                return;
                            }
                        }
                    } catch (Exception e11) {
                        a.b("IRemoteDecoderDelegateImpl", e11.getMessage());
                        if (this.f15073c == null) {
                            return;
                        }
                    }
                }
                this.f15073c.a(bundle);
            } catch (Throwable th2) {
                if (this.f15073c != null) {
                    throw th2;
                }
            }
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
    public HmsScan[] decodeWithBitmap(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Bundle bundle;
        if (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) {
            bundle = new Bundle();
        } else {
            bundle = (Bundle) ObjectWrapper.unwrap(iObjectWrapper2);
        }
        if (this.f15072b == null) {
            try {
                this.f15072b = new Ta(bundle, "Bitmap");
            } catch (RuntimeException unused) {
                a.b("IRemoteDecoderDelegateImpl", "Ha error");
            } catch (Exception unused2) {
                a.b("IRemoteDecoderDelegateImpl", "Ha error");
            }
        }
        return a(iObjectWrapper, iObjectWrapper2);
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
    public IObjectWrapper queryDeepLinkInfo(IObjectWrapper iObjectWrapper) throws RemoteException {
        return null;
    }

    private HmsScan[] a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        boolean z10;
        int i10;
        if (iObjectWrapper == null) {
            a.b("IRemoteDecoder", "bitmap is null");
            return new HmsScan[0];
        }
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        boolean z11 = true;
        if (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) {
            i10 = 0;
            z10 = true;
            z11 = false;
        } else {
            i10 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.FORMAT_FLAG);
            z10 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.PHOTO_MODE, false);
            int i11 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.TYPE_TRANS, 0);
            DetailRect.HMSSCAN_SDK_VALUE = i11;
            if (i11 < 2) {
                z11 = false;
            }
            if (z11) {
                i10 = b.b(i10);
            }
        }
        if (!(unwrap instanceof Bitmap)) {
            return new HmsScan[0];
        }
        HmsScan[] b10 = D.a().b((Bitmap) unwrap, i10, z10, this.f15072b);
        return !z11 ? b.a(b10) : b10;
    }
}
