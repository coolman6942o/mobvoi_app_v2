package kotlinx.coroutines;

import com.huawei.hms.ml.camera.CameraConfig;
import kotlin.coroutines.d;
import kotlin.coroutines.f;
import kotlin.coroutines.jvm.internal.c;
import kotlinx.coroutines.internal.x;
import kotlinx.coroutines.scheduling.a;
/* compiled from: CoroutineContext.kt */
/* loaded from: classes3.dex */
public final class f0 {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f30171a;

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
        if (r0.equals("on") != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
        if (r0.equals("") != false) goto L19;
     */
    static {
        boolean z10;
        String d10 = x.d("kotlinx.coroutines.scheduler");
        if (d10 != null) {
            int hashCode = d10.hashCode();
            if (hashCode != 0) {
                if (hashCode != 3551) {
                    if (hashCode == 109935 && d10.equals(CameraConfig.CAMERA_TORCH_OFF)) {
                        z10 = false;
                    }
                }
                throw new IllegalStateException(("System property 'kotlinx.coroutines.scheduler' has unrecognized value '" + ((Object) d10) + '\'').toString());
            }
            f30171a = z10;
        }
        z10 = true;
        f30171a = z10;
    }

    public static final g0 a() {
        return f30171a ? a.f30306g : x.f30345b;
    }

    public static final String b(f fVar) {
        j0 j0Var;
        String Q;
        if (!n0.c() || (j0Var = (j0) fVar.get(j0.f30246b)) == null) {
            return null;
        }
        k0 k0Var = (k0) fVar.get(k0.f30250b);
        String str = "coroutine";
        if (!(k0Var == null || (Q = k0Var.Q()) == null)) {
            str = Q;
        }
        return str + '#' + j0Var.Q();
    }

    public static final f c(l0 l0Var, f fVar) {
        f plus = l0Var.getCoroutineContext().plus(fVar);
        f plus2 = n0.c() ? plus.plus(new j0(n0.b().incrementAndGet())) : plus;
        return (plus == t0.a() || plus.get(d.f30064e0) != null) ? plus2 : plus2.plus(t0.a());
    }

    public static final c2<?> d(c cVar) {
        while (!(cVar instanceof q0) && (cVar = cVar.getCallerFrame()) != null) {
            if (cVar instanceof c2) {
                return (c2) cVar;
            }
        }
        return null;
    }

    public static final c2<?> e(kotlin.coroutines.c<?> cVar, f fVar, Object obj) {
        if (!(cVar instanceof c)) {
            return null;
        }
        if (!(fVar.get(d2.f30166a) != null)) {
            return null;
        }
        c2<?> d10 = d((c) cVar);
        if (d10 != null) {
            d10.y0(fVar, obj);
        }
        return d10;
    }
}
