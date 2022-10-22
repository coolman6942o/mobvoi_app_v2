package pk;

import java.io.File;
import lh.d;
import of.g;
import xe.b;
import yg.f;
/* compiled from: BandModuleInitializer.java */
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: c  reason: collision with root package name */
    private static volatile e f32793c;

    /* renamed from: a  reason: collision with root package name */
    private final b f32794a;

    /* renamed from: b  reason: collision with root package name */
    private u f32795b = new a(this);

    /* compiled from: BandModuleInitializer.java */
    /* loaded from: classes2.dex */
    class a implements u {
        a(e eVar) {
        }

        @Override // pk.u
        public String b() {
            return ta.a.d();
        }

        @Override // pk.u
        public String getWwid() {
            return ta.a.x();
        }
    }

    static {
        StringBuilder sb2 = new StringBuilder();
        String str = File.separator;
        sb2.append(str);
        sb2.append("ticband");
        sb2.append(str);
    }

    private e() {
        try {
            f.X();
        } catch (Exception unused) {
            f.Y(com.mobvoi.android.common.utils.b.e());
        }
        this.f32794a = f.X().p();
    }

    public static e f() {
        if (f32793c == null) {
            synchronized (e.class) {
                if (f32793c == null) {
                    f32793c = new e();
                }
            }
        }
        return f32793c;
    }

    public u a() {
        return this.f32795b;
    }

    public g b() {
        return ig.b.J();
    }

    public com.mobvoi.health.common.data.db.a c() {
        return ig.b.J().z();
    }

    public b d() {
        return this.f32794a;
    }

    public d e() {
        return pg.b.q();
    }

    public xj.a g() {
        return ig.b.J().K();
    }
}
