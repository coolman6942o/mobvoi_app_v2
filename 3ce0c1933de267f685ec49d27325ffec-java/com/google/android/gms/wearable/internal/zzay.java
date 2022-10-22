package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import b6.h;
import b6.i;
import c6.a;
import c7.g;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelClient;
/* loaded from: classes.dex */
public final class zzay extends AbstractSafeParcelable implements Channel, ChannelClient.Channel {
    public static final Parcelable.Creator<zzay> CREATOR = new g();

    /* renamed from: a  reason: collision with root package name */
    private final String f10232a;

    /* renamed from: b  reason: collision with root package name */
    private final String f10233b;

    /* renamed from: c  reason: collision with root package name */
    private final String f10234c;

    public zzay(String str, String str2, String str3) {
        this.f10232a = (String) i.k(str);
        this.f10233b = (String) i.k(str2);
        this.f10234c = (String) i.k(str3);
    }

    public final String G0() {
        return this.f10233b;
    }

    public final String a() {
        return this.f10234c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzay)) {
            return false;
        }
        zzay zzayVar = (zzay) obj;
        return this.f10232a.equals(zzayVar.f10232a) && h.a(zzayVar.f10233b, this.f10233b) && h.a(zzayVar.f10234c, this.f10234c);
    }

    public final int hashCode() {
        return this.f10232a.hashCode();
    }

    public final String toString() {
        int i10 = 0;
        for (char c10 : this.f10232a.toCharArray()) {
            i10 += c10;
        }
        String trim = this.f10232a.trim();
        int length = trim.length();
        if (length > 25) {
            String substring = trim.substring(0, 10);
            String substring2 = trim.substring(length - 10, length);
            StringBuilder sb2 = new StringBuilder(String.valueOf(substring).length() + 16 + String.valueOf(substring2).length());
            sb2.append(substring);
            sb2.append("...");
            sb2.append(substring2);
            sb2.append("::");
            sb2.append(i10);
            trim = sb2.toString();
        }
        String str = this.f10233b;
        String str2 = this.f10234c;
        StringBuilder sb3 = new StringBuilder(String.valueOf(trim).length() + 31 + String.valueOf(str).length() + String.valueOf(str2).length());
        sb3.append("Channel{token=");
        sb3.append(trim);
        sb3.append(", nodeId=");
        sb3.append(str);
        sb3.append(", path=");
        sb3.append(str2);
        sb3.append("}");
        return sb3.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.t(parcel, 2, this.f10232a, false);
        a.t(parcel, 3, G0(), false);
        a.t(parcel, 4, a(), false);
        a.b(parcel, a10);
    }
}
