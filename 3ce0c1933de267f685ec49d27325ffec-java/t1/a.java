package t1;

import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.b;
import androidx.work.c;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.k;
import y1.p;
/* compiled from: SystemJobInfoConverter.java */
/* loaded from: classes.dex */
class a {

    /* renamed from: b  reason: collision with root package name */
    private static final String f35041b = k.f("SystemJobInfoConverter");

    /* renamed from: a  reason: collision with root package name */
    private final ComponentName f35042a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemJobInfoConverter.java */
    /* renamed from: t1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0499a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f35043a;

        static {
            int[] iArr = new int[NetworkType.values().length];
            f35043a = iArr;
            try {
                iArr[NetworkType.NOT_REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35043a[NetworkType.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35043a[NetworkType.UNMETERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35043a[NetworkType.NOT_ROAMING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f35043a[NetworkType.METERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        this.f35042a = new ComponentName(context.getApplicationContext(), SystemJobService.class);
    }

    private static JobInfo.TriggerContentUri b(c.a aVar) {
        return new JobInfo.TriggerContentUri(aVar.a(), aVar.b() ? 1 : 0);
    }

    static int c(NetworkType networkType) {
        int i10 = C0499a.f35043a[networkType.ordinal()];
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        if (i10 == 3) {
            return 2;
        }
        if (i10 != 4) {
            if (i10 == 5 && Build.VERSION.SDK_INT >= 26) {
                return 4;
            }
        } else if (Build.VERSION.SDK_INT >= 24) {
            return 3;
        }
        k.c().a(f35041b, String.format("API version too low. Cannot convert network type value %s", networkType), new Throwable[0]);
        return 1;
    }

    static void d(JobInfo.Builder builder, NetworkType networkType) {
        if (Build.VERSION.SDK_INT < 30 || networkType != NetworkType.TEMPORARILY_UNMETERED) {
            builder.setRequiredNetworkType(c(networkType));
        } else {
            builder.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JobInfo a(p pVar, int i10) {
        b bVar = pVar.f36698j;
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", pVar.f36689a);
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", pVar.d());
        JobInfo.Builder extras = new JobInfo.Builder(i10, this.f35042a).setRequiresCharging(bVar.g()).setRequiresDeviceIdle(bVar.h()).setExtras(persistableBundle);
        d(extras, bVar.b());
        boolean z10 = false;
        if (!bVar.h()) {
            extras.setBackoffCriteria(pVar.f36701m, pVar.f36700l == BackoffPolicy.LINEAR ? 0 : 1);
        }
        long max = Math.max(pVar.a() - System.currentTimeMillis(), 0L);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 <= 28) {
            extras.setMinimumLatency(max);
        } else if (max > 0) {
            extras.setMinimumLatency(max);
        } else if (!pVar.f36705q) {
            extras.setImportantWhileForeground(true);
        }
        if (i11 >= 24 && bVar.e()) {
            for (c.a aVar : bVar.a().b()) {
                extras.addTriggerContentUri(b(aVar));
            }
            extras.setTriggerContentUpdateDelay(bVar.c());
            extras.setTriggerContentMaxDelay(bVar.d());
        }
        extras.setPersisted(false);
        if (Build.VERSION.SDK_INT >= 26) {
            extras.setRequiresBatteryNotLow(bVar.f());
            extras.setRequiresStorageNotLow(bVar.i());
        }
        boolean z11 = pVar.f36699k > 0;
        if (max > 0) {
            z10 = true;
        }
        if (g0.a.c() && pVar.f36705q && !z11 && !z10) {
            extras.setExpedited(true);
        }
        return extras.build();
    }
}
