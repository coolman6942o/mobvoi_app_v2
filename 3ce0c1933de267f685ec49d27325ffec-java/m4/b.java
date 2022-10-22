package m4;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore2d.a;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.TextOptions;
import com.mobvoi.wear.info.SharedWearInfoHelper;
/* compiled from: TextOptionsCreator.java */
/* loaded from: classes.dex */
public class b implements Parcelable.Creator<TextOptions> {
    /* renamed from: a */
    public TextOptions createFromParcel(Parcel parcel) {
        TextOptions textOptions = new TextOptions();
        Bundle readBundle = parcel.readBundle();
        textOptions.e(new LatLng(readBundle.getDouble(SharedWearInfoHelper.LocationInfo.KEY_LAT), readBundle.getDouble(SharedWearInfoHelper.LocationInfo.KEY_LNG)));
        textOptions.h(parcel.readString());
        textOptions.i(Typeface.defaultFromStyle(parcel.readInt()));
        textOptions.f(parcel.readFloat());
        textOptions.a(parcel.readInt(), parcel.readInt());
        textOptions.b(parcel.readInt());
        textOptions.c(parcel.readInt());
        textOptions.d(parcel.readInt());
        textOptions.k(parcel.readInt());
        boolean z10 = true;
        if (parcel.readByte() != 1) {
            z10 = false;
        }
        textOptions.j(z10);
        try {
            Parcelable parcelable = parcel.readBundle().getParcelable("obj");
            if (parcelable != null) {
                textOptions.g(parcelable);
            }
        } catch (Throwable th2) {
            a.e(th2, "TextOptionsCreator", "createFromParcel");
        }
        return textOptions;
    }

    /* renamed from: b */
    public TextOptions[] newArray(int i10) {
        return new TextOptions[i10];
    }
}
