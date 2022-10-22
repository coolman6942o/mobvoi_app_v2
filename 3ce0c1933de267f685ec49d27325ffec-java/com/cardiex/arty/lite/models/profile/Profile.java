package com.cardiex.arty.lite.models.profile;

import android.os.Parcel;
import android.os.Parcelable;
import eq.a;
import h8.b;
import java.util.Date;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlinx.parcelize.Parcelize;
/* compiled from: Profile.kt */
@Parcelize
/* loaded from: classes.dex */
public final class Profile implements Parcelable {
    public static final Parcelable.Creator<Profile> CREATOR = new Creator();
    @b(a.class)
    private Date dateOfBirth;
    private Gender gender;
    private float height;
    private boolean isHeightMetric;
    private boolean isWeightMetric;
    private String name;
    private float weight;

    /* compiled from: Profile.kt */
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<Profile> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Profile createFromParcel(Parcel parcel) {
            i.f(parcel, "parcel");
            return new Profile(parcel.readString(), (Date) parcel.readSerializable(), parcel.readFloat(), parcel.readInt() != 0, parcel.readFloat(), parcel.readInt() != 0, Gender.valueOf(parcel.readString()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Profile[] newArray(int i10) {
            return new Profile[i10];
        }
    }

    public Profile(String name, Date dateOfBirth, float f10, boolean z10, float f11, boolean z11, Gender gender) {
        i.f(name, "name");
        i.f(dateOfBirth, "dateOfBirth");
        i.f(gender, "gender");
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.weight = f10;
        this.isWeightMetric = z10;
        this.height = f11;
        this.isHeightMetric = z11;
        this.gender = gender;
    }

    public static /* synthetic */ Profile copy$default(Profile profile, String str, Date date, float f10, boolean z10, float f11, boolean z11, Gender gender, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = profile.name;
        }
        if ((i10 & 2) != 0) {
            date = profile.dateOfBirth;
        }
        Date date2 = date;
        if ((i10 & 4) != 0) {
            f10 = profile.weight;
        }
        float f12 = f10;
        if ((i10 & 8) != 0) {
            z10 = profile.isWeightMetric;
        }
        boolean z12 = z10;
        if ((i10 & 16) != 0) {
            f11 = profile.height;
        }
        float f13 = f11;
        if ((i10 & 32) != 0) {
            z11 = profile.isHeightMetric;
        }
        boolean z13 = z11;
        if ((i10 & 64) != 0) {
            gender = profile.gender;
        }
        return profile.copy(str, date2, f12, z12, f13, z13, gender);
    }

    public final String component1() {
        return this.name;
    }

    public final Date component2() {
        return this.dateOfBirth;
    }

    public final float component3() {
        return this.weight;
    }

    public final boolean component4() {
        return this.isWeightMetric;
    }

    public final float component5() {
        return this.height;
    }

    public final boolean component6() {
        return this.isHeightMetric;
    }

    public final Gender component7() {
        return this.gender;
    }

    public final Profile copy(String name, Date dateOfBirth, float f10, boolean z10, float f11, boolean z11, Gender gender) {
        i.f(name, "name");
        i.f(dateOfBirth, "dateOfBirth");
        i.f(gender, "gender");
        return new Profile(name, dateOfBirth, f10, z10, f11, z11, gender);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Profile)) {
            return false;
        }
        Profile profile = (Profile) obj;
        return i.b(this.name, profile.name) && i.b(this.dateOfBirth, profile.dateOfBirth) && i.b(Float.valueOf(this.weight), Float.valueOf(profile.weight)) && this.isWeightMetric == profile.isWeightMetric && i.b(Float.valueOf(this.height), Float.valueOf(profile.height)) && this.isHeightMetric == profile.isHeightMetric && this.gender == profile.gender;
    }

    public final Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public final Gender getGender() {
        return this.gender;
    }

    public final float getHeight() {
        return this.height;
    }

    public final String getName() {
        return this.name;
    }

    public final float getWeight() {
        return this.weight;
    }

    public int hashCode() {
        int hashCode = ((((this.name.hashCode() * 31) + this.dateOfBirth.hashCode()) * 31) + Float.floatToIntBits(this.weight)) * 31;
        boolean z10 = this.isWeightMetric;
        int i10 = 1;
        if (z10) {
            z10 = true;
        }
        int i11 = z10 ? 1 : 0;
        int i12 = z10 ? 1 : 0;
        int floatToIntBits = (((hashCode + i11) * 31) + Float.floatToIntBits(this.height)) * 31;
        boolean z11 = this.isHeightMetric;
        if (!z11) {
            i10 = z11 ? 1 : 0;
        }
        return ((floatToIntBits + i10) * 31) + this.gender.hashCode();
    }

    public final boolean isHeightMetric() {
        return this.isHeightMetric;
    }

    public final boolean isWeightMetric() {
        return this.isWeightMetric;
    }

    public final void setDateOfBirth(Date date) {
        i.f(date, "<set-?>");
        this.dateOfBirth = date;
    }

    public final void setGender(Gender gender) {
        i.f(gender, "<set-?>");
        this.gender = gender;
    }

    public final void setHeight(float f10) {
        this.height = f10;
    }

    public final void setHeightMetric(boolean z10) {
        this.isHeightMetric = z10;
    }

    public final void setName(String str) {
        i.f(str, "<set-?>");
        this.name = str;
    }

    public final void setWeight(float f10) {
        this.weight = f10;
    }

    public final void setWeightMetric(boolean z10) {
        this.isWeightMetric = z10;
    }

    public String toString() {
        return "Profile(name=" + this.name + ", dateOfBirth=" + this.dateOfBirth + ", weight=" + this.weight + ", isWeightMetric=" + this.isWeightMetric + ", height=" + this.height + ", isHeightMetric=" + this.isHeightMetric + ", gender=" + this.gender + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i10) {
        i.f(out, "out");
        out.writeString(this.name);
        out.writeSerializable(this.dateOfBirth);
        out.writeFloat(this.weight);
        out.writeInt(this.isWeightMetric ? 1 : 0);
        out.writeFloat(this.height);
        out.writeInt(this.isHeightMetric ? 1 : 0);
        out.writeString(this.gender.name());
    }

    public /* synthetic */ Profile(String str, Date date, float f10, boolean z10, float f11, boolean z11, Gender gender, int i10, f fVar) {
        this(str, date, f10, (i10 & 8) != 0 ? false : z10, f11, (i10 & 32) != 0 ? false : z11, gender);
    }
}
