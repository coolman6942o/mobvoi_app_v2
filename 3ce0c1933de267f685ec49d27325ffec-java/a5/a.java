package a5;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.EncodeStrategy;
import java.io.File;
import q4.f;
import t4.c;
import u4.e;
/* compiled from: BitmapDrawableEncoder.java */
/* loaded from: classes.dex */
public class a implements f<BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final e f87a;

    /* renamed from: b  reason: collision with root package name */
    private final f<Bitmap> f88b;

    public a(e eVar, f<Bitmap> fVar) {
        this.f87a = eVar;
        this.f88b = fVar;
    }

    @Override // q4.f
    public EncodeStrategy a(q4.e eVar) {
        return this.f88b.a(eVar);
    }

    /* renamed from: c */
    public boolean b(c<BitmapDrawable> cVar, File file, q4.e eVar) {
        return this.f88b.b(new c(cVar.get().getBitmap(), this.f87a), file, eVar);
    }
}
