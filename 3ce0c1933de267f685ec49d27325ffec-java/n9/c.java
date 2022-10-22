package n9;

import com.liulishuo.filedownloader.message.MessageSnapshot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import n9.b;
/* compiled from: MessageSnapshotThreadPool.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final List<a> f31068a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final b.AbstractC0410b f31069b;

    /* compiled from: MessageSnapshotThreadPool.java */
    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<Integer> f31070a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final Executor f31071b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: MessageSnapshotThreadPool.java */
        /* renamed from: n9.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0411a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ MessageSnapshot f31073a;

            RunnableC0411a(MessageSnapshot messageSnapshot) {
                this.f31073a = messageSnapshot;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.f31069b.c(this.f31073a);
                a.this.f31070a.remove(Integer.valueOf(this.f31073a.a()));
            }
        }

        public a(int i10) {
            this.f31071b = r9.a.a(1, "Flow-" + i10);
        }

        public void b(int i10) {
            this.f31070a.add(Integer.valueOf(i10));
        }

        public void c(MessageSnapshot messageSnapshot) {
            this.f31071b.execute(new RunnableC0411a(messageSnapshot));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i10, b.AbstractC0410b bVar) {
        this.f31069b = bVar;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f31068a.add(new a(i11));
        }
    }

    public void b(MessageSnapshot messageSnapshot) {
        a aVar = null;
        try {
            synchronized (this.f31068a) {
                int a10 = messageSnapshot.a();
                Iterator<a> it = this.f31068a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (next.f31070a.contains(Integer.valueOf(a10))) {
                        aVar = next;
                        break;
                    }
                }
                if (aVar == null) {
                    int i10 = 0;
                    Iterator<a> it2 = this.f31068a.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        a next2 = it2.next();
                        if (next2.f31070a.size() <= 0) {
                            aVar = next2;
                            break;
                        } else if (i10 == 0 || next2.f31070a.size() < i10) {
                            i10 = next2.f31070a.size();
                            aVar = next2;
                        }
                    }
                }
                aVar.b(a10);
            }
        } finally {
            aVar.c(messageSnapshot);
        }
    }
}
