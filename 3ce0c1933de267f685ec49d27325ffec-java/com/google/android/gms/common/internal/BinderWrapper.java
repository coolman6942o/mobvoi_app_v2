package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
@KeepName
/* loaded from: classes.dex */
public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new r();

    /* renamed from: a  reason: collision with root package name */
    private IBinder f8867a;

    public BinderWrapper() {
        this.f8867a = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeStrongBinder(this.f8867a);
    }

    private BinderWrapper(Parcel parcel) {
        this.f8867a = null;
        this.f8867a = parcel.readStrongBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ BinderWrapper(Parcel parcel, r rVar) {
        this(parcel);
    }
}
