package androidx.recyclerview.widget;

import android.view.View;
/* compiled from: ViewBoundsCheck.java */
/* loaded from: classes.dex */
class s {

    /* renamed from: a  reason: collision with root package name */
    final b f4119a;

    /* renamed from: b  reason: collision with root package name */
    a f4120b = new a();

    /* compiled from: ViewBoundsCheck.java */
    /* loaded from: classes.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        int f4121a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f4122b;

        /* renamed from: c  reason: collision with root package name */
        int f4123c;

        /* renamed from: d  reason: collision with root package name */
        int f4124d;

        /* renamed from: e  reason: collision with root package name */
        int f4125e;

        a() {
        }

        void a(int i10) {
            this.f4121a = i10 | this.f4121a;
        }

        boolean b() {
            int i10 = this.f4121a;
            if ((i10 & 7) != 0 && (i10 & (c(this.f4124d, this.f4122b) << 0)) == 0) {
                return false;
            }
            int i11 = this.f4121a;
            if ((i11 & 112) != 0 && (i11 & (c(this.f4124d, this.f4123c) << 4)) == 0) {
                return false;
            }
            int i12 = this.f4121a;
            if ((i12 & 1792) != 0 && (i12 & (c(this.f4125e, this.f4122b) << 8)) == 0) {
                return false;
            }
            int i13 = this.f4121a;
            return (i13 & 28672) == 0 || (i13 & (c(this.f4125e, this.f4123c) << 12)) != 0;
        }

        int c(int i10, int i11) {
            if (i10 > i11) {
                return 1;
            }
            return i10 == i11 ? 2 : 4;
        }

        void d() {
            this.f4121a = 0;
        }

        void e(int i10, int i11, int i12, int i13) {
            this.f4122b = i10;
            this.f4123c = i11;
            this.f4124d = i12;
            this.f4125e = i13;
        }
    }

    /* compiled from: ViewBoundsCheck.java */
    /* loaded from: classes.dex */
    interface b {
        View a(int i10);

        int b(View view);

        int c();

        int d();

        int e(View view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(b bVar) {
        this.f4119a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View a(int i10, int i11, int i12, int i13) {
        int c10 = this.f4119a.c();
        int d10 = this.f4119a.d();
        int i14 = i11 > i10 ? 1 : -1;
        View view = null;
        while (i10 != i11) {
            View a10 = this.f4119a.a(i10);
            this.f4120b.e(c10, d10, this.f4119a.b(a10), this.f4119a.e(a10));
            if (i12 != 0) {
                this.f4120b.d();
                this.f4120b.a(i12);
                if (this.f4120b.b()) {
                    return a10;
                }
            }
            if (i13 != 0) {
                this.f4120b.d();
                this.f4120b.a(i13);
                if (this.f4120b.b()) {
                    view = a10;
                }
            }
            i10 += i14;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(View view, int i10) {
        this.f4120b.e(this.f4119a.c(), this.f4119a.d(), this.f4119a.b(view), this.f4119a.e(view));
        if (i10 == 0) {
            return false;
        }
        this.f4120b.d();
        this.f4120b.a(i10);
        return this.f4120b.b();
    }
}
