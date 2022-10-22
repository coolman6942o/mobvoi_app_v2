package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.work.impl.background.systemalarm.e;
import androidx.work.k;
import java.util.ArrayList;
import java.util.List;
import u1.d;
import y1.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConstraintsCommandHandler.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    private static final String f4780e = k.f("ConstraintsCmdHandler");

    /* renamed from: a  reason: collision with root package name */
    private final Context f4781a;

    /* renamed from: b  reason: collision with root package name */
    private final int f4782b;

    /* renamed from: c  reason: collision with root package name */
    private final e f4783c;

    /* renamed from: d  reason: collision with root package name */
    private final d f4784d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, int i10, e eVar) {
        this.f4781a = context;
        this.f4782b = i10;
        this.f4783c = eVar;
        this.f4784d = new d(context, eVar.f(), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        List<p> h10 = this.f4783c.g().n().M().h();
        ConstraintProxy.a(this.f4781a, h10);
        this.f4784d.d(h10);
        ArrayList<p> arrayList = new ArrayList(h10.size());
        long currentTimeMillis = System.currentTimeMillis();
        for (p pVar : h10) {
            String str = pVar.f36689a;
            if (currentTimeMillis >= pVar.a() && (!pVar.b() || this.f4784d.c(str))) {
                arrayList.add(pVar);
            }
        }
        for (p pVar2 : arrayList) {
            String str2 = pVar2.f36689a;
            Intent b10 = b.b(this.f4781a, str2);
            k.c().a(f4780e, String.format("Creating a delay_met command for workSpec with id (%s)", str2), new Throwable[0]);
            e eVar = this.f4783c;
            eVar.k(new e.b(eVar, b10, this.f4782b));
        }
        this.f4784d.e();
    }
}
