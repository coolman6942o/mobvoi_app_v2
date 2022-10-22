package g5;

import android.content.Context;
import android.util.Log;
import androidx.core.content.b;
import g5.c;
/* compiled from: DefaultConnectivityMonitorFactory.java */
/* loaded from: classes.dex */
public class f implements d {
    @Override // g5.d
    public c a(Context context, c.a aVar) {
        boolean z10 = b.a(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            Log.d("ConnectivityMonitor", z10 ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        if (z10) {
            return new e(context, aVar);
        }
        return new j();
    }
}
