package com.tendcloud.tenddata;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.security.MessageDigest;
import java.util.concurrent.LinkedBlockingQueue;
/* compiled from: td */
/* loaded from: classes2.dex */
public class bs {

    /* renamed from: b  reason: collision with root package name */
    private static String f22751b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile bs f22752c = new bs();

    /* renamed from: a  reason: collision with root package name */
    private final LinkedBlockingQueue<IBinder> f22753a = new LinkedBlockingQueue<>(1);

    /* renamed from: d  reason: collision with root package name */
    private ServiceConnection f22754d = new ServiceConnection() { // from class: com.tendcloud.tenddata.bs.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            s.f22998a.execute(new Runnable() { // from class: com.tendcloud.tenddata.bs.1.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (bs.this.f22753a.size() > 0) {
                            bs.this.f22753a.clear();
                        }
                        bs.this.f22753a.put(iBinder);
                    } catch (Throwable unused) {
                    }
                }
            });
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: td */
    /* loaded from: classes2.dex */
    public static class a implements IInterface {
        private IBinder mIBinder;

        a(IBinder iBinder) {
            this.mIBinder = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.mIBinder;
        }

        String getSerID(String str, String str2, String str3) {
            String str4 = null;
            try {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.mIBinder.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    str4 = obtain2.readString();
                } catch (Throwable unused) {
                }
                obtain.recycle();
                obtain2.recycle();
            } catch (Throwable unused2) {
            }
            return str4;
        }
    }

    private bs() {
    }

    private void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            if (context.bindService(intent, this.f22754d, 1)) {
                a aVar = new a(this.f22753a.take());
                try {
                    co.a().setOAID(a("OUID", context, aVar));
                } catch (Throwable unused) {
                }
                try {
                    co.a().setVAID(a("DUID", context, aVar));
                } catch (Throwable unused2) {
                }
                try {
                    co.a().setAAID(a("AUID", context, aVar));
                } catch (Throwable unused3) {
                }
                context.unbindService(this.f22754d);
            }
        } catch (Throwable unused4) {
        }
    }

    public static void bindOPPOServiceGetOAID(Context context) {
        f22752c.b(context);
    }

    public static boolean a(Context context) {
        PackageInfo packageInfo;
        try {
            if (bk.d() && (packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0)) != null) {
                return packageInfo.versionCode >= 1;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static String a(String str, Context context, a aVar) {
        Signature[] signatureArr;
        String packageName = context.getPackageName();
        if (f22751b == null) {
            String str2 = null;
            try {
                signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (Throwable unused) {
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb2 = new StringBuilder();
                        for (byte b10 : digest) {
                            sb2.append(Integer.toHexString((b10 & 255) | 256).substring(1, 3));
                        }
                        str2 = sb2.toString();
                    }
                } catch (Throwable unused2) {
                }
            }
            f22751b = str2;
        }
        return aVar.getSerID(packageName, f22751b, str);
    }
}
