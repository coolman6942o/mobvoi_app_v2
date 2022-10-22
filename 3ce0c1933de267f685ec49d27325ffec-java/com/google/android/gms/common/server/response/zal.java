package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public final class zal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zal> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    private final int f9014a;

    /* renamed from: b  reason: collision with root package name */
    final String f9015b;

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<zam> f9016c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zal(int i10, String str, ArrayList<zam> arrayList) {
        this.f9014a = i10;
        this.f9015b = str;
        this.f9016c = arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f9014a);
        a.t(parcel, 2, this.f9015b, false);
        a.x(parcel, 3, this.f9016c, false);
        a.b(parcel, a10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zal(String str, Map<String, FastJsonResponse.Field<?, ?>> map) {
        ArrayList<zam> arrayList;
        this.f9014a = 1;
        this.f9015b = str;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            for (String str2 : map.keySet()) {
                arrayList.add(new zam(str2, map.get(str2)));
            }
        }
        this.f9016c = arrayList;
    }
}
