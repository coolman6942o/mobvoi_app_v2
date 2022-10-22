package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final c f11594a;

    /* renamed from: b  reason: collision with root package name */
    private final c f11595b;

    /* renamed from: c  reason: collision with root package name */
    final int f11596c;

    /* renamed from: d  reason: collision with root package name */
    int f11597d;

    /* renamed from: e  reason: collision with root package name */
    int f11598e;

    /* renamed from: f  reason: collision with root package name */
    int f11599f;

    /* renamed from: g  reason: collision with root package name */
    int f11600g;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<TimeModel> {
        a() {
        }

        /* renamed from: a */
        public TimeModel createFromParcel(Parcel parcel) {
            return new TimeModel(parcel);
        }

        /* renamed from: b */
        public TimeModel[] newArray(int i10) {
            return new TimeModel[i10];
        }
    }

    public TimeModel() {
        this(0);
    }

    public static String a(Resources resources, CharSequence charSequence) {
        return b(resources, charSequence, "%02d");
    }

    public static String b(Resources resources, CharSequence charSequence, String str) {
        return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
    }

    private static int f(int i10) {
        return i10 >= 12 ? 1 : 0;
    }

    public int c() {
        if (this.f11596c == 1) {
            return this.f11597d % 24;
        }
        int i10 = this.f11597d;
        if (i10 % 12 == 0) {
            return 12;
        }
        return this.f11600g == 1 ? i10 - 12 : i10;
    }

    public c d() {
        return this.f11595b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public c e() {
        return this.f11594a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeModel)) {
            return false;
        }
        TimeModel timeModel = (TimeModel) obj;
        return this.f11597d == timeModel.f11597d && this.f11598e == timeModel.f11598e && this.f11596c == timeModel.f11596c && this.f11599f == timeModel.f11599f;
    }

    public void g(int i10) {
        if (this.f11596c == 1) {
            this.f11597d = i10;
            return;
        }
        int i11 = 12;
        int i12 = i10 % 12;
        if (this.f11600g != 1) {
            i11 = 0;
        }
        this.f11597d = i12 + i11;
    }

    public void h(int i10) {
        this.f11600g = f(i10);
        this.f11597d = i10;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f11596c), Integer.valueOf(this.f11597d), Integer.valueOf(this.f11598e), Integer.valueOf(this.f11599f)});
    }

    public void i(int i10) {
        this.f11598e = i10 % 60;
    }

    public void j(int i10) {
        if (i10 != this.f11600g) {
            this.f11600g = i10;
            int i11 = this.f11597d;
            if (i11 < 12 && i10 == 1) {
                this.f11597d = i11 + 12;
            } else if (i11 >= 12 && i10 == 0) {
                this.f11597d = i11 - 12;
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f11597d);
        parcel.writeInt(this.f11598e);
        parcel.writeInt(this.f11599f);
        parcel.writeInt(this.f11596c);
    }

    public TimeModel(int i10) {
        this(0, 0, 10, i10);
    }

    public TimeModel(int i10, int i11, int i12, int i13) {
        this.f11597d = i10;
        this.f11598e = i11;
        this.f11599f = i12;
        this.f11596c = i13;
        this.f11600g = f(i10);
        this.f11594a = new c(59);
        this.f11595b = new c(i13 == 1 ? 24 : 12);
    }

    protected TimeModel(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}
