package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import androidx.collection.f;
/* compiled from: WindowInsetsControllerCompat.java */
/* loaded from: classes.dex */
public final class o0 {

    /* renamed from: a  reason: collision with root package name */
    private final e f2613a;

    /* compiled from: WindowInsetsControllerCompat.java */
    /* loaded from: classes.dex */
    private static class a extends e {

        /* renamed from: a  reason: collision with root package name */
        protected final Window f2614a;

        /* renamed from: b  reason: collision with root package name */
        private final View f2615b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: WindowInsetsControllerCompat.java */
        /* renamed from: androidx.core.view.o0$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0023a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ View f2616a;

            RunnableC0023a(a aVar, View view) {
                this.f2616a = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                ((InputMethodManager) this.f2616a.getContext().getSystemService("input_method")).showSoftInput(this.f2616a, 0);
            }
        }

        a(Window window, View view) {
            this.f2614a = window;
            this.f2615b = view;
        }

        private void f(int i10) {
            if (i10 == 1) {
                g(4);
                h(1024);
            } else if (i10 == 2) {
                g(2);
            } else if (i10 == 8) {
                View view = this.f2615b;
                if (view == null || (!view.isInEditMode() && !view.onCheckIsTextEditor())) {
                    view = this.f2614a.getCurrentFocus();
                } else {
                    view.requestFocus();
                }
                if (view == null) {
                    view = this.f2614a.findViewById(16908290);
                }
                if (view != null && view.hasWindowFocus()) {
                    view.post(new RunnableC0023a(this, view));
                }
            }
        }

        @Override // androidx.core.view.o0.e
        void c(int i10) {
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    f(i11);
                }
            }
        }

        protected void d(int i10) {
            View decorView = this.f2614a.getDecorView();
            decorView.setSystemUiVisibility(i10 | decorView.getSystemUiVisibility());
        }

        protected void e(int i10) {
            this.f2614a.addFlags(i10);
        }

        protected void g(int i10) {
            View decorView = this.f2614a.getDecorView();
            decorView.setSystemUiVisibility((~i10) & decorView.getSystemUiVisibility());
        }

        protected void h(int i10) {
            this.f2614a.clearFlags(i10);
        }
    }

    /* compiled from: WindowInsetsControllerCompat.java */
    /* loaded from: classes.dex */
    private static class b extends a {
        b(Window window, View view) {
            super(window, view);
        }

        @Override // androidx.core.view.o0.e
        public void b(boolean z10) {
            if (z10) {
                h(67108864);
                e(Integer.MIN_VALUE);
                d(8192);
                return;
            }
            g(8192);
        }
    }

    /* compiled from: WindowInsetsControllerCompat.java */
    /* loaded from: classes.dex */
    private static class c extends b {
        c(Window window, View view) {
            super(window, view);
        }

        @Override // androidx.core.view.o0.e
        public void a(boolean z10) {
            if (z10) {
                h(134217728);
                e(Integer.MIN_VALUE);
                d(16);
                return;
            }
            g(16);
        }
    }

    /* compiled from: WindowInsetsControllerCompat.java */
    /* loaded from: classes.dex */
    private static class e {
        e() {
        }

        public void a(boolean z10) {
        }

        public void b(boolean z10) {
        }

        void c(int i10) {
        }
    }

    private o0(WindowInsetsController windowInsetsController) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f2613a = new d(windowInsetsController, this);
        } else {
            this.f2613a = new e();
        }
    }

    public static o0 d(WindowInsetsController windowInsetsController) {
        return new o0(windowInsetsController);
    }

    public void a(boolean z10) {
        this.f2613a.a(z10);
    }

    public void b(boolean z10) {
        this.f2613a.b(z10);
    }

    public void c(int i10) {
        this.f2613a.c(i10);
    }

    /* compiled from: WindowInsetsControllerCompat.java */
    /* loaded from: classes.dex */
    private static class d extends e {

        /* renamed from: a  reason: collision with root package name */
        final WindowInsetsController f2617a;

        /* renamed from: b  reason: collision with root package name */
        protected Window f2618b;

        d(Window window, o0 o0Var) {
            this(window.getInsetsController(), o0Var);
            this.f2618b = window;
        }

        @Override // androidx.core.view.o0.e
        public void a(boolean z10) {
            if (z10) {
                this.f2617a.setSystemBarsAppearance(16, 16);
            } else {
                this.f2617a.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // androidx.core.view.o0.e
        public void b(boolean z10) {
            if (z10) {
                if (this.f2618b != null) {
                    d(8192);
                }
                this.f2617a.setSystemBarsAppearance(8, 8);
                return;
            }
            this.f2617a.setSystemBarsAppearance(0, 8);
        }

        @Override // androidx.core.view.o0.e
        void c(int i10) {
            this.f2617a.show(i10);
        }

        protected void d(int i10) {
            View decorView = this.f2618b.getDecorView();
            decorView.setSystemUiVisibility((~i10) & decorView.getSystemUiVisibility());
        }

        d(WindowInsetsController windowInsetsController, o0 o0Var) {
            new f();
            this.f2617a = windowInsetsController;
        }
    }

    public o0(Window window, View view) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            this.f2613a = new d(window, this);
        } else if (i10 >= 26) {
            this.f2613a = new c(window, view);
        } else if (i10 >= 23) {
            this.f2613a = new b(window, view);
        } else if (i10 >= 20) {
            this.f2613a = new a(window, view);
        } else {
            this.f2613a = new e();
        }
    }
}
