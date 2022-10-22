package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;
/* loaded from: classes2.dex */
public final class PayPalPaymentDetails implements Parcelable {
    public static final Parcelable.Creator CREATOR = new t0();

    /* renamed from: a  reason: collision with root package name */
    private BigDecimal f21578a;

    /* renamed from: b  reason: collision with root package name */
    private BigDecimal f21579b;

    /* renamed from: c  reason: collision with root package name */
    private BigDecimal f21580c;

    private PayPalPaymentDetails(Parcel parcel) {
        try {
            String readString = parcel.readString();
            BigDecimal bigDecimal = null;
            this.f21579b = readString == null ? null : new BigDecimal(readString);
            String readString2 = parcel.readString();
            this.f21578a = readString2 == null ? null : new BigDecimal(readString2);
            String readString3 = parcel.readString();
            if (readString3 != null) {
                bigDecimal = new BigDecimal(readString3);
            }
            this.f21580c = bigDecimal;
        } catch (NumberFormatException unused) {
            throw new RuntimeException("error unparceling PayPalPaymentDetails");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ PayPalPaymentDetails(Parcel parcel, byte b10) {
        this(parcel);
    }

    public final BigDecimal a() {
        return this.f21579b;
    }

    public final BigDecimal b() {
        return this.f21578a;
    }

    public final BigDecimal c() {
        return this.f21580c;
    }

    public final boolean d() {
        return this.f21578a != null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        BigDecimal bigDecimal = this.f21579b;
        String str = null;
        parcel.writeString(bigDecimal == null ? null : bigDecimal.toString());
        BigDecimal bigDecimal2 = this.f21578a;
        parcel.writeString(bigDecimal2 == null ? null : bigDecimal2.toString());
        BigDecimal bigDecimal3 = this.f21580c;
        if (bigDecimal3 != null) {
            str = bigDecimal3.toString();
        }
        parcel.writeString(str);
    }
}
