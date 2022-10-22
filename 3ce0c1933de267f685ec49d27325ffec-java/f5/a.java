package f5;

import android.graphics.Bitmap;
import b5.b;
import java.io.ByteArrayOutputStream;
import q4.e;
import t4.c;
/* compiled from: BitmapBytesTranscoder.java */
/* loaded from: classes.dex */
public class a implements e<Bitmap, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final Bitmap.CompressFormat f26351a;

    /* renamed from: b  reason: collision with root package name */
    private final int f26352b;

    public a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Override // f5.e
    public c<byte[]> a(c<Bitmap> cVar, e eVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        cVar.get().compress(this.f26351a, this.f26352b, byteArrayOutputStream);
        cVar.b();
        return new b(byteArrayOutputStream.toByteArray());
    }

    public a(Bitmap.CompressFormat compressFormat, int i10) {
        this.f26351a = compressFormat;
        this.f26352b = i10;
    }
}
