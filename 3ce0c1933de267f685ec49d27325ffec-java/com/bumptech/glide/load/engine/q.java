package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.i;
import j0.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import n5.j;
import t4.c;
/* compiled from: LoadPath.java */
/* loaded from: classes.dex */
public class q<Data, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final e<List<Throwable>> f8027a;

    /* renamed from: b  reason: collision with root package name */
    private final List<? extends i<Data, ResourceType, Transcode>> f8028b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8029c;

    public q(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<i<Data, ResourceType, Transcode>> list, e<List<Throwable>> eVar) {
        this.f8027a = eVar;
        this.f8028b = (List) j.c(list);
        this.f8029c = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private c<Transcode> b(r4.e<Data> eVar, q4.e eVar2, int i10, int i11, i.a<ResourceType> aVar, List<Throwable> list) throws GlideException {
        int size = this.f8028b.size();
        c<Transcode> cVar = null;
        for (int i12 = 0; i12 < size; i12++) {
            try {
                cVar = this.f8028b.get(i12).a(eVar, i10, i11, eVar2, aVar);
            } catch (GlideException e10) {
                list.add(e10);
            }
            if (cVar != null) {
                break;
            }
        }
        if (cVar != null) {
            return cVar;
        }
        throw new GlideException(this.f8029c, new ArrayList(list));
    }

    public c<Transcode> a(r4.e<Data> eVar, q4.e eVar2, int i10, int i11, i.a<ResourceType> aVar) throws GlideException {
        List<Throwable> list = (List) j.d(this.f8027a.b());
        try {
            return b(eVar, eVar2, i10, i11, aVar, list);
        } finally {
            this.f8027a.a(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f8028b.toArray()) + '}';
    }
}
