package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import c7.b1;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzl> CREATOR = new b1();

    /* renamed from: a  reason: collision with root package name */
    private int f10301a;

    /* renamed from: b  reason: collision with root package name */
    private final String f10302b;

    /* renamed from: c  reason: collision with root package name */
    private final String f10303c;

    /* renamed from: d  reason: collision with root package name */
    private final String f10304d;

    /* renamed from: e  reason: collision with root package name */
    private final String f10305e;

    /* renamed from: f  reason: collision with root package name */
    private final String f10306f;

    /* renamed from: g  reason: collision with root package name */
    private final String f10307g;

    /* renamed from: h  reason: collision with root package name */
    private final byte f10308h;

    /* renamed from: i  reason: collision with root package name */
    private final byte f10309i;

    /* renamed from: j  reason: collision with root package name */
    private final byte f10310j;

    /* renamed from: k  reason: collision with root package name */
    private final byte f10311k;

    /* renamed from: l  reason: collision with root package name */
    private final String f10312l;

    public zzl(int i10, String str, String str2, String str3, String str4, String str5, String str6, byte b10, byte b11, byte b12, byte b13, String str7) {
        this.f10301a = i10;
        this.f10302b = str;
        this.f10303c = str2;
        this.f10304d = str3;
        this.f10305e = str4;
        this.f10306f = str5;
        this.f10307g = str6;
        this.f10308h = b10;
        this.f10309i = b11;
        this.f10310j = b12;
        this.f10311k = b13;
        this.f10312l = str7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzl.class == obj.getClass()) {
            zzl zzlVar = (zzl) obj;
            if (this.f10301a != zzlVar.f10301a || this.f10308h != zzlVar.f10308h || this.f10309i != zzlVar.f10309i || this.f10310j != zzlVar.f10310j || this.f10311k != zzlVar.f10311k || !this.f10302b.equals(zzlVar.f10302b)) {
                return false;
            }
            String str = this.f10303c;
            if (str == null ? zzlVar.f10303c != null : !str.equals(zzlVar.f10303c)) {
                return false;
            }
            if (!this.f10304d.equals(zzlVar.f10304d) || !this.f10305e.equals(zzlVar.f10305e) || !this.f10306f.equals(zzlVar.f10306f)) {
                return false;
            }
            String str2 = this.f10307g;
            if (str2 == null ? zzlVar.f10307g != null : !str2.equals(zzlVar.f10307g)) {
                return false;
            }
            String str3 = this.f10312l;
            String str4 = zzlVar.f10312l;
            if (str3 != null) {
                return str3.equals(str4);
            }
            if (str4 == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (((this.f10301a + 31) * 31) + this.f10302b.hashCode()) * 31;
        String str = this.f10303c;
        int i10 = 0;
        int hashCode2 = (((((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f10304d.hashCode()) * 31) + this.f10305e.hashCode()) * 31) + this.f10306f.hashCode()) * 31;
        String str2 = this.f10307g;
        int hashCode3 = (((((((((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f10308h) * 31) + this.f10309i) * 31) + this.f10310j) * 31) + this.f10311k) * 31;
        String str3 = this.f10312l;
        if (str3 != null) {
            i10 = str3.hashCode();
        }
        return hashCode3 + i10;
    }

    public final String toString() {
        int i10 = this.f10301a;
        String str = this.f10302b;
        String str2 = this.f10303c;
        String str3 = this.f10304d;
        String str4 = this.f10305e;
        String str5 = this.f10306f;
        String str6 = this.f10307g;
        byte b10 = this.f10308h;
        byte b11 = this.f10309i;
        byte b12 = this.f10310j;
        byte b13 = this.f10311k;
        String str7 = this.f10312l;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 211 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(str6).length() + String.valueOf(str7).length());
        sb2.append("AncsNotificationParcelable{, id=");
        sb2.append(i10);
        sb2.append(", appId='");
        sb2.append(str);
        sb2.append('\'');
        sb2.append(", dateTime='");
        sb2.append(str2);
        sb2.append('\'');
        sb2.append(", notificationText='");
        sb2.append(str3);
        sb2.append('\'');
        sb2.append(", title='");
        sb2.append(str4);
        sb2.append('\'');
        sb2.append(", subtitle='");
        sb2.append(str5);
        sb2.append('\'');
        sb2.append(", displayName='");
        sb2.append(str6);
        sb2.append('\'');
        sb2.append(", eventId=");
        sb2.append((int) b10);
        sb2.append(", eventFlags=");
        sb2.append((int) b11);
        sb2.append(", categoryId=");
        sb2.append((int) b12);
        sb2.append(", categoryCount=");
        sb2.append((int) b13);
        sb2.append(", packageName='");
        sb2.append(str7);
        sb2.append('\'');
        sb2.append('}');
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 2, this.f10301a);
        a.t(parcel, 3, this.f10302b, false);
        a.t(parcel, 4, this.f10303c, false);
        a.t(parcel, 5, this.f10304d, false);
        a.t(parcel, 6, this.f10305e, false);
        a.t(parcel, 7, this.f10306f, false);
        String str = this.f10307g;
        if (str == null) {
            str = this.f10302b;
        }
        a.t(parcel, 8, str, false);
        a.e(parcel, 9, this.f10308h);
        a.e(parcel, 10, this.f10309i);
        a.e(parcel, 11, this.f10310j);
        a.e(parcel, 12, this.f10311k);
        a.t(parcel, 13, this.f10312l, false);
        a.b(parcel, a10);
    }
}
