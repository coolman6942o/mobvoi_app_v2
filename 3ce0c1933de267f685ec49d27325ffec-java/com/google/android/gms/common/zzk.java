package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.y;
import k6.b;
import k6.d;
/* loaded from: classes.dex */
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new p();

    /* renamed from: a  reason: collision with root package name */
    private final String f9038a;

    /* renamed from: b  reason: collision with root package name */
    private final j f9039b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f9040c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f9041d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzk(String str, IBinder iBinder, boolean z10, boolean z11) {
        this.f9038a = str;
        this.f9039b = G0(iBinder);
        this.f9040c = z10;
        this.f9041d = z11;
    }

    private static j G0(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        try {
            b Y1 = y.m1(iBinder).Y1();
            byte[] bArr = Y1 == null ? null : (byte[]) d.U1(Y1);
            if (bArr != null) {
                return new k(bArr);
            }
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
            return null;
        } catch (RemoteException e10) {
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e10);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        IBinder iBinder;
        int a10 = a.a(parcel);
        a.t(parcel, 1, this.f9038a, false);
        j jVar = this.f9039b;
        if (jVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            iBinder = null;
        } else {
            iBinder = jVar.asBinder();
        }
        a.k(parcel, 2, iBinder, false);
        a.c(parcel, 3, this.f9040c);
        a.c(parcel, 4, this.f9041d);
        a.b(parcel, a10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzk(String str, j jVar, boolean z10, boolean z11) {
        this.f9038a = str;
        this.f9039b = jVar;
        this.f9040c = z10;
        this.f9041d = z11;
    }
}
