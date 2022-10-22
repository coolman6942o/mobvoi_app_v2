package okio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import rp.d;
/* compiled from: BufferedSource.kt */
/* loaded from: classes3.dex */
public interface e extends t, ReadableByteChannel {
    long A(ByteString byteString) throws IOException;

    boolean B() throws IOException;

    void B0(long j10) throws IOException;

    long E0() throws IOException;

    long F(ByteString byteString) throws IOException;

    InputStream F0();

    long H() throws IOException;

    String J(long j10) throws IOException;

    String X(Charset charset) throws IOException;

    c b();

    ByteString d0() throws IOException;

    int e0(d dVar) throws IOException;

    void f(long j10) throws IOException;

    ByteString k(long j10) throws IOException;

    String n0() throws IOException;

    byte[] p0(long j10) throws IOException;

    int read(byte[] bArr, int i10, int i11) throws IOException;

    byte readByte() throws IOException;

    int readInt() throws IOException;

    short readShort() throws IOException;

    boolean request(long j10) throws IOException;

    long y0(r rVar) throws IOException;

    byte[] z() throws IOException;
}
