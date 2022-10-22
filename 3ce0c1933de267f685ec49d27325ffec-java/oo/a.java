package oo;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.i;
/* compiled from: IOStreams.kt */
/* loaded from: classes3.dex */
public final class a {
    public static final long a(InputStream copyTo, OutputStream out, int i10) {
        i.f(copyTo, "$this$copyTo");
        i.f(out, "out");
        byte[] bArr = new byte[i10];
        int read = copyTo.read(bArr);
        long j10 = 0;
        while (read >= 0) {
            out.write(bArr, 0, read);
            j10 += read;
            read = copyTo.read(bArr);
        }
        return j10;
    }

    public static /* synthetic */ long b(InputStream inputStream, OutputStream outputStream, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 8192;
        }
        return a(inputStream, outputStream, i10);
    }

    public static final byte[] c(InputStream readBytes) {
        i.f(readBytes, "$this$readBytes");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, readBytes.available()));
        b(readBytes, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        i.e(byteArray, "buffer.toByteArray()");
        return byteArray;
    }
}
