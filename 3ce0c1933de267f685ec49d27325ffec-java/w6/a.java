package w6;

import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.e;
import com.google.android.gms.location.LocationRequest;
@Deprecated
/* loaded from: classes.dex */
public interface a {
    Location a(d dVar);

    e<Status> b(d dVar, c cVar);

    e<Status> c(d dVar, LocationRequest locationRequest, c cVar, Looper looper);
}
