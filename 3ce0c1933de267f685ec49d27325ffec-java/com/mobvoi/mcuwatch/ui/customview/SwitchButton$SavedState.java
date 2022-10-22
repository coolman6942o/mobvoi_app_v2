package com.mobvoi.mcuwatch.ui.customview;

import android.os.Parcel;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes2.dex */
class SwitchButton$SavedState extends View.BaseSavedState {

    /* renamed from: a  reason: collision with root package name */
    CharSequence f19622a;

    /* renamed from: b  reason: collision with root package name */
    CharSequence f19623b;

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        TextUtils.writeToParcel(this.f19622a, parcel, i10);
        TextUtils.writeToParcel(this.f19623b, parcel, i10);
    }
}
