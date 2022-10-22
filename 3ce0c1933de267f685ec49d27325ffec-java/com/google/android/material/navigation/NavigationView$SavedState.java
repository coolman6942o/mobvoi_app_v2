package com.google.android.material.navigation;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;
/* loaded from: classes.dex */
public class NavigationView$SavedState extends AbsSavedState {
    public static final Parcelable.Creator<NavigationView$SavedState> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    public Bundle f11120c;

    /* loaded from: classes.dex */
    static class a implements Parcelable.ClassLoaderCreator<NavigationView$SavedState> {
        a() {
        }

        /* renamed from: a */
        public NavigationView$SavedState createFromParcel(Parcel parcel) {
            return new NavigationView$SavedState(parcel, null);
        }

        /* renamed from: b */
        public NavigationView$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new NavigationView$SavedState(parcel, classLoader);
        }

        /* renamed from: c */
        public NavigationView$SavedState[] newArray(int i10) {
            return new NavigationView$SavedState[i10];
        }
    }

    public NavigationView$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f11120c = parcel.readBundle(classLoader);
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeBundle(this.f11120c);
    }
}
