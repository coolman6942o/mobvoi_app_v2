package m0;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;
/* compiled from: InputContentInfoCompat.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final AbstractC0395c f30594a;

    /* compiled from: InputContentInfoCompat.java */
    /* loaded from: classes.dex */
    private static final class b implements AbstractC0395c {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f30596a;

        /* renamed from: b  reason: collision with root package name */
        private final ClipDescription f30597b;

        /* renamed from: c  reason: collision with root package name */
        private final Uri f30598c;

        b(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f30596a = uri;
            this.f30597b = clipDescription;
            this.f30598c = uri2;
        }

        @Override // m0.c.AbstractC0395c
        public Uri a() {
            return this.f30596a;
        }

        @Override // m0.c.AbstractC0395c
        public void b() {
        }

        @Override // m0.c.AbstractC0395c
        public Uri c() {
            return this.f30598c;
        }

        @Override // m0.c.AbstractC0395c
        public ClipDescription d() {
            return this.f30597b;
        }

        @Override // m0.c.AbstractC0395c
        public Object e() {
            return null;
        }
    }

    /* compiled from: InputContentInfoCompat.java */
    /* renamed from: m0.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private interface AbstractC0395c {
        Uri a();

        void b();

        Uri c();

        ClipDescription d();

        Object e();
    }

    public c(Uri uri, ClipDescription clipDescription, Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.f30594a = new a(uri, clipDescription, uri2);
        } else {
            this.f30594a = new b(uri, clipDescription, uri2);
        }
    }

    public static c f(Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 25) {
            return new c(new a(obj));
        }
        return null;
    }

    public Uri a() {
        return this.f30594a.a();
    }

    public ClipDescription b() {
        return this.f30594a.d();
    }

    public Uri c() {
        return this.f30594a.c();
    }

    public void d() {
        this.f30594a.b();
    }

    public Object e() {
        return this.f30594a.e();
    }

    /* compiled from: InputContentInfoCompat.java */
    /* loaded from: classes.dex */
    private static final class a implements AbstractC0395c {

        /* renamed from: a  reason: collision with root package name */
        final InputContentInfo f30595a;

        a(Object obj) {
            this.f30595a = (InputContentInfo) obj;
        }

        @Override // m0.c.AbstractC0395c
        public Uri a() {
            return this.f30595a.getContentUri();
        }

        @Override // m0.c.AbstractC0395c
        public void b() {
            this.f30595a.requestPermission();
        }

        @Override // m0.c.AbstractC0395c
        public Uri c() {
            return this.f30595a.getLinkUri();
        }

        @Override // m0.c.AbstractC0395c
        public ClipDescription d() {
            return this.f30595a.getDescription();
        }

        @Override // m0.c.AbstractC0395c
        public Object e() {
            return this.f30595a;
        }

        a(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f30595a = new InputContentInfo(uri, clipDescription, uri2);
        }
    }

    private c(AbstractC0395c cVar) {
        this.f30594a = cVar;
    }
}
