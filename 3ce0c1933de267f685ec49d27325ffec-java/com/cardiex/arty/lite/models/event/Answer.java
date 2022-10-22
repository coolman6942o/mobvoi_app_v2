package com.cardiex.arty.lite.models.event;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlinx.parcelize.Parcelize;
/* compiled from: Answer.kt */
@Parcelize
/* loaded from: classes.dex */
public final class Answer implements Parcelable {
    public static final Parcelable.Creator<Answer> CREATOR = new Creator();
    private String questionId;
    private String value;

    /* compiled from: Answer.kt */
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<Answer> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Answer createFromParcel(Parcel parcel) {
            i.f(parcel, "parcel");
            return new Answer(parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Answer[] newArray(int i10) {
            return new Answer[i10];
        }
    }

    public Answer(String str, String str2) {
        this.questionId = str;
        this.value = str2;
    }

    public static /* synthetic */ Answer copy$default(Answer answer, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = answer.questionId;
        }
        if ((i10 & 2) != 0) {
            str2 = answer.value;
        }
        return answer.copy(str, str2);
    }

    public final String component1() {
        return this.questionId;
    }

    public final String component2() {
        return this.value;
    }

    public final Answer copy(String str, String str2) {
        return new Answer(str, str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Answer)) {
            return false;
        }
        Answer answer = (Answer) obj;
        return i.b(this.questionId, answer.questionId) && i.b(this.value, answer.value);
    }

    public final String getQuestionId() {
        return this.questionId;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.questionId;
        int i10 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.value;
        if (str2 != null) {
            i10 = str2.hashCode();
        }
        return hashCode + i10;
    }

    public final void setQuestionId(String str) {
        this.questionId = str;
    }

    public final void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        return "Answer(questionId=" + ((Object) this.questionId) + ", value=" + ((Object) this.value) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i10) {
        i.f(out, "out");
        out.writeString(this.questionId);
        out.writeString(this.value);
    }

    public /* synthetic */ Answer(String str, String str2, int i10, f fVar) {
        this(str, (i10 & 2) != 0 ? null : str2);
    }
}
