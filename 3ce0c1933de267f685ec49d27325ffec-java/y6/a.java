package y6;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import k6.b;
/* loaded from: classes.dex */
public interface a extends IInterface {
    b V0(LatLngBounds latLngBounds, int i10, int i11, int i12) throws RemoteException;

    b b2(LatLng latLng, float f10) throws RemoteException;

    b c2(float f10, float f11) throws RemoteException;

    b g(LatLngBounds latLngBounds, int i10) throws RemoteException;
}
