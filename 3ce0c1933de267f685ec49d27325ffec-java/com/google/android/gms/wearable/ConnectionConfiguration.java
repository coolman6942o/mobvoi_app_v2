package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable;
import b6.h;
import c6.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public class ConnectionConfiguration extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<ConnectionConfiguration> CREATOR = new r();

    /* renamed from: a  reason: collision with root package name */
    private final String f10193a;

    /* renamed from: b  reason: collision with root package name */
    private final String f10194b;

    /* renamed from: c  reason: collision with root package name */
    private final int f10195c;

    /* renamed from: d  reason: collision with root package name */
    private final int f10196d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f10197e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f10198f;

    /* renamed from: g  reason: collision with root package name */
    private volatile String f10199g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10200h;

    /* renamed from: i  reason: collision with root package name */
    private String f10201i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConnectionConfiguration(String str, String str2, int i10, int i11, boolean z10, boolean z11, String str3, boolean z12, String str4) {
        this.f10193a = str;
        this.f10194b = str2;
        this.f10195c = i10;
        this.f10196d = i11;
        this.f10197e = z10;
        this.f10198f = z11;
        this.f10199g = str3;
        this.f10200h = z12;
        this.f10201i = str4;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ConnectionConfiguration)) {
            return false;
        }
        ConnectionConfiguration connectionConfiguration = (ConnectionConfiguration) obj;
        return h.a(this.f10193a, connectionConfiguration.f10193a) && h.a(this.f10194b, connectionConfiguration.f10194b) && h.a(Integer.valueOf(this.f10195c), Integer.valueOf(connectionConfiguration.f10195c)) && h.a(Integer.valueOf(this.f10196d), Integer.valueOf(connectionConfiguration.f10196d)) && h.a(Boolean.valueOf(this.f10197e), Boolean.valueOf(connectionConfiguration.f10197e)) && h.a(Boolean.valueOf(this.f10200h), Boolean.valueOf(connectionConfiguration.f10200h));
    }

    public int hashCode() {
        return h.b(this.f10193a, this.f10194b, Integer.valueOf(this.f10195c), Integer.valueOf(this.f10196d), Boolean.valueOf(this.f10197e), Boolean.valueOf(this.f10200h));
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ConnectionConfiguration[ ");
        String valueOf = String.valueOf(this.f10193a);
        sb2.append(valueOf.length() != 0 ? "mName=".concat(valueOf) : new String("mName="));
        String valueOf2 = String.valueOf(this.f10194b);
        sb2.append(valueOf2.length() != 0 ? ", mAddress=".concat(valueOf2) : new String(", mAddress="));
        int i10 = this.f10195c;
        StringBuilder sb3 = new StringBuilder(19);
        sb3.append(", mType=");
        sb3.append(i10);
        sb2.append(sb3.toString());
        int i11 = this.f10196d;
        StringBuilder sb4 = new StringBuilder(19);
        sb4.append(", mRole=");
        sb4.append(i11);
        sb2.append(sb4.toString());
        boolean z10 = this.f10197e;
        StringBuilder sb5 = new StringBuilder(16);
        sb5.append(", mEnabled=");
        sb5.append(z10);
        sb2.append(sb5.toString());
        boolean z11 = this.f10198f;
        StringBuilder sb6 = new StringBuilder(20);
        sb6.append(", mIsConnected=");
        sb6.append(z11);
        sb2.append(sb6.toString());
        String valueOf3 = String.valueOf(this.f10199g);
        sb2.append(valueOf3.length() != 0 ? ", mPeerNodeId=".concat(valueOf3) : new String(", mPeerNodeId="));
        boolean z12 = this.f10200h;
        StringBuilder sb7 = new StringBuilder(21);
        sb7.append(", mBtlePriority=");
        sb7.append(z12);
        sb2.append(sb7.toString());
        String valueOf4 = String.valueOf(this.f10201i);
        sb2.append(valueOf4.length() != 0 ? ", mNodeId=".concat(valueOf4) : new String(", mNodeId="));
        sb2.append("]");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.t(parcel, 2, this.f10193a, false);
        a.t(parcel, 3, this.f10194b, false);
        a.l(parcel, 4, this.f10195c);
        a.l(parcel, 5, this.f10196d);
        a.c(parcel, 6, this.f10197e);
        a.c(parcel, 7, this.f10198f);
        a.t(parcel, 8, this.f10199g, false);
        a.c(parcel, 9, this.f10200h);
        a.t(parcel, 10, this.f10201i, false);
        a.b(parcel, a10);
    }
}
