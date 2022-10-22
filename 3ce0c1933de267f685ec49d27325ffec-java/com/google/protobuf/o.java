package com.google.protobuf;

import com.google.protobuf.Descriptors;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* compiled from: ExtensionRegistry.java */
/* loaded from: classes.dex */
public class o extends q {

    /* renamed from: h  reason: collision with root package name */
    static final o f13299h = new o(true);

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, b> f13300d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, b> f13301e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<a, b> f13302f;

    /* renamed from: g  reason: collision with root package name */
    private final Map<a, b> f13303g;

    /* compiled from: ExtensionRegistry.java */
    /* loaded from: classes.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Descriptors.b f13304a;

        /* renamed from: b  reason: collision with root package name */
        private final int f13305b;

        a(Descriptors.b bVar, int i10) {
            this.f13304a = bVar;
            this.f13305b = i10;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f13304a == aVar.f13304a && this.f13305b == aVar.f13305b;
        }

        public int hashCode() {
            return (this.f13304a.hashCode() * 65535) + this.f13305b;
        }
    }

    /* compiled from: ExtensionRegistry.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Descriptors.FieldDescriptor f13306a;

        /* renamed from: b  reason: collision with root package name */
        public final d0 f13307b;
    }

    private o() {
        new HashMap();
        new HashMap();
        this.f13302f = new HashMap();
        new HashMap();
    }

    public static o e() {
        return f13299h;
    }

    public b d(Descriptors.b bVar, int i10) {
        return this.f13302f.get(new a(bVar, i10));
    }

    o(boolean z10) {
        super(q.f13331c);
        this.f13300d = Collections.emptyMap();
        this.f13301e = Collections.emptyMap();
        this.f13302f = Collections.emptyMap();
        this.f13303g = Collections.emptyMap();
    }
}
