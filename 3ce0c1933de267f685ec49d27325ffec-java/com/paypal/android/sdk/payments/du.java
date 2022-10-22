package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import com.paypal.android.sdk.p3;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class du implements Parcelable {
    public static final Parcelable.Creator CREATOR = new x2();

    /* renamed from: a  reason: collision with root package name */
    private List f21700a;

    /* renamed from: b  reason: collision with root package name */
    private String f21701b;

    /* renamed from: c  reason: collision with root package name */
    private String f21702c;

    /* renamed from: d  reason: collision with root package name */
    private String f21703d;

    du() {
        this.f21700a = new ArrayList();
    }

    public du(Parcel parcel) {
        this();
        if (parcel != null) {
            this.f21701b = parcel.readString();
            this.f21702c = parcel.readString();
            this.f21703d = parcel.readString();
            ArrayList arrayList = new ArrayList();
            this.f21700a = arrayList;
            parcel.readList(arrayList, String.class.getClassLoader());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public du(p3 p3Var) {
        this.f21700a = b(p3Var.C());
        this.f21701b = p3Var.D();
        this.f21702c = p3Var.E();
        this.f21703d = p3Var.F();
    }

    private static List b(Map map) {
        ArrayList arrayList = new ArrayList();
        for (String str : map.keySet()) {
            if (((String) map.get(str)).toUpperCase().equals("Y")) {
                arrayList.add(str.toLowerCase(Locale.US));
            }
        }
        return arrayList;
    }

    public final List a() {
        return this.f21700a;
    }

    public final String c() {
        return this.f21701b;
    }

    public final String d() {
        return this.f21702c;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f21703d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f21701b);
        parcel.writeString(this.f21702c);
        parcel.writeString(this.f21703d);
        parcel.writeList(this.f21700a);
    }
}
