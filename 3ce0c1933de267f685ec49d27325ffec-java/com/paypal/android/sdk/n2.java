package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
final class n2 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new dy(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i10) {
        return new dy[i10];
    }
}
