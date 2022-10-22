package com.liulishuo.filedownloader.download;

import android.os.Process;
import com.liulishuo.filedownloader.download.a;
import com.liulishuo.filedownloader.download.g;
import com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import java.io.IOException;
import java.net.SocketException;
import r9.c;
/* compiled from: DownloadRunnable.java */
/* loaded from: classes2.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final com.liulishuo.filedownloader.download.a f15146a;

    /* renamed from: b  reason: collision with root package name */
    private final h f15147b;

    /* renamed from: c  reason: collision with root package name */
    private final String f15148c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f15149d;

    /* renamed from: e  reason: collision with root package name */
    private g f15150e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f15151f;

    /* renamed from: g  reason: collision with root package name */
    private final int f15152g;

    /* renamed from: h  reason: collision with root package name */
    final int f15153h;

    /* compiled from: DownloadRunnable.java */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final a.b f15154a = new a.b();

        /* renamed from: b  reason: collision with root package name */
        private h f15155b;

        /* renamed from: c  reason: collision with root package name */
        private String f15156c;

        /* renamed from: d  reason: collision with root package name */
        private Boolean f15157d;

        /* renamed from: e  reason: collision with root package name */
        private Integer f15158e;

        public e a() {
            if (this.f15155b == null || this.f15156c == null || this.f15157d == null || this.f15158e == null) {
                throw new IllegalArgumentException(r9.e.n("%s %s %B", this.f15155b, this.f15156c, this.f15157d));
            }
            com.liulishuo.filedownloader.download.a a10 = this.f15154a.a();
            return new e(a10.f15090a, this.f15158e.intValue(), a10, this.f15155b, this.f15157d.booleanValue(), this.f15156c);
        }

        public b b(h hVar) {
            this.f15155b = hVar;
            return this;
        }

        public b c(Integer num) {
            this.f15158e = num;
            return this;
        }

        public b d(com.liulishuo.filedownloader.download.b bVar) {
            this.f15154a.b(bVar);
            return this;
        }

        public b e(String str) {
            this.f15154a.d(str);
            return this;
        }

        public b f(FileDownloadHeader fileDownloadHeader) {
            this.f15154a.e(fileDownloadHeader);
            return this;
        }

        public b g(int i10) {
            this.f15154a.c(i10);
            return this;
        }

        public b h(String str) {
            this.f15156c = str;
            return this;
        }

        public b i(String str) {
            this.f15154a.f(str);
            return this;
        }

        public b j(boolean z10) {
            this.f15157d = Boolean.valueOf(z10);
            return this;
        }
    }

    private long b() {
        k9.a f10 = c.i().f();
        if (this.f15153h < 0) {
            return f10.o(this.f15152g).g();
        }
        for (o9.a aVar : f10.n(this.f15152g)) {
            if (aVar.d() == this.f15153h) {
                return aVar.a();
            }
        }
        return 0L;
    }

    public void a() {
        c();
    }

    public void c() {
        this.f15151f = true;
        g gVar = this.f15150e;
        if (gVar != null) {
            gVar.b();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z10;
        Exception e10;
        g.b bVar;
        Process.setThreadPriority(10);
        long j10 = this.f15146a.f().f15103b;
        j9.b bVar2 = null;
        boolean z11 = false;
        while (!this.f15151f) {
            try {
                try {
                    bVar2 = this.f15146a.c();
                    int d10 = bVar2.d();
                    if (c.f33469a) {
                        c.a(this, "the connection[%d] for %d, is connected %s with code[%d]", Integer.valueOf(this.f15153h), Integer.valueOf(this.f15152g), this.f15146a.f(), Integer.valueOf(d10));
                    }
                    if (!(d10 == 206 || d10 == 200)) {
                        throw new SocketException(r9.e.n("Connection failed with request[%s] response[%s] http-state[%d] on task[%d-%d], which is changed after verify connection, so please try again.", this.f15146a.g(), bVar2.b(), Integer.valueOf(d10), Integer.valueOf(this.f15152g), Integer.valueOf(this.f15153h)));
                        break;
                    }
                    try {
                        bVar = new g.b();
                    } catch (FileDownloadGiveUpRetryException | IOException | IllegalAccessException | IllegalArgumentException e11) {
                        e10 = e11;
                        z10 = true;
                        try {
                            if (!this.f15147b.d(e10)) {
                                this.f15147b.onError(e10);
                                if (bVar2 == null) {
                                    return;
                                }
                            } else if (!z10 || this.f15150e != null) {
                                if (this.f15150e != null) {
                                    long b10 = b();
                                    if (b10 > 0) {
                                        this.f15146a.i(b10);
                                    }
                                }
                                this.f15147b.b(e10);
                                if (bVar2 != null) {
                                    bVar2.g();
                                }
                                z11 = z10;
                            } else {
                                c.i(this, "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s", e10);
                                this.f15147b.onError(e10);
                                if (bVar2 == null) {
                                    return;
                                }
                            }
                            bVar2.g();
                            return;
                        } finally {
                            if (bVar2 != null) {
                                bVar2.g();
                            }
                        }
                    }
                } catch (FileDownloadGiveUpRetryException | IOException | IllegalAccessException | IllegalArgumentException e12) {
                    e10 = e12;
                    z10 = false;
                }
            } catch (FileDownloadGiveUpRetryException | IOException | IllegalAccessException | IllegalArgumentException e13) {
                e10 = e13;
                z10 = z11;
            }
            if (this.f15151f) {
                bVar2.g();
                return;
            }
            g a10 = bVar.f(this.f15152g).d(this.f15153h).b(this.f15147b).g(this).i(this.f15149d).c(bVar2).e(this.f15146a.f()).h(this.f15148c).a();
            this.f15150e = a10;
            a10.c();
            if (this.f15151f) {
                this.f15150e.b();
            }
            bVar2.g();
            return;
        }
    }

    private e(int i10, int i11, com.liulishuo.filedownloader.download.a aVar, h hVar, boolean z10, String str) {
        this.f15152g = i10;
        this.f15153h = i11;
        this.f15151f = false;
        this.f15147b = hVar;
        this.f15148c = str;
        this.f15146a = aVar;
        this.f15149d = z10;
    }
}
