package c;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.i;
/* compiled from: ActivityResultContract.kt */
/* loaded from: classes.dex */
public abstract class a<I, O> {

    /* compiled from: ActivityResultContract.kt */
    /* renamed from: c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0080a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final T f5538a;

        public C0080a(T t10) {
            this.f5538a = t10;
        }

        public final T a() {
            return this.f5538a;
        }
    }

    public abstract Intent a(Context context, I i10);

    public C0080a<O> b(Context context, I i10) {
        i.f(context, "context");
        return null;
    }

    public abstract O c(int i10, Intent intent);
}
