package e5;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;
import n5.f;
import n5.k;
import p4.a;
import p4.c;
import p4.d;
import p4.e;
/* compiled from: ByteBufferGifDecoder.java */
/* loaded from: classes.dex */
public class a implements com.bumptech.glide.load.b<ByteBuffer, c> {

    /* renamed from: f  reason: collision with root package name */
    private static final C0279a f25777f = new C0279a();

    /* renamed from: g  reason: collision with root package name */
    private static final b f25778g = new b();

    /* renamed from: a  reason: collision with root package name */
    private final Context f25779a;

    /* renamed from: b  reason: collision with root package name */
    private final List<ImageHeaderParser> f25780b;

    /* renamed from: c  reason: collision with root package name */
    private final b f25781c;

    /* renamed from: d  reason: collision with root package name */
    private final C0279a f25782d;

    /* renamed from: e  reason: collision with root package name */
    private final e5.b f25783e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ByteBufferGifDecoder.java */
    /* renamed from: e5.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0279a {
        C0279a() {
        }

        p4.a a(a.AbstractC0451a aVar, c cVar, ByteBuffer byteBuffer, int i10) {
            return new e(aVar, cVar, byteBuffer, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ByteBufferGifDecoder.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<d> f25784a = k.e(0);

        b() {
        }

        synchronized d a(ByteBuffer byteBuffer) {
            d poll;
            poll = this.f25784a.poll();
            if (poll == null) {
                poll = new d();
            }
            return poll.p(byteBuffer);
        }

        synchronized void b(d dVar) {
            dVar.a();
            this.f25784a.offer(dVar);
        }
    }

    public a(Context context, List<ImageHeaderParser> list, u4.e eVar, u4.b bVar) {
        this(context, list, eVar, bVar, f25778g, f25777f);
    }

    private e c(ByteBuffer byteBuffer, int i10, int i11, d dVar, q4.e eVar) {
        Bitmap.Config config;
        long b10 = f.b();
        try {
            c c10 = dVar.c();
            if (c10.b() > 0 && c10.c() == 0) {
                if (eVar.c(i.f25825a) == DecodeFormat.PREFER_RGB_565) {
                    config = Bitmap.Config.RGB_565;
                } else {
                    config = Bitmap.Config.ARGB_8888;
                }
                p4.a a10 = this.f25782d.a(this.f25783e, c10, byteBuffer, e(c10, i10, i11));
                a10.f(config);
                a10.b();
                Bitmap a11 = a10.a();
                if (a11 == null) {
                    return null;
                }
                e eVar2 = new e(new c(this.f25779a, a10, z4.c.c(), i10, i11, a11));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + f.a(b10));
                }
                return eVar2;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + f.a(b10));
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + f.a(b10));
            }
        }
    }

    private static int e(c cVar, int i10, int i11) {
        int min = Math.min(cVar.a() / i11, cVar.d() / i10);
        int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i10 + "x" + i11 + "], actual dimens: [" + cVar.d() + "x" + cVar.a() + "]");
        }
        return max;
    }

    /* renamed from: d */
    public e a(ByteBuffer byteBuffer, int i10, int i11, q4.e eVar) {
        d a10 = this.f25781c.a(byteBuffer);
        try {
            return c(byteBuffer, i10, i11, a10, eVar);
        } finally {
            this.f25781c.b(a10);
        }
    }

    /* renamed from: f */
    public boolean b(ByteBuffer byteBuffer, q4.e eVar) throws IOException {
        return !((Boolean) eVar.c(i.f25826b)).booleanValue() && com.bumptech.glide.load.a.c(this.f25780b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    a(Context context, List<ImageHeaderParser> list, u4.e eVar, u4.b bVar, b bVar2, C0279a aVar) {
        this.f25779a = context.getApplicationContext();
        this.f25780b = list;
        this.f25782d = aVar;
        this.f25783e = new e5.b(eVar, bVar);
        this.f25781c = bVar2;
    }
}
