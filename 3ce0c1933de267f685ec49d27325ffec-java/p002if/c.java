package p002if;

import android.content.Context;
import com.mobvoi.android.common.utils.k;
import df.d;
import hf.i;
import hf.o;
import java.util.Collections;
import java.util.List;
import p002if.a;
/* compiled from: NetDeleteClient.java */
/* renamed from: if.c  reason: invalid package */
/* loaded from: classes2.dex */
public class c extends a implements i {

    /* renamed from: d  reason: collision with root package name */
    private o<List<String>> f28248d;

    /* renamed from: e  reason: collision with root package name */
    private String f28249e;

    public c(Context context, bf.c cVar, String str) {
        super(context, cVar);
        this.f28249e = str;
    }

    @Override // hf.p
    public String a() {
        return this.f28249e;
    }

    @Override // hf.i
    public void b(List<String> list) {
        k.i("fit.net.client", "deleteRecords, %s", list);
        for (final String str : list) {
            j().b(str).enqueue(l(this.f28248d, new a.b() { // from class: if.b
                @Override // p002if.a.b
                public final Object a(d dVar) {
                    List singletonList;
                    singletonList = Collections.singletonList(str);
                    return singletonList;
                }
            }));
        }
    }

    @Override // hf.i
    public void g(o<List<String>> oVar) {
        this.f28248d = oVar;
    }
}
