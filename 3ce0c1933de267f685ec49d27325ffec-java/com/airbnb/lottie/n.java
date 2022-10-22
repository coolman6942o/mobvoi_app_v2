package com.airbnb.lottie;

import j0.d;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import k3.f;
/* compiled from: PerformanceTracker.java */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private boolean f6665a = false;

    /* renamed from: b  reason: collision with root package name */
    private final Set<b> f6666b = new androidx.collection.b();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, f> f6667c = new HashMap();

    /* compiled from: PerformanceTracker.java */
    /* loaded from: classes.dex */
    class a implements Comparator<d<String, Float>> {
        a(n nVar) {
        }

        /* renamed from: a */
        public int compare(d<String, Float> dVar, d<String, Float> dVar2) {
            float floatValue = dVar.f29365b.floatValue();
            float floatValue2 = dVar2.f29365b.floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            return floatValue > floatValue2 ? -1 : 0;
        }
    }

    /* compiled from: PerformanceTracker.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(float f10);
    }

    public n() {
        new a(this);
    }

    public void a(String str, float f10) {
        if (this.f6665a) {
            f fVar = this.f6667c.get(str);
            if (fVar == null) {
                fVar = new f();
                this.f6667c.put(str, fVar);
            }
            fVar.a(f10);
            if (str.equals("__container")) {
                for (b bVar : this.f6666b) {
                    bVar.a(f10);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z10) {
        this.f6665a = z10;
    }
}
