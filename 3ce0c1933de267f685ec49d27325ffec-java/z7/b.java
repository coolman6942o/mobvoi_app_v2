package z7;

import a8.a;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import b6.i;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class b implements a {

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f37295b;

    /* renamed from: a  reason: collision with root package name */
    private final AppMeasurement f37296a;

    private b(AppMeasurement appMeasurement) {
        i.k(appMeasurement);
        this.f37296a = appMeasurement;
        new ConcurrentHashMap();
    }

    public static a c(Context context) {
        i.k(context);
        i.k(context.getApplicationContext());
        if (f37295b == null) {
            synchronized (a.class) {
                if (f37295b == null) {
                    f37295b = new b(AppMeasurement.getInstance(context));
                }
            }
        }
        return f37295b;
    }

    @Override // z7.a
    public void a(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!a.c(str)) {
            String valueOf = String.valueOf(str);
            Log.d("FA-C", valueOf.length() != 0 ? "Origin not allowed : ".concat(valueOf) : new String("Origin not allowed : "));
        } else if (!a.a(str2, bundle)) {
            Log.d("FA-C", "Event or Params not allowed");
        } else if (!a.b(str, str2, bundle)) {
            Log.d("FA-C", "Campaign events not allowed");
        } else {
            this.f37296a.logEventInternal(str, str2, bundle);
        }
    }

    @Override // z7.a
    public void b(String str, String str2, Object obj) {
        if (!a.c(str)) {
            String valueOf = String.valueOf(str);
            Log.d("FA-C", valueOf.length() != 0 ? "Origin not allowed : ".concat(valueOf) : new String("Origin not allowed : "));
        } else if (!a.d(str2)) {
            String valueOf2 = String.valueOf(str2);
            Log.d("FA-C", valueOf2.length() != 0 ? "User Property not allowed : ".concat(valueOf2) : new String("User Property not allowed : "));
        } else if ((str2.equals("_ce1") || str2.equals("_ce2")) && !str.equals(AppMeasurement.FCM_ORIGIN) && !str.equals("frc")) {
            Log.d("FA-C", str2.length() != 0 ? "User Property not allowed for this origin: ".concat(str2) : new String("User Property not allowed for this origin: "));
        } else {
            this.f37296a.setUserPropertyInternal(str, str2, obj);
        }
    }
}
