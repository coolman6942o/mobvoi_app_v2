package com.cardiex.arty.lite.models.coach;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlinx.parcelize.Parcelize;
/* compiled from: ArtyGraph.kt */
@Parcelize
/* loaded from: classes.dex */
public final class ArtyGraph implements Parcelable {
    public static final Parcelable.Creator<ArtyGraph> CREATOR = new Creator();
    private ArtyType artyType;
    private List<ArtyComponent> data;
    private GraphMode mode;

    /* compiled from: ArtyGraph.kt */
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<ArtyGraph> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ArtyGraph createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            i.f(parcel, "parcel");
            GraphMode valueOf = GraphMode.valueOf(parcel.readString());
            ArtyType valueOf2 = ArtyType.valueOf(parcel.readString());
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList2.add(ArtyComponent.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new ArtyGraph(valueOf, valueOf2, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ArtyGraph[] newArray(int i10) {
            return new ArtyGraph[i10];
        }
    }

    public ArtyGraph() {
        this(null, null, null, 7, null);
    }

    public ArtyGraph(GraphMode mode, ArtyType artyType, List<ArtyComponent> list) {
        i.f(mode, "mode");
        i.f(artyType, "artyType");
        this.mode = mode;
        this.artyType = artyType;
        this.data = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ArtyGraph copy$default(ArtyGraph artyGraph, GraphMode graphMode, ArtyType artyType, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            graphMode = artyGraph.mode;
        }
        if ((i10 & 2) != 0) {
            artyType = artyGraph.artyType;
        }
        if ((i10 & 4) != 0) {
            list = artyGraph.data;
        }
        return artyGraph.copy(graphMode, artyType, list);
    }

    public final GraphMode component1() {
        return this.mode;
    }

    public final ArtyType component2() {
        return this.artyType;
    }

    public final List<ArtyComponent> component3() {
        return this.data;
    }

    public final ArtyGraph copy(GraphMode mode, ArtyType artyType, List<ArtyComponent> list) {
        i.f(mode, "mode");
        i.f(artyType, "artyType");
        return new ArtyGraph(mode, artyType, list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ArtyGraph)) {
            return false;
        }
        ArtyGraph artyGraph = (ArtyGraph) obj;
        return this.mode == artyGraph.mode && this.artyType == artyGraph.artyType && i.b(this.data, artyGraph.data);
    }

    public final ArtyType getArtyType() {
        return this.artyType;
    }

    public final List<ArtyComponent> getData() {
        return this.data;
    }

    public final GraphMode getMode() {
        return this.mode;
    }

    public int hashCode() {
        int hashCode = ((this.mode.hashCode() * 31) + this.artyType.hashCode()) * 31;
        List<ArtyComponent> list = this.data;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    public final void setArtyType(ArtyType artyType) {
        i.f(artyType, "<set-?>");
        this.artyType = artyType;
    }

    public final void setData(List<ArtyComponent> list) {
        this.data = list;
    }

    public final void setMode(GraphMode graphMode) {
        i.f(graphMode, "<set-?>");
        this.mode = graphMode;
    }

    public String toString() {
        return "ArtyGraph(mode=" + this.mode + ", artyType=" + this.artyType + ", data=" + this.data + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i10) {
        i.f(out, "out");
        out.writeString(this.mode.name());
        out.writeString(this.artyType.name());
        List<ArtyComponent> list = this.data;
        if (list == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        out.writeInt(list.size());
        for (ArtyComponent artyComponent : list) {
            artyComponent.writeToParcel(out, i10);
        }
    }

    public /* synthetic */ ArtyGraph(GraphMode graphMode, ArtyType artyType, List list, int i10, f fVar) {
        this((i10 & 1) != 0 ? GraphMode.BAR : graphMode, (i10 & 2) != 0 ? ArtyType.ARTY : artyType, (i10 & 4) != 0 ? null : list);
    }
}
