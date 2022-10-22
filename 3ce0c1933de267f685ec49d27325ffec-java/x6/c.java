package x6;

import android.content.Context;
import android.os.RemoteException;
import b6.i;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import y6.m;
import y6.n;
import z6.b;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f36461a = false;

    public static synchronized int a(Context context) {
        synchronized (c.class) {
            i.l(context, "Context is null");
            if (f36461a) {
                return 0;
            }
            try {
                n c10 = m.c(context);
                try {
                    b.e(c10.D1());
                    b.b(c10.j0());
                    f36461a = true;
                    return 0;
                } catch (RemoteException e10) {
                    throw new RuntimeRemoteException(e10);
                }
            } catch (GooglePlayServicesNotAvailableException e11) {
                return e11.errorCode;
            }
        }
    }
}
