package com.liulishuo.filedownloader.model;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.mobvoi.wear.permission.PermissionConstant;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import r9.e;
/* loaded from: classes2.dex */
public class FileDownloadModel implements Parcelable {
    public static final Parcelable.Creator<FileDownloadModel> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private int f15229a;

    /* renamed from: b  reason: collision with root package name */
    private String f15230b;

    /* renamed from: c  reason: collision with root package name */
    private String f15231c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f15232d;

    /* renamed from: e  reason: collision with root package name */
    private String f15233e;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicInteger f15234f;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicLong f15235g;

    /* renamed from: h  reason: collision with root package name */
    private long f15236h;

    /* renamed from: i  reason: collision with root package name */
    private String f15237i;

    /* renamed from: j  reason: collision with root package name */
    private String f15238j;

    /* renamed from: k  reason: collision with root package name */
    private int f15239k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f15240l;

    /* loaded from: classes2.dex */
    static class a implements Parcelable.Creator<FileDownloadModel> {
        a() {
        }

        /* renamed from: a */
        public FileDownloadModel createFromParcel(Parcel parcel) {
            return new FileDownloadModel(parcel);
        }

        /* renamed from: b */
        public FileDownloadModel[] newArray(int i10) {
            return new FileDownloadModel[i10];
        }
    }

    public FileDownloadModel() {
        this.f15235g = new AtomicLong();
        this.f15234f = new AtomicInteger();
    }

    public void A(long j10) {
        this.f15235g.set(j10);
    }

    public void B(byte b10) {
        this.f15234f.set(b10);
    }

    public void C(long j10) {
        this.f15240l = j10 > 2147483647L;
        this.f15236h = j10;
    }

    public void D(String str) {
        this.f15230b = str;
    }

    public ContentValues E() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(e()));
        contentValues.put("url", l());
        contentValues.put("path", f());
        contentValues.put(PermissionConstant.Columns.STATUS, Byte.valueOf(h()));
        contentValues.put("sofar", Long.valueOf(g()));
        contentValues.put("total", Long.valueOf(k()));
        contentValues.put("errMsg", c());
        contentValues.put("etag", b());
        contentValues.put("connectionCount", Integer.valueOf(a()));
        contentValues.put("pathAsDirectory", Boolean.valueOf(r()));
        if (r() && d() != null) {
            contentValues.put("filename", d());
        }
        return contentValues;
    }

    public int a() {
        return this.f15239k;
    }

    public String b() {
        return this.f15238j;
    }

    public String c() {
        return this.f15237i;
    }

    public String d() {
        return this.f15233e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f15229a;
    }

    public String f() {
        return this.f15231c;
    }

    public long g() {
        return this.f15235g.get();
    }

    public byte h() {
        return (byte) this.f15234f.get();
    }

    public String i() {
        return e.y(f(), r(), d());
    }

    public String j() {
        if (i() == null) {
            return null;
        }
        return e.z(i());
    }

    public long k() {
        return this.f15236h;
    }

    public String l() {
        return this.f15230b;
    }

    public void m(long j10) {
        this.f15235g.addAndGet(j10);
    }

    public boolean o() {
        return this.f15236h == -1;
    }

    public boolean p() {
        return this.f15240l;
    }

    public boolean r() {
        return this.f15232d;
    }

    public void s() {
        this.f15239k = 1;
    }

    public void t(int i10) {
        this.f15239k = i10;
    }

    public String toString() {
        return e.n("id[%d], url[%s], path[%s], status[%d], sofar[%s], total[%d], etag[%s], %s", Integer.valueOf(this.f15229a), this.f15230b, this.f15231c, Integer.valueOf(this.f15234f.get()), this.f15235g, Long.valueOf(this.f15236h), this.f15238j, super.toString());
    }

    public void u(String str) {
        this.f15238j = str;
    }

    public void v(String str) {
        this.f15237i = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f15229a);
        parcel.writeString(this.f15230b);
        parcel.writeString(this.f15231c);
        parcel.writeByte(this.f15232d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f15233e);
        parcel.writeByte((byte) this.f15234f.get());
        parcel.writeLong(this.f15235g.get());
        parcel.writeLong(this.f15236h);
        parcel.writeString(this.f15237i);
        parcel.writeString(this.f15238j);
        parcel.writeInt(this.f15239k);
        parcel.writeByte(this.f15240l ? (byte) 1 : (byte) 0);
    }

    public void x(String str) {
        this.f15233e = str;
    }

    public void y(int i10) {
        this.f15229a = i10;
    }

    public void z(String str, boolean z10) {
        this.f15231c = str;
        this.f15232d = z10;
    }

    protected FileDownloadModel(Parcel parcel) {
        this.f15229a = parcel.readInt();
        this.f15230b = parcel.readString();
        this.f15231c = parcel.readString();
        boolean z10 = true;
        this.f15232d = parcel.readByte() != 0;
        this.f15233e = parcel.readString();
        this.f15234f = new AtomicInteger(parcel.readByte());
        this.f15235g = new AtomicLong(parcel.readLong());
        this.f15236h = parcel.readLong();
        this.f15237i = parcel.readString();
        this.f15238j = parcel.readString();
        this.f15239k = parcel.readInt();
        this.f15240l = parcel.readByte() == 0 ? false : z10;
    }
}
