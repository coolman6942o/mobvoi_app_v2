package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.d;
import j5.b;
import j5.c;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import k5.i;
import n5.e;
import n5.j;
import n5.k;
/* compiled from: RequestBuilder.java */
/* loaded from: classes.dex */
public class g<TranscodeType> extends com.bumptech.glide.request.a<g<TranscodeType>> {
    private final Context A;
    private final h B;
    private final Class<TranscodeType> C;
    private final e D;
    private i<?, ? super TranscodeType> E;
    private Object F;
    private List<b<TranscodeType>> G;
    private g<TranscodeType> H;
    private g<TranscodeType> I;
    private Float J;
    private boolean K = true;
    private boolean L;
    private boolean M;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestBuilder.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7844a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f7845b;

        static {
            int[] iArr = new int[Priority.values().length];
            f7845b = iArr;
            try {
                iArr[Priority.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7845b[Priority.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7845b[Priority.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7845b[Priority.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            f7844a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7844a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7844a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f7844a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f7844a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f7844a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f7844a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f7844a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    static {
        new c().f(t4.a.f35050b).V(Priority.LOW).c0(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"CheckResult"})
    public g(c cVar, h hVar, Class<TranscodeType> cls, Context context) {
        this.B = hVar;
        this.C = cls;
        this.A = context;
        this.E = hVar.p(cls);
        this.D = cVar.i();
        q0(hVar.n());
        a(hVar.o());
    }

    private g<TranscodeType> A0(Object obj) {
        this.F = obj;
        this.L = true;
        return this;
    }

    private j5.a B0(Object obj, i<TranscodeType> iVar, b<TranscodeType> bVar, com.bumptech.glide.request.a<?> aVar, RequestCoordinator requestCoordinator, i<?, ? super TranscodeType> iVar2, Priority priority, int i10, int i11, Executor executor) {
        Context context = this.A;
        e eVar = this.D;
        return com.bumptech.glide.request.c.x(context, eVar, obj, this.F, this.C, aVar, i10, i11, priority, iVar, bVar, this.G, requestCoordinator, eVar.f(), iVar2.b(), executor);
    }

    private j5.a l0(i<TranscodeType> iVar, b<TranscodeType> bVar, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        return m0(new Object(), iVar, bVar, null, this.E, aVar.w(), aVar.t(), aVar.s(), aVar, executor);
    }

    private j5.a m0(Object obj, i<TranscodeType> iVar, b<TranscodeType> bVar, RequestCoordinator requestCoordinator, i<?, ? super TranscodeType> iVar2, Priority priority, int i10, int i11, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        com.bumptech.glide.request.b bVar2;
        com.bumptech.glide.request.b bVar3;
        if (this.I != null) {
            bVar3 = new com.bumptech.glide.request.b(obj, requestCoordinator);
            bVar2 = bVar3;
        } else {
            bVar2 = null;
            bVar3 = requestCoordinator;
        }
        j5.a n02 = n0(obj, iVar, bVar, bVar3, iVar2, priority, i10, i11, aVar, executor);
        if (bVar2 == null) {
            return n02;
        }
        int t10 = this.I.t();
        int s10 = this.I.s();
        if (k.s(i10, i11) && !this.I.M()) {
            t10 = aVar.t();
            s10 = aVar.s();
        }
        g<TranscodeType> gVar = this.I;
        com.bumptech.glide.request.b bVar4 = bVar2;
        bVar4.q(n02, gVar.m0(obj, iVar, bVar, bVar4, gVar.E, gVar.w(), t10, s10, this.I, executor));
        return bVar4;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.bumptech.glide.request.a] */
    private j5.a n0(Object obj, i<TranscodeType> iVar, b<TranscodeType> bVar, RequestCoordinator requestCoordinator, i<?, ? super TranscodeType> iVar2, Priority priority, int i10, int i11, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        Priority priority2;
        g<TranscodeType> gVar = this.H;
        if (gVar != null) {
            if (!this.M) {
                i<?, ? super TranscodeType> iVar3 = gVar.K ? iVar2 : gVar.E;
                if (gVar.F()) {
                    priority2 = this.H.w();
                } else {
                    priority2 = p0(priority);
                }
                Priority priority3 = priority2;
                int t10 = this.H.t();
                int s10 = this.H.s();
                if (k.s(i10, i11) && !this.H.M()) {
                    t10 = aVar.t();
                    s10 = aVar.s();
                }
                d dVar = new d(obj, requestCoordinator);
                j5.a B0 = B0(obj, iVar, bVar, aVar, dVar, iVar2, priority, i10, i11, executor);
                this.M = true;
                g<TranscodeType> gVar2 = this.H;
                j5.a m02 = gVar2.m0(obj, iVar, bVar, dVar, iVar3, priority3, t10, s10, gVar2, executor);
                this.M = false;
                dVar.q(B0, m02);
                return dVar;
            }
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        } else if (this.J == null) {
            return B0(obj, iVar, bVar, aVar, requestCoordinator, iVar2, priority, i10, i11, executor);
        } else {
            d dVar2 = new d(obj, requestCoordinator);
            dVar2.q(B0(obj, iVar, bVar, aVar, dVar2, iVar2, priority, i10, i11, executor), B0(obj, iVar, bVar, aVar.clone().b0(this.J.floatValue()), dVar2, iVar2, p0(priority), i10, i11, executor));
            return dVar2;
        }
    }

    private Priority p0(Priority priority) {
        int i10 = a.f7845b[priority.ordinal()];
        if (i10 == 1) {
            return Priority.NORMAL;
        }
        if (i10 == 2) {
            return Priority.HIGH;
        }
        if (i10 == 3 || i10 == 4) {
            return Priority.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + w());
    }

    @SuppressLint({"CheckResult"})
    private void q0(List<b<Object>> list) {
        for (b<Object> bVar : list) {
            j0(bVar);
        }
    }

    private <Y extends i<TranscodeType>> Y s0(Y y10, b<TranscodeType> bVar, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        j.d(y10);
        if (this.L) {
            j5.a l02 = l0(y10, bVar, aVar, executor);
            j5.a f10 = y10.f();
            if (!l02.f(f10) || v0(aVar, f10)) {
                this.B.m(y10);
                y10.d(l02);
                this.B.y(y10, l02);
                return y10;
            }
            if (!((j5.a) j.d(f10)).isRunning()) {
                f10.e();
            }
            return y10;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    private boolean v0(com.bumptech.glide.request.a<?> aVar, j5.a aVar2) {
        return !aVar.E() && aVar2.k();
    }

    public g<TranscodeType> j0(b<TranscodeType> bVar) {
        if (bVar != null) {
            if (this.G == null) {
                this.G = new ArrayList();
            }
            this.G.add(bVar);
        }
        return this;
    }

    /* renamed from: k0 */
    public g<TranscodeType> a(com.bumptech.glide.request.a<?> aVar) {
        j.d(aVar);
        return (g) super.a(aVar);
    }

    /* renamed from: o0 */
    public g<TranscodeType> d() {
        g<TranscodeType> gVar = (g) super.clone();
        gVar.E = (i<?, ? super TranscodeType>) gVar.E.clone();
        return gVar;
    }

    public <Y extends i<TranscodeType>> Y r0(Y y10) {
        return (Y) t0(y10, null, e.b());
    }

    <Y extends i<TranscodeType>> Y t0(Y y10, b<TranscodeType> bVar, Executor executor) {
        return (Y) s0(y10, bVar, this, executor);
    }

    public k5.j<ImageView, TranscodeType> u0(ImageView imageView) {
        g<TranscodeType> gVar;
        k.a();
        j.d(imageView);
        if (!L() && J() && imageView.getScaleType() != null) {
            switch (a.f7844a[imageView.getScaleType().ordinal()]) {
                case 1:
                    gVar = clone().O();
                    break;
                case 2:
                    gVar = clone().P();
                    break;
                case 3:
                case 4:
                case 5:
                    gVar = clone().Q();
                    break;
                case 6:
                    gVar = clone().P();
                    break;
            }
            return (k5.j) s0(this.D.a(imageView, this.C), null, gVar, e.b());
        }
        gVar = this;
        return (k5.j) s0(this.D.a(imageView, this.C), null, gVar, e.b());
    }

    public g<TranscodeType> w0(Bitmap bitmap) {
        return A0(bitmap).a(c.l0(t4.a.f35049a));
    }

    public g<TranscodeType> x0(Uri uri) {
        return A0(uri);
    }

    public g<TranscodeType> y0(Object obj) {
        return A0(obj);
    }

    public g<TranscodeType> z0(String str) {
        return A0(str);
    }
}
