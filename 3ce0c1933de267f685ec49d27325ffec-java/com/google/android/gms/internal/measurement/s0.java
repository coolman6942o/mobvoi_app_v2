package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public abstract class s0 extends l6 implements r0 {
    public s0() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.measurement.l6
    protected final boolean c(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        Object obj;
        switch (i10) {
            case 1:
                l1((zzeu) m6.a(parcel, zzeu.CREATOR), (zzdz) m6.a(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                K((zzjx) m6.a(parcel, zzjx.CREATOR), (zzdz) m6.a(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            default:
                return false;
            case 4:
                r0((zzdz) m6.a(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                return true;
            case 5:
                w0((zzeu) m6.a(parcel, zzeu.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                c0((zzdz) m6.a(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                obj = i1((zzdz) m6.a(parcel, zzdz.CREATOR), m6.e(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(obj);
                return true;
            case 9:
                byte[] P = P((zzeu) m6.a(parcel, zzeu.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(P);
                return true;
            case 10:
                x0(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                String r12 = r1((zzdz) m6.a(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(r12);
                return true;
            case 12:
                X0((zzed) m6.a(parcel, zzed.CREATOR), (zzdz) m6.a(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                C1((zzed) m6.a(parcel, zzed.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                obj = f2(parcel.readString(), parcel.readString(), m6.e(parcel), (zzdz) m6.a(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(obj);
                return true;
            case 15:
                obj = G(parcel.readString(), parcel.readString(), parcel.readString(), m6.e(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(obj);
                return true;
            case 16:
                obj = v2(parcel.readString(), parcel.readString(), (zzdz) m6.a(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(obj);
                return true;
            case 17:
                obj = e2(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(obj);
                return true;
            case 18:
                Q0((zzdz) m6.a(parcel, zzdz.CREATOR));
                parcel2.writeNoException();
                return true;
        }
    }
}
