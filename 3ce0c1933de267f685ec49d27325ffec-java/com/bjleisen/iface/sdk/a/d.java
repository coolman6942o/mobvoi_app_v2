package com.bjleisen.iface.sdk.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.ByteArrayBuffer;
/* compiled from: AsyncHttpResponseHandler.java */
/* loaded from: classes.dex */
public abstract class d implements h {

    /* renamed from: b  reason: collision with root package name */
    protected static final int f7638b = 0;

    /* renamed from: c  reason: collision with root package name */
    protected static final int f7639c = 1;

    /* renamed from: d  reason: collision with root package name */
    protected static final int f7640d = 2;

    /* renamed from: e  reason: collision with root package name */
    protected static final int f7641e = 3;

    /* renamed from: f  reason: collision with root package name */
    protected static final int f7642f = 4;

    /* renamed from: g  reason: collision with root package name */
    protected static final int f7643g = 5;

    /* renamed from: h  reason: collision with root package name */
    protected static final int f7644h = 6;

    /* renamed from: i  reason: collision with root package name */
    public static final String f7645i = "UTF_8";

    /* renamed from: j  reason: collision with root package name */
    protected static final int f7646j = 4096;

    /* renamed from: k  reason: collision with root package name */
    private Handler f7648k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f7649l;

    /* renamed from: a  reason: collision with root package name */
    private String f7647a = "UTF_8";

    /* renamed from: m  reason: collision with root package name */
    private URI f7650m = null;

    /* renamed from: n  reason: collision with root package name */
    private Header[] f7651n = null;

    /* compiled from: AsyncHttpResponseHandler.java */
    /* loaded from: classes.dex */
    private static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final d f7652a;

        public a(d dVar) {
            this.f7652a = dVar;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            this.f7652a.a(message);
        }
    }

    private static void a() {
    }

    private static void b() {
    }

    private void b(Message message) {
        if (this.f7649l || this.f7648k == null) {
            a(message);
        } else if (!Thread.currentThread().isInterrupted()) {
            this.f7648k.sendMessage(message);
        }
    }

    private static void c() {
    }

    private static void d() {
    }

    @Override // com.bjleisen.iface.sdk.a.h
    public final void a(URI uri) {
        this.f7650m = uri;
    }

    public abstract void a(byte[] bArr);

    public abstract void a(byte[] bArr, Throwable th2);

    @Override // com.bjleisen.iface.sdk.a.h
    public final URI j() {
        return this.f7650m;
    }

    @Override // com.bjleisen.iface.sdk.a.h
    public final Header[] k() {
        return this.f7651n;
    }

    @Override // com.bjleisen.iface.sdk.a.h
    public final boolean l() {
        return this.f7649l;
    }

    public final String m() {
        String str = this.f7647a;
        return str == null ? "UTF_8" : str;
    }

    @Override // com.bjleisen.iface.sdk.a.h
    public final void n() {
        b(a(2, (Object) null));
    }

    @Override // com.bjleisen.iface.sdk.a.h
    public final void o() {
        b(a(3, (Object) null));
    }

    @Override // com.bjleisen.iface.sdk.a.h
    public final void p() {
        b(a(6, (Object) null));
    }

    @Override // com.bjleisen.iface.sdk.a.h
    public final void a(Header[] headerArr) {
        this.f7651n = headerArr;
    }

    @Override // com.bjleisen.iface.sdk.a.h
    public final void a(boolean z10) {
        if (!z10 && Looper.myLooper() == null) {
            z10 = true;
        }
        if (!z10 && this.f7648k == null) {
            this.f7648k = new a(this);
        } else if (z10 && this.f7648k != null) {
            this.f7648k = null;
        }
        this.f7649l = z10;
    }

    private void a(String str) {
        this.f7647a = str;
    }

    @Override // com.bjleisen.iface.sdk.a.h
    public final void a(HttpResponse httpResponse) {
        if (!Thread.currentThread().isInterrupted()) {
            StatusLine statusLine = httpResponse.getStatusLine();
            byte[] a10 = a(httpResponse.getEntity());
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            if (statusLine.getStatusCode() > 300) {
                a(statusLine.getStatusCode(), httpResponse.getAllHeaders(), a10, new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()));
                return;
            }
            b(a(0, new Object[]{Integer.valueOf(statusLine.getStatusCode()), httpResponse.getAllHeaders(), a10}));
        }
    }

    @Override // com.bjleisen.iface.sdk.a.h
    public final void a(int i10, int i11) {
        b(a(4, new Object[]{Integer.valueOf(i10), Integer.valueOf(i11)}));
    }

    @Override // com.bjleisen.iface.sdk.a.h
    public final void a(int i10, Header[] headerArr, byte[] bArr) {
        b(a(0, new Object[]{Integer.valueOf(i10), headerArr, bArr}));
    }

    @Override // com.bjleisen.iface.sdk.a.h
    public final void a(int i10, Header[] headerArr, byte[] bArr, Throwable th2) {
        b(a(1, new Object[]{Integer.valueOf(i10), headerArr, bArr, th2}));
    }

    @Override // com.bjleisen.iface.sdk.a.h
    public final void a(int i10) {
        b(a(5, new Object[]{Integer.valueOf(i10)}));
    }

    protected final void a(Message message) {
        int i10 = message.what;
        if (i10 == 0) {
            Object[] objArr = (Object[]) message.obj;
            if (objArr == null || objArr.length < 3) {
                Log.e("AsyncHttpResponseHandler", "SUCCESS_MESSAGE didn't got enough params");
                return;
            }
            ((Integer) objArr[0]).intValue();
            a((byte[]) objArr[2]);
        } else if (i10 == 1) {
            Object[] objArr2 = (Object[]) message.obj;
            if (objArr2 == null || objArr2.length < 4) {
                Log.e("AsyncHttpResponseHandler", "FAILURE_MESSAGE didn't got enough params");
                return;
            }
            ((Integer) objArr2[0]).intValue();
            a((byte[]) objArr2[2], (Throwable) objArr2[3]);
        } else if (i10 == 4) {
            Object[] objArr3 = (Object[]) message.obj;
            if (objArr3 == null || objArr3.length < 2) {
                Log.e("AsyncHttpResponseHandler", "PROGRESS_MESSAGE didn't got enough params");
                return;
            }
            try {
                ((Integer) objArr3[0]).intValue();
                ((Integer) objArr3[1]).intValue();
            } catch (Throwable th2) {
                Log.e("AsyncHttpResponseHandler", "custom onProgress contains an error", th2);
            }
        }
    }

    private Message a(int i10, Object obj) {
        Handler handler = this.f7648k;
        if (handler != null) {
            return Message.obtain(handler, i10, obj);
        }
        Message obtain = Message.obtain();
        if (obtain == null) {
            return obtain;
        }
        obtain.what = i10;
        obtain.obj = obj;
        return obtain;
    }

    private byte[] a(HttpEntity httpEntity) {
        InputStream content;
        if (httpEntity == null || (content = httpEntity.getContent()) == null) {
            return null;
        }
        long contentLength = httpEntity.getContentLength();
        if (contentLength <= 2147483647L) {
            int i10 = (contentLength > 0L ? 1 : (contentLength == 0L ? 0 : -1));
            try {
                ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(i10 < 0 ? 4096 : (int) contentLength);
                byte[] bArr = new byte[4096];
                int i11 = 0;
                while (true) {
                    int read = content.read(bArr);
                    if (read == -1 || Thread.currentThread().isInterrupted()) {
                        break;
                    }
                    i11 += read;
                    byteArrayBuffer.append(bArr, 0, read);
                    b(a(4, new Object[]{Integer.valueOf(i11), Integer.valueOf((int) (i10 <= 0 ? 1L : contentLength))}));
                }
                com.bjleisen.iface.sdk.a.a.a(content);
                return byteArrayBuffer.toByteArray();
            } catch (OutOfMemoryError unused) {
                System.gc();
                throw new IOException("File too large to fit into available memory");
            }
        } else {
            throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
        }
    }
}
