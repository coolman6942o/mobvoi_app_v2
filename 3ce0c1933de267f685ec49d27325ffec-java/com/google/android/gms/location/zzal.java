package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class zzal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzal> CREATOR = new h();

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f9967a;

    /* renamed from: b  reason: collision with root package name */
    private final PendingIntent f9968b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9969c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzal(List<String> list, PendingIntent pendingIntent, String str) {
        this.f9967a = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.f9968b = pendingIntent;
        this.f9969c = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.v(parcel, 1, this.f9967a, false);
        a.r(parcel, 2, this.f9968b, i10, false);
        a.t(parcel, 3, this.f9969c, false);
        a.b(parcel, a10);
    }
}
