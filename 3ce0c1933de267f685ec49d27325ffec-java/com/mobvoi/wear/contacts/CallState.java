package com.mobvoi.wear.contacts;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class CallState implements Parcelable {
    public static final Parcelable.Creator<CallState> CREATOR = new Parcelable.Creator<CallState>() { // from class: com.mobvoi.wear.contacts.CallState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CallState createFromParcel(Parcel parcel) {
            CallState callState = new CallState();
            callState.number = parcel.readString();
            callState.state = parcel.readString();
            return callState;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CallState[] newArray(int i10) {
            return new CallState[i10];
        }
    };
    public String command;
    public String number;
    public String state;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.command);
        parcel.writeString(this.number);
        parcel.writeString(this.state);
    }
}
