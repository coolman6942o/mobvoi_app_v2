package com.paypal.android.sdk;

import android.os.Parcel;
/* loaded from: classes2.dex */
public abstract class m2 {

    /* renamed from: a  reason: collision with root package name */
    protected String f21456a;

    /* renamed from: b  reason: collision with root package name */
    protected long f21457b;

    public m2() {
    }

    public m2(Parcel parcel) {
        this.f21456a = parcel.readString();
        this.f21457b = parcel.readLong();
    }

    public final boolean a() {
        return this.f21457b > System.currentTimeMillis();
    }

    public final String b() {
        return this.f21456a;
    }
}
