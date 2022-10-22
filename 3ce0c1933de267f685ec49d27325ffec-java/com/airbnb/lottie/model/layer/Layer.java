package com.airbnb.lottie.model.layer;

import com.airbnb.lottie.d;
import com.airbnb.lottie.model.content.Mask;
import h3.j;
import h3.k;
import h3.l;
import i3.b;
import java.util.List;
import java.util.Locale;
import l3.a;
/* loaded from: classes.dex */
public class Layer {

    /* renamed from: a  reason: collision with root package name */
    private final List<b> f6602a;

    /* renamed from: b  reason: collision with root package name */
    private final d f6603b;

    /* renamed from: c  reason: collision with root package name */
    private final String f6604c;

    /* renamed from: d  reason: collision with root package name */
    private final long f6605d;

    /* renamed from: e  reason: collision with root package name */
    private final LayerType f6606e;

    /* renamed from: f  reason: collision with root package name */
    private final long f6607f;

    /* renamed from: g  reason: collision with root package name */
    private final String f6608g;

    /* renamed from: h  reason: collision with root package name */
    private final List<Mask> f6609h;

    /* renamed from: i  reason: collision with root package name */
    private final l f6610i;

    /* renamed from: j  reason: collision with root package name */
    private final int f6611j;

    /* renamed from: k  reason: collision with root package name */
    private final int f6612k;

    /* renamed from: l  reason: collision with root package name */
    private final int f6613l;

    /* renamed from: m  reason: collision with root package name */
    private final float f6614m;

    /* renamed from: n  reason: collision with root package name */
    private final float f6615n;

    /* renamed from: o  reason: collision with root package name */
    private final int f6616o;

    /* renamed from: p  reason: collision with root package name */
    private final int f6617p;

    /* renamed from: q  reason: collision with root package name */
    private final j f6618q;

    /* renamed from: r  reason: collision with root package name */
    private final k f6619r;

    /* renamed from: s  reason: collision with root package name */
    private final h3.b f6620s;

    /* renamed from: t  reason: collision with root package name */
    private final List<a<Float>> f6621t;

    /* renamed from: u  reason: collision with root package name */
    private final MatteType f6622u;

    /* renamed from: v  reason: collision with root package name */
    private final boolean f6623v;

    /* loaded from: classes.dex */
    public enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* loaded from: classes.dex */
    public enum MatteType {
        NONE,
        ADD,
        INVERT,
        UNKNOWN
    }

    public Layer(List<b> list, d dVar, String str, long j10, LayerType layerType, long j11, String str2, List<Mask> list2, l lVar, int i10, int i11, int i12, float f10, float f11, int i13, int i14, j jVar, k kVar, List<a<Float>> list3, MatteType matteType, h3.b bVar, boolean z10) {
        this.f6602a = list;
        this.f6603b = dVar;
        this.f6604c = str;
        this.f6605d = j10;
        this.f6606e = layerType;
        this.f6607f = j11;
        this.f6608g = str2;
        this.f6609h = list2;
        this.f6610i = lVar;
        this.f6611j = i10;
        this.f6612k = i11;
        this.f6613l = i12;
        this.f6614m = f10;
        this.f6615n = f11;
        this.f6616o = i13;
        this.f6617p = i14;
        this.f6618q = jVar;
        this.f6619r = kVar;
        this.f6621t = list3;
        this.f6622u = matteType;
        this.f6620s = bVar;
        this.f6623v = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d a() {
        return this.f6603b;
    }

    public long b() {
        return this.f6605d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<a<Float>> c() {
        return this.f6621t;
    }

    public LayerType d() {
        return this.f6606e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> e() {
        return this.f6609h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType f() {
        return this.f6622u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String g() {
        return this.f6604c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long h() {
        return this.f6607f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.f6617p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.f6616o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String k() {
        return this.f6608g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<b> l() {
        return this.f6602a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        return this.f6613l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        return this.f6612k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int o() {
        return this.f6611j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float p() {
        return this.f6615n / this.f6603b.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j q() {
        return this.f6618q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k r() {
        return this.f6619r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h3.b s() {
        return this.f6620s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float t() {
        return this.f6614m;
    }

    public String toString() {
        return w("");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l u() {
        return this.f6610i;
    }

    public boolean v() {
        return this.f6623v;
    }

    public String w(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(g());
        sb2.append("\n");
        Layer s10 = this.f6603b.s(h());
        if (s10 != null) {
            sb2.append("\t\tParents: ");
            sb2.append(s10.g());
            Layer s11 = this.f6603b.s(s10.h());
            while (s11 != null) {
                sb2.append("->");
                sb2.append(s11.g());
                s11 = this.f6603b.s(s11.h());
            }
            sb2.append(str);
            sb2.append("\n");
        }
        if (!e().isEmpty()) {
            sb2.append(str);
            sb2.append("\tMasks: ");
            sb2.append(e().size());
            sb2.append("\n");
        }
        if (!(o() == 0 || n() == 0)) {
            sb2.append(str);
            sb2.append("\tBackground: ");
            sb2.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(o()), Integer.valueOf(n()), Integer.valueOf(m())));
        }
        if (!this.f6602a.isEmpty()) {
            sb2.append(str);
            sb2.append("\tShapes:\n");
            for (b bVar : this.f6602a) {
                sb2.append(str);
                sb2.append("\t\t");
                sb2.append(bVar);
                sb2.append("\n");
            }
        }
        return sb2.toString();
    }
}
