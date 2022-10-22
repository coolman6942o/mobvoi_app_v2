package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
final class y2 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ProofOfPayment(parcel, (byte) 0);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i10) {
        return new ProofOfPayment[i10];
    }
}
