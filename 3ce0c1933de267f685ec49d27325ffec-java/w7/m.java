package w7;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;
/* compiled from: ShapePath.java */
/* loaded from: classes.dex */
public class m {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public float f36107a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public float f36108b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public float f36109c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public float f36110d;
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    public float f36111e;
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    public float f36112f;

    /* renamed from: g  reason: collision with root package name */
    private final List<f> f36113g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private final List<g> f36114h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private boolean f36115i;

    /* compiled from: ShapePath.java */
    /* loaded from: classes.dex */
    class a extends g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f36116b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Matrix f36117c;

        a(m mVar, List list, Matrix matrix) {
            this.f36116b = list;
            this.f36117c = matrix;
        }

        @Override // w7.m.g
        public void a(Matrix matrix, v7.a aVar, int i10, Canvas canvas) {
            for (g gVar : this.f36116b) {
                gVar.a(this.f36117c, aVar, i10, canvas);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShapePath.java */
    /* loaded from: classes.dex */
    public static class b extends g {

        /* renamed from: b  reason: collision with root package name */
        private final d f36118b;

        public b(d dVar) {
            this.f36118b = dVar;
        }

        @Override // w7.m.g
        public void a(Matrix matrix, v7.a aVar, int i10, Canvas canvas) {
            aVar.a(canvas, matrix, new RectF(this.f36118b.k(), this.f36118b.o(), this.f36118b.l(), this.f36118b.j()), i10, this.f36118b.m(), this.f36118b.n());
        }
    }

    /* compiled from: ShapePath.java */
    /* loaded from: classes.dex */
    static class c extends g {

        /* renamed from: b  reason: collision with root package name */
        private final e f36119b;

        /* renamed from: c  reason: collision with root package name */
        private final float f36120c;

        /* renamed from: d  reason: collision with root package name */
        private final float f36121d;

        public c(e eVar, float f10, float f11) {
            this.f36119b = eVar;
            this.f36120c = f10;
            this.f36121d = f11;
        }

        @Override // w7.m.g
        public void a(Matrix matrix, v7.a aVar, int i10, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f36119b.f36130c - this.f36121d, this.f36119b.f36129b - this.f36120c), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.f36120c, this.f36121d);
            matrix2.preRotate(c());
            aVar.b(canvas, matrix2, rectF, i10);
        }

        float c() {
            return (float) Math.toDegrees(Math.atan((this.f36119b.f36130c - this.f36121d) / (this.f36119b.f36129b - this.f36120c)));
        }
    }

    /* compiled from: ShapePath.java */
    /* loaded from: classes.dex */
    public static class d extends f {

        /* renamed from: h  reason: collision with root package name */
        private static final RectF f36122h = new RectF();
        @Deprecated

        /* renamed from: b  reason: collision with root package name */
        public float f36123b;
        @Deprecated

        /* renamed from: c  reason: collision with root package name */
        public float f36124c;
        @Deprecated

        /* renamed from: d  reason: collision with root package name */
        public float f36125d;
        @Deprecated

        /* renamed from: e  reason: collision with root package name */
        public float f36126e;
        @Deprecated

        /* renamed from: f  reason: collision with root package name */
        public float f36127f;
        @Deprecated

        /* renamed from: g  reason: collision with root package name */
        public float f36128g;

        public d(float f10, float f11, float f12, float f13) {
            q(f10);
            u(f11);
            r(f12);
            p(f13);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float j() {
            return this.f36126e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float k() {
            return this.f36123b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float l() {
            return this.f36125d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float m() {
            return this.f36127f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float n() {
            return this.f36128g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float o() {
            return this.f36124c;
        }

        private void p(float f10) {
            this.f36126e = f10;
        }

        private void q(float f10) {
            this.f36123b = f10;
        }

        private void r(float f10) {
            this.f36125d = f10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(float f10) {
            this.f36127f = f10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t(float f10) {
            this.f36128g = f10;
        }

        private void u(float f10) {
            this.f36124c = f10;
        }

        @Override // w7.m.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f36131a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f36122h;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(matrix);
        }
    }

    /* compiled from: ShapePath.java */
    /* loaded from: classes.dex */
    public static class e extends f {

        /* renamed from: b  reason: collision with root package name */
        private float f36129b;

        /* renamed from: c  reason: collision with root package name */
        private float f36130c;

        @Override // w7.m.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f36131a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f36129b, this.f36130c);
            path.transform(matrix);
        }
    }

    /* compiled from: ShapePath.java */
    /* loaded from: classes.dex */
    public static abstract class f {

        /* renamed from: a  reason: collision with root package name */
        protected final Matrix f36131a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShapePath.java */
    /* loaded from: classes.dex */
    public static abstract class g {

        /* renamed from: a  reason: collision with root package name */
        static final Matrix f36132a = new Matrix();

        g() {
        }

        public abstract void a(Matrix matrix, v7.a aVar, int i10, Canvas canvas);

        public final void b(v7.a aVar, int i10, Canvas canvas) {
            a(f36132a, aVar, i10, canvas);
        }
    }

    public m() {
        n(0.0f, 0.0f);
    }

    private void b(float f10) {
        if (g() != f10) {
            float g10 = ((f10 - g()) + 360.0f) % 360.0f;
            if (g10 <= 180.0f) {
                d dVar = new d(i(), j(), i(), j());
                dVar.s(g());
                dVar.t(g10);
                this.f36114h.add(new b(dVar));
                p(f10);
            }
        }
    }

    private void c(g gVar, float f10, float f11) {
        b(f10);
        this.f36114h.add(gVar);
        p(f11);
    }

    private float g() {
        return this.f36111e;
    }

    private float h() {
        return this.f36112f;
    }

    private void p(float f10) {
        this.f36111e = f10;
    }

    private void q(float f10) {
        this.f36112f = f10;
    }

    private void r(float f10) {
        this.f36109c = f10;
    }

    private void s(float f10) {
        this.f36110d = f10;
    }

    private void t(float f10) {
        this.f36107a = f10;
    }

    private void u(float f10) {
        this.f36108b = f10;
    }

    public void a(float f10, float f11, float f12, float f13, float f14, float f15) {
        d dVar = new d(f10, f11, f12, f13);
        dVar.s(f14);
        dVar.t(f15);
        this.f36113g.add(dVar);
        b bVar = new b(dVar);
        float f16 = f14 + f15;
        boolean z10 = f15 < 0.0f;
        if (z10) {
            f14 = (f14 + 180.0f) % 360.0f;
        }
        c(bVar, f14, z10 ? (180.0f + f16) % 360.0f : f16);
        double d10 = f16;
        r(((f10 + f12) * 0.5f) + (((f12 - f10) / 2.0f) * ((float) Math.cos(Math.toRadians(d10)))));
        s(((f11 + f13) * 0.5f) + (((f13 - f11) / 2.0f) * ((float) Math.sin(Math.toRadians(d10)))));
    }

    public void d(Matrix matrix, Path path) {
        int size = this.f36113g.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f36113g.get(i10).a(matrix, path);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f36115i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g f(Matrix matrix) {
        b(h());
        return new a(this, new ArrayList(this.f36114h), new Matrix(matrix));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float i() {
        return this.f36109c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        return this.f36110d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float k() {
        return this.f36107a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float l() {
        return this.f36108b;
    }

    public void m(float f10, float f11) {
        e eVar = new e();
        eVar.f36129b = f10;
        eVar.f36130c = f11;
        this.f36113g.add(eVar);
        c cVar = new c(eVar, i(), j());
        c(cVar, cVar.c() + 270.0f, cVar.c() + 270.0f);
        r(f10);
        s(f11);
    }

    public void n(float f10, float f11) {
        o(f10, f11, 270.0f, 0.0f);
    }

    public void o(float f10, float f11, float f12, float f13) {
        t(f10);
        u(f11);
        r(f10);
        s(f11);
        p(f12);
        q((f12 + f13) % 360.0f);
        this.f36113g.clear();
        this.f36114h.clear();
        this.f36115i = false;
    }
}
