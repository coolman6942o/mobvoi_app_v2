package kotlinx.coroutines.internal;

import java.util.Objects;
import kotlin.collections.h;
/* compiled from: ArrayQueue.kt */
/* loaded from: classes3.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private Object[] f30195a = new Object[16];

    /* renamed from: b  reason: collision with root package name */
    private int f30196b;

    /* renamed from: c  reason: collision with root package name */
    private int f30197c;

    private final void b() {
        Object[] objArr = this.f30195a;
        int length = objArr.length;
        Object[] objArr2 = new Object[length << 1];
        h.f(objArr, objArr2, 0, this.f30196b, 0, 10, null);
        Object[] objArr3 = this.f30195a;
        int length2 = objArr3.length;
        int i10 = this.f30196b;
        h.f(objArr3, objArr2, length2 - i10, 0, i10, 4, null);
        this.f30195a = objArr2;
        this.f30196b = 0;
        this.f30197c = length;
    }

    public final void a(T t10) {
        Object[] objArr = this.f30195a;
        int i10 = this.f30197c;
        objArr[i10] = t10;
        int length = (objArr.length - 1) & (i10 + 1);
        this.f30197c = length;
        if (length == this.f30196b) {
            b();
        }
    }

    public final boolean c() {
        return this.f30196b == this.f30197c;
    }

    public final T d() {
        int i10 = this.f30196b;
        if (i10 == this.f30197c) {
            return null;
        }
        Object[] objArr = this.f30195a;
        T t10 = (T) objArr[i10];
        objArr[i10] = null;
        this.f30196b = (i10 + 1) & (objArr.length - 1);
        Objects.requireNonNull(t10, "null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue");
        return t10;
    }
}
