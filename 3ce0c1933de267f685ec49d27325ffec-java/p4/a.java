package p4;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;
/* compiled from: GifDecoder.java */
/* loaded from: classes.dex */
public interface a {

    /* compiled from: GifDecoder.java */
    /* renamed from: p4.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface AbstractC0451a {
        Bitmap a(int i10, int i11, Bitmap.Config config);

        int[] b(int i10);

        void c(Bitmap bitmap);

        void d(byte[] bArr);

        byte[] e(int i10);

        void f(int[] iArr);
    }

    Bitmap a();

    void b();

    ByteBuffer c();

    void clear();

    int d();

    int e();

    void f(Bitmap.Config config);

    void g();

    int h();

    int i();
}
