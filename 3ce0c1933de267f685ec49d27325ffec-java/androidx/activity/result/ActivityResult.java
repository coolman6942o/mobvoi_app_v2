package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class ActivityResult implements Parcelable {
    public static final Parcelable.Creator<ActivityResult> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final int f323a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f324b;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<ActivityResult> {
        a() {
        }

        /* renamed from: a */
        public ActivityResult createFromParcel(Parcel parcel) {
            return new ActivityResult(parcel);
        }

        /* renamed from: b */
        public ActivityResult[] newArray(int i10) {
            return new ActivityResult[i10];
        }
    }

    public ActivityResult(int i10, Intent intent) {
        this.f323a = i10;
        this.f324b = intent;
    }

    public static String c(int i10) {
        return i10 != -1 ? i10 != 0 ? String.valueOf(i10) : "RESULT_CANCELED" : "RESULT_OK";
    }

    public Intent a() {
        return this.f324b;
    }

    public int b() {
        return this.f323a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + c(this.f323a) + ", data=" + this.f324b + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f323a);
        parcel.writeInt(this.f324b == null ? 0 : 1);
        Intent intent = this.f324b;
        if (intent != null) {
            intent.writeToParcel(parcel, i10);
        }
    }

    ActivityResult(Parcel parcel) {
        this.f323a = parcel.readInt();
        this.f324b = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
