package com.cardiex.arty.lite.models.coach;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import kotlin.jvm.internal.i;
import kotlinx.parcelize.Parcelize;
/* compiled from: ArtyTrend.kt */
@Parcelize
/* loaded from: classes.dex */
public final class ArtyTrend implements Parcelable {
    public static final Parcelable.Creator<ArtyTrend> CREATOR = new Creator();
    private ArtyComponent[] allReadings;
    private ArtyGraph graph;

    /* compiled from: ArtyTrend.kt */
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<ArtyTrend> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ArtyTrend createFromParcel(Parcel parcel) {
            i.f(parcel, "parcel");
            ArtyComponent[] artyComponentArr = null;
            ArtyGraph createFromParcel = parcel.readInt() == 0 ? null : ArtyGraph.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                ArtyComponent[] artyComponentArr2 = new ArtyComponent[readInt];
                for (int i10 = 0; i10 != readInt; i10++) {
                    artyComponentArr2[i10] = ArtyComponent.CREATOR.createFromParcel(parcel);
                }
                artyComponentArr = artyComponentArr2;
            }
            return new ArtyTrend(createFromParcel, artyComponentArr);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ArtyTrend[] newArray(int i10) {
            return new ArtyTrend[i10];
        }
    }

    public ArtyTrend(ArtyGraph artyGraph, ArtyComponent[] artyComponentArr) {
        this.graph = artyGraph;
        this.allReadings = artyComponentArr;
    }

    public static /* synthetic */ ArtyTrend copy$default(ArtyTrend artyTrend, ArtyGraph artyGraph, ArtyComponent[] artyComponentArr, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            artyGraph = artyTrend.graph;
        }
        if ((i10 & 2) != 0) {
            artyComponentArr = artyTrend.allReadings;
        }
        return artyTrend.copy(artyGraph, artyComponentArr);
    }

    public final ArtyGraph component1() {
        return this.graph;
    }

    public final ArtyComponent[] component2() {
        return this.allReadings;
    }

    public final ArtyTrend copy(ArtyGraph artyGraph, ArtyComponent[] artyComponentArr) {
        return new ArtyTrend(artyGraph, artyComponentArr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ArtyTrend)) {
            return false;
        }
        ArtyTrend artyTrend = (ArtyTrend) obj;
        return i.b(this.graph, artyTrend.graph) && i.b(this.allReadings, artyTrend.allReadings);
    }

    public final ArtyComponent[] getAllReadings() {
        return this.allReadings;
    }

    public final ArtyGraph getGraph() {
        return this.graph;
    }

    public int hashCode() {
        ArtyGraph artyGraph = this.graph;
        int i10 = 0;
        int hashCode = (artyGraph == null ? 0 : artyGraph.hashCode()) * 31;
        ArtyComponent[] artyComponentArr = this.allReadings;
        if (artyComponentArr != null) {
            i10 = Arrays.hashCode(artyComponentArr);
        }
        return hashCode + i10;
    }

    public final void setAllReadings(ArtyComponent[] artyComponentArr) {
        this.allReadings = artyComponentArr;
    }

    public final void setGraph(ArtyGraph artyGraph) {
        this.graph = artyGraph;
    }

    public String toString() {
        return "ArtyTrend(graph=" + this.graph + ", allReadings=" + Arrays.toString(this.allReadings) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i10) {
        i.f(out, "out");
        ArtyGraph artyGraph = this.graph;
        if (artyGraph == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            artyGraph.writeToParcel(out, i10);
        }
        ArtyComponent[] artyComponentArr = this.allReadings;
        if (artyComponentArr == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        int length = artyComponentArr.length;
        out.writeInt(length);
        for (int i11 = 0; i11 != length; i11++) {
            artyComponentArr[i11].writeToParcel(out, i10);
        }
    }
}
