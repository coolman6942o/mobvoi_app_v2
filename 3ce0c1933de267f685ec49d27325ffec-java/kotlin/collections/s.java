package kotlin.collections;

import java.util.List;
import kotlin.jvm.internal.i;
import vo.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReversedViews.kt */
/* loaded from: classes3.dex */
public class s extends r {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int A(List<?> list, int i10) {
        int size = list.size();
        if (i10 >= 0 && size >= i10) {
            return list.size() - i10;
        }
        throw new IndexOutOfBoundsException("Position index " + i10 + " must be in range [" + new c(0, list.size()) + "].");
    }

    public static <T> List<T> y(List<T> asReversed) {
        i.f(asReversed, "$this$asReversed");
        return new f0(asReversed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int z(List<?> list, int i10) {
        int i11;
        int i12;
        int i13;
        i11 = m.i(list);
        if (i10 < 0 || i11 < i10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Element index ");
            sb2.append(i10);
            sb2.append(" must be in range [");
            i12 = m.i(list);
            sb2.append(new c(0, i12));
            sb2.append("].");
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        i13 = m.i(list);
        return i13 - i10;
    }
}
