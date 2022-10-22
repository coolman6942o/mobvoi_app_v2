package y0;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;
import android.util.SparseArray;
import com.mobvoi.wear.util.LogCleaner;
/* compiled from: WakefulBroadcastReceiver.java */
@Deprecated
/* loaded from: classes.dex */
public abstract class a extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final SparseArray<PowerManager.WakeLock> f36665a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private static int f36666b = 1;

    public static boolean c(Intent intent) {
        int intExtra = intent.getIntExtra("androidx.contentpager.content.wakelockid", 0);
        if (intExtra == 0) {
            return false;
        }
        SparseArray<PowerManager.WakeLock> sparseArray = f36665a;
        synchronized (sparseArray) {
            PowerManager.WakeLock wakeLock = sparseArray.get(intExtra);
            if (wakeLock != null) {
                wakeLock.release();
                sparseArray.remove(intExtra);
                return true;
            }
            Log.w("WakefulBroadcastReceiv.", "No active wake lock id #" + intExtra);
            return true;
        }
    }

    public static ComponentName d(Context context, Intent intent) {
        SparseArray<PowerManager.WakeLock> sparseArray = f36665a;
        synchronized (sparseArray) {
            int i10 = f36666b;
            int i11 = i10 + 1;
            f36666b = i11;
            if (i11 <= 0) {
                f36666b = 1;
            }
            intent.putExtra("androidx.contentpager.content.wakelockid", i10);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "androidx.core:wake:" + startService.flattenToShortString());
            newWakeLock.setReferenceCounted(false);
            newWakeLock.acquire(LogCleaner.ONE_MINUTE);
            sparseArray.put(i10, newWakeLock);
            return startService;
        }
    }
}
