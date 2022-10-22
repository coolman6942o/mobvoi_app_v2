package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class zzl extends zzaz {
    public static final Parcelable.Creator<zzl> CREATOR = new a();

    /* renamed from: f  reason: collision with root package name */
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> f8299f;

    /* renamed from: a  reason: collision with root package name */
    private final Set<Integer> f8300a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8301b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<zzr> f8302c;

    /* renamed from: d  reason: collision with root package name */
    private int f8303d;

    /* renamed from: e  reason: collision with root package name */
    private zzo f8304e;

    static {
        HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
        f8299f = hashMap;
        hashMap.put("authenticatorData", FastJsonResponse.Field.I0("authenticatorData", 2, zzr.class));
        hashMap.put("progress", FastJsonResponse.Field.H0("progress", 4, zzo.class));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzl(Set<Integer> set, int i10, ArrayList<zzr> arrayList, int i11, zzo zzoVar) {
        this.f8300a = set;
        this.f8301b = i10;
        this.f8302c = arrayList;
        this.f8303d = i11;
        this.f8304e = zzoVar;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final /* synthetic */ Map a() {
        return f8299f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final Object b(FastJsonResponse.Field field) {
        int M0 = field.M0();
        if (M0 == 1) {
            return Integer.valueOf(this.f8301b);
        }
        if (M0 == 2) {
            return this.f8302c;
        }
        if (M0 == 4) {
            return this.f8304e;
        }
        int M02 = field.M0();
        StringBuilder sb2 = new StringBuilder(37);
        sb2.append("Unknown SafeParcelable id=");
        sb2.append(M02);
        throw new IllegalStateException(sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final boolean d(FastJsonResponse.Field field) {
        return this.f8300a.contains(Integer.valueOf(field.M0()));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        Set<Integer> set = this.f8300a;
        if (set.contains(1)) {
            a.l(parcel, 1, this.f8301b);
        }
        if (set.contains(2)) {
            a.x(parcel, 2, this.f8302c, true);
        }
        if (set.contains(3)) {
            a.l(parcel, 3, this.f8303d);
        }
        if (set.contains(4)) {
            a.r(parcel, 4, this.f8304e, i10, true);
        }
        a.b(parcel, a10);
    }

    public zzl() {
        this.f8300a = new HashSet(1);
        this.f8301b = 1;
    }
}
