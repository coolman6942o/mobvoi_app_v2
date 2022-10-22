package z4;

import android.annotation.SuppressLint;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.b;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.f;
import com.bumptech.glide.load.resource.bitmap.j;
import java.io.IOException;
import q4.d;
import q4.e;
import t4.c;
/* compiled from: ImageDecoderResourceDecoder.java */
/* loaded from: classes.dex */
public abstract class a<T> implements b<ImageDecoder.Source, T> {

    /* renamed from: a  reason: collision with root package name */
    final j f37275a = j.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImageDecoderResourceDecoder.java */
    /* renamed from: z4.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0544a implements ImageDecoder.OnHeaderDecodedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f37276a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f37277b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f37278c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ DecodeFormat f37279d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ DownsampleStrategy f37280e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ PreferredColorSpace f37281f;

        /* compiled from: ImageDecoderResourceDecoder.java */
        /* renamed from: z4.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0545a implements ImageDecoder.OnPartialImageListener {
            C0545a(C0544a aVar) {
            }

            @Override // android.graphics.ImageDecoder.OnPartialImageListener
            public boolean onPartialImage(ImageDecoder.DecodeException decodeException) {
                return false;
            }
        }

        C0544a(int i10, int i11, boolean z10, DecodeFormat decodeFormat, DownsampleStrategy downsampleStrategy, PreferredColorSpace preferredColorSpace) {
            this.f37276a = i10;
            this.f37277b = i11;
            this.f37278c = z10;
            this.f37279d = decodeFormat;
            this.f37280e = downsampleStrategy;
            this.f37281f = preferredColorSpace;
        }

        @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
        @SuppressLint({"Override"})
        public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
            boolean z10 = false;
            if (a.this.f37275a.c(this.f37276a, this.f37277b, this.f37278c, false)) {
                imageDecoder.setAllocator(3);
            } else {
                imageDecoder.setAllocator(1);
            }
            if (this.f37279d == DecodeFormat.PREFER_RGB_565) {
                imageDecoder.setMemorySizePolicy(0);
            }
            imageDecoder.setOnPartialImageListener(new C0545a(this));
            Size size = imageInfo.getSize();
            int i10 = this.f37276a;
            if (i10 == Integer.MIN_VALUE) {
                i10 = size.getWidth();
            }
            int i11 = this.f37277b;
            if (i11 == Integer.MIN_VALUE) {
                i11 = size.getHeight();
            }
            float b10 = this.f37280e.b(size.getWidth(), size.getHeight(), i10, i11);
            int round = Math.round(size.getWidth() * b10);
            int round2 = Math.round(size.getHeight() * b10);
            if (Log.isLoggable("ImageDecoder", 2)) {
                Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + round + "x" + round2 + "] scaleFactor: " + b10);
            }
            imageDecoder.setTargetSize(round, round2);
            int i12 = Build.VERSION.SDK_INT;
            if (i12 >= 28) {
                if (this.f37281f == PreferredColorSpace.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) {
                    z10 = true;
                }
                imageDecoder.setTargetColorSpace(ColorSpace.get(z10 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
            } else if (i12 >= 26) {
                imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
            }
        }
    }

    protected abstract c<T> c(ImageDecoder.Source source, int i10, int i11, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException;

    /* renamed from: d */
    public final c<T> a(ImageDecoder.Source source, int i10, int i11, e eVar) throws IOException {
        DecodeFormat decodeFormat = (DecodeFormat) eVar.c(f.f8080f);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) eVar.c(DownsampleStrategy.f8068f);
        d<Boolean> dVar = f.f8083i;
        return c(source, i10, i11, new C0544a(i10, i11, eVar.c(dVar) != null && ((Boolean) eVar.c(dVar)).booleanValue(), decodeFormat, downsampleStrategy, (PreferredColorSpace) eVar.c(f.f8081g)));
    }

    /* renamed from: e */
    public final boolean b(ImageDecoder.Source source, e eVar) {
        return true;
    }
}
