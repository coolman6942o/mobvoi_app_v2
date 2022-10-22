package com.liulishuo.filedownloader.download;

import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import k9.a;
import p9.b;
import r9.b;
import r9.e;
/* compiled from: CustomComponentHolder.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private b f15108a;

    /* renamed from: b  reason: collision with root package name */
    private b.a f15109b;

    /* renamed from: c  reason: collision with root package name */
    private b.AbstractC0460b f15110c;

    /* renamed from: d  reason: collision with root package name */
    private b.d f15111d;

    /* renamed from: e  reason: collision with root package name */
    private k9.a f15112e;

    /* renamed from: f  reason: collision with root package name */
    private b.c f15113f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CustomComponentHolder.java */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final c f15114a = new c();
    }

    private b.a d() {
        b.a aVar = this.f15109b;
        if (aVar != null) {
            return aVar;
        }
        synchronized (this) {
            if (this.f15109b == null) {
                this.f15109b = g().a();
            }
        }
        return this.f15109b;
    }

    private b.AbstractC0460b e() {
        b.AbstractC0460b bVar = this.f15110c;
        if (bVar != null) {
            return bVar;
        }
        synchronized (this) {
            if (this.f15110c == null) {
                this.f15110c = g().b();
            }
        }
        return this.f15110c;
    }

    private p9.b g() {
        p9.b bVar = this.f15108a;
        if (bVar != null) {
            return bVar;
        }
        synchronized (this) {
            if (this.f15108a == null) {
                this.f15108a = new p9.b();
            }
        }
        return this.f15108a;
    }

    public static c i() {
        return a.f15114a;
    }

    private b.d k() {
        b.d dVar = this.f15111d;
        if (dVar != null) {
            return dVar;
        }
        synchronized (this) {
            if (this.f15111d == null) {
                this.f15111d = g().j();
            }
        }
        return this.f15111d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0051, code lost:
        if (r8.g() <= 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d4, code lost:
        if (r8.g() > 0) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0065 A[Catch: all -> 0x0141, TryCatch #0 {all -> 0x0141, blocks: (B:9:0x0034, B:11:0x003b, B:13:0x0042, B:15:0x0049, B:17:0x0053, B:18:0x0056, B:21:0x0065, B:23:0x0070), top: B:80:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cc A[Catch: all -> 0x013f, TryCatch #3 {all -> 0x013f, blocks: (B:35:0x00a3, B:40:0x00c5, B:42:0x00cc, B:46:0x00da, B:49:0x00e5, B:55:0x00f1, B:56:0x00fb, B:58:0x0111, B:60:0x0115, B:61:0x012d, B:62:0x0134), top: B:86:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f1 A[Catch: all -> 0x013f, TryCatch #3 {all -> 0x013f, blocks: (B:35:0x00a3, B:40:0x00c5, B:42:0x00cc, B:46:0x00da, B:49:0x00e5, B:55:0x00f1, B:56:0x00fb, B:58:0x0111, B:60:0x0115, B:61:0x012d, B:62:0x0134), top: B:86:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00fb A[Catch: all -> 0x013f, TryCatch #3 {all -> 0x013f, blocks: (B:35:0x00a3, B:40:0x00c5, B:42:0x00cc, B:46:0x00da, B:49:0x00e5, B:55:0x00f1, B:56:0x00fb, B:58:0x0111, B:60:0x0115, B:61:0x012d, B:62:0x0134), top: B:86:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x019b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void m(a.AbstractC0365a aVar) {
        long j10;
        long j11;
        Throwable th2;
        String i10;
        boolean z10;
        String str = "refreshed data count: %d , delete data count: %d, reset id count: %d. consume %d";
        Iterator<FileDownloadModel> it = aVar.iterator();
        b.c h10 = i().h();
        long currentTimeMillis = System.currentTimeMillis();
        long j12 = 0;
        long j13 = 0;
        long j14 = 0;
        while (it.hasNext()) {
            try {
                FileDownloadModel next = it.next();
                String str2 = str;
                if (next.h() != 3) {
                    try {
                        if (next.h() != 2) {
                            if (next.h() != -1) {
                                if (next.h() == 1) {
                                }
                                i10 = next.i();
                                if (i10 != null) {
                                    j11 = currentTimeMillis;
                                    j10 = j12;
                                    z10 = true;
                                } else {
                                    File file = new File(i10);
                                    if (next.h() == -2) {
                                        j11 = currentTimeMillis;
                                        try {
                                            if (e.E(next.e(), next, next.f(), null)) {
                                                File file2 = new File(next.j());
                                                if (!file2.exists() && file.exists()) {
                                                    boolean renameTo = file.renameTo(file2);
                                                    if (r9.c.f33469a) {
                                                        j10 = j12;
                                                        try {
                                                            r9.c.a(k9.a.class, "resume from the old no-temp-file architecture [%B], [%s]->[%s]", Boolean.valueOf(renameTo), file.getPath(), file2.getPath());
                                                            if (next.h() != 1) {
                                                            }
                                                            if (e.C(next.e(), next) && !file.exists()) {
                                                                z10 = false;
                                                            }
                                                            z10 = true;
                                                        } catch (Throwable th3) {
                                                            th2 = th3;
                                                            str = str2;
                                                            e.J(r9.b.a());
                                                            aVar.t0();
                                                            if (r9.c.f33469a) {
                                                            }
                                                            throw th2;
                                                        }
                                                    }
                                                }
                                            }
                                        } catch (Throwable th4) {
                                            th2 = th4;
                                            j10 = j12;
                                            str = str2;
                                            e.J(r9.b.a());
                                            aVar.t0();
                                            if (r9.c.f33469a) {
                                            }
                                            throw th2;
                                        }
                                    } else {
                                        j11 = currentTimeMillis;
                                    }
                                    j10 = j12;
                                    if (next.h() != 1) {
                                    }
                                    if (e.C(next.e(), next)) {
                                        z10 = false;
                                    }
                                    z10 = true;
                                }
                                if (!z10) {
                                    it.remove();
                                    aVar.x(next);
                                    j13++;
                                    j12 = j10;
                                } else {
                                    int e10 = next.e();
                                    int b10 = h10.b(e10, next.l(), next.f(), next.r());
                                    if (b10 != e10) {
                                        if (r9.c.f33469a) {
                                            r9.c.a(k9.a.class, "the id is changed on restoring from db: old[%d] -> new[%d]", Integer.valueOf(e10), Integer.valueOf(b10));
                                        }
                                        next.y(b10);
                                        aVar.I(e10, next);
                                        j14++;
                                    }
                                    aVar.E(next);
                                    j12 = j10 + 1;
                                }
                                str = str2;
                                currentTimeMillis = j11;
                            }
                        }
                    } catch (Throwable th5) {
                        th2 = th5;
                        j11 = currentTimeMillis;
                        j10 = j12;
                        str = str2;
                        e.J(r9.b.a());
                        aVar.t0();
                        if (r9.c.f33469a) {
                            r9.c.a(k9.a.class, str, Long.valueOf(j10), Long.valueOf(j13), Long.valueOf(j14), Long.valueOf(System.currentTimeMillis() - j11));
                        }
                        throw th2;
                    }
                }
                next.B((byte) -2);
                i10 = next.i();
                if (i10 != null) {
                }
                if (!z10) {
                }
                str = str2;
                currentTimeMillis = j11;
            } catch (Throwable th6) {
                th2 = th6;
                j11 = currentTimeMillis;
                j10 = j12;
            }
        }
        String str3 = str;
        long j15 = currentTimeMillis;
        long j16 = j12;
        e.J(r9.b.a());
        aVar.t0();
        if (r9.c.f33469a) {
            r9.c.a(k9.a.class, str3, Long.valueOf(j16), Long.valueOf(j13), Long.valueOf(j14), Long.valueOf(System.currentTimeMillis() - j15));
        }
    }

    public j9.b a(String str) throws IOException {
        return e().a(str);
    }

    public q9.a b(File file) throws IOException {
        return k().a(file);
    }

    public int c(int i10, String str, String str2, long j10) {
        return d().a(i10, str, str2, j10);
    }

    public k9.a f() {
        k9.a aVar = this.f15112e;
        if (aVar != null) {
            return aVar;
        }
        synchronized (this) {
            if (this.f15112e == null) {
                k9.a c10 = g().c();
                this.f15112e = c10;
                m(c10.c());
            }
        }
        return this.f15112e;
    }

    public b.c h() {
        b.c cVar = this.f15113f;
        if (cVar != null) {
            return cVar;
        }
        synchronized (this) {
            if (this.f15113f == null) {
                this.f15113f = g().i();
            }
        }
        return this.f15113f;
    }

    public int j() {
        return g().l();
    }

    public boolean l() {
        return k().b();
    }
}
