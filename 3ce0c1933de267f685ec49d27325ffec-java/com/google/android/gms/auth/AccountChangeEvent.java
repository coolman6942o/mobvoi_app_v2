package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import b6.h;
import b6.i;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
/* loaded from: classes.dex */
public class AccountChangeEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEvent> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final int f8276a;

    /* renamed from: b  reason: collision with root package name */
    private final long f8277b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8278c;

    /* renamed from: d  reason: collision with root package name */
    private final int f8279d;

    /* renamed from: e  reason: collision with root package name */
    private final int f8280e;

    /* renamed from: f  reason: collision with root package name */
    private final String f8281f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AccountChangeEvent(int i10, long j10, String str, int i11, int i12, String str2) {
        this.f8276a = i10;
        this.f8277b = j10;
        this.f8278c = (String) i.k(str);
        this.f8279d = i11;
        this.f8280e = i12;
        this.f8281f = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AccountChangeEvent) {
            AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
            if (this.f8276a == accountChangeEvent.f8276a && this.f8277b == accountChangeEvent.f8277b && h.a(this.f8278c, accountChangeEvent.f8278c) && this.f8279d == accountChangeEvent.f8279d && this.f8280e == accountChangeEvent.f8280e && h.a(this.f8281f, accountChangeEvent.f8281f)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return h.b(Integer.valueOf(this.f8276a), Long.valueOf(this.f8277b), this.f8278c, Integer.valueOf(this.f8279d), Integer.valueOf(this.f8280e), this.f8281f);
    }

    public String toString() {
        int i10 = this.f8279d;
        String str = i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? GrsBaseInfo.CountryCodeSource.UNKNOWN : "RENAMED_TO" : "RENAMED_FROM" : "REMOVED" : "ADDED";
        String str2 = this.f8278c;
        String str3 = this.f8281f;
        int i11 = this.f8280e;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 91 + str.length() + String.valueOf(str3).length());
        sb2.append("AccountChangeEvent {accountName = ");
        sb2.append(str2);
        sb2.append(", changeType = ");
        sb2.append(str);
        sb2.append(", changeData = ");
        sb2.append(str3);
        sb2.append(", eventIndex = ");
        sb2.append(i11);
        sb2.append("}");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f8276a);
        a.o(parcel, 2, this.f8277b);
        a.t(parcel, 3, this.f8278c, false);
        a.l(parcel, 4, this.f8279d);
        a.l(parcel, 5, this.f8280e);
        a.t(parcel, 6, this.f8281f, false);
        a.b(parcel, a10);
    }
}
