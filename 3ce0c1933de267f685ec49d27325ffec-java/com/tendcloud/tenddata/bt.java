package com.tendcloud.tenddata;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.concurrent.LinkedBlockingQueue;
/* compiled from: td */
/* loaded from: classes2.dex */
public final class bt {

    /* renamed from: c  reason: collision with root package name */
    private static volatile bt f22755c = new bt();

    /* renamed from: b  reason: collision with root package name */
    private final LinkedBlockingQueue<IBinder> f22757b = new LinkedBlockingQueue<>(1);

    /* renamed from: a  reason: collision with root package name */
    ServiceConnection f22756a = new ServiceConnection() { // from class: com.tendcloud.tenddata.bt.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            s.f22998a.execute(new Runnable() { // from class: com.tendcloud.tenddata.bt.1.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (bt.this.f22757b.size() > 0) {
                            bt.this.f22757b.clear();
                        }
                        bt.this.f22757b.put(iBinder);
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

        public a(IBinder iBinder) {
            this.mIBinder = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.mIBinder;
        }

        public String getOAID() {
            String str = null;
            try {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    this.mIBinder.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.readString();
                } catch (Throwable unused) {
                    obtain2.recycle();
                    obtain.recycle();
                }
                obtain2.recycle();
                obtain.recycle();
            } catch (Throwable unused2) {
            }
            return str;
        }
    }

    private bt() {
    }

    private void b(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (context.bindService(intent, this.f22756a, 1)) {
            try {
                co.a().setOAID(new a(this.f22757b.take()).getOAID());
            } catch (Throwable unused) {
            }
            try {
                context.unbindService(this.f22756a);
            } catch (Throwable unused2) {
            }
        }
    }

    public static void bindSECServiceGetOAID(Context context) {
        f22755c.b(context);
    }

    public static boolean a(Context context) {
        try {
            if (!bk.g()) {
                return false;
            }
            context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
