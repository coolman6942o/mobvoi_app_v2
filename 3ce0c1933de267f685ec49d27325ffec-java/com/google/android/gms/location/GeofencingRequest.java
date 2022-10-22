package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.location.zzbh;
import java.util.List;
/* loaded from: classes.dex */
public class GeofencingRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GeofencingRequest> CREATOR = new q();

    /* renamed from: a  reason: collision with root package name */
    private final List<zzbh> f9921a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9922b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9923c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GeofencingRequest(List<zzbh> list, int i10, String str) {
        this.f9921a = list;
        this.f9922b = i10;
        this.f9923c = str;
    }

    public int G0() {
        return this.f9922b;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("GeofencingRequest[");
        sb2.append("geofences=");
        sb2.append(this.f9921a);
        int i10 = this.f9922b;
        StringBuilder sb3 = new StringBuilder(30);
        sb3.append(", initialTrigger=");
        sb3.append(i10);
        sb3.append(", ");
        sb2.append(sb3.toString());
        String valueOf = String.valueOf(this.f9923c);
        sb2.append(valueOf.length() != 0 ? "tag=".concat(valueOf) : new String("tag="));
        sb2.append("]");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.x(parcel, 1, this.f9921a, false);
        a.l(parcel, 2, G0());
        a.t(parcel, 3, this.f9923c, false);
        a.b(parcel, a10);
    }
}
