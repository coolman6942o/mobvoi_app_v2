package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
final class r implements Parcelable.Creator<BinderWrapper> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ BinderWrapper createFromParcel(Parcel parcel) {
        return new BinderWrapper(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ BinderWrapper[] newArray(int i10) {
        return new BinderWrapper[i10];
    }
}
