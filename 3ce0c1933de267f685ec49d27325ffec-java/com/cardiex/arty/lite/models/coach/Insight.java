package com.cardiex.arty.lite.models.coach;

import android.os.Parcel;
import android.os.Parcelable;
import com.cardiex.arty.lite.models.social.BadgeSummary;
import ia.a;
import kotlin.jvm.internal.i;
import kotlinx.parcelize.Parcelize;
/* compiled from: Insight.kt */
@Parcelize
/* loaded from: classes.dex */
public final class Insight implements Parcelable {
    public static final Parcelable.Creator<Insight> CREATOR = new Creator();
    private Advice advice;
    private Article article;
    private BadgeSummary badgeSummary;
    private long timestamp;
    private InsightType type;

    /* compiled from: Insight.kt */
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<Insight> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Insight createFromParcel(Parcel parcel) {
            i.f(parcel, "parcel");
            long readLong = parcel.readLong();
            BadgeSummary badgeSummary = null;
            InsightType valueOf = parcel.readInt() == 0 ? null : InsightType.valueOf(parcel.readString());
            Advice createFromParcel = parcel.readInt() == 0 ? null : Advice.CREATOR.createFromParcel(parcel);
            Article createFromParcel2 = parcel.readInt() == 0 ? null : Article.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                badgeSummary = BadgeSummary.CREATOR.createFromParcel(parcel);
            }
            return new Insight(readLong, valueOf, createFromParcel, createFromParcel2, badgeSummary);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Insight[] newArray(int i10) {
            return new Insight[i10];
        }
    }

    public Insight(long j10, InsightType insightType, Advice advice, Article article, BadgeSummary badgeSummary) {
        this.timestamp = j10;
        this.type = insightType;
        this.advice = advice;
        this.article = article;
        this.badgeSummary = badgeSummary;
    }

    public static /* synthetic */ Insight copy$default(Insight insight, long j10, InsightType insightType, Advice advice, Article article, BadgeSummary badgeSummary, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = insight.timestamp;
        }
        long j11 = j10;
        if ((i10 & 2) != 0) {
            insightType = insight.type;
        }
        InsightType insightType2 = insightType;
        if ((i10 & 4) != 0) {
            advice = insight.advice;
        }
        Advice advice2 = advice;
        if ((i10 & 8) != 0) {
            article = insight.article;
        }
        Article article2 = article;
        if ((i10 & 16) != 0) {
            badgeSummary = insight.badgeSummary;
        }
        return insight.copy(j11, insightType2, advice2, article2, badgeSummary);
    }

    public final long component1() {
        return this.timestamp;
    }

    public final InsightType component2() {
        return this.type;
    }

    public final Advice component3() {
        return this.advice;
    }

    public final Article component4() {
        return this.article;
    }

    public final BadgeSummary component5() {
        return this.badgeSummary;
    }

    public final Insight copy(long j10, InsightType insightType, Advice advice, Article article, BadgeSummary badgeSummary) {
        return new Insight(j10, insightType, advice, article, badgeSummary);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Insight)) {
            return false;
        }
        Insight insight = (Insight) obj;
        return this.timestamp == insight.timestamp && this.type == insight.type && i.b(this.advice, insight.advice) && i.b(this.article, insight.article) && i.b(this.badgeSummary, insight.badgeSummary);
    }

    public final Advice getAdvice() {
        return this.advice;
    }

    public final Article getArticle() {
        return this.article;
    }

    public final BadgeSummary getBadgeSummary() {
        return this.badgeSummary;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final InsightType getType() {
        return this.type;
    }

    public int hashCode() {
        int a10 = a.a(this.timestamp) * 31;
        InsightType insightType = this.type;
        int i10 = 0;
        int hashCode = (a10 + (insightType == null ? 0 : insightType.hashCode())) * 31;
        Advice advice = this.advice;
        int hashCode2 = (hashCode + (advice == null ? 0 : advice.hashCode())) * 31;
        Article article = this.article;
        int hashCode3 = (hashCode2 + (article == null ? 0 : article.hashCode())) * 31;
        BadgeSummary badgeSummary = this.badgeSummary;
        if (badgeSummary != null) {
            i10 = badgeSummary.hashCode();
        }
        return hashCode3 + i10;
    }

    public final void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public final void setArticle(Article article) {
        this.article = article;
    }

    public final void setBadgeSummary(BadgeSummary badgeSummary) {
        this.badgeSummary = badgeSummary;
    }

    public final void setTimestamp(long j10) {
        this.timestamp = j10;
    }

    public final void setType(InsightType insightType) {
        this.type = insightType;
    }

    public String toString() {
        return "Insight(timestamp=" + this.timestamp + ", type=" + this.type + ", advice=" + this.advice + ", article=" + this.article + ", badgeSummary=" + this.badgeSummary + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i10) {
        i.f(out, "out");
        out.writeLong(this.timestamp);
        InsightType insightType = this.type;
        if (insightType == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeString(insightType.name());
        }
        Advice advice = this.advice;
        if (advice == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            advice.writeToParcel(out, i10);
        }
        Article article = this.article;
        if (article == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            article.writeToParcel(out, i10);
        }
        BadgeSummary badgeSummary = this.badgeSummary;
        if (badgeSummary == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        badgeSummary.writeToParcel(out, i10);
    }
}
