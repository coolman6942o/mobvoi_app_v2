package y6;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import k6.b;
/* loaded from: classes.dex */
public interface c extends IInterface {
    void G0(h hVar) throws RemoteException;

    b getView() throws RemoteException;

    void onCreate(Bundle bundle) throws RemoteException;

    void onDestroy() throws RemoteException;

    void onPause() throws RemoteException;

    void onResume() throws RemoteException;
}
