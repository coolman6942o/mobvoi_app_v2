package com.cardiex.arty.lite.models.coach;

import android.os.Parcel;
import android.os.Parcelable;
import ia.a;
import kotlin.jvm.internal.i;
import kotlinx.parcelize.Parcelize;
/* compiled from: ArtyScore.kt */
@Parcelize
/* loaded from: classes.dex */
public final class ArtyScore implements Parcelable {
    public static final Parcelable.Creator<ArtyScore> CREATOR = new Creator();
    private ArtyComponent age;
    private double ageChange;
    private ArtyComponent arty;
    private double artyChange;
    private ArtyComponent eCap;
    private double eCapChange;
    private ArtyComponent hsx;
    private double hsxChange;
    private long timestamp;
    private ArtyComponent truHr;
    private double truHrChange;

    /* compiled from: ArtyScore.kt */
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<ArtyScore> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ArtyScore createFromParcel(Parcel parcel) {
            i.f(parcel, "parcel");
            long readLong = parcel.readLong();
            ArtyComponent artyComponent = null;
            ArtyComponent createFromParcel = parcel.readInt() == 0 ? null : ArtyComponent.CREATOR.createFromParcel(parcel);
            ArtyComponent createFromParcel2 = parcel.readInt() == 0 ? null : ArtyComponent.CREATOR.createFromParcel(parcel);
            ArtyComponent createFromParcel3 = parcel.readInt() == 0 ? null : ArtyComponent.CREATOR.createFromParcel(parcel);
            ArtyComponent createFromParcel4 = parcel.readInt() == 0 ? null : ArtyComponent.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                artyComponent = ArtyComponent.CREATOR.createFromParcel(parcel);
            }
            return new ArtyScore(readLong, createFromParcel, createFromParcel2, createFromParcel3, createFromParcel4, artyComponent, parcel.readDouble(), parcel.readDouble(), parcel.readDouble(), parcel.readDouble(), parcel.readDouble());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ArtyScore[] newArray(int i10) {
            return new ArtyScore[i10];
        }
    }

    public ArtyScore(long j10, ArtyComponent artyComponent, ArtyComponent artyComponent2, ArtyComponent artyComponent3, ArtyComponent artyComponent4, ArtyComponent artyComponent5, double d10, double d11, double d12, double d13, double d14) {
        this.timestamp = j10;
        this.arty = artyComponent;
        this.truHr = artyComponent2;
        this.eCap = artyComponent3;
        this.hsx = artyComponent4;
        this.age = artyComponent5;
        this.artyChange = d10;
        this.truHrChange = d11;
        this.eCapChange = d12;
        this.hsxChange = d13;
        this.ageChange = d14;
    }

    public final long component1() {
        return this.timestamp;
    }

    public final double component10() {
        return this.hsxChange;
    }

    public final double component11() {
        return this.ageChange;
    }

    public final ArtyComponent component2() {
        return this.arty;
    }

    public final ArtyComponent component3() {
        return this.truHr;
    }

    public final ArtyComponent component4() {
        return this.eCap;
    }

    public final ArtyComponent component5() {
        return this.hsx;
    }

    public final ArtyComponent component6() {
        return this.age;
    }

    public final double component7() {
        return this.artyChange;
    }

    public final double component8() {
        return this.truHrChange;
    }

    public final double component9() {
        return this.eCapChange;
    }

    public final ArtyScore copy(long j10, ArtyComponent artyComponent, ArtyComponent artyComponent2, ArtyComponent artyComponent3, ArtyComponent artyComponent4, ArtyComponent artyComponent5, double d10, double d11, double d12, double d13, double d14) {
        return new ArtyScore(j10, artyComponent, artyComponent2, artyComponent3, artyComponent4, artyComponent5, d10, d11, d12, d13, d14);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ArtyScore)) {
            return false;
        }
        ArtyScore artyScore = (ArtyScore) obj;
        return this.timestamp == artyScore.timestamp && i.b(this.arty, artyScore.arty) && i.b(this.truHr, artyScore.truHr) && i.b(this.eCap, artyScore.eCap) && i.b(this.hsx, artyScore.hsx) && i.b(this.age, artyScore.age) && i.b(Double.valueOf(this.artyChange), Double.valueOf(artyScore.artyChange)) && i.b(Double.valueOf(this.truHrChange), Double.valueOf(artyScore.truHrChange)) && i.b(Double.valueOf(this.eCapChange), Double.valueOf(artyScore.eCapChange)) && i.b(Double.valueOf(this.hsxChange), Double.valueOf(artyScore.hsxChange)) && i.b(Double.valueOf(this.ageChange), Double.valueOf(artyScore.ageChange));
    }

    public final ArtyComponent getAge() {
        return this.age;
    }

    public final double getAgeChange() {
        return this.ageChange;
    }

    public final ArtyComponent getArty() {
        return this.arty;
    }

    public final double getArtyChange() {
        return this.artyChange;
    }

    public final ArtyComponent getECap() {
        return this.eCap;
    }

    public final double getECapChange() {
        return this.eCapChange;
    }

    public final ArtyComponent getHsx() {
        return this.hsx;
    }

    public final double getHsxChange() {
        return this.hsxChange;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final ArtyComponent getTruHr() {
        return this.truHr;
    }

    public final double getTruHrChange() {
        return this.truHrChange;
    }

    public int hashCode() {
        int a10 = a.a(this.timestamp) * 31;
        ArtyComponent artyComponent = this.arty;
        int i10 = 0;
        int hashCode = (a10 + (artyComponent == null ? 0 : artyComponent.hashCode())) * 31;
        ArtyComponent artyComponent2 = this.truHr;
        int hashCode2 = (hashCode + (artyComponent2 == null ? 0 : artyComponent2.hashCode())) * 31;
        ArtyComponent artyComponent3 = this.eCap;
        int hashCode3 = (hashCode2 + (artyComponent3 == null ? 0 : artyComponent3.hashCode())) * 31;
        ArtyComponent artyComponent4 = this.hsx;
        int hashCode4 = (hashCode3 + (artyComponent4 == null ? 0 : artyComponent4.hashCode())) * 31;
        ArtyComponent artyComponent5 = this.age;
        if (artyComponent5 != null) {
            i10 = artyComponent5.hashCode();
        }
        return ((((((((((hashCode4 + i10) * 31) + Double.doubleToLongBits(this.artyChange)) * 31) + Double.doubleToLongBits(this.truHrChange)) * 31) + Double.doubleToLongBits(this.eCapChange)) * 31) + Double.doubleToLongBits(this.hsxChange)) * 31) + Double.doubleToLongBits(this.ageChange);
    }

    public final void setAge(ArtyComponent artyComponent) {
        this.age = artyComponent;
    }

    public final void setAgeChange(double d10) {
        this.ageChange = d10;
    }

    public final void setArty(ArtyComponent artyComponent) {
        this.arty = artyComponent;
    }

    public final void setArtyChange(double d10) {
        this.artyChange = d10;
    }

    public final void setECap(ArtyComponent artyComponent) {
        this.eCap = artyComponent;
    }

    public final void setECapChange(double d10) {
        this.eCapChange = d10;
    }

    public final void setHsx(ArtyComponent artyComponent) {
        this.hsx = artyComponent;
    }

    public final void setHsxChange(double d10) {
        this.hsxChange = d10;
    }

    public final void setTimestamp(long j10) {
        this.timestamp = j10;
    }

    public final void setTruHr(ArtyComponent artyComponent) {
        this.truHr = artyComponent;
    }

    public final void setTruHrChange(double d10) {
        this.truHrChange = d10;
    }

    public String toString() {
        return "ArtyScore(timestamp=" + this.timestamp + ", arty=" + this.arty + ", truHr=" + this.truHr + ", eCap=" + this.eCap + ", hsx=" + this.hsx + ", age=" + this.age + ", artyChange=" + this.artyChange + ", truHrChange=" + this.truHrChange + ", eCapChange=" + this.eCapChange + ", hsxChange=" + this.hsxChange + ", ageChange=" + this.ageChange + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i10) {
        i.f(out, "out");
        out.writeLong(this.timestamp);
        ArtyComponent artyComponent = this.arty;
        if (artyComponent == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            artyComponent.writeToParcel(out, i10);
        }
        ArtyComponent artyComponent2 = this.truHr;
        if (artyComponent2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            artyComponent2.writeToParcel(out, i10);
        }
        ArtyComponent artyComponent3 = this.eCap;
        if (artyComponent3 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            artyComponent3.writeToParcel(out, i10);
        }
        ArtyComponent artyComponent4 = this.hsx;
        if (artyComponent4 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            artyComponent4.writeToParcel(out, i10);
        }
        ArtyComponent artyComponent5 = this.age;
        if (artyComponent5 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            artyComponent5.writeToParcel(out, i10);
        }
        out.writeDouble(this.artyChange);
        out.writeDouble(this.truHrChange);
        out.writeDouble(this.eCapChange);
        out.writeDouble(this.hsxChange);
        out.writeDouble(this.ageChange);
    }
}
