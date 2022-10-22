package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.AMapException;
import j0.c;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Month f10714a;

    /* renamed from: b  reason: collision with root package name */
    private final Month f10715b;

    /* renamed from: c  reason: collision with root package name */
    private final DateValidator f10716c;

    /* renamed from: d  reason: collision with root package name */
    private Month f10717d;

    /* renamed from: e  reason: collision with root package name */
    private final int f10718e;

    /* renamed from: f  reason: collision with root package name */
    private final int f10719f;

    /* loaded from: classes.dex */
    public interface DateValidator extends Parcelable {
        boolean i0(long j10);
    }

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<CalendarConstraints> {
        a() {
        }

        /* renamed from: a */
        public CalendarConstraints createFromParcel(Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), null);
        }

        /* renamed from: b */
        public CalendarConstraints[] newArray(int i10) {
            return new CalendarConstraints[i10];
        }
    }

    /* synthetic */ CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3, a aVar) {
        this(month, month2, dateValidator, month3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month e(Month month) {
        if (month.compareTo(this.f10714a) < 0) {
            return this.f10714a;
        }
        return month.compareTo(this.f10715b) > 0 ? this.f10715b : month;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        return this.f10714a.equals(calendarConstraints.f10714a) && this.f10715b.equals(calendarConstraints.f10715b) && c.a(this.f10717d, calendarConstraints.f10717d) && this.f10716c.equals(calendarConstraints.f10716c);
    }

    public DateValidator f() {
        return this.f10716c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month g() {
        return this.f10715b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f10719f;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f10714a, this.f10715b, this.f10717d, this.f10716c});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month i() {
        return this.f10717d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month j() {
        return this.f10714a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f10718e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l(long j10) {
        if (this.f10714a.f(1) <= j10) {
            Month month = this.f10715b;
            if (j10 <= month.f(month.f10738e)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Month month) {
        this.f10717d = month;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f10714a, 0);
        parcel.writeParcelable(this.f10715b, 0);
        parcel.writeParcelable(this.f10717d, 0);
        parcel.writeParcelable(this.f10716c, 0);
    }

    private CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3) {
        this.f10714a = month;
        this.f10715b = month2;
        this.f10717d = month3;
        this.f10716c = dateValidator;
        if (month3 != null && month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        } else if (month3 == null || month3.compareTo(month2) <= 0) {
            this.f10719f = month.k(month2) + 1;
            this.f10718e = (month2.f10736c - month.f10736c) + 1;
        } else {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: e  reason: collision with root package name */
        static final long f10720e = p.a(Month.b(AMapException.CODE_AMAP_CLIENT_UNKNOWN_ERROR, 0).f10739f);

        /* renamed from: f  reason: collision with root package name */
        static final long f10721f = p.a(Month.b(AMapException.CODE_AMAP_NEARBY_INVALID_USERID, 11).f10739f);

        /* renamed from: a  reason: collision with root package name */
        private long f10722a;

        /* renamed from: b  reason: collision with root package name */
        private long f10723b;

        /* renamed from: c  reason: collision with root package name */
        private Long f10724c;

        /* renamed from: d  reason: collision with root package name */
        private DateValidator f10725d;

        public b() {
            this.f10722a = f10720e;
            this.f10723b = f10721f;
            this.f10725d = DateValidatorPointForward.a(Long.MIN_VALUE);
        }

        public CalendarConstraints a() {
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f10725d);
            Month c10 = Month.c(this.f10722a);
            Month c11 = Month.c(this.f10723b);
            DateValidator dateValidator = (DateValidator) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l10 = this.f10724c;
            return new CalendarConstraints(c10, c11, dateValidator, l10 == null ? null : Month.c(l10.longValue()), null);
        }

        public b b(long j10) {
            this.f10723b = j10;
            return this;
        }

        public b c(long j10) {
            this.f10724c = Long.valueOf(j10);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(CalendarConstraints calendarConstraints) {
            this.f10722a = f10720e;
            this.f10723b = f10721f;
            this.f10725d = DateValidatorPointForward.a(Long.MIN_VALUE);
            this.f10722a = calendarConstraints.f10714a.f10739f;
            this.f10723b = calendarConstraints.f10715b.f10739f;
            this.f10724c = Long.valueOf(calendarConstraints.f10717d.f10739f);
            this.f10725d = calendarConstraints.f10716c;
        }
    }
}
