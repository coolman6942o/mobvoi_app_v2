package m4;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps2d.model.BitmapDescriptor;
import com.amap.api.maps2d.model.MyLocationStyle;
/* compiled from: MyLocationStyleCreator.java */
/* loaded from: classes.dex */
public class a implements Parcelable.Creator<MyLocationStyle> {
    /* renamed from: a */
    public MyLocationStyle createFromParcel(Parcel parcel) {
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.b((BitmapDescriptor) parcel.readParcelable(BitmapDescriptor.class.getClassLoader()));
        myLocationStyle.a(parcel.readFloat(), parcel.readFloat());
        myLocationStyle.c(parcel.readInt());
        myLocationStyle.d(parcel.readInt());
        myLocationStyle.e(parcel.readFloat());
        return myLocationStyle;
    }

    /* renamed from: b */
    public MyLocationStyle[] newArray(int i10) {
        return new MyLocationStyle[i10];
    }
}
