package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import b6.i;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;
/* loaded from: classes.dex */
public class AccountChangeEventsResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEventsResponse> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private final int f8286a;

    /* renamed from: b  reason: collision with root package name */
    private final List<AccountChangeEvent> f8287b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AccountChangeEventsResponse(int i10, List<AccountChangeEvent> list) {
        this.f8286a = i10;
        this.f8287b = (List) i.k(list);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f8286a);
        a.x(parcel, 2, this.f8287b, false);
        a.b(parcel, a10);
    }
}
