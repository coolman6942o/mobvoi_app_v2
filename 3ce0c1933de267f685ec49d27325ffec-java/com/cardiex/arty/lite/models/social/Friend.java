package com.cardiex.arty.lite.models.social;

import android.os.Parcel;
import android.os.Parcelable;
import com.cardiex.arty.lite.models.coach.Activity;
import com.cardiex.arty.lite.models.coach.ArtyScore;
import ia.a;
import java.util.Arrays;
import kotlin.jvm.internal.i;
import kotlinx.parcelize.Parcelize;
/* compiled from: Friend.kt */
@Parcelize
/* loaded from: classes.dex */
public final class Friend implements Parcelable {
    public static final Parcelable.Creator<Friend> CREATOR = new Creator();
    private ArtyScore artyScore;

    /* renamed from: id  reason: collision with root package name */
    private String f8203id;
    private String image;
    private boolean isSeen;
    private long lastActive;
    private String name;
    private Activity[] recentActivities;
    private String username;

    /* compiled from: Friend.kt */
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<Friend> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Friend createFromParcel(Parcel parcel) {
            i.f(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            long readLong = parcel.readLong();
            Activity[] activityArr = null;
            ArtyScore createFromParcel = parcel.readInt() == 0 ? null : ArtyScore.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                activityArr = new Activity[readInt];
                for (int i10 = 0; i10 != readInt; i10++) {
                    activityArr[i10] = Activity.CREATOR.createFromParcel(parcel);
                }
            }
            return new Friend(readString, readString2, readString3, readString4, readLong, createFromParcel, activityArr, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Friend[] newArray(int i10) {
            return new Friend[i10];
        }
    }

    public Friend(String str, String str2, String str3, String str4, long j10, ArtyScore artyScore, Activity[] activityArr, boolean z10) {
        this.f8203id = str;
        this.image = str2;
        this.name = str3;
        this.username = str4;
        this.lastActive = j10;
        this.artyScore = artyScore;
        this.recentActivities = activityArr;
        this.isSeen = z10;
    }

    public final String component1() {
        return this.f8203id;
    }

    public final String component2() {
        return this.image;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.username;
    }

    public final long component5() {
        return this.lastActive;
    }

    public final ArtyScore component6() {
        return this.artyScore;
    }

    public final Activity[] component7() {
        return this.recentActivities;
    }

    public final boolean component8() {
        return this.isSeen;
    }

    public final Friend copy(String str, String str2, String str3, String str4, long j10, ArtyScore artyScore, Activity[] activityArr, boolean z10) {
        return new Friend(str, str2, str3, str4, j10, artyScore, activityArr, z10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Friend)) {
            return false;
        }
        Friend friend = (Friend) obj;
        return i.b(this.f8203id, friend.f8203id) && i.b(this.image, friend.image) && i.b(this.name, friend.name) && i.b(this.username, friend.username) && this.lastActive == friend.lastActive && i.b(this.artyScore, friend.artyScore) && i.b(this.recentActivities, friend.recentActivities) && this.isSeen == friend.isSeen;
    }

    public final ArtyScore getArtyScore() {
        return this.artyScore;
    }

    public final String getId() {
        return this.f8203id;
    }

    public final String getImage() {
        return this.image;
    }

    public final long getLastActive() {
        return this.lastActive;
    }

    public final String getName() {
        return this.name;
    }

    public final Activity[] getRecentActivities() {
        return this.recentActivities;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        String str = this.f8203id;
        int i10 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.image;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.name;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.username;
        int hashCode4 = (((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + a.a(this.lastActive)) * 31;
        ArtyScore artyScore = this.artyScore;
        int hashCode5 = (hashCode4 + (artyScore == null ? 0 : artyScore.hashCode())) * 31;
        Activity[] activityArr = this.recentActivities;
        if (activityArr != null) {
            i10 = Arrays.hashCode(activityArr);
        }
        int i11 = (hashCode5 + i10) * 31;
        boolean z10 = this.isSeen;
        if (z10) {
            z10 = true;
        }
        int i12 = z10 ? 1 : 0;
        int i13 = z10 ? 1 : 0;
        return i11 + i12;
    }

    public final boolean isSeen() {
        return this.isSeen;
    }

    public final void setArtyScore(ArtyScore artyScore) {
        this.artyScore = artyScore;
    }

    public final void setId(String str) {
        this.f8203id = str;
    }

    public final void setImage(String str) {
        this.image = str;
    }

    public final void setLastActive(long j10) {
        this.lastActive = j10;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setRecentActivities(Activity[] activityArr) {
        this.recentActivities = activityArr;
    }

    public final void setSeen(boolean z10) {
        this.isSeen = z10;
    }

    public final void setUsername(String str) {
        this.username = str;
    }

    public String toString() {
        return "Friend(id=" + ((Object) this.f8203id) + ", image=" + ((Object) this.image) + ", name=" + ((Object) this.name) + ", username=" + ((Object) this.username) + ", lastActive=" + this.lastActive + ", artyScore=" + this.artyScore + ", recentActivities=" + Arrays.toString(this.recentActivities) + ", isSeen=" + this.isSeen + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i10) {
        i.f(out, "out");
        out.writeString(this.f8203id);
        out.writeString(this.image);
        out.writeString(this.name);
        out.writeString(this.username);
        out.writeLong(this.lastActive);
        ArtyScore artyScore = this.artyScore;
        if (artyScore == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            artyScore.writeToParcel(out, i10);
        }
        Activity[] activityArr = this.recentActivities;
        if (activityArr == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            int length = activityArr.length;
            out.writeInt(length);
            for (int i11 = 0; i11 != length; i11++) {
                activityArr[i11].writeToParcel(out, i10);
            }
        }
        out.writeInt(this.isSeen ? 1 : 0);
    }
}
