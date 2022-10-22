package com.cardiex.arty.lite.models.dashboard;

import android.os.Parcel;
import android.os.Parcelable;
import com.cardiex.arty.lite.models.coach.ArtyScore;
import kotlin.jvm.internal.i;
import kotlinx.parcelize.Parcelize;
/* compiled from: Dashboard.kt */
@Parcelize
/* loaded from: classes.dex */
public final class Dashboard implements Parcelable {
    public static final Parcelable.Creator<Dashboard> CREATOR = new Creator();
    private ArtyScore artyScore;
    private int newFriends;
    private int newInsights;
    private int totalUnseenAdvice;

    /* compiled from: Dashboard.kt */
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<Dashboard> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Dashboard createFromParcel(Parcel parcel) {
            i.f(parcel, "parcel");
            return new Dashboard(parcel.readInt(), (ArtyScore) parcel.readParcelable(Dashboard.class.getClassLoader()), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Dashboard[] newArray(int i10) {
            return new Dashboard[i10];
        }
    }

    public Dashboard(int i10, ArtyScore artyScore, int i11, int i12) {
        this.newInsights = i10;
        this.artyScore = artyScore;
        this.newFriends = i11;
        this.totalUnseenAdvice = i12;
    }

    public static /* synthetic */ Dashboard copy$default(Dashboard dashboard, int i10, ArtyScore artyScore, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i10 = dashboard.newInsights;
        }
        if ((i13 & 2) != 0) {
            artyScore = dashboard.artyScore;
        }
        if ((i13 & 4) != 0) {
            i11 = dashboard.newFriends;
        }
        if ((i13 & 8) != 0) {
            i12 = dashboard.totalUnseenAdvice;
        }
        return dashboard.copy(i10, artyScore, i11, i12);
    }

    public final int component1() {
        return this.newInsights;
    }

    public final ArtyScore component2() {
        return this.artyScore;
    }

    public final int component3() {
        return this.newFriends;
    }

    public final int component4() {
        return this.totalUnseenAdvice;
    }

    public final Dashboard copy(int i10, ArtyScore artyScore, int i11, int i12) {
        return new Dashboard(i10, artyScore, i11, i12);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Dashboard)) {
            return false;
        }
        Dashboard dashboard = (Dashboard) obj;
        return this.newInsights == dashboard.newInsights && i.b(this.artyScore, dashboard.artyScore) && this.newFriends == dashboard.newFriends && this.totalUnseenAdvice == dashboard.totalUnseenAdvice;
    }

    public final ArtyScore getArtyScore() {
        return this.artyScore;
    }

    public final int getNewFriends() {
        return this.newFriends;
    }

    public final int getNewInsights() {
        return this.newInsights;
    }

    public final int getTotalUnseenAdvice() {
        return this.totalUnseenAdvice;
    }

    public int hashCode() {
        int i10 = this.newInsights * 31;
        ArtyScore artyScore = this.artyScore;
        return ((((i10 + (artyScore == null ? 0 : artyScore.hashCode())) * 31) + this.newFriends) * 31) + this.totalUnseenAdvice;
    }

    public final void setArtyScore(ArtyScore artyScore) {
        this.artyScore = artyScore;
    }

    public final void setNewFriends(int i10) {
        this.newFriends = i10;
    }

    public final void setNewInsights(int i10) {
        this.newInsights = i10;
    }

    public final void setTotalUnseenAdvice(int i10) {
        this.totalUnseenAdvice = i10;
    }

    public String toString() {
        return "Dashboard(newInsights=" + this.newInsights + ", artyScore=" + this.artyScore + ", newFriends=" + this.newFriends + ", totalUnseenAdvice=" + this.totalUnseenAdvice + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i10) {
        i.f(out, "out");
        out.writeInt(this.newInsights);
        out.writeParcelable(this.artyScore, i10);
        out.writeInt(this.newFriends);
        out.writeInt(this.totalUnseenAdvice);
    }
}
