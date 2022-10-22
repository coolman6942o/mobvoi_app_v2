package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.wearable.f;
import com.google.android.gms.wearable.g;
import com.mobvoi.wear.lpa.LpaConstants;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class zzdd extends AbstractSafeParcelable implements f {
    public static final Parcelable.Creator<zzdd> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    private final Uri f10242a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, g> f10243b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f10244c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdd(Uri uri, Bundle bundle, byte[] bArr) {
        this.f10242a = uri;
        HashMap hashMap = new HashMap();
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (String str : bundle.keySet()) {
            hashMap.put(str, (DataItemAssetParcelable) bundle.getParcelable(str));
        }
        this.f10243b = hashMap;
        this.f10244c = bArr;
    }

    public final Uri G0() {
        return this.f10242a;
    }

    public final byte[] c() {
        return this.f10244c;
    }

    public final String toString() {
        boolean isLoggable = Log.isLoggable("DataItem", 3);
        StringBuilder sb2 = new StringBuilder("DataItemParcelable[");
        sb2.append("@");
        sb2.append(Integer.toHexString(hashCode()));
        byte[] bArr = this.f10244c;
        String valueOf = String.valueOf(bArr == null ? LpaConstants.VALUE_NULL : Integer.valueOf(bArr.length));
        StringBuilder sb3 = new StringBuilder(valueOf.length() + 8);
        sb3.append(",dataSz=");
        sb3.append(valueOf);
        sb2.append(sb3.toString());
        int size = this.f10243b.size();
        StringBuilder sb4 = new StringBuilder(23);
        sb4.append(", numAssets=");
        sb4.append(size);
        sb2.append(sb4.toString());
        String valueOf2 = String.valueOf(this.f10242a);
        StringBuilder sb5 = new StringBuilder(valueOf2.length() + 6);
        sb5.append(", uri=");
        sb5.append(valueOf2);
        sb2.append(sb5.toString());
        if (!isLoggable) {
            sb2.append("]");
            return sb2.toString();
        }
        sb2.append("]\n  assets: ");
        for (String str : this.f10243b.keySet()) {
            String valueOf3 = String.valueOf(this.f10243b.get(str));
            StringBuilder sb6 = new StringBuilder(String.valueOf(str).length() + 7 + valueOf3.length());
            sb6.append("\n    ");
            sb6.append(str);
            sb6.append(": ");
            sb6.append(valueOf3);
            sb2.append(sb6.toString());
        }
        sb2.append("\n  ]");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.r(parcel, 2, G0(), i10, false);
        Bundle bundle = new Bundle();
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (Map.Entry<String, g> entry : this.f10243b.entrySet()) {
            bundle.putParcelable(entry.getKey(), new DataItemAssetParcelable(entry.getValue()));
        }
        a.d(parcel, 4, bundle, false);
        a.f(parcel, 5, c(), false);
        a.b(parcel, a10);
    }
}
