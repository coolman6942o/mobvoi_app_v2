package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
/* loaded from: classes.dex */
public final class zaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaa> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final int f8991a;

    /* renamed from: b  reason: collision with root package name */
    private final StringToIntConverter f8992b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zaa(int i10, StringToIntConverter stringToIntConverter) {
        this.f8991a = i10;
        this.f8992b = stringToIntConverter;
    }

    public static zaa G0(FastJsonResponse.a<?, ?> aVar) {
        if (aVar instanceof StringToIntConverter) {
            return new zaa((StringToIntConverter) aVar);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public final FastJsonResponse.a<?, ?> H0() {
        StringToIntConverter stringToIntConverter = this.f8992b;
        if (stringToIntConverter != null) {
            return stringToIntConverter;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f8991a);
        a.r(parcel, 2, this.f8992b, i10, false);
        a.b(parcel, a10);
    }

    private zaa(StringToIntConverter stringToIntConverter) {
        this.f8991a = 1;
        this.f8992b = stringToIntConverter;
    }
}
