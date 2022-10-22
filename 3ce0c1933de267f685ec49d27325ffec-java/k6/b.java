package k6;

import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes.dex */
public interface b extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class a extends r6.b implements b {

        /* renamed from: k6.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0364a extends r6.a implements b {
            C0364a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IObjectWrapper");
            }
        }

        public a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static b m1(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            if (queryLocalInterface instanceof b) {
                return (b) queryLocalInterface;
            }
            return new C0364a(iBinder);
        }
    }
}
