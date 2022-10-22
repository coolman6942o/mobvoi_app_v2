package com.cardiex.arty.lite.models.coach;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.i;
import kotlinx.parcelize.Parcelize;
/* compiled from: Content.kt */
@Parcelize
/* loaded from: classes.dex */
public final class Content implements Parcelable {
    public static final Parcelable.Creator<Content> CREATOR = new Creator();
    private Action action;
    private ArtyComponent artyComponent;
    private ArtyGraph artyGraph;
    private ArtyScore artyScore;
    private String bin;
    private String icon;
    private String image;
    private Question question;
    private ContentType type;
    private String value;
    private String video;

    /* compiled from: Content.kt */
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<Content> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Content createFromParcel(Parcel parcel) {
            i.f(parcel, "parcel");
            return new Content(ContentType.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : Action.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (Question) parcel.readParcelable(Content.class.getClassLoader()), (ArtyComponent) parcel.readParcelable(Content.class.getClassLoader()), (ArtyGraph) parcel.readParcelable(Content.class.getClassLoader()), (ArtyScore) parcel.readParcelable(Content.class.getClassLoader()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Content[] newArray(int i10) {
            return new Content[i10];
        }
    }

    public Content(ContentType type, Action action, String str, String str2, String str3, String str4, Question question, ArtyComponent artyComponent, ArtyGraph artyGraph, ArtyScore artyScore, String str5) {
        i.f(type, "type");
        this.type = type;
        this.action = action;
        this.value = str;
        this.video = str2;
        this.icon = str3;
        this.image = str4;
        this.question = question;
        this.artyComponent = artyComponent;
        this.artyGraph = artyGraph;
        this.artyScore = artyScore;
        this.bin = str5;
    }

    public final ContentType component1() {
        return this.type;
    }

    public final ArtyScore component10() {
        return this.artyScore;
    }

    public final String component11() {
        return this.bin;
    }

    public final Action component2() {
        return this.action;
    }

    public final String component3() {
        return this.value;
    }

    public final String component4() {
        return this.video;
    }

    public final String component5() {
        return this.icon;
    }

    public final String component6() {
        return this.image;
    }

    public final Question component7() {
        return this.question;
    }

    public final ArtyComponent component8() {
        return this.artyComponent;
    }

    public final ArtyGraph component9() {
        return this.artyGraph;
    }

    public final Content copy(ContentType type, Action action, String str, String str2, String str3, String str4, Question question, ArtyComponent artyComponent, ArtyGraph artyGraph, ArtyScore artyScore, String str5) {
        i.f(type, "type");
        return new Content(type, action, str, str2, str3, str4, question, artyComponent, artyGraph, artyScore, str5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Content)) {
            return false;
        }
        Content content = (Content) obj;
        return this.type == content.type && this.action == content.action && i.b(this.value, content.value) && i.b(this.video, content.video) && i.b(this.icon, content.icon) && i.b(this.image, content.image) && i.b(this.question, content.question) && i.b(this.artyComponent, content.artyComponent) && i.b(this.artyGraph, content.artyGraph) && i.b(this.artyScore, content.artyScore) && i.b(this.bin, content.bin);
    }

    public final Action getAction() {
        return this.action;
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

    public final String getBin() {
        return this.bin;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getImage() {
        return this.image;
    }

    public final Question getQuestion() {
        return this.question;
    }

    public final ContentType getType() {
        return this.type;
    }

    public final String getValue() {
        return this.value;
    }

    public final String getVideo() {
        return this.video;
    }

    public int hashCode() {
        int hashCode = this.type.hashCode() * 31;
        Action action = this.action;
        int i10 = 0;
        int hashCode2 = (hashCode + (action == null ? 0 : action.hashCode())) * 31;
        String str = this.value;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.video;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.icon;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.image;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Question question = this.question;
        int hashCode7 = (hashCode6 + (question == null ? 0 : question.hashCode())) * 31;
        ArtyComponent artyComponent = this.artyComponent;
        int hashCode8 = (hashCode7 + (artyComponent == null ? 0 : artyComponent.hashCode())) * 31;
        ArtyGraph artyGraph = this.artyGraph;
        int hashCode9 = (hashCode8 + (artyGraph == null ? 0 : artyGraph.hashCode())) * 31;
        ArtyScore artyScore = this.artyScore;
        int hashCode10 = (hashCode9 + (artyScore == null ? 0 : artyScore.hashCode())) * 31;
        String str5 = this.bin;
        if (str5 != null) {
            i10 = str5.hashCode();
        }
        return hashCode10 + i10;
    }

    public final void setAction(Action action) {
        this.action = action;
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

    public final void setBin(String str) {
        this.bin = str;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final void setImage(String str) {
        this.image = str;
    }

    public final void setQuestion(Question question) {
        this.question = question;
    }

    public final void setType(ContentType contentType) {
        i.f(contentType, "<set-?>");
        this.type = contentType;
    }

    public final void setValue(String str) {
        this.value = str;
    }

    public final void setVideo(String str) {
        this.video = str;
    }

    public String toString() {
        return "Content(type=" + this.type + ", action=" + this.action + ", value=" + ((Object) this.value) + ", video=" + ((Object) this.video) + ", icon=" + ((Object) this.icon) + ", image=" + ((Object) this.image) + ", question=" + this.question + ", artyComponent=" + this.artyComponent + ", artyGraph=" + this.artyGraph + ", artyScore=" + this.artyScore + ", bin=" + ((Object) this.bin) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i10) {
        i.f(out, "out");
        out.writeString(this.type.name());
        Action action = this.action;
        if (action == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeString(action.name());
        }
        out.writeString(this.value);
        out.writeString(this.video);
        out.writeString(this.icon);
        out.writeString(this.image);
        out.writeParcelable(this.question, i10);
        out.writeParcelable(this.artyComponent, i10);
        out.writeParcelable(this.artyGraph, i10);
        out.writeParcelable(this.artyScore, i10);
        out.writeString(this.bin);
    }
}
