package com.cardiex.arty.lite.models.coach;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import kotlin.jvm.internal.i;
import kotlinx.parcelize.Parcelize;
/* compiled from: Question.kt */
@Parcelize
/* loaded from: classes.dex */
public final class Question implements Parcelable {
    public static final Parcelable.Creator<Question> CREATOR = new Creator();
    private String[] answers;

    /* renamed from: id  reason: collision with root package name */
    private String f8200id;
    private String value;

    /* compiled from: Question.kt */
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<Question> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Question createFromParcel(Parcel parcel) {
            i.f(parcel, "parcel");
            return new Question(parcel.readString(), parcel.readString(), parcel.createStringArray());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Question[] newArray(int i10) {
            return new Question[i10];
        }
    }

    public Question(String str, String str2, String[] strArr) {
        this.f8200id = str;
        this.value = str2;
        this.answers = strArr;
    }

    public static /* synthetic */ Question copy$default(Question question, String str, String str2, String[] strArr, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = question.f8200id;
        }
        if ((i10 & 2) != 0) {
            str2 = question.value;
        }
        if ((i10 & 4) != 0) {
            strArr = question.answers;
        }
        return question.copy(str, str2, strArr);
    }

    public final String component1() {
        return this.f8200id;
    }

    public final String component2() {
        return this.value;
    }

    public final String[] component3() {
        return this.answers;
    }

    public final Question copy(String str, String str2, String[] strArr) {
        return new Question(str, str2, strArr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Question)) {
            return false;
        }
        Question question = (Question) obj;
        return i.b(this.f8200id, question.f8200id) && i.b(this.value, question.value) && i.b(this.answers, question.answers);
    }

    public final String[] getAnswers() {
        return this.answers;
    }

    public final String getId() {
        return this.f8200id;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.f8200id;
        int i10 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.value;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String[] strArr = this.answers;
        if (strArr != null) {
            i10 = Arrays.hashCode(strArr);
        }
        return hashCode2 + i10;
    }

    public final void setAnswers(String[] strArr) {
        this.answers = strArr;
    }

    public final void setId(String str) {
        this.f8200id = str;
    }

    public final void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        return "Question(id=" + ((Object) this.f8200id) + ", value=" + ((Object) this.value) + ", answers=" + Arrays.toString(this.answers) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i10) {
        i.f(out, "out");
        out.writeString(this.f8200id);
        out.writeString(this.value);
        out.writeStringArray(this.answers);
    }
}
