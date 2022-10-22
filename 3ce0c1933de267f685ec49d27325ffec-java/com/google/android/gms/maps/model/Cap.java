package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b6.h;
import b6.i;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k6.b;
import z6.a;
/* loaded from: classes.dex */
public class Cap extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Cap> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final int f10024a;

    /* renamed from: b  reason: collision with root package name */
    private final a f10025b;

    /* renamed from: c  reason: collision with root package name */
    private final Float f10026c;

    private Cap(int i10, a aVar, Float f10) {
        i.b(i10 != 3 || (aVar != null && (f10 != null && (f10.floatValue() > 0.0f ? 1 : (f10.floatValue() == 0.0f ? 0 : -1)) > 0)), String.format("Invalid Cap: type=%s bitmapDescriptor=%s bitmapRefWidth=%s", Integer.valueOf(i10), aVar, f10));
        this.f10024a = i10;
        this.f10025b = aVar;
        this.f10026c = f10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cap)) {
            return false;
        }
        Cap cap = (Cap) obj;
        return this.f10024a == cap.f10024a && h.a(this.f10025b, cap.f10025b) && h.a(this.f10026c, cap.f10026c);
    }

    public int hashCode() {
        return h.b(Integer.valueOf(this.f10024a), this.f10025b, this.f10026c);
    }

    public String toString() {
        int i10 = this.f10024a;
        StringBuilder sb2 = new StringBuilder(23);
        sb2.append("[Cap: type=");
        sb2.append(i10);
        sb2.append("]");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = c6.a.a(parcel);
        c6.a.l(parcel, 2, this.f10024a);
        a aVar = this.f10025b;
        c6.a.k(parcel, 3, aVar == null ? null : aVar.a().asBinder(), false);
        c6.a.j(parcel, 4, this.f10026c, false);
        c6.a.b(parcel, a10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cap(int i10, IBinder iBinder, Float f10) {
        this(i10, iBinder == null ? null : new a(b.a.m1(iBinder)), f10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Cap(int i10) {
        this(i10, (a) null, (Float) null);
    }
}
