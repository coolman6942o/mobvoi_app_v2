package com.mobvoi.mcuwatch.bean;

import android.os.Parcel;
import android.os.Parcelable;
import bn.m;
import com.mobvoi.android.common.json.JsonBean;
/* loaded from: classes2.dex */
public class DialZipBean implements JsonBean, Parcelable, Comparable<DialZipBean> {
    public static final Parcelable.Creator<DialZipBean> CREATOR = new a();
    private String createtime;
    private String dpi;
    private String file;

    /* renamed from: id  reason: collision with root package name */
    private String f19131id;
    private String note;
    private String type;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<DialZipBean> {
        a() {
        }

        /* renamed from: a */
        public DialZipBean createFromParcel(Parcel parcel) {
            return new DialZipBean(parcel);
        }

        /* renamed from: b */
        public DialZipBean[] newArray(int i10) {
            return new DialZipBean[i10];
        }
    }

    public DialZipBean() {
        this.f19131id = "0";
        this.type = "2";
        this.dpi = "240*240";
        this.file = "";
        this.note = "";
        this.createtime = "";
    }

    /* renamed from: a */
    public int compareTo(DialZipBean dialZipBean) {
        return (!m.o().u(e()) || !m.o().u(dialZipBean.e())) ? e().compareTo(dialZipBean.e()) : Integer.parseInt(e()) - Integer.parseInt(dialZipBean.e());
    }

    public String b() {
        return this.createtime;
    }

    public String c() {
        return this.dpi;
    }

    public String d() {
        return this.file;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f19131id;
    }

    public String f() {
        return this.note;
    }

    public String g() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f19131id);
        parcel.writeString(this.type);
        parcel.writeString(this.dpi);
        parcel.writeString(this.file);
        parcel.writeString(this.note);
        parcel.writeString(this.createtime);
    }

    protected DialZipBean(Parcel parcel) {
        this.f19131id = "0";
        this.type = "2";
        this.dpi = "240*240";
        this.file = "";
        this.note = "";
        this.createtime = "";
        this.f19131id = parcel.readString();
        this.type = parcel.readString();
        this.dpi = parcel.readString();
        this.file = parcel.readString();
        this.note = parcel.readString();
        this.createtime = parcel.readString();
    }
}
