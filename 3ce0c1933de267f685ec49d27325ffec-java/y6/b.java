package y6;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import u6.l;
import u6.o;
import u6.r;
/* loaded from: classes.dex */
public interface b extends IInterface {
    void I(f fVar) throws RemoteException;

    void L1(k6.b bVar) throws RemoteException;

    o R0(PolygonOptions polygonOptions) throws RemoteException;

    r S1(PolylineOptions polylineOptions) throws RemoteException;

    d b1() throws RemoteException;

    void clear() throws RemoteException;

    void e(boolean z10) throws RemoteException;

    l q2(MarkerOptions markerOptions) throws RemoteException;
}
