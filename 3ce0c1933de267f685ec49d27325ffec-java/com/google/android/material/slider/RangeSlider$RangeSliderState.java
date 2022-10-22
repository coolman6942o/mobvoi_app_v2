package com.google.android.material.slider;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class RangeSlider$RangeSliderState extends AbsSavedState {
    public static final Parcelable.Creator<RangeSlider$RangeSliderState> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private float f11261a;

    /* renamed from: b  reason: collision with root package name */
    private int f11262b;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<RangeSlider$RangeSliderState> {
        a() {
        }

        /* renamed from: a */
        public RangeSlider$RangeSliderState createFromParcel(Parcel parcel) {
            return new RangeSlider$RangeSliderState(parcel);
        }

        /* renamed from: b */
        public RangeSlider$RangeSliderState[] newArray(int i10) {
            return new RangeSlider$RangeSliderState[i10];
        }
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeFloat(this.f11261a);
        parcel.writeInt(this.f11262b);
    }

    private RangeSlider$RangeSliderState(Parcel parcel) {
        super(parcel.readParcelable(RangeSlider$RangeSliderState.class.getClassLoader()));
        this.f11261a = parcel.readFloat();
        this.f11262b = parcel.readInt();
    }
}
