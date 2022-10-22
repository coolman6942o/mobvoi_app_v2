package com.airbnb.lottie;

import android.graphics.Rect;
import com.airbnb.lottie.model.layer.Layer;
import g3.b;
import g3.c;
import g3.g;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
/* compiled from: LottieComposition.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    private Map<String, List<Layer>> f6425c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, g> f6426d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, b> f6427e;

    /* renamed from: f  reason: collision with root package name */
    private List<g> f6428f;

    /* renamed from: g  reason: collision with root package name */
    private androidx.collection.g<c> f6429g;

    /* renamed from: h  reason: collision with root package name */
    private androidx.collection.d<Layer> f6430h;

    /* renamed from: i  reason: collision with root package name */
    private List<Layer> f6431i;

    /* renamed from: j  reason: collision with root package name */
    private Rect f6432j;

    /* renamed from: k  reason: collision with root package name */
    private float f6433k;

    /* renamed from: l  reason: collision with root package name */
    private float f6434l;

    /* renamed from: m  reason: collision with root package name */
    private float f6435m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f6436n;

    /* renamed from: a  reason: collision with root package name */
    private final n f6423a = new n();

    /* renamed from: b  reason: collision with root package name */
    private final HashSet<String> f6424b = new HashSet<>();

    /* renamed from: o  reason: collision with root package name */
    private int f6437o = 0;

    public void a(String str) {
        k3.d.c(str);
        this.f6424b.add(str);
    }

    public Rect b() {
        return this.f6432j;
    }

    public androidx.collection.g<c> c() {
        return this.f6429g;
    }

    public float d() {
        return (e() / this.f6435m) * 1000.0f;
    }

    public float e() {
        return this.f6434l - this.f6433k;
    }

    public float f() {
        return this.f6434l;
    }

    public Map<String, b> g() {
        return this.f6427e;
    }

    public float h() {
        return this.f6435m;
    }

    public Map<String, g> i() {
        return this.f6426d;
    }

    public List<Layer> j() {
        return this.f6431i;
    }

    public g k(String str) {
        this.f6428f.size();
        for (int i10 = 0; i10 < this.f6428f.size(); i10++) {
            g gVar = this.f6428f.get(i10);
            if (gVar.a(str)) {
                return gVar;
            }
        }
        return null;
    }

    public int l() {
        return this.f6437o;
    }

    public n m() {
        return this.f6423a;
    }

    public List<Layer> n(String str) {
        return this.f6425c.get(str);
    }

    public float o() {
        return this.f6433k;
    }

    public boolean p() {
        return this.f6436n;
    }

    public void q(int i10) {
        this.f6437o += i10;
    }

    public void r(Rect rect, float f10, float f11, float f12, List<Layer> list, androidx.collection.d<Layer> dVar, Map<String, List<Layer>> map, Map<String, g> map2, androidx.collection.g<c> gVar, Map<String, b> map3, List<g> list2) {
        this.f6432j = rect;
        this.f6433k = f10;
        this.f6434l = f11;
        this.f6435m = f12;
        this.f6431i = list;
        this.f6430h = dVar;
        this.f6425c = map;
        this.f6426d = map2;
        this.f6429g = gVar;
        this.f6427e = map3;
        this.f6428f = list2;
    }

    public Layer s(long j10) {
        return this.f6430h.f(j10);
    }

    public void t(boolean z10) {
        this.f6436n = z10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.f6431i) {
            sb2.append(layer.w("\t"));
        }
        return sb2.toString();
    }

    public void u(boolean z10) {
        this.f6423a.b(z10);
    }
}
