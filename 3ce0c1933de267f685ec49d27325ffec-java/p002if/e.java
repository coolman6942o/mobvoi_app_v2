package p002if;

import android.content.Context;
import bf.c;
import com.mobvoi.android.common.utils.k;
import df.a;
import df.b;
import df.d;
import ef.r;
import ef.u;
import hf.j;
import hf.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p002if.a;
/* compiled from: NetPostClient.java */
/* renamed from: if.e  reason: invalid package */
/* loaded from: classes2.dex */
public class e extends a implements j {

    /* renamed from: d  reason: collision with root package name */
    private o<List<String>> f28251d;

    /* renamed from: e  reason: collision with root package name */
    private int f28252e;

    /* renamed from: f  reason: collision with root package name */
    private String f28253f;

    public e(Context context, c cVar, int i10, String str) {
        super(context, cVar);
        this.f28252e = i10;
        this.f28253f = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List n(List list, d dVar) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            u b10 = ((r) it.next()).b();
            if (b10 != null) {
                arrayList.add(b10.f25984c);
            }
        }
        return arrayList;
    }

    @Override // hf.p
    public String a() {
        return this.f28253f;
    }

    @Override // hf.j
    public void d(final List<r> list) {
        k.i("fit.net.client", "postRecords, have %d records to post", Integer.valueOf(list.size()));
        ArrayList arrayList = new ArrayList(list.size());
        for (r rVar : list) {
            if (rVar.e()) {
                arrayList.add(a.b(rVar, this.f28252e));
            }
        }
        b bVar = new b();
        bVar.records = arrayList;
        j().a(bVar).enqueue(l(this.f28251d, new a.b() { // from class: if.d
            @Override // p002if.a.b
            public final Object a(df.d dVar) {
                List n10;
                n10 = e.n(list, dVar);
                return n10;
            }
        }));
    }

    @Override // hf.j
    public void e(o<List<String>> oVar) {
        this.f28251d = oVar;
    }
}
