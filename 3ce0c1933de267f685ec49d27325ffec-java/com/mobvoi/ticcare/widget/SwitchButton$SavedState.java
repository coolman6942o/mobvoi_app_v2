package com.mobvoi.ticcare.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class SwitchButton$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<SwitchButton$SavedState> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    CharSequence f20843a;

    /* renamed from: b  reason: collision with root package name */
    CharSequence f20844b;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SwitchButton$SavedState> {
        a() {
        }

        /* renamed from: a */
        public SwitchButton$SavedState createFromParcel(Parcel parcel) {
            return new SwitchButton$SavedState(parcel);
        }

        /* renamed from: b */
        public SwitchButton$SavedState[] newArray(int i10) {
            return new SwitchButton$SavedState[i10];
        }
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        TextUtils.writeToParcel(this.f20843a, parcel, i10);
        TextUtils.writeToParcel(this.f20844b, parcel, i10);
    }

    private SwitchButton$SavedState(Parcel parcel) {
        super(parcel);
        this.f20843a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f20844b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }
}
