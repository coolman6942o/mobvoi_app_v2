package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.primitives.d;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.NoSuchElementException;
/* compiled from: DiscreteDomain.java */
/* loaded from: classes.dex */
public abstract class h3<C extends Comparable> {
    final boolean supportsFastOffset;

    /* compiled from: DiscreteDomain.java */
    /* loaded from: classes.dex */
    private static final class b extends h3<Integer> implements Serializable {
        private static final b INSTANCE = new b();
        private static final long serialVersionUID = 0;

        b() {
            super(true);
        }

        /* renamed from: l */
        public long a(Integer num, Integer num2) {
            return num2.intValue() - num.intValue();
        }

        /* renamed from: m */
        public Integer d() {
            return Integer.MAX_VALUE;
        }

        /* renamed from: n */
        public Integer g() {
            return Integer.MIN_VALUE;
        }

        /* renamed from: o */
        public Integer h(Integer num) {
            int intValue = num.intValue();
            if (intValue == Integer.MAX_VALUE) {
                return null;
            }
            return Integer.valueOf(intValue + 1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: p */
        public Integer i(Integer num, long j10) {
            p2.c(j10, "distance");
            return Integer.valueOf(d.c(num.longValue() + j10));
        }

        /* renamed from: q */
        public Integer j(Integer num) {
            int intValue = num.intValue();
            if (intValue == Integer.MIN_VALUE) {
                return null;
            }
            return Integer.valueOf(intValue - 1);
        }

        public String toString() {
            return "DiscreteDomain.integers()";
        }
    }

    /* compiled from: DiscreteDomain.java */
    /* loaded from: classes.dex */
    private static final class c extends h3<Long> implements Serializable {
        private static final c INSTANCE = new c();
        private static final long serialVersionUID = 0;

        c() {
            super(true);
        }

        /* renamed from: l */
        public long a(Long l10, Long l11) {
            long longValue = l11.longValue() - l10.longValue();
            if (l11.longValue() > l10.longValue() && longValue < 0) {
                return Long.MAX_VALUE;
            }
            if (l11.longValue() >= l10.longValue() || longValue <= 0) {
                return longValue;
            }
            return Long.MIN_VALUE;
        }

        /* renamed from: m */
        public Long d() {
            return Long.MAX_VALUE;
        }

        /* renamed from: n */
        public Long g() {
            return Long.MIN_VALUE;
        }

        /* renamed from: o */
        public Long h(Long l10) {
            long longValue = l10.longValue();
            if (longValue == Long.MAX_VALUE) {
                return null;
            }
            return Long.valueOf(longValue + 1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: p */
        public Long i(Long l10, long j10) {
            p2.c(j10, "distance");
            long longValue = l10.longValue() + j10;
            if (longValue < 0) {
                p.e(l10.longValue() < 0, "overflow");
            }
            return Long.valueOf(longValue);
        }

        /* renamed from: q */
        public Long j(Long l10) {
            long longValue = l10.longValue();
            if (longValue == Long.MIN_VALUE) {
                return null;
            }
            return Long.valueOf(longValue - 1);
        }

        public String toString() {
            return "DiscreteDomain.longs()";
        }
    }

    public static h3<Integer> b() {
        return b.INSTANCE;
    }

    public static h3<Long> c() {
        return c.INSTANCE;
    }

    public abstract long a(C c10, C c11);

    public C d() {
        throw new NoSuchElementException();
    }

    public C g() {
        throw new NoSuchElementException();
    }

    public abstract C h(C c10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public C i(C c10, long j10) {
        p2.c(j10, "distance");
        for (long j11 = 0; j11 < j10; j11++) {
            c10 = h(c10);
        }
        return c10;
    }

    public abstract C j(C c10);

    protected h3() {
        this(false);
    }

    private h3(boolean z10) {
        this.supportsFastOffset = z10;
    }
}
