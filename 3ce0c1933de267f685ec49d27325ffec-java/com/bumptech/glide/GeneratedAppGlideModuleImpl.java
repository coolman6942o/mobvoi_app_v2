package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import com.mobvoi.companion.aw.glide.MobvoiGlideModule;
import java.util.Collections;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {

    /* renamed from: a  reason: collision with root package name */
    private final MobvoiGlideModule f7791a = new MobvoiGlideModule();

    public GeneratedAppGlideModuleImpl(Context context) {
        if (Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Discovered AppGlideModule from annotation: com.mobvoi.companion.aw.glide.MobvoiGlideModule");
        }
    }

    @Override // h5.c
    public void a(Context context, c cVar, Registry registry) {
        this.f7791a.a(context, cVar, registry);
    }

    @Override // h5.a
    public void b(Context context, d dVar) {
        this.f7791a.b(context, dVar);
    }

    @Override // h5.a
    public boolean c() {
        return this.f7791a.c();
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    public Set<Class<?>> d() {
        return Collections.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public a e() {
        return new a();
    }
}
