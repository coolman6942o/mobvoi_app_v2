package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import b6.h;
import b6.i;
import c6.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;
/* loaded from: classes.dex */
public class TokenData extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<TokenData> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    private final int f8288a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8289b;

    /* renamed from: c  reason: collision with root package name */
    private final Long f8290c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f8291d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f8292e;

    /* renamed from: f  reason: collision with root package name */
    private final List<String> f8293f;

    /* renamed from: g  reason: collision with root package name */
    private final String f8294g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TokenData(int i10, String str, Long l10, boolean z10, boolean z11, List<String> list, String str2) {
        this.f8288a = i10;
        this.f8289b = i.g(str);
        this.f8290c = l10;
        this.f8291d = z10;
        this.f8292e = z11;
        this.f8293f = list;
        this.f8294g = str2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TokenData)) {
            return false;
        }
        TokenData tokenData = (TokenData) obj;
        return TextUtils.equals(this.f8289b, tokenData.f8289b) && h.a(this.f8290c, tokenData.f8290c) && this.f8291d == tokenData.f8291d && this.f8292e == tokenData.f8292e && h.a(this.f8293f, tokenData.f8293f) && h.a(this.f8294g, tokenData.f8294g);
    }

    public int hashCode() {
        return h.b(this.f8289b, this.f8290c, Boolean.valueOf(this.f8291d), Boolean.valueOf(this.f8292e), this.f8293f, this.f8294g);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f8288a);
        a.t(parcel, 2, this.f8289b, false);
        a.p(parcel, 3, this.f8290c, false);
        a.c(parcel, 4, this.f8291d);
        a.c(parcel, 5, this.f8292e);
        a.v(parcel, 6, this.f8293f, false);
        a.t(parcel, 7, this.f8294g, false);
        a.b(parcel, a10);
    }
}
