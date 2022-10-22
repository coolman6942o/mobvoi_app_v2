package com.google.common.collect;

import com.google.common.base.h;
import com.google.common.base.p;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SortedLists.java */
/* loaded from: classes.dex */
public final class s7 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: SortedLists.java */
    /* loaded from: classes.dex */
    public static abstract class b extends Enum<b> {
        public static final b NEXT_LOWER = new a("NEXT_LOWER", 0);
        public static final b NEXT_HIGHER = new C0149b("NEXT_HIGHER", 1);
        public static final b INVERTED_INSERTION_INDEX = new c("INVERTED_INSERTION_INDEX", 2);
        private static final /* synthetic */ b[] $VALUES = a();

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: SortedLists.java */
        /* loaded from: classes.dex */
        final class a extends b {
            a(String str, int i10) {
                super(str, i10);
            }

            @Override // com.google.common.collect.s7.b
            int b(int i10) {
                return i10 - 1;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: SortedLists.java */
        /* renamed from: com.google.common.collect.s7$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        final class C0149b extends b {
            C0149b(String str, int i10) {
                super(str, i10);
            }

            @Override // com.google.common.collect.s7.b
            public int b(int i10) {
                return i10;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: SortedLists.java */
        /* loaded from: classes.dex */
        final class c extends b {
            c(String str, int i10) {
                super(str, i10);
            }

            @Override // com.google.common.collect.s7.b
            public int b(int i10) {
                return ~i10;
            }
        }

        private b(String str, int i10) {
        }

        private static /* synthetic */ b[] a() {
            return new b[]{NEXT_LOWER, NEXT_HIGHER, INVERTED_INSERTION_INDEX};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) $VALUES.clone();
        }

        abstract int b(int i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: SortedLists.java */
    /* loaded from: classes.dex */
    public static abstract class c extends Enum<c> {
        public static final c ANY_PRESENT = new a("ANY_PRESENT", 0);
        public static final c LAST_PRESENT = new b("LAST_PRESENT", 1);
        public static final c FIRST_PRESENT = new C0150c("FIRST_PRESENT", 2);
        public static final c FIRST_AFTER = new d("FIRST_AFTER", 3);
        public static final c LAST_BEFORE = new e("LAST_BEFORE", 4);
        private static final /* synthetic */ c[] $VALUES = a();

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: SortedLists.java */
        /* loaded from: classes.dex */
        final class a extends c {
            a(String str, int i10) {
                super(str, i10);
            }

            @Override // com.google.common.collect.s7.c
            <E> int b(Comparator<? super E> comparator, E e10, List<? extends E> list, int i10) {
                return i10;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: SortedLists.java */
        /* loaded from: classes.dex */
        final class b extends c {
            b(String str, int i10) {
                super(str, i10);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.s7.c
            <E> int b(Comparator<? super E> comparator, E e10, List<? extends E> list, int i10) {
                int size = list.size() - 1;
                while (i10 < size) {
                    int i11 = ((i10 + size) + 1) >>> 1;
                    if (comparator.compare((E) list.get(i11), e10) > 0) {
                        size = i11 - 1;
                    } else {
                        i10 = i11;
                    }
                }
                return i10;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: SortedLists.java */
        /* renamed from: com.google.common.collect.s7$c$c  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        final class C0150c extends c {
            C0150c(String str, int i10) {
                super(str, i10);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.s7.c
            <E> int b(Comparator<? super E> comparator, E e10, List<? extends E> list, int i10) {
                int i11 = 0;
                while (i11 < i10) {
                    int i12 = (i11 + i10) >>> 1;
                    if (comparator.compare((E) list.get(i12), e10) < 0) {
                        i11 = i12 + 1;
                    } else {
                        i10 = i12;
                    }
                }
                return i11;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: SortedLists.java */
        /* loaded from: classes.dex */
        final class d extends c {
            d(String str, int i10) {
                super(str, i10);
            }

            @Override // com.google.common.collect.s7.c
            public <E> int b(Comparator<? super E> comparator, E e10, List<? extends E> list, int i10) {
                return c.LAST_PRESENT.b(comparator, e10, list, i10) + 1;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: SortedLists.java */
        /* loaded from: classes.dex */
        final class e extends c {
            e(String str, int i10) {
                super(str, i10);
            }

            @Override // com.google.common.collect.s7.c
            public <E> int b(Comparator<? super E> comparator, E e10, List<? extends E> list, int i10) {
                return c.FIRST_PRESENT.b(comparator, e10, list, i10) - 1;
            }
        }

        private c(String str, int i10) {
        }

        private static /* synthetic */ c[] a() {
            return new c[]{ANY_PRESENT, LAST_PRESENT, FIRST_PRESENT, FIRST_AFTER, LAST_BEFORE};
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) $VALUES.clone();
        }

        abstract <E> int b(Comparator<? super E> comparator, E e10, List<? extends E> list, int i10);
    }

    public static <E, K extends Comparable> int a(List<E> list, h<? super E, K> hVar, K k10, c cVar, b bVar) {
        return b(list, hVar, k10, q6.g(), cVar, bVar);
    }

    public static <E, K> int b(List<E> list, h<? super E, K> hVar, K k10, Comparator<? super K> comparator, c cVar, b bVar) {
        return c(s5.l(list, hVar), k10, comparator, cVar, bVar);
    }

    public static <E> int c(List<? extends E> list, E e10, Comparator<? super E> comparator, c cVar, b bVar) {
        p.o(comparator);
        p.o(list);
        p.o(cVar);
        p.o(bVar);
        if (!(list instanceof RandomAccess)) {
            list = s5.h(list);
        }
        int i10 = 0;
        int size = list.size() - 1;
        while (i10 <= size) {
            int i11 = (i10 + size) >>> 1;
            int compare = comparator.compare(e10, (E) list.get(i11));
            if (compare < 0) {
                size = i11 - 1;
            } else if (compare <= 0) {
                return i10 + cVar.b(comparator, e10, list.subList(i10, size + 1), i11 - i10);
            } else {
                i10 = i11 + 1;
            }
        }
        return bVar.b(i10);
    }
}
