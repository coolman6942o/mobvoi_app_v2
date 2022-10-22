package com.cardiex.arty.lite.models.coach;

import android.os.Parcel;
import android.os.Parcelable;
import ia.a;
import kotlin.jvm.internal.i;
import kotlinx.parcelize.Parcelize;
/* compiled from: Article.kt */
@Parcelize
/* loaded from: classes.dex */
public final class Article implements Parcelable {
    public static final Parcelable.Creator<Article> CREATOR = new Creator();
    private String author;
    private String authorLocation;
    private String bodyHtml;

    /* renamed from: id  reason: collision with root package name */
    private String f8199id;
    private String image;
    private boolean isSeen;
    private String summary;
    private long timestamp;
    private String title;

    /* compiled from: Article.kt */
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<Article> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Article createFromParcel(Parcel parcel) {
            i.f(parcel, "parcel");
            return new Article(parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Article[] newArray(int i10) {
            return new Article[i10];
        }
    }

    public Article(String str, long j10, String str2, String str3, String str4, String str5, String str6, String str7, boolean z10) {
        this.f8199id = str;
        this.timestamp = j10;
        this.image = str2;
        this.title = str3;
        this.author = str4;
        this.authorLocation = str5;
        this.summary = str6;
        this.bodyHtml = str7;
        this.isSeen = z10;
    }

    public final String component1() {
        return this.f8199id;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final String component3() {
        return this.image;
    }

    public final String component4() {
        return this.title;
    }

    public final String component5() {
        return this.author;
    }

    public final String component6() {
        return this.authorLocation;
    }

    public final String component7() {
        return this.summary;
    }

    public final String component8() {
        return this.bodyHtml;
    }

    public final boolean component9() {
        return this.isSeen;
    }

    public final Article copy(String str, long j10, String str2, String str3, String str4, String str5, String str6, String str7, boolean z10) {
        return new Article(str, j10, str2, str3, str4, str5, str6, str7, z10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Article)) {
            return false;
        }
        Article article = (Article) obj;
        return i.b(this.f8199id, article.f8199id) && this.timestamp == article.timestamp && i.b(this.image, article.image) && i.b(this.title, article.title) && i.b(this.author, article.author) && i.b(this.authorLocation, article.authorLocation) && i.b(this.summary, article.summary) && i.b(this.bodyHtml, article.bodyHtml) && this.isSeen == article.isSeen;
    }

    public final String getAuthor() {
        return this.author;
    }

    public final String getAuthorLocation() {
        return this.authorLocation;
    }

    public final String getBodyHtml() {
        return this.bodyHtml;
    }

    public final String getId() {
        return this.f8199id;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.f8199id;
        int i10 = 0;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + a.a(this.timestamp)) * 31;
        String str2 = this.image;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.title;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.author;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.authorLocation;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.summary;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.bodyHtml;
        if (str7 != null) {
            i10 = str7.hashCode();
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

    public final void setAuthor(String str) {
        this.author = str;
    }

    public final void setAuthorLocation(String str) {
        this.authorLocation = str;
    }

    public final void setBodyHtml(String str) {
        this.bodyHtml = str;
    }

    public final void setId(String str) {
        this.f8199id = str;
    }

    public final void setImage(String str) {
        this.image = str;
    }

    public final void setSeen(boolean z10) {
        this.isSeen = z10;
    }

    public final void setSummary(String str) {
        this.summary = str;
    }

    public final void setTimestamp(long j10) {
        this.timestamp = j10;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "Article(id=" + ((Object) this.f8199id) + ", timestamp=" + this.timestamp + ", image=" + ((Object) this.image) + ", title=" + ((Object) this.title) + ", author=" + ((Object) this.author) + ", authorLocation=" + ((Object) this.authorLocation) + ", summary=" + ((Object) this.summary) + ", bodyHtml=" + ((Object) this.bodyHtml) + ", isSeen=" + this.isSeen + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i10) {
        i.f(out, "out");
        out.writeString(this.f8199id);
        out.writeLong(this.timestamp);
        out.writeString(this.image);
        out.writeString(this.title);
        out.writeString(this.author);
        out.writeString(this.authorLocation);
        out.writeString(this.summary);
        out.writeString(this.bodyHtml);
        out.writeInt(this.isSeen ? 1 : 0);
    }
}
