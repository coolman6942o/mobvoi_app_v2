package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.j;
import java.util.List;
import java.util.Map;
import k5.g;
import u4.b;
/* compiled from: GlideContext.java */
/* loaded from: classes.dex */
public class e extends ContextWrapper {

    /* renamed from: k  reason: collision with root package name */
    static final i<?, ?> f7832k = new b();

    /* renamed from: a  reason: collision with root package name */
    private final b f7833a;

    /* renamed from: b  reason: collision with root package name */
    private final Registry f7834b;

    /* renamed from: c  reason: collision with root package name */
    private final g f7835c;

    /* renamed from: d  reason: collision with root package name */
    private final c.a f7836d;

    /* renamed from: e  reason: collision with root package name */
    private final List<j5.b<Object>> f7837e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<Class<?>, i<?, ?>> f7838f;

    /* renamed from: g  reason: collision with root package name */
    private final j f7839g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f7840h;

    /* renamed from: i  reason: collision with root package name */
    private final int f7841i;

    /* renamed from: j  reason: collision with root package name */
    private j5.c f7842j;

    public e(Context context, b bVar, Registry registry, g gVar, c.a aVar, Map<Class<?>, i<?, ?>> map, List<j5.b<Object>> list, j jVar, boolean z10, int i10) {
        super(context.getApplicationContext());
        this.f7833a = bVar;
        this.f7834b = registry;
        this.f7835c = gVar;
        this.f7836d = aVar;
        this.f7837e = list;
        this.f7838f = map;
        this.f7839g = jVar;
        this.f7840h = z10;
        this.f7841i = i10;
    }

    public <X> k5.j<ImageView, X> a(ImageView imageView, Class<X> cls) {
        return this.f7835c.a(imageView, cls);
    }

    public b b() {
        return this.f7833a;
    }

    public List<j5.b<Object>> c() {
        return this.f7837e;
    }

    public synchronized j5.c d() {
        if (this.f7842j == null) {
            this.f7842j = this.f7836d.build().N();
        }
        return this.f7842j;
    }

    public <T> i<?, T> e(Class<T> cls) {
        i<?, T> iVar = (i<?, T>) this.f7838f.get(cls);
        if (iVar == null) {
            for (Map.Entry<Class<?>, i<?, ?>> entry : this.f7838f.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    iVar = (i<?, T>) entry.getValue();
                }
            }
        }
        return iVar == null ? (i<?, T>) f7832k : iVar;
    }

    public j f() {
        return this.f7839g;
    }

    public int g() {
        return this.f7841i;
    }

    public Registry h() {
        return this.f7834b;
    }

    public boolean i() {
        return this.f7840h;
    }
}
