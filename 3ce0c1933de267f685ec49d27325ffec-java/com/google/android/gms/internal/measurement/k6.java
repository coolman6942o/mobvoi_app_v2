package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public class k6 implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f9464a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9465b;

    /* JADX INFO: Access modifiers changed from: protected */
    public k6(IBinder iBinder, String str) {
        this.f9464a = iBinder;
        this.f9465b = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void A2(int i10, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.f9464a.transact(i10, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel U1(int i10, Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.f9464a.transact(i10, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e10) {
            throw e10;
        } finally {
            parcel.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f9464a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel m1() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f9465b);
        return obtain;
    }
}
