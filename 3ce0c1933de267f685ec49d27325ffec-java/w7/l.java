package w7;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
/* compiled from: ShapeAppearancePathProvider.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private final m[] f36089a = new m[4];

    /* renamed from: b  reason: collision with root package name */
    private final Matrix[] f36090b = new Matrix[4];

    /* renamed from: c  reason: collision with root package name */
    private final Matrix[] f36091c = new Matrix[4];

    /* renamed from: d  reason: collision with root package name */
    private final PointF f36092d = new PointF();

    /* renamed from: e  reason: collision with root package name */
    private final Path f36093e = new Path();

    /* renamed from: f  reason: collision with root package name */
    private final Path f36094f = new Path();

    /* renamed from: g  reason: collision with root package name */
    private final m f36095g = new m();

    /* renamed from: h  reason: collision with root package name */
    private final float[] f36096h = new float[2];

    /* renamed from: i  reason: collision with root package name */
    private final float[] f36097i = new float[2];

    /* renamed from: j  reason: collision with root package name */
    private final Path f36098j = new Path();

    /* renamed from: k  reason: collision with root package name */
    private final Path f36099k = new Path();

    /* renamed from: l  reason: collision with root package name */
    private boolean f36100l = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ShapeAppearancePathProvider.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        static final l f36101a = new l();
    }

    /* compiled from: ShapeAppearancePathProvider.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(m mVar, Matrix matrix, int i10);

        void b(m mVar, Matrix matrix, int i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShapeAppearancePathProvider.java */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final k f36102a;

        /* renamed from: b  reason: collision with root package name */
        public final Path f36103b;

        /* renamed from: c  reason: collision with root package name */
        public final RectF f36104c;

        /* renamed from: d  reason: collision with root package name */
        public final b f36105d;

        /* renamed from: e  reason: collision with root package name */
        public final float f36106e;

        c(k kVar, float f10, RectF rectF, b bVar, Path path) {
            this.f36105d = bVar;
            this.f36102a = kVar;
            this.f36106e = f10;
            this.f36104c = rectF;
            this.f36103b = path;
        }
    }

    public l() {
        for (int i10 = 0; i10 < 4; i10++) {
            this.f36089a[i10] = new m();
            this.f36090b[i10] = new Matrix();
            this.f36091c[i10] = new Matrix();
        }
    }

    private float a(int i10) {
        return (i10 + 1) * 90;
    }

    private void b(c cVar, int i10) {
        this.f36096h[0] = this.f36089a[i10].k();
        this.f36096h[1] = this.f36089a[i10].l();
        this.f36090b[i10].mapPoints(this.f36096h);
        if (i10 == 0) {
            Path path = cVar.f36103b;
            float[] fArr = this.f36096h;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = cVar.f36103b;
            float[] fArr2 = this.f36096h;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.f36089a[i10].d(this.f36090b[i10], cVar.f36103b);
        b bVar = cVar.f36105d;
        if (bVar != null) {
            bVar.a(this.f36089a[i10], this.f36090b[i10], i10);
        }
    }

    private void c(c cVar, int i10) {
        int i11 = (i10 + 1) % 4;
        this.f36096h[0] = this.f36089a[i10].i();
        this.f36096h[1] = this.f36089a[i10].j();
        this.f36090b[i10].mapPoints(this.f36096h);
        this.f36097i[0] = this.f36089a[i11].k();
        this.f36097i[1] = this.f36089a[i11].l();
        this.f36090b[i11].mapPoints(this.f36097i);
        float[] fArr = this.f36096h;
        float f10 = fArr[0];
        float[] fArr2 = this.f36097i;
        float max = Math.max(((float) Math.hypot(f10 - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, 0.0f);
        float i12 = i(cVar.f36104c, i10);
        this.f36095g.n(0.0f, 0.0f);
        f j10 = j(i10, cVar.f36102a);
        j10.b(max, i12, cVar.f36106e, this.f36095g);
        this.f36098j.reset();
        this.f36095g.d(this.f36091c[i10], this.f36098j);
        if (!this.f36100l || Build.VERSION.SDK_INT < 19 || (!j10.a() && !l(this.f36098j, i10) && !l(this.f36098j, i11))) {
            this.f36095g.d(this.f36091c[i10], cVar.f36103b);
        } else {
            Path path = this.f36098j;
            path.op(path, this.f36094f, Path.Op.DIFFERENCE);
            this.f36096h[0] = this.f36095g.k();
            this.f36096h[1] = this.f36095g.l();
            this.f36091c[i10].mapPoints(this.f36096h);
            Path path2 = this.f36093e;
            float[] fArr3 = this.f36096h;
            path2.moveTo(fArr3[0], fArr3[1]);
            this.f36095g.d(this.f36091c[i10], this.f36093e);
        }
        b bVar = cVar.f36105d;
        if (bVar != null) {
            bVar.b(this.f36095g, this.f36091c[i10], i10);
        }
    }

    private void f(int i10, RectF rectF, PointF pointF) {
        if (i10 == 1) {
            pointF.set(rectF.right, rectF.bottom);
        } else if (i10 == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i10 != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }

    private w7.c g(int i10, k kVar) {
        if (i10 == 1) {
            return kVar.l();
        }
        if (i10 == 2) {
            return kVar.j();
        }
        if (i10 != 3) {
            return kVar.t();
        }
        return kVar.r();
    }

    private d h(int i10, k kVar) {
        if (i10 == 1) {
            return kVar.k();
        }
        if (i10 == 2) {
            return kVar.i();
        }
        if (i10 != 3) {
            return kVar.s();
        }
        return kVar.q();
    }

    private float i(RectF rectF, int i10) {
        float[] fArr = this.f36096h;
        m[] mVarArr = this.f36089a;
        fArr[0] = mVarArr[i10].f36109c;
        fArr[1] = mVarArr[i10].f36110d;
        this.f36090b[i10].mapPoints(fArr);
        if (i10 == 1 || i10 == 3) {
            return Math.abs(rectF.centerX() - this.f36096h[0]);
        }
        return Math.abs(rectF.centerY() - this.f36096h[1]);
    }

    private f j(int i10, k kVar) {
        if (i10 == 1) {
            return kVar.h();
        }
        if (i10 == 2) {
            return kVar.n();
        }
        if (i10 != 3) {
            return kVar.o();
        }
        return kVar.p();
    }

    public static l k() {
        return a.f36101a;
    }

    private boolean l(Path path, int i10) {
        this.f36099k.reset();
        this.f36089a[i10].d(this.f36090b[i10], this.f36099k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f36099k.computeBounds(rectF, true);
        path.op(this.f36099k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    private void m(c cVar, int i10) {
        h(i10, cVar.f36102a).b(this.f36089a[i10], 90.0f, cVar.f36106e, cVar.f36104c, g(i10, cVar.f36102a));
        float a10 = a(i10);
        this.f36090b[i10].reset();
        f(i10, cVar.f36104c, this.f36092d);
        Matrix matrix = this.f36090b[i10];
        PointF pointF = this.f36092d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f36090b[i10].preRotate(a10);
    }

    private void n(int i10) {
        this.f36096h[0] = this.f36089a[i10].i();
        this.f36096h[1] = this.f36089a[i10].j();
        this.f36090b[i10].mapPoints(this.f36096h);
        float a10 = a(i10);
        this.f36091c[i10].reset();
        Matrix matrix = this.f36091c[i10];
        float[] fArr = this.f36096h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f36091c[i10].preRotate(a10);
    }

    public void d(k kVar, float f10, RectF rectF, Path path) {
        e(kVar, f10, rectF, null, path);
    }

    public void e(k kVar, float f10, RectF rectF, b bVar, Path path) {
        path.rewind();
        this.f36093e.rewind();
        this.f36094f.rewind();
        this.f36094f.addRect(rectF, Path.Direction.CW);
        c cVar = new c(kVar, f10, rectF, bVar, path);
        for (int i10 = 0; i10 < 4; i10++) {
            m(cVar, i10);
            n(i10);
        }
        for (int i11 = 0; i11 < 4; i11++) {
            b(cVar, i11);
            c(cVar, i11);
        }
        path.close();
        this.f36093e.close();
        if (Build.VERSION.SDK_INT >= 19 && !this.f36093e.isEmpty()) {
            path.op(this.f36093e, Path.Op.UNION);
        }
    }
}
