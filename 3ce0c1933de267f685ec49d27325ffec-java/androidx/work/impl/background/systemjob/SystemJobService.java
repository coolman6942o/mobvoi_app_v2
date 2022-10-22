package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.work.WorkerParameters;
import androidx.work.k;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import r1.b;
import r1.i;
/* loaded from: classes.dex */
public class SystemJobService extends JobService implements b {

    /* renamed from: c  reason: collision with root package name */
    private static final String f4813c = k.f("SystemJobService");

    /* renamed from: a  reason: collision with root package name */
    private i f4814a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, JobParameters> f4815b = new HashMap();

    private static String a(JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return extras.getString("EXTRA_WORK_SPEC_ID");
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // r1.b
    public void c(String str, boolean z10) {
        JobParameters remove;
        k.c().a(f4813c, String.format("%s executed on JobScheduler", str), new Throwable[0]);
        synchronized (this.f4815b) {
            remove = this.f4815b.remove(str);
        }
        if (remove != null) {
            jobFinished(remove, z10);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            i j10 = i.j(getApplicationContext());
            this.f4814a = j10;
            j10.l().d(this);
        } catch (IllegalStateException unused) {
            if (Application.class.equals(getApplication().getClass())) {
                k.c().h(f4813c, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
                return;
            }
            throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        i iVar = this.f4814a;
        if (iVar != null) {
            iVar.l().i(this);
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (this.f4814a == null) {
            k.c().a(f4813c, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            jobFinished(jobParameters, true);
            return false;
        }
        String a10 = a(jobParameters);
        if (TextUtils.isEmpty(a10)) {
            k.c().b(f4813c, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        synchronized (this.f4815b) {
            if (this.f4815b.containsKey(a10)) {
                k.c().a(f4813c, String.format("Job is already being executed by SystemJobService: %s", a10), new Throwable[0]);
                return false;
            }
            k.c().a(f4813c, String.format("onStartJob for %s", a10), new Throwable[0]);
            this.f4815b.put(a10, jobParameters);
            WorkerParameters.a aVar = null;
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 24) {
                aVar = new WorkerParameters.a();
                if (jobParameters.getTriggeredContentUris() != null) {
                    aVar.f4694b = Arrays.asList(jobParameters.getTriggeredContentUris());
                }
                if (jobParameters.getTriggeredContentAuthorities() != null) {
                    aVar.f4693a = Arrays.asList(jobParameters.getTriggeredContentAuthorities());
                }
                if (i10 >= 28) {
                    jobParameters.getNetwork();
                }
            }
            this.f4814a.u(a10, aVar);
            return true;
        }
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        if (this.f4814a == null) {
            k.c().a(f4813c, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            return true;
        }
        String a10 = a(jobParameters);
        if (TextUtils.isEmpty(a10)) {
            k.c().b(f4813c, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        k.c().a(f4813c, String.format("onStopJob for %s", a10), new Throwable[0]);
        synchronized (this.f4815b) {
            this.f4815b.remove(a10);
        }
        this.f4814a.w(a10);
        return !this.f4814a.l().f(a10);
    }
}
