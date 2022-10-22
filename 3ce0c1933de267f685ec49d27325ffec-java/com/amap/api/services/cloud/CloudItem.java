package com.amap.api.services.cloud;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class CloudItem implements Parcelable {
    public static final Parcelable.Creator<CloudItem> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f7277a;

    /* renamed from: b  reason: collision with root package name */
    private int f7278b;

    /* renamed from: c  reason: collision with root package name */
    protected final LatLonPoint f7279c;

    /* renamed from: d  reason: collision with root package name */
    protected final String f7280d;

    /* renamed from: e  reason: collision with root package name */
    protected final String f7281e;

    /* renamed from: f  reason: collision with root package name */
    private String f7282f;

    /* renamed from: g  reason: collision with root package name */
    private String f7283g;

    /* renamed from: h  reason: collision with root package name */
    private HashMap<String, String> f7284h;

    /* renamed from: i  reason: collision with root package name */
    private List<CloudImage> f7285i;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<CloudItem> {
        a() {
        }

        /* renamed from: a */
        public CloudItem createFromParcel(Parcel parcel) {
            return new CloudItem(parcel);
        }

        /* renamed from: b */
        public CloudItem[] newArray(int i10) {
            return new CloudItem[i10];
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CloudItem(Parcel parcel) {
        this.f7278b = -1;
        this.f7277a = parcel.readString();
        this.f7278b = parcel.readInt();
        this.f7279c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f7280d = parcel.readString();
        this.f7281e = parcel.readString();
        this.f7282f = parcel.readString();
        this.f7283g = parcel.readString();
        HashMap<String, String> hashMap = new HashMap<>();
        this.f7284h = hashMap;
        parcel.readMap(hashMap, HashMap.class.getClassLoader());
        List arrayList = new ArrayList();
        this.f7285i = arrayList;
        parcel.readList(arrayList, getClass().getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CloudItem)) {
            return false;
        }
        CloudItem cloudItem = (CloudItem) obj;
        String str = this.f7277a;
        if (str == null) {
            if (cloudItem.f7277a != null) {
                return false;
            }
        } else if (!str.equals(cloudItem.f7277a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f7277a;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return this.f7280d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7277a);
        parcel.writeInt(this.f7278b);
        parcel.writeValue(this.f7279c);
        parcel.writeString(this.f7280d);
        parcel.writeString(this.f7281e);
        parcel.writeString(this.f7282f);
        parcel.writeString(this.f7283g);
        parcel.writeMap(this.f7284h);
        parcel.writeList(this.f7285i);
    }
}
