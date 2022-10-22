package n5;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ByteBufferUtil.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReference<byte[]> f31022a = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ByteBufferUtil.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        final int f31025a;

        /* renamed from: b  reason: collision with root package name */
        final int f31026b;

        /* renamed from: c  reason: collision with root package name */
        final byte[] f31027c;

        b(byte[] bArr, int i10, int i11) {
            this.f31027c = bArr;
            this.f31025a = i10;
            this.f31026b = i11;
        }
    }

    public static ByteBuffer a(File file) throws IOException {
        Throwable th2;
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel = null;
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new IOException("File too large to map into memory");
            } else if (length != 0) {
                randomAccessFile = new RandomAccessFile(file, "r");
                try {
                    fileChannel = randomAccessFile.getChannel();
                    MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                    try {
                        fileChannel.close();
                    } catch (IOException unused) {
                    }
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused2) {
                    }
                    return load;
                } catch (Throwable th3) {
                    th2 = th3;
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th2;
                }
            } else {
                throw new IOException("File unsuitable for memory mapping");
            }
        } catch (Throwable th4) {
            th2 = th4;
            randomAccessFile = null;
        }
    }

    public static ByteBuffer b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        byte[] andSet = f31022a.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (true) {
            int read = inputStream.read(andSet);
            if (read >= 0) {
                byteArrayOutputStream.write(andSet, 0, read);
            } else {
                f31022a.set(andSet);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return (ByteBuffer) ByteBuffer.allocateDirect(byteArray.length).put(byteArray).position(0);
            }
        }
    }

    private static b c(ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }

    public static byte[] d(ByteBuffer byteBuffer) {
        b c10 = c(byteBuffer);
        if (c10 != null && c10.f31025a == 0 && c10.f31026b == c10.f31027c.length) {
            return byteBuffer.array();
        }
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[asReadOnlyBuffer.limit()];
        asReadOnlyBuffer.position(0);
        asReadOnlyBuffer.get(bArr);
        return bArr;
    }

    public static void e(ByteBuffer byteBuffer, File file) throws IOException {
        Throwable th2;
        RandomAccessFile randomAccessFile;
        byteBuffer.position(0);
        FileChannel fileChannel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileChannel = randomAccessFile.getChannel();
                fileChannel.write(byteBuffer);
                fileChannel.force(false);
                fileChannel.close();
                randomAccessFile.close();
                try {
                    fileChannel.close();
                } catch (IOException unused) {
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
            } catch (Throwable th3) {
                th2 = th3;
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException unused3) {
                    }
                }
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            randomAccessFile = null;
        }
    }

    public static InputStream f(ByteBuffer byteBuffer) {
        return new C0408a(byteBuffer);
    }

    /* compiled from: ByteBufferUtil.java */
    /* renamed from: n5.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0408a extends InputStream {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f31023a;

        /* renamed from: b  reason: collision with root package name */
        private int f31024b = -1;

        C0408a(ByteBuffer byteBuffer) {
            this.f31023a = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f31023a.remaining();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i10) {
            this.f31024b = this.f31023a.position();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            if (!this.f31023a.hasRemaining()) {
                return -1;
            }
            return this.f31023a.get() & 255;
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            int i10 = this.f31024b;
            if (i10 != -1) {
                this.f31023a.position(i10);
            } else {
                throw new IOException("Cannot reset to unset mark position");
            }
        }

        @Override // java.io.InputStream
        public long skip(long j10) throws IOException {
            if (!this.f31023a.hasRemaining()) {
                return -1L;
            }
            long min = Math.min(j10, available());
            ByteBuffer byteBuffer = this.f31023a;
            byteBuffer.position((int) (byteBuffer.position() + min));
            return min;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            if (!this.f31023a.hasRemaining()) {
                return -1;
            }
            int min = Math.min(i11, available());
            this.f31023a.get(bArr, i10, min);
            return min;
        }
    }
}
