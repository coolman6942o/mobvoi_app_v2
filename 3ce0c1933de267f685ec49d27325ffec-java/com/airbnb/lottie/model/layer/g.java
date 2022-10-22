package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import com.airbnb.lottie.d;
import com.airbnb.lottie.f;
import com.airbnb.lottie.model.DocumentData;
import e3.n;
import e3.p;
import h3.k;
import i3.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import k3.h;
/* compiled from: TextLayer.java */
/* loaded from: classes.dex */
public class g extends com.airbnb.lottie.model.layer.a {
    private final n E;
    private final f F;
    private final d G;
    private e3.a<Integer, Integer> H;
    private e3.a<Integer, Integer> I;
    private e3.a<Integer, Integer> J;
    private e3.a<Integer, Integer> K;
    private e3.a<Float, Float> L;
    private e3.a<Float, Float> M;
    private e3.a<Float, Float> N;
    private e3.a<Float, Float> O;
    private e3.a<Float, Float> P;
    private e3.a<Float, Float> Q;

    /* renamed from: x  reason: collision with root package name */
    private final StringBuilder f6661x = new StringBuilder(2);

    /* renamed from: y  reason: collision with root package name */
    private final RectF f6662y = new RectF();

    /* renamed from: z  reason: collision with root package name */
    private final Matrix f6663z = new Matrix();
    private final Paint A = new a(this, 1);
    private final Paint B = new b(this, 1);
    private final Map<g3.c, List<d3.d>> C = new HashMap();
    private final androidx.collection.d<String> D = new androidx.collection.d<>();

    /* compiled from: TextLayer.java */
    /* loaded from: classes.dex */
    class a extends Paint {
        a(g gVar, int i10) {
            super(i10);
            setStyle(Paint.Style.FILL);
        }
    }

    /* compiled from: TextLayer.java */
    /* loaded from: classes.dex */
    class b extends Paint {
        b(g gVar, int i10) {
            super(i10);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TextLayer.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f6664a;

        static {
            int[] iArr = new int[DocumentData.Justification.values().length];
            f6664a = iArr;
            try {
                iArr[DocumentData.Justification.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6664a[DocumentData.Justification.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6664a[DocumentData.Justification.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, Layer layer) {
        super(fVar, layer);
        h3.b bVar;
        h3.b bVar2;
        h3.a aVar;
        h3.a aVar2;
        this.F = fVar;
        this.G = layer.a();
        n d10 = layer.q().a();
        this.E = d10;
        d10.a(this);
        j(d10);
        k r10 = layer.r();
        if (!(r10 == null || (aVar2 = r10.f27715a) == null)) {
            e3.a<Integer, Integer> a10 = aVar2.a();
            this.H = a10;
            a10.a(this);
            j(this.H);
        }
        if (!(r10 == null || (aVar = r10.f27716b) == null)) {
            e3.a<Integer, Integer> a11 = aVar.a();
            this.J = a11;
            a11.a(this);
            j(this.J);
        }
        if (!(r10 == null || (bVar2 = r10.f27717c) == null)) {
            e3.a<Float, Float> a12 = bVar2.a();
            this.L = a12;
            a12.a(this);
            j(this.L);
        }
        if (r10 != null && (bVar = r10.f27718d) != null) {
            e3.a<Float, Float> a13 = bVar.a();
            this.N = a13;
            a13.a(this);
            j(this.N);
        }
    }

    private void K(DocumentData.Justification justification, Canvas canvas, float f10) {
        int i10 = c.f6664a[justification.ordinal()];
        if (i10 == 2) {
            canvas.translate(-f10, 0.0f);
        } else if (i10 == 3) {
            canvas.translate((-f10) / 2.0f, 0.0f);
        }
    }

    private String L(String str, int i10) {
        int codePointAt = str.codePointAt(i10);
        int charCount = Character.charCount(codePointAt) + i10;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!X(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j10 = codePointAt;
        if (this.D.d(j10)) {
            return this.D.f(j10);
        }
        this.f6661x.setLength(0);
        while (i10 < charCount) {
            int codePointAt3 = str.codePointAt(i10);
            this.f6661x.appendCodePoint(codePointAt3);
            i10 += Character.charCount(codePointAt3);
        }
        String sb2 = this.f6661x.toString();
        this.D.k(j10, sb2);
        return sb2;
    }

    private void M(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
            }
        }
    }

    private void N(g3.c cVar, Matrix matrix, float f10, DocumentData documentData, Canvas canvas) {
        List<d3.d> U = U(cVar);
        for (int i10 = 0; i10 < U.size(); i10++) {
            Path a10 = U.get(i10).a();
            a10.computeBounds(this.f6662y, false);
            this.f6663z.set(matrix);
            this.f6663z.preTranslate(0.0f, (-documentData.f6549g) * h.e());
            this.f6663z.preScale(f10, f10);
            a10.transform(this.f6663z);
            if (documentData.f6553k) {
                Q(a10, this.A, canvas);
                Q(a10, this.B, canvas);
            } else {
                Q(a10, this.B, canvas);
                Q(a10, this.A, canvas);
            }
        }
    }

    private void O(String str, DocumentData documentData, Canvas canvas) {
        if (documentData.f6553k) {
            M(str, this.A, canvas);
            M(str, this.B, canvas);
            return;
        }
        M(str, this.B, canvas);
        M(str, this.A, canvas);
    }

    private void P(String str, DocumentData documentData, Canvas canvas, float f10) {
        float floatValue;
        int i10 = 0;
        while (i10 < str.length()) {
            String L = L(str, i10);
            i10 += L.length();
            O(L, documentData, canvas);
            float measureText = this.A.measureText(L, 0, 1);
            float f11 = documentData.f6547e / 10.0f;
            e3.a<Float, Float> aVar = this.O;
            if (aVar != null) {
                floatValue = aVar.h().floatValue();
            } else {
                e3.a<Float, Float> aVar2 = this.N;
                if (aVar2 != null) {
                    floatValue = aVar2.h().floatValue();
                } else {
                    canvas.translate(measureText + (f11 * f10), 0.0f);
                }
            }
            f11 += floatValue;
            canvas.translate(measureText + (f11 * f10), 0.0f);
        }
    }

    private void Q(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawPath(path, paint);
            }
        }
    }

    private void R(String str, DocumentData documentData, Matrix matrix, g3.b bVar, Canvas canvas, float f10, float f11) {
        float floatValue;
        for (int i10 = 0; i10 < str.length(); i10++) {
            g3.c e10 = this.G.c().e(g3.c.c(str.charAt(i10), bVar.a(), bVar.c()));
            if (e10 != null) {
                N(e10, matrix, f11, documentData, canvas);
                float b10 = ((float) e10.b()) * f11 * h.e() * f10;
                float f12 = documentData.f6547e / 10.0f;
                e3.a<Float, Float> aVar = this.O;
                if (aVar != null) {
                    floatValue = aVar.h().floatValue();
                } else {
                    e3.a<Float, Float> aVar2 = this.N;
                    if (aVar2 != null) {
                        floatValue = aVar2.h().floatValue();
                    }
                    canvas.translate(b10 + (f12 * f10), 0.0f);
                }
                f12 += floatValue;
                canvas.translate(b10 + (f12 * f10), 0.0f);
            }
        }
    }

    private void S(DocumentData documentData, Matrix matrix, g3.b bVar, Canvas canvas) {
        float f10;
        e3.a<Float, Float> aVar = this.Q;
        if (aVar != null) {
            f10 = aVar.h().floatValue();
        } else {
            e3.a<Float, Float> aVar2 = this.P;
            if (aVar2 != null) {
                f10 = aVar2.h().floatValue();
            } else {
                f10 = documentData.f6545c;
            }
        }
        float f11 = f10 / 100.0f;
        float g10 = h.g(matrix);
        String str = documentData.f6543a;
        float e10 = documentData.f6548f * h.e();
        List<String> W = W(str);
        int size = W.size();
        for (int i10 = 0; i10 < size; i10++) {
            String str2 = W.get(i10);
            float V = V(str2, bVar, f11, g10);
            canvas.save();
            K(documentData.f6546d, canvas, V);
            canvas.translate(0.0f, (i10 * e10) - (((size - 1) * e10) / 2.0f));
            R(str2, documentData, matrix, bVar, canvas, g10, f11);
            canvas.restore();
        }
    }

    private void T(DocumentData documentData, g3.b bVar, Matrix matrix, Canvas canvas) {
        float f10;
        float g10 = h.g(matrix);
        Typeface D = this.F.D(bVar.a(), bVar.c());
        if (D != null) {
            String str = documentData.f6543a;
            this.F.C();
            this.A.setTypeface(D);
            e3.a<Float, Float> aVar = this.Q;
            if (aVar != null) {
                f10 = aVar.h().floatValue();
            } else {
                e3.a<Float, Float> aVar2 = this.P;
                if (aVar2 != null) {
                    f10 = aVar2.h().floatValue();
                } else {
                    f10 = documentData.f6545c;
                }
            }
            this.A.setTextSize(f10 * h.e());
            this.B.setTypeface(this.A.getTypeface());
            this.B.setTextSize(this.A.getTextSize());
            float e10 = documentData.f6548f * h.e();
            List<String> W = W(str);
            int size = W.size();
            for (int i10 = 0; i10 < size; i10++) {
                String str2 = W.get(i10);
                K(documentData.f6546d, canvas, this.B.measureText(str2));
                canvas.translate(0.0f, (i10 * e10) - (((size - 1) * e10) / 2.0f));
                P(str2, documentData, canvas, g10);
                canvas.setMatrix(matrix);
            }
        }
    }

    private List<d3.d> U(g3.c cVar) {
        if (this.C.containsKey(cVar)) {
            return this.C.get(cVar);
        }
        List<i> a10 = cVar.a();
        int size = a10.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(new d3.d(this.F, this, a10.get(i10)));
        }
        this.C.put(cVar, arrayList);
        return arrayList;
    }

    private float V(String str, g3.b bVar, float f10, float f11) {
        float f12 = 0.0f;
        for (int i10 = 0; i10 < str.length(); i10++) {
            g3.c e10 = this.G.c().e(g3.c.c(str.charAt(i10), bVar.a(), bVar.c()));
            if (e10 != null) {
                f12 = (float) (f12 + (e10.b() * f10 * h.e() * f11));
            }
        }
        return f12;
    }

    private List<String> W(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private boolean X(int i10) {
        return Character.getType(i10) == 16 || Character.getType(i10) == 27 || Character.getType(i10) == 6 || Character.getType(i10) == 28 || Character.getType(i10) == 19;
    }

    @Override // com.airbnb.lottie.model.layer.a, g3.e
    public <T> void d(T t10, l3.c<T> cVar) {
        super.d(t10, cVar);
        if (t10 == com.airbnb.lottie.k.f6508a) {
            e3.a<Integer, Integer> aVar = this.I;
            if (aVar != null) {
                D(aVar);
            }
            if (cVar == null) {
                this.I = null;
                return;
            }
            p pVar = new p(cVar);
            this.I = pVar;
            pVar.a(this);
            j(this.I);
        } else if (t10 == com.airbnb.lottie.k.f6509b) {
            e3.a<Integer, Integer> aVar2 = this.K;
            if (aVar2 != null) {
                D(aVar2);
            }
            if (cVar == null) {
                this.K = null;
                return;
            }
            p pVar2 = new p(cVar);
            this.K = pVar2;
            pVar2.a(this);
            j(this.K);
        } else if (t10 == com.airbnb.lottie.k.f6522o) {
            e3.a<Float, Float> aVar3 = this.M;
            if (aVar3 != null) {
                D(aVar3);
            }
            if (cVar == null) {
                this.M = null;
                return;
            }
            p pVar3 = new p(cVar);
            this.M = pVar3;
            pVar3.a(this);
            j(this.M);
        } else if (t10 == com.airbnb.lottie.k.f6523p) {
            e3.a<Float, Float> aVar4 = this.O;
            if (aVar4 != null) {
                D(aVar4);
            }
            if (cVar == null) {
                this.O = null;
                return;
            }
            p pVar4 = new p(cVar);
            this.O = pVar4;
            pVar4.a(this);
            j(this.O);
        } else if (t10 == com.airbnb.lottie.k.B) {
            e3.a<Float, Float> aVar5 = this.Q;
            if (aVar5 != null) {
                D(aVar5);
            }
            if (cVar == null) {
                this.Q = null;
                return;
            }
            p pVar5 = new p(cVar);
            this.Q = pVar5;
            pVar5.a(this);
            j(this.Q);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, d3.e
    public void e(RectF rectF, Matrix matrix, boolean z10) {
        super.e(rectF, matrix, z10);
        rectF.set(0.0f, 0.0f, this.G.b().width(), this.G.b().height());
    }

    @Override // com.airbnb.lottie.model.layer.a
    void u(Canvas canvas, Matrix matrix, int i10) {
        canvas.save();
        if (!this.F.j0()) {
            canvas.setMatrix(matrix);
        }
        DocumentData h10 = this.E.h();
        g3.b bVar = this.G.g().get(h10.f6544b);
        if (bVar == null) {
            canvas.restore();
            return;
        }
        e3.a<Integer, Integer> aVar = this.I;
        if (aVar != null) {
            this.A.setColor(aVar.h().intValue());
        } else {
            e3.a<Integer, Integer> aVar2 = this.H;
            if (aVar2 != null) {
                this.A.setColor(aVar2.h().intValue());
            } else {
                this.A.setColor(h10.f6550h);
            }
        }
        e3.a<Integer, Integer> aVar3 = this.K;
        if (aVar3 != null) {
            this.B.setColor(aVar3.h().intValue());
        } else {
            e3.a<Integer, Integer> aVar4 = this.J;
            if (aVar4 != null) {
                this.B.setColor(aVar4.h().intValue());
            } else {
                this.B.setColor(h10.f6551i);
            }
        }
        int intValue = ((this.f6645v.h() == null ? 100 : this.f6645v.h().h().intValue()) * 255) / 100;
        this.A.setAlpha(intValue);
        this.B.setAlpha(intValue);
        e3.a<Float, Float> aVar5 = this.M;
        if (aVar5 != null) {
            this.B.setStrokeWidth(aVar5.h().floatValue());
        } else {
            e3.a<Float, Float> aVar6 = this.L;
            if (aVar6 != null) {
                this.B.setStrokeWidth(aVar6.h().floatValue());
            } else {
                this.B.setStrokeWidth(h10.f6552j * h.e() * h.g(matrix));
            }
        }
        if (this.F.j0()) {
            S(h10, matrix, bVar, canvas);
        } else {
            T(h10, bVar, matrix, canvas);
        }
        canvas.restore();
    }
}
