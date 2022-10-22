package com.unionpay.mobile.android.pboctransaction;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class AppIdentification implements Parcelable, Comparable<AppIdentification> {
    public static final Parcelable.Creator<AppIdentification> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f23749a;

    /* renamed from: b  reason: collision with root package name */
    private String f23750b;

    private AppIdentification() {
        this.f23749a = "";
        this.f23750b = "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ AppIdentification(byte b10) {
        this();
    }

    public AppIdentification(String str, String str2) {
        this.f23749a = str;
        this.f23750b = str2;
    }

    public final String a() {
        return this.f23749a;
    }

    public final String b() {
        try {
            return this.f23749a.substring(14, 16);
        } catch (Exception unused) {
            return "";
        }
    }

    public final boolean c() {
        String str = this.f23749a;
        if (str != null) {
            return str.startsWith("A000000333");
        }
        return false;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(AppIdentification appIdentification) {
        String str;
        String str2;
        AppIdentification appIdentification2 = appIdentification;
        if (!this.f23749a.equalsIgnoreCase(appIdentification2.f23749a)) {
            str = this.f23749a;
            str2 = appIdentification2.f23749a;
        } else if (this.f23750b.equalsIgnoreCase(appIdentification2.f23750b)) {
            return 0;
        } else {
            str = this.f23750b;
            str2 = appIdentification2.f23750b;
        }
        return str.compareTo(str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AppIdentification)) {
            AppIdentification appIdentification = (AppIdentification) obj;
            if (this.f23749a.equalsIgnoreCase(appIdentification.f23749a) && this.f23750b.equalsIgnoreCase(appIdentification.f23750b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f23749a.hashCode() + 31) * 31) + this.f23750b.hashCode();
    }

    public String toString() {
        return "{appId:" + this.f23749a + ", appVersion:" + this.f23750b + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f23749a);
        parcel.writeString(this.f23750b);
    }
}
