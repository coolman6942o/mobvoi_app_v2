package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.Arrays;
/* loaded from: classes.dex */
public class DateValidatorPointForward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointForward> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final long f10731a;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<DateValidatorPointForward> {
        a() {
        }

        /* renamed from: a */
        public DateValidatorPointForward createFromParcel(Parcel parcel) {
            return new DateValidatorPointForward(parcel.readLong(), null);
        }

        /* renamed from: b */
        public DateValidatorPointForward[] newArray(int i10) {
            return new DateValidatorPointForward[i10];
        }
    }

    /* synthetic */ DateValidatorPointForward(long j10, a aVar) {
        this(j10);
    }

    public static DateValidatorPointForward a(long j10) {
        return new DateValidatorPointForward(j10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DateValidatorPointForward) && this.f10731a == ((DateValidatorPointForward) obj).f10731a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f10731a)});
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean i0(long j10) {
        return j10 >= this.f10731a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f10731a);
    }

    private DateValidatorPointForward(long j10) {
        this.f10731a = j10;
    }
}
