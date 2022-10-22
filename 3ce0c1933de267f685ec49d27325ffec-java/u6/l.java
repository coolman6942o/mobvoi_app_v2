package u6;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
/* loaded from: classes.dex */
public interface l extends IInterface {
    void F(LatLng latLng) throws RemoteException;

    boolean W1(l lVar) throws RemoteException;

    int n() throws RemoteException;

    void remove() throws RemoteException;
}
