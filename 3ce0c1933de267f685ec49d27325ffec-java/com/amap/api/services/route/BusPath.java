package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class BusPath extends Path {
    public static final Parcelable.Creator<BusPath> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    private float f7412c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7413d;

    /* renamed from: e  reason: collision with root package name */
    private float f7414e;

    /* renamed from: f  reason: collision with root package name */
    private float f7415f;

    /* renamed from: g  reason: collision with root package name */
    private List<BusStep> f7416g;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<BusPath> {
        a() {
        }

        /* renamed from: a */
        public BusPath createFromParcel(Parcel parcel) {
            return new BusPath(parcel);
        }

        /* renamed from: b */
        public BusPath[] newArray(int i10) {
            return null;
        }
    }

    public BusPath(Parcel parcel) {
        super(parcel);
        this.f7416g = new ArrayList();
        this.f7412c = parcel.readFloat();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f7413d = zArr[0];
        this.f7414e = parcel.readFloat();
        this.f7415f = parcel.readFloat();
        this.f7416g = parcel.createTypedArrayList(BusStep.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeFloat(this.f7412c);
        parcel.writeBooleanArray(new boolean[]{this.f7413d});
        parcel.writeFloat(this.f7414e);
        parcel.writeFloat(this.f7415f);
        parcel.writeTypedList(this.f7416g);
    }

    public BusPath() {
        this.f7416g = new ArrayList();
    }
}
