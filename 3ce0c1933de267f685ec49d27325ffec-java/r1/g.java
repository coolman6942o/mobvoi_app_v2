package r1;

import android.text.TextUtils;
import androidx.work.ExistingWorkPolicy;
import androidx.work.k;
import androidx.work.m;
import androidx.work.q;
import androidx.work.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import z1.b;
/* compiled from: WorkContinuationImpl.java */
/* loaded from: classes.dex */
public class g extends q {

    /* renamed from: j  reason: collision with root package name */
    private static final String f33305j = k.f("WorkContinuationImpl");

    /* renamed from: a  reason: collision with root package name */
    private final i f33306a;

    /* renamed from: b  reason: collision with root package name */
    private final String f33307b;

    /* renamed from: c  reason: collision with root package name */
    private final ExistingWorkPolicy f33308c;

    /* renamed from: d  reason: collision with root package name */
    private final List<? extends s> f33309d;

    /* renamed from: e  reason: collision with root package name */
    private final List<String> f33310e;

    /* renamed from: f  reason: collision with root package name */
    private final List<String> f33311f;

    /* renamed from: g  reason: collision with root package name */
    private final List<g> f33312g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f33313h;

    /* renamed from: i  reason: collision with root package name */
    private m f33314i;

    public g(i iVar, List<? extends s> list) {
        this(iVar, null, ExistingWorkPolicy.KEEP, list, null);
    }

    private static boolean i(g gVar, Set<String> set) {
        set.addAll(gVar.c());
        Set<String> l10 = l(gVar);
        for (String str : set) {
            if (l10.contains(str)) {
                return true;
            }
        }
        List<g> e10 = gVar.e();
        if (e10 != null && !e10.isEmpty()) {
            for (g gVar2 : e10) {
                if (i(gVar2, set)) {
                    return true;
                }
            }
        }
        set.removeAll(gVar.c());
        return false;
    }

    public static Set<String> l(g gVar) {
        HashSet hashSet = new HashSet();
        List<g> e10 = gVar.e();
        if (e10 != null && !e10.isEmpty()) {
            for (g gVar2 : e10) {
                hashSet.addAll(gVar2.c());
            }
        }
        return hashSet;
    }

    public m a() {
        if (!this.f33313h) {
            b bVar = new b(this);
            this.f33306a.o().b(bVar);
            this.f33314i = bVar.d();
        } else {
            k.c().h(f33305j, String.format("Already enqueued work ids (%s)", TextUtils.join(", ", this.f33310e)), new Throwable[0]);
        }
        return this.f33314i;
    }

    public ExistingWorkPolicy b() {
        return this.f33308c;
    }

    public List<String> c() {
        return this.f33310e;
    }

    public String d() {
        return this.f33307b;
    }

    public List<g> e() {
        return this.f33312g;
    }

    public List<? extends s> f() {
        return this.f33309d;
    }

    public i g() {
        return this.f33306a;
    }

    public boolean h() {
        return i(this, new HashSet());
    }

    public boolean j() {
        return this.f33313h;
    }

    public void k() {
        this.f33313h = true;
    }

    public g(i iVar, String str, ExistingWorkPolicy existingWorkPolicy, List<? extends s> list, List<g> list2) {
        this.f33306a = iVar;
        this.f33307b = str;
        this.f33308c = existingWorkPolicy;
        this.f33309d = list;
        this.f33312g = list2;
        this.f33310e = new ArrayList(list.size());
        this.f33311f = new ArrayList();
        if (list2 != null) {
            for (g gVar : list2) {
                this.f33311f.addAll(gVar.f33311f);
            }
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            String a10 = list.get(i10).a();
            this.f33310e.add(a10);
            this.f33311f.add(a10);
        }
    }
}
