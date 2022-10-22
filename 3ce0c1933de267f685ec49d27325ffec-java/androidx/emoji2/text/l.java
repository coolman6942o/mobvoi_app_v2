package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import g0.j;
import j0.h;
import java.io.IOException;
import java.nio.ByteBuffer;
import t0.b;
/* compiled from: MetadataRepo.java */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    private final b f2857a;

    /* renamed from: b  reason: collision with root package name */
    private final char[] f2858b;

    /* renamed from: c  reason: collision with root package name */
    private final a f2859c = new a(1024);

    /* renamed from: d  reason: collision with root package name */
    private final Typeface f2860d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MetadataRepo.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final SparseArray<a> f2861a;

        /* renamed from: b  reason: collision with root package name */
        private f f2862b;

        private a() {
            this(1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(int i10) {
            SparseArray<a> sparseArray = this.f2861a;
            if (sparseArray == null) {
                return null;
            }
            return sparseArray.get(i10);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final f b() {
            return this.f2862b;
        }

        void c(f fVar, int i10, int i11) {
            a a10 = a(fVar.b(i10));
            if (a10 == null) {
                a10 = new a();
                this.f2861a.put(fVar.b(i10), a10);
            }
            if (i11 > i10) {
                a10.c(fVar, i10 + 1, i11);
            } else {
                a10.f2862b = fVar;
            }
        }

        a(int i10) {
            this.f2861a = new SparseArray<>(i10);
        }
    }

    private l(Typeface typeface, b bVar) {
        this.f2860d = typeface;
        this.f2857a = bVar;
        this.f2858b = new char[bVar.k() * 2];
        a(bVar);
    }

    private void a(b bVar) {
        int k10 = bVar.k();
        for (int i10 = 0; i10 < k10; i10++) {
            f fVar = new f(this, i10);
            Character.toChars(fVar.f(), this.f2858b, i10 * 2);
            h(fVar);
        }
    }

    public static l b(Typeface typeface, ByteBuffer byteBuffer) throws IOException {
        try {
            j.a("EmojiCompat.MetadataRepo.create");
            return new l(typeface, k.b(byteBuffer));
        } finally {
            j.b();
        }
    }

    public char[] c() {
        return this.f2858b;
    }

    public b d() {
        return this.f2857a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f2857a.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a f() {
        return this.f2859c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Typeface g() {
        return this.f2860d;
    }

    void h(f fVar) {
        h.h(fVar, "emoji metadata cannot be null");
        h.b(fVar.c() > 0, "invalid metadata codepoint length");
        this.f2859c.c(fVar, 0, fVar.c() - 1);
    }
}
