package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.math.BigDecimal;
import java.util.Currency;
/* loaded from: classes2.dex */
public class eo implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    private BigDecimal f21187a;

    /* renamed from: b  reason: collision with root package name */
    private Currency f21188b;

    /* renamed from: c  reason: collision with root package name */
    private static /* synthetic */ boolean f21186c = true;
    public static final Parcelable.Creator CREATOR = new a3();

    public eo(Parcel parcel) {
        this.f21187a = new BigDecimal(parcel.readString());
        try {
            this.f21188b = Currency.getInstance(parcel.readString());
        } catch (IllegalArgumentException e10) {
            Log.e("MoneySpec", "Exception reading currency code from parcel", e10);
            throw new RuntimeException(e10);
        }
    }

    public eo(BigDecimal bigDecimal, String str) {
        this.f21187a = bigDecimal;
        this.f21188b = Currency.getInstance(str);
    }

    public final BigDecimal a() {
        return this.f21187a;
    }

    public final Currency b() {
        return this.f21188b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (f21186c || (obj instanceof eo)) {
            eo eoVar = (eo) obj;
            return eoVar.f21187a == this.f21187a && eoVar.f21188b.equals(this.f21188b);
        }
        throw new AssertionError();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f21187a.toString());
        parcel.writeString(this.f21188b.getCurrencyCode());
    }
}
