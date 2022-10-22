package xo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.i;
import qo.l;
/* compiled from: _Sequences.kt */
/* loaded from: classes3.dex */
public class m extends l {

    /* compiled from: Iterables.kt */
    /* loaded from: classes3.dex */
    public static final class a implements Iterable<T>, ro.a {

        /* renamed from: a */
        final /* synthetic */ e f36638a;

        public a(e eVar) {
            this.f36638a = eVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.f36638a.iterator();
        }
    }

    public static <T> Iterable<T> f(e<? extends T> asIterable) {
        i.f(asIterable, "$this$asIterable");
        return new a(asIterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> e<T> g(e<? extends T> drop, int i10) {
        i.f(drop, "$this$drop");
        if (i10 >= 0) {
            return i10 == 0 ? drop : drop instanceof c ? ((c) drop).a(i10) : new b(drop, i10);
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    public static final <T, A extends Appendable> A h(e<? extends T> joinTo, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, l<? super T, ? extends CharSequence> lVar) {
        i.f(joinTo, "$this$joinTo");
        i.f(buffer, "buffer");
        i.f(separator, "separator");
        i.f(prefix, "prefix");
        i.f(postfix, "postfix");
        i.f(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (T t10 : joinTo) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            kotlin.text.l.a(buffer, t10, lVar);
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <T> String i(e<? extends T> joinToString, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, l<? super T, ? extends CharSequence> lVar) {
        i.f(joinToString, "$this$joinToString");
        i.f(separator, "separator");
        i.f(prefix, "prefix");
        i.f(postfix, "postfix");
        i.f(truncated, "truncated");
        String sb2 = ((StringBuilder) h(joinToString, new StringBuilder(), separator, prefix, postfix, i10, truncated, lVar)).toString();
        i.e(sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb2;
    }

    public static /* synthetic */ String j(e eVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i11 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i11 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return i(eVar, charSequence, charSequence6, charSequence5, i12, charSequence7, lVar);
    }

    public static <T, R> e<R> k(e<? extends T> map, l<? super T, ? extends R> transform) {
        i.f(map, "$this$map");
        i.f(transform, "transform");
        return new n(map, transform);
    }

    public static final <T, C extends Collection<? super T>> C l(e<? extends T> toCollection, C destination) {
        i.f(toCollection, "$this$toCollection");
        i.f(destination, "destination");
        for (T t10 : toCollection) {
            destination.add(t10);
        }
        return destination;
    }

    public static <T> List<T> m(e<? extends T> toList) {
        List<T> m10;
        i.f(toList, "$this$toList");
        m10 = kotlin.collections.m.m(n(toList));
        return m10;
    }

    public static final <T> List<T> n(e<? extends T> toMutableList) {
        i.f(toMutableList, "$this$toMutableList");
        return (List) l(toMutableList, new ArrayList());
    }
}
