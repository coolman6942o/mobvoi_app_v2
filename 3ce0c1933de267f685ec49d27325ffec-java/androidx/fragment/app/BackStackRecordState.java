package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.w;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class BackStackRecordState implements Parcelable {
    public static final Parcelable.Creator<BackStackRecordState> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final int[] f2916a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<String> f2917b;

    /* renamed from: c  reason: collision with root package name */
    final int[] f2918c;

    /* renamed from: d  reason: collision with root package name */
    final int[] f2919d;

    /* renamed from: e  reason: collision with root package name */
    final int f2920e;

    /* renamed from: f  reason: collision with root package name */
    final String f2921f;

    /* renamed from: g  reason: collision with root package name */
    final int f2922g;

    /* renamed from: h  reason: collision with root package name */
    final int f2923h;

    /* renamed from: i  reason: collision with root package name */
    final CharSequence f2924i;

    /* renamed from: j  reason: collision with root package name */
    final int f2925j;

    /* renamed from: k  reason: collision with root package name */
    final CharSequence f2926k;

    /* renamed from: l  reason: collision with root package name */
    final ArrayList<String> f2927l;

    /* renamed from: m  reason: collision with root package name */
    final ArrayList<String> f2928m;

    /* renamed from: n  reason: collision with root package name */
    final boolean f2929n;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<BackStackRecordState> {
        a() {
        }

        /* renamed from: a */
        public BackStackRecordState createFromParcel(Parcel parcel) {
            return new BackStackRecordState(parcel);
        }

        /* renamed from: b */
        public BackStackRecordState[] newArray(int i10) {
            return new BackStackRecordState[i10];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BackStackRecordState(androidx.fragment.app.a aVar) {
        int size = aVar.f3193a.size();
        this.f2916a = new int[size * 6];
        if (aVar.f3199g) {
            this.f2917b = new ArrayList<>(size);
            this.f2918c = new int[size];
            this.f2919d = new int[size];
            int i10 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                w.a aVar2 = aVar.f3193a.get(i11);
                int i12 = i10 + 1;
                this.f2916a[i10] = aVar2.f3210a;
                ArrayList<String> arrayList = this.f2917b;
                Fragment fragment = aVar2.f3211b;
                arrayList.add(fragment != null ? fragment.mWho : null);
                int[] iArr = this.f2916a;
                int i13 = i12 + 1;
                iArr[i12] = aVar2.f3212c ? 1 : 0;
                int i14 = i13 + 1;
                iArr[i13] = aVar2.f3213d;
                int i15 = i14 + 1;
                iArr[i14] = aVar2.f3214e;
                int i16 = i15 + 1;
                iArr[i15] = aVar2.f3215f;
                i10 = i16 + 1;
                iArr[i16] = aVar2.f3216g;
                this.f2918c[i11] = aVar2.f3217h.ordinal();
                this.f2919d[i11] = aVar2.f3218i.ordinal();
            }
            this.f2920e = aVar.f3198f;
            this.f2921f = aVar.f3201i;
            this.f2922g = aVar.f3043t;
            this.f2923h = aVar.f3202j;
            this.f2924i = aVar.f3203k;
            this.f2925j = aVar.f3204l;
            this.f2926k = aVar.f3205m;
            this.f2927l = aVar.f3206n;
            this.f2928m = aVar.f3207o;
            this.f2929n = aVar.f3208p;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    private void a(androidx.fragment.app.a aVar) {
        int i10 = 0;
        int i11 = 0;
        while (true) {
            boolean z10 = true;
            if (i10 < this.f2916a.length) {
                w.a aVar2 = new w.a();
                int i12 = i10 + 1;
                aVar2.f3210a = this.f2916a[i10];
                if (FragmentManager.H0(2)) {
                    Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i11 + " base fragment #" + this.f2916a[i12]);
                }
                aVar2.f3217h = Lifecycle.State.values()[this.f2918c[i11]];
                aVar2.f3218i = Lifecycle.State.values()[this.f2919d[i11]];
                int[] iArr = this.f2916a;
                int i13 = i12 + 1;
                if (iArr[i12] == 0) {
                    z10 = false;
                }
                aVar2.f3212c = z10;
                int i14 = i13 + 1;
                int i15 = iArr[i13];
                aVar2.f3213d = i15;
                int i16 = i14 + 1;
                int i17 = iArr[i14];
                aVar2.f3214e = i17;
                int i18 = i16 + 1;
                int i19 = iArr[i16];
                aVar2.f3215f = i19;
                i10 = i18 + 1;
                int i20 = iArr[i18];
                aVar2.f3216g = i20;
                aVar.f3194b = i15;
                aVar.f3195c = i17;
                aVar.f3196d = i19;
                aVar.f3197e = i20;
                aVar.f(aVar2);
                i11++;
            } else {
                aVar.f3198f = this.f2920e;
                aVar.f3201i = this.f2921f;
                aVar.f3199g = true;
                aVar.f3202j = this.f2923h;
                aVar.f3203k = this.f2924i;
                aVar.f3204l = this.f2925j;
                aVar.f3205m = this.f2926k;
                aVar.f3206n = this.f2927l;
                aVar.f3207o = this.f2928m;
                aVar.f3208p = this.f2929n;
                return;
            }
        }
    }

    public androidx.fragment.app.a b(FragmentManager fragmentManager) {
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(fragmentManager);
        a(aVar);
        aVar.f3043t = this.f2922g;
        for (int i10 = 0; i10 < this.f2917b.size(); i10++) {
            String str = this.f2917b.get(i10);
            if (str != null) {
                aVar.f3193a.get(i10).f3211b = fragmentManager.d0(str);
            }
        }
        aVar.A(1);
        return aVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeIntArray(this.f2916a);
        parcel.writeStringList(this.f2917b);
        parcel.writeIntArray(this.f2918c);
        parcel.writeIntArray(this.f2919d);
        parcel.writeInt(this.f2920e);
        parcel.writeString(this.f2921f);
        parcel.writeInt(this.f2922g);
        parcel.writeInt(this.f2923h);
        TextUtils.writeToParcel(this.f2924i, parcel, 0);
        parcel.writeInt(this.f2925j);
        TextUtils.writeToParcel(this.f2926k, parcel, 0);
        parcel.writeStringList(this.f2927l);
        parcel.writeStringList(this.f2928m);
        parcel.writeInt(this.f2929n ? 1 : 0);
    }

    BackStackRecordState(Parcel parcel) {
        this.f2916a = parcel.createIntArray();
        this.f2917b = parcel.createStringArrayList();
        this.f2918c = parcel.createIntArray();
        this.f2919d = parcel.createIntArray();
        this.f2920e = parcel.readInt();
        this.f2921f = parcel.readString();
        this.f2922g = parcel.readInt();
        this.f2923h = parcel.readInt();
        this.f2924i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2925j = parcel.readInt();
        this.f2926k = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2927l = parcel.createStringArrayList();
        this.f2928m = parcel.createStringArrayList();
        this.f2929n = parcel.readInt() != 0;
    }
}
