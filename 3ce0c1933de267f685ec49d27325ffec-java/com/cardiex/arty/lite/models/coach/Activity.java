package com.cardiex.arty.lite.models.coach;

import android.os.Parcel;
import android.os.Parcelable;
import ia.a;
import kotlin.jvm.internal.i;
import kotlinx.parcelize.Parcelize;
/* compiled from: Activity.kt */
@Parcelize
/* loaded from: classes.dex */
public final class Activity implements Parcelable {
    public static final Parcelable.Creator<Activity> CREATOR = new Creator();

    /* renamed from: id  reason: collision with root package name */
    private String f8197id;
    private String name;
    private long timestamp;

    /* compiled from: Activity.kt */
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<Activity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Activity createFromParcel(Parcel parcel) {
            i.f(parcel, "parcel");
            return new Activity(parcel.readString(), parcel.readLong(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Activity[] newArray(int i10) {
            return new Activity[i10];
        }
    }

    public Activity(String str, long j10, String str2) {
        this.f8197id = str;
        this.timestamp = j10;
        this.name = str2;
    }

    public static /* synthetic */ Activity copy$default(Activity activity, String str, long j10, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = activity.f8197id;
        }
        if ((i10 & 2) != 0) {
            j10 = activity.timestamp;
        }
        if ((i10 & 4) != 0) {
            str2 = activity.name;
        }
        return activity.copy(str, j10, str2);
    }

    public final String component1() {
        return this.f8197id;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final String component3() {
        return this.name;
    }

    public final Activity copy(String str, long j10, String str2) {
        return new Activity(str, j10, str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) obj;
        return i.b(this.f8197id, activity.f8197id) && this.timestamp == activity.timestamp && i.b(this.name, activity.name);
    }

    public final String getId() {
        return this.f8197id;
    }

    public final String getName() {
        return this.name;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        String str = this.f8197id;
        int i10 = 0;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + a.a(this.timestamp)) * 31;
        String str2 = this.name;
        if (str2 != null) {
            i10 = str2.hashCode();
        }
        return hashCode + i10;
    }

    public final void setId(String str) {
        this.f8197id = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setTimestamp(long j10) {
        this.timestamp = j10;
    }

    public String toString() {
        return "Activity(id=" + ((Object) this.f8197id) + ", timestamp=" + this.timestamp + ", name=" + ((Object) this.name) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i10) {
        i.f(out, "out");
        out.writeString(this.f8197id);
        out.writeLong(this.timestamp);
        out.writeString(this.name);
    }
}
