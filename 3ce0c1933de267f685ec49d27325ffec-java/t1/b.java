package t1;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.k;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import r1.e;
import r1.i;
import y1.g;
import y1.p;
import y1.q;
import z1.c;
/* compiled from: SystemJobScheduler.java */
/* loaded from: classes.dex */
public class b implements e {

    /* renamed from: e  reason: collision with root package name */
    private static final String f35044e = k.f("SystemJobScheduler");

    /* renamed from: a  reason: collision with root package name */
    private final Context f35045a;

    /* renamed from: b  reason: collision with root package name */
    private final JobScheduler f35046b;

    /* renamed from: c  reason: collision with root package name */
    private final i f35047c;

    /* renamed from: d  reason: collision with root package name */
    private final a f35048d;

    public b(Context context, i iVar) {
        this(context, iVar, (JobScheduler) context.getSystemService("jobscheduler"), new a(context));
    }

    public static void b(Context context) {
        List<JobInfo> g10;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (!(jobScheduler == null || (g10 = g(context, jobScheduler)) == null || g10.isEmpty())) {
            for (JobInfo jobInfo : g10) {
                c(jobScheduler, jobInfo.getId());
            }
        }
    }

    private static void c(JobScheduler jobScheduler, int i10) {
        try {
            jobScheduler.cancel(i10);
        } catch (Throwable th2) {
            k.c().b(f35044e, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i10)), th2);
        }
    }

    private static List<Integer> e(Context context, JobScheduler jobScheduler, String str) {
        List<JobInfo> g10 = g(context, jobScheduler);
        if (g10 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo jobInfo : g10) {
            if (str.equals(h(jobInfo))) {
                arrayList.add(Integer.valueOf(jobInfo.getId()));
            }
        }
        return arrayList;
    }

    private static List<JobInfo> g(Context context, JobScheduler jobScheduler) {
        List<JobInfo> list;
        try {
            list = jobScheduler.getAllPendingJobs();
        } catch (Throwable th2) {
            k.c().b(f35044e, "getAllPendingJobs() is not reliable on this device.", th2);
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ComponentName componentName = new ComponentName(context, SystemJobService.class);
        for (JobInfo jobInfo : list) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    private static String h(JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return extras.getString("EXTRA_WORK_SPEC_ID");
            }
            return null;
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public static boolean i(Context context, i iVar) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        List<JobInfo> g10 = g(context, jobScheduler);
        List<String> a10 = iVar.n().J().a();
        boolean z10 = false;
        HashSet hashSet = new HashSet(g10 != null ? g10.size() : 0);
        if (g10 != null && !g10.isEmpty()) {
            for (JobInfo jobInfo : g10) {
                String h10 = h(jobInfo);
                if (!TextUtils.isEmpty(h10)) {
                    hashSet.add(h10);
                } else {
                    c(jobScheduler, jobInfo.getId());
                }
            }
        }
        Iterator<String> it = a10.iterator();
        while (true) {
            if (it.hasNext()) {
                if (!hashSet.contains(it.next())) {
                    k.c().a(f35044e, "Reconciling jobs", new Throwable[0]);
                    z10 = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (z10) {
            WorkDatabase n10 = iVar.n();
            n10.e();
            try {
                q M = n10.M();
                for (String str : a10) {
                    M.d(str, -1L);
                }
                n10.B();
            } finally {
                n10.i();
            }
        }
        return z10;
    }

    @Override // r1.e
    public boolean a() {
        return true;
    }

    @Override // r1.e
    public void d(String str) {
        List<Integer> e10 = e(this.f35045a, this.f35046b, str);
        if (!(e10 == null || e10.isEmpty())) {
            for (Integer num : e10) {
                c(this.f35046b, num.intValue());
            }
            this.f35047c.n().J().d(str);
        }
    }

    /* JADX WARN: Finally extract failed */
    @Override // r1.e
    public void f(p... pVarArr) {
        int i10;
        List<Integer> e10;
        int i11;
        WorkDatabase n10 = this.f35047c.n();
        c cVar = new c(n10);
        for (p pVar : pVarArr) {
            n10.e();
            try {
                p n11 = n10.M().n(pVar.f36689a);
                if (n11 == null) {
                    k.c().h(f35044e, "Skipping scheduling " + pVar.f36689a + " because it's no longer in the DB", new Throwable[0]);
                    n10.B();
                } else if (n11.f36690b != WorkInfo.State.ENQUEUED) {
                    k.c().h(f35044e, "Skipping scheduling " + pVar.f36689a + " because it is no longer enqueued", new Throwable[0]);
                    n10.B();
                } else {
                    g c10 = n10.J().c(pVar.f36689a);
                    if (c10 != null) {
                        i10 = c10.f36676b;
                    } else {
                        i10 = cVar.d(this.f35047c.h().i(), this.f35047c.h().g());
                    }
                    if (c10 == null) {
                        this.f35047c.n().J().b(new g(pVar.f36689a, i10));
                    }
                    j(pVar, i10);
                    if (Build.VERSION.SDK_INT == 23 && (e10 = e(this.f35045a, this.f35046b, pVar.f36689a)) != null) {
                        int indexOf = e10.indexOf(Integer.valueOf(i10));
                        if (indexOf >= 0) {
                            e10.remove(indexOf);
                        }
                        if (!e10.isEmpty()) {
                            i11 = e10.get(0).intValue();
                        } else {
                            i11 = cVar.d(this.f35047c.h().i(), this.f35047c.h().g());
                        }
                        j(pVar, i11);
                    }
                    n10.B();
                }
                n10.i();
            } catch (Throwable th2) {
                n10.i();
                throw th2;
            }
        }
    }

    public void j(p pVar, int i10) {
        JobInfo a10 = this.f35048d.a(pVar, i10);
        k c10 = k.c();
        String str = f35044e;
        c10.a(str, String.format("Scheduling work ID %s Job ID %s", pVar.f36689a, Integer.valueOf(i10)), new Throwable[0]);
        try {
            if (this.f35046b.schedule(a10) == 0) {
                k.c().h(str, String.format("Unable to schedule work ID %s", pVar.f36689a), new Throwable[0]);
                if (pVar.f36705q && pVar.f36706r == OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST) {
                    pVar.f36705q = false;
                    k.c().a(str, String.format("Scheduling a non-expedited job (work ID %s)", pVar.f36689a), new Throwable[0]);
                    j(pVar, i10);
                }
            }
        } catch (IllegalStateException e10) {
            List<JobInfo> g10 = g(this.f35045a, this.f35046b);
            String format = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", Integer.valueOf(g10 != null ? g10.size() : 0), Integer.valueOf(this.f35047c.n().M().h().size()), Integer.valueOf(this.f35047c.h().h()));
            k.c().b(f35044e, format, new Throwable[0]);
            throw new IllegalStateException(format, e10);
        } catch (Throwable th2) {
            k.c().b(f35044e, String.format("Unable to schedule %s", pVar), th2);
        }
    }

    public b(Context context, i iVar, JobScheduler jobScheduler, a aVar) {
        this.f35045a = context;
        this.f35047c = iVar;
        this.f35046b = jobScheduler;
        this.f35048d = aVar;
    }
}
