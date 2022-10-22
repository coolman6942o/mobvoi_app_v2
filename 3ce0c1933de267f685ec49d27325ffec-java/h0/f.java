package h0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import j0.h;
/* compiled from: FontsContractCompat.java */
/* loaded from: classes.dex */
public class f {

    /* compiled from: FontsContractCompat.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f27667a;

        /* renamed from: b  reason: collision with root package name */
        private final b[] f27668b;

        @Deprecated
        public a(int i10, b[] bVarArr) {
            this.f27667a = i10;
            this.f27668b = bVarArr;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static a a(int i10, b[] bVarArr) {
            return new a(i10, bVarArr);
        }

        public b[] b() {
            return this.f27668b;
        }

        public int c() {
            return this.f27667a;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f27669a;

        /* renamed from: b  reason: collision with root package name */
        private final int f27670b;

        /* renamed from: c  reason: collision with root package name */
        private final int f27671c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f27672d;

        /* renamed from: e  reason: collision with root package name */
        private final int f27673e;

        @Deprecated
        public b(Uri uri, int i10, int i11, boolean z10, int i12) {
            this.f27669a = (Uri) h.g(uri);
            this.f27670b = i10;
            this.f27671c = i11;
            this.f27672d = z10;
            this.f27673e = i12;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static b a(Uri uri, int i10, int i11, boolean z10, int i12) {
            return new b(uri, i10, i11, z10, i12);
        }

        public int b() {
            return this.f27673e;
        }

        public int c() {
            return this.f27670b;
        }

        public Uri d() {
            return this.f27669a;
        }

        public int e() {
            return this.f27671c;
        }

        public boolean f() {
            return this.f27672d;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* loaded from: classes.dex */
    public static class c {
        public void a(int i10) {
            throw null;
        }

        public void b(Typeface typeface) {
            throw null;
        }
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b[] bVarArr) {
        return androidx.core.graphics.a.b(context, cancellationSignal, bVarArr, 0);
    }

    public static a b(Context context, CancellationSignal cancellationSignal, d dVar) throws PackageManager.NameNotFoundException {
        return h0.c.d(context, dVar, cancellationSignal);
    }

    public static Typeface c(Context context, d dVar, int i10, boolean z10, int i11, Handler handler, c cVar) {
        h0.a aVar = new h0.a(cVar, handler);
        if (z10) {
            return e.e(context, dVar, aVar, i10, i11);
        }
        return e.d(context, dVar, i10, null, aVar);
    }
}
