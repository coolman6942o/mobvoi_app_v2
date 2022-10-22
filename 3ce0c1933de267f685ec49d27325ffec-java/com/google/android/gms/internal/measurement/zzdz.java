package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import b6.i;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzdz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdz> CREATOR = new w();

    /* renamed from: a  reason: collision with root package name */
    public final String f9859a;

    /* renamed from: b  reason: collision with root package name */
    public final String f9860b;

    /* renamed from: c  reason: collision with root package name */
    public final String f9861c;

    /* renamed from: d  reason: collision with root package name */
    public final String f9862d;

    /* renamed from: e  reason: collision with root package name */
    public final long f9863e;

    /* renamed from: f  reason: collision with root package name */
    public final long f9864f;

    /* renamed from: g  reason: collision with root package name */
    public final String f9865g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f9866h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f9867i;

    /* renamed from: j  reason: collision with root package name */
    public final long f9868j;

    /* renamed from: k  reason: collision with root package name */
    public final String f9869k;

    /* renamed from: l  reason: collision with root package name */
    public final long f9870l;

    /* renamed from: m  reason: collision with root package name */
    public final long f9871m;

    /* renamed from: n  reason: collision with root package name */
    public final int f9872n;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f9873o;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f9874p;

    /* renamed from: q  reason: collision with root package name */
    public final boolean f9875q;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdz(String str, String str2, String str3, long j10, String str4, long j11, long j12, String str5, boolean z10, boolean z11, String str6, long j13, long j14, int i10, boolean z12, boolean z13, boolean z14) {
        i.g(str);
        this.f9859a = str;
        this.f9860b = TextUtils.isEmpty(str2) ? null : str2;
        this.f9861c = str3;
        this.f9868j = j10;
        this.f9862d = str4;
        this.f9863e = j11;
        this.f9864f = j12;
        this.f9865g = str5;
        this.f9866h = z10;
        this.f9867i = z11;
        this.f9869k = str6;
        this.f9870l = j13;
        this.f9871m = j14;
        this.f9872n = i10;
        this.f9873o = z12;
        this.f9874p = z13;
        this.f9875q = z14;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdz(String str, String str2, String str3, String str4, long j10, long j11, String str5, boolean z10, boolean z11, long j12, String str6, long j13, long j14, int i10, boolean z12, boolean z13, boolean z14) {
        this.f9859a = str;
        this.f9860b = str2;
        this.f9861c = str3;
        this.f9868j = j12;
        this.f9862d = str4;
        this.f9863e = j10;
        this.f9864f = j11;
        this.f9865g = str5;
        this.f9866h = z10;
        this.f9867i = z11;
        this.f9869k = str6;
        this.f9870l = j13;
        this.f9871m = j14;
        this.f9872n = i10;
        this.f9873o = z12;
        this.f9874p = z13;
        this.f9875q = z14;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.t(parcel, 2, this.f9859a, false);
        a.t(parcel, 3, this.f9860b, false);
        a.t(parcel, 4, this.f9861c, false);
        a.t(parcel, 5, this.f9862d, false);
        a.o(parcel, 6, this.f9863e);
        a.o(parcel, 7, this.f9864f);
        a.t(parcel, 8, this.f9865g, false);
        a.c(parcel, 9, this.f9866h);
        a.c(parcel, 10, this.f9867i);
        a.o(parcel, 11, this.f9868j);
        a.t(parcel, 12, this.f9869k, false);
        a.o(parcel, 13, this.f9870l);
        a.o(parcel, 14, this.f9871m);
        a.l(parcel, 15, this.f9872n);
        a.c(parcel, 16, this.f9873o);
        a.c(parcel, 17, this.f9874p);
        a.c(parcel, 18, this.f9875q);
        a.b(parcel, a10);
    }
}
