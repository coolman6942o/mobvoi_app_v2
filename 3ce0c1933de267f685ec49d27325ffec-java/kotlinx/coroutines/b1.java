package kotlinx.coroutines;

import java.io.Closeable;
import kotlin.coroutines.b;
import kotlin.coroutines.f;
import kotlin.jvm.internal.Lambda;
import qo.l;
/* compiled from: Executors.kt */
/* loaded from: classes3.dex */
public abstract class b1 extends g0 implements Closeable {

    /* compiled from: Executors.kt */
    /* loaded from: classes3.dex */
    public static final class a extends b<g0, b1> {

        /* compiled from: Executors.kt */
        /* renamed from: kotlinx.coroutines.b1$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static final class C0374a extends Lambda implements l<f.b, b1> {
            public static final C0374a INSTANCE = new C0374a();

            C0374a() {
                super(1);
            }

            /* renamed from: a */
            public final b1 invoke(f.b bVar) {
                if (bVar instanceof b1) {
                    return (b1) bVar;
                }
                return null;
            }
        }

        private a() {
            super(g0.f30186a, C0374a.INSTANCE);
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    static {
        new a(null);
    }
}
