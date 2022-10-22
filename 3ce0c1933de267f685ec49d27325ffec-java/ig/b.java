package ig;

import android.content.Context;
import com.mobvoi.android.common.utils.e;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.health.companion.system.b;
import of.g;
import qh.a;
import xj.c;
/* compiled from: PhoneCommonStorage.java */
/* loaded from: classes2.dex */
public class b extends g {

    /* renamed from: r  reason: collision with root package name */
    private static volatile b f28268r;

    /* renamed from: p  reason: collision with root package name */
    private final a f28269p = new a(z());

    /* renamed from: q  reason: collision with root package name */
    private final c f28270q = new c(z(), C(), h());

    private b(final Context context) {
        super(context);
        String l10 = com.mobvoi.health.companion.system.c.a().l(context);
        k.i("health.data.storage", "Health common storage init with wwid %s", l10);
        E(l10, false);
        com.mobvoi.health.companion.system.c.a().d(context, new b.a() { // from class: ig.a
            @Override // com.mobvoi.health.companion.system.b.a
            public final void a(boolean z10) {
                b.this.M(context, z10);
            }
        });
        D(e.e(context));
        F(context, true);
    }

    public static b J() {
        if (f28268r != null) {
            return f28268r;
        }
        throw new RuntimeException("Call PhoneCommonStorage.init(Context) before using it.");
    }

    public static void L(Context context) {
        if (f28268r == null) {
            f28268r = new b(context);
            return;
        }
        throw new RuntimeException("PhoneCommonStorage already initialized.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(Context context, boolean z10) {
        String str;
        if (z10) {
            str = com.mobvoi.health.companion.system.c.a().s(context);
        } else {
            str = com.mobvoi.health.companion.system.c.a().l(context);
        }
        k.i("health.data.storage", "Health common storage wwid changed to %s", str);
        E(str, z10);
    }

    @Override // of.g
    public void E(String str, boolean z10) {
        k.h("health.data.storage", " setAccountWwid wwid = " + str + " isTiccareAccount = " + z10);
        super.E(str, z10);
        this.f28270q.f(str);
    }

    public a I() {
        return this.f28269p;
    }

    public c K() {
        return this.f28270q;
    }

    @Override // of.g
    public uf.a g(Context context) {
        return new kg.c(context, h());
    }
}
