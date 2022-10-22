package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import c6.a;
import java.util.List;
/* loaded from: classes.dex */
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final int f9020a;

    /* renamed from: b  reason: collision with root package name */
    private final long f9021b;

    /* renamed from: c  reason: collision with root package name */
    private int f9022c;

    /* renamed from: d  reason: collision with root package name */
    private final String f9023d;

    /* renamed from: e  reason: collision with root package name */
    private final String f9024e;

    /* renamed from: f  reason: collision with root package name */
    private final String f9025f;

    /* renamed from: g  reason: collision with root package name */
    private final int f9026g;

    /* renamed from: h  reason: collision with root package name */
    private final List<String> f9027h;

    /* renamed from: i  reason: collision with root package name */
    private final String f9028i;

    /* renamed from: j  reason: collision with root package name */
    private final long f9029j;

    /* renamed from: k  reason: collision with root package name */
    private int f9030k;

    /* renamed from: l  reason: collision with root package name */
    private final String f9031l;

    /* renamed from: m  reason: collision with root package name */
    private final float f9032m;

    /* renamed from: n  reason: collision with root package name */
    private final long f9033n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f9034o;

    /* renamed from: p  reason: collision with root package name */
    private long f9035p = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WakeLockEvent(int i10, long j10, int i11, String str, int i12, List<String> list, String str2, long j11, int i13, String str3, String str4, float f10, long j12, String str5, boolean z10) {
        this.f9020a = i10;
        this.f9021b = j10;
        this.f9022c = i11;
        this.f9023d = str;
        this.f9024e = str3;
        this.f9025f = str5;
        this.f9026g = i12;
        this.f9027h = list;
        this.f9028i = str2;
        this.f9029j = j11;
        this.f9030k = i13;
        this.f9031l = str4;
        this.f9032m = f10;
        this.f9033n = j12;
        this.f9034o = z10;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int G0() {
        return this.f9022c;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long H0() {
        return this.f9021b;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long I0() {
        return this.f9035p;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final String J0() {
        String str = this.f9023d;
        int i10 = this.f9026g;
        List<String> list = this.f9027h;
        String str2 = "";
        String join = list == null ? str2 : TextUtils.join(",", list);
        int i11 = this.f9030k;
        String str3 = this.f9024e;
        if (str3 == null) {
            str3 = str2;
        }
        String str4 = this.f9031l;
        if (str4 == null) {
            str4 = str2;
        }
        float f10 = this.f9032m;
        String str5 = this.f9025f;
        if (str5 != null) {
            str2 = str5;
        }
        boolean z10 = this.f9034o;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(join).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str2).length());
        sb2.append("\t");
        sb2.append(str);
        sb2.append("\t");
        sb2.append(i10);
        sb2.append("\t");
        sb2.append(join);
        sb2.append("\t");
        sb2.append(i11);
        sb2.append("\t");
        sb2.append(str3);
        sb2.append("\t");
        sb2.append(str4);
        sb2.append("\t");
        sb2.append(f10);
        sb2.append("\t");
        sb2.append(str2);
        sb2.append("\t");
        sb2.append(z10);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f9020a);
        a.o(parcel, 2, H0());
        a.t(parcel, 4, this.f9023d, false);
        a.l(parcel, 5, this.f9026g);
        a.v(parcel, 6, this.f9027h, false);
        a.o(parcel, 8, this.f9029j);
        a.t(parcel, 10, this.f9024e, false);
        a.l(parcel, 11, G0());
        a.t(parcel, 12, this.f9028i, false);
        a.t(parcel, 13, this.f9031l, false);
        a.l(parcel, 14, this.f9030k);
        a.i(parcel, 15, this.f9032m);
        a.o(parcel, 16, this.f9033n);
        a.t(parcel, 17, this.f9025f, false);
        a.c(parcel, 18, this.f9034o);
        a.b(parcel, a10);
    }
}
