package e5;

import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import java.io.File;
import java.io.IOException;
import n5.a;
import q4.e;
import q4.f;
import t4.c;
/* compiled from: GifDrawableEncoder.java */
/* loaded from: classes.dex */
public class d implements f<c> {
    @Override // q4.f
    public EncodeStrategy a(e eVar) {
        return EncodeStrategy.SOURCE;
    }

    /* renamed from: c */
    public boolean b(c<c> cVar, File file, e eVar) {
        try {
            a.e(cVar.get().c(), file);
            return true;
        } catch (IOException e10) {
            if (Log.isLoggable("GifEncoder", 5)) {
                Log.w("GifEncoder", "Failed to encode GIF drawable data", e10);
            }
            return false;
        }
    }
}
