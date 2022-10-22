package com.google.common.base;

import java.util.Arrays;
import java.util.Objects;
/* compiled from: MoreObjects.java */
/* loaded from: classes.dex */
public final class l {

    /* compiled from: MoreObjects.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final String f11708a;

        /* renamed from: b  reason: collision with root package name */
        private final a f11709b;

        /* renamed from: c  reason: collision with root package name */
        private a f11710c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f11711d;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: MoreObjects.java */
        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            String f11712a;

            /* renamed from: b  reason: collision with root package name */
            Object f11713b;

            /* renamed from: c  reason: collision with root package name */
            a f11714c;

            private a() {
            }
        }

        private a e() {
            a aVar = new a();
            this.f11710c.f11714c = aVar;
            this.f11710c = aVar;
            return aVar;
        }

        private b f(Object obj) {
            e().f11713b = obj;
            return this;
        }

        private b g(String str, Object obj) {
            a e10 = e();
            e10.f11713b = obj;
            e10.f11712a = (String) p.o(str);
            return this;
        }

        public b a(String str, double d10) {
            return g(str, String.valueOf(d10));
        }

        public b b(String str, int i10) {
            return g(str, String.valueOf(i10));
        }

        public b c(String str, long j10) {
            return g(str, String.valueOf(j10));
        }

        public b d(String str, Object obj) {
            return g(str, obj);
        }

        public b h(Object obj) {
            return f(obj);
        }

        public String toString() {
            boolean z10 = this.f11711d;
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append(this.f11708a);
            sb2.append('{');
            String str = "";
            for (a aVar = this.f11709b.f11714c; aVar != null; aVar = aVar.f11714c) {
                Object obj = aVar.f11713b;
                if (!z10 || obj != null) {
                    sb2.append(str);
                    String str2 = aVar.f11712a;
                    if (str2 != null) {
                        sb2.append(str2);
                        sb2.append('=');
                    }
                    if (obj == null || !obj.getClass().isArray()) {
                        sb2.append(obj);
                    } else {
                        String deepToString = Arrays.deepToString(new Object[]{obj});
                        sb2.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                    }
                    str = ", ";
                }
            }
            sb2.append('}');
            return sb2.toString();
        }

        private b(String str) {
            a aVar = new a();
            this.f11709b = aVar;
            this.f11710c = aVar;
            this.f11711d = false;
            this.f11708a = (String) p.o(str);
        }
    }

    public static <T> T a(T t10, T t11) {
        if (t10 != null) {
            return t10;
        }
        Objects.requireNonNull(t11, "Both parameters are null");
        return t11;
    }

    public static b b(Object obj) {
        return new b(obj.getClass().getSimpleName());
    }
}
