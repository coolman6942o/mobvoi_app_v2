package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.poisearch.IndoorData;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiItemExtension;
import com.amap.api.services.poisearch.SubPoiItem;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class PoiItem implements Parcelable {
    public static final Parcelable.Creator<PoiItem> CREATOR = new a();
    private String A;
    private String B;

    /* renamed from: a  reason: collision with root package name */
    private String f7293a;

    /* renamed from: b  reason: collision with root package name */
    private String f7294b;

    /* renamed from: c  reason: collision with root package name */
    private String f7295c;

    /* renamed from: d  reason: collision with root package name */
    private String f7296d;

    /* renamed from: e  reason: collision with root package name */
    private String f7297e;

    /* renamed from: f  reason: collision with root package name */
    private int f7298f;

    /* renamed from: g  reason: collision with root package name */
    private final LatLonPoint f7299g;

    /* renamed from: h  reason: collision with root package name */
    private final String f7300h;

    /* renamed from: i  reason: collision with root package name */
    private final String f7301i;

    /* renamed from: j  reason: collision with root package name */
    private LatLonPoint f7302j;

    /* renamed from: k  reason: collision with root package name */
    private LatLonPoint f7303k;

    /* renamed from: l  reason: collision with root package name */
    private String f7304l;

    /* renamed from: m  reason: collision with root package name */
    private String f7305m;

    /* renamed from: n  reason: collision with root package name */
    private String f7306n;

    /* renamed from: o  reason: collision with root package name */
    private String f7307o;

    /* renamed from: p  reason: collision with root package name */
    private String f7308p;

    /* renamed from: q  reason: collision with root package name */
    private String f7309q;

    /* renamed from: r  reason: collision with root package name */
    private String f7310r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f7311s;

    /* renamed from: t  reason: collision with root package name */
    private IndoorData f7312t;

    /* renamed from: u  reason: collision with root package name */
    private String f7313u;

    /* renamed from: v  reason: collision with root package name */
    private String f7314v;

    /* renamed from: w  reason: collision with root package name */
    private String f7315w;

    /* renamed from: x  reason: collision with root package name */
    private List<SubPoiItem> f7316x;

    /* renamed from: y  reason: collision with root package name */
    private List<Photo> f7317y;

    /* renamed from: z  reason: collision with root package name */
    private PoiItemExtension f7318z;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<PoiItem> {
        a() {
        }

        /* renamed from: a */
        public PoiItem createFromParcel(Parcel parcel) {
            return new PoiItem(parcel);
        }

        /* renamed from: b */
        public PoiItem[] newArray(int i10) {
            return new PoiItem[i10];
        }
    }

    protected PoiItem(Parcel parcel) {
        this.f7297e = "";
        this.f7298f = -1;
        this.f7316x = new ArrayList();
        this.f7317y = new ArrayList();
        this.f7293a = parcel.readString();
        this.f7295c = parcel.readString();
        this.f7294b = parcel.readString();
        this.f7297e = parcel.readString();
        this.f7298f = parcel.readInt();
        this.f7299g = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f7300h = parcel.readString();
        this.f7301i = parcel.readString();
        this.f7296d = parcel.readString();
        this.f7302j = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f7303k = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f7304l = parcel.readString();
        this.f7305m = parcel.readString();
        this.f7306n = parcel.readString();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f7311s = zArr[0];
        this.f7307o = parcel.readString();
        this.f7308p = parcel.readString();
        this.f7309q = parcel.readString();
        this.f7310r = parcel.readString();
        this.f7313u = parcel.readString();
        this.f7314v = parcel.readString();
        this.f7315w = parcel.readString();
        this.f7316x = parcel.readArrayList(SubPoiItem.class.getClassLoader());
        this.f7312t = (IndoorData) parcel.readValue(IndoorData.class.getClassLoader());
        this.f7317y = parcel.createTypedArrayList(Photo.CREATOR);
        this.f7318z = (PoiItemExtension) parcel.readParcelable(PoiItemExtension.class.getClassLoader());
        this.A = parcel.readString();
        this.B = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PoiItem poiItem = (PoiItem) obj;
        String str = this.f7293a;
        if (str == null) {
            if (poiItem.f7293a != null) {
                return false;
            }
        } else if (!str.equals(poiItem.f7293a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f7293a;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return this.f7300h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7293a);
        parcel.writeString(this.f7295c);
        parcel.writeString(this.f7294b);
        parcel.writeString(this.f7297e);
        parcel.writeInt(this.f7298f);
        parcel.writeValue(this.f7299g);
        parcel.writeString(this.f7300h);
        parcel.writeString(this.f7301i);
        parcel.writeString(this.f7296d);
        parcel.writeValue(this.f7302j);
        parcel.writeValue(this.f7303k);
        parcel.writeString(this.f7304l);
        parcel.writeString(this.f7305m);
        parcel.writeString(this.f7306n);
        parcel.writeBooleanArray(new boolean[]{this.f7311s});
        parcel.writeString(this.f7307o);
        parcel.writeString(this.f7308p);
        parcel.writeString(this.f7309q);
        parcel.writeString(this.f7310r);
        parcel.writeString(this.f7313u);
        parcel.writeString(this.f7314v);
        parcel.writeString(this.f7315w);
        parcel.writeList(this.f7316x);
        parcel.writeValue(this.f7312t);
        parcel.writeTypedList(this.f7317y);
        parcel.writeParcelable(this.f7318z, i10);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
    }
}
