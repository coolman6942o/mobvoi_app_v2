package com.liulishuo.filedownloader.download;

import android.os.SystemClock;
import com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException;
import java.io.IOException;
import java.io.InputStream;
import r9.c;
import r9.e;
/* compiled from: FetchDataTask.java */
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final h f15178a;

    /* renamed from: b  reason: collision with root package name */
    private final int f15179b;

    /* renamed from: c  reason: collision with root package name */
    private final int f15180c;

    /* renamed from: d  reason: collision with root package name */
    private final e f15181d;

    /* renamed from: e  reason: collision with root package name */
    private final j9.b f15182e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f15183f;

    /* renamed from: g  reason: collision with root package name */
    private final long f15184g;

    /* renamed from: h  reason: collision with root package name */
    private final long f15185h;

    /* renamed from: i  reason: collision with root package name */
    private final long f15186i;

    /* renamed from: j  reason: collision with root package name */
    private final String f15187j;

    /* renamed from: k  reason: collision with root package name */
    long f15188k;

    /* renamed from: l  reason: collision with root package name */
    private q9.a f15189l;

    /* renamed from: m  reason: collision with root package name */
    private volatile boolean f15190m;

    /* renamed from: n  reason: collision with root package name */
    private final k9.a f15191n;

    /* renamed from: o  reason: collision with root package name */
    private volatile long f15192o;

    /* renamed from: p  reason: collision with root package name */
    private volatile long f15193p;

    /* compiled from: FetchDataTask.java */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        e f15194a;

        /* renamed from: b  reason: collision with root package name */
        j9.b f15195b;

        /* renamed from: c  reason: collision with root package name */
        com.liulishuo.filedownloader.download.b f15196c;

        /* renamed from: d  reason: collision with root package name */
        h f15197d;

        /* renamed from: e  reason: collision with root package name */
        String f15198e;

        /* renamed from: f  reason: collision with root package name */
        Boolean f15199f;

        /* renamed from: g  reason: collision with root package name */
        Integer f15200g;

        /* renamed from: h  reason: collision with root package name */
        Integer f15201h;

        public g a() throws IllegalArgumentException {
            j9.b bVar;
            com.liulishuo.filedownloader.download.b bVar2;
            Integer num;
            if (this.f15199f != null && (bVar = this.f15195b) != null && (bVar2 = this.f15196c) != null && this.f15197d != null && this.f15198e != null && (num = this.f15201h) != null && this.f15200g != null) {
                return new g(bVar, bVar2, this.f15194a, num.intValue(), this.f15200g.intValue(), this.f15199f.booleanValue(), this.f15197d, this.f15198e);
            }
            throw new IllegalArgumentException();
        }

        public b b(h hVar) {
            this.f15197d = hVar;
            return this;
        }

        public b c(j9.b bVar) {
            this.f15195b = bVar;
            return this;
        }

        public b d(int i10) {
            this.f15200g = Integer.valueOf(i10);
            return this;
        }

        public b e(com.liulishuo.filedownloader.download.b bVar) {
            this.f15196c = bVar;
            return this;
        }

        public b f(int i10) {
            this.f15201h = Integer.valueOf(i10);
            return this;
        }

        public b g(e eVar) {
            this.f15194a = eVar;
            return this;
        }

        public b h(String str) {
            this.f15198e = str;
            return this;
        }

        public b i(boolean z10) {
            this.f15199f = Boolean.valueOf(z10);
            return this;
        }
    }

    private void a() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (e.H(this.f15188k - this.f15192o, elapsedRealtime - this.f15193p)) {
            d();
            this.f15192o = this.f15188k;
            this.f15193p = elapsedRealtime;
        }
    }

    private void d() {
        boolean z10;
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            this.f15189l.b();
            z10 = true;
        } catch (IOException e10) {
            if (c.f33469a) {
                c.a(this, "Because of the system cannot guarantee that all the buffers have been synchronized with physical media, or write to filefailed, we just not flushAndSync process to database too %s", e10);
            }
            z10 = false;
        }
        if (z10) {
            int i10 = this.f15180c;
            if (i10 >= 0) {
                this.f15191n.g(this.f15179b, i10, this.f15188k);
            } else {
                this.f15178a.e();
            }
            if (c.f33469a) {
                c.a(this, "require flushAndSync id[%d] index[%d] offset[%d], consume[%d]", Integer.valueOf(this.f15179b), Integer.valueOf(this.f15180c), Long.valueOf(this.f15188k), Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
            }
        }
    }

    public void b() {
        this.f15190m = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x01e6, code lost:
        throw new com.liulishuo.filedownloader.exception.FileDownloadNetworkPolicyException();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c() throws IOException, IllegalAccessException, IllegalArgumentException, FileDownloadGiveUpRetryException {
        q9.a aVar;
        Throwable th2;
        if (!this.f15190m) {
            long h10 = e.h(this.f15180c, this.f15182e);
            if (h10 == -1) {
                h10 = e.i(this.f15182e);
            }
            char c10 = 1;
            int i10 = 0;
            if (h10 != 0) {
                long j10 = this.f15186i;
                if (j10 <= 0 || h10 == j10) {
                    long j11 = this.f15188k;
                    InputStream inputStream = null;
                    try {
                        boolean l10 = c.i().l();
                        if (this.f15181d != null && !l10) {
                            throw new IllegalAccessException("can't using multi-download when the output stream can't support seek");
                        }
                        aVar = e.c(this.f15187j);
                        try {
                            this.f15189l = aVar;
                            if (l10) {
                                aVar.c(this.f15188k);
                            }
                            if (c.f33469a) {
                                c.a(this, "start fetch(%d): range [%d, %d), seek to[%d]", Integer.valueOf(this.f15180c), Long.valueOf(this.f15184g), Long.valueOf(this.f15185h), Long.valueOf(this.f15188k));
                            }
                            inputStream = this.f15182e.a();
                            byte[] bArr = new byte[4096];
                            if (this.f15190m) {
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e10) {
                                        e10.printStackTrace();
                                    }
                                }
                                if (aVar != null) {
                                    try {
                                        d();
                                    } finally {
                                    }
                                }
                                if (aVar != null) {
                                    try {
                                        aVar.close();
                                    } catch (IOException e11) {
                                        e11.printStackTrace();
                                    }
                                }
                            } else {
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read == -1) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e12) {
                                            e12.printStackTrace();
                                        }
                                        if (aVar != null) {
                                            try {
                                                d();
                                            } finally {
                                            }
                                        }
                                        if (aVar != null) {
                                            try {
                                                aVar.close();
                                            } catch (IOException e13) {
                                                e13.printStackTrace();
                                            }
                                        }
                                        long j12 = this.f15188k - j11;
                                        if (h10 == -1 || h10 == j12) {
                                            this.f15178a.a(this.f15181d, this.f15184g, this.f15185h);
                                            return;
                                        }
                                        Object[] objArr = new Object[6];
                                        objArr[i10] = Long.valueOf(j12);
                                        objArr[c10] = Long.valueOf(h10);
                                        objArr[2] = Long.valueOf(this.f15184g);
                                        objArr[3] = Long.valueOf(this.f15185h);
                                        objArr[4] = Long.valueOf(this.f15188k);
                                        objArr[5] = Long.valueOf(j11);
                                        throw new FileDownloadGiveUpRetryException(e.n("fetched length[%d] != content length[%d], range[%d, %d) offset[%d] fetch begin offset[%d]", objArr));
                                    }
                                    aVar.e(bArr, i10, read);
                                    long j13 = read;
                                    this.f15188k += j13;
                                    this.f15178a.c(j13);
                                    a();
                                    if (this.f15190m) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e14) {
                                            e14.printStackTrace();
                                        }
                                        try {
                                            d();
                                            try {
                                                aVar.close();
                                                return;
                                            } catch (IOException e15) {
                                                e15.printStackTrace();
                                                return;
                                            }
                                        } finally {
                                            try {
                                                aVar.close();
                                            } catch (IOException e16) {
                                                e16.printStackTrace();
                                            }
                                        }
                                    } else {
                                        if (this.f15183f && e.I()) {
                                            break;
                                        }
                                        c10 = 1;
                                        i10 = 0;
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e17) {
                                    e17.printStackTrace();
                                }
                            }
                            if (aVar != null) {
                                try {
                                    d();
                                } finally {
                                    try {
                                        aVar.close();
                                    } catch (IOException e18) {
                                        e18.printStackTrace();
                                    }
                                }
                            }
                            if (aVar != null) {
                                try {
                                    aVar.close();
                                } catch (IOException e19) {
                                    e19.printStackTrace();
                                }
                            }
                            throw th2;
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        aVar = null;
                    }
                } else {
                    throw new FileDownloadGiveUpRetryException(e.n("require %s with contentLength(%d), but the backend response contentLength is %d on downloadId[%d]-connectionIndex[%d], please ask your backend dev to fix such problem.", this.f15185h == -1 ? e.n("range[%d-)", Long.valueOf(this.f15188k)) : e.n("range[%d-%d)", Long.valueOf(this.f15188k), Long.valueOf(this.f15185h)), Long.valueOf(this.f15186i), Long.valueOf(h10), Integer.valueOf(this.f15179b), Integer.valueOf(this.f15180c)));
                }
            } else {
                throw new FileDownloadGiveUpRetryException(e.n("there isn't any content need to download on %d-%d with the content-length is 0", Integer.valueOf(this.f15179b), Integer.valueOf(this.f15180c)));
            }
        }
    }

    private g(j9.b bVar, com.liulishuo.filedownloader.download.b bVar2, e eVar, int i10, int i11, boolean z10, h hVar, String str) {
        this.f15192o = 0L;
        this.f15193p = 0L;
        this.f15178a = hVar;
        this.f15187j = str;
        this.f15182e = bVar;
        this.f15183f = z10;
        this.f15181d = eVar;
        this.f15180c = i11;
        this.f15179b = i10;
        this.f15191n = c.i().f();
        this.f15184g = bVar2.f15102a;
        this.f15185h = bVar2.f15104c;
        this.f15188k = bVar2.f15103b;
        this.f15186i = bVar2.f15105d;
    }
}
