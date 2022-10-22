package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import com.mobvoi.wear.util.LogCleaner;
import java.util.ArrayList;
import java.util.HashMap;
/* compiled from: JobIntentService.java */
@Deprecated
/* loaded from: classes.dex */
public abstract class g extends Service {

    /* renamed from: g  reason: collision with root package name */
    static final Object f2255g = new Object();

    /* renamed from: h  reason: collision with root package name */
    static final HashMap<ComponentName, h> f2256h = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    b f2257a;

    /* renamed from: b  reason: collision with root package name */
    h f2258b;

    /* renamed from: c  reason: collision with root package name */
    a f2259c;

    /* renamed from: d  reason: collision with root package name */
    boolean f2260d = false;

    /* renamed from: e  reason: collision with root package name */
    boolean f2261e = false;

    /* renamed from: f  reason: collision with root package name */
    final ArrayList<d> f2262f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JobIntentService.java */
    /* loaded from: classes.dex */
    public final class a extends AsyncTask<Void, Void, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                e a10 = g.this.a();
                if (a10 == null) {
                    return null;
                }
                g.this.g(a10.getIntent());
                a10.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: b */
        public void onCancelled(Void r12) {
            g.this.i();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: c */
        public void onPostExecute(Void r12) {
            g.this.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JobIntentService.java */
    /* loaded from: classes.dex */
    public interface b {
        IBinder a();

        e b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JobIntentService.java */
    /* loaded from: classes.dex */
    public static final class c extends h {

        /* renamed from: d  reason: collision with root package name */
        private final Context f2264d;

        /* renamed from: e  reason: collision with root package name */
        private final PowerManager.WakeLock f2265e;

        /* renamed from: f  reason: collision with root package name */
        private final PowerManager.WakeLock f2266f;

        /* renamed from: g  reason: collision with root package name */
        boolean f2267g;

        /* renamed from: h  reason: collision with root package name */
        boolean f2268h;

        c(Context context, ComponentName componentName) {
            super(componentName);
            this.f2264d = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f2265e = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f2266f = newWakeLock2;
            newWakeLock2.setReferenceCounted(false);
        }

        @Override // androidx.core.app.g.h
        void a(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.f2279a);
            if (this.f2264d.startService(intent2) != null) {
                synchronized (this) {
                    if (!this.f2267g) {
                        this.f2267g = true;
                        if (!this.f2268h) {
                            this.f2265e.acquire(LogCleaner.ONE_MINUTE);
                        }
                    }
                }
            }
        }

        @Override // androidx.core.app.g.h
        public void c() {
            synchronized (this) {
                if (this.f2268h) {
                    if (this.f2267g) {
                        this.f2265e.acquire(LogCleaner.ONE_MINUTE);
                    }
                    this.f2268h = false;
                    this.f2266f.release();
                }
            }
        }

        @Override // androidx.core.app.g.h
        public void d() {
            synchronized (this) {
                if (!this.f2268h) {
                    this.f2268h = true;
                    this.f2266f.acquire(600000L);
                    this.f2265e.release();
                }
            }
        }

        @Override // androidx.core.app.g.h
        public void e() {
            synchronized (this) {
                this.f2267g = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JobIntentService.java */
    /* loaded from: classes.dex */
    public final class d implements e {

        /* renamed from: a  reason: collision with root package name */
        final Intent f2269a;

        /* renamed from: b  reason: collision with root package name */
        final int f2270b;

        d(Intent intent, int i10) {
            this.f2269a = intent;
            this.f2270b = i10;
        }

        @Override // androidx.core.app.g.e
        public void a() {
            g.this.stopSelf(this.f2270b);
        }

        @Override // androidx.core.app.g.e
        public Intent getIntent() {
            return this.f2269a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JobIntentService.java */
    /* loaded from: classes.dex */
    public interface e {
        void a();

        Intent getIntent();
    }

    /* compiled from: JobIntentService.java */
    /* loaded from: classes.dex */
    static final class f extends JobServiceEngine implements b {

        /* renamed from: a  reason: collision with root package name */
        final g f2272a;

        /* renamed from: b  reason: collision with root package name */
        final Object f2273b = new Object();

        /* renamed from: c  reason: collision with root package name */
        JobParameters f2274c;

        /* compiled from: JobIntentService.java */
        /* loaded from: classes.dex */
        final class a implements e {

            /* renamed from: a  reason: collision with root package name */
            final JobWorkItem f2275a;

            a(JobWorkItem jobWorkItem) {
                this.f2275a = jobWorkItem;
            }

            @Override // androidx.core.app.g.e
            public void a() {
                synchronized (f.this.f2273b) {
                    JobParameters jobParameters = f.this.f2274c;
                    if (jobParameters != null) {
                        jobParameters.completeWork(this.f2275a);
                    }
                }
            }

            @Override // androidx.core.app.g.e
            public Intent getIntent() {
                return this.f2275a.getIntent();
            }
        }

        f(g gVar) {
            super(gVar);
            this.f2272a = gVar;
        }

        @Override // androidx.core.app.g.b
        public IBinder a() {
            return getBinder();
        }

        @Override // androidx.core.app.g.b
        public e b() {
            synchronized (this.f2273b) {
                JobParameters jobParameters = this.f2274c;
                if (jobParameters == null) {
                    return null;
                }
                JobWorkItem dequeueWork = jobParameters.dequeueWork();
                if (dequeueWork == null) {
                    return null;
                }
                dequeueWork.getIntent().setExtrasClassLoader(this.f2272a.getClassLoader());
                return new a(dequeueWork);
            }
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters jobParameters) {
            this.f2274c = jobParameters;
            this.f2272a.e(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters jobParameters) {
            boolean b10 = this.f2272a.b();
            synchronized (this.f2273b) {
                this.f2274c = null;
            }
            return b10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JobIntentService.java */
    /* renamed from: androidx.core.app.g$g  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0016g extends h {

        /* renamed from: d  reason: collision with root package name */
        private final JobInfo f2277d;

        /* renamed from: e  reason: collision with root package name */
        private final JobScheduler f2278e;

        C0016g(Context context, ComponentName componentName, int i10) {
            super(componentName);
            b(i10);
            this.f2277d = new JobInfo.Builder(i10, this.f2279a).setOverrideDeadline(0L).build();
            this.f2278e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        @Override // androidx.core.app.g.h
        void a(Intent intent) {
            this.f2278e.enqueue(this.f2277d, new JobWorkItem(intent));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JobIntentService.java */
    /* loaded from: classes.dex */
    public static abstract class h {

        /* renamed from: a  reason: collision with root package name */
        final ComponentName f2279a;

        /* renamed from: b  reason: collision with root package name */
        boolean f2280b;

        /* renamed from: c  reason: collision with root package name */
        int f2281c;

        h(ComponentName componentName) {
            this.f2279a = componentName;
        }

        abstract void a(Intent intent);

        void b(int i10) {
            if (!this.f2280b) {
                this.f2280b = true;
                this.f2281c = i10;
            } else if (this.f2281c != i10) {
                throw new IllegalArgumentException("Given job ID " + i10 + " is different than previous " + this.f2281c);
            }
        }

        public void c() {
        }

        public void d() {
        }

        public void e() {
        }
    }

    public g() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2262f = null;
        } else {
            this.f2262f = new ArrayList<>();
        }
    }

    public static void c(Context context, ComponentName componentName, int i10, Intent intent) {
        if (intent != null) {
            synchronized (f2255g) {
                h f10 = f(context, componentName, true, i10);
                f10.b(i10);
                f10.a(intent);
            }
            return;
        }
        throw new IllegalArgumentException("work must not be null");
    }

    public static void d(Context context, Class<?> cls, int i10, Intent intent) {
        c(context, new ComponentName(context, cls), i10, intent);
    }

    static h f(Context context, ComponentName componentName, boolean z10, int i10) {
        h hVar;
        HashMap<ComponentName, h> hashMap = f2256h;
        h hVar2 = hashMap.get(componentName);
        if (hVar2 != null) {
            return hVar2;
        }
        if (Build.VERSION.SDK_INT < 26) {
            hVar = new c(context, componentName);
        } else if (z10) {
            hVar = new C0016g(context, componentName, i10);
        } else {
            throw new IllegalArgumentException("Can't be here without a job id");
        }
        h hVar3 = hVar;
        hashMap.put(componentName, hVar3);
        return hVar3;
    }

    e a() {
        b bVar = this.f2257a;
        if (bVar != null) {
            return bVar.b();
        }
        synchronized (this.f2262f) {
            if (this.f2262f.size() <= 0) {
                return null;
            }
            return this.f2262f.remove(0);
        }
    }

    boolean b() {
        a aVar = this.f2259c;
        if (aVar != null) {
            aVar.cancel(this.f2260d);
        }
        return h();
    }

    void e(boolean z10) {
        if (this.f2259c == null) {
            this.f2259c = new a();
            h hVar = this.f2258b;
            if (hVar != null && z10) {
                hVar.d();
            }
            this.f2259c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    protected abstract void g(Intent intent);

    public boolean h() {
        return true;
    }

    void i() {
        ArrayList<d> arrayList = this.f2262f;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f2259c = null;
                ArrayList<d> arrayList2 = this.f2262f;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    e(false);
                } else if (!this.f2261e) {
                    this.f2258b.c();
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        b bVar = this.f2257a;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2257a = new f(this);
            this.f2258b = null;
            return;
        }
        this.f2257a = null;
        this.f2258b = f(this, new ComponentName(this, getClass()), false, 0);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList<d> arrayList = this.f2262f;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f2261e = true;
                this.f2258b.c();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        if (this.f2262f == null) {
            return 2;
        }
        this.f2258b.e();
        synchronized (this.f2262f) {
            ArrayList<d> arrayList = this.f2262f;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new d(intent, i11));
            e(true);
        }
        return 3;
    }
}
