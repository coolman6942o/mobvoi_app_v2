package com.amap.api.mapcore2d;

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
import k4.o;
/* compiled from: DiskLruCache.java */
/* loaded from: classes.dex */
public final class p implements Closeable {

    /* renamed from: q  reason: collision with root package name */
    private static final ThreadFactory f7009q;

    /* renamed from: r  reason: collision with root package name */
    static ThreadPoolExecutor f7010r;

    /* renamed from: a  reason: collision with root package name */
    private final File f7012a;

    /* renamed from: b  reason: collision with root package name */
    private final File f7013b;

    /* renamed from: c  reason: collision with root package name */
    private final File f7014c;

    /* renamed from: d  reason: collision with root package name */
    private final File f7015d;

    /* renamed from: e  reason: collision with root package name */
    private final int f7016e;

    /* renamed from: f  reason: collision with root package name */
    private long f7017f;

    /* renamed from: g  reason: collision with root package name */
    private final int f7018g;

    /* renamed from: i  reason: collision with root package name */
    private Writer f7020i;

    /* renamed from: l  reason: collision with root package name */
    private int f7023l;

    /* renamed from: m  reason: collision with root package name */
    private o f7024m;

    /* renamed from: p  reason: collision with root package name */
    static final Pattern f7008p = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: s  reason: collision with root package name */
    private static final OutputStream f7011s = new c();

    /* renamed from: h  reason: collision with root package name */
    private long f7019h = 0;

    /* renamed from: j  reason: collision with root package name */
    private int f7021j = 1000;

    /* renamed from: k  reason: collision with root package name */
    private final LinkedHashMap<String, f> f7022k = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: n  reason: collision with root package name */
    private long f7025n = 0;

    /* renamed from: o  reason: collision with root package name */
    private final Callable<Void> f7026o = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f7027a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "disklrucache#" + this.f7027a.getAndIncrement());
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    class b implements Callable<Void> {
        b() {
        }

        /* renamed from: a */
        public Void call() throws Exception {
            synchronized (p.this) {
                if (p.this.f7020i == null) {
                    return null;
                }
                p.this.z0();
                if (p.this.u0()) {
                    p.this.t0();
                    p.this.f7023l = 0;
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
        private final f f7029a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean[] f7030b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f7031c;

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
                    d.this.f7031c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    d.this.f7031c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i10) {
                try {
                    ((FilterOutputStream) this).out.write(i10);
                } catch (IOException unused) {
                    d.this.f7031c = true;
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
                    d.this.f7031c = true;
                }
            }
        }

        /* synthetic */ d(p pVar, f fVar, a aVar) {
            this(fVar);
        }

        public OutputStream b(int i10) throws IOException {
            FileOutputStream fileOutputStream;
            a aVar;
            if (i10 < 0 || i10 >= p.this.f7018g) {
                throw new IllegalArgumentException("Expected index " + i10 + " to be greater than 0 and less than the maximum value count of " + p.this.f7018g);
            }
            synchronized (p.this) {
                if (this.f7029a.f7038d == this) {
                    if (!this.f7029a.f7037c) {
                        this.f7030b[i10] = true;
                    }
                    File i11 = this.f7029a.i(i10);
                    try {
                        fileOutputStream = new FileOutputStream(i11);
                    } catch (FileNotFoundException unused) {
                        p.this.f7012a.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(i11);
                        } catch (FileNotFoundException unused2) {
                            return p.f7011s;
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
            if (this.f7031c) {
                p.this.o(this, false);
                p.this.Q(this.f7029a.f7035a);
                return;
            }
            p.this.o(this, true);
        }

        public void e() throws IOException {
            p.this.o(this, false);
        }

        private d(f fVar) {
            this.f7029a = fVar;
            this.f7030b = fVar.f7037c ? null : new boolean[p.this.f7018g];
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class e implements Closeable {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream[] f7034a;

        /* synthetic */ e(p pVar, String str, long j10, InputStream[] inputStreamArr, long[] jArr, a aVar) {
            this(pVar, str, j10, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.f7034a) {
                r.a(inputStream);
            }
        }

        private e(p pVar, String str, long j10, InputStream[] inputStreamArr, long[] jArr) {
            this.f7034a = inputStreamArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class f {

        /* renamed from: a  reason: collision with root package name */
        private final String f7035a;

        /* renamed from: b  reason: collision with root package name */
        private final long[] f7036b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f7037c;

        /* renamed from: d  reason: collision with root package name */
        private d f7038d;

        /* renamed from: e  reason: collision with root package name */
        private long f7039e;

        /* synthetic */ f(p pVar, String str, a aVar) {
            this(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(String[] strArr) throws IOException {
            if (strArr.length == p.this.f7018g) {
                for (int i10 = 0; i10 < strArr.length; i10++) {
                    try {
                        this.f7036b[i10] = Long.parseLong(strArr[i10]);
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
            File file = p.this.f7012a;
            return new File(file, this.f7035a + "." + i10);
        }

        public String e() throws IOException {
            long[] jArr;
            StringBuilder sb2 = new StringBuilder();
            for (long j10 : this.f7036b) {
                sb2.append(' ');
                sb2.append(j10);
            }
            return sb2.toString();
        }

        public File i(int i10) {
            File file = p.this.f7012a;
            return new File(file, this.f7035a + "." + i10 + ".tmp");
        }

        private f(String str) {
            this.f7035a = str;
            this.f7036b = new long[p.this.f7018g];
        }
    }

    static {
        a aVar = new a();
        f7009q = aVar;
        f7010r = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), aVar);
    }

    private p(File file, int i10, int i11, long j10) {
        this.f7012a = file;
        this.f7016e = i10;
        this.f7013b = new File(file, "journal");
        this.f7014c = new File(file, "journal.tmp");
        this.f7015d = new File(file, "journal.bkp");
        this.f7018g = i11;
        this.f7017f = j10;
    }

    public static ThreadPoolExecutor E() {
        try {
            ThreadPoolExecutor threadPoolExecutor = f7010r;
            if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
                f7010r = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f7009q);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return f7010r;
    }

    private void V(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i10 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i10);
            if (indexOf2 == -1) {
                str2 = str.substring(i10);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f7022k.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i10, indexOf2);
            }
            f fVar = this.f7022k.get(str2);
            if (fVar == null) {
                fVar = new f(this, str2, null);
                this.f7022k.put(str2, fVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                fVar.f7037c = true;
                fVar.f7038d = null;
                fVar.g(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                fVar.f7038d = new d(this, fVar, null);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private synchronized d d(String str, long j10) throws IOException {
        w0();
        i0(str);
        f fVar = this.f7022k.get(str);
        if (j10 != -1 && (fVar == null || fVar.f7039e != j10)) {
            return null;
        }
        if (fVar == null) {
            fVar = new f(this, str, null);
            this.f7022k.put(str, fVar);
        } else if (fVar.f7038d != null) {
            return null;
        }
        d dVar = new d(this, fVar, null);
        fVar.f7038d = dVar;
        Writer writer = this.f7020i;
        writer.write("DIRTY " + str + '\n');
        this.f7020i.flush();
        return dVar;
    }

    public static p i(File file, int i10, int i11, long j10) throws IOException {
        if (j10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i11 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    v(file2, file3, false);
                }
            }
            p pVar = new p(file, i10, i11, j10);
            if (pVar.f7013b.exists()) {
                try {
                    pVar.o0();
                    pVar.r0();
                    pVar.f7020i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pVar.f7013b, true), r.f7047a));
                    return pVar;
                } catch (Throwable unused) {
                    pVar.k0();
                }
            }
            file.mkdirs();
            p pVar2 = new p(file, i10, i11, j10);
            pVar2.t0();
            return pVar2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    private void i0(String str) {
        if (!f7008p.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void o(d dVar, boolean z10) throws IOException {
        f fVar = dVar.f7029a;
        if (fVar.f7038d == dVar) {
            if (z10 && !fVar.f7037c) {
                for (int i10 = 0; i10 < this.f7018g; i10++) {
                    if (!dVar.f7030b[i10]) {
                        dVar.e();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i10);
                    } else if (!fVar.i(i10).exists()) {
                        dVar.e();
                        return;
                    }
                }
            }
            for (int i11 = 0; i11 < this.f7018g; i11++) {
                File i12 = fVar.i(i11);
                if (!z10) {
                    u(i12);
                } else if (i12.exists()) {
                    File d10 = fVar.d(i11);
                    i12.renameTo(d10);
                    long j10 = fVar.f7036b[i11];
                    long length = d10.length();
                    fVar.f7036b[i11] = length;
                    this.f7019h = (this.f7019h - j10) + length;
                }
            }
            this.f7023l++;
            fVar.f7038d = null;
            if (fVar.f7037c || z10) {
                fVar.f7037c = true;
                this.f7020i.write("CLEAN " + fVar.f7035a + fVar.e() + '\n');
                if (z10) {
                    long j11 = this.f7025n;
                    this.f7025n = 1 + j11;
                    fVar.f7039e = j11;
                }
            } else {
                this.f7022k.remove(fVar.f7035a);
                this.f7020i.write("REMOVE " + fVar.f7035a + '\n');
            }
            this.f7020i.flush();
            if (this.f7019h > this.f7017f || u0()) {
                E().submit(this.f7026o);
            }
            return;
        }
        throw new IllegalStateException();
    }

    private void o0() throws IOException {
        q qVar = new q(new FileInputStream(this.f7013b), r.f7047a);
        try {
            String c10 = qVar.c();
            String c11 = qVar.c();
            String c12 = qVar.c();
            String c13 = qVar.c();
            String c14 = qVar.c();
            if (!"libcore.io.DiskLruCache".equals(c10) || !"1".equals(c11) || !Integer.toString(this.f7016e).equals(c12) || !Integer.toString(this.f7018g).equals(c13) || !"".equals(c14)) {
                throw new IOException("unexpected journal header: [" + c10 + ", " + c11 + ", " + c13 + ", " + c14 + "]");
            }
            int i10 = 0;
            while (true) {
                try {
                    V(qVar.c());
                    i10++;
                } catch (EOFException unused) {
                    this.f7023l = i10 - this.f7022k.size();
                    r.a(qVar);
                    return;
                }
            }
        } catch (Throwable th2) {
            r.a(qVar);
            throw th2;
        }
    }

    private void r0() throws IOException {
        u(this.f7014c);
        Iterator<f> it = this.f7022k.values().iterator();
        while (it.hasNext()) {
            f next = it.next();
            int i10 = 0;
            if (next.f7038d == null) {
                while (i10 < this.f7018g) {
                    this.f7019h += next.f7036b[i10];
                    i10++;
                }
            } else {
                next.f7038d = null;
                while (i10 < this.f7018g) {
                    u(next.d(i10));
                    u(next.i(i10));
                    i10++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void t0() throws IOException {
        Writer writer = this.f7020i;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f7014c), r.f7047a));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f7016e));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f7018g));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (f fVar : this.f7022k.values()) {
            if (fVar.f7038d != null) {
                bufferedWriter.write("DIRTY " + fVar.f7035a + '\n');
            } else {
                bufferedWriter.write("CLEAN " + fVar.f7035a + fVar.e() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.f7013b.exists()) {
            v(this.f7013b, this.f7015d, true);
        }
        v(this.f7014c, this.f7013b, false);
        this.f7015d.delete();
        this.f7020i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f7013b, true), r.f7047a));
    }

    private static void u(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u0() {
        int i10 = this.f7023l;
        return i10 >= 2000 && i10 >= this.f7022k.size();
    }

    private static void v(File file, File file2, boolean z10) throws IOException {
        if (z10) {
            u(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private void w0() {
        if (this.f7020i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() throws IOException {
        while (true) {
            if (this.f7019h > this.f7017f || this.f7022k.size() > this.f7021j) {
                String key = this.f7022k.entrySet().iterator().next().getKey();
                Q(key);
                o oVar = this.f7024m;
                if (oVar != null) {
                    oVar.a(key);
                }
            } else {
                return;
            }
        }
    }

    public synchronized boolean Q(String str) throws IOException {
        w0();
        i0(str);
        f fVar = this.f7022k.get(str);
        if (fVar != null && fVar.f7038d == null) {
            for (int i10 = 0; i10 < this.f7018g; i10++) {
                File d10 = fVar.d(i10);
                if (d10.exists() && !d10.delete()) {
                    throw new IOException("failed to delete " + d10);
                }
                this.f7019h -= fVar.f7036b[i10];
                fVar.f7036b[i10] = 0;
            }
            this.f7023l++;
            this.f7020i.append((CharSequence) ("REMOVE " + str + '\n'));
            this.f7022k.remove(str);
            if (u0()) {
                E().submit(this.f7026o);
            }
            return true;
        }
        return false;
    }

    public synchronized boolean W() {
        return this.f7020i == null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f7020i != null) {
            Iterator it = new ArrayList(this.f7022k.values()).iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                if (fVar.f7038d != null) {
                    fVar.f7038d.e();
                }
            }
            z0();
            this.f7020i.close();
            this.f7020i = null;
        }
    }

    public synchronized e h(String str) throws IOException {
        w0();
        i0(str);
        f fVar = this.f7022k.get(str);
        if (fVar == null) {
            return null;
        }
        if (!fVar.f7037c) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.f7018g];
        for (int i10 = 0; i10 < this.f7018g; i10++) {
            try {
                inputStreamArr[i10] = new FileInputStream(fVar.d(i10));
            } catch (FileNotFoundException unused) {
                for (int i11 = 0; i11 < this.f7018g && inputStreamArr[i11] != null; i11++) {
                    r.a(inputStreamArr[i11]);
                }
                return null;
            }
        }
        this.f7023l++;
        this.f7020i.append((CharSequence) ("READ " + str + '\n'));
        if (u0()) {
            E().submit(this.f7026o);
        }
        return new e(this, str, fVar.f7039e, inputStreamArr, fVar.f7036b, null);
    }

    public synchronized void h0() throws IOException {
        w0();
        z0();
        this.f7020i.flush();
    }

    public void k0() throws IOException {
        close();
        r.b(this.f7012a);
    }

    public void w(o oVar) {
        this.f7024m = oVar;
    }

    public d x(String str) throws IOException {
        return d(str, -1L);
    }
}
