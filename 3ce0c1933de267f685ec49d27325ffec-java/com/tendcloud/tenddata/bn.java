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
public class bn {

    /* renamed from: b  reason: collision with root package name */
    private static volatile bn f22744b = new bn();

    /* renamed from: a  reason: collision with root package name */
    private final LinkedBlockingQueue<IBinder> f22745a = new LinkedBlockingQueue<>(1);

    /* renamed from: c  reason: collision with root package name */
    private ServiceConnection f22746c = new ServiceConnection() { // from class: com.tendcloud.tenddata.bn.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            s.f22998a.execute(new Runnable() { // from class: com.tendcloud.tenddata.bn.1.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (bn.this.f22745a.size() > 0) {
                            bn.this.f22745a.clear();
                        }
                        bn.this.f22745a.put(iBinder);
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

        String getOAID() {
            String str = null;
            try {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.mIBinder.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.readString();
                } catch (Throwable unused) {
                }
                obtain.recycle();
                obtain2.recycle();
            } catch (Throwable unused2) {
            }
            return str;
        }
    }

    private bn() {
    }

    private void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (context.bindService(intent, this.f22746c, 1)) {
                try {
                    co.a().setOAID(new a(this.f22745a.take()).getOAID());
                } catch (Throwable unused) {
                }
                context.unbindService(this.f22746c);
            }
        } catch (Throwable unused2) {
        }
    }

    public static void bindLENOVOServiceGetOAID(Context context) {
        f22744b.b(context);
    }

    public static boolean a(Context context) {
        try {
            if (!bk.k()) {
                return false;
            }
            context.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
