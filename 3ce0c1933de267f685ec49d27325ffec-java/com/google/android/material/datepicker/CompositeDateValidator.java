package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.CalendarConstraints;
import j0.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class CompositeDateValidator implements CalendarConstraints.DateValidator {

    /* renamed from: a  reason: collision with root package name */
    private final d f10728a;

    /* renamed from: b  reason: collision with root package name */
    private final List<CalendarConstraints.DateValidator> f10729b;

    /* renamed from: c  reason: collision with root package name */
    private static final d f10726c = new a();

    /* renamed from: d  reason: collision with root package name */
    private static final d f10727d = new b();
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements d {
        a() {
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public boolean a(List<CalendarConstraints.DateValidator> list, long j10) {
            for (CalendarConstraints.DateValidator dateValidator : list) {
                if (dateValidator != null && dateValidator.i0(j10)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public int getId() {
            return 1;
        }
    }

    /* loaded from: classes.dex */
    static class b implements d {
        b() {
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public boolean a(List<CalendarConstraints.DateValidator> list, long j10) {
            for (CalendarConstraints.DateValidator dateValidator : list) {
                if (dateValidator != null && !dateValidator.i0(j10)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public int getId() {
            return 2;
        }
    }

    /* loaded from: classes.dex */
    static class c implements Parcelable.Creator<CompositeDateValidator> {
        c() {
        }

        /* renamed from: a */
        public CompositeDateValidator createFromParcel(Parcel parcel) {
            ArrayList readArrayList = parcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader());
            int readInt = parcel.readInt();
            return new CompositeDateValidator((List) h.g(readArrayList), readInt == 2 ? CompositeDateValidator.f10727d : readInt == 1 ? CompositeDateValidator.f10726c : CompositeDateValidator.f10727d, null);
        }

        /* renamed from: b */
        public CompositeDateValidator[] newArray(int i10) {
            return new CompositeDateValidator[i10];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface d {
        boolean a(List<CalendarConstraints.DateValidator> list, long j10);

        int getId();
    }

    /* synthetic */ CompositeDateValidator(List list, d dVar, a aVar) {
        this(list, dVar);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompositeDateValidator)) {
            return false;
        }
        CompositeDateValidator compositeDateValidator = (CompositeDateValidator) obj;
        return this.f10729b.equals(compositeDateValidator.f10729b) && this.f10728a.getId() == compositeDateValidator.f10728a.getId();
    }

    public int hashCode() {
        return this.f10729b.hashCode();
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean i0(long j10) {
        return this.f10728a.a(this.f10729b, j10);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeList(this.f10729b);
        parcel.writeInt(this.f10728a.getId());
    }

    private CompositeDateValidator(List<CalendarConstraints.DateValidator> list, d dVar) {
        this.f10729b = list;
        this.f10728a = dVar;
    }
}
