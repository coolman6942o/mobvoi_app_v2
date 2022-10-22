package kotlinx.coroutines;

import kotlin.jvm.internal.i;
import kotlinx.coroutines.internal.j;
import kotlinx.coroutines.internal.l;
/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public final class t1 extends j implements e1 {
    @Override // kotlinx.coroutines.e1
    public boolean c() {
        return true;
    }

    @Override // kotlinx.coroutines.e1
    public t1 d() {
        return this;
    }

    @Override // kotlinx.coroutines.internal.l
    public String toString() {
        return n0.c() ? w("Active") : super.toString();
    }

    public final String w(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("List{");
        sb2.append(str);
        sb2.append("}[");
        boolean z10 = true;
        for (l lVar = (l) m(); !i.b(lVar, this); lVar = lVar.n()) {
            if (lVar instanceof o1) {
                o1 o1Var = (o1) lVar;
                if (z10) {
                    z10 = false;
                } else {
                    sb2.append(", ");
                }
                sb2.append(o1Var);
            }
        }
        sb2.append("]");
        String sb3 = sb2.toString();
        i.e(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }
}
