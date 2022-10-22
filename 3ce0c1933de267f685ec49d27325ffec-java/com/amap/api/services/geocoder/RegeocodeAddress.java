package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.road.Crossroad;
import com.amap.api.services.road.Road;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class RegeocodeAddress implements Parcelable {
    public static final Parcelable.Creator<RegeocodeAddress> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f7352a;

    /* renamed from: b  reason: collision with root package name */
    private String f7353b;

    /* renamed from: c  reason: collision with root package name */
    private String f7354c;

    /* renamed from: d  reason: collision with root package name */
    private String f7355d;

    /* renamed from: e  reason: collision with root package name */
    private String f7356e;

    /* renamed from: f  reason: collision with root package name */
    private String f7357f;

    /* renamed from: g  reason: collision with root package name */
    private String f7358g;

    /* renamed from: h  reason: collision with root package name */
    private StreetNumber f7359h;

    /* renamed from: i  reason: collision with root package name */
    private String f7360i;

    /* renamed from: j  reason: collision with root package name */
    private String f7361j;

    /* renamed from: k  reason: collision with root package name */
    private String f7362k;

    /* renamed from: l  reason: collision with root package name */
    private List<RegeocodeRoad> f7363l;

    /* renamed from: m  reason: collision with root package name */
    private List<Crossroad> f7364m;

    /* renamed from: n  reason: collision with root package name */
    private List<PoiItem> f7365n;

    /* renamed from: o  reason: collision with root package name */
    private List<BusinessArea> f7366o;

    /* renamed from: p  reason: collision with root package name */
    private List<AoiItem> f7367p;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<RegeocodeAddress> {
        a() {
        }

        /* renamed from: a */
        public RegeocodeAddress createFromParcel(Parcel parcel) {
            return new RegeocodeAddress(parcel, null);
        }

        /* renamed from: b */
        public RegeocodeAddress[] newArray(int i10) {
            return null;
        }
    }

    /* synthetic */ RegeocodeAddress(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7352a);
        parcel.writeString(this.f7353b);
        parcel.writeString(this.f7354c);
        parcel.writeString(this.f7355d);
        parcel.writeString(this.f7356e);
        parcel.writeString(this.f7357f);
        parcel.writeString(this.f7358g);
        parcel.writeValue(this.f7359h);
        parcel.writeList(this.f7363l);
        parcel.writeList(this.f7364m);
        parcel.writeList(this.f7365n);
        parcel.writeString(this.f7360i);
        parcel.writeString(this.f7361j);
        parcel.writeList(this.f7366o);
        parcel.writeList(this.f7367p);
        parcel.writeString(this.f7362k);
    }

    public RegeocodeAddress() {
        this.f7363l = new ArrayList();
        this.f7364m = new ArrayList();
        this.f7365n = new ArrayList();
        this.f7366o = new ArrayList();
        this.f7367p = new ArrayList();
    }

    private RegeocodeAddress(Parcel parcel) {
        this.f7363l = new ArrayList();
        this.f7364m = new ArrayList();
        this.f7365n = new ArrayList();
        this.f7366o = new ArrayList();
        this.f7367p = new ArrayList();
        this.f7352a = parcel.readString();
        this.f7353b = parcel.readString();
        this.f7354c = parcel.readString();
        this.f7355d = parcel.readString();
        this.f7356e = parcel.readString();
        this.f7357f = parcel.readString();
        this.f7358g = parcel.readString();
        this.f7359h = (StreetNumber) parcel.readValue(StreetNumber.class.getClassLoader());
        this.f7363l = parcel.readArrayList(Road.class.getClassLoader());
        this.f7364m = parcel.readArrayList(Crossroad.class.getClassLoader());
        this.f7365n = parcel.readArrayList(PoiItem.class.getClassLoader());
        this.f7360i = parcel.readString();
        this.f7361j = parcel.readString();
        this.f7366o = parcel.readArrayList(BusinessArea.class.getClassLoader());
        this.f7367p = parcel.readArrayList(AoiItem.class.getClassLoader());
        this.f7362k = parcel.readString();
    }
}
