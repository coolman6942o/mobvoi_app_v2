package com.google.firebase.iid;

import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import s6.d;
import s6.e;
/* loaded from: classes.dex */
public class zzi implements Parcelable {
    public static final Parcelable.Creator<zzi> CREATOR = new q();

    /* renamed from: a  reason: collision with root package name */
    private Messenger f12533a;

    /* renamed from: b  reason: collision with root package name */
    private d f12534b;

    /* loaded from: classes.dex */
    public static final class a extends ClassLoader {
        @Override // java.lang.ClassLoader
        protected final Class<?> loadClass(String str, boolean z10) throws ClassNotFoundException {
            if (!"com.google.android.gms.iid.MessengerCompat".equals(str)) {
                return super.loadClass(str, z10);
            }
            if (!FirebaseInstanceId.u()) {
                return zzi.class;
            }
            Log.d("FirebaseInstanceId", "Using renamed FirebaseIidMessengerCompat class");
            return zzi.class;
        }
    }

    public zzi(IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f12533a = new Messenger(iBinder);
        } else {
            this.f12534b = e.c(iBinder);
        }
    }

    private final IBinder a() {
        Messenger messenger = this.f12533a;
        return messenger != null ? messenger.getBinder() : this.f12534b.asBinder();
    }

    public final void b(Message message) throws RemoteException {
        Messenger messenger = this.f12533a;
        if (messenger != null) {
            messenger.send(message);
        } else {
            this.f12534b.E(message);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return a().equals(((zzi) obj).a());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        return a().hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        Messenger messenger = this.f12533a;
        parcel.writeStrongBinder(messenger != null ? messenger.getBinder() : this.f12534b.asBinder());
    }
}
