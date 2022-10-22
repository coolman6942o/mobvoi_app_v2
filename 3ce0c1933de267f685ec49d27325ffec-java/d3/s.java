package d3;

import com.airbnb.lottie.model.content.ShapeTrimPath;
import e3.a;
import java.util.ArrayList;
import java.util.List;
/* compiled from: TrimPathContent.java */
/* loaded from: classes.dex */
public class s implements c, a.b {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f25126a;

    /* renamed from: b  reason: collision with root package name */
    private final List<a.b> f25127b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final ShapeTrimPath.Type f25128c;

    /* renamed from: d  reason: collision with root package name */
    private final a<?, Float> f25129d;

    /* renamed from: e  reason: collision with root package name */
    private final a<?, Float> f25130e;

    /* renamed from: f  reason: collision with root package name */
    private final a<?, Float> f25131f;

    public s(com.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        shapeTrimPath.c();
        this.f25126a = shapeTrimPath.g();
        this.f25128c = shapeTrimPath.f();
        a<Float, Float> a10 = shapeTrimPath.e().a();
        this.f25129d = a10;
        a<Float, Float> a11 = shapeTrimPath.b().a();
        this.f25130e = a11;
        a<Float, Float> a12 = shapeTrimPath.d().a();
        this.f25131f = a12;
        aVar.j(a10);
        aVar.j(a11);
        aVar.j(a12);
        a10.a(this);
        a11.a(this);
        a12.a(this);
    }

    @Override // e3.a.b
    public void b() {
        for (int i10 = 0; i10 < this.f25127b.size(); i10++) {
            this.f25127b.get(i10).b();
        }
    }

    @Override // d3.c
    public void c(List<c> list, List<c> list2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(a.b bVar) {
        this.f25127b.add(bVar);
    }

    public a<?, Float> f() {
        return this.f25130e;
    }

    public a<?, Float> h() {
        return this.f25131f;
    }

    public a<?, Float> i() {
        return this.f25129d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type j() {
        return this.f25128c;
    }

    public boolean k() {
        return this.f25126a;
    }
}
