package a5;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import n5.k;
import q4.d;
import q4.e;
import q4.f;
import t4.c;
/* compiled from: BitmapEncoder.java */
/* loaded from: classes.dex */
public class b implements f<Bitmap> {

    /* renamed from: b  reason: collision with root package name */
    public static final d<Integer> f89b = d.f("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);

    /* renamed from: c  reason: collision with root package name */
    public static final d<Bitmap.CompressFormat> f90c = d.e("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    /* renamed from: a  reason: collision with root package name */
    private final u4.b f91a;

    public b(u4.b bVar) {
        this.f91a = bVar;
    }

    private Bitmap.CompressFormat d(Bitmap bitmap, e eVar) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) eVar.c(f90c);
        if (compressFormat != null) {
            return compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    @Override // q4.f
    public EncodeStrategy a(e eVar) {
        return EncodeStrategy.TRANSFORMED;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0066, code lost:
        if (r6 != null) goto L39;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(c<Bitmap> cVar, File file, e eVar) {
        Throwable th2;
        IOException e10;
        FileOutputStream fileOutputStream;
        Bitmap bitmap = cVar.get();
        Bitmap.CompressFormat d10 = d(bitmap, eVar);
        o5.b.c("encode: [%dx%d] %s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), d10);
        try {
            long b10 = n5.f.b();
            int intValue = ((Integer) eVar.c(f89b)).intValue();
            boolean z10 = false;
            r4.c cVar2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e11) {
                    e10 = e11;
                }
            } catch (Throwable th3) {
                th2 = th3;
            }
            try {
                cVar2 = this.f91a != null ? new r4.c(fileOutputStream, this.f91a) : fileOutputStream;
                bitmap.compress(d10, intValue, cVar2);
                cVar2.close();
                z10 = true;
            } catch (IOException e12) {
                e10 = e12;
                cVar2 = fileOutputStream;
                if (Log.isLoggable("BitmapEncoder", 3)) {
                    Log.d("BitmapEncoder", "Failed to encode Bitmap", e10);
                }
            } catch (Throwable th4) {
                th2 = th4;
                cVar2 = fileOutputStream;
                if (cVar2 != null) {
                    try {
                        cVar2.close();
                    } catch (IOException unused) {
                    }
                }
                throw th2;
            }
            try {
                cVar2.close();
            } catch (IOException unused2) {
                if (Log.isLoggable("BitmapEncoder", 2)) {
                    Log.v("BitmapEncoder", "Compressed with type: " + d10 + " of size " + k.g(bitmap) + " in " + n5.f.a(b10) + ", options format: " + eVar.c(f90c) + ", hasAlpha: " + bitmap.hasAlpha());
                }
                return z10;
            }
        } finally {
            o5.b.d();
        }
    }
}
