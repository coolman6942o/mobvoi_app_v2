package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import r6.b;
import r6.c;
/* loaded from: classes.dex */
public interface f extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class a extends b implements f {

        /* renamed from: com.google.android.gms.common.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0109a extends r6.a implements f {
            C0109a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
            }

            @Override // com.google.android.gms.common.internal.f
            public final Account o() throws RemoteException {
                Parcel U1 = U1(2, m1());
                Account account = (Account) c.b(U1, Account.CREATOR);
                U1.recycle();
                return account;
            }
        }

        public static f m1(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            if (queryLocalInterface instanceof f) {
                return (f) queryLocalInterface;
            }
            return new C0109a(iBinder);
        }
    }

    Account o() throws RemoteException;
}
