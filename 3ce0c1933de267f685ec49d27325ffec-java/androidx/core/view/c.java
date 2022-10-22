package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContentInfo;
import com.mobvoi.wear.util.TelephonyUtil;
import j0.h;
/* compiled from: ContentInfoCompat.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final f f2484a;

    /* compiled from: ContentInfoCompat.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final AbstractC0022c f2485a;

        public a(ClipData clipData, int i10) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.f2485a = new b(clipData, i10);
            } else {
                this.f2485a = new d(clipData, i10);
            }
        }

        public c a() {
            return this.f2485a.build();
        }

        public a b(Bundle bundle) {
            this.f2485a.setExtras(bundle);
            return this;
        }

        public a c(int i10) {
            this.f2485a.b(i10);
            return this;
        }

        public a d(Uri uri) {
            this.f2485a.a(uri);
            return this;
        }
    }

    /* compiled from: ContentInfoCompat.java */
    /* loaded from: classes.dex */
    private static final class b implements AbstractC0022c {

        /* renamed from: a  reason: collision with root package name */
        private final ContentInfo.Builder f2486a;

        b(ClipData clipData, int i10) {
            this.f2486a = new ContentInfo.Builder(clipData, i10);
        }

        @Override // androidx.core.view.c.AbstractC0022c
        public void a(Uri uri) {
            this.f2486a.setLinkUri(uri);
        }

        @Override // androidx.core.view.c.AbstractC0022c
        public void b(int i10) {
            this.f2486a.setFlags(i10);
        }

        @Override // androidx.core.view.c.AbstractC0022c
        public c build() {
            return new c(new e(this.f2486a.build()));
        }

        @Override // androidx.core.view.c.AbstractC0022c
        public void setExtras(Bundle bundle) {
            this.f2486a.setExtras(bundle);
        }
    }

    /* compiled from: ContentInfoCompat.java */
    /* renamed from: androidx.core.view.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private interface AbstractC0022c {
        void a(Uri uri);

        void b(int i10);

        c build();

        void setExtras(Bundle bundle);
    }

    /* compiled from: ContentInfoCompat.java */
    /* loaded from: classes.dex */
    private static final class d implements AbstractC0022c {

        /* renamed from: a  reason: collision with root package name */
        ClipData f2487a;

        /* renamed from: b  reason: collision with root package name */
        int f2488b;

        /* renamed from: c  reason: collision with root package name */
        int f2489c;

        /* renamed from: d  reason: collision with root package name */
        Uri f2490d;

        /* renamed from: e  reason: collision with root package name */
        Bundle f2491e;

        d(ClipData clipData, int i10) {
            this.f2487a = clipData;
            this.f2488b = i10;
        }

        @Override // androidx.core.view.c.AbstractC0022c
        public void a(Uri uri) {
            this.f2490d = uri;
        }

        @Override // androidx.core.view.c.AbstractC0022c
        public void b(int i10) {
            this.f2489c = i10;
        }

        @Override // androidx.core.view.c.AbstractC0022c
        public c build() {
            return new c(new g(this));
        }

        @Override // androidx.core.view.c.AbstractC0022c
        public void setExtras(Bundle bundle) {
            this.f2491e = bundle;
        }
    }

    /* compiled from: ContentInfoCompat.java */
    /* loaded from: classes.dex */
    private static final class e implements f {

        /* renamed from: a  reason: collision with root package name */
        private final ContentInfo f2492a;

        e(ContentInfo contentInfo) {
            this.f2492a = (ContentInfo) h.g(contentInfo);
        }

        @Override // androidx.core.view.c.f
        public ClipData a() {
            return this.f2492a.getClip();
        }

        @Override // androidx.core.view.c.f
        public int b() {
            return this.f2492a.getFlags();
        }

        @Override // androidx.core.view.c.f
        public ContentInfo c() {
            return this.f2492a;
        }

        @Override // androidx.core.view.c.f
        public int getSource() {
            return this.f2492a.getSource();
        }

        public String toString() {
            return "ContentInfoCompat{" + this.f2492a + "}";
        }
    }

    /* compiled from: ContentInfoCompat.java */
    /* loaded from: classes.dex */
    private interface f {
        ClipData a();

        int b();

        ContentInfo c();

        int getSource();
    }

    /* compiled from: ContentInfoCompat.java */
    /* loaded from: classes.dex */
    private static final class g implements f {

        /* renamed from: a  reason: collision with root package name */
        private final ClipData f2493a;

        /* renamed from: b  reason: collision with root package name */
        private final int f2494b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2495c;

        /* renamed from: d  reason: collision with root package name */
        private final Uri f2496d;

        /* renamed from: e  reason: collision with root package name */
        private final Bundle f2497e;

        g(d dVar) {
            this.f2493a = (ClipData) h.g(dVar.f2487a);
            this.f2494b = h.c(dVar.f2488b, 0, 5, TelephonyUtil.KEY_SIM_ACTIVITIED_SOURCE);
            this.f2495c = h.f(dVar.f2489c, 1);
            this.f2496d = dVar.f2490d;
            this.f2497e = dVar.f2491e;
        }

        @Override // androidx.core.view.c.f
        public ClipData a() {
            return this.f2493a;
        }

        @Override // androidx.core.view.c.f
        public int b() {
            return this.f2495c;
        }

        @Override // androidx.core.view.c.f
        public ContentInfo c() {
            return null;
        }

        @Override // androidx.core.view.c.f
        public int getSource() {
            return this.f2494b;
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ContentInfoCompat{clip=");
            sb2.append(this.f2493a.getDescription());
            sb2.append(", source=");
            sb2.append(c.e(this.f2494b));
            sb2.append(", flags=");
            sb2.append(c.a(this.f2495c));
            String str2 = "";
            if (this.f2496d == null) {
                str = str2;
            } else {
                str = ", hasLinkUri(" + this.f2496d.toString().length() + ")";
            }
            sb2.append(str);
            if (this.f2497e != null) {
                str2 = ", hasExtras";
            }
            sb2.append(str2);
            sb2.append("}");
            return sb2.toString();
        }
    }

    c(f fVar) {
        this.f2484a = fVar;
    }

    static String a(int i10) {
        return (i10 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i10);
    }

    static String e(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 5 ? String.valueOf(i10) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP";
    }

    public static c g(ContentInfo contentInfo) {
        return new c(new e(contentInfo));
    }

    public ClipData b() {
        return this.f2484a.a();
    }

    public int c() {
        return this.f2484a.b();
    }

    public int d() {
        return this.f2484a.getSource();
    }

    public ContentInfo f() {
        return this.f2484a.c();
    }

    public String toString() {
        return this.f2484a.toString();
    }
}
