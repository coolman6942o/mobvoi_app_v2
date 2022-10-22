package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ObservableByte extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableByte> CREATOR = new a();
    static final long serialVersionUID = 1;
    private byte mValue;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<ObservableByte> {
        a() {
        }

        /* renamed from: a */
        public ObservableByte createFromParcel(Parcel parcel) {
            return new ObservableByte(parcel.readByte());
        }

        /* renamed from: b */
        public ObservableByte[] newArray(int i10) {
            return new ObservableByte[i10];
        }
    }

    public ObservableByte(byte b10) {
        this.mValue = b10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public byte get() {
        return this.mValue;
    }

    public void set(byte b10) {
        if (b10 != this.mValue) {
            this.mValue = b10;
            notifyChange();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeByte(this.mValue);
    }

    public ObservableByte() {
    }

    public ObservableByte(f... fVarArr) {
        super(fVarArr);
    }
}
