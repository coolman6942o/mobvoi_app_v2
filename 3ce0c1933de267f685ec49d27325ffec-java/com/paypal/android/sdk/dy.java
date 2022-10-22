package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Random;
/* loaded from: classes2.dex */
public final class dy extends m2 implements Parcelable {
    public static final Parcelable.Creator CREATOR = new n2();

    public dy() {
        this.f21457b = System.currentTimeMillis() + 1800000;
        Random random = new Random(this.f21457b);
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < 8; i10++) {
            sb2.append((char) ((Math.abs(random.nextInt()) % 10) + 48));
        }
        this.f21456a = sb2.toString();
    }

    public dy(Parcel parcel) {
        super(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f21456a);
        parcel.writeLong(this.f21457b);
    }
}
