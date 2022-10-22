package y6;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import b6.i;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.d;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.maps.model.RuntimeRemoteException;
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private static final String f36774a = "m";
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b  reason: collision with root package name */
    private static Context f36775b;

    /* renamed from: c  reason: collision with root package name */
    private static n f36776c;

    private static <T> T a(Class<?> cls) {
        try {
            return (T) cls.newInstance();
        } catch (IllegalAccessException unused) {
            String name = cls.getName();
            throw new IllegalStateException(name.length() != 0 ? "Unable to call the default constructor of ".concat(name) : new String("Unable to call the default constructor of "));
        } catch (InstantiationException unused2) {
            String name2 = cls.getName();
            throw new IllegalStateException(name2.length() != 0 ? "Unable to instantiate the dynamic class ".concat(name2) : new String("Unable to instantiate the dynamic class "));
        }
    }

    private static <T> T b(ClassLoader classLoader, String str) {
        try {
            return (T) a(((ClassLoader) i.k(classLoader)).loadClass(str));
        } catch (ClassNotFoundException unused) {
            String valueOf = String.valueOf(str);
            throw new IllegalStateException(valueOf.length() != 0 ? "Unable to find dynamic class ".concat(valueOf) : new String("Unable to find dynamic class "));
        }
    }

    public static n c(Context context) throws GooglePlayServicesNotAvailableException {
        n nVar;
        i.k(context);
        n nVar2 = f36776c;
        if (nVar2 != null) {
            return nVar2;
        }
        int g10 = d.g(context, 13400000);
        if (g10 == 0) {
            Log.i(f36774a, "Making Creator dynamically");
            IBinder iBinder = (IBinder) b(d(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl");
            if (iBinder == null) {
                nVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
                if (queryLocalInterface instanceof n) {
                    nVar = (n) queryLocalInterface;
                } else {
                    nVar = new o(iBinder);
                }
            }
            f36776c = nVar;
            try {
                nVar.l2(k6.d.A2(d(context).getResources()), d.f8814f);
                return f36776c;
            } catch (RemoteException e10) {
                throw new RuntimeRemoteException(e10);
            }
        } else {
            throw new GooglePlayServicesNotAvailableException(g10);
        }
    }

    private static Context d(Context context) {
        Context context2 = f36775b;
        if (context2 != null) {
            return context2;
        }
        Context e10 = e(context);
        f36775b = e10;
        return e10;
    }

    private static Context e(Context context) {
        try {
            return DynamiteModule.d(context, DynamiteModule.f9049i, "com.google.android.gms.maps_dynamite").b();
        } catch (Exception e10) {
            Log.e(f36774a, "Failed to load maps module, use legacy", e10);
            return d.d(context);
        }
    }
}
