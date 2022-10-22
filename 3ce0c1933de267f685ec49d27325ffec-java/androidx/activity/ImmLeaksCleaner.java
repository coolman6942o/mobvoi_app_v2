package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.n;
import androidx.lifecycle.p;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
final class ImmLeaksCleaner implements n {

    /* renamed from: b  reason: collision with root package name */
    private static int f303b;

    /* renamed from: c  reason: collision with root package name */
    private static Field f304c;

    /* renamed from: d  reason: collision with root package name */
    private static Field f305d;

    /* renamed from: e  reason: collision with root package name */
    private static Field f306e;

    /* renamed from: a  reason: collision with root package name */
    private Activity f307a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmLeaksCleaner(Activity activity) {
        this.f307a = activity;
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    private static void d() {
        try {
            f303b = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f305d = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f306e = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f304c = declaredField3;
            declaredField3.setAccessible(true);
            f303b = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.n
    public void c(p pVar, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            if (f303b == 0) {
                d();
            }
            if (f303b == 1) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.f307a.getSystemService("input_method");
                try {
                    Object obj = f304c.get(inputMethodManager);
                    if (obj != null) {
                        synchronized (obj) {
                            try {
                                try {
                                    View view = (View) f305d.get(inputMethodManager);
                                    if (view != null) {
                                        if (!view.isAttachedToWindow()) {
                                            try {
                                                f306e.set(inputMethodManager, null);
                                                inputMethodManager.isActive();
                                            } catch (IllegalAccessException unused) {
                                            }
                                        }
                                    }
                                } catch (Throwable th2) {
                                    throw th2;
                                }
                            } catch (ClassCastException unused2) {
                            } catch (IllegalAccessException unused3) {
                            }
                        }
                    }
                } catch (IllegalAccessException unused4) {
                }
            }
        }
    }
}
