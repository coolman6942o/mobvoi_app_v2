package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import b6.b;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import com.mobvoi.wear.lpa.LpaConstants;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class PutDataRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PutDataRequest> CREATOR = new s();

    /* renamed from: a  reason: collision with root package name */
    private final Uri f10202a;

    /* renamed from: b  reason: collision with root package name */
    private final Bundle f10203b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f10204c;

    /* renamed from: d  reason: collision with root package name */
    private long f10205d;

    static {
        TimeUnit.MINUTES.toMillis(30L);
        new SecureRandom();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PutDataRequest(Uri uri, Bundle bundle, byte[] bArr, long j10) {
        this.f10202a = uri;
        this.f10203b = bundle;
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        this.f10204c = bArr;
        this.f10205d = j10;
    }

    public Uri G0() {
        return this.f10202a;
    }

    public String H0(boolean z10) {
        StringBuilder sb2 = new StringBuilder("PutDataRequest[");
        byte[] bArr = this.f10204c;
        String valueOf = String.valueOf(bArr == null ? LpaConstants.VALUE_NULL : Integer.valueOf(bArr.length));
        StringBuilder sb3 = new StringBuilder(valueOf.length() + 7);
        sb3.append("dataSz=");
        sb3.append(valueOf);
        sb2.append(sb3.toString());
        int size = this.f10203b.size();
        StringBuilder sb4 = new StringBuilder(23);
        sb4.append(", numAssets=");
        sb4.append(size);
        sb2.append(sb4.toString());
        String valueOf2 = String.valueOf(this.f10202a);
        StringBuilder sb5 = new StringBuilder(valueOf2.length() + 6);
        sb5.append(", uri=");
        sb5.append(valueOf2);
        sb2.append(sb5.toString());
        long j10 = this.f10205d;
        StringBuilder sb6 = new StringBuilder(35);
        sb6.append(", syncDeadline=");
        sb6.append(j10);
        sb2.append(sb6.toString());
        if (!z10) {
            sb2.append("]");
            return sb2.toString();
        }
        sb2.append("]\n  assets: ");
        for (String str : this.f10203b.keySet()) {
            String valueOf3 = String.valueOf(this.f10203b.getParcelable(str));
            StringBuilder sb7 = new StringBuilder(String.valueOf(str).length() + 7 + valueOf3.length());
            sb7.append("\n    ");
            sb7.append(str);
            sb7.append(": ");
            sb7.append(valueOf3);
            sb2.append(sb7.toString());
        }
        sb2.append("\n  ]");
        return sb2.toString();
    }

    public byte[] c() {
        return this.f10204c;
    }

    public String toString() {
        return H0(Log.isLoggable("DataMap", 3));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        b.d(parcel, "dest must not be null");
        int a10 = a.a(parcel);
        a.r(parcel, 2, G0(), i10, false);
        a.d(parcel, 4, this.f10203b, false);
        a.f(parcel, 5, c(), false);
        a.o(parcel, 6, this.f10205d);
        a.b(parcel, a10);
    }
}
