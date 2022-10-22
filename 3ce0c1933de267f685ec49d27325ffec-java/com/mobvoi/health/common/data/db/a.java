package com.mobvoi.health.common.data.db;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.d;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.health.common.data.db.DbSyncAccessor;
import com.mobvoi.health.common.data.db.a;
import com.mobvoi.health.common.data.db.c;
import com.mobvoi.health.common.data.pojo.DataType;
import eg.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.SortedSet;
import java.util.TreeSet;
import nf.h;
import qf.i;
import qf.j;
import rf.b;
/* compiled from: DbPointAccessor.java */
/* loaded from: classes2.dex */
public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private HealthDatabase f17954a;

    /* renamed from: b  reason: collision with root package name */
    private b f17955b;

    /* renamed from: c  reason: collision with root package name */
    private String f17956c = "";

    /* renamed from: e  reason: collision with root package name */
    private final h<c.a> f17958e = new nf.a();

    /* renamed from: f  reason: collision with root package name */
    private boolean f17959f = false;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f17957d = new Handler(Looper.getMainLooper());

    public a(HealthDatabase healthDatabase) {
        this.f17954a = healthDatabase;
        this.f17955b = healthDatabase.D();
    }

    private void B(final DataType dataType, final long j10, final long j11) {
        if (!this.f17959f) {
            this.f17957d.post(new Runnable() { // from class: qf.g
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.z(dataType, j10, j11);
                }
            });
        }
    }

    private void p(Collection<qf.a> collection) {
        TreeSet treeSet = new TreeSet(i.f33151a);
        treeSet.addAll(collection);
        String str = ((qf.a) treeSet.first()).f33126b;
        String str2 = ((qf.a) treeSet.first()).f33125a;
        int i10 = ((qf.a) treeSet.first()).f33127c;
        qf.a l10 = this.f17955b.l(str, str2, i10);
        if (l10 != null) {
            l10.f33128d++;
        }
        final SortedSet headSet = l10 == null ? null : treeSet.headSet(l10);
        final SortedSet tailSet = l10 == null ? treeSet : treeSet.tailSet(l10);
        if (headSet != null && !headSet.isEmpty()) {
            headSet.removeAll(i(str2, DataType.from(i10), ((qf.a) headSet.first()).f33128d, ((qf.a) headSet.last()).f33128d + 1));
        }
        this.f17954a.A(new Runnable() { // from class: qf.h
            @Override // java.lang.Runnable
            public final void run() {
                a.this.y(headSet, tailSet);
            }
        });
        if (f.a.b()) {
            Iterator it = tailSet.iterator();
            while (it.hasNext()) {
                k.p("health.db.dataPoint", "bulkInsert: %s", (qf.a) it.next());
            }
        }
        if (!treeSet.isEmpty()) {
            B(DataType.from(i10), ((qf.a) treeSet.first()).f33128d, ((qf.a) treeSet.last()).f33128d);
        }
    }

    public static a q(Context context) {
        return new a(HealthDatabase.G(context));
    }

    private long s() {
        return System.currentTimeMillis();
    }

    static Collection<List<qf.a>> u(List<qf.a> list) {
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        boolean z10 = false;
        qf.a aVar = list.get(0);
        for (qf.a aVar2 : list) {
            aVar2.b();
            if (z10 || aVar.f33127c != aVar2.f33127c || !TextUtils.equals(aVar.f33126b, aVar2.f33126b) || !TextUtils.equals(aVar.f33125a, aVar2.f33125a)) {
                z10 = true;
            }
        }
        if (!z10) {
            return Collections.singletonList(list);
        }
        HashMap hashMap = new HashMap();
        for (qf.a aVar3 : list) {
            String str = aVar3.f33127c + "#" + aVar3.f33126b + "#" + aVar3.f33125a;
            List list2 = (List) hashMap.get(str);
            if (list2 == null) {
                list2 = new ArrayList(list.size());
                hashMap.put(str, list2);
            }
            list2.add(aVar3);
        }
        return hashMap.values();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004c, code lost:
        if (r10.f17955b.m(r11) > 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004e, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0050, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005b, code lost:
        if (r10.f17955b.j(r11) > 0) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private qf.a w(qf.a aVar, boolean z10) {
        boolean z11;
        if (aVar.g()) {
            long j10 = aVar.f33129e;
            if (j10 > 0 && j10 < aVar.f33128d) {
                z11 = ((long) this.f17955b.d(aVar)) > 0;
                if (!z11) {
                }
            }
            if (!z11) {
                if (f.a.b()) {
                    k.p("health.db.dataPoint", "insert: %s", aVar);
                }
                this.f17955b.b(aVar);
                B(DataType.from(aVar.f33127c), aVar.f33129e, aVar.f33128d);
                return aVar;
            } else if (z10) {
                return null;
            } else {
                throw new DbSyncAccessor.TimeOverlapException(String.format(Locale.getDefault(), "%s overlaps exist points.", aVar));
            }
        } else if (z10) {
            return null;
        } else {
            throw new DbSyncAccessor.InvalidParamsException(String.format(Locale.getDefault(), "%s is invalid.", aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int x(qf.a aVar, qf.a aVar2) {
        return Long.compare(aVar.f33128d, aVar2.f33128d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(SortedSet sortedSet, SortedSet sortedSet2) {
        this.f17959f = true;
        if (sortedSet != null && !sortedSet.isEmpty()) {
            Iterator it = sortedSet.iterator();
            while (it.hasNext()) {
                w((qf.a) it.next(), true);
            }
        }
        if (!sortedSet2.isEmpty()) {
            try {
                this.f17955b.o((qf.a[]) sortedSet2.toArray(new qf.a[sortedSet2.size()]));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        this.f17959f = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(DataType dataType, long j10, long j11) {
        this.f17958e.f(new c.a(dataType, j10, j11));
    }

    /* renamed from: A */
    public void e(DataType dataType, long j10, long j11) {
        x9.a aVar = new x9.a(-1);
        int s10 = this.f17955b.s(this.f17956c, dataType, j10, j11);
        aVar.f36505a = s10;
        k.c("health.db.dataPoint", "markAsSynced, updatedRows: %s, type=%s, {%s ~ %s}", Integer.valueOf(s10), dataType, d.a(j10), d.a(j11));
        if (aVar.f36505a > 0) {
            B(dataType, j10, j11);
        }
    }

    /* renamed from: C */
    public List<qf.a> g(String str, String str2, DataType dataType, long j10, long j11) {
        return this.f17955b.g(str, str2, dataType, j10, j11);
    }

    public qf.a D(String str, DataType dataType) {
        List<qf.a> e10 = this.f17955b.e(this.f17956c, str, dataType);
        if (e10 == null || e10.isEmpty()) {
            return null;
        }
        return e10.get(0);
    }

    /* renamed from: E */
    public qf.a j(String str, DataType dataType, long j10, long j11) {
        List<qf.a> n10 = this.f17955b.n(this.f17956c, str, dataType, j10, j11);
        if (n10 == null || n10.isEmpty()) {
            return null;
        }
        return n10.get(0);
    }

    /* renamed from: F */
    public List<qf.a> f(DataType dataType, long j10) {
        return this.f17955b.k(this.f17956c, null, dataType, j10);
    }

    @Override // com.mobvoi.health.common.data.db.DbSyncAccessor
    public void a() {
        B(null, 0L, s());
    }

    @Override // com.mobvoi.health.common.data.db.DbSyncAccessor
    public /* synthetic */ List h(Enum r12, long j10, long j11) {
        return j.b(this, r12, j10, j11);
    }

    @Override // com.mobvoi.health.common.data.db.DbSyncAccessor
    public /* synthetic */ List i(String str, Enum r22, long j10, long j11) {
        return j.c(this, str, r22, j10, j11);
    }

    @Override // com.mobvoi.health.common.data.db.DbSyncAccessor
    public void k(List<qf.a> list) {
        for (List<qf.a> list2 : u(list)) {
            p(list2);
        }
    }

    @Override // com.mobvoi.health.common.data.db.DbSyncAccessor
    public String o() {
        return this.f17956c;
    }

    public void r(String str) {
        this.f17956c = str;
        a();
    }

    public h<c.a> t() {
        return this.f17958e;
    }

    /* renamed from: v */
    public qf.a d(qf.a aVar) throws NullPointerException, DbSyncAccessor.InvalidParamsException, DbSyncAccessor.TimeOverlapException {
        aVar.b();
        return w(aVar, false);
    }
}
