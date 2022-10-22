package com.cardiex.arty.lite.models.coach;

import android.os.Parcel;
import android.os.Parcelable;
import ia.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlinx.parcelize.Parcelize;
/* compiled from: Advice.kt */
@Parcelize
/* loaded from: classes.dex */
public final class Advice implements Parcelable {
    public static final Parcelable.Creator<Advice> CREATOR = new Creator();
    private ArtyComponent artyComponent;
    private ArtyGraph artyGraph;
    private ArtyScore artyScore;
    private List<Content> details;

    /* renamed from: id  reason: collision with root package name */
    private String f8198id;
    private boolean isSeen;
    private Content primary;
    private Content secondary;
    private long timestamp;

    /* compiled from: Advice.kt */
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<Advice> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Advice createFromParcel(Parcel parcel) {
            i.f(parcel, "parcel");
            String readString = parcel.readString();
            long readLong = parcel.readLong();
            ArrayList arrayList = null;
            Content createFromParcel = parcel.readInt() == 0 ? null : Content.CREATOR.createFromParcel(parcel);
            Content createFromParcel2 = parcel.readInt() == 0 ? null : Content.CREATOR.createFromParcel(parcel);
            ArtyComponent createFromParcel3 = parcel.readInt() == 0 ? null : ArtyComponent.CREATOR.createFromParcel(parcel);
            ArtyGraph createFromParcel4 = parcel.readInt() == 0 ? null : ArtyGraph.CREATOR.createFromParcel(parcel);
            ArtyScore createFromParcel5 = parcel.readInt() == 0 ? null : ArtyScore.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList.add(Content.CREATOR.createFromParcel(parcel));
                }
            }
            return new Advice(readString, readLong, createFromParcel, createFromParcel2, createFromParcel3, createFromParcel4, createFromParcel5, arrayList, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Advice[] newArray(int i10) {
            return new Advice[i10];
        }
    }

    public Advice(String str, long j10, Content content, Content content2, ArtyComponent artyComponent, ArtyGraph artyGraph, ArtyScore artyScore, List<Content> list, boolean z10) {
        this.f8198id = str;
        this.timestamp = j10;
        this.primary = content;
        this.secondary = content2;
        this.artyComponent = artyComponent;
        this.artyGraph = artyGraph;
        this.artyScore = artyScore;
        this.details = list;
        this.isSeen = z10;
    }

    public final String component1() {
        return this.f8198id;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final Content component3() {
        return this.primary;
    }

    public final Content component4() {
        return this.secondary;
    }

    public final ArtyComponent component5() {
        return this.artyComponent;
    }

    public final ArtyGraph component6() {
        return this.artyGraph;
    }

    public final ArtyScore component7() {
        return this.artyScore;
    }

    public final List<Content> component8() {
        return this.details;
    }

    public final boolean component9() {
        return this.isSeen;
    }

    public final Advice copy(String str, long j10, Content content, Content content2, ArtyComponent artyComponent, ArtyGraph artyGraph, ArtyScore artyScore, List<Content> list, boolean z10) {
        return new Advice(str, j10, content, content2, artyComponent, artyGraph, artyScore, list, z10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Advice)) {
            return false;
        }
        Advice advice = (Advice) obj;
        return i.b(this.f8198id, advice.f8198id) && this.timestamp == advice.timestamp && i.b(this.primary, advice.primary) && i.b(this.secondary, advice.secondary) && i.b(this.artyComponent, advice.artyComponent) && i.b(this.artyGraph, advice.artyGraph) && i.b(this.artyScore, advice.artyScore) && i.b(this.details, advice.details) && this.isSeen == advice.isSeen;
    }

    public final ArtyComponent getArtyComponent() {
        return this.artyComponent;
    }

    public final ArtyGraph getArtyGraph() {
        return this.artyGraph;
    }

    public final ArtyScore getArtyScore() {
        return this.artyScore;
    }

    public final List<Content> getDetails() {
        return this.details;
    }

    public final String getId() {
        return this.f8198id;
    }

    public final Content getPrimary() {
        return this.primary;
    }

    public final Content getSecondary() {
        return this.secondary;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        String str = this.f8198id;
        int i10 = 0;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + a.a(this.timestamp)) * 31;
        Content content = this.primary;
        int hashCode2 = (hashCode + (content == null ? 0 : content.hashCode())) * 31;
        Content content2 = this.secondary;
        int hashCode3 = (hashCode2 + (content2 == null ? 0 : content2.hashCode())) * 31;
        ArtyComponent artyComponent = this.artyComponent;
        int hashCode4 = (hashCode3 + (artyComponent == null ? 0 : artyComponent.hashCode())) * 31;
        ArtyGraph artyGraph = this.artyGraph;
        int hashCode5 = (hashCode4 + (artyGraph == null ? 0 : artyGraph.hashCode())) * 31;
        ArtyScore artyScore = this.artyScore;
        int hashCode6 = (hashCode5 + (artyScore == null ? 0 : artyScore.hashCode())) * 31;
        List<Content> list = this.details;
        if (list != null) {
            i10 = list.hashCode();
        }
        int i11 = (hashCode6 + i10) * 31;
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

    public final void setArtyComponent(ArtyComponent artyComponent) {
        this.artyComponent = artyComponent;
    }

    public final void setArtyGraph(ArtyGraph artyGraph) {
        this.artyGraph = artyGraph;
    }

    public final void setArtyScore(ArtyScore artyScore) {
        this.artyScore = artyScore;
    }

    public final void setDetails(List<Content> list) {
        this.details = list;
    }

    public final void setId(String str) {
        this.f8198id = str;
    }

    public final void setPrimary(Content content) {
        this.primary = content;
    }

    public final void setSecondary(Content content) {
        this.secondary = content;
    }

    public final void setSeen(boolean z10) {
        this.isSeen = z10;
    }

    public final void setTimestamp(long j10) {
        this.timestamp = j10;
    }

    public String toString() {
        return "Advice(id=" + ((Object) this.f8198id) + ", timestamp=" + this.timestamp + ", primary=" + this.primary + ", secondary=" + this.secondary + ", artyComponent=" + this.artyComponent + ", artyGraph=" + this.artyGraph + ", artyScore=" + this.artyScore + ", details=" + this.details + ", isSeen=" + this.isSeen + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i10) {
        i.f(out, "out");
        out.writeString(this.f8198id);
        out.writeLong(this.timestamp);
        Content content = this.primary;
        if (content == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            content.writeToParcel(out, i10);
        }
        Content content2 = this.secondary;
        if (content2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            content2.writeToParcel(out, i10);
        }
        ArtyComponent artyComponent = this.artyComponent;
        if (artyComponent == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            artyComponent.writeToParcel(out, i10);
        }
        ArtyGraph artyGraph = this.artyGraph;
        if (artyGraph == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            artyGraph.writeToParcel(out, i10);
        }
        ArtyScore artyScore = this.artyScore;
        if (artyScore == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            artyScore.writeToParcel(out, i10);
        }
        List<Content> list = this.details;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            for (Content content3 : list) {
                content3.writeToParcel(out, i10);
            }
        }
        out.writeInt(this.isSeen ? 1 : 0);
    }

    public /* synthetic */ Advice(String str, long j10, Content content, Content content2, ArtyComponent artyComponent, ArtyGraph artyGraph, ArtyScore artyScore, List list, boolean z10, int i10, f fVar) {
        this(str, j10, content, content2, artyComponent, artyGraph, artyScore, list, (i10 & 256) != 0 ? false : z10);
    }
}
