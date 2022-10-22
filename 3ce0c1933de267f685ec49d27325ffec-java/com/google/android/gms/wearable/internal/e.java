package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.wearable.b;
import v6.a;
/* loaded from: classes.dex */
public abstract class e extends b implements d {
    public e() {
        super("com.google.android.gms.wearable.internal.IWearableCallbacks");
    }

    @Override // com.google.android.gms.internal.wearable.b
    protected final boolean c(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        switch (i10) {
            case 2:
                w((zzdw) a.a(parcel, zzdw.CREATOR));
                break;
            case 3:
                v((zzfu) a.a(parcel, zzfu.CREATOR));
                break;
            case 4:
                m0((zzec) a.a(parcel, zzec.CREATOR));
                break;
            case 5:
                X1((DataHolder) a.a(parcel, DataHolder.CREATOR));
                break;
            case 6:
                F0((zzdg) a.a(parcel, zzdg.CREATOR));
                break;
            case 7:
                b0((zzga) a.a(parcel, zzga.CREATOR));
                break;
            case 8:
                W0((zzee) a.a(parcel, zzee.CREATOR));
                break;
            case 9:
                a2((zzeg) a.a(parcel, zzeg.CREATOR));
                break;
            case 10:
                l((zzea) a.a(parcel, zzea.CREATOR));
                break;
            case 11:
                o1((Status) a.a(parcel, Status.CREATOR));
                break;
            case 12:
                Q1((zzge) a.a(parcel, zzge.CREATOR));
                break;
            case 13:
                u0((zzdy) a.a(parcel, zzdy.CREATOR));
                break;
            case 14:
                S0((zzfq) a.a(parcel, zzfq.CREATOR));
                break;
            case 15:
                A1((zzbt) a.a(parcel, zzbt.CREATOR));
                break;
            case 16:
                c1((zzbt) a.a(parcel, zzbt.CREATOR));
                break;
            case 17:
                N1((zzdm) a.a(parcel, zzdm.CREATOR));
                break;
            case 18:
                i((zzdo) a.a(parcel, zzdo.CREATOR));
                break;
            case 19:
                o2((zzbn) a.a(parcel, zzbn.CREATOR));
                break;
            case 20:
                M((zzbp) a.a(parcel, zzbp.CREATOR));
                break;
            case 21:
            case 24:
            case 25:
            default:
                return false;
            case 22:
                N0((zzdk) a.a(parcel, zzdk.CREATOR));
                break;
            case 23:
                W((zzdi) a.a(parcel, zzdi.CREATOR));
                break;
            case 26:
                Q((zzf) a.a(parcel, zzf.CREATOR));
                break;
            case 27:
                f1((zzfy) a.a(parcel, zzfy.CREATOR));
                break;
            case 28:
                y1((zzdr) a.a(parcel, zzdr.CREATOR));
                break;
            case 29:
                R((zzdv) a.a(parcel, zzdv.CREATOR));
                break;
            case 30:
                n2((zzdt) a.a(parcel, zzdt.CREATOR));
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
