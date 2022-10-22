package com.google.android.material.navigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.m;
import com.google.android.material.badge.a;
import com.google.android.material.internal.ParcelableSparseArray;
/* loaded from: classes.dex */
public class NavigationBarPresenter implements j {

    /* renamed from: a  reason: collision with root package name */
    private e f11105a;

    /* renamed from: b  reason: collision with root package name */
    private c f11106b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11107c = false;

    /* renamed from: d  reason: collision with root package name */
    private int f11108d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        int f11109a;

        /* renamed from: b  reason: collision with root package name */
        ParcelableSparseArray f11110b;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f11109a);
            parcel.writeParcelable(this.f11110b, 0);
        }

        SavedState(Parcel parcel) {
            this.f11109a = parcel.readInt();
            this.f11110b = (ParcelableSparseArray) parcel.readParcelable(getClass().getClassLoader());
        }
    }

    public void a(int i10) {
        this.f11108d = i10;
    }

    public void b(c cVar) {
        this.f11106b = cVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public void c(e eVar, boolean z10) {
    }

    @Override // androidx.appcompat.view.menu.j
    public void d(boolean z10) {
        if (!this.f11107c) {
            if (z10) {
                this.f11106b.d();
            } else {
                this.f11106b.l();
            }
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean e() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean f(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean g(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public int getId() {
        return this.f11108d;
    }

    @Override // androidx.appcompat.view.menu.j
    public void i(Context context, e eVar) {
        this.f11105a = eVar;
        this.f11106b.b(eVar);
    }

    @Override // androidx.appcompat.view.menu.j
    public void j(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f11106b.k(savedState.f11109a);
            this.f11106b.setBadgeDrawables(a.b(this.f11106b.getContext(), savedState.f11110b));
        }
    }

    public void k(boolean z10) {
        this.f11107c = z10;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean l(m mVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public Parcelable m() {
        SavedState savedState = new SavedState();
        savedState.f11109a = this.f11106b.getSelectedItemId();
        savedState.f11110b = a.c(this.f11106b.getBadgeDrawables());
        return savedState;
    }
}
