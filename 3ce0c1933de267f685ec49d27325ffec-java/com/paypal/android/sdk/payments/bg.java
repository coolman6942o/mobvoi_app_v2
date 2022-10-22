package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public enum bg implements Parcelable {
    EMAIL,
    PIN,
    EMAIL_LOGIN_IN_PROGRESS,
    PIN_LOGIN_IN_PROGRESS,
    EMAIL_LOGIN_FAILED,
    PIN_LOGIN_FAILED,
    TWO_FA_SEND_FIRST_SMS,
    TWO_FA_SEND_FIRST_SMS_IN_PROGRESS,
    TWO_FA_SEND_ANOTHER_SMS_IN_PROGRESS,
    TWO_FA_ENTER_OTP,
    TWO_FA_LOGIN_OTP_IN_PROGRESS,
    TWO_FA_SEND_SMS_FAILED,
    TWO_FA_LOGIN_OTP_FAILED;
    
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.paypal.android.sdk.payments.i0
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return (bg) parcel.readSerializable();
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object[] newArray(int i10) {
            return new bg[i10];
        }
    };

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeSerializable(this);
    }
}
