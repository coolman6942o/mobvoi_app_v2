package l9;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Executor;
import r9.c;
/* compiled from: DownloadEventPoolImpl.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f30439a = r9.a.a(10, "EventPool");

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, LinkedList<c>> f30440b = new HashMap<>();

    /* compiled from: DownloadEventPoolImpl.java */
    /* renamed from: l9.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class RunnableC0381a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f30441a;

        RunnableC0381a(b bVar) {
            this.f30441a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b(this.f30441a);
        }
    }

    private void c(LinkedList<c> linkedList, b bVar) {
        Object[] array;
        for (Object obj : linkedList.toArray()) {
            if (obj != null && ((c) obj).a(bVar)) {
                break;
            }
        }
        Runnable runnable = bVar.f30443a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public void a(b bVar) {
        if (c.f33469a) {
            c.h(this, "asyncPublishInNewThread %s", bVar.a());
        }
        if (bVar != null) {
            this.f30439a.execute(new RunnableC0381a(bVar));
            return;
        }
        throw new IllegalArgumentException("event must not be null!");
    }

    public boolean b(b bVar) {
        if (c.f33469a) {
            c.h(this, "publish %s", bVar.a());
        }
        if (bVar != null) {
            String a10 = bVar.a();
            LinkedList<c> linkedList = this.f30440b.get(a10);
            if (linkedList == null) {
                synchronized (a10.intern()) {
                    linkedList = this.f30440b.get(a10);
                    if (linkedList == null) {
                        if (c.f33469a) {
                            c.a(this, "No listener for this event %s", a10);
                        }
                        return false;
                    }
                }
            }
            c(linkedList, bVar);
            return true;
        }
        throw new IllegalArgumentException("event must not be null!");
    }
}
