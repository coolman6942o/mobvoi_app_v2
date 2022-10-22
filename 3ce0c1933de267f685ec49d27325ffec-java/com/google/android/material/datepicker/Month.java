package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Calendar f10734a;

    /* renamed from: b  reason: collision with root package name */
    final int f10735b;

    /* renamed from: c  reason: collision with root package name */
    final int f10736c;

    /* renamed from: d  reason: collision with root package name */
    final int f10737d;

    /* renamed from: e  reason: collision with root package name */
    final int f10738e;

    /* renamed from: f  reason: collision with root package name */
    final long f10739f;

    /* renamed from: g  reason: collision with root package name */
    private String f10740g;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<Month> {
        a() {
        }

        /* renamed from: a */
        public Month createFromParcel(Parcel parcel) {
            return Month.b(parcel.readInt(), parcel.readInt());
        }

        /* renamed from: b */
        public Month[] newArray(int i10) {
            return new Month[i10];
        }
    }

    private Month(Calendar calendar) {
        calendar.set(5, 1);
        Calendar f10 = p.f(calendar);
        this.f10734a = f10;
        this.f10735b = f10.get(2);
        this.f10736c = f10.get(1);
        this.f10737d = f10.getMaximum(7);
        this.f10738e = f10.getActualMaximum(5);
        this.f10739f = f10.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Month b(int i10, int i11) {
        Calendar q5 = p.q();
        q5.set(1, i10);
        q5.set(2, i11);
        return new Month(q5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Month c(long j10) {
        Calendar q5 = p.q();
        q5.setTimeInMillis(j10);
        return new Month(q5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Month d() {
        return new Month(p.o());
    }

    /* renamed from: a */
    public int compareTo(Month month) {
        return this.f10734a.compareTo(month.f10734a);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        int firstDayOfWeek = this.f10734a.get(7) - this.f10734a.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.f10737d : firstDayOfWeek;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        return this.f10735b == month.f10735b && this.f10736c == month.f10736c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long f(int i10) {
        Calendar f10 = p.f(this.f10734a);
        f10.set(5, i10);
        return f10.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g(long j10) {
        Calendar f10 = p.f(this.f10734a);
        f10.setTimeInMillis(j10);
        return f10.get(5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h(Context context) {
        if (this.f10740g == null) {
            this.f10740g = d.i(context, this.f10734a.getTimeInMillis());
        }
        return this.f10740g;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f10735b), Integer.valueOf(this.f10736c)});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long i() {
        return this.f10734a.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month j(int i10) {
        Calendar f10 = p.f(this.f10734a);
        f10.add(2, i10);
        return new Month(f10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k(Month month) {
        if (this.f10734a instanceof GregorianCalendar) {
            return ((month.f10736c - this.f10736c) * 12) + (month.f10735b - this.f10735b);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f10736c);
        parcel.writeInt(this.f10735b);
    }
}
