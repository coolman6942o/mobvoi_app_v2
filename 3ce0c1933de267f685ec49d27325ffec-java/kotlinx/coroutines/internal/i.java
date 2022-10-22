package kotlinx.coroutines.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlinx.coroutines.n0;
/* compiled from: InlineList.kt */
/* loaded from: classes3.dex */
public final class i<E> {
    public static <E> Object a(Object obj) {
        return obj;
    }

    public static /* synthetic */ Object b(Object obj, int i10, f fVar) {
        if ((i10 & 1) != 0) {
            obj = null;
        }
        return a(obj);
    }

    public static final Object c(Object obj, E e10) {
        if (n0.a() && !(!(e10 instanceof List))) {
            throw new AssertionError();
        } else if (obj == null) {
            return a(e10);
        } else {
            if (obj instanceof ArrayList) {
                ((ArrayList) obj).add(e10);
                return a(obj);
            }
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(obj);
            arrayList.add(e10);
            return a(arrayList);
        }
    }
}
