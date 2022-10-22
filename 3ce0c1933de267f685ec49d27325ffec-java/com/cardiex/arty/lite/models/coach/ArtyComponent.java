package com.cardiex.arty.lite.models.coach;

import android.os.Parcel;
import android.os.Parcelable;
import ia.a;
import kotlin.jvm.internal.i;
import kotlinx.parcelize.Parcelize;
/* compiled from: ArtyComponent.kt */
@Parcelize
/* loaded from: classes.dex */
public final class ArtyComponent implements Parcelable {
    public static final Parcelable.Creator<ArtyComponent> CREATOR = new Creator();
    private ScoreType aggregateType;
    private ArtyType artyType;
    private Duration duration;
    private double spread;
    private long timestamp;
    private double value;

    /* compiled from: ArtyComponent.kt */
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<ArtyComponent> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ArtyComponent createFromParcel(Parcel parcel) {
            i.f(parcel, "parcel");
            return new ArtyComponent(parcel.readLong(), parcel.readInt() == 0 ? null : ArtyType.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : ScoreType.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : Duration.valueOf(parcel.readString()), parcel.readDouble(), parcel.readDouble());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ArtyComponent[] newArray(int i10) {
            return new ArtyComponent[i10];
        }
    }

    public ArtyComponent(long j10, ArtyType artyType, ScoreType scoreType, Duration duration, double d10, double d11) {
        this.timestamp = j10;
        this.artyType = artyType;
        this.aggregateType = scoreType;
        this.duration = duration;
        this.value = d10;
        this.spread = d11;
    }

    public final long component1() {
        return this.timestamp;
    }

    public final ArtyType component2() {
        return this.artyType;
    }

    public final ScoreType component3() {
        return this.aggregateType;
    }

    public final Duration component4() {
        return this.duration;
    }

    public final double component5() {
        return this.value;
    }

    public final double component6() {
        return this.spread;
    }

    public final ArtyComponent copy(long j10, ArtyType artyType, ScoreType scoreType, Duration duration, double d10, double d11) {
        return new ArtyComponent(j10, artyType, scoreType, duration, d10, d11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ArtyComponent)) {
            return false;
        }
        ArtyComponent artyComponent = (ArtyComponent) obj;
        return this.timestamp == artyComponent.timestamp && this.artyType == artyComponent.artyType && this.aggregateType == artyComponent.aggregateType && this.duration == artyComponent.duration && i.b(Double.valueOf(this.value), Double.valueOf(artyComponent.value)) && i.b(Double.valueOf(this.spread), Double.valueOf(artyComponent.spread));
    }

    public final ScoreType getAggregateType() {
        return this.aggregateType;
    }

    public final ArtyType getArtyType() {
        return this.artyType;
    }

    public final Duration getDuration() {
        return this.duration;
    }

    public final double getSpread() {
        return this.spread;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final double getValue() {
        return this.value;
    }

    public int hashCode() {
        int a10 = a.a(this.timestamp) * 31;
        ArtyType artyType = this.artyType;
        int i10 = 0;
        int hashCode = (a10 + (artyType == null ? 0 : artyType.hashCode())) * 31;
        ScoreType scoreType = this.aggregateType;
        int hashCode2 = (hashCode + (scoreType == null ? 0 : scoreType.hashCode())) * 31;
        Duration duration = this.duration;
        if (duration != null) {
            i10 = duration.hashCode();
        }
        return ((((hashCode2 + i10) * 31) + Double.doubleToLongBits(this.value)) * 31) + Double.doubleToLongBits(this.spread);
    }

    public final void setAggregateType(ScoreType scoreType) {
        this.aggregateType = scoreType;
    }

    public final void setArtyType(ArtyType artyType) {
        this.artyType = artyType;
    }

    public final void setDuration(Duration duration) {
        this.duration = duration;
    }

    public final void setSpread(double d10) {
        this.spread = d10;
    }

    public final void setTimestamp(long j10) {
        this.timestamp = j10;
    }

    public final void setValue(double d10) {
        this.value = d10;
    }

    public String toString() {
        return "ArtyComponent(timestamp=" + this.timestamp + ", artyType=" + this.artyType + ", aggregateType=" + this.aggregateType + ", duration=" + this.duration + ", value=" + this.value + ", spread=" + this.spread + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i10) {
        i.f(out, "out");
        out.writeLong(this.timestamp);
        ArtyType artyType = this.artyType;
        if (artyType == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeString(artyType.name());
        }
        ScoreType scoreType = this.aggregateType;
        if (scoreType == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeString(scoreType.name());
        }
        Duration duration = this.duration;
        if (duration == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeString(duration.name());
        }
        out.writeDouble(this.value);
        out.writeDouble(this.spread);
    }
}
