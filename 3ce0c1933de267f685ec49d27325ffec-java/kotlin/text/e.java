package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.Pair;
import kotlin.jvm.internal.i;
import qo.p;
import vo.c;
import vo.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Strings.kt */
/* loaded from: classes3.dex */
public final class e implements xo.e<c> {

    /* renamed from: a  reason: collision with root package name */
    private final CharSequence f30096a;

    /* renamed from: b  reason: collision with root package name */
    private final int f30097b;

    /* renamed from: c  reason: collision with root package name */
    private final int f30098c;

    /* renamed from: d  reason: collision with root package name */
    private final p<CharSequence, Integer, Pair<Integer, Integer>> f30099d;

    /* compiled from: Strings.kt */
    /* loaded from: classes3.dex */
    public static final class a implements Iterator<c>, ro.a {

        /* renamed from: a  reason: collision with root package name */
        private int f30100a = -1;

        /* renamed from: b  reason: collision with root package name */
        private int f30101b;

        /* renamed from: c  reason: collision with root package name */
        private int f30102c;

        /* renamed from: d  reason: collision with root package name */
        private c f30103d;

        /* renamed from: e  reason: collision with root package name */
        private int f30104e;

        a() {
            int h10;
            h10 = f.h(e.this.f30097b, 0, e.this.f30096a.length());
            this.f30101b = h10;
            this.f30102c = h10;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0021, code lost:
            if (r0 < r6.f30105f.f30098c) goto L9;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void a() {
            c k10;
            int i10 = 0;
            if (this.f30102c < 0) {
                this.f30100a = 0;
                this.f30103d = null;
                return;
            }
            if (e.this.f30098c > 0) {
                int i11 = this.f30104e + 1;
                this.f30104e = i11;
            }
            if (this.f30102c <= e.this.f30096a.length()) {
                Pair pair = (Pair) e.this.f30099d.invoke(e.this.f30096a, Integer.valueOf(this.f30102c));
                if (pair == null) {
                    this.f30103d = new c(this.f30101b, u.N(e.this.f30096a));
                    this.f30102c = -1;
                } else {
                    int intValue = ((Number) pair.component1()).intValue();
                    int intValue2 = ((Number) pair.component2()).intValue();
                    k10 = f.k(this.f30101b, intValue);
                    this.f30103d = k10;
                    int i12 = intValue + intValue2;
                    this.f30101b = i12;
                    if (intValue2 == 0) {
                        i10 = 1;
                    }
                    this.f30102c = i12 + i10;
                }
                this.f30100a = 1;
            }
            this.f30103d = new c(this.f30101b, u.N(e.this.f30096a));
            this.f30102c = -1;
            this.f30100a = 1;
        }

        /* renamed from: b */
        public c next() {
            if (this.f30100a == -1) {
                a();
            }
            if (this.f30100a != 0) {
                c cVar = this.f30103d;
                Objects.requireNonNull(cVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
                this.f30103d = null;
                this.f30100a = -1;
                return cVar;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f30100a == -1) {
                a();
            }
            return this.f30100a == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(CharSequence input, int i10, int i11, p<? super CharSequence, ? super Integer, Pair<Integer, Integer>> getNextMatch) {
        i.f(input, "input");
        i.f(getNextMatch, "getNextMatch");
        this.f30096a = input;
        this.f30097b = i10;
        this.f30098c = i11;
        this.f30099d = getNextMatch;
    }

    @Override // xo.e
    public Iterator<c> iterator() {
        return new a();
    }
}
