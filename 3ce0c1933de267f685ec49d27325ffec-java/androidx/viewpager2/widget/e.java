package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ScrollEventAdapter.java */
/* loaded from: classes.dex */
public final class e extends RecyclerView.s {

    /* renamed from: a  reason: collision with root package name */
    private ViewPager2.i f4651a;

    /* renamed from: b  reason: collision with root package name */
    private final ViewPager2 f4652b;

    /* renamed from: c  reason: collision with root package name */
    private final RecyclerView f4653c;

    /* renamed from: d  reason: collision with root package name */
    private final LinearLayoutManager f4654d;

    /* renamed from: e  reason: collision with root package name */
    private int f4655e;

    /* renamed from: f  reason: collision with root package name */
    private int f4656f;

    /* renamed from: g  reason: collision with root package name */
    private a f4657g = new a();

    /* renamed from: h  reason: collision with root package name */
    private int f4658h;

    /* renamed from: i  reason: collision with root package name */
    private int f4659i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4660j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f4661k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f4662l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f4663m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ScrollEventAdapter.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        int f4664a;

        /* renamed from: b  reason: collision with root package name */
        float f4665b;

        /* renamed from: c  reason: collision with root package name */
        int f4666c;

        a() {
        }

        void a() {
            this.f4664a = -1;
            this.f4665b = 0.0f;
            this.f4666c = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ViewPager2 viewPager2) {
        this.f4652b = viewPager2;
        RecyclerView recyclerView = viewPager2.f4617j;
        this.f4653c = recyclerView;
        this.f4654d = (LinearLayoutManager) recyclerView.getLayoutManager();
        n();
    }

    private void c(int i10, float f10, int i11) {
        ViewPager2.i iVar = this.f4651a;
        if (iVar != null) {
            iVar.b(i10, f10, i11);
        }
    }

    private void d(int i10) {
        ViewPager2.i iVar = this.f4651a;
        if (iVar != null) {
            iVar.c(i10);
        }
    }

    private void e(int i10) {
        if ((this.f4655e != 3 || this.f4656f != 0) && this.f4656f != i10) {
            this.f4656f = i10;
            ViewPager2.i iVar = this.f4651a;
            if (iVar != null) {
                iVar.a(i10);
            }
        }
    }

    private int f() {
        return this.f4654d.Z1();
    }

    private boolean k() {
        int i10 = this.f4655e;
        return i10 == 1 || i10 == 4;
    }

    private void n() {
        this.f4655e = 0;
        this.f4656f = 0;
        this.f4657g.a();
        this.f4658h = -1;
        this.f4659i = -1;
        this.f4660j = false;
        this.f4661k = false;
        this.f4663m = false;
        this.f4662l = false;
    }

    private void p(boolean z10) {
        this.f4663m = z10;
        this.f4655e = z10 ? 4 : 1;
        int i10 = this.f4659i;
        if (i10 != -1) {
            this.f4658h = i10;
            this.f4659i = -1;
        } else if (this.f4658h == -1) {
            this.f4658h = f();
        }
        e(1);
    }

    private void q() {
        int i10;
        a aVar = this.f4657g;
        int Z1 = this.f4654d.Z1();
        aVar.f4664a = Z1;
        if (Z1 == -1) {
            aVar.a();
            return;
        }
        View D = this.f4654d.D(Z1);
        if (D == null) {
            aVar.a();
            return;
        }
        int b02 = this.f4654d.b0(D);
        int k02 = this.f4654d.k0(D);
        int n02 = this.f4654d.n0(D);
        int I = this.f4654d.I(D);
        ViewGroup.LayoutParams layoutParams = D.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            b02 += marginLayoutParams.leftMargin;
            k02 += marginLayoutParams.rightMargin;
            n02 += marginLayoutParams.topMargin;
            I += marginLayoutParams.bottomMargin;
        }
        int height = D.getHeight() + n02 + I;
        height = D.getWidth() + b02 + k02;
        if (this.f4654d.n2() == 0) {
            i10 = (D.getLeft() - b02) - this.f4653c.getPaddingLeft();
            if (this.f4652b.d()) {
                i10 = -i10;
            }
        } else {
            i10 = (D.getTop() - n02) - this.f4653c.getPaddingTop();
        }
        int i11 = -i10;
        aVar.f4666c = i11;
        if (i11 >= 0) {
            aVar.f4665b = height == 0 ? 0.0f : i11 / height;
        } else if (new androidx.viewpager2.widget.a(this.f4654d).d()) {
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        } else {
            throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(aVar.f4666c)));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void a(RecyclerView recyclerView, int i10) {
        boolean z10 = true;
        if (!(this.f4655e == 1 && this.f4656f == 1) && i10 == 1) {
            p(false);
        } else if (!k() || i10 != 2) {
            if (k() && i10 == 0) {
                q();
                if (!this.f4661k) {
                    int i11 = this.f4657g.f4664a;
                    if (i11 != -1) {
                        c(i11, 0.0f, 0);
                    }
                } else {
                    a aVar = this.f4657g;
                    if (aVar.f4666c == 0) {
                        int i12 = this.f4658h;
                        int i13 = aVar.f4664a;
                        if (i12 != i13) {
                            d(i13);
                        }
                    } else {
                        z10 = false;
                    }
                }
                if (z10) {
                    e(0);
                    n();
                }
            }
            if (this.f4655e == 2 && i10 == 0 && this.f4662l) {
                q();
                a aVar2 = this.f4657g;
                if (aVar2.f4666c == 0) {
                    int i14 = this.f4659i;
                    int i15 = aVar2.f4664a;
                    if (i14 != i15) {
                        if (i15 == -1) {
                            i15 = 0;
                        }
                        d(i15);
                    }
                    e(0);
                    n();
                }
            }
        } else if (this.f4661k) {
            e(2);
            this.f4660j = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
        if ((r5 < 0) == r3.f4652b.d()) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
    @Override // androidx.recyclerview.widget.RecyclerView.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(RecyclerView recyclerView, int i10, int i11) {
        boolean z10;
        int i12;
        this.f4661k = true;
        q();
        if (this.f4660j) {
            this.f4660j = false;
            if (i11 <= 0) {
                if (i11 == 0) {
                }
                z10 = false;
                if (z10) {
                    a aVar = this.f4657g;
                    if (aVar.f4666c != 0) {
                        i12 = aVar.f4664a + 1;
                        this.f4659i = i12;
                        if (this.f4658h != i12) {
                            d(i12);
                        }
                    }
                }
                i12 = this.f4657g.f4664a;
                this.f4659i = i12;
                if (this.f4658h != i12) {
                }
            }
            z10 = true;
            if (z10) {
            }
            i12 = this.f4657g.f4664a;
            this.f4659i = i12;
            if (this.f4658h != i12) {
            }
        } else if (this.f4655e == 0) {
            int i13 = this.f4657g.f4664a;
            if (i13 == -1) {
                i13 = 0;
            }
            d(i13);
        }
        a aVar2 = this.f4657g;
        int i14 = aVar2.f4664a;
        if (i14 == -1) {
            i14 = 0;
        }
        c(i14, aVar2.f4665b, aVar2.f4666c);
        a aVar3 = this.f4657g;
        int i15 = aVar3.f4664a;
        int i16 = this.f4659i;
        if ((i15 == i16 || i16 == -1) && aVar3.f4666c == 0 && this.f4656f != 1) {
            e(0);
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double g() {
        q();
        a aVar = this.f4657g;
        return aVar.f4664a + aVar.f4665b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f4656f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i() {
        return this.f4663m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j() {
        return this.f4656f == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        this.f4662l = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(int i10, boolean z10) {
        this.f4655e = z10 ? 2 : 3;
        boolean z11 = false;
        this.f4663m = false;
        if (this.f4659i != i10) {
            z11 = true;
        }
        this.f4659i = i10;
        e(2);
        if (z11) {
            d(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(ViewPager2.i iVar) {
        this.f4651a = iVar;
    }
}
