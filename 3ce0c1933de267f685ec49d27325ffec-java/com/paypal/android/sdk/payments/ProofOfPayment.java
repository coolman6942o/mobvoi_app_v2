package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import com.paypal.android.sdk.y1;
/* loaded from: classes2.dex */
public final class ProofOfPayment implements Parcelable {
    public static final Parcelable.Creator CREATOR = new y2();

    /* renamed from: a  reason: collision with root package name */
    private String f21642a;

    /* renamed from: b  reason: collision with root package name */
    private String f21643b;

    /* renamed from: c  reason: collision with root package name */
    private String f21644c;

    /* renamed from: d  reason: collision with root package name */
    private String f21645d;

    /* renamed from: e  reason: collision with root package name */
    private String f21646e;

    private ProofOfPayment(Parcel parcel) {
        this(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ProofOfPayment(Parcel parcel, byte b10) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProofOfPayment(String str, String str2, String str3, String str4, String str5) {
        this.f21642a = str;
        this.f21643b = str2;
        this.f21644c = str3;
        this.f21645d = str4;
        this.f21646e = str5;
        toString();
    }

    public final String a() {
        return this.f21643b;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        String str = y1.m(this.f21646e) ? this.f21646e : "no transactionId";
        return "{" + this.f21645d + ": " + str + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f21642a);
        parcel.writeString(this.f21643b);
        parcel.writeString(this.f21644c);
        parcel.writeString(this.f21645d);
        parcel.writeString(this.f21646e);
    }
}
