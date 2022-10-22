package com.mobvoi.companion.health.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.mobvoi.companion.health.entity.a;
/* loaded from: classes2.dex */
public class WeekSportDetailBean implements Parcelable {
    public static final Parcelable.Creator<WeekSportDetailBean> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public String f16837a;

    /* renamed from: b  reason: collision with root package name */
    public long f16838b;

    /* renamed from: c  reason: collision with root package name */
    public long f16839c;

    /* renamed from: d  reason: collision with root package name */
    public String f16840d;

    /* renamed from: e  reason: collision with root package name */
    public String f16841e;

    /* renamed from: f  reason: collision with root package name */
    public int f16842f;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<WeekSportDetailBean> {
        a() {
        }

        /* renamed from: a */
        public WeekSportDetailBean createFromParcel(Parcel parcel) {
            return new WeekSportDetailBean(parcel);
        }

        /* renamed from: b */
        public WeekSportDetailBean[] newArray(int i10) {
            return new WeekSportDetailBean[i10];
        }
    }

    public WeekSportDetailBean() {
    }

    public static WeekSportDetailBean a(String str, a.b bVar) {
        WeekSportDetailBean weekSportDetailBean = new WeekSportDetailBean();
        weekSportDetailBean.f16837a = str;
        weekSportDetailBean.f16838b = bVar.f16849a;
        weekSportDetailBean.f16839c = bVar.f16850b;
        weekSportDetailBean.f16840d = bVar.f16851c;
        weekSportDetailBean.f16841e = bVar.f16852d;
        weekSportDetailBean.f16842f = bVar.f16853e;
        return weekSportDetailBean;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f16837a);
        parcel.writeLong(this.f16838b);
        parcel.writeLong(this.f16839c);
        parcel.writeString(this.f16840d);
        parcel.writeString(this.f16841e);
        parcel.writeInt(this.f16842f);
    }

    protected WeekSportDetailBean(Parcel parcel) {
        this.f16837a = parcel.readString();
        this.f16838b = parcel.readLong();
        this.f16839c = parcel.readLong();
        this.f16840d = parcel.readString();
        this.f16841e = parcel.readString();
        this.f16842f = parcel.readInt();
    }
}
