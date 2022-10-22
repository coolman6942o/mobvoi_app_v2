package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ObservableShort extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableShort> CREATOR = new a();
    static final long serialVersionUID = 1;
    private short mValue;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<ObservableShort> {
        a() {
        }

        /* renamed from: a */
        public ObservableShort createFromParcel(Parcel parcel) {
            return new ObservableShort((short) parcel.readInt());
        }

        /* renamed from: b */
        public ObservableShort[] newArray(int i10) {
            return new ObservableShort[i10];
        }
    }

    public ObservableShort(short s10) {
        this.mValue = s10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public short get() {
        return this.mValue;
    }

    public void set(short s10) {
        if (s10 != this.mValue) {
            this.mValue = s10;
            notifyChange();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mValue);
    }

    public ObservableShort() {
    }

    public ObservableShort(f... fVarArr) {
        super(fVarArr);
    }
}
