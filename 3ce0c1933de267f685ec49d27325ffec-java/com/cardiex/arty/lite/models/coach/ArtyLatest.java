package com.cardiex.arty.lite.models.coach;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.i;
import kotlinx.parcelize.Parcelize;
/* compiled from: ArtyLatest.kt */
@Parcelize
/* loaded from: classes.dex */
public final class ArtyLatest implements Parcelable {
    public static final Parcelable.Creator<ArtyLatest> CREATOR = new Creator();
    private ArtyComponent avgComponent;
    private ArtyComponent currentComponent;
    private ArtyComponent maxComponent;
    private ArtyComponent minComponent;
    private double percentile;

    /* compiled from: ArtyLatest.kt */
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<ArtyLatest> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ArtyLatest createFromParcel(Parcel parcel) {
            i.f(parcel, "parcel");
            ArtyComponent artyComponent = null;
            ArtyComponent createFromParcel = parcel.readInt() == 0 ? null : ArtyComponent.CREATOR.createFromParcel(parcel);
            ArtyComponent createFromParcel2 = parcel.readInt() == 0 ? null : ArtyComponent.CREATOR.createFromParcel(parcel);
            ArtyComponent createFromParcel3 = parcel.readInt() == 0 ? null : ArtyComponent.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                artyComponent = ArtyComponent.CREATOR.createFromParcel(parcel);
            }
            return new ArtyLatest(createFromParcel, createFromParcel2, createFromParcel3, artyComponent, parcel.readDouble());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ArtyLatest[] newArray(int i10) {
            return new ArtyLatest[i10];
        }
    }

    public ArtyLatest(ArtyComponent artyComponent, ArtyComponent artyComponent2, ArtyComponent artyComponent3, ArtyComponent artyComponent4, double d10) {
        this.currentComponent = artyComponent;
        this.avgComponent = artyComponent2;
        this.minComponent = artyComponent3;
        this.maxComponent = artyComponent4;
        this.percentile = d10;
    }

    public static /* synthetic */ ArtyLatest copy$default(ArtyLatest artyLatest, ArtyComponent artyComponent, ArtyComponent artyComponent2, ArtyComponent artyComponent3, ArtyComponent artyComponent4, double d10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            artyComponent = artyLatest.currentComponent;
        }
        if ((i10 & 2) != 0) {
            artyComponent2 = artyLatest.avgComponent;
        }
        ArtyComponent artyComponent5 = artyComponent2;
        if ((i10 & 4) != 0) {
            artyComponent3 = artyLatest.minComponent;
        }
        ArtyComponent artyComponent6 = artyComponent3;
        if ((i10 & 8) != 0) {
            artyComponent4 = artyLatest.maxComponent;
        }
        ArtyComponent artyComponent7 = artyComponent4;
        if ((i10 & 16) != 0) {
            d10 = artyLatest.percentile;
        }
        return artyLatest.copy(artyComponent, artyComponent5, artyComponent6, artyComponent7, d10);
    }

    public final ArtyComponent component1() {
        return this.currentComponent;
    }

    public final ArtyComponent component2() {
        return this.avgComponent;
    }

    public final ArtyComponent component3() {
        return this.minComponent;
    }

    public final ArtyComponent component4() {
        return this.maxComponent;
    }

    public final double component5() {
        return this.percentile;
    }

    public final ArtyLatest copy(ArtyComponent artyComponent, ArtyComponent artyComponent2, ArtyComponent artyComponent3, ArtyComponent artyComponent4, double d10) {
        return new ArtyLatest(artyComponent, artyComponent2, artyComponent3, artyComponent4, d10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ArtyLatest)) {
            return false;
        }
        ArtyLatest artyLatest = (ArtyLatest) obj;
        return i.b(this.currentComponent, artyLatest.currentComponent) && i.b(this.avgComponent, artyLatest.avgComponent) && i.b(this.minComponent, artyLatest.minComponent) && i.b(this.maxComponent, artyLatest.maxComponent) && i.b(Double.valueOf(this.percentile), Double.valueOf(artyLatest.percentile));
    }

    public final ArtyComponent getAvgComponent() {
        return this.avgComponent;
    }

    public final ArtyComponent getCurrentComponent() {
        return this.currentComponent;
    }

    public final ArtyComponent getMaxComponent() {
        return this.maxComponent;
    }

    public final ArtyComponent getMinComponent() {
        return this.minComponent;
    }

    public final double getPercentile() {
        return this.percentile;
    }

    public int hashCode() {
        ArtyComponent artyComponent = this.currentComponent;
        int i10 = 0;
        int hashCode = (artyComponent == null ? 0 : artyComponent.hashCode()) * 31;
        ArtyComponent artyComponent2 = this.avgComponent;
        int hashCode2 = (hashCode + (artyComponent2 == null ? 0 : artyComponent2.hashCode())) * 31;
        ArtyComponent artyComponent3 = this.minComponent;
        int hashCode3 = (hashCode2 + (artyComponent3 == null ? 0 : artyComponent3.hashCode())) * 31;
        ArtyComponent artyComponent4 = this.maxComponent;
        if (artyComponent4 != null) {
            i10 = artyComponent4.hashCode();
        }
        return ((hashCode3 + i10) * 31) + Double.doubleToLongBits(this.percentile);
    }

    public final void setAvgComponent(ArtyComponent artyComponent) {
        this.avgComponent = artyComponent;
    }

    public final void setCurrentComponent(ArtyComponent artyComponent) {
        this.currentComponent = artyComponent;
    }

    public final void setMaxComponent(ArtyComponent artyComponent) {
        this.maxComponent = artyComponent;
    }

    public final void setMinComponent(ArtyComponent artyComponent) {
        this.minComponent = artyComponent;
    }

    public final void setPercentile(double d10) {
        this.percentile = d10;
    }

    public String toString() {
        return "ArtyLatest(currentComponent=" + this.currentComponent + ", avgComponent=" + this.avgComponent + ", minComponent=" + this.minComponent + ", maxComponent=" + this.maxComponent + ", percentile=" + this.percentile + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i10) {
        i.f(out, "out");
        ArtyComponent artyComponent = this.currentComponent;
        if (artyComponent == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            artyComponent.writeToParcel(out, i10);
        }
        ArtyComponent artyComponent2 = this.avgComponent;
        if (artyComponent2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            artyComponent2.writeToParcel(out, i10);
        }
        ArtyComponent artyComponent3 = this.minComponent;
        if (artyComponent3 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            artyComponent3.writeToParcel(out, i10);
        }
        ArtyComponent artyComponent4 = this.maxComponent;
        if (artyComponent4 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            artyComponent4.writeToParcel(out, i10);
        }
        out.writeDouble(this.percentile);
    }
}
