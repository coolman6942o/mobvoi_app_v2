package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;
/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(VersionedParcel versionedParcel) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f2222a = (IconCompat) versionedParcel.v(remoteActionCompat.f2222a, 1);
        remoteActionCompat.f2223b = versionedParcel.l(remoteActionCompat.f2223b, 2);
        remoteActionCompat.f2224c = versionedParcel.l(remoteActionCompat.f2224c, 3);
        remoteActionCompat.f2225d = (PendingIntent) versionedParcel.r(remoteActionCompat.f2225d, 4);
        remoteActionCompat.f2226e = versionedParcel.h(remoteActionCompat.f2226e, 5);
        remoteActionCompat.f2227f = versionedParcel.h(remoteActionCompat.f2227f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, VersionedParcel versionedParcel) {
        versionedParcel.x(false, false);
        versionedParcel.M(remoteActionCompat.f2222a, 1);
        versionedParcel.D(remoteActionCompat.f2223b, 2);
        versionedParcel.D(remoteActionCompat.f2224c, 3);
        versionedParcel.H(remoteActionCompat.f2225d, 4);
        versionedParcel.z(remoteActionCompat.f2226e, 5);
        versionedParcel.z(remoteActionCompat.f2227f, 6);
    }
}
