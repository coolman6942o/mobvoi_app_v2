package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import com.airbnb.lottie.f;
import d3.c;
import d3.r;
import h3.d;
import i3.b;
import java.util.List;
/* loaded from: classes.dex */
public class ShapeStroke implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f6571a;

    /* renamed from: b  reason: collision with root package name */
    private final h3.b f6572b;

    /* renamed from: c  reason: collision with root package name */
    private final List<h3.b> f6573c;

    /* renamed from: d  reason: collision with root package name */
    private final h3.a f6574d;

    /* renamed from: e  reason: collision with root package name */
    private final d f6575e;

    /* renamed from: f  reason: collision with root package name */
    private final h3.b f6576f;

    /* renamed from: g  reason: collision with root package name */
    private final LineCapType f6577g;

    /* renamed from: h  reason: collision with root package name */
    private final LineJoinType f6578h;

    /* renamed from: i  reason: collision with root package name */
    private final float f6579i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f6580j;

    /* loaded from: classes.dex */
    public enum LineCapType {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap toPaintCap() {
            int i10 = a.f6581a[ordinal()];
            if (i10 == 1) {
                return Paint.Cap.BUTT;
            }
            if (i10 != 2) {
                return Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }
    }

    /* loaded from: classes.dex */
    public enum LineJoinType {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join toPaintJoin() {
            int i10 = a.f6582b[ordinal()];
            if (i10 == 1) {
                return Paint.Join.BEVEL;
            }
            if (i10 == 2) {
                return Paint.Join.MITER;
            }
            if (i10 != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f6581a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f6582b;

        static {
            int[] iArr = new int[LineJoinType.values().length];
            f6582b = iArr;
            try {
                iArr[LineJoinType.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6582b[LineJoinType.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6582b[LineJoinType.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[LineCapType.values().length];
            f6581a = iArr2;
            try {
                iArr2[LineCapType.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6581a[LineCapType.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6581a[LineCapType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ShapeStroke(String str, h3.b bVar, List<h3.b> list, h3.a aVar, d dVar, h3.b bVar2, LineCapType lineCapType, LineJoinType lineJoinType, float f10, boolean z10) {
        this.f6571a = str;
        this.f6572b = bVar;
        this.f6573c = list;
        this.f6574d = aVar;
        this.f6575e = dVar;
        this.f6576f = bVar2;
        this.f6577g = lineCapType;
        this.f6578h = lineJoinType;
        this.f6579i = f10;
        this.f6580j = z10;
    }

    @Override // i3.b
    public c a(f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new r(fVar, aVar, this);
    }

    public LineCapType b() {
        return this.f6577g;
    }

    public h3.a c() {
        return this.f6574d;
    }

    public h3.b d() {
        return this.f6572b;
    }

    public LineJoinType e() {
        return this.f6578h;
    }

    public List<h3.b> f() {
        return this.f6573c;
    }

    public float g() {
        return this.f6579i;
    }

    public String h() {
        return this.f6571a;
    }

    public d i() {
        return this.f6575e;
    }

    public h3.b j() {
        return this.f6576f;
    }

    public boolean k() {
        return this.f6580j;
    }
}
