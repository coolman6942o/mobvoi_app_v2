package com.bumptech.glide;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.load.engine.q;
import i5.a;
import i5.b;
import i5.c;
import i5.d;
import i5.f;
import j0.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import r4.e;
import x4.n;
import x4.o;
import x4.p;
/* loaded from: classes.dex */
public class Registry {

    /* renamed from: a  reason: collision with root package name */
    private final p f7792a;

    /* renamed from: j  reason: collision with root package name */
    private final e<List<Throwable>> f7801j;

    /* renamed from: h  reason: collision with root package name */
    private final d f7799h = new d();

    /* renamed from: i  reason: collision with root package name */
    private final c f7800i = new c();

    /* renamed from: b  reason: collision with root package name */
    private final a f7793b = new a();

    /* renamed from: c  reason: collision with root package name */
    private final i5.e f7794c = new i5.e();

    /* renamed from: d  reason: collision with root package name */
    private final f f7795d = new f();

    /* renamed from: e  reason: collision with root package name */
    private final r4.f f7796e = new r4.f();

    /* renamed from: f  reason: collision with root package name */
    private final f5.f f7797f = new f5.f();

    /* renamed from: g  reason: collision with root package name */
    private final b f7798g = new b();

    /* loaded from: classes.dex */
    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(String str) {
            super(str);
        }
    }

    /* loaded from: classes.dex */
    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    /* loaded from: classes.dex */
    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(Object obj) {
            super("Failed to find any ModelLoaders for model: " + obj);
        }

        public NoModelLoaderAvailableException(Class<?> cls, Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    /* loaded from: classes.dex */
    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* loaded from: classes.dex */
    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public Registry() {
        e<List<Throwable>> e10 = o5.a.e();
        this.f7801j = e10;
        this.f7792a = new p(e10);
        r(Arrays.asList("Gif", "Bitmap", "BitmapDrawable"));
    }

    private <Data, TResource, Transcode> List<i<Data, TResource, Transcode>> f(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f7794c.d(cls, cls2)) {
            for (Class cls5 : this.f7797f.b(cls4, cls3)) {
                arrayList.add(new i(cls, cls4, cls5, this.f7794c.b(cls, cls4), this.f7797f.a(cls4, cls5), this.f7801j));
            }
        }
        return arrayList;
    }

    public <Data, TResource> Registry a(Class<Data> cls, Class<TResource> cls2, com.bumptech.glide.load.b<Data, TResource> bVar) {
        e("legacy_append", cls, cls2, bVar);
        return this;
    }

    public <Model, Data> Registry b(Class<Model> cls, Class<Data> cls2, o<Model, Data> oVar) {
        this.f7792a.a(cls, cls2, oVar);
        return this;
    }

    public <Data> Registry c(Class<Data> cls, q4.a<Data> aVar) {
        this.f7793b.a(cls, aVar);
        return this;
    }

    public <TResource> Registry d(Class<TResource> cls, q4.f<TResource> fVar) {
        this.f7795d.a(cls, fVar);
        return this;
    }

    public <Data, TResource> Registry e(String str, Class<Data> cls, Class<TResource> cls2, com.bumptech.glide.load.b<Data, TResource> bVar) {
        this.f7794c.a(str, bVar, cls, cls2);
        return this;
    }

    public List<ImageHeaderParser> g() {
        List<ImageHeaderParser> b10 = this.f7798g.b();
        if (!b10.isEmpty()) {
            return b10;
        }
        throw new NoImageHeaderParserException();
    }

    public <Data, TResource, Transcode> q<Data, TResource, Transcode> h(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        q<Data, TResource, Transcode> a10 = this.f7800i.a(cls, cls2, cls3);
        if (this.f7800i.c(a10)) {
            return null;
        }
        if (a10 == null) {
            List<i<Data, TResource, Transcode>> f10 = f(cls, cls2, cls3);
            a10 = f10.isEmpty() ? null : new q<>(cls, cls2, cls3, f10, this.f7801j);
            this.f7800i.d(cls, cls2, cls3, a10);
        }
        return a10;
    }

    public <Model> List<n<Model, ?>> i(Model model) {
        List<n<Model, ?>> d10 = this.f7792a.d(model);
        if (!d10.isEmpty()) {
            return d10;
        }
        throw new NoModelLoaderAvailableException(model);
    }

    public <Model, TResource, Transcode> List<Class<?>> j(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        List<Class<?>> a10 = this.f7799h.a(cls, cls2, cls3);
        if (a10 == null) {
            a10 = new ArrayList<>();
            for (Class<?> cls4 : this.f7792a.c(cls)) {
                for (Class<?> cls5 : this.f7794c.d(cls4, cls2)) {
                    if (!this.f7797f.b(cls5, cls3).isEmpty() && !a10.contains(cls5)) {
                        a10.add(cls5);
                    }
                }
            }
            this.f7799h.b(cls, cls2, cls3, Collections.unmodifiableList(a10));
        }
        return a10;
    }

    public <X> q4.f<X> k(t4.c<X> cVar) throws NoResultEncoderAvailableException {
        q4.f<X> b10 = this.f7795d.b(cVar.d());
        if (b10 != null) {
            return b10;
        }
        throw new NoResultEncoderAvailableException(cVar.d());
    }

    public <X> r4.e<X> l(X x10) {
        return this.f7796e.a(x10);
    }

    public <X> q4.a<X> m(X x10) throws NoSourceEncoderAvailableException {
        q4.a<X> b10 = this.f7793b.b(x10.getClass());
        if (b10 != null) {
            return b10;
        }
        throw new NoSourceEncoderAvailableException(x10.getClass());
    }

    public boolean n(t4.c<?> cVar) {
        return this.f7795d.b(cVar.d()) != null;
    }

    public Registry o(ImageHeaderParser imageHeaderParser) {
        this.f7798g.a(imageHeaderParser);
        return this;
    }

    public <TResource, Transcode> Registry p(Class<TResource> cls, Class<Transcode> cls2, f5.e<TResource, Transcode> eVar) {
        this.f7797f.c(cls, cls2, eVar);
        return this;
    }

    public Registry q(e.a<?> aVar) {
        this.f7796e.b(aVar);
        return this;
    }

    public final Registry r(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.f7794c.e(arrayList);
        return this;
    }
}
