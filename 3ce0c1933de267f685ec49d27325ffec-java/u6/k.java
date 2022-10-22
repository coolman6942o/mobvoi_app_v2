package u6;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import k6.b;
/* loaded from: classes.dex */
public final class k extends a implements i {
    /* JADX INFO: Access modifiers changed from: package-private */
    public k(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
    }

    @Override // u6.i
    public final b z0(Bitmap bitmap) throws RemoteException {
        Parcel m12 = m1();
        h.c(m12, bitmap);
        Parcel U1 = U1(6, m12);
        b m13 = b.a.m1(U1.readStrongBinder());
        U1.recycle();
        return m13;
    }
}
