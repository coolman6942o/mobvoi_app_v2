package com.cardiex.arty.lite.models.social;

import android.os.Parcel;
import android.os.Parcelable;
import ia.a;
import kotlin.jvm.internal.i;
import kotlinx.parcelize.Parcelize;
/* compiled from: Badge.kt */
@Parcelize
/* loaded from: classes.dex */
public final class Badge implements Parcelable {
    public static final Parcelable.Creator<Badge> CREATOR = new Creator();
    private String category;

    /* renamed from: id  reason: collision with root package name */
    private String f8202id;
    private boolean isEarned;
    private boolean isSeen;
    private String name;
    private int position;
    private long timestamp;

    /* compiled from: Badge.kt */
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<Badge> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Badge createFromParcel(Parcel parcel) {
            i.f(parcel, "parcel");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            boolean z10 = false;
            boolean z11 = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                z10 = true;
            }
            return new Badge(readString, readInt, readString2, readString3, z11, z10, parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Badge[] newArray(int i10) {
            return new Badge[i10];
        }
    }

    public Badge(String str, int i10, String str2, String str3, boolean z10, boolean z11, long j10) {
        this.f8202id = str;
        this.position = i10;
        this.category = str2;
        this.name = str3;
        this.isEarned = z10;
        this.isSeen = z11;
        this.timestamp = j10;
    }

    public final String component1() {
        return this.f8202id;
    }

    public final int component2() {
        return this.position;
    }

    public final String component3() {
        return this.category;
    }

    public final String component4() {
        return this.name;
    }

    public final boolean component5() {
        return this.isEarned;
    }

    public final boolean component6() {
        return this.isSeen;
    }

    public final long component7() {
        return this.timestamp;
    }

    public final Badge copy(String str, int i10, String str2, String str3, boolean z10, boolean z11, long j10) {
        return new Badge(str, i10, str2, str3, z10, z11, j10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Badge)) {
            return false;
        }
        Badge badge = (Badge) obj;
        return i.b(this.f8202id, badge.f8202id) && this.position == badge.position && i.b(this.category, badge.category) && i.b(this.name, badge.name) && this.isEarned == badge.isEarned && this.isSeen == badge.isSeen && this.timestamp == badge.timestamp;
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getId() {
        return this.f8202id;
    }

    public final String getName() {
        return this.name;
    }

    public final int getPosition() {
        return this.position;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        String str = this.f8202id;
        int i10 = 0;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.position) * 31;
        String str2 = this.category;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.name;
        if (str3 != null) {
            i10 = str3.hashCode();
        }
        int i11 = (hashCode2 + i10) * 31;
        boolean z10 = this.isEarned;
        int i12 = 1;
        if (z10) {
            z10 = true;
        }
        int i13 = z10 ? 1 : 0;
        int i14 = z10 ? 1 : 0;
        int i15 = (i11 + i13) * 31;
        boolean z11 = this.isSeen;
        if (!z11) {
            i12 = z11 ? 1 : 0;
        }
        return ((i15 + i12) * 31) + a.a(this.timestamp);
    }

    public final boolean isEarned() {
        return this.isEarned;
    }

    public final boolean isSeen() {
        return this.isSeen;
    }

    public final void setCategory(String str) {
        this.category = str;
    }

    public final void setEarned(boolean z10) {
        this.isEarned = z10;
    }

    public final void setId(String str) {
        this.f8202id = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setPosition(int i10) {
        this.position = i10;
    }

    public final void setSeen(boolean z10) {
        this.isSeen = z10;
    }

    public final void setTimestamp(long j10) {
        this.timestamp = j10;
    }

    public String toString() {
        return "Badge(id=" + ((Object) this.f8202id) + ", position=" + this.position + ", category=" + ((Object) this.category) + ", name=" + ((Object) this.name) + ", isEarned=" + this.isEarned + ", isSeen=" + this.isSeen + ", timestamp=" + this.timestamp + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i10) {
        i.f(out, "out");
        out.writeString(this.f8202id);
        out.writeInt(this.position);
        out.writeString(this.category);
        out.writeString(this.name);
        out.writeInt(this.isEarned ? 1 : 0);
        out.writeInt(this.isSeen ? 1 : 0);
        out.writeLong(this.timestamp);
    }
}
