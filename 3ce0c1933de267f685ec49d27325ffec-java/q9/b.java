package q9;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import r9.b;
/* compiled from: FileDownloadRandomAccessFile.java */
/* loaded from: classes2.dex */
public class b implements q9.a {

    /* renamed from: a  reason: collision with root package name */
    private final BufferedOutputStream f32935a;

    /* renamed from: b  reason: collision with root package name */
    private final FileDescriptor f32936b;

    /* renamed from: c  reason: collision with root package name */
    private final RandomAccessFile f32937c;

    /* compiled from: FileDownloadRandomAccessFile.java */
    /* loaded from: classes2.dex */
    public static class a implements b.d {
        @Override // r9.b.d
        public q9.a a(File file) throws IOException {
            return new b(file);
        }

        @Override // r9.b.d
        public boolean b() {
            return true;
        }
    }

    b(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.f32937c = randomAccessFile;
        this.f32936b = randomAccessFile.getFD();
        this.f32935a = new BufferedOutputStream(new FileOutputStream(randomAccessFile.getFD()));
    }

    @Override // q9.a
    public void a(long j10) throws IOException {
        this.f32937c.setLength(j10);
    }

    @Override // q9.a
    public void b() throws IOException {
        this.f32935a.flush();
        this.f32936b.sync();
    }

    @Override // q9.a
    public void c(long j10) throws IOException {
        this.f32937c.seek(j10);
    }

    @Override // q9.a
    public void close() throws IOException {
        this.f32935a.close();
        this.f32937c.close();
    }

    @Override // q9.a
    public void e(byte[] bArr, int i10, int i11) throws IOException {
        this.f32935a.write(bArr, i10, i11);
    }
}
