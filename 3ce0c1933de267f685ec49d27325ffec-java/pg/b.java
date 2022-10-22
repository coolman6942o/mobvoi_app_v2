package pg;

import android.annotation.SuppressLint;
import lh.d;
/* compiled from: HealthStorageImpl.java */
/* loaded from: classes2.dex */
public class b extends d {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: j  reason: collision with root package name */
    private static volatile b f32774j;

    private b() {
        super(ig.b.J());
        this.f30473b.f(new a());
    }

    public static b q() {
        if (f32774j == null) {
            synchronized (b.class) {
                if (f32774j == null) {
                    f32774j = new b();
                }
            }
        }
        return f32774j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // lh.d
    public void j() {
        super.j();
    }
}
