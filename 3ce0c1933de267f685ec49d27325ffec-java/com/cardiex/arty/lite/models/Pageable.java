package com.cardiex.arty.lite.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.e;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlinx.parcelize.Parcelize;
/* compiled from: Pageable.kt */
@Parcelize
/* loaded from: classes.dex */
public final class Pageable implements Parcelable {
    public static final Parcelable.Creator<Pageable> CREATOR = new Creator();
    private final e gson;
    private int page;
    private int size;
    private String sort;

    /* compiled from: Pageable.kt */
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<Pageable> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Pageable createFromParcel(Parcel parcel) {
            i.f(parcel, "parcel");
            return new Pageable(parcel.readInt(), parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Pageable[] newArray(int i10) {
            return new Pageable[i10];
        }
    }

    public Pageable(int i10, int i11, String str) {
        this.page = i10;
        this.size = i11;
        this.sort = str;
        this.gson = new e();
    }

    public static /* synthetic */ Pageable copy$default(Pageable pageable, int i10, int i11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = pageable.page;
        }
        if ((i12 & 2) != 0) {
            i11 = pageable.size;
        }
        if ((i12 & 4) != 0) {
            str = pageable.sort;
        }
        return pageable.copy(i10, i11, str);
    }

    private static /* synthetic */ void getGson$annotations() {
    }

    public final int component1() {
        return this.page;
    }

    public final int component2() {
        return this.size;
    }

    public final String component3() {
        return this.sort;
    }

    public final Pageable copy(int i10, int i11, String str) {
        return new Pageable(i10, i11, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pageable)) {
            return false;
        }
        Pageable pageable = (Pageable) obj;
        return this.page == pageable.page && this.size == pageable.size && i.b(this.sort, pageable.sort);
    }

    public final int getPage() {
        return this.page;
    }

    public final int getSize() {
        return this.size;
    }

    public final String getSort() {
        return this.sort;
    }

    public int hashCode() {
        int i10 = ((this.page * 31) + this.size) * 31;
        String str = this.sort;
        return i10 + (str == null ? 0 : str.hashCode());
    }

    public final void setPage(int i10) {
        this.page = i10;
    }

    public final void setSize(int i10) {
        this.size = i10;
    }

    public final void setSort(String str) {
        this.sort = str;
    }

    public String toString() {
        return "Pageable(page=" + this.page + ", size=" + this.size + ", sort=" + ((Object) this.sort) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i10) {
        i.f(out, "out");
        out.writeInt(this.page);
        out.writeInt(this.size);
        out.writeString(this.sort);
    }

    public /* synthetic */ Pageable(int i10, int i11, String str, int i12, f fVar) {
        this(i10, i11, (i12 & 4) != 0 ? null : str);
    }
}
