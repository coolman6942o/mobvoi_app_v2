package u4;

import android.graphics.Bitmap;
/* compiled from: BitmapPoolAdapter.java */
/* loaded from: classes.dex */
public class f implements e {
    @Override // u4.e
    public void a(int i10) {
    }

    @Override // u4.e
    public void b() {
    }

    @Override // u4.e
    public void c(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // u4.e
    public Bitmap d(int i10, int i11, Bitmap.Config config) {
        return Bitmap.createBitmap(i10, i11, config);
    }

    @Override // u4.e
    public Bitmap e(int i10, int i11, Bitmap.Config config) {
        return d(i10, i11, config);
    }
}
