package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import b6.h;
import c6.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.huawei.hms.feature.dynamic.b;
/* loaded from: classes.dex */
public final class Status extends AbstractSafeParcelable implements h, ReflectedParcelable {

    /* renamed from: a  reason: collision with root package name */
    private final int f8448a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8449b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8450c;

    /* renamed from: d  reason: collision with root package name */
    private final PendingIntent f8451d;

    /* renamed from: e  reason: collision with root package name */
    public static final Status f8444e = new Status(0);

    /* renamed from: f  reason: collision with root package name */
    public static final Status f8445f = new Status(8);

    /* renamed from: g  reason: collision with root package name */
    public static final Status f8446g = new Status(15);

    /* renamed from: h  reason: collision with root package name */
    public static final Status f8447h = new Status(16);
    public static final Parcelable.Creator<Status> CREATOR = new n();

    static {
        new Status(14);
        new Status(17);
        new Status(18);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Status(int i10, int i11, String str, PendingIntent pendingIntent) {
        this.f8448a = i10;
        this.f8449b = i11;
        this.f8450c = str;
        this.f8451d = pendingIntent;
    }

    public final PendingIntent G0() {
        return this.f8451d;
    }

    public final int H0() {
        return this.f8449b;
    }

    public final String I0() {
        return this.f8450c;
    }

    public final boolean J0() {
        return this.f8451d != null;
    }

    public final boolean K0() {
        return this.f8449b <= 0;
    }

    public final void L0(Activity activity, int i10) throws IntentSender.SendIntentException {
        if (J0()) {
            activity.startIntentSenderForResult(this.f8451d.getIntentSender(), i10, null, 0, 0, 0);
        }
    }

    public final String M0() {
        String str = this.f8450c;
        return str != null ? str : b.a(this.f8449b);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f8448a == status.f8448a && this.f8449b == status.f8449b && h.a(this.f8450c, status.f8450c) && h.a(this.f8451d, status.f8451d);
    }

    @Override // com.google.android.gms.common.api.h
    public final Status getStatus() {
        return this;
    }

    public final int hashCode() {
        return h.b(Integer.valueOf(this.f8448a), Integer.valueOf(this.f8449b), this.f8450c, this.f8451d);
    }

    public final String toString() {
        return h.c(this).a("statusCode", M0()).a(b.f13797h, this.f8451d).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, H0());
        a.t(parcel, 2, I0(), false);
        a.r(parcel, 3, this.f8451d, i10, false);
        a.l(parcel, 1000, this.f8448a);
        a.b(parcel, a10);
    }

    public Status(int i10) {
        this(i10, null);
    }

    public Status(int i10, String str) {
        this(1, i10, str, null);
    }

    public Status(int i10, String str, PendingIntent pendingIntent) {
        this(1, i10, str, pendingIntent);
    }
}
