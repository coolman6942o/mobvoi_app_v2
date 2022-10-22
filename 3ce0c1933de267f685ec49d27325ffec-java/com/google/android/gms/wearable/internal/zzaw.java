package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import c6.a;
import c7.f;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.wearable.c;
/* loaded from: classes.dex */
public final class zzaw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaw> CREATOR = new f();

    /* renamed from: a  reason: collision with root package name */
    private final zzay f10228a;

    /* renamed from: b  reason: collision with root package name */
    private final int f10229b;

    /* renamed from: c  reason: collision with root package name */
    private final int f10230c;

    /* renamed from: d  reason: collision with root package name */
    private final int f10231d;

    public zzaw(zzay zzayVar, int i10, int i11, int i12) {
        this.f10228a = zzayVar;
        this.f10229b = i10;
        this.f10230c = i11;
        this.f10231d = i12;
    }

    public final void G0(c cVar) {
        int i10 = this.f10229b;
        if (i10 == 1) {
            cVar.onChannelOpened(this.f10228a);
        } else if (i10 == 2) {
            cVar.onChannelClosed(this.f10228a, this.f10230c, this.f10231d);
        } else if (i10 == 3) {
            cVar.onInputClosed(this.f10228a, this.f10230c, this.f10231d);
        } else if (i10 != 4) {
            StringBuilder sb2 = new StringBuilder(25);
            sb2.append("Unknown type: ");
            sb2.append(i10);
            Log.w("ChannelEventParcelable", sb2.toString());
        } else {
            cVar.onOutputClosed(this.f10228a, this.f10230c, this.f10231d);
        }
    }

    public final String toString() {
        String str;
        String str2;
        String valueOf = String.valueOf(this.f10228a);
        int i10 = this.f10229b;
        if (i10 == 1) {
            str = "CHANNEL_OPENED";
        } else if (i10 == 2) {
            str = "CHANNEL_CLOSED";
        } else if (i10 != 3) {
            str = i10 != 4 ? Integer.toString(i10) : "OUTPUT_CLOSED";
        } else {
            str = "INPUT_CLOSED";
        }
        int i11 = this.f10230c;
        if (i11 == 0) {
            str2 = "CLOSE_REASON_NORMAL";
        } else if (i11 == 1) {
            str2 = "CLOSE_REASON_DISCONNECTED";
        } else if (i11 != 2) {
            str2 = i11 != 3 ? Integer.toString(i11) : "CLOSE_REASON_LOCAL_CLOSE";
        } else {
            str2 = "CLOSE_REASON_REMOTE_CLOSE";
        }
        int i12 = this.f10231d;
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 81 + String.valueOf(str).length() + String.valueOf(str2).length());
        sb2.append("ChannelEventParcelable[, channel=");
        sb2.append(valueOf);
        sb2.append(", type=");
        sb2.append(str);
        sb2.append(", closeReason=");
        sb2.append(str2);
        sb2.append(", appErrorCode=");
        sb2.append(i12);
        sb2.append("]");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.r(parcel, 2, this.f10228a, i10, false);
        a.l(parcel, 3, this.f10229b);
        a.l(parcel, 4, this.f10230c);
        a.l(parcel, 5, this.f10231d);
        a.b(parcel, a10);
    }
}
