package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final List<String> f2930a;

    /* renamed from: b  reason: collision with root package name */
    final List<BackStackRecordState> f2931b;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<BackStackState> {
        a() {
        }

        /* renamed from: a */
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        /* renamed from: b */
        public BackStackState[] newArray(int i10) {
            return new BackStackState[i10];
        }
    }

    BackStackState(Parcel parcel) {
        this.f2930a = parcel.createStringArrayList();
        this.f2931b = parcel.createTypedArrayList(BackStackRecordState.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeStringList(this.f2930a);
        parcel.writeTypedList(this.f2931b);
    }
}
