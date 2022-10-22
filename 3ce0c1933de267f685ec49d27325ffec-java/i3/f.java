package i3;

import com.airbnb.lottie.model.layer.a;
import d3.c;
import d3.p;
import h3.b;
import h3.l;
/* compiled from: Repeater.java */
/* loaded from: classes.dex */
public class f implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f28042a;

    /* renamed from: b  reason: collision with root package name */
    private final b f28043b;

    /* renamed from: c  reason: collision with root package name */
    private final b f28044c;

    /* renamed from: d  reason: collision with root package name */
    private final l f28045d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f28046e;

    public f(String str, b bVar, b bVar2, l lVar, boolean z10) {
        this.f28042a = str;
        this.f28043b = bVar;
        this.f28044c = bVar2;
        this.f28045d = lVar;
        this.f28046e = z10;
    }

    @Override // i3.b
    public c a(com.airbnb.lottie.f fVar, a aVar) {
        return new p(fVar, aVar, this);
    }

    public b b() {
        return this.f28043b;
    }

    public String c() {
        return this.f28042a;
    }

    public b d() {
        return this.f28044c;
    }

    public l e() {
        return this.f28045d;
    }

    public boolean f() {
        return this.f28046e;
    }
}
