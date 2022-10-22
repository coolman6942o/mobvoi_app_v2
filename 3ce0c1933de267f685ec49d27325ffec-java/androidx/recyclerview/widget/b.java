package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChildHelper.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    final AbstractC0041b f3926a;

    /* renamed from: b  reason: collision with root package name */
    final a f3927b = new a();

    /* renamed from: c  reason: collision with root package name */
    final List<View> f3928c = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChildHelper.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        long f3929a = 0;

        /* renamed from: b  reason: collision with root package name */
        a f3930b;

        a() {
        }

        private void c() {
            if (this.f3930b == null) {
                this.f3930b = new a();
            }
        }

        void a(int i10) {
            if (i10 >= 64) {
                a aVar = this.f3930b;
                if (aVar != null) {
                    aVar.a(i10 - 64);
                    return;
                }
                return;
            }
            this.f3929a &= ~(1 << i10);
        }

        int b(int i10) {
            a aVar = this.f3930b;
            if (aVar == null) {
                if (i10 >= 64) {
                    return Long.bitCount(this.f3929a);
                }
                return Long.bitCount(this.f3929a & ((1 << i10) - 1));
            } else if (i10 < 64) {
                return Long.bitCount(this.f3929a & ((1 << i10) - 1));
            } else {
                return aVar.b(i10 - 64) + Long.bitCount(this.f3929a);
            }
        }

        boolean d(int i10) {
            if (i10 < 64) {
                return (this.f3929a & (1 << i10)) != 0;
            }
            c();
            return this.f3930b.d(i10 - 64);
        }

        void e(int i10, boolean z10) {
            if (i10 >= 64) {
                c();
                this.f3930b.e(i10 - 64, z10);
                return;
            }
            long j10 = this.f3929a;
            boolean z11 = (Long.MIN_VALUE & j10) != 0;
            long j11 = (1 << i10) - 1;
            this.f3929a = ((j10 & (~j11)) << 1) | (j10 & j11);
            if (z10) {
                h(i10);
            } else {
                a(i10);
            }
            if (z11 || this.f3930b != null) {
                c();
                this.f3930b.e(0, z11);
            }
        }

        boolean f(int i10) {
            if (i10 >= 64) {
                c();
                return this.f3930b.f(i10 - 64);
            }
            long j10 = 1 << i10;
            long j11 = this.f3929a;
            boolean z10 = (j11 & j10) != 0;
            long j12 = j11 & (~j10);
            this.f3929a = j12;
            long j13 = j10 - 1;
            this.f3929a = (j12 & j13) | Long.rotateRight((~j13) & j12, 1);
            a aVar = this.f3930b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f3930b.f(0);
            }
            return z10;
        }

        void g() {
            this.f3929a = 0L;
            a aVar = this.f3930b;
            if (aVar != null) {
                aVar.g();
            }
        }

        void h(int i10) {
            if (i10 >= 64) {
                c();
                this.f3930b.h(i10 - 64);
                return;
            }
            this.f3929a |= 1 << i10;
        }

        public String toString() {
            if (this.f3930b == null) {
                return Long.toBinaryString(this.f3929a);
            }
            return this.f3930b.toString() + "xx" + Long.toBinaryString(this.f3929a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChildHelper.java */
    /* renamed from: androidx.recyclerview.widget.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface AbstractC0041b {
        View a(int i10);

        void b(View view);

        int c();

        void d();

        int e(View view);

        RecyclerView.b0 f(View view);

        void g(int i10);

        void h(View view);

        void i(View view, int i10);

        void j(int i10);

        void k(View view, int i10, ViewGroup.LayoutParams layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AbstractC0041b bVar) {
        this.f3926a = bVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
        if (r4.f3927b.d(r2) == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int h(int i10) {
        if (i10 < 0) {
            return -1;
        }
        int c10 = this.f3926a.c();
        int i11 = i10;
        while (i11 < c10) {
            int b10 = i10 - (i11 - this.f3927b.b(i11));
            if (b10 == 0) {
                break;
            }
            i11 += b10;
        }
        return -1;
    }

    private void l(View view) {
        this.f3928c.add(view);
        this.f3926a.b(view);
    }

    private boolean t(View view) {
        if (!this.f3928c.remove(view)) {
            return false;
        }
        this.f3926a.h(view);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, int i10, boolean z10) {
        int i11;
        if (i10 < 0) {
            i11 = this.f3926a.c();
        } else {
            i11 = h(i10);
        }
        this.f3927b.e(i11, z10);
        if (z10) {
            l(view);
        }
        this.f3926a.i(view, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(View view, boolean z10) {
        a(view, -1, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(View view, int i10, ViewGroup.LayoutParams layoutParams, boolean z10) {
        int i11;
        if (i10 < 0) {
            i11 = this.f3926a.c();
        } else {
            i11 = h(i10);
        }
        this.f3927b.e(i11, z10);
        if (z10) {
            l(view);
        }
        this.f3926a.k(view, i11, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i10) {
        int h10 = h(i10);
        this.f3927b.f(h10);
        this.f3926a.g(h10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View e(int i10) {
        int size = this.f3928c.size();
        for (int i11 = 0; i11 < size; i11++) {
            View view = this.f3928c.get(i11);
            RecyclerView.b0 f10 = this.f3926a.f(view);
            if (!(f10.getLayoutPosition() != i10 || f10.isInvalid() || f10.isRemoved())) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View f(int i10) {
        return this.f3926a.a(h(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f3926a.c() - this.f3928c.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View i(int i10) {
        return this.f3926a.a(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.f3926a.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(View view) {
        int e10 = this.f3926a.e(view);
        if (e10 >= 0) {
            this.f3927b.h(e10);
            l(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m(View view) {
        int e10 = this.f3926a.e(view);
        if (e10 != -1 && !this.f3927b.d(e10)) {
            return e10 - this.f3927b.b(e10);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n(View view) {
        return this.f3928c.contains(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        this.f3927b.g();
        for (int size = this.f3928c.size() - 1; size >= 0; size--) {
            this.f3926a.h(this.f3928c.get(size));
            this.f3928c.remove(size);
        }
        this.f3926a.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(View view) {
        int e10 = this.f3926a.e(view);
        if (e10 >= 0) {
            if (this.f3927b.f(e10)) {
                t(view);
            }
            this.f3926a.j(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(int i10) {
        int h10 = h(i10);
        View a10 = this.f3926a.a(h10);
        if (a10 != null) {
            if (this.f3927b.f(h10)) {
                t(a10);
            }
            this.f3926a.j(h10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r(View view) {
        int e10 = this.f3926a.e(view);
        if (e10 == -1) {
            t(view);
            return true;
        } else if (!this.f3927b.d(e10)) {
            return false;
        } else {
            this.f3927b.f(e10);
            t(view);
            this.f3926a.j(e10);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(View view) {
        int e10 = this.f3926a.e(view);
        if (e10 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.f3927b.d(e10)) {
            this.f3927b.a(e10);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f3927b.toString() + ", hidden list:" + this.f3928c.size();
    }
}
