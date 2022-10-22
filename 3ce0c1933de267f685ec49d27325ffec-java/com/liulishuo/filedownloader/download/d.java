package com.liulishuo.filedownloader.download;

import android.os.Process;
import com.liulishuo.filedownloader.download.a;
import com.liulishuo.filedownloader.download.b;
import com.liulishuo.filedownloader.download.e;
import com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.liulishuo.filedownloader.exception.FileDownloadHttpException;
import com.liulishuo.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.liulishuo.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.liulishuo.filedownloader.exception.FileDownloadSecurityException;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import i9.f;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import r9.e;
/* compiled from: DownloadLaunchRunnable.java */
/* loaded from: classes2.dex */
public class d implements Runnable, h {

    /* renamed from: w  reason: collision with root package name */
    private static final ThreadPoolExecutor f15115w = r9.a.c("ConnectionBlock");

    /* renamed from: a  reason: collision with root package name */
    private final f f15116a;

    /* renamed from: b  reason: collision with root package name */
    private final FileDownloadModel f15117b;

    /* renamed from: c  reason: collision with root package name */
    private final FileDownloadHeader f15118c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f15119d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f15120e;

    /* renamed from: f  reason: collision with root package name */
    private final k9.a f15121f;

    /* renamed from: g  reason: collision with root package name */
    private final f f15122g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f15123h;

    /* renamed from: i  reason: collision with root package name */
    int f15124i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f15125j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f15126k;

    /* renamed from: l  reason: collision with root package name */
    private final ArrayList<e> f15127l;

    /* renamed from: m  reason: collision with root package name */
    private e f15128m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f15129n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f15130o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f15131p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f15132q;

    /* renamed from: r  reason: collision with root package name */
    private final AtomicBoolean f15133r;

    /* renamed from: s  reason: collision with root package name */
    private volatile boolean f15134s;

    /* renamed from: t  reason: collision with root package name */
    private volatile boolean f15135t;

    /* renamed from: u  reason: collision with root package name */
    private volatile Exception f15136u;

    /* renamed from: v  reason: collision with root package name */
    private String f15137v;

    /* compiled from: DownloadLaunchRunnable.java */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private FileDownloadModel f15138a;

        /* renamed from: b  reason: collision with root package name */
        private FileDownloadHeader f15139b;

        /* renamed from: c  reason: collision with root package name */
        private f f15140c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f15141d;

        /* renamed from: e  reason: collision with root package name */
        private Integer f15142e;

        /* renamed from: f  reason: collision with root package name */
        private Boolean f15143f;

        /* renamed from: g  reason: collision with root package name */
        private Boolean f15144g;

        /* renamed from: h  reason: collision with root package name */
        private Integer f15145h;

        public d a() {
            if (this.f15138a != null && this.f15140c != null && this.f15141d != null && this.f15142e != null && this.f15143f != null && this.f15144g != null && this.f15145h != null) {
                return new d(this.f15138a, this.f15139b, this.f15140c, this.f15141d.intValue(), this.f15142e.intValue(), this.f15143f.booleanValue(), this.f15144g.booleanValue(), this.f15145h.intValue());
            }
            throw new IllegalArgumentException();
        }

        public b b(Integer num) {
            this.f15142e = num;
            return this;
        }

        public b c(Boolean bool) {
            this.f15143f = bool;
            return this;
        }

        public b d(FileDownloadHeader fileDownloadHeader) {
            this.f15139b = fileDownloadHeader;
            return this;
        }

        public b e(Integer num) {
            this.f15145h = num;
            return this;
        }

        public b f(Integer num) {
            this.f15141d = num;
            return this;
        }

        public b g(FileDownloadModel fileDownloadModel) {
            this.f15138a = fileDownloadModel;
            return this;
        }

        public b h(f fVar) {
            this.f15140c = fVar;
            return this;
        }

        public b i(Boolean bool) {
            this.f15144g = bool;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadLaunchRunnable.java */
    /* loaded from: classes2.dex */
    public class c extends Throwable {
        c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadLaunchRunnable.java */
    /* renamed from: com.liulishuo.filedownloader.download.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0184d extends Throwable {
        C0184d() {
        }
    }

    private int f(long j10) {
        if (!p()) {
            return 1;
        }
        if (this.f15130o) {
            return this.f15117b.a();
        }
        return com.liulishuo.filedownloader.download.c.i().c(this.f15117b.e(), this.f15117b.l(), this.f15117b.f(), j10);
    }

    private void g() throws C0184d, c {
        int e10 = this.f15117b.e();
        if (this.f15117b.r()) {
            String i10 = this.f15117b.i();
            int q5 = e.q(this.f15117b.l(), i10);
            if (!r9.b.d(e10, i10, this.f15119d, false)) {
                FileDownloadModel o10 = this.f15121f.o(q5);
                if (o10 != null) {
                    if (!r9.b.e(e10, o10, this.f15122g, false)) {
                        List<o9.a> n10 = this.f15121f.n(q5);
                        this.f15121f.remove(q5);
                        this.f15121f.h(q5);
                        e.e(this.f15117b.i());
                        if (e.C(q5, o10)) {
                            this.f15117b.A(o10.g());
                            this.f15117b.C(o10.k());
                            this.f15117b.u(o10.b());
                            this.f15117b.t(o10.a());
                            this.f15121f.j(this.f15117b);
                            if (n10 != null) {
                                for (o9.a aVar : n10) {
                                    aVar.i(e10);
                                    this.f15121f.b(aVar);
                                }
                            }
                            throw new C0184d();
                        }
                    } else {
                        this.f15121f.remove(e10);
                        this.f15121f.h(e10);
                        throw new c();
                    }
                }
                if (r9.b.c(e10, this.f15117b.g(), this.f15117b.j(), i10, this.f15122g)) {
                    this.f15121f.remove(e10);
                    this.f15121f.h(e10);
                    throw new c();
                }
                return;
            }
            this.f15121f.remove(e10);
            this.f15121f.h(e10);
            throw new c();
        }
    }

    private void h() throws FileDownloadGiveUpRetryException {
        if (this.f15120e && !e.a("android.permission.ACCESS_NETWORK_STATE")) {
            throw new FileDownloadGiveUpRetryException(e.n("Task[%d] can't start the download runnable, because this task require wifi, but user application nor current process has %s, so we can't check whether the network type connection.", Integer.valueOf(this.f15117b.e()), "android.permission.ACCESS_NETWORK_STATE"));
        } else if (this.f15120e && e.I()) {
            throw new FileDownloadNetworkPolicyException();
        }
    }

    private void i(List<o9.a> list, long j10) throws InterruptedException {
        long j11;
        int e10 = this.f15117b.e();
        String str = this.f15117b.b();
        String str2 = this.f15137v;
        if (str2 == null) {
            str2 = this.f15117b.l();
        }
        String j12 = this.f15117b.j();
        if (r9.c.f33469a) {
            r9.c.a(this, "fetch data with multiple connection(count: [%d]) for task[%d] totalLength[%d]", Integer.valueOf(list.size()), Integer.valueOf(e10), Long.valueOf(j10));
        }
        boolean z10 = this.f15130o;
        long j13 = 0;
        long j14 = 0;
        for (o9.a aVar : list) {
            if (aVar.b() == -1) {
                j11 = j10 - aVar.a();
            } else {
                j11 = (aVar.b() - aVar.a()) + 1;
            }
            long j15 = j11;
            j14 += aVar.a() - aVar.e();
            if (j15 != j13) {
                e.b bVar = new e.b();
                com.liulishuo.filedownloader.download.b b10 = b.C0183b.b(aVar.e(), aVar.a(), aVar.b(), j15);
                e.b i10 = bVar.g(e10).c(Integer.valueOf(aVar.d())).b(this).i(str2);
                if (!z10) {
                    str = null;
                }
                e a10 = i10.e(str).f(this.f15118c).j(this.f15120e).d(b10).h(j12).a();
                if (r9.c.f33469a) {
                    r9.c.a(this, "enable multiple connection: %s", aVar);
                }
                if (a10 != null) {
                    this.f15127l.add(a10);
                } else {
                    throw new IllegalArgumentException("the download runnable must not be null!");
                }
            } else if (r9.c.f33469a) {
                r9.c.a(this, "pass connection[%d-%d], because it has been completed", Integer.valueOf(aVar.c()), Integer.valueOf(aVar.d()));
            }
            j13 = 0;
        }
        if (j14 != this.f15117b.g()) {
            r9.c.i(this, "correct the sofar[%d] from connection table[%d]", Long.valueOf(this.f15117b.g()), Long.valueOf(j14));
            this.f15117b.A(j14);
        }
        ArrayList arrayList = new ArrayList(this.f15127l.size());
        Iterator<e> it = this.f15127l.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (this.f15134s) {
                next.c();
            } else {
                arrayList.add(Executors.callable(next));
            }
        }
        if (this.f15134s) {
            this.f15117b.B((byte) -2);
            return;
        }
        List<Future> invokeAll = f15115w.invokeAll(arrayList);
        if (r9.c.f33469a) {
            for (Future future : invokeAll) {
                r9.c.a(this, "finish sub-task for [%d] %B %B", Integer.valueOf(e10), Boolean.valueOf(future.isDone()), Boolean.valueOf(future.isCancelled()));
            }
        }
    }

    private void l(long j10, String str) throws IOException, IllegalAccessException {
        q9.a aVar = null;
        if (j10 != -1) {
            try {
                aVar = r9.e.c(this.f15117b.j());
                long length = new File(str).length();
                long j11 = j10 - length;
                long u10 = r9.e.u(str);
                if (u10 < j11) {
                    throw new FileDownloadOutOfSpaceException(u10, j11, length);
                } else if (!r9.d.a().f33475f) {
                    aVar.a(j10);
                }
            } finally {
                if (0 != 0) {
                    aVar.close();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m(Map<String, List<String>> map, com.liulishuo.filedownloader.download.a aVar, j9.b bVar) throws IOException, C0184d, IllegalArgumentException, FileDownloadSecurityException {
        boolean z10;
        int e10 = this.f15117b.e();
        int d10 = bVar.d();
        this.f15131p = r9.e.B(d10, bVar);
        boolean z11 = d10 == 200 || d10 == 201 || d10 == 0;
        String b10 = this.f15117b.b();
        String j10 = r9.e.j(e10, bVar);
        if (d10 != 412 && ((b10 == 0 || b10.equals(j10) || (!z11 && !this.f15131p)) && (d10 != 201 || !aVar.h()))) {
            if (d10 == 416) {
                if (this.f15117b.g() <= 0) {
                    if (!this.f15125j) {
                        this.f15125j = true;
                    }
                }
            }
            z10 = false;
            if (!z10) {
                if (this.f15130o) {
                    r9.c.i(this, "there is precondition failed on this request[%d] with old etag[%s]、new etag[%s]、response code is %d", Integer.valueOf(e10), b10, j10, Integer.valueOf(d10));
                }
                this.f15121f.h(this.f15117b.e());
                r9.e.f(this.f15117b.i(), this.f15117b.j());
                this.f15130o = false;
                if (b10 != null && b10.equals(j10)) {
                    r9.c.i(this, "the old etag[%s] is the same to the new etag[%s], but the response status code is %d not Partial(206), so wo have to start this task from very beginning for task[%d]!", b10, j10, Integer.valueOf(d10), Integer.valueOf(e10));
                    j10 = null;
                }
                this.f15117b.A(0L);
                this.f15117b.C(0L);
                this.f15117b.u(j10);
                this.f15117b.s();
                this.f15121f.f(e10, this.f15117b.b(), this.f15117b.g(), this.f15117b.k(), this.f15117b.a());
                throw new C0184d();
            }
            this.f15137v = aVar.e();
            if (this.f15131p || z11) {
                long l10 = r9.e.l(bVar);
                String k10 = this.f15117b.r() ? r9.e.k(bVar, this.f15117b.l()) : null;
                this.f15132q = l10 == -1;
                this.f15116a.n(this.f15130o && this.f15131p, l10, j10, k10);
                return;
            }
            throw new FileDownloadHttpException(d10, map, bVar.b());
        }
        z10 = true;
        if (!z10) {
        }
    }

    private boolean p() {
        return (!this.f15130o || this.f15117b.a() > 1) && this.f15131p && this.f15126k && !this.f15132q;
    }

    private void s(long j10, int i10) throws InterruptedException {
        long j11 = j10 / i10;
        int e10 = this.f15117b.e();
        ArrayList arrayList = new ArrayList();
        long j12 = 0;
        int i11 = 0;
        while (i11 < i10) {
            long j13 = i11 == i10 + (-1) ? -1L : (j12 + j11) - 1;
            o9.a aVar = new o9.a();
            aVar.i(e10);
            aVar.j(i11);
            aVar.k(j12);
            aVar.g(j12);
            aVar.h(j13);
            arrayList.add(aVar);
            this.f15121f.b(aVar);
            j12 += j11;
            i11++;
        }
        this.f15117b.t(i10);
        this.f15121f.p(e10, i10);
        i(arrayList, j10);
    }

    private void t(int i10, List<o9.a> list) throws InterruptedException {
        if (i10 <= 1 || list.size() != i10) {
            throw new IllegalArgumentException();
        }
        i(list, this.f15117b.k());
    }

    private void u(long j10) throws IOException, IllegalAccessException {
        com.liulishuo.filedownloader.download.b bVar;
        if (!this.f15131p) {
            this.f15117b.A(0L);
            bVar = b.C0183b.a(j10);
        } else {
            bVar = b.C0183b.c(this.f15117b.g(), this.f15117b.g(), j10 - this.f15117b.g());
        }
        this.f15128m = new e.b().g(this.f15117b.e()).c(-1).b(this).i(this.f15117b.l()).e(this.f15117b.b()).f(this.f15118c).j(this.f15120e).d(bVar).h(this.f15117b.j()).a();
        this.f15117b.t(1);
        this.f15121f.p(this.f15117b.e(), 1);
        if (this.f15134s) {
            this.f15117b.B((byte) -2);
            this.f15128m.c();
            return;
        }
        this.f15128m.run();
    }

    private void v() throws IOException, C0184d, IllegalAccessException, FileDownloadSecurityException {
        com.liulishuo.filedownloader.download.b bVar;
        j9.b bVar2 = null;
        try {
            if (this.f15125j) {
                bVar = b.C0183b.e();
            } else {
                bVar = b.C0183b.d();
            }
            com.liulishuo.filedownloader.download.a a10 = new a.b().c(this.f15117b.e()).f(this.f15117b.l()).d(this.f15117b.b()).e(this.f15118c).b(bVar).a();
            bVar2 = a10.c();
            m(a10.g(), a10, bVar2);
        } finally {
            if (bVar2 != null) {
                bVar2.g();
            }
        }
    }

    @Override // com.liulishuo.filedownloader.download.h
    public void a(e eVar, long j10, long j11) {
        if (!this.f15134s) {
            int i10 = eVar.f15153h;
            if (r9.c.f33469a) {
                r9.c.a(this, "the connection has been completed(%d): [%d, %d)  %d", Integer.valueOf(i10), Long.valueOf(j10), Long.valueOf(j11), Long.valueOf(this.f15117b.k()));
            }
            if (!this.f15129n) {
                synchronized (this.f15127l) {
                    this.f15127l.remove(eVar);
                }
            } else if (j10 != 0 && j11 != this.f15117b.k()) {
                r9.c.b(this, "the single task not completed corrected(%d, %d != %d) for task(%d)", Long.valueOf(j10), Long.valueOf(j11), Long.valueOf(this.f15117b.k()), Integer.valueOf(this.f15117b.e()));
            }
        } else if (r9.c.f33469a) {
            r9.c.a(this, "the task[%d] has already been paused, so pass the completed callback", Integer.valueOf(this.f15117b.e()));
        }
    }

    @Override // com.liulishuo.filedownloader.download.h
    public void b(Exception exc) {
        if (!this.f15134s) {
            int i10 = this.f15124i;
            int i11 = i10 - 1;
            this.f15124i = i11;
            if (i10 < 0) {
                r9.c.b(this, "valid retry times is less than 0(%d) for download task(%d)", Integer.valueOf(i11), Integer.valueOf(this.f15117b.e()));
            }
            this.f15116a.t(exc, this.f15124i);
        } else if (r9.c.f33469a) {
            r9.c.a(this, "the task[%d] has already been paused, so pass the retry callback", Integer.valueOf(this.f15117b.e()));
        }
    }

    @Override // com.liulishuo.filedownloader.download.h
    public void c(long j10) {
        if (!this.f15134s) {
            this.f15116a.s(j10);
        }
    }

    @Override // com.liulishuo.filedownloader.download.h
    public boolean d(Exception exc) {
        if (exc instanceof FileDownloadHttpException) {
            int code = ((FileDownloadHttpException) exc).getCode();
            if (this.f15129n && code == 416 && !this.f15123h) {
                r9.e.f(this.f15117b.i(), this.f15117b.j());
                this.f15123h = true;
                return true;
            }
        }
        return this.f15124i > 0 && !(exc instanceof FileDownloadGiveUpRetryException);
    }

    @Override // com.liulishuo.filedownloader.download.h
    public void e() {
        this.f15121f.l(this.f15117b.e(), this.f15117b.g());
    }

    public int j() {
        return this.f15117b.e();
    }

    public String k() {
        return this.f15117b.j();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void n(List<o9.a> list) {
        long j10;
        int a10 = this.f15117b.a();
        String j11 = this.f15117b.j();
        String i10 = this.f15117b.i();
        boolean z10 = false;
        boolean z11 = a10 > 1;
        if (!this.f15125j && ((!z11 || this.f15126k) && r9.e.C(this.f15117b.e(), this.f15117b))) {
            if (!this.f15126k) {
                j10 = new File(j11).length();
            } else if (!z11) {
                j10 = this.f15117b.g();
            } else if (a10 == list.size()) {
                j10 = o9.a.f(list);
            }
            this.f15117b.A(j10);
            if (j10 > 0) {
                z10 = true;
            }
            this.f15130o = z10;
            if (z10) {
                this.f15121f.h(this.f15117b.e());
                r9.e.f(i10, j11);
                return;
            }
            return;
        }
        j10 = 0;
        this.f15117b.A(j10);
        if (j10 > 0) {
        }
        this.f15130o = z10;
        if (z10) {
        }
    }

    public boolean o() {
        return this.f15133r.get() || this.f15116a.l();
    }

    @Override // com.liulishuo.filedownloader.download.h
    public void onError(Exception exc) {
        this.f15135t = true;
        this.f15136u = exc;
        if (!this.f15134s) {
            Iterator it = ((ArrayList) this.f15127l.clone()).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                if (eVar != null) {
                    eVar.a();
                }
            }
        } else if (r9.c.f33469a) {
            r9.c.a(this, "the task[%d] has already been paused, so pass the error callback", Integer.valueOf(this.f15117b.e()));
        }
    }

    public void q() {
        this.f15134s = true;
        e eVar = this.f15128m;
        if (eVar != null) {
            eVar.c();
        }
        Iterator it = ((ArrayList) this.f15127l.clone()).iterator();
        while (it.hasNext()) {
            e eVar2 = (e) it.next();
            if (eVar2 != null) {
                eVar2.c();
            }
        }
    }

    public void r() {
        n(this.f15121f.n(this.f15117b.e()));
        this.f15116a.r();
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x01c5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01c0 A[Catch: all -> 0x01f5, TryCatch #12 {all -> 0x01f5, blocks: (B:3:0x0003, B:6:0x0012, B:8:0x001a, B:10:0x001e, B:11:0x0030, B:23:0x008d, B:25:0x0091, B:26:0x0096, B:28:0x009a, B:30:0x009e, B:37:0x00c6, B:39:0x00e2, B:46:0x0100, B:56:0x0136, B:58:0x013a, B:68:0x015f, B:70:0x0163, B:71:0x0167, B:73:0x0170, B:74:0x0174, B:75:0x0178, B:76:0x018b, B:77:0x018c, B:90:0x01ba, B:92:0x01c0, B:93:0x01c5), top: B:127:0x0003, inners: #16, #12, #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01d7  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Exception e10;
        List<o9.a> n10;
        try {
            Process.setThreadPriority(10);
            if (this.f15117b.h() != 1) {
                if (this.f15117b.h() != -2) {
                    onError(new RuntimeException(r9.e.n("Task[%d] can't start the download runnable, because its status is %d not %d", Integer.valueOf(this.f15117b.e()), Byte.valueOf(this.f15117b.h()), (byte) 1)));
                } else if (r9.c.f33469a) {
                    r9.c.a(this, "High concurrent cause, start runnable but already paused %d", Integer.valueOf(this.f15117b.e()));
                }
                this.f15116a.b();
                if (!this.f15134s) {
                    if (!this.f15135t) {
                        try {
                            this.f15116a.m();
                        } catch (IOException e11) {
                            e = e11;
                            this.f15116a.o(e);
                            this.f15133r.set(false);
                        }
                        this.f15133r.set(false);
                    }
                    this.f15116a.o(this.f15136u);
                    this.f15133r.set(false);
                }
                this.f15116a.q();
                this.f15133r.set(false);
            }
            if (!this.f15134s) {
                this.f15116a.u();
            }
            while (!this.f15134s) {
                try {
                    h();
                    v();
                    g();
                    n10 = this.f15121f.n(this.f15117b.e());
                    n(n10);
                } catch (c unused) {
                    this.f15116a.b();
                    if (!this.f15134s) {
                        if (!this.f15135t) {
                            try {
                                this.f15116a.m();
                            } catch (IOException e12) {
                                e = e12;
                                this.f15116a.o(e);
                                this.f15133r.set(false);
                            }
                        }
                    }
                } catch (C0184d unused2) {
                    this.f15117b.B((byte) 5);
                } catch (FileDownloadGiveUpRetryException e13) {
                    e10 = e13;
                    if (!d(e10)) {
                        b(e10);
                    } else {
                        onError(e10);
                        this.f15116a.b();
                        if (!this.f15134s) {
                        }
                        this.f15133r.set(false);
                        return;
                    }
                } catch (FileDownloadSecurityException e14) {
                    e10 = e14;
                    if (!d(e10)) {
                    }
                } catch (IOException e15) {
                    e10 = e15;
                    if (!d(e10)) {
                    }
                } catch (IllegalAccessException e16) {
                    e10 = e16;
                    if (!d(e10)) {
                    }
                } catch (IllegalArgumentException e17) {
                    e10 = e17;
                    if (!d(e10)) {
                    }
                } catch (InterruptedException e18) {
                    e10 = e18;
                    if (!d(e10)) {
                    }
                }
                if (this.f15134s) {
                    this.f15117b.B((byte) -2);
                    this.f15116a.b();
                    if (!this.f15134s) {
                        if (!this.f15135t) {
                            try {
                                this.f15116a.m();
                            } catch (IOException e19) {
                                e = e19;
                                this.f15116a.o(e);
                                this.f15133r.set(false);
                            }
                            this.f15133r.set(false);
                        }
                        this.f15116a.o(this.f15136u);
                        this.f15133r.set(false);
                    }
                    this.f15116a.q();
                    this.f15133r.set(false);
                }
                long k10 = this.f15117b.k();
                l(k10, this.f15117b.j());
                int f10 = f(k10);
                if (f10 <= 0) {
                    throw new IllegalAccessException(r9.e.n("invalid connection count %d, the connection count must be larger than 0", Integer.valueOf(f10)));
                } else if (k10 == 0) {
                    this.f15116a.b();
                    if (!this.f15134s) {
                        if (!this.f15135t) {
                            try {
                                this.f15116a.m();
                            } catch (IOException e20) {
                                e = e20;
                                this.f15116a.o(e);
                                this.f15133r.set(false);
                            }
                            this.f15133r.set(false);
                        }
                        this.f15116a.o(this.f15136u);
                        this.f15133r.set(false);
                    }
                    this.f15116a.q();
                    this.f15133r.set(false);
                } else if (this.f15134s) {
                    this.f15117b.B((byte) -2);
                    this.f15116a.b();
                    if (!this.f15134s) {
                        if (!this.f15135t) {
                            try {
                                this.f15116a.m();
                            } catch (IOException e21) {
                                e = e21;
                                this.f15116a.o(e);
                                this.f15133r.set(false);
                            }
                            this.f15133r.set(false);
                        }
                        this.f15116a.o(this.f15136u);
                        this.f15133r.set(false);
                    }
                    this.f15116a.q();
                    this.f15133r.set(false);
                } else {
                    boolean z10 = f10 == 1;
                    this.f15129n = z10;
                    if (z10) {
                        u(k10);
                    } else {
                        this.f15116a.p();
                        if (this.f15130o) {
                            t(f10, n10);
                        } else {
                            s(k10, f10);
                        }
                    }
                    this.f15116a.b();
                    if (!this.f15134s) {
                        this.f15116a.q();
                    } else if (this.f15135t) {
                        this.f15116a.o(this.f15136u);
                    } else {
                        try {
                            this.f15116a.m();
                        } catch (IOException e22) {
                            this.f15116a.o(e22);
                        }
                    }
                    this.f15133r.set(false);
                    return;
                }
            }
            if (r9.c.f33469a) {
                r9.c.a(this, "High concurrent cause, start runnable but already paused %d", Integer.valueOf(this.f15117b.e()));
            }
            this.f15116a.b();
            if (!this.f15134s) {
                if (!this.f15135t) {
                    try {
                        this.f15116a.m();
                    } catch (IOException e23) {
                        e = e23;
                        this.f15116a.o(e);
                        this.f15133r.set(false);
                    }
                    this.f15133r.set(false);
                }
                this.f15116a.o(this.f15136u);
                this.f15133r.set(false);
            }
            this.f15116a.q();
            this.f15133r.set(false);
        } catch (Throwable th2) {
            this.f15116a.b();
            if (this.f15134s) {
                this.f15116a.q();
            } else if (this.f15135t) {
                this.f15116a.o(this.f15136u);
            } else {
                try {
                    this.f15116a.m();
                } catch (IOException e24) {
                    this.f15116a.o(e24);
                }
            }
            this.f15133r.set(false);
            throw th2;
        }
    }

    private d(FileDownloadModel fileDownloadModel, FileDownloadHeader fileDownloadHeader, f fVar, int i10, int i11, boolean z10, boolean z11, int i12) {
        this.f15125j = false;
        this.f15127l = new ArrayList<>(5);
        this.f15133r = new AtomicBoolean(true);
        this.f15134s = false;
        this.f15123h = false;
        this.f15117b = fileDownloadModel;
        this.f15118c = fileDownloadHeader;
        this.f15119d = z10;
        this.f15120e = z11;
        this.f15121f = com.liulishuo.filedownloader.download.c.i().f();
        this.f15126k = com.liulishuo.filedownloader.download.c.i().l();
        this.f15122g = fVar;
        this.f15124i = i12;
        this.f15116a = new f(fileDownloadModel, i12, i10, i11);
    }
}
