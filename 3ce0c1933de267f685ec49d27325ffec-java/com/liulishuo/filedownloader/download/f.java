package com.liulishuo.filedownloader.download;

import android.database.sqlite.SQLiteFullException;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.liulishuo.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;
import n9.b;
import r9.c;
import r9.d;
import r9.e;
/* compiled from: DownloadStatusCallback.java */
/* loaded from: classes2.dex */
public class f implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final FileDownloadModel f15159a;

    /* renamed from: c  reason: collision with root package name */
    private final a f15161c;

    /* renamed from: d  reason: collision with root package name */
    private final int f15162d;

    /* renamed from: e  reason: collision with root package name */
    private final int f15163e;

    /* renamed from: f  reason: collision with root package name */
    private final int f15164f;

    /* renamed from: g  reason: collision with root package name */
    private long f15165g;

    /* renamed from: h  reason: collision with root package name */
    private Handler f15166h;

    /* renamed from: i  reason: collision with root package name */
    private HandlerThread f15167i;

    /* renamed from: k  reason: collision with root package name */
    private volatile Thread f15169k;

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f15168j = false;

    /* renamed from: l  reason: collision with root package name */
    private volatile long f15170l = 0;

    /* renamed from: m  reason: collision with root package name */
    private final AtomicLong f15171m = new AtomicLong();

    /* renamed from: n  reason: collision with root package name */
    private final AtomicBoolean f15172n = new AtomicBoolean(false);

    /* renamed from: o  reason: collision with root package name */
    private final AtomicBoolean f15173o = new AtomicBoolean(false);

    /* renamed from: p  reason: collision with root package name */
    private final AtomicBoolean f15174p = new AtomicBoolean(true);

    /* renamed from: b  reason: collision with root package name */
    private final k9.a f15160b = c.i().f();

    /* compiled from: DownloadStatusCallback.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f15175a;

        /* renamed from: b  reason: collision with root package name */
        private Exception f15176b;

        /* renamed from: c  reason: collision with root package name */
        private int f15177c;

        public Exception a() {
            return this.f15176b;
        }

        public int b() {
            return this.f15177c;
        }

        public boolean c() {
            return this.f15175a;
        }

        void d(Exception exc) {
            this.f15176b = exc;
        }

        void e(boolean z10) {
            this.f15175a = z10;
        }

        void f(int i10) {
            this.f15177c = i10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FileDownloadModel fileDownloadModel, int i10, int i11, int i12) {
        this.f15159a = fileDownloadModel;
        this.f15163e = i11 < 5 ? 5 : i11;
        this.f15164f = i12;
        this.f15161c = new a();
        this.f15162d = i10;
    }

    private static long a(long j10, long j11) {
        if (j11 <= 0) {
            return -1L;
        }
        if (j10 == -1) {
            return 1L;
        }
        long j12 = j10 / j11;
        if (j12 <= 0) {
            return 1L;
        }
        return j12;
    }

    private Exception c(Exception exc) {
        String j10 = this.f15159a.j();
        if ((!this.f15159a.o() && !d.a().f33475f) || !(exc instanceof IOException) || !new File(j10).exists()) {
            return exc;
        }
        long u10 = e.u(j10);
        if (u10 > ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF) {
            return exc;
        }
        long j11 = 0;
        File file = new File(j10);
        if (!file.exists()) {
            c.c(this, exc, "Exception with: free space isn't enough, and the target file not exist.", new Object[0]);
        } else {
            j11 = file.length();
        }
        if (Build.VERSION.SDK_INT >= 9) {
            return new FileDownloadOutOfSpaceException(u10, ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF, j11, exc);
        }
        return new FileDownloadOutOfSpaceException(u10, ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF, j11);
    }

    private void d() throws IOException {
        w();
        this.f15159a.B((byte) -3);
        this.f15160b.e(this.f15159a.e(), this.f15159a.k());
        this.f15160b.h(this.f15159a.e());
        v((byte) -3);
        if (d.a().f33476g) {
            p9.c.a(this.f15159a);
        }
    }

    private void e(Exception exc) {
        Exception exc2;
        Exception c10 = c(exc);
        if (c10 instanceof SQLiteFullException) {
            i((SQLiteFullException) c10);
            exc2 = c10;
        } else {
            try {
                this.f15159a.B((byte) -1);
                this.f15159a.v(exc.toString());
                this.f15160b.k(this.f15159a.e(), c10, this.f15159a.g());
                exc2 = c10;
            } catch (SQLiteFullException 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r6v1 ??
                	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:227)
                	at jadx.core.codegen.RegionGen.makeCatchBlock(RegionGen.java:349)
                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:312)
                	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:286)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:265)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:270)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                */
            /*
                this = this;
                java.lang.Exception r0 = r5.c(r6)
                boolean r1 = r0 instanceof android.database.sqlite.SQLiteFullException
                r2 = -1
                if (r1 == 0) goto L10
                r6 = r0
                android.database.sqlite.SQLiteFullException r6 = (android.database.sqlite.SQLiteFullException) r6
                r5.i(r6)
                goto L35
            L10:
                com.liulishuo.filedownloader.model.FileDownloadModel r1 = r5.f15159a     // Catch: android.database.sqlite.SQLiteFullException -> L30
                r1.B(r2)     // Catch: android.database.sqlite.SQLiteFullException -> L30
                com.liulishuo.filedownloader.model.FileDownloadModel r1 = r5.f15159a     // Catch: android.database.sqlite.SQLiteFullException -> L30
                java.lang.String r6 = r6.toString()     // Catch: android.database.sqlite.SQLiteFullException -> L30
                r1.v(r6)     // Catch: android.database.sqlite.SQLiteFullException -> L30
                k9.a r6 = r5.f15160b     // Catch: android.database.sqlite.SQLiteFullException -> L30
                com.liulishuo.filedownloader.model.FileDownloadModel r1 = r5.f15159a     // Catch: android.database.sqlite.SQLiteFullException -> L30
                int r1 = r1.e()     // Catch: android.database.sqlite.SQLiteFullException -> L30
                com.liulishuo.filedownloader.model.FileDownloadModel r3 = r5.f15159a     // Catch: android.database.sqlite.SQLiteFullException -> L30
                long r3 = r3.g()     // Catch: android.database.sqlite.SQLiteFullException -> L30
                r6.k(r1, r0, r3)     // Catch: android.database.sqlite.SQLiteFullException -> L30
                goto L35
            L30:
                r6 = move-exception
                r0 = r6
                r5.i(r0)
            L35:
                com.liulishuo.filedownloader.download.f$a r6 = r5.f15161c
                r6.d(r0)
                r5.v(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.download.f.e(java.lang.Exception):void");
        }

        private void f() {
            this.f15159a.B((byte) -2);
            this.f15160b.q(this.f15159a.e(), this.f15159a.g());
            v((byte) -2);
        }

        private void g() {
            if (this.f15159a.g() == this.f15159a.k()) {
                this.f15160b.l(this.f15159a.e(), this.f15159a.g());
                return;
            }
            if (this.f15173o.compareAndSet(true, false)) {
                if (c.f33469a) {
                    c.e(this, "handleProgress update model's status with progress", new Object[0]);
                }
                this.f15159a.B((byte) 3);
            }
            if (this.f15172n.compareAndSet(true, false)) {
                if (c.f33469a) {
                    c.e(this, "handleProgress notify user progress status", new Object[0]);
                }
                v((byte) 3);
            }
        }

        private void h(Exception exc, int i10) {
            Exception c10 = c(exc);
            this.f15161c.d(c10);
            this.f15161c.f(this.f15162d - i10);
            this.f15159a.B((byte) 5);
            this.f15159a.v(c10.toString());
            this.f15160b.d(this.f15159a.e(), c10);
            v((byte) 5);
        }

        private void i(SQLiteFullException sQLiteFullException) {
            int e10 = this.f15159a.e();
            if (c.f33469a) {
                c.a(this, "the data of the task[%d] is dirty, because the SQLite full exception[%s], so remove it from the database directly.", Integer.valueOf(e10), sQLiteFullException.toString());
            }
            this.f15159a.v(sQLiteFullException.toString());
            this.f15159a.B((byte) -1);
            this.f15160b.remove(e10);
            this.f15160b.h(e10);
        }

        private void j(long j10) {
            boolean z10;
            if (!this.f15174p.compareAndSet(true, false)) {
                long j11 = j10 - this.f15170l;
                if (this.f15165g == -1 || this.f15171m.get() < this.f15165g || j11 < this.f15163e) {
                    z10 = false;
                    if (z10 && this.f15172n.compareAndSet(false, true)) {
                        if (c.f33469a) {
                            c.e(this, "inspectNeedCallbackToUser need callback to user", new Object[0]);
                        }
                        this.f15170l = j10;
                        this.f15171m.set(0L);
                        return;
                    }
                }
            }
            z10 = true;
            if (z10) {
            }
        }

        private boolean k() {
            if (this.f15159a.o()) {
                FileDownloadModel fileDownloadModel = this.f15159a;
                fileDownloadModel.C(fileDownloadModel.g());
            } else if (this.f15159a.g() != this.f15159a.k()) {
                o(new FileDownloadGiveUpRetryException(e.n("sofar[%d] not equal total[%d]", Long.valueOf(this.f15159a.g()), Long.valueOf(this.f15159a.k()))));
                return true;
            }
            return false;
        }

        private void v(byte b10) {
            if (b10 != -2) {
                b.a().b(com.liulishuo.filedownloader.message.b.d(b10, this.f15159a, this.f15161c));
            } else if (c.f33469a) {
                c.a(this, "High concurrent cause, Already paused and we don't need to call-back to Task in here, %d", Integer.valueOf(this.f15159a.e()));
            }
        }

        private void w() throws IOException {
            boolean z10;
            Throwable th2;
            String j10 = this.f15159a.j();
            String i10 = this.f15159a.i();
            File file = new File(j10);
            try {
                File file2 = new File(i10);
                if (file2.exists()) {
                    long length = file2.length();
                    if (file2.delete()) {
                        c.i(this, "The target file([%s], [%d]) will be replaced with the new downloaded file[%d]", i10, Long.valueOf(length), Long.valueOf(file.length()));
                    } else {
                        throw new IOException(e.n("Can't delete the old file([%s], [%d]), so can't replace it with the new downloaded one.", i10, Long.valueOf(length)));
                    }
                }
                z10 = !file.renameTo(file2);
                if (z10) {
                    try {
                        throw new IOException(e.n("Can't rename the  temp downloaded file(%s) to the target file(%s)", j10, i10));
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (z10 && file.exists() && !file.delete()) {
                            c.i(this, "delete the temp file(%s) failed, on completed downloading.", j10);
                        }
                        throw th2;
                    }
                } else if (z10 && file.exists() && !file.delete()) {
                    c.i(this, "delete the temp file(%s) failed, on completed downloading.", j10);
                }
            } catch (Throwable th4) {
                th2 = th4;
                z10 = true;
            }
        }

        private synchronized void x(Message message) {
            if (!this.f15167i.isAlive()) {
                if (c.f33469a) {
                    c.a(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
                }
                return;
            }
            try {
                this.f15166h.sendMessage(message);
            } catch (IllegalStateException e10) {
                if (this.f15167i.isAlive()) {
                    throw e10;
                } else if (c.f33469a) {
                    c.a(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b() {
            Handler handler = this.f15166h;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.f15167i.quit();
                this.f15169k = Thread.currentThread();
                while (this.f15168j) {
                    LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(100L));
                }
                this.f15169k = null;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0020 A[DONT_GENERATE] */
        @Override // android.os.Handler.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean handleMessage(Message message) {
            this.f15168j = true;
            int i10 = message.what;
            try {
                if (i10 != 3) {
                    if (i10 == 5) {
                        h((Exception) message.obj, message.arg1);
                    }
                    return true;
                }
                g();
                return true;
            } finally {
                this.f15168j = false;
                if (this.f15169k != null) {
                    LockSupport.unpark(this.f15169k);
                }
            }
        }

        public boolean l() {
            HandlerThread handlerThread = this.f15167i;
            return handlerThread != null && handlerThread.isAlive();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void m() throws IOException {
            if (!k()) {
                d();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void n(boolean z10, long j10, String str, String str2) throws IllegalArgumentException {
            String b10 = this.f15159a.b();
            if (b10 == null || b10.equals(str)) {
                this.f15161c.e(z10);
                this.f15159a.B((byte) 2);
                this.f15159a.C(j10);
                this.f15159a.u(str);
                this.f15159a.x(str2);
                this.f15160b.m(this.f15159a.e(), j10, str, str2);
                v((byte) 2);
                this.f15165g = a(j10, this.f15164f);
                this.f15173o.compareAndSet(false, true);
                return;
            }
            throw new IllegalArgumentException(e.n("callback onConnected must with precondition succeed, but the etag is changes(%s != %s)", str, b10));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void o(Exception exc) {
            e(exc);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void p() {
            HandlerThread handlerThread = new HandlerThread("source-status-callback");
            this.f15167i = handlerThread;
            handlerThread.start();
            this.f15166h = new Handler(this.f15167i.getLooper(), this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void q() {
            f();
        }

        public void r() {
            this.f15159a.B((byte) 1);
            this.f15160b.a(this.f15159a.e());
            v((byte) 1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void s(long j10) {
            this.f15171m.addAndGet(j10);
            this.f15159a.m(j10);
            j(SystemClock.elapsedRealtime());
            if (this.f15166h == null) {
                g();
            } else if (this.f15172n.get()) {
                x(this.f15166h.obtainMessage(3));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void t(Exception exc, int i10) {
            this.f15171m.set(0L);
            Handler handler = this.f15166h;
            if (handler == null) {
                h(exc, i10);
            } else {
                x(handler.obtainMessage(5, i10, 0, exc));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void u() {
            this.f15159a.B((byte) 6);
            v((byte) 6);
            this.f15160b.i(this.f15159a.e());
        }
    }
