package kotlinx.coroutines.internal;

import kotlin.coroutines.f;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.z1;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThreadContext.kt */
/* loaded from: classes3.dex */
public final class d0 {

    /* renamed from: a  reason: collision with root package name */
    public final f f30206a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f30207b;

    /* renamed from: c  reason: collision with root package name */
    private final z1<Object>[] f30208c;

    /* renamed from: d  reason: collision with root package name */
    private int f30209d;

    public d0(f fVar, int i10) {
        this.f30206a = fVar;
        this.f30207b = new Object[i10];
        this.f30208c = new z1[i10];
    }

    public final void a(z1<?> z1Var, Object obj) {
        Object[] objArr = this.f30207b;
        int i10 = this.f30209d;
        objArr[i10] = obj;
        z1<Object>[] z1VarArr = this.f30208c;
        this.f30209d = i10 + 1;
        z1VarArr[i10] = z1Var;
    }

    public final void b(f fVar) {
        int length = this.f30208c.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                z1<Object> z1Var = this.f30208c[length];
                i.d(z1Var);
                z1Var.v(fVar, this.f30207b[length]);
                if (i10 >= 0) {
                    length = i10;
                } else {
                    return;
                }
            }
        }
    }
}
