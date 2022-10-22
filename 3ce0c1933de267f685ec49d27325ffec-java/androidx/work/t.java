package androidx.work;

import android.content.Context;
/* compiled from: WorkerFactory.java */
/* loaded from: classes.dex */
public abstract class t {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4904a = k.f("WorkerFactory");

    /* compiled from: WorkerFactory.java */
    /* loaded from: classes.dex */
    class a extends t {
        a() {
        }

        @Override // androidx.work.t
        public ListenableWorker a(Context context, String str, WorkerParameters workerParameters) {
            return null;
        }
    }

    public static t c() {
        return new a();
    }

    public abstract ListenableWorker a(Context context, String str, WorkerParameters workerParameters);

    public final ListenableWorker b(Context context, String str, WorkerParameters workerParameters) {
        ListenableWorker a10 = a(context, str, workerParameters);
        if (a10 == null) {
            Class cls = null;
            try {
                cls = Class.forName(str).asSubclass(ListenableWorker.class);
            } catch (Throwable th2) {
                k c10 = k.c();
                String str2 = f4904a;
                c10.b(str2, "Invalid class: " + str, th2);
            }
            if (cls != null) {
                try {
                    a10 = (ListenableWorker) cls.getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(context, workerParameters);
                } catch (Throwable th3) {
                    k c11 = k.c();
                    String str3 = f4904a;
                    c11.b(str3, "Could not instantiate " + str, th3);
                }
            }
        }
        if (a10 == null || !a10.l()) {
            return a10;
        }
        throw new IllegalStateException(String.format("WorkerFactory (%s) returned an instance of a ListenableWorker (%s) which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.", getClass().getName(), str));
    }
}
