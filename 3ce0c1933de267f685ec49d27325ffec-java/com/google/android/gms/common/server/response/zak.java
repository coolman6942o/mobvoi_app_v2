package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import b6.i;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private final int f9011a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> f9012b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9013c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zak(int i10, ArrayList<zal> arrayList, String str) {
        this.f9011a = i10;
        HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            zal zalVar = arrayList.get(i11);
            String str2 = zalVar.f9015b;
            HashMap hashMap2 = new HashMap();
            int size2 = zalVar.f9016c.size();
            for (int i12 = 0; i12 < size2; i12++) {
                zam zamVar = zalVar.f9016c.get(i12);
                hashMap2.put(zamVar.f9018b, zamVar.f9019c);
            }
            hashMap.put(str2, hashMap2);
        }
        this.f9012b = hashMap;
        this.f9013c = (String) i.k(str);
        G0();
    }

    public final void G0() {
        for (String str : this.f9012b.keySet()) {
            Map<String, FastJsonResponse.Field<?, ?>> map = this.f9012b.get(str);
            for (String str2 : map.keySet()) {
                map.get(str2).O0(this);
            }
        }
    }

    public final String H0() {
        return this.f9013c;
    }

    public final Map<String, FastJsonResponse.Field<?, ?>> I0(String str) {
        return this.f9012b.get(str);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        for (String str : this.f9012b.keySet()) {
            sb2.append(str);
            sb2.append(":\n");
            Map<String, FastJsonResponse.Field<?, ?>> map = this.f9012b.get(str);
            for (String str2 : map.keySet()) {
                sb2.append("  ");
                sb2.append(str2);
                sb2.append(": ");
                sb2.append(map.get(str2));
            }
        }
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f9011a);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f9012b.keySet()) {
            arrayList.add(new zal(str, this.f9012b.get(str)));
        }
        a.x(parcel, 2, arrayList, false);
        a.t(parcel, 3, this.f9013c, false);
        a.b(parcel, a10);
    }
}
