package kotlin.collections;

import io.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.i;
import qo.l;
import vo.f;
import xo.e;
/* compiled from: _Collections.kt */
/* loaded from: classes3.dex */
public class u extends t {

    /* compiled from: Sequences.kt */
    /* loaded from: classes3.dex */
    public static final class a implements e<T> {

        /* renamed from: a */
        final /* synthetic */ Iterable f30058a;

        public a(Iterable iterable) {
            this.f30058a = iterable;
        }

        @Override // xo.e
        public Iterator<T> iterator() {
            return this.f30058a.iterator();
        }
    }

    public static <T> e<T> B(Iterable<? extends T> asSequence) {
        i.f(asSequence, "$this$asSequence");
        return new a(asSequence);
    }

    public static <T> boolean C(Iterable<? extends T> contains, T t10) {
        i.f(contains, "$this$contains");
        if (contains instanceof Collection) {
            return ((Collection) contains).contains(t10);
        }
        return G(contains, t10) >= 0;
    }

    public static <T> List<T> D(List<? extends T> dropLast, int i10) {
        int c10;
        i.f(dropLast, "$this$dropLast");
        if (i10 >= 0) {
            c10 = f.c(dropLast.size() - i10, 0);
            return S(dropLast, c10);
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    public static <T> T E(Iterable<? extends T> first) {
        i.f(first, "$this$first");
        if (first instanceof List) {
            return (T) k.F((List) first);
        }
        Iterator<? extends T> it = first.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T F(List<? extends T> first) {
        i.f(first, "$this$first");
        if (!first.isEmpty()) {
            return first.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> int G(Iterable<? extends T> indexOf, T t10) {
        i.f(indexOf, "$this$indexOf");
        if (indexOf instanceof List) {
            return ((List) indexOf).indexOf(t10);
        }
        int i10 = 0;
        for (T t11 : indexOf) {
            if (i10 < 0) {
                m.o();
            }
            if (i.b(t10, t11)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static final <T, A extends Appendable> A H(Iterable<? extends T> joinTo, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, l<? super T, ? extends CharSequence> lVar) {
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

    public static /* synthetic */ Appendable I(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, l lVar, int i11, Object obj) {
        String str = (i11 & 2) != 0 ? ", " : charSequence;
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i11 & 4) != 0 ? charSequence5 : charSequence2;
        if ((i11 & 8) == 0) {
            charSequence5 = charSequence3;
        }
        return H(iterable, appendable, str, charSequence6, charSequence5, (i11 & 16) != 0 ? -1 : i10, (i11 & 32) != 0 ? "..." : charSequence4, (i11 & 64) != 0 ? null : lVar);
    }

    public static final <T> String J(Iterable<? extends T> joinToString, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, l<? super T, ? extends CharSequence> lVar) {
        i.f(joinToString, "$this$joinToString");
        i.f(separator, "separator");
        i.f(prefix, "prefix");
        i.f(postfix, "postfix");
        i.f(truncated, "truncated");
        String sb2 = ((StringBuilder) H(joinToString, new StringBuilder(), separator, prefix, postfix, i10, truncated, lVar)).toString();
        i.e(sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb2;
    }

    public static /* synthetic */ String K(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, l lVar, int i11, Object obj) {
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
        return J(iterable, charSequence, charSequence6, charSequence5, i12, charSequence7, lVar);
    }

    public static <T> T L(List<? extends T> last) {
        int i10;
        i.f(last, "$this$last");
        if (!last.isEmpty()) {
            i10 = m.i(last);
            return last.get(i10);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T extends Comparable<? super T>> T M(Iterable<? extends T> minOrNull) {
        i.f(minOrNull, "$this$minOrNull");
        Iterator<? extends T> it = minOrNull.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static <T> List<T> N(Collection<? extends T> plus, Iterable<? extends T> elements) {
        i.f(plus, "$this$plus");
        i.f(elements, "elements");
        if (elements instanceof Collection) {
            Collection collection = (Collection) elements;
            ArrayList arrayList = new ArrayList(plus.size() + collection.size());
            arrayList.addAll(plus);
            arrayList.addAll(collection);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(plus);
        r.s(arrayList2, elements);
        return arrayList2;
    }

    public static <T> List<T> O(Collection<? extends T> plus, T t10) {
        i.f(plus, "$this$plus");
        ArrayList arrayList = new ArrayList(plus.size() + 1);
        arrayList.addAll(plus);
        arrayList.add(t10);
        return arrayList;
    }

    public static <T> T P(Iterable<? extends T> single) {
        i.f(single, "$this$single");
        if (single instanceof List) {
            return (T) Q((List) single);
        }
        Iterator<? extends T> it = single.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (!it.hasNext()) {
                return next;
            }
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> T Q(List<? extends T> single) {
        i.f(single, "$this$single");
        int size = single.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        } else if (size == 1) {
            return single.get(0);
        } else {
            throw new IllegalArgumentException("List has more than one element.");
        }
    }

    public static <T extends Comparable<? super T>> List<T> R(Iterable<? extends T> sorted) {
        List<T> b10;
        List<T> U;
        i.f(sorted, "$this$sorted");
        if (sorted instanceof Collection) {
            Collection collection = (Collection) sorted;
            if (collection.size() <= 1) {
                U = U(sorted);
                return U;
            }
            Object[] array = collection.toArray(new Comparable[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            Comparable[] comparableArr = (Comparable[]) array;
            h.l(comparableArr);
            b10 = h.b(comparableArr);
            return b10;
        }
        List<T> V = V(sorted);
        q.q(V);
        return V;
    }

    public static final <T> List<T> S(Iterable<? extends T> take, int i10) {
        List<T> m10;
        List<T> b10;
        List<T> U;
        List<T> g10;
        i.f(take, "$this$take");
        int i11 = 0;
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        } else if (i10 == 0) {
            g10 = m.g();
            return g10;
        } else {
            if (take instanceof Collection) {
                if (i10 >= ((Collection) take).size()) {
                    U = U(take);
                    return U;
                } else if (i10 == 1) {
                    b10 = l.b(k.E(take));
                    return b10;
                }
            }
            ArrayList arrayList = new ArrayList(i10);
            for (T t10 : take) {
                arrayList.add(t10);
                i11++;
                if (i11 == i10) {
                    break;
                }
            }
            m10 = m.m(arrayList);
            return m10;
        }
    }

    public static final <T, C extends Collection<? super T>> C T(Iterable<? extends T> toCollection, C destination) {
        i.f(toCollection, "$this$toCollection");
        i.f(destination, "destination");
        for (T t10 : toCollection) {
            destination.add(t10);
        }
        return destination;
    }

    public static <T> List<T> U(Iterable<? extends T> toList) {
        List<T> m10;
        List<T> g10;
        List<T> b10;
        List<T> W;
        i.f(toList, "$this$toList");
        if (toList instanceof Collection) {
            Collection collection = (Collection) toList;
            int size = collection.size();
            if (size == 0) {
                g10 = m.g();
                return g10;
            } else if (size != 1) {
                W = W(collection);
                return W;
            } else {
                b10 = l.b(toList instanceof List ? ((List) toList).get(0) : toList.iterator().next());
                return b10;
            }
        } else {
            m10 = m.m(V(toList));
            return m10;
        }
    }

    public static final <T> List<T> V(Iterable<? extends T> toMutableList) {
        List<T> W;
        i.f(toMutableList, "$this$toMutableList");
        if (!(toMutableList instanceof Collection)) {
            return (List) T(toMutableList, new ArrayList());
        }
        W = W((Collection) toMutableList);
        return W;
    }

    public static <T> List<T> W(Collection<? extends T> toMutableList) {
        i.f(toMutableList, "$this$toMutableList");
        return new ArrayList(toMutableList);
    }

    public static <T> Set<T> X(Iterable<? extends T> toSet) {
        Set<T> b10;
        int b11;
        i.f(toSet, "$this$toSet");
        if (!(toSet instanceof Collection)) {
            return i0.c((Set) T(toSet, new LinkedHashSet()));
        }
        Collection collection = (Collection) toSet;
        int size = collection.size();
        if (size == 0) {
            b10 = i0.b();
            return b10;
        } else if (size != 1) {
            b11 = c0.b(collection.size());
            return (Set) T(toSet, new LinkedHashSet(b11));
        } else {
            return h0.a(toSet instanceof List ? ((List) toSet).get(0) : toSet.iterator().next());
        }
    }

    public static <T, R> List<Pair<T, R>> Y(Iterable<? extends T> zip, Iterable<? extends R> other) {
        int p10;
        int p11;
        i.f(zip, "$this$zip");
        i.f(other, "other");
        Iterator<? extends T> it = zip.iterator();
        Iterator<? extends R> it2 = other.iterator();
        p10 = n.p(zip, 10);
        p11 = n.p(other, 10);
        ArrayList arrayList = new ArrayList(Math.min(p10, p11));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(j.a(it.next(), it2.next()));
        }
        return arrayList;
    }
}
