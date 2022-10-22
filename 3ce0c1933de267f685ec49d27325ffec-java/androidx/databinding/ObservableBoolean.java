package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ObservableBoolean extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableBoolean> CREATOR = new a();
    static final long serialVersionUID = 1;
    private boolean mValue;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<ObservableBoolean> {
        a() {
        }

        /* renamed from: a */
        public ObservableBoolean createFromParcel(Parcel parcel) {
            boolean z10 = true;
            if (parcel.readInt() != 1) {
                z10 = false;
            }
            return new ObservableBoolean(z10);
        }

        /* renamed from: b */
        public ObservableBoolean[] newArray(int i10) {
            return new ObservableBoolean[i10];
        }
    }

    public ObservableBoolean(boolean z10) {
        this.mValue = z10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean get() {
        return this.mValue;
    }

    public void set(boolean z10) {
        if (z10 != this.mValue) {
            this.mValue = z10;
            notifyChange();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mValue ? 1 : 0);
    }

    public ObservableBoolean() {
    }

    public ObservableBoolean(f... fVarArr) {
        super(fVarArr);
    }
}
