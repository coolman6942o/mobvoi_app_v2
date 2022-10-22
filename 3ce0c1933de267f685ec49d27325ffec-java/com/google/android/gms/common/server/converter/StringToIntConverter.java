package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.a<String, Integer> {
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    private final int f8985a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, Integer> f8986b;

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray<String> f8987c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StringToIntConverter(int i10, ArrayList<zaa> arrayList) {
        this.f8985a = i10;
        this.f8986b = new HashMap<>();
        this.f8987c = new SparseArray<>();
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            zaa zaaVar = arrayList.get(i11);
            i11++;
            zaa zaaVar2 = zaaVar;
            G0(zaaVar2.f8989b, zaaVar2.f8990c);
        }
    }

    public final StringToIntConverter G0(String str, int i10) {
        this.f8986b.put(str, Integer.valueOf(i10));
        this.f8987c.put(i10, str);
        return this;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.a
    public final /* synthetic */ String h(Integer num) {
        String str = this.f8987c.get(num.intValue());
        return (str != null || !this.f8986b.containsKey("gms_unknown")) ? str : "gms_unknown";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f8985a);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f8986b.keySet()) {
            arrayList.add(new zaa(str, this.f8986b.get(str).intValue()));
        }
        a.x(parcel, 2, arrayList, false);
        a.b(parcel, a10);
    }

    /* loaded from: classes.dex */
    public static final class zaa extends AbstractSafeParcelable {
        public static final Parcelable.Creator<zaa> CREATOR = new c();

        /* renamed from: a  reason: collision with root package name */
        private final int f8988a;

        /* renamed from: b  reason: collision with root package name */
        final String f8989b;

        /* renamed from: c  reason: collision with root package name */
        final int f8990c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public zaa(int i10, String str, int i11) {
            this.f8988a = i10;
            this.f8989b = str;
            this.f8990c = i11;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i10) {
            int a10 = a.a(parcel);
            a.l(parcel, 1, this.f8988a);
            a.t(parcel, 2, this.f8989b, false);
            a.l(parcel, 3, this.f8990c);
            a.b(parcel, a10);
        }

        zaa(String str, int i10) {
            this.f8988a = 1;
            this.f8989b = str;
            this.f8990c = i10;
        }
    }

    public StringToIntConverter() {
        this.f8985a = 1;
        this.f8986b = new HashMap<>();
        this.f8987c = new SparseArray<>();
    }
}
