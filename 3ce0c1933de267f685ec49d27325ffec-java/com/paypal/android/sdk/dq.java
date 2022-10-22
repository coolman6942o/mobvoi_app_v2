package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.Date;
/* loaded from: classes2.dex */
public final class dq extends h2 implements Parcelable {
    public static final Parcelable.Creator CREATOR = new j2();

    /* renamed from: b  reason: collision with root package name */
    private String f21149b;

    /* renamed from: c  reason: collision with root package name */
    private Date f21150c;

    /* renamed from: d  reason: collision with root package name */
    private String f21151d;

    /* renamed from: e  reason: collision with root package name */
    private ds f21152e;

    /* renamed from: f  reason: collision with root package name */
    private int f21153f;

    /* renamed from: g  reason: collision with root package name */
    private int f21154g;

    public dq() {
    }

    private dq(Parcel parcel) {
        this.f21333a = parcel.readString();
        this.f21149b = parcel.readString();
        this.f21151d = parcel.readString();
        this.f21150c = (Date) parcel.readSerializable();
        this.f21152e = (ds) parcel.readSerializable();
        this.f21153f = parcel.readInt();
        this.f21154g = parcel.readInt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ dq(Parcel parcel, byte b10) {
        this(parcel);
    }

    public dq(a aVar, String str, String str2, Date date, String str3, String str4, int i10, int i11) {
        this.f21333a = aVar.e(str2);
        this.f21149b = str;
        this.f21150c = date;
        c(str3);
        f(str4);
        this.f21153f = i10;
        this.f21154g = i11;
    }

    public dq(String str, String str2, String str3, String str4, String str5, int i10, int i11) {
        this.f21333a = str2;
        this.f21149b = str;
        this.f21150c = eu.a(str3);
        c(str4);
        f(str5);
        this.f21153f = i10;
        this.f21154g = i11;
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        return "x-" + str.substring(str.length() - 4);
    }

    private void c(String str) {
        this.f21151d = str != null ? str.substring(str.length() - 4) : null;
    }

    private void f(String str) {
        this.f21152e = ds.a(str);
    }

    public final boolean d() {
        Date date;
        ds dsVar;
        int i10;
        int i11;
        return !TextUtils.isEmpty(this.f21149b) && !TextUtils.isEmpty(this.f21151d) && !TextUtils.isEmpty(this.f21333a) && (date = this.f21150c) != null && !date.before(new Date()) && (dsVar = this.f21152e) != null && dsVar != ds.UNKNOWN && (i10 = this.f21153f) > 0 && i10 <= 12 && (i11 = this.f21154g) >= 0 && i11 <= 9999;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final Date e() {
        return this.f21150c;
    }

    public final String g() {
        return b(this.f21151d);
    }

    public final String h() {
        return this.f21149b;
    }

    public final int i() {
        return this.f21153f;
    }

    public final int j() {
        return this.f21154g;
    }

    public final ds k() {
        return this.f21152e;
    }

    public final String toString() {
        return "TokenizedCreditCard(token=" + this.f21149b + ",lastFourDigits=" + this.f21151d + ",payerId=" + this.f21333a + ",tokenValidUntil=" + this.f21150c + ",cardType=" + this.f21152e + ",expiryMonth/year=" + this.f21153f + "/" + this.f21154g + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f21333a);
        parcel.writeString(this.f21149b);
        parcel.writeString(this.f21151d);
        parcel.writeSerializable(this.f21150c);
        parcel.writeSerializable(this.f21152e);
        parcel.writeInt(this.f21153f);
        parcel.writeInt(this.f21154g);
    }
}
