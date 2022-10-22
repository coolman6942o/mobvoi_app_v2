package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class zzr extends zzaz {
    public static final Parcelable.Creator<zzr> CREATOR = new c();

    /* renamed from: g  reason: collision with root package name */
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> f8312g;

    /* renamed from: a  reason: collision with root package name */
    private final Set<Integer> f8313a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8314b;

    /* renamed from: c  reason: collision with root package name */
    private zzt f8315c;

    /* renamed from: d  reason: collision with root package name */
    private String f8316d;

    /* renamed from: e  reason: collision with root package name */
    private String f8317e;

    /* renamed from: f  reason: collision with root package name */
    private String f8318f;

    static {
        HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
        f8312g = hashMap;
        hashMap.put("authenticatorInfo", FastJsonResponse.Field.H0("authenticatorInfo", 2, zzt.class));
        hashMap.put("signature", FastJsonResponse.Field.K0("signature", 3));
        hashMap.put("package", FastJsonResponse.Field.K0("package", 4));
    }

    public zzr() {
        this.f8313a = new HashSet(3);
        this.f8314b = 1;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public /* synthetic */ Map a() {
        return f8312g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Object b(FastJsonResponse.Field field) {
        int M0 = field.M0();
        if (M0 == 1) {
            return Integer.valueOf(this.f8314b);
        }
        if (M0 == 2) {
            return this.f8315c;
        }
        if (M0 == 3) {
            return this.f8316d;
        }
        if (M0 == 4) {
            return this.f8317e;
        }
        int M02 = field.M0();
        StringBuilder sb2 = new StringBuilder(37);
        sb2.append("Unknown SafeParcelable id=");
        sb2.append(M02);
        throw new IllegalStateException(sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public boolean d(FastJsonResponse.Field field) {
        return this.f8313a.contains(Integer.valueOf(field.M0()));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        Set<Integer> set = this.f8313a;
        if (set.contains(1)) {
            a.l(parcel, 1, this.f8314b);
        }
        if (set.contains(2)) {
            a.r(parcel, 2, this.f8315c, i10, true);
        }
        if (set.contains(3)) {
            a.t(parcel, 3, this.f8316d, true);
        }
        if (set.contains(4)) {
            a.t(parcel, 4, this.f8317e, true);
        }
        if (set.contains(5)) {
            a.t(parcel, 5, this.f8318f, true);
        }
        a.b(parcel, a10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzr(Set<Integer> set, int i10, zzt zztVar, String str, String str2, String str3) {
        this.f8313a = set;
        this.f8314b = i10;
        this.f8315c = zztVar;
        this.f8316d = str;
        this.f8317e = str2;
        this.f8318f = str3;
    }
}
