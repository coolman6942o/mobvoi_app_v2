package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import b6.h;
import b6.k;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public class ClientIdentity extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ClientIdentity> CREATOR = new k();

    /* renamed from: a  reason: collision with root package name */
    private final int f8868a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8869b;

    public ClientIdentity(int i10, String str) {
        this.f8868a = i10;
        this.f8869b = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof ClientIdentity)) {
            ClientIdentity clientIdentity = (ClientIdentity) obj;
            if (clientIdentity.f8868a == this.f8868a && h.a(clientIdentity.f8869b, this.f8869b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f8868a;
    }

    public String toString() {
        int i10 = this.f8868a;
        String str = this.f8869b;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 12);
        sb2.append(i10);
        sb2.append(":");
        sb2.append(str);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f8868a);
        a.t(parcel, 2, this.f8869b, false);
        a.b(parcel, a10);
    }
}
