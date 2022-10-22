package com.mobvoi.companion.aw.glide;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Registry;
import com.bumptech.glide.c;
import com.mobvoi.companion.aw.glide.d;
import com.mobvoi.companion.aw.watchfacecenter.glide.e;
import com.mobvoi.companion.aw.watchfacecenter.glide.f;
import h5.a;
import java.nio.ByteBuffer;
import x4.g;
/* loaded from: classes2.dex */
public class MobvoiGlideModule extends a {
    @Override // h5.c
    public void a(Context context, c cVar, Registry registry) {
        super.a(context, cVar, registry);
        registry.b(g.class, Bitmap.class, new d.b());
        registry.b(f.class, ByteBuffer.class, new e());
    }
}
