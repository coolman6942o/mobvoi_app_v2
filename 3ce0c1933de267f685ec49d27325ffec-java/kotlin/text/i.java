package kotlin.text;

import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.collections.m;
import kotlin.collections.u;
import kotlin.jvm.internal.Lambda;
import qo.l;
import vo.c;
import xo.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Regex.kt */
/* loaded from: classes3.dex */
public final class i implements h {

    /* renamed from: a  reason: collision with root package name */
    private final Matcher f30108a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f30109b;

    /* compiled from: Regex.kt */
    /* loaded from: classes3.dex */
    public static final class a extends kotlin.collections.a<g> {

        /* compiled from: Regex.kt */
        /* renamed from: kotlin.text.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static final class C0373a extends Lambda implements l<Integer, g> {
            C0373a() {
                super(1);
            }

            public final g a(int i10) {
                return a.this.d(i10);
            }

            @Override // qo.l
            public /* bridge */ /* synthetic */ g invoke(Integer num) {
                return a(num.intValue());
            }
        }

        a() {
        }

        @Override // kotlin.collections.a
        public int a() {
            return i.this.c().groupCount() + 1;
        }

        public /* bridge */ boolean b(g gVar) {
            return super.contains(gVar);
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj != null ? obj instanceof g : true) {
                return b((g) obj);
            }
            return false;
        }

        public g d(int i10) {
            c i11;
            i11 = j.i(i.this.c(), i10);
            if (i11.h().intValue() < 0) {
                return null;
            }
            String group = i.this.c().group(i10);
            kotlin.jvm.internal.i.e(group, "matchResult.group(index)");
            return new g(group, i11);
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<g> iterator() {
            c h10;
            e B;
            e k10;
            h10 = m.h(this);
            B = u.B(h10);
            k10 = xo.m.k(B, new C0373a());
            return k10.iterator();
        }
    }

    public i(Matcher matcher, CharSequence input) {
        kotlin.jvm.internal.i.f(matcher, "matcher");
        kotlin.jvm.internal.i.f(input, "input");
        this.f30108a = matcher;
        this.f30109b = input;
        new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MatchResult c() {
        return this.f30108a;
    }

    @Override // kotlin.text.h
    public c a() {
        c h10;
        h10 = j.h(c());
        return h10;
    }

    @Override // kotlin.text.h
    public h next() {
        h f10;
        int end = c().end() + (c().end() == c().start() ? 1 : 0);
        if (end > this.f30109b.length()) {
            return null;
        }
        Matcher matcher = this.f30108a.pattern().matcher(this.f30109b);
        kotlin.jvm.internal.i.e(matcher, "matcher.pattern().matcher(input)");
        f10 = j.f(matcher, end, this.f30109b);
        return f10;
    }
}
