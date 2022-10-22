package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.a;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import com.unionpay.tsmservice.data.Constant;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class zzo extends zzaz {
    public static final Parcelable.Creator<zzo> CREATOR = new b();

    /* renamed from: g  reason: collision with root package name */
    private static final a<String, FastJsonResponse.Field<?, ?>> f8305g;

    /* renamed from: a  reason: collision with root package name */
    private final int f8306a;

    /* renamed from: b  reason: collision with root package name */
    private List<String> f8307b;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f8308c;

    /* renamed from: d  reason: collision with root package name */
    private List<String> f8309d;

    /* renamed from: e  reason: collision with root package name */
    private List<String> f8310e;

    /* renamed from: f  reason: collision with root package name */
    private List<String> f8311f;

    static {
        a<String, FastJsonResponse.Field<?, ?>> aVar = new a<>();
        f8305g = aVar;
        aVar.put("registered", FastJsonResponse.Field.L0("registered", 2));
        aVar.put("in_progress", FastJsonResponse.Field.L0("in_progress", 3));
        aVar.put(Constant.CASH_LOAD_SUCCESS, FastJsonResponse.Field.L0(Constant.CASH_LOAD_SUCCESS, 4));
        aVar.put("failed", FastJsonResponse.Field.L0("failed", 5));
        aVar.put("escrowed", FastJsonResponse.Field.L0("escrowed", 6));
    }

    public zzo() {
        this.f8306a = 1;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Map<String, FastJsonResponse.Field<?, ?>> a() {
        return f8305g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Object b(FastJsonResponse.Field field) {
        switch (field.M0()) {
            case 1:
                return Integer.valueOf(this.f8306a);
            case 2:
                return this.f8307b;
            case 3:
                return this.f8308c;
            case 4:
                return this.f8309d;
            case 5:
                return this.f8310e;
            case 6:
                return this.f8311f;
            default:
                int M0 = field.M0();
                StringBuilder sb2 = new StringBuilder(37);
                sb2.append("Unknown SafeParcelable id=");
                sb2.append(M0);
                throw new IllegalStateException(sb2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public boolean d(FastJsonResponse.Field field) {
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = c6.a.a(parcel);
        c6.a.l(parcel, 1, this.f8306a);
        c6.a.v(parcel, 2, this.f8307b, false);
        c6.a.v(parcel, 3, this.f8308c, false);
        c6.a.v(parcel, 4, this.f8309d, false);
        c6.a.v(parcel, 5, this.f8310e, false);
        c6.a.v(parcel, 6, this.f8311f, false);
        c6.a.b(parcel, a10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(int i10, List<String> list, List<String> list2, List<String> list3, List<String> list4, List<String> list5) {
        this.f8306a = i10;
        this.f8307b = list;
        this.f8308c = list2;
        this.f8309d = list3;
        this.f8310e = list4;
        this.f8311f = list5;
    }
}
