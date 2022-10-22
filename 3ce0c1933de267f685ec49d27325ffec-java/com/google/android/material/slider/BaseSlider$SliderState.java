package com.google.android.material.slider;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class BaseSlider$SliderState extends View.BaseSavedState {
    public static final Parcelable.Creator<BaseSlider$SliderState> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    float f11256a;

    /* renamed from: b  reason: collision with root package name */
    float f11257b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<Float> f11258c;

    /* renamed from: d  reason: collision with root package name */
    float f11259d;

    /* renamed from: e  reason: collision with root package name */
    boolean f11260e;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<BaseSlider$SliderState> {
        a() {
        }

        /* renamed from: a */
        public BaseSlider$SliderState createFromParcel(Parcel parcel) {
            return new BaseSlider$SliderState(parcel, null);
        }

        /* renamed from: b */
        public BaseSlider$SliderState[] newArray(int i10) {
            return new BaseSlider$SliderState[i10];
        }
    }

    /* synthetic */ BaseSlider$SliderState(Parcel parcel, com.google.android.material.slider.a aVar) {
        this(parcel);
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeFloat(this.f11256a);
        parcel.writeFloat(this.f11257b);
        parcel.writeList(this.f11258c);
        parcel.writeFloat(this.f11259d);
        parcel.writeBooleanArray(new boolean[]{this.f11260e});
    }

    private BaseSlider$SliderState(Parcel parcel) {
        super(parcel);
        this.f11256a = parcel.readFloat();
        this.f11257b = parcel.readFloat();
        ArrayList<Float> arrayList = new ArrayList<>();
        this.f11258c = arrayList;
        parcel.readList(arrayList, Float.class.getClassLoader());
        this.f11259d = parcel.readFloat();
        this.f11260e = parcel.createBooleanArray()[0];
    }
}
