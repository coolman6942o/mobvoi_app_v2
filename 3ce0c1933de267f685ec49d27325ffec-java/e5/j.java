package e5;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import q4.e;
import t4.c;
/* compiled from: StreamGifDecoder.java */
/* loaded from: classes.dex */
public class j implements b<InputStream, c> {

    /* renamed from: a  reason: collision with root package name */
    private final List<ImageHeaderParser> f25827a;

    /* renamed from: b  reason: collision with root package name */
    private final b<ByteBuffer, c> f25828b;

    /* renamed from: c  reason: collision with root package name */
    private final u4.b f25829c;

    public j(List<ImageHeaderParser> list, b<ByteBuffer, c> bVar, u4.b bVar2) {
        this.f25827a = list;
        this.f25828b = bVar;
        this.f25829c = bVar2;
    }

    private static byte[] e(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e10) {
            if (!Log.isLoggable("StreamGifDecoder", 5)) {
                return null;
            }
            Log.w("StreamGifDecoder", "Error reading data from stream", e10);
            return null;
        }
    }

    /* renamed from: c */
    public c<c> a(InputStream inputStream, int i10, int i11, e eVar) throws IOException {
        byte[] e10 = e(inputStream);
        if (e10 == null) {
            return null;
        }
        return this.f25828b.a(ByteBuffer.wrap(e10), i10, i11, eVar);
    }

    /* renamed from: d */
    public boolean b(InputStream inputStream, e eVar) throws IOException {
        return !((Boolean) eVar.c(i.f25826b)).booleanValue() && a.b(this.f25827a, inputStream, this.f25829c) == ImageHeaderParser.ImageType.GIF;
    }
}
