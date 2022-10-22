package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import b6.i;
import c6.a;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.wearable.g;
@KeepName
/* loaded from: classes.dex */
public class DataItemAssetParcelable extends AbstractSafeParcelable implements ReflectedParcelable, g {
    public static final Parcelable.Creator<DataItemAssetParcelable> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f10215a;

    /* renamed from: b  reason: collision with root package name */
    private final String f10216b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataItemAssetParcelable(String str, String str2) {
        this.f10215a = str;
        this.f10216b = str2;
    }

    @Override // com.google.android.gms.wearable.g
    public String getId() {
        return this.f10215a;
    }

    @Override // com.google.android.gms.wearable.g
    public String i() {
        return this.f10216b;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DataItemAssetParcelable[");
        sb2.append("@");
        sb2.append(Integer.toHexString(hashCode()));
        if (this.f10215a == null) {
            sb2.append(",noid");
        } else {
            sb2.append(",");
            sb2.append(this.f10215a);
        }
        sb2.append(", key=");
        sb2.append(this.f10216b);
        sb2.append("]");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.t(parcel, 2, getId(), false);
        a.t(parcel, 3, i(), false);
        a.b(parcel, a10);
    }

    public DataItemAssetParcelable(g gVar) {
        this.f10215a = (String) i.k(gVar.getId());
        this.f10216b = (String) i.k(gVar.i());
    }
}
