package com.google.common.base;
/* compiled from: CharMatcher.java */
/* loaded from: classes.dex */
public abstract class d implements r<Character> {

    /* compiled from: CharMatcher.java */
    /* loaded from: classes.dex */
    static abstract class a extends d {
        a() {
        }

        @Override // com.google.common.base.d, com.google.common.base.r
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return d.super.apply(ch2);
        }

        @Override // com.google.common.base.d
        /* renamed from: h */
        public d negate() {
            return new f(this);
        }
    }

    /* compiled from: CharMatcher.java */
    /* loaded from: classes.dex */
    private static final class b extends a {

        /* renamed from: a  reason: collision with root package name */
        private final char f11698a;

        /* renamed from: b  reason: collision with root package name */
        private final char f11699b;

        b(char c10, char c11) {
            p.d(c11 >= c10);
            this.f11698a = c10;
            this.f11699b = c11;
        }

        @Override // com.google.common.base.d
        public boolean g(char c10) {
            return this.f11698a <= c10 && c10 <= this.f11699b;
        }

        @Override // com.google.common.base.d
        public String toString() {
            String i10 = d.i(this.f11698a);
            String i11 = d.i(this.f11699b);
            StringBuilder sb2 = new StringBuilder(String.valueOf(i10).length() + 27 + String.valueOf(i11).length());
            sb2.append("CharMatcher.inRange('");
            sb2.append(i10);
            sb2.append("', '");
            sb2.append(i11);
            sb2.append("')");
            return sb2.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CharMatcher.java */
    /* loaded from: classes.dex */
    public static final class c extends a {

        /* renamed from: a  reason: collision with root package name */
        private final char f11700a;

        c(char c10) {
            this.f11700a = c10;
        }

        @Override // com.google.common.base.d
        public boolean g(char c10) {
            return c10 == this.f11700a;
        }

        @Override // com.google.common.base.d.a, com.google.common.base.d
        /* renamed from: h */
        public d negate() {
            return d.f(this.f11700a);
        }

        @Override // com.google.common.base.d
        public String toString() {
            String i10 = d.i(this.f11700a);
            StringBuilder sb2 = new StringBuilder(String.valueOf(i10).length() + 18);
            sb2.append("CharMatcher.is('");
            sb2.append(i10);
            sb2.append("')");
            return sb2.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CharMatcher.java */
    /* renamed from: com.google.common.base.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0138d extends a {

        /* renamed from: a  reason: collision with root package name */
        private final char f11701a;

        C0138d(char c10) {
            this.f11701a = c10;
        }

        @Override // com.google.common.base.d
        public boolean g(char c10) {
            return c10 != this.f11701a;
        }

        @Override // com.google.common.base.d.a, com.google.common.base.d
        /* renamed from: h */
        public d negate() {
            return d.e(this.f11701a);
        }

        @Override // com.google.common.base.d
        public String toString() {
            String i10 = d.i(this.f11701a);
            StringBuilder sb2 = new StringBuilder(String.valueOf(i10).length() + 21);
            sb2.append("CharMatcher.isNot('");
            sb2.append(i10);
            sb2.append("')");
            return sb2.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CharMatcher.java */
    /* loaded from: classes.dex */
    public static class e extends d {

        /* renamed from: a  reason: collision with root package name */
        final d f11702a;

        e(d dVar) {
            this.f11702a = (d) p.o(dVar);
        }

        @Override // com.google.common.base.d, com.google.common.base.r
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return d.super.apply(ch2);
        }

        @Override // com.google.common.base.d
        public boolean g(char c10) {
            return !this.f11702a.g(c10);
        }

        @Override // com.google.common.base.d
        /* renamed from: h */
        public d negate() {
            return this.f11702a;
        }

        @Override // com.google.common.base.d
        public String toString() {
            String valueOf = String.valueOf(this.f11702a);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 9);
            sb2.append(valueOf);
            sb2.append(".negate()");
            return sb2.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CharMatcher.java */
    /* loaded from: classes.dex */
    public static class f extends e {
        f(d dVar) {
            super(dVar);
        }
    }

    protected d() {
    }

    public static d c(char c10, char c11) {
        return new b(c10, c11);
    }

    public static d e(char c10) {
        return new c(c10);
    }

    public static d f(char c10) {
        return new C0138d(c10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String i(char c10) {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i10 = 0; i10 < 4; i10++) {
            cArr[5 - i10] = "0123456789ABCDEF".charAt(c10 & 15);
            c10 = (char) (c10 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    @Deprecated
    /* renamed from: b */
    public boolean apply(Character ch2) {
        return g(ch2.charValue());
    }

    public int d(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        p.r(i10, length);
        while (i10 < length) {
            if (g(charSequence.charAt(i10))) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public abstract boolean g(char c10);

    /* renamed from: h */
    public d negate() {
        return new e(this);
    }

    @Override // com.google.common.base.r, java.util.function.Predicate
    public /* synthetic */ boolean test(Object obj) {
        return q.a(this, obj);
    }

    public String toString() {
        return super.toString();
    }
}
