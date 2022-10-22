package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import b6.b;
import b6.h;
import c6.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
/* loaded from: classes.dex */
public class Asset extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Asset> CREATOR = new q();

    /* renamed from: a  reason: collision with root package name */
    private byte[] f10189a;

    /* renamed from: b  reason: collision with root package name */
    private String f10190b;

    /* renamed from: c  reason: collision with root package name */
    private ParcelFileDescriptor f10191c;

    /* renamed from: d  reason: collision with root package name */
    private Uri f10192d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Asset(byte[] bArr, String str, ParcelFileDescriptor parcelFileDescriptor, Uri uri) {
        this.f10189a = bArr;
        this.f10190b = str;
        this.f10191c = parcelFileDescriptor;
        this.f10192d = uri;
    }

    public String G0() {
        return this.f10190b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Asset)) {
            return false;
        }
        Asset asset = (Asset) obj;
        return Arrays.equals(this.f10189a, asset.f10189a) && h.a(this.f10190b, asset.f10190b) && h.a(this.f10191c, asset.f10191c) && h.a(this.f10192d, asset.f10192d);
    }

    public int hashCode() {
        return Arrays.deepHashCode(new Object[]{this.f10189a, this.f10190b, this.f10191c, this.f10192d});
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Asset[@");
        sb2.append(Integer.toHexString(hashCode()));
        if (this.f10190b == null) {
            sb2.append(", nodigest");
        } else {
            sb2.append(", ");
            sb2.append(this.f10190b);
        }
        if (this.f10189a != null) {
            sb2.append(", size=");
            sb2.append(this.f10189a.length);
        }
        if (this.f10191c != null) {
            sb2.append(", fd=");
            sb2.append(this.f10191c);
        }
        if (this.f10192d != null) {
            sb2.append(", uri=");
            sb2.append(this.f10192d);
        }
        sb2.append("]");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        b.c(parcel);
        int i11 = i10 | 1;
        int a10 = a.a(parcel);
        a.f(parcel, 2, this.f10189a, false);
        a.t(parcel, 3, G0(), false);
        a.r(parcel, 4, this.f10191c, i11, false);
        a.r(parcel, 5, this.f10192d, i11, false);
        a.b(parcel, a10);
    }
}
