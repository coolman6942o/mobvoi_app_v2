package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class ObservableParcelable<T extends Parcelable> extends ObservableField<T> implements Parcelable {
    public static final Parcelable.Creator<ObservableParcelable> CREATOR = new a();
    static final long serialVersionUID = 1;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<ObservableParcelable> {
        a() {
        }

        /* renamed from: a */
        public ObservableParcelable createFromParcel(Parcel parcel) {
            return new ObservableParcelable(parcel.readParcelable(a.class.getClassLoader()));
        }

        /* renamed from: b */
        public ObservableParcelable[] newArray(int i10) {
            return new ObservableParcelable[i10];
        }
    }

    public ObservableParcelable(T t10) {
        super(t10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable((Parcelable) get(), 0);
    }

    public ObservableParcelable() {
    }
}
