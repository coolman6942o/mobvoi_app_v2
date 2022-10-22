package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    ArrayList<FragmentState> f3016a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<String> f3017b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<String> f3018c;

    /* renamed from: d  reason: collision with root package name */
    BackStackRecordState[] f3019d;

    /* renamed from: e  reason: collision with root package name */
    int f3020e;

    /* renamed from: f  reason: collision with root package name */
    String f3021f;

    /* renamed from: g  reason: collision with root package name */
    ArrayList<String> f3022g;

    /* renamed from: h  reason: collision with root package name */
    ArrayList<BackStackState> f3023h;

    /* renamed from: i  reason: collision with root package name */
    ArrayList<String> f3024i;

    /* renamed from: j  reason: collision with root package name */
    ArrayList<Bundle> f3025j;

    /* renamed from: k  reason: collision with root package name */
    ArrayList<FragmentManager.LaunchedFragmentInfo> f3026k;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<FragmentManagerState> {
        a() {
        }

        /* renamed from: a */
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        /* renamed from: b */
        public FragmentManagerState[] newArray(int i10) {
            return new FragmentManagerState[i10];
        }
    }

    public FragmentManagerState() {
        this.f3021f = null;
        this.f3022g = new ArrayList<>();
        this.f3023h = new ArrayList<>();
        this.f3024i = new ArrayList<>();
        this.f3025j = new ArrayList<>();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeTypedList(this.f3016a);
        parcel.writeStringList(this.f3017b);
        parcel.writeStringList(this.f3018c);
        parcel.writeTypedArray(this.f3019d, i10);
        parcel.writeInt(this.f3020e);
        parcel.writeString(this.f3021f);
        parcel.writeStringList(this.f3022g);
        parcel.writeTypedList(this.f3023h);
        parcel.writeStringList(this.f3024i);
        parcel.writeTypedList(this.f3025j);
        parcel.writeTypedList(this.f3026k);
    }

    public FragmentManagerState(Parcel parcel) {
        this.f3021f = null;
        this.f3022g = new ArrayList<>();
        this.f3023h = new ArrayList<>();
        this.f3024i = new ArrayList<>();
        this.f3025j = new ArrayList<>();
        this.f3016a = parcel.createTypedArrayList(FragmentState.CREATOR);
        this.f3017b = parcel.createStringArrayList();
        this.f3018c = parcel.createStringArrayList();
        this.f3019d = (BackStackRecordState[]) parcel.createTypedArray(BackStackRecordState.CREATOR);
        this.f3020e = parcel.readInt();
        this.f3021f = parcel.readString();
        this.f3022g = parcel.createStringArrayList();
        this.f3023h = parcel.createTypedArrayList(BackStackState.CREATOR);
        this.f3024i = parcel.createStringArrayList();
        this.f3025j = parcel.createTypedArrayList(Bundle.CREATOR);
        this.f3026k = parcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }
}
