package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class PaymentConfirmation implements Parcelable {
    public static final Parcelable.Creator CREATOR = new l2();

    /* renamed from: a  reason: collision with root package name */
    private String f21628a;

    /* renamed from: b  reason: collision with root package name */
    private PayPalPayment f21629b;

    /* renamed from: c  reason: collision with root package name */
    private ProofOfPayment f21630c;

    private PaymentConfirmation(Parcel parcel) {
        this.f21628a = parcel.readString();
        this.f21629b = (PayPalPayment) parcel.readParcelable(PayPalPayment.class.getClassLoader());
        this.f21630c = (ProofOfPayment) parcel.readParcelable(ProofOfPayment.class.getClassLoader());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ PaymentConfirmation(Parcel parcel, byte b10) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PaymentConfirmation(String str, PayPalPayment payPalPayment, ProofOfPayment proofOfPayment) {
        this.f21628a = str;
        this.f21629b = payPalPayment;
        this.f21630c = proofOfPayment;
    }

    public final ProofOfPayment a() {
        return this.f21630c;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f21628a);
        parcel.writeParcelable(this.f21629b, 0);
        parcel.writeParcelable(this.f21630c, 0);
    }
}
