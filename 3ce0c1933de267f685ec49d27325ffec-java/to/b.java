package to;

import java.util.Random;
import kotlin.jvm.internal.i;
/* compiled from: PlatformRandom.kt */
/* loaded from: classes3.dex */
public final class b extends to.a {

    /* renamed from: a  reason: collision with root package name */
    private final a f35233a = new a();

    /* compiled from: PlatformRandom.kt */
    /* loaded from: classes3.dex */
    public static final class a extends ThreadLocal<Random> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // to.a
    public Random a() {
        Random random = this.f35233a.get();
        i.e(random, "implStorage.get()");
        return random;
    }
}
