package com.amap.api.services.a;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
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
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import n4.n;
/* compiled from: DiskLruCache.java */
/* loaded from: classes.dex */
public final class o implements Closeable {

    /* renamed from: q  reason: collision with root package name */
    private static final ThreadFactory f7213q;

    /* renamed from: r  reason: collision with root package name */
    static ThreadPoolExecutor f7214r;

    /* renamed from: a  reason: collision with root package name */
    private final File f7216a;

    /* renamed from: b  reason: collision with root package name */
    private final File f7217b;

    /* renamed from: c  reason: collision with root package name */
    private final File f7218c;

    /* renamed from: d  reason: collision with root package name */
    private final File f7219d;

    /* renamed from: e  reason: collision with root package name */
    private final int f7220e;

    /* renamed from: f  reason: collision with root package name */
    private long f7221f;

    /* renamed from: g  reason: collision with root package name */
    private final int f7222g;

    /* renamed from: i  reason: collision with root package name */
    private Writer f7224i;

    /* renamed from: l  reason: collision with root package name */
    private int f7227l;

    /* renamed from: m  reason: collision with root package name */
    private n f7228m;

    /* renamed from: p  reason: collision with root package name */
    static final Pattern f7212p = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: s  reason: collision with root package name */
    private static final OutputStream f7215s = new c();

    /* renamed from: h  reason: collision with root package name */
    private long f7223h = 0;

    /* renamed from: j  reason: collision with root package name */
    private int f7225j = 1000;

    /* renamed from: k  reason: collision with root package name */
    private final LinkedHashMap<String, f> f7226k = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: n  reason: collision with root package name */
    private long f7229n = 0;

    /* renamed from: o  reason: collision with root package name */
    private final Callable<Void> f7230o = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f7231a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "disklrucache#" + this.f7231a.getAndIncrement());
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    class b implements Callable<Void> {
        b() {
        }

        /* renamed from: a */
        public Void call() throws Exception {
            synchronized (o.this) {
                if (o.this.f7224i == null) {
                    return null;
                }
                o.this.z0();
                if (o.this.u0()) {
                    o.this.t0();
                    o.this.f7227l = 0;
                }
                return null;
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    static class c extends OutputStream {
        c() {
        }

        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class d {

        /* renamed from: a  reason: collision with root package name */
        private final f f7233a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean[] f7234b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f7235c;

        /* compiled from: DiskLruCache.java */
        /* loaded from: classes.dex */
        private class a extends FilterOutputStream {
            /* synthetic */ a(d dVar, OutputStream outputStream, a aVar) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    d.this.f7235c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    d.this.f7235c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i10) {
                try {
                    ((FilterOutputStream) this).out.write(i10);
                } catch (IOException unused) {
                    d.this.f7235c = true;
                }
            }

            private a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i10, int i11) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i10, i11);
                } catch (IOException unused) {
                    d.this.f7235c = true;
                }
            }
        }

        /* synthetic */ d(o oVar, f fVar, a aVar) {
            this(fVar);
        }

        public OutputStream b(int i10) throws IOException {
            FileOutputStream fileOutputStream;
            a aVar;
            if (i10 < 0 || i10 >= o.this.f7222g) {
                throw new IllegalArgumentException("Expected index " + i10 + " to be greater than 0 and less than the maximum value count of " + o.this.f7222g);
            }
            synchronized (o.this) {
                if (this.f7233a.f7242d == this) {
                    if (!this.f7233a.f7241c) {
                        this.f7234b[i10] = true;
                    }
                    File i11 = this.f7233a.i(i10);
                    try {
                        fileOutputStream = new FileOutputStream(i11);
                    } catch (FileNotFoundException unused) {
                        o.this.f7216a.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(i11);
                        } catch (FileNotFoundException unused2) {
                            return o.f7215s;
                        }
                    }
                    aVar = new a(this, fileOutputStream, null);
                } else {
                    throw new IllegalStateException();
                }
            }
            return aVar;
        }

        public void c() throws IOException {
            if (this.f7235c) {
                o.this.q(this, false);
                o.this.T(this.f7233a.f7239a);
                return;
            }
            o.this.q(this, true);
        }

        public void e() throws IOException {
            o.this.q(this, false);
        }

        private d(f fVar) {
            this.f7233a = fVar;
            this.f7234b = fVar.f7241c ? null : new boolean[o.this.f7222g];
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class e implements Closeable {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream[] f7238a;

        /* synthetic */ e(o oVar, String str, long j10, InputStream[] inputStreamArr, long[] jArr, a aVar) {
            this(oVar, str, j10, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.f7238a) {
                q.a(inputStream);
            }
        }

        private e(o oVar, String str, long j10, InputStream[] inputStreamArr, long[] jArr) {
            this.f7238a = inputStreamArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class f {

        /* renamed from: a  reason: collision with root package name */
        private final String f7239a;

        /* renamed from: b  reason: collision with root package name */
        private final long[] f7240b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f7241c;

        /* renamed from: d  reason: collision with root package name */
        private d f7242d;

        /* renamed from: e  reason: collision with root package name */
        private long f7243e;

        /* synthetic */ f(o oVar, String str, a aVar) {
            this(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(String[] strArr) throws IOException {
            if (strArr.length == o.this.f7222g) {
                for (int i10 = 0; i10 < strArr.length; i10++) {
                    try {
                        this.f7240b[i10] = Long.parseLong(strArr[i10]);
                    } catch (NumberFormatException unused) {
                        throw j(strArr);
                    }
                }
                return;
            }
            throw j(strArr);
        }

        private IOException j(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File d(int i10) {
            File file = o.this.f7216a;
            return new File(file, this.f7239a + "." + i10);
        }

        public String e() throws IOException {
            long[] jArr;
            StringBuilder sb2 = new StringBuilder();
            for (long j10 : this.f7240b) {
                sb2.append(' ');
                sb2.append(j10);
            }
            return sb2.toString();
        }

        public File i(int i10) {
            File file = o.this.f7216a;
            return new File(file, this.f7239a + "." + i10 + ".tmp");
        }

        private f(String str) {
            this.f7239a = str;
            this.f7240b = new long[o.this.f7222g];
        }
    }

    static {
        a aVar = new a();
        f7213q = aVar;
        f7214r = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), aVar);
    }

    private o(File file, int i10, int i11, long j10) {
        this.f7216a = file;
        this.f7220e = i10;
        this.f7217b = new File(file, "journal");
        this.f7218c = new File(file, "journal.tmp");
        this.f7219d = new File(file, "journal.bkp");
        this.f7222g = i11;
        this.f7221f = j10;
    }

    private synchronized d d(String str, long j10) throws IOException {
        w0();
        j0(str);
        f fVar = this.f7226k.get(str);
        if (j10 != -1 && (fVar == null || fVar.f7243e != j10)) {
            return null;
        }
        if (fVar == null) {
            fVar = new f(this, str, null);
            this.f7226k.put(str, fVar);
        } else if (fVar.f7242d != null) {
            return null;
        }
        d dVar = new d(this, fVar, null);
        fVar.f7242d = dVar;
        Writer writer = this.f7224i;
        writer.write("DIRTY " + str + '\n');
        this.f7224i.flush();
        return dVar;
    }

    private void g0(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i10 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i10);
            if (indexOf2 == -1) {
                str2 = str.substring(i10);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f7226k.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i10, indexOf2);
            }
            f fVar = this.f7226k.get(str2);
            if (fVar == null) {
                fVar = new f(this, str2, null);
                this.f7226k.put(str2, fVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                fVar.f7241c = true;
                fVar.f7242d = null;
                fVar.g(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                fVar.f7242d = new d(this, fVar, null);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    public static o i(File file, int i10, int i11, long j10) throws IOException {
        if (j10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i11 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    w(file2, file3, false);
                }
            }
            o oVar = new o(file, i10, i11, j10);
            if (oVar.f7217b.exists()) {
                try {
                    oVar.o0();
                    oVar.r0();
                    oVar.f7224i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(oVar.f7217b, true), q.f7251a));
                    return oVar;
                } catch (Throwable unused) {
                    oVar.i0();
                }
            }
            file.mkdirs();
            o oVar2 = new o(file, i10, i11, j10);
            oVar2.t0();
            return oVar2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    private void j0(String str) {
        if (!f7212p.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    public static ThreadPoolExecutor o() {
        try {
            ThreadPoolExecutor threadPoolExecutor = f7214r;
            if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
                f7214r = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f7213q);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return f7214r;
    }

    private void o0() throws IOException {
        p pVar = new p(new FileInputStream(this.f7217b), q.f7251a);
        try {
            String c10 = pVar.c();
            String c11 = pVar.c();
            String c12 = pVar.c();
            String c13 = pVar.c();
            String c14 = pVar.c();
            if (!"libcore.io.DiskLruCache".equals(c10) || !"1".equals(c11) || !Integer.toString(this.f7220e).equals(c12) || !Integer.toString(this.f7222g).equals(c13) || !"".equals(c14)) {
                throw new IOException("unexpected journal header: [" + c10 + ", " + c11 + ", " + c13 + ", " + c14 + "]");
            }
            int i10 = 0;
            while (true) {
                try {
                    g0(pVar.c());
                    i10++;
                } catch (EOFException unused) {
                    this.f7227l = i10 - this.f7226k.size();
                    q.a(pVar);
                    return;
                }
            }
        } catch (Throwable th2) {
            q.a(pVar);
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void q(d dVar, boolean z10) throws IOException {
        f fVar = dVar.f7233a;
        if (fVar.f7242d == dVar) {
            if (z10 && !fVar.f7241c) {
                for (int i10 = 0; i10 < this.f7222g; i10++) {
                    if (!dVar.f7234b[i10]) {
                        dVar.e();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i10);
                    } else if (!fVar.i(i10).exists()) {
                        dVar.e();
                        return;
                    }
                }
            }
            for (int i11 = 0; i11 < this.f7222g; i11++) {
                File i12 = fVar.i(i11);
                if (!z10) {
                    v(i12);
                } else if (i12.exists()) {
                    File d10 = fVar.d(i11);
                    i12.renameTo(d10);
                    long j10 = fVar.f7240b[i11];
                    long length = d10.length();
                    fVar.f7240b[i11] = length;
                    this.f7223h = (this.f7223h - j10) + length;
                }
            }
            this.f7227l++;
            fVar.f7242d = null;
            if (fVar.f7241c || z10) {
                fVar.f7241c = true;
                this.f7224i.write("CLEAN " + fVar.f7239a + fVar.e() + '\n');
                if (z10) {
                    long j11 = this.f7229n;
                    this.f7229n = 1 + j11;
                    fVar.f7243e = j11;
                }
            } else {
                this.f7226k.remove(fVar.f7239a);
                this.f7224i.write("REMOVE " + fVar.f7239a + '\n');
            }
            this.f7224i.flush();
            if (this.f7223h > this.f7221f || u0()) {
                o().submit(this.f7230o);
            }
            return;
        }
        throw new IllegalStateException();
    }

    private void r0() throws IOException {
        v(this.f7218c);
        Iterator<f> it = this.f7226k.values().iterator();
        while (it.hasNext()) {
            f next = it.next();
            int i10 = 0;
            if (next.f7242d == null) {
                while (i10 < this.f7222g) {
                    this.f7223h += next.f7240b[i10];
                    i10++;
                }
            } else {
                next.f7242d = null;
                while (i10 < this.f7222g) {
                    v(next.d(i10));
                    v(next.i(i10));
                    i10++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void t0() throws IOException {
        Writer writer = this.f7224i;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f7218c), q.f7251a));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f7220e));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f7222g));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (f fVar : this.f7226k.values()) {
            if (fVar.f7242d != null) {
                bufferedWriter.write("DIRTY " + fVar.f7239a + '\n');
            } else {
                bufferedWriter.write("CLEAN " + fVar.f7239a + fVar.e() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.f7217b.exists()) {
            w(this.f7217b, this.f7219d, true);
        }
        w(this.f7218c, this.f7217b, false);
        this.f7219d.delete();
        this.f7224i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f7217b, true), q.f7251a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u0() {
        int i10 = this.f7227l;
        return i10 >= 2000 && i10 >= this.f7226k.size();
    }

    private static void v(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void w(File file, File file2, boolean z10) throws IOException {
        if (z10) {
            v(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private void w0() {
        if (this.f7224i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() throws IOException {
        while (true) {
            if (this.f7223h > this.f7221f || this.f7226k.size() > this.f7225j) {
                String key = this.f7226k.entrySet().iterator().next().getKey();
                T(key);
                n nVar = this.f7228m;
                if (nVar != null) {
                    nVar.a(key);
                }
            } else {
                return;
            }
        }
    }

    public d E(String str) throws IOException {
        return d(str, -1L);
    }

    public synchronized boolean O() {
        return this.f7224i == null;
    }

    public synchronized boolean T(String str) throws IOException {
        w0();
        j0(str);
        f fVar = this.f7226k.get(str);
        if (fVar != null && fVar.f7242d == null) {
            for (int i10 = 0; i10 < this.f7222g; i10++) {
                File d10 = fVar.d(i10);
                if (d10.exists() && !d10.delete()) {
                    throw new IOException("failed to delete " + d10);
                }
                this.f7223h -= fVar.f7240b[i10];
                fVar.f7240b[i10] = 0;
            }
            this.f7227l++;
            this.f7224i.append((CharSequence) ("REMOVE " + str + '\n'));
            this.f7226k.remove(str);
            if (u0()) {
                o().submit(this.f7230o);
            }
            return true;
        }
        return false;
    }

    public synchronized void V() throws IOException {
        w0();
        z0();
        this.f7224i.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f7224i != null) {
            Iterator it = new ArrayList(this.f7226k.values()).iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                if (fVar.f7242d != null) {
                    fVar.f7242d.e();
                }
            }
            z0();
            this.f7224i.close();
            this.f7224i = null;
        }
    }

    public synchronized e h(String str) throws IOException {
        w0();
        j0(str);
        f fVar = this.f7226k.get(str);
        if (fVar == null) {
            return null;
        }
        if (!fVar.f7241c) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.f7222g];
        for (int i10 = 0; i10 < this.f7222g; i10++) {
            try {
                inputStreamArr[i10] = new FileInputStream(fVar.d(i10));
            } catch (FileNotFoundException unused) {
                for (int i11 = 0; i11 < this.f7222g && inputStreamArr[i11] != null; i11++) {
                    q.a(inputStreamArr[i11]);
                }
                return null;
            }
        }
        this.f7227l++;
        this.f7224i.append((CharSequence) ("READ " + str + '\n'));
        if (u0()) {
            o().submit(this.f7230o);
        }
        return new e(this, str, fVar.f7243e, inputStreamArr, fVar.f7240b, null);
    }

    public void i0() throws IOException {
        close();
        q.b(this.f7216a);
    }

    public void x(n nVar) {
        this.f7228m = nVar;
    }
}
