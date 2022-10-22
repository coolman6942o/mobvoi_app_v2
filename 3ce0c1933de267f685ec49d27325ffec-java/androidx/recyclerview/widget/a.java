package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.l;
import j0.e;
import j0.f;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdapterHelper.java */
/* loaded from: classes.dex */
public final class a implements l.a {

    /* renamed from: a  reason: collision with root package name */
    private e<b> f3914a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<b> f3915b;

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<b> f3916c;

    /* renamed from: d  reason: collision with root package name */
    final AbstractC0040a f3917d;

    /* renamed from: e  reason: collision with root package name */
    Runnable f3918e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f3919f;

    /* renamed from: g  reason: collision with root package name */
    final l f3920g;

    /* renamed from: h  reason: collision with root package name */
    private int f3921h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdapterHelper.java */
    /* renamed from: androidx.recyclerview.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface AbstractC0040a {
        void a(int i10, int i11);

        void b(b bVar);

        void c(int i10, int i11, Object obj);

        void d(b bVar);

        RecyclerView.b0 e(int i10);

        void f(int i10, int i11);

        void g(int i10, int i11);

        void h(int i10, int i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdapterHelper.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        int f3922a;

        /* renamed from: b  reason: collision with root package name */
        int f3923b;

        /* renamed from: c  reason: collision with root package name */
        Object f3924c;

        /* renamed from: d  reason: collision with root package name */
        int f3925d;

        b(int i10, int i11, int i12, Object obj) {
            this.f3922a = i10;
            this.f3923b = i11;
            this.f3925d = i12;
            this.f3924c = obj;
        }

        String a() {
            int i10 = this.f3922a;
            return i10 != 1 ? i10 != 2 ? i10 != 4 ? i10 != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            int i10 = this.f3922a;
            if (i10 != bVar.f3922a) {
                return false;
            }
            if (i10 == 8 && Math.abs(this.f3925d - this.f3923b) == 1 && this.f3925d == bVar.f3923b && this.f3923b == bVar.f3925d) {
                return true;
            }
            if (this.f3925d != bVar.f3925d || this.f3923b != bVar.f3923b) {
                return false;
            }
            Object obj2 = this.f3924c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f3924c)) {
                    return false;
                }
            } else if (bVar.f3924c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f3922a * 31) + this.f3923b) * 31) + this.f3925d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f3923b + "c:" + this.f3925d + ",p:" + this.f3924c + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbstractC0040a aVar) {
        this(aVar, false);
    }

    private void c(b bVar) {
        v(bVar);
    }

    private void d(b bVar) {
        v(bVar);
    }

    private void f(b bVar) {
        char c10;
        boolean z10;
        int i10 = bVar.f3923b;
        int i11 = bVar.f3925d + i10;
        char c11 = 65535;
        int i12 = i10;
        int i13 = 0;
        while (i12 < i11) {
            if (this.f3917d.e(i12) != null || h(i12)) {
                if (c11 == 0) {
                    k(b(2, i10, i13, null));
                    z10 = true;
                } else {
                    z10 = false;
                }
                c10 = 1;
            } else {
                if (c11 == 1) {
                    v(b(2, i10, i13, null));
                    z10 = true;
                } else {
                    z10 = false;
                }
                c10 = 0;
            }
            if (z10) {
                i12 -= i13;
                i11 -= i13;
                i13 = 1;
            } else {
                i13++;
            }
            i12++;
            c11 = c10;
        }
        if (i13 != bVar.f3925d) {
            a(bVar);
            bVar = b(2, i10, i13, null);
        }
        if (c11 == 0) {
            k(bVar);
        } else {
            v(bVar);
        }
    }

    private void g(b bVar) {
        int i10 = bVar.f3923b;
        int i11 = bVar.f3925d + i10;
        char c10 = 65535;
        int i12 = 0;
        int i13 = i10;
        while (i10 < i11) {
            if (this.f3917d.e(i10) != null || h(i10)) {
                if (c10 == 0) {
                    k(b(4, i13, i12, bVar.f3924c));
                    i13 = i10;
                    i12 = 0;
                }
                c10 = 1;
            } else {
                if (c10 == 1) {
                    v(b(4, i13, i12, bVar.f3924c));
                    i13 = i10;
                    i12 = 0;
                }
                c10 = 0;
            }
            i12++;
            i10++;
        }
        if (i12 != bVar.f3925d) {
            Object obj = bVar.f3924c;
            a(bVar);
            bVar = b(4, i13, i12, obj);
        }
        if (c10 == 0) {
            k(bVar);
        } else {
            v(bVar);
        }
    }

    private boolean h(int i10) {
        int size = this.f3916c.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = this.f3916c.get(i11);
            int i12 = bVar.f3922a;
            if (i12 == 8) {
                if (n(bVar.f3925d, i11 + 1) == i10) {
                    return true;
                }
            } else if (i12 == 1) {
                int i13 = bVar.f3923b;
                int i14 = bVar.f3925d + i13;
                while (i13 < i14) {
                    if (n(i13, i11 + 1) == i10) {
                        return true;
                    }
                    i13++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void k(b bVar) {
        int i10;
        int i11 = bVar.f3922a;
        if (i11 == 1 || i11 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int z10 = z(bVar.f3923b, i11);
        int i12 = bVar.f3923b;
        int i13 = bVar.f3922a;
        if (i13 == 2) {
            i10 = 0;
        } else if (i13 == 4) {
            i10 = 1;
        } else {
            throw new IllegalArgumentException("op should be remove or update." + bVar);
        }
        int i14 = 1;
        for (int i15 = 1; i15 < bVar.f3925d; i15++) {
            int z11 = z(bVar.f3923b + (i10 * i15), bVar.f3922a);
            int i16 = bVar.f3922a;
            if (i16 == 2 ? z11 == z10 : i16 == 4 && z11 == z10 + 1) {
                i14++;
            } else {
                b b10 = b(i16, z10, i14, bVar.f3924c);
                l(b10, i12);
                a(b10);
                if (bVar.f3922a == 4) {
                    i12 += i14;
                }
                i14 = 1;
                z10 = z11;
            }
        }
        Object obj = bVar.f3924c;
        a(bVar);
        if (i14 > 0) {
            b b11 = b(bVar.f3922a, z10, i14, obj);
            l(b11, i12);
            a(b11);
        }
    }

    private void v(b bVar) {
        this.f3916c.add(bVar);
        int i10 = bVar.f3922a;
        if (i10 == 1) {
            this.f3917d.g(bVar.f3923b, bVar.f3925d);
        } else if (i10 == 2) {
            this.f3917d.f(bVar.f3923b, bVar.f3925d);
        } else if (i10 == 4) {
            this.f3917d.c(bVar.f3923b, bVar.f3925d, bVar.f3924c);
        } else if (i10 == 8) {
            this.f3917d.a(bVar.f3923b, bVar.f3925d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    private int z(int i10, int i11) {
        int i12;
        int i13;
        for (int size = this.f3916c.size() - 1; size >= 0; size--) {
            b bVar = this.f3916c.get(size);
            int i14 = bVar.f3922a;
            if (i14 == 8) {
                int i15 = bVar.f3923b;
                int i16 = bVar.f3925d;
                if (i15 < i16) {
                    i13 = i15;
                    i12 = i16;
                } else {
                    i12 = i15;
                    i13 = i16;
                }
                if (i10 < i13 || i10 > i12) {
                    if (i10 < i15) {
                        if (i11 == 1) {
                            bVar.f3923b = i15 + 1;
                            bVar.f3925d = i16 + 1;
                        } else if (i11 == 2) {
                            bVar.f3923b = i15 - 1;
                            bVar.f3925d = i16 - 1;
                        }
                    }
                } else if (i13 == i15) {
                    if (i11 == 1) {
                        bVar.f3925d = i16 + 1;
                    } else if (i11 == 2) {
                        bVar.f3925d = i16 - 1;
                    }
                    i10++;
                } else {
                    if (i11 == 1) {
                        bVar.f3923b = i15 + 1;
                    } else if (i11 == 2) {
                        bVar.f3923b = i15 - 1;
                    }
                    i10--;
                }
            } else {
                int i17 = bVar.f3923b;
                if (i17 <= i10) {
                    if (i14 == 1) {
                        i10 -= bVar.f3925d;
                    } else if (i14 == 2) {
                        i10 += bVar.f3925d;
                    }
                } else if (i11 == 1) {
                    bVar.f3923b = i17 + 1;
                } else if (i11 == 2) {
                    bVar.f3923b = i17 - 1;
                }
            }
        }
        for (int size2 = this.f3916c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f3916c.get(size2);
            if (bVar2.f3922a == 8) {
                int i18 = bVar2.f3925d;
                if (i18 == bVar2.f3923b || i18 < 0) {
                    this.f3916c.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.f3925d <= 0) {
                this.f3916c.remove(size2);
                a(bVar2);
            }
        }
        return i10;
    }

    @Override // androidx.recyclerview.widget.l.a
    public void a(b bVar) {
        if (!this.f3919f) {
            bVar.f3924c = null;
            this.f3914a.a(bVar);
        }
    }

    @Override // androidx.recyclerview.widget.l.a
    public b b(int i10, int i11, int i12, Object obj) {
        b b10 = this.f3914a.b();
        if (b10 == null) {
            return new b(i10, i11, i12, obj);
        }
        b10.f3922a = i10;
        b10.f3923b = i11;
        b10.f3925d = i12;
        b10.f3924c = obj;
        return b10;
    }

    public int e(int i10) {
        int size = this.f3915b.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = this.f3915b.get(i11);
            int i12 = bVar.f3922a;
            if (i12 != 1) {
                if (i12 == 2) {
                    int i13 = bVar.f3923b;
                    if (i13 <= i10) {
                        int i14 = bVar.f3925d;
                        if (i13 + i14 > i10) {
                            return -1;
                        }
                        i10 -= i14;
                    } else {
                        continue;
                    }
                } else if (i12 == 8) {
                    int i15 = bVar.f3923b;
                    if (i15 == i10) {
                        i10 = bVar.f3925d;
                    } else {
                        if (i15 < i10) {
                            i10--;
                        }
                        if (bVar.f3925d <= i10) {
                            i10++;
                        }
                    }
                }
            } else if (bVar.f3923b <= i10) {
                i10 += bVar.f3925d;
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        int size = this.f3916c.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f3917d.d(this.f3916c.get(i10));
        }
        x(this.f3916c);
        this.f3921h = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        i();
        int size = this.f3915b.size();
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = this.f3915b.get(i10);
            int i11 = bVar.f3922a;
            if (i11 == 1) {
                this.f3917d.d(bVar);
                this.f3917d.g(bVar.f3923b, bVar.f3925d);
            } else if (i11 == 2) {
                this.f3917d.d(bVar);
                this.f3917d.h(bVar.f3923b, bVar.f3925d);
            } else if (i11 == 4) {
                this.f3917d.d(bVar);
                this.f3917d.c(bVar.f3923b, bVar.f3925d, bVar.f3924c);
            } else if (i11 == 8) {
                this.f3917d.d(bVar);
                this.f3917d.a(bVar.f3923b, bVar.f3925d);
            }
            Runnable runnable = this.f3918e;
            if (runnable != null) {
                runnable.run();
            }
        }
        x(this.f3915b);
        this.f3921h = 0;
    }

    void l(b bVar, int i10) {
        this.f3917d.b(bVar);
        int i11 = bVar.f3922a;
        if (i11 == 2) {
            this.f3917d.h(i10, bVar.f3925d);
        } else if (i11 == 4) {
            this.f3917d.c(i10, bVar.f3925d, bVar.f3924c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m(int i10) {
        return n(i10, 0);
    }

    int n(int i10, int i11) {
        int size = this.f3916c.size();
        while (i11 < size) {
            b bVar = this.f3916c.get(i11);
            int i12 = bVar.f3922a;
            if (i12 == 8) {
                int i13 = bVar.f3923b;
                if (i13 == i10) {
                    i10 = bVar.f3925d;
                } else {
                    if (i13 < i10) {
                        i10--;
                    }
                    if (bVar.f3925d <= i10) {
                        i10++;
                    }
                }
            } else {
                int i14 = bVar.f3923b;
                if (i14 > i10) {
                    continue;
                } else if (i12 == 2) {
                    int i15 = bVar.f3925d;
                    if (i10 < i14 + i15) {
                        return -1;
                    }
                    i10 -= i15;
                } else if (i12 == 1) {
                    i10 += bVar.f3925d;
                }
            }
            i11++;
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o(int i10) {
        return (i10 & this.f3921h) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        return this.f3915b.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q() {
        return !this.f3916c.isEmpty() && !this.f3915b.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r(int i10, int i11, Object obj) {
        if (i11 < 1) {
            return false;
        }
        this.f3915b.add(b(4, i10, i11, obj));
        this.f3921h |= 4;
        return this.f3915b.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s(int i10, int i11) {
        if (i11 < 1) {
            return false;
        }
        this.f3915b.add(b(1, i10, i11, null));
        this.f3921h |= 1;
        return this.f3915b.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t(int i10, int i11, int i12) {
        if (i10 == i11) {
            return false;
        }
        if (i12 == 1) {
            this.f3915b.add(b(8, i10, i11, null));
            this.f3921h |= 8;
            return this.f3915b.size() == 1;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean u(int i10, int i11) {
        if (i11 < 1) {
            return false;
        }
        this.f3915b.add(b(2, i10, i11, null));
        this.f3921h |= 2;
        return this.f3915b.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w() {
        this.f3920g.b(this.f3915b);
        int size = this.f3915b.size();
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = this.f3915b.get(i10);
            int i11 = bVar.f3922a;
            if (i11 == 1) {
                c(bVar);
            } else if (i11 == 2) {
                f(bVar);
            } else if (i11 == 4) {
                g(bVar);
            } else if (i11 == 8) {
                d(bVar);
            }
            Runnable runnable = this.f3918e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f3915b.clear();
    }

    void x(List<b> list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            a(list.get(i10));
        }
        list.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y() {
        x(this.f3915b);
        x(this.f3916c);
        this.f3921h = 0;
    }

    a(AbstractC0040a aVar, boolean z10) {
        this.f3914a = new f(30);
        this.f3915b = new ArrayList<>();
        this.f3916c = new ArrayList<>();
        this.f3921h = 0;
        this.f3917d = aVar;
        this.f3919f = z10;
        this.f3920g = new l(this);
    }
}
