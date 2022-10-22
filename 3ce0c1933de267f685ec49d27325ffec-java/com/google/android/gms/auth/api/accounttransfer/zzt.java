package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.b;
import c6.a;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import com.mobvoi.wear.permission.PermissionConstant;
import com.unionpay.tsmservice.data.Constant;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class zzt extends zzaz {
    public static final Parcelable.Creator<zzt> CREATOR = new d();

    /* renamed from: h  reason: collision with root package name */
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> f8319h;

    /* renamed from: a  reason: collision with root package name */
    private final Set<Integer> f8320a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8321b;

    /* renamed from: c  reason: collision with root package name */
    private String f8322c;

    /* renamed from: d  reason: collision with root package name */
    private int f8323d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f8324e;

    /* renamed from: f  reason: collision with root package name */
    private PendingIntent f8325f;

    /* renamed from: g  reason: collision with root package name */
    private DeviceMetaData f8326g;

    static {
        HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
        f8319h = hashMap;
        hashMap.put(Constant.KEY_ACCOUNT_TYPE, FastJsonResponse.Field.K0(Constant.KEY_ACCOUNT_TYPE, 2));
        hashMap.put(PermissionConstant.Columns.STATUS, FastJsonResponse.Field.J0(PermissionConstant.Columns.STATUS, 3));
        hashMap.put("transferBytes", FastJsonResponse.Field.G0("transferBytes", 4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzt(Set<Integer> set, int i10, String str, int i11, byte[] bArr, PendingIntent pendingIntent, DeviceMetaData deviceMetaData) {
        this.f8320a = set;
        this.f8321b = i10;
        this.f8322c = str;
        this.f8323d = i11;
        this.f8324e = bArr;
        this.f8325f = pendingIntent;
        this.f8326g = deviceMetaData;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public /* synthetic */ Map a() {
        return f8319h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Object b(FastJsonResponse.Field field) {
        int M0 = field.M0();
        if (M0 == 1) {
            return Integer.valueOf(this.f8321b);
        }
        if (M0 == 2) {
            return this.f8322c;
        }
        if (M0 == 3) {
            return Integer.valueOf(this.f8323d);
        }
        if (M0 == 4) {
            return this.f8324e;
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
        return this.f8320a.contains(Integer.valueOf(field.M0()));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        Set<Integer> set = this.f8320a;
        if (set.contains(1)) {
            a.l(parcel, 1, this.f8321b);
        }
        if (set.contains(2)) {
            a.t(parcel, 2, this.f8322c, true);
        }
        if (set.contains(3)) {
            a.l(parcel, 3, this.f8323d);
        }
        if (set.contains(4)) {
            a.f(parcel, 4, this.f8324e, true);
        }
        if (set.contains(5)) {
            a.r(parcel, 5, this.f8325f, i10, true);
        }
        if (set.contains(6)) {
            a.r(parcel, 6, this.f8326g, i10, true);
        }
        a.b(parcel, a10);
    }

    public zzt() {
        this.f8320a = new b(3);
        this.f8321b = 1;
    }
}
