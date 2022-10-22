package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import q4.d;
/* compiled from: VideoDecoder.java */
/* loaded from: classes.dex */
public class q<T> implements com.bumptech.glide.load.b<T, Bitmap> {

    /* renamed from: d  reason: collision with root package name */
    public static final q4.d<Long> f8123d = q4.d.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());

    /* renamed from: e  reason: collision with root package name */
    public static final q4.d<Integer> f8124e = q4.d.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());

    /* renamed from: f  reason: collision with root package name */
    private static final d f8125f = new d();

    /* renamed from: a  reason: collision with root package name */
    private final e<T> f8126a;

    /* renamed from: b  reason: collision with root package name */
    private final u4.e f8127b;

    /* renamed from: c  reason: collision with root package name */
    private final d f8128c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoDecoder.java */
    /* loaded from: classes.dex */
    public class a implements d.b<Long> {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f8129a = ByteBuffer.allocate(8);

        a() {
        }

        /* renamed from: b */
        public void a(byte[] bArr, Long l10, MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f8129a) {
                this.f8129a.position(0);
                messageDigest.update(this.f8129a.putLong(l10.longValue()).array());
            }
        }
    }

    /* compiled from: VideoDecoder.java */
    /* loaded from: classes.dex */
    class b implements d.b<Integer> {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f8130a = ByteBuffer.allocate(4);

        b() {
        }

        /* renamed from: b */
        public void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
            if (num != null) {
                messageDigest.update(bArr);
                synchronized (this.f8130a) {
                    this.f8130a.position(0);
                    messageDigest.update(this.f8130a.putInt(num.intValue()).array());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VideoDecoder.java */
    /* loaded from: classes.dex */
    public static final class c implements e<AssetFileDescriptor> {
        private c() {
        }

        /* renamed from: b */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* compiled from: VideoDecoder.java */
    /* loaded from: classes.dex */
    static class d {
        d() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoDecoder.java */
    /* loaded from: classes.dex */
    public interface e<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoDecoder.java */
    /* loaded from: classes.dex */
    public static final class f implements e<ParcelFileDescriptor> {
        f() {
        }

        /* renamed from: b */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    q(u4.e eVar, e<T> eVar2) {
        this(eVar, eVar2, f8125f);
    }

    public static com.bumptech.glide.load.b<AssetFileDescriptor, Bitmap> c(u4.e eVar) {
        return new q(eVar, new c(null));
    }

    private static Bitmap d(MediaMetadataRetriever mediaMetadataRetriever, long j10, int i10, int i11, int i12, DownsampleStrategy downsampleStrategy) {
        Bitmap f10 = (Build.VERSION.SDK_INT < 27 || i11 == Integer.MIN_VALUE || i12 == Integer.MIN_VALUE || downsampleStrategy == DownsampleStrategy.f8066d) ? null : f(mediaMetadataRetriever, j10, i10, i11, i12, downsampleStrategy);
        return f10 == null ? e(mediaMetadataRetriever, j10, i10) : f10;
    }

    private static Bitmap e(MediaMetadataRetriever mediaMetadataRetriever, long j10, int i10) {
        return mediaMetadataRetriever.getFrameAtTime(j10, i10);
    }

    @TargetApi(27)
    private static Bitmap f(MediaMetadataRetriever mediaMetadataRetriever, long j10, int i10, int i11, int i12, DownsampleStrategy downsampleStrategy) {
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                parseInt2 = parseInt;
                parseInt = parseInt2;
            }
            float b10 = downsampleStrategy.b(parseInt, parseInt2, i11, i12);
            return mediaMetadataRetriever.getScaledFrameAtTime(j10, i10, Math.round(parseInt * b10), Math.round(b10 * parseInt2));
        } catch (Throwable th2) {
            if (!Log.isLoggable("VideoDecoder", 3)) {
                return null;
            }
            Log.d("VideoDecoder", "Exception trying to decode frame on oreo+", th2);
            return null;
        }
    }

    public static com.bumptech.glide.load.b<ParcelFileDescriptor, Bitmap> g(u4.e eVar) {
        return new q(eVar, new f());
    }

    /* JADX WARN: Finally extract failed */
    @Override // com.bumptech.glide.load.b
    public t4.c<Bitmap> a(T t10, int i10, int i11, q4.e eVar) throws IOException {
        long longValue = ((Long) eVar.c(f8123d)).longValue();
        if (longValue >= 0 || longValue == -1) {
            Integer num = (Integer) eVar.c(f8124e);
            if (num == null) {
                num = 2;
            }
            DownsampleStrategy downsampleStrategy = (DownsampleStrategy) eVar.c(DownsampleStrategy.f8068f);
            if (downsampleStrategy == null) {
                downsampleStrategy = DownsampleStrategy.f8067e;
            }
            DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
            MediaMetadataRetriever a10 = this.f8128c.a();
            try {
                try {
                    this.f8126a.a(a10, t10);
                    Bitmap d10 = d(a10, longValue, num.intValue(), i10, i11, downsampleStrategy2);
                    a10.release();
                    return a5.c.f(d10, this.f8127b);
                } catch (RuntimeException e10) {
                    throw new IOException(e10);
                }
            } catch (Throwable th2) {
                a10.release();
                throw th2;
            }
        } else {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
    }

    @Override // com.bumptech.glide.load.b
    public boolean b(T t10, q4.e eVar) {
        return true;
    }

    q(u4.e eVar, e<T> eVar2, d dVar) {
        this.f8127b = eVar;
        this.f8126a = eVar2;
        this.f8128c = dVar;
    }
}
