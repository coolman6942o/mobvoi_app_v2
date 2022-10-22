package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.Lifecycle;
/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final String f3027a;

    /* renamed from: b  reason: collision with root package name */
    final String f3028b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f3029c;

    /* renamed from: d  reason: collision with root package name */
    final int f3030d;

    /* renamed from: e  reason: collision with root package name */
    final int f3031e;

    /* renamed from: f  reason: collision with root package name */
    final String f3032f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f3033g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f3034h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f3035i;

    /* renamed from: j  reason: collision with root package name */
    final Bundle f3036j;

    /* renamed from: k  reason: collision with root package name */
    final boolean f3037k;

    /* renamed from: l  reason: collision with root package name */
    final int f3038l;

    /* renamed from: m  reason: collision with root package name */
    Bundle f3039m;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<FragmentState> {
        a() {
        }

        /* renamed from: a */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        /* renamed from: b */
        public FragmentState[] newArray(int i10) {
            return new FragmentState[i10];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentState(Fragment fragment) {
        this.f3027a = fragment.getClass().getName();
        this.f3028b = fragment.mWho;
        this.f3029c = fragment.mFromLayout;
        this.f3030d = fragment.mFragmentId;
        this.f3031e = fragment.mContainerId;
        this.f3032f = fragment.mTag;
        this.f3033g = fragment.mRetainInstance;
        this.f3034h = fragment.mRemoving;
        this.f3035i = fragment.mDetached;
        this.f3036j = fragment.mArguments;
        this.f3037k = fragment.mHidden;
        this.f3038l = fragment.mMaxState.ordinal();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment a(j jVar, ClassLoader classLoader) {
        Fragment a10 = jVar.a(classLoader, this.f3027a);
        Bundle bundle = this.f3036j;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        a10.setArguments(this.f3036j);
        a10.mWho = this.f3028b;
        a10.mFromLayout = this.f3029c;
        a10.mRestored = true;
        a10.mFragmentId = this.f3030d;
        a10.mContainerId = this.f3031e;
        a10.mTag = this.f3032f;
        a10.mRetainInstance = this.f3033g;
        a10.mRemoving = this.f3034h;
        a10.mDetached = this.f3035i;
        a10.mHidden = this.f3037k;
        a10.mMaxState = Lifecycle.State.values()[this.f3038l];
        Bundle bundle2 = this.f3039m;
        if (bundle2 != null) {
            a10.mSavedFragmentState = bundle2;
        } else {
            a10.mSavedFragmentState = new Bundle();
        }
        return a10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentState{");
        sb2.append(this.f3027a);
        sb2.append(" (");
        sb2.append(this.f3028b);
        sb2.append(")}:");
        if (this.f3029c) {
            sb2.append(" fromLayout");
        }
        if (this.f3031e != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(this.f3031e));
        }
        String str = this.f3032f;
        if (str != null && !str.isEmpty()) {
            sb2.append(" tag=");
            sb2.append(this.f3032f);
        }
        if (this.f3033g) {
            sb2.append(" retainInstance");
        }
        if (this.f3034h) {
            sb2.append(" removing");
        }
        if (this.f3035i) {
            sb2.append(" detached");
        }
        if (this.f3037k) {
            sb2.append(" hidden");
        }
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f3027a);
        parcel.writeString(this.f3028b);
        parcel.writeInt(this.f3029c ? 1 : 0);
        parcel.writeInt(this.f3030d);
        parcel.writeInt(this.f3031e);
        parcel.writeString(this.f3032f);
        parcel.writeInt(this.f3033g ? 1 : 0);
        parcel.writeInt(this.f3034h ? 1 : 0);
        parcel.writeInt(this.f3035i ? 1 : 0);
        parcel.writeBundle(this.f3036j);
        parcel.writeInt(this.f3037k ? 1 : 0);
        parcel.writeBundle(this.f3039m);
        parcel.writeInt(this.f3038l);
    }

    FragmentState(Parcel parcel) {
        this.f3027a = parcel.readString();
        this.f3028b = parcel.readString();
        boolean z10 = true;
        this.f3029c = parcel.readInt() != 0;
        this.f3030d = parcel.readInt();
        this.f3031e = parcel.readInt();
        this.f3032f = parcel.readString();
        this.f3033g = parcel.readInt() != 0;
        this.f3034h = parcel.readInt() != 0;
        this.f3035i = parcel.readInt() != 0;
        this.f3036j = parcel.readBundle();
        this.f3037k = parcel.readInt() == 0 ? false : z10;
        this.f3039m = parcel.readBundle();
        this.f3038l = parcel.readInt();
    }
}
