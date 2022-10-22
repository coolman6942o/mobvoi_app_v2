package com.huawei.hms.hmsscankit;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.api.IRemoteCreator;
import com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate;
import com.huawei.hms.ml.scan.HmsBuildBitmapOption;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.hms.scankit.p.Ya;
import com.huawei.hms.scankit.p._a;
import com.huawei.hms.scankit.util.a;
import com.mobvoi.wear.lpa.LpaConstants;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;
/* compiled from: RemoteDecoder.java */
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static volatile Ya f13999a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile IRemoteDecoderDelegate f14000b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle a(Context context, Bundle bundle) {
        Bundle bundle2 = null;
        if (f14000b == null) {
            IRemoteCreator b10 = j.b(context);
            if (b10 == null) {
                return null;
            }
            try {
                f14000b = b10.newRemoteDecoderDelegate();
            } catch (RemoteException unused) {
                a.b("RemoteDecoder", "queryDeepLinkInfoRemoteException1");
            }
            if (f14000b != null) {
                try {
                    IObjectWrapper queryDeepLinkInfo = f14000b.queryDeepLinkInfo(ObjectWrapper.wrap(bundle));
                    if (queryDeepLinkInfo != null) {
                        bundle2 = (Bundle) ObjectWrapper.unwrap(queryDeepLinkInfo);
                    } else {
                        a.b("RemoteDecoder", "queryDeepLinkInfo result null");
                    }
                } catch (RemoteException unused2) {
                    a.b("RemoteDecoder", "queryDeepLinkInfoRemoteException2");
                }
            }
        }
        return bundle2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static HmsScan[] a(Context context, Bitmap bitmap, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        HmsScan[] hmsScanArr = new HmsScan[0];
        if (f14000b == null) {
            IRemoteCreator b10 = j.b(context);
            if (b10 == null) {
                return hmsScanArr;
            }
            try {
                f14000b = b10.newRemoteDecoderDelegate();
            } catch (RemoteException unused) {
                a.b("RemoteDecoder", "RemoteException");
            }
        }
        if (f14000b == null) {
            return hmsScanArr;
        }
        try {
            Bundle bundle = new Bundle();
            if (hmsScanAnalyzerOptions != null) {
                bundle.putInt(DetailRect.FORMAT_FLAG, hmsScanAnalyzerOptions.mode);
                bundle.putBoolean(DetailRect.PHOTO_MODE, hmsScanAnalyzerOptions.photoMode);
            }
            bundle.putInt(DetailRect.TYPE_TRANS, 3);
            bundle.putAll(_a.a(context));
            HmsScan[] decodeWithBitmap = f14000b.decodeWithBitmap(ObjectWrapper.wrap(bitmap), ObjectWrapper.wrap(bundle));
            return decodeWithBitmap != null ? decodeWithBitmap : hmsScanArr;
        } catch (RemoteException unused2) {
            a.b("RemoteDecoder", "RemoteException");
            return hmsScanArr;
        }
    }

    private static void a(Bundle bundle) {
        if (DynamicModuleInitializer.getContext() == null) {
            try {
                j.a(AGConnectInstance.getInstance().getContext());
            } catch (ClassNotFoundException e10) {
                a.b("ClassNotFoundException", e10.getMessage());
            } catch (IllegalAccessException e11) {
                a.b("IllegalAccessException", e11.getMessage());
            } catch (NoSuchMethodException e12) {
                a.b("NoSuchMethodException", e12.getMessage());
            } catch (Exception e13) {
                a.b("Exception", e13.getMessage());
            } catch (NoClassDefFoundError e14) {
                a.b("NoClassDefFoundError", e14.getMessage());
                return;
            } catch (InvocationTargetException e15) {
                a.b("InvocationTargetException", e15.getMessage());
            }
        }
        try {
            if (f13999a == null) {
                try {
                    try {
                        f13999a = new Ya();
                        if (f13999a == null) {
                            return;
                        }
                    } catch (RuntimeException e16) {
                        a.b("RemoteDecoder", e16.getMessage());
                        if (f13999a == null) {
                            return;
                        }
                    }
                } catch (Exception e17) {
                    a.b("RemoteDecoder", e17.getMessage());
                    if (f13999a == null) {
                        return;
                    }
                }
            }
            f13999a.a(bundle);
        } catch (Throwable th2) {
            if (f13999a != null) {
                throw th2;
            }
        }
    }

    public static Bundle a(String str, int i10, int i11, int i12, HmsBuildBitmapOption hmsBuildBitmapOption) {
        Bundle bundle = new Bundle();
        bundle.putInt("contentLength", str == null ? -1 : str.length());
        bundle.putInt("scanType", i10);
        bundle.putInt("reqWidth", i11);
        bundle.putInt("reqHeight", i12);
        bundle.putString("buildBitmapOption", hmsBuildBitmapOption == null ? LpaConstants.VALUE_NULL : hmsBuildBitmapOption.toString());
        bundle.putString("apiName", "BuildBitmap");
        bundle.putLong("callTime", System.currentTimeMillis());
        bundle.putString("transId", UUID.randomUUID().toString());
        return bundle;
    }

    public static void a(int i10, Bitmap bitmap, Bundle bundle) {
        if (bundle != null) {
            bundle.putInt("result", i10);
            int i11 = -1;
            bundle.putInt("outputWidth", bitmap == null ? -1 : bitmap.getWidth());
            if (bitmap != null) {
                i11 = bitmap.getHeight();
            }
            bundle.putInt("outputHeight", i11);
            long j10 = bundle.getLong("callTime");
            bundle.putLong("costTime", System.currentTimeMillis() - j10);
            bundle.putString("callTime", new f("yyyyMMddHHmmss.SSS").format(Long.valueOf(j10)));
            a(bundle);
        }
    }
}
