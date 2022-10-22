package com.google.common.base;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
/* compiled from: Joiner.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private final String f11705a;

    /* compiled from: Joiner.java */
    /* loaded from: classes.dex */
    class a extends k {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f11706b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(k kVar, String str) {
            super(kVar, null);
            this.f11706b = str;
        }

        @Override // com.google.common.base.k
        CharSequence h(Object obj) {
            return obj == null ? this.f11706b : k.this.h(obj);
        }

        @Override // com.google.common.base.k
        public k i(String str) {
            throw new UnsupportedOperationException("already specified useForNull");
        }
    }

    /* synthetic */ k(k kVar, a aVar) {
        this(kVar);
    }

    public static k f(char c10) {
        return new k(String.valueOf(c10));
    }

    public static k g(String str) {
        return new k(str);
    }

    public <A extends Appendable> A a(A a10, Iterator<?> it) throws IOException {
        p.o(a10);
        if (it.hasNext()) {
            a10.append(h(it.next()));
            while (it.hasNext()) {
                a10.append(this.f11705a);
                a10.append(h(it.next()));
            }
        }
        return a10;
    }

    public final StringBuilder b(StringBuilder sb2, Iterator<?> it) {
        try {
            a(sb2, it);
            return sb2;
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }

    public final String c(Iterable<?> iterable) {
        return d(iterable.iterator());
    }

    public final String d(Iterator<?> it) {
        return b(new StringBuilder(), it).toString();
    }

    public final String e(Object[] objArr) {
        return c(Arrays.asList(objArr));
    }

    CharSequence h(Object obj) {
        p.o(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public k i(String str) {
        p.o(str);
        return new a(this, str);
    }

    private k(String str) {
        this.f11705a = (String) p.o(str);
    }

    private k(k kVar) {
        this.f11705a = kVar.f11705a;
    }
}
