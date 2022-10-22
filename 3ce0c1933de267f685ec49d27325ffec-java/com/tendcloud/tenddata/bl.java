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
public class bl {

    /* renamed from: b  reason: collision with root package name */
    private static volatile bl f22738b = new bl();

    /* renamed from: a  reason: collision with root package name */
    private final LinkedBlockingQueue<IBinder> f22739a = new LinkedBlockingQueue<>(1);

    /* renamed from: c  reason: collision with root package name */
    private ServiceConnection f22740c = new ServiceConnection() { // from class: com.tendcloud.tenddata.bl.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            s.f22998a.execute(new Runnable() { // from class: com.tendcloud.tenddata.bl.1.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (bl.this.f22739a.size() > 0) {
                            bl.this.f22739a.clear();
                        }
                        bl.this.f22739a.put(iBinder);
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
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.mIBinder.transact(3, obtain, obtain2, 0);
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

    private bl() {
    }

    private void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction("com.asus.msa.action.ACCESS_DID");
            intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
            if (context.bindService(intent, this.f22740c, 1)) {
                try {
                    co.a().setOAID(new a(this.f22739a.take()).getOAID());
                } catch (Throwable unused) {
                }
                context.unbindService(this.f22740c);
            }
        } catch (Throwable unused2) {
        }
    }

    public static void bindASUSServiceGetOAID(Context context) {
        f22738b.b(context);
    }

    public static boolean a(Context context) {
        try {
            return bk.j();
        } catch (Throwable unused) {
            return false;
        }
    }
}
