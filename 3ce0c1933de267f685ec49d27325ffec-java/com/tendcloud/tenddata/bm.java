package com.tendcloud.tenddata;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import java.util.concurrent.LinkedBlockingQueue;
/* compiled from: td */
/* loaded from: classes2.dex */
public final class bm {

    /* renamed from: c  reason: collision with root package name */
    private static volatile bm f22741c = new bm();

    /* renamed from: b  reason: collision with root package name */
    private final LinkedBlockingQueue<IBinder> f22743b = new LinkedBlockingQueue<>(1);

    /* renamed from: a  reason: collision with root package name */
    ServiceConnection f22742a = new ServiceConnection() { // from class: com.tendcloud.tenddata.bm.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            s.f22998a.execute(new Runnable() { // from class: com.tendcloud.tenddata.bm.1.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (bm.this.f22743b.size() > 0) {
                            bm.this.f22743b.clear();
                        }
                        bm.this.f22743b.put(iBinder);
                    } catch (Throwable unused) {
                    }
                }
            });
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* compiled from: td */
    /* loaded from: classes2.dex */
    public static final class a implements IInterface {
        private IBinder iBinder;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.iBinder;
        }

        public String getOAID() {
            String str = null;
            try {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.iBinder.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.readString();
                } catch (Throwable unused) {
                    obtain.recycle();
                    obtain2.recycle();
                }
                obtain.recycle();
                obtain2.recycle();
            } catch (Throwable unused2) {
            }
            return str;
        }

        private a(IBinder iBinder) {
            this.iBinder = iBinder;
        }
    }

    private bm() {
    }

    public static String b(Context context) {
        if (a(context, "com.huawei.hwid")) {
            return "com.huawei.hwid";
        }
        return a(context, "com.huawei.hms") ? "com.huawei.hms" : a(context, "com.huawei.hwid.tv") ? "com.huawei.hwid.tv" : "com.huawei.hwid";
    }

    public static void bindHWServiceGetOAID(Context context) {
        f22741c.c(context);
    }

    private void c(Context context) {
        try {
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage(b(context));
            if (context.bindService(intent, this.f22742a, 1)) {
                try {
                    co.a().setOAID(new a(this.f22743b.take()).getOAID());
                } catch (Throwable unused) {
                }
                context.unbindService(this.f22742a);
            }
        } catch (Throwable unused2) {
        }
    }

    public static boolean a(Context context) {
        try {
            if (bk.b() || bk.c()) {
                return !TextUtils.isEmpty(b(context));
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static PackageInfo b(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    return packageManager.getPackageInfo(str, 128);
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static boolean a(Context context, String str) {
        return b(context, str) != null;
    }
}
