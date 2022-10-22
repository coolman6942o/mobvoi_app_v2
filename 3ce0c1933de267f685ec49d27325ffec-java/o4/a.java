package o4;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* compiled from: DiskLruCache.java */
/* loaded from: classes.dex */
public final class a implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final File f31411a;

    /* renamed from: b  reason: collision with root package name */
    private final File f31412b;

    /* renamed from: c  reason: collision with root package name */
    private final File f31413c;

    /* renamed from: d  reason: collision with root package name */
    private final File f31414d;

    /* renamed from: e  reason: collision with root package name */
    private final int f31415e;

    /* renamed from: f  reason: collision with root package name */
    private long f31416f;

    /* renamed from: g  reason: collision with root package name */
    private final int f31417g;

    /* renamed from: i  reason: collision with root package name */
    private Writer f31419i;

    /* renamed from: k  reason: collision with root package name */
    private int f31421k;

    /* renamed from: h  reason: collision with root package name */
    private long f31418h = 0;

    /* renamed from: j  reason: collision with root package name */
    private final LinkedHashMap<String, d> f31420j = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: l  reason: collision with root package name */
    private long f31422l = 0;

    /* renamed from: m  reason: collision with root package name */
    final ThreadPoolExecutor f31423m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));

    /* renamed from: n  reason: collision with root package name */
    private final Callable<Void> f31424n = new CallableC0419a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DiskLruCache.java */
    /* renamed from: o4.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class CallableC0419a implements Callable<Void> {
        CallableC0419a() {
        }

        /* renamed from: a */
        public Void call() throws Exception {
            synchronized (a.this) {
                if (a.this.f31419i == null) {
                    return null;
                }
                a.this.r0();
                if (a.this.W()) {
                    a.this.k0();
                    a.this.f31421k = 0;
                }
                return null;
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    private static final class b implements ThreadFactory {
        private b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        /* synthetic */ b(CallableC0419a aVar) {
            this();
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class c {

        /* renamed from: a  reason: collision with root package name */
        private final d f31426a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean[] f31427b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f31428c;

        /* synthetic */ c(a aVar, d dVar, CallableC0419a aVar2) {
            this(dVar);
        }

        public void a() throws IOException {
            a.this.x(this, false);
        }

        public void b() {
            if (!this.f31428c) {
                try {
                    a();
                } catch (IOException unused) {
                }
            }
        }

        public void e() throws IOException {
            a.this.x(this, true);
            this.f31428c = true;
        }

        public File f(int i10) throws IOException {
            File k10;
            synchronized (a.this) {
                if (this.f31426a.f31435f == this) {
                    if (!this.f31426a.f31434e) {
                        this.f31427b[i10] = true;
                    }
                    k10 = this.f31426a.k(i10);
                    if (!a.this.f31411a.exists()) {
                        a.this.f31411a.mkdirs();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            return k10;
        }

        private c(d dVar) {
            this.f31426a = dVar;
            this.f31427b = dVar.f31434e ? null : new boolean[a.this.f31417g];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class d {

        /* renamed from: a  reason: collision with root package name */
        private final String f31430a;

        /* renamed from: b  reason: collision with root package name */
        private final long[] f31431b;

        /* renamed from: c  reason: collision with root package name */
        File[] f31432c;

        /* renamed from: d  reason: collision with root package name */
        File[] f31433d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f31434e;

        /* renamed from: f  reason: collision with root package name */
        private c f31435f;

        /* renamed from: g  reason: collision with root package name */
        private long f31436g;

        /* synthetic */ d(a aVar, String str, CallableC0419a aVar2) {
            this(str);
        }

        private IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(String[] strArr) throws IOException {
            if (strArr.length == a.this.f31417g) {
                for (int i10 = 0; i10 < strArr.length; i10++) {
                    try {
                        this.f31431b[i10] = Long.parseLong(strArr[i10]);
                    } catch (NumberFormatException unused) {
                        throw m(strArr);
                    }
                }
                return;
            }
            throw m(strArr);
        }

        public File j(int i10) {
            return this.f31432c[i10];
        }

        public File k(int i10) {
            return this.f31433d[i10];
        }

        public String l() throws IOException {
            long[] jArr;
            StringBuilder sb2 = new StringBuilder();
            for (long j10 : this.f31431b) {
                sb2.append(' ');
                sb2.append(j10);
            }
            return sb2.toString();
        }

        private d(String str) {
            this.f31430a = str;
            this.f31431b = new long[a.this.f31417g];
            this.f31432c = new File[a.this.f31417g];
            this.f31433d = new File[a.this.f31417g];
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append('.');
            int length = sb2.length();
            for (int i10 = 0; i10 < a.this.f31417g; i10++) {
                sb2.append(i10);
                this.f31432c[i10] = new File(a.this.f31411a, sb2.toString());
                sb2.append(".tmp");
                this.f31433d[i10] = new File(a.this.f31411a, sb2.toString());
                sb2.setLength(length);
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class e {

        /* renamed from: a  reason: collision with root package name */
        private final File[] f31438a;

        /* synthetic */ e(a aVar, String str, long j10, File[] fileArr, long[] jArr, CallableC0419a aVar2) {
            this(aVar, str, j10, fileArr, jArr);
        }

        public File a(int i10) {
            return this.f31438a[i10];
        }

        private e(a aVar, String str, long j10, File[] fileArr, long[] jArr) {
            this.f31438a = fileArr;
        }
    }

    private a(File file, int i10, int i11, long j10) {
        this.f31411a = file;
        this.f31415e = i10;
        this.f31412b = new File(file, "journal");
        this.f31413c = new File(file, "journal.tmp");
        this.f31414d = new File(file, "journal.bkp");
        this.f31417g = i11;
        this.f31416f = j10;
    }

    private static void I(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private synchronized c Q(String str, long j10) throws IOException {
        v();
        d dVar = this.f31420j.get(str);
        if (j10 != -1 && (dVar == null || dVar.f31436g != j10)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, str, null);
            this.f31420j.put(str, dVar);
        } else if (dVar.f31435f != null) {
            return null;
        }
        c cVar = new c(this, dVar, null);
        dVar.f31435f = cVar;
        this.f31419i.append((CharSequence) "DIRTY");
        this.f31419i.append(' ');
        this.f31419i.append((CharSequence) str);
        this.f31419i.append('\n');
        T(this.f31419i);
        return cVar;
    }

    @TargetApi(26)
    private static void T(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean W() {
        int i10 = this.f31421k;
        return i10 >= 2000 && i10 >= this.f31420j.size();
    }

    public static a g0(File file, int i10, int i11, long j10) throws IOException {
        if (j10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i11 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    o0(file2, file3, false);
                }
            }
            a aVar = new a(file, i10, i11, j10);
            if (aVar.f31412b.exists()) {
                try {
                    aVar.i0();
                    aVar.h0();
                    return aVar;
                } catch (IOException e10) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e10.getMessage() + ", removing");
                    aVar.E();
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, i10, i11, j10);
            aVar2.k0();
            return aVar2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    private void h0() throws IOException {
        I(this.f31413c);
        Iterator<d> it = this.f31420j.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i10 = 0;
            if (next.f31435f == null) {
                while (i10 < this.f31417g) {
                    this.f31418h += next.f31431b[i10];
                    i10++;
                }
            } else {
                next.f31435f = null;
                while (i10 < this.f31417g) {
                    I(next.j(i10));
                    I(next.k(i10));
                    i10++;
                }
                it.remove();
            }
        }
    }

    private void i0() throws IOException {
        o4.b bVar = new o4.b(new FileInputStream(this.f31412b), o4.c.f31445a);
        try {
            String i10 = bVar.i();
            String i11 = bVar.i();
            String i12 = bVar.i();
            String i13 = bVar.i();
            String i14 = bVar.i();
            if (!"libcore.io.DiskLruCache".equals(i10) || !"1".equals(i11) || !Integer.toString(this.f31415e).equals(i12) || !Integer.toString(this.f31417g).equals(i13) || !"".equals(i14)) {
                throw new IOException("unexpected journal header: [" + i10 + ", " + i11 + ", " + i13 + ", " + i14 + "]");
            }
            int i15 = 0;
            while (true) {
                try {
                    j0(bVar.i());
                    i15++;
                } catch (EOFException unused) {
                    this.f31421k = i15 - this.f31420j.size();
                    if (bVar.h()) {
                        k0();
                    } else {
                        this.f31419i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f31412b, true), o4.c.f31445a));
                    }
                    o4.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th2) {
            o4.c.a(bVar);
            throw th2;
        }
    }

    private void j0(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i10 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i10);
            if (indexOf2 == -1) {
                str2 = str.substring(i10);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f31420j.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i10, indexOf2);
            }
            d dVar = this.f31420j.get(str2);
            if (dVar == null) {
                dVar = new d(this, str2, null);
                this.f31420j.put(str2, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.f31434e = true;
                dVar.f31435f = null;
                dVar.n(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.f31435f = new c(this, dVar, null);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void k0() throws IOException {
        Writer writer = this.f31419i;
        if (writer != null) {
            w(writer);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f31413c), o4.c.f31445a));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f31415e));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f31417g));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (d dVar : this.f31420j.values()) {
            if (dVar.f31435f != null) {
                bufferedWriter.write("DIRTY " + dVar.f31430a + '\n');
            } else {
                bufferedWriter.write("CLEAN " + dVar.f31430a + dVar.l() + '\n');
            }
        }
        w(bufferedWriter);
        if (this.f31412b.exists()) {
            o0(this.f31412b, this.f31414d, true);
        }
        o0(this.f31413c, this.f31412b, false);
        this.f31414d.delete();
        this.f31419i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f31412b, true), o4.c.f31445a));
    }

    private static void o0(File file, File file2, boolean z10) throws IOException {
        if (z10) {
            I(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() throws IOException {
        while (this.f31418h > this.f31416f) {
            m0(this.f31420j.entrySet().iterator().next().getKey());
        }
    }

    private void v() {
        if (this.f31419i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @TargetApi(26)
    private static void w(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void x(c cVar, boolean z10) throws IOException {
        d dVar = cVar.f31426a;
        if (dVar.f31435f == cVar) {
            if (z10 && !dVar.f31434e) {
                for (int i10 = 0; i10 < this.f31417g; i10++) {
                    if (!cVar.f31427b[i10]) {
                        cVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i10);
                    } else if (!dVar.k(i10).exists()) {
                        cVar.a();
                        return;
                    }
                }
            }
            for (int i11 = 0; i11 < this.f31417g; i11++) {
                File k10 = dVar.k(i11);
                if (!z10) {
                    I(k10);
                } else if (k10.exists()) {
                    File j10 = dVar.j(i11);
                    k10.renameTo(j10);
                    long j11 = dVar.f31431b[i11];
                    long length = j10.length();
                    dVar.f31431b[i11] = length;
                    this.f31418h = (this.f31418h - j11) + length;
                }
            }
            this.f31421k++;
            dVar.f31435f = null;
            if (dVar.f31434e || z10) {
                dVar.f31434e = true;
                this.f31419i.append((CharSequence) "CLEAN");
                this.f31419i.append(' ');
                this.f31419i.append((CharSequence) dVar.f31430a);
                this.f31419i.append((CharSequence) dVar.l());
                this.f31419i.append('\n');
                if (z10) {
                    long j12 = this.f31422l;
                    this.f31422l = 1 + j12;
                    dVar.f31436g = j12;
                }
            } else {
                this.f31420j.remove(dVar.f31430a);
                this.f31419i.append((CharSequence) "REMOVE");
                this.f31419i.append(' ');
                this.f31419i.append((CharSequence) dVar.f31430a);
                this.f31419i.append('\n');
            }
            T(this.f31419i);
            if (this.f31418h > this.f31416f || W()) {
                this.f31423m.submit(this.f31424n);
            }
            return;
        }
        throw new IllegalStateException();
    }

    public void E() throws IOException {
        close();
        o4.c.b(this.f31411a);
    }

    public c O(String str) throws IOException {
        return Q(str, -1L);
    }

    public synchronized e V(String str) throws IOException {
        v();
        d dVar = this.f31420j.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f31434e) {
            return null;
        }
        for (File file : dVar.f31432c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.f31421k++;
        this.f31419i.append((CharSequence) "READ");
        this.f31419i.append(' ');
        this.f31419i.append((CharSequence) str);
        this.f31419i.append('\n');
        if (W()) {
            this.f31423m.submit(this.f31424n);
        }
        return new e(this, str, dVar.f31436g, dVar.f31432c, dVar.f31431b, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f31419i != null) {
            Iterator it = new ArrayList(this.f31420j.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.f31435f != null) {
                    dVar.f31435f.a();
                }
            }
            r0();
            w(this.f31419i);
            this.f31419i = null;
        }
    }

    public synchronized boolean m0(String str) throws IOException {
        v();
        d dVar = this.f31420j.get(str);
        if (dVar != null && dVar.f31435f == null) {
            for (int i10 = 0; i10 < this.f31417g; i10++) {
                File j10 = dVar.j(i10);
                if (j10.exists() && !j10.delete()) {
                    throw new IOException("failed to delete " + j10);
                }
                this.f31418h -= dVar.f31431b[i10];
                dVar.f31431b[i10] = 0;
            }
            this.f31421k++;
            this.f31419i.append((CharSequence) "REMOVE");
            this.f31419i.append(' ');
            this.f31419i.append((CharSequence) str);
            this.f31419i.append('\n');
            this.f31420j.remove(str);
            if (W()) {
                this.f31423m.submit(this.f31424n);
            }
            return true;
        }
        return false;
    }
}
