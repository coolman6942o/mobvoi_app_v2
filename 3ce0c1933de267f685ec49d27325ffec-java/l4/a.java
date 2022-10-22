package l4;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps2d.AMapOptions;
import com.amap.api.maps2d.model.CameraPosition;
/* compiled from: AMapOptionsCreator.java */
/* loaded from: classes.dex */
public class a implements Parcelable.Creator<AMapOptions> {
    /* renamed from: a */
    public AMapOptions createFromParcel(Parcel parcel) {
        AMapOptions aMapOptions = new AMapOptions();
        aMapOptions.c(parcel.readInt());
        aMapOptions.a((CameraPosition) parcel.readParcelable(CameraPosition.class.getClassLoader()));
        boolean[] createBooleanArray = parcel.createBooleanArray();
        if (createBooleanArray != null && createBooleanArray.length >= 6) {
            aMapOptions.e(createBooleanArray[0]);
            aMapOptions.h(createBooleanArray[1]);
            aMapOptions.g(createBooleanArray[2]);
            aMapOptions.f(createBooleanArray[3]);
            aMapOptions.b(createBooleanArray[4]);
            aMapOptions.d(createBooleanArray[5]);
        }
        return aMapOptions;
    }

    /* renamed from: b */
    public AMapOptions[] newArray(int i10) {
        return new AMapOptions[i10];
    }
}
