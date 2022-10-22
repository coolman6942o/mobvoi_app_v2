package com.mobvoi.vpa.vpacommonlib;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
/* loaded from: classes2.dex */
public class FragmentData implements Parcelable {
    public static final Parcelable.Creator<FragmentData> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private Bundle f20868a;

    /* renamed from: b  reason: collision with root package name */
    private final Class<? extends Fragment> f20869b;

    /* renamed from: c  reason: collision with root package name */
    private Fragment f20870c;

    /* renamed from: d  reason: collision with root package name */
    private String f20871d;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<FragmentData> {
        a() {
        }

        /* renamed from: a */
        public FragmentData createFromParcel(Parcel parcel) {
            return new FragmentData(parcel);
        }

        /* renamed from: b */
        public FragmentData[] newArray(int i10) {
            return new FragmentData[i10];
        }
    }

    public FragmentData(Class<? extends Fragment> cls, String str) {
        this.f20868a = new Bundle();
        this.f20869b = cls;
        this.f20871d = str;
    }

    public Bundle a() {
        return this.f20868a;
    }

    public Fragment b() {
        return this.f20870c;
    }

    public Class<? extends Fragment> c() {
        return this.f20869b;
    }

    public String d() {
        return this.f20871d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public FragmentData e(String str, Bundle bundle) {
        this.f20868a.putBundle(str, bundle);
        return this;
    }

    public void f() {
        this.f20871d = "";
        this.f20870c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(int i10) {
    }

    public void h(Fragment fragment) {
        this.f20870c = fragment;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeBundle(this.f20868a);
        parcel.writeSerializable(this.f20869b);
        parcel.writeString(this.f20871d);
    }

    protected FragmentData(Parcel parcel) {
        this.f20868a = new Bundle();
        this.f20868a = parcel.readBundle();
        this.f20869b = (Class) parcel.readSerializable();
        this.f20871d = parcel.readString();
    }
}
