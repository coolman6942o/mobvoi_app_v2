package com.cardiex.arty.lite.models.social;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.i;
import kotlinx.parcelize.Parcelize;
/* compiled from: BadgeSummary.kt */
@Parcelize
/* loaded from: classes.dex */
public final class BadgeSummary implements Parcelable {
    public static final Parcelable.Creator<BadgeSummary> CREATOR = new Creator();
    private int badgesEarned;
    private Badge lastBadge;
    private int totalBadges;

    /* compiled from: BadgeSummary.kt */
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<BadgeSummary> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BadgeSummary createFromParcel(Parcel parcel) {
            i.f(parcel, "parcel");
            return new BadgeSummary((Badge) parcel.readParcelable(BadgeSummary.class.getClassLoader()), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BadgeSummary[] newArray(int i10) {
            return new BadgeSummary[i10];
        }
    }

    public BadgeSummary(Badge badge, int i10, int i11) {
        this.lastBadge = badge;
        this.totalBadges = i10;
        this.badgesEarned = i11;
    }

    public static /* synthetic */ BadgeSummary copy$default(BadgeSummary badgeSummary, Badge badge, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            badge = badgeSummary.lastBadge;
        }
        if ((i12 & 2) != 0) {
            i10 = badgeSummary.totalBadges;
        }
        if ((i12 & 4) != 0) {
            i11 = badgeSummary.badgesEarned;
        }
        return badgeSummary.copy(badge, i10, i11);
    }

    public final Badge component1() {
        return this.lastBadge;
    }

    public final int component2() {
        return this.totalBadges;
    }

    public final int component3() {
        return this.badgesEarned;
    }

    public final BadgeSummary copy(Badge badge, int i10, int i11) {
        return new BadgeSummary(badge, i10, i11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BadgeSummary)) {
            return false;
        }
        BadgeSummary badgeSummary = (BadgeSummary) obj;
        return i.b(this.lastBadge, badgeSummary.lastBadge) && this.totalBadges == badgeSummary.totalBadges && this.badgesEarned == badgeSummary.badgesEarned;
    }

    public final int getBadgesEarned() {
        return this.badgesEarned;
    }

    public final Badge getLastBadge() {
        return this.lastBadge;
    }

    public final int getTotalBadges() {
        return this.totalBadges;
    }

    public int hashCode() {
        Badge badge = this.lastBadge;
        return ((((badge == null ? 0 : badge.hashCode()) * 31) + this.totalBadges) * 31) + this.badgesEarned;
    }

    public final void setBadgesEarned(int i10) {
        this.badgesEarned = i10;
    }

    public final void setLastBadge(Badge badge) {
        this.lastBadge = badge;
    }

    public final void setTotalBadges(int i10) {
        this.totalBadges = i10;
    }

    public String toString() {
        return "BadgeSummary(lastBadge=" + this.lastBadge + ", totalBadges=" + this.totalBadges + ", badgesEarned=" + this.badgesEarned + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i10) {
        i.f(out, "out");
        out.writeParcelable(this.lastBadge, i10);
        out.writeInt(this.totalBadges);
        out.writeInt(this.badgesEarned);
    }
}
