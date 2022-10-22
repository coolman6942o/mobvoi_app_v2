package r4;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.IOException;
import java.io.OutputStream;
import u4.b;
/* compiled from: BufferedOutputStream.java */
/* loaded from: classes.dex */
public final class c extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    private final OutputStream f33406a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f33407b;

    /* renamed from: c  reason: collision with root package name */
    private b f33408c;

    /* renamed from: d  reason: collision with root package name */
    private int f33409d;

    public c(OutputStream outputStream, b bVar) {
        this(outputStream, bVar, WXMediaMessage.THUMB_LENGTH_LIMIT);
    }

    private void c() throws IOException {
        int i10 = this.f33409d;
        if (i10 > 0) {
            this.f33406a.write(this.f33407b, 0, i10);
            this.f33409d = 0;
        }
    }

    private void d() throws IOException {
        if (this.f33409d == this.f33407b.length) {
            c();
        }
    }

    private void h() {
        byte[] bArr = this.f33407b;
        if (bArr != null) {
            this.f33408c.d(bArr);
            this.f33407b = null;
        }
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.f33406a.close();
            h();
        } catch (Throwable th2) {
            this.f33406a.close();
            throw th2;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        c();
        this.f33406a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        byte[] bArr = this.f33407b;
        int i11 = this.f33409d;
        this.f33409d = i11 + 1;
        bArr[i11] = (byte) i10;
        d();
    }

    c(OutputStream outputStream, b bVar, int i10) {
        this.f33406a = outputStream;
        this.f33408c = bVar;
        this.f33407b = (byte[]) bVar.e(i10, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = 0;
        do {
            int i13 = i11 - i12;
            int i14 = i10 + i12;
            int i15 = this.f33409d;
            if (i15 != 0 || i13 < this.f33407b.length) {
                int min = Math.min(i13, this.f33407b.length - i15);
                System.arraycopy(bArr, i14, this.f33407b, this.f33409d, min);
                this.f33409d += min;
                i12 += min;
                d();
            } else {
                this.f33406a.write(bArr, i14, i13);
                return;
            }
        } while (i12 < i11);
    }
}
