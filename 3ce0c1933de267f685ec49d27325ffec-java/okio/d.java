package okio;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;
/* compiled from: BufferedSink.kt */
/* loaded from: classes3.dex */
public interface d extends r, WritableByteChannel {
    d C(int i10) throws IOException;

    d C0(long j10) throws IOException;

    d G() throws IOException;

    d R(String str) throws IOException;

    d a0(String str, int i10, int i11) throws IOException;

    c b();

    long b0(t tVar) throws IOException;

    d c0(long j10) throws IOException;

    d e(byte[] bArr, int i10, int i11) throws IOException;

    @Override // okio.r, java.io.Flushable
    void flush() throws IOException;

    d p(int i10) throws IOException;

    d s0(byte[] bArr) throws IOException;

    d t(int i10) throws IOException;

    d v0(ByteString byteString) throws IOException;
}
