package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* compiled from: TintContextWrapper.java */
/* loaded from: classes.dex */
public class u0 extends ContextWrapper {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f1350c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static ArrayList<WeakReference<u0>> f1351d;

    /* renamed from: a  reason: collision with root package name */
    private final Resources f1352a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources.Theme f1353b;

    private u0(Context context) {
        super(context);
        if (d1.c()) {
            d1 d1Var = new d1(this, context.getResources());
            this.f1352a = d1Var;
            Resources.Theme newTheme = d1Var.newTheme();
            this.f1353b = newTheme;
            newTheme.setTo(context.getTheme());
            return;
        }
        this.f1352a = new w0(this, context.getResources());
        this.f1353b = null;
    }

    private static boolean a(Context context) {
        if ((context instanceof u0) || (context.getResources() instanceof w0) || (context.getResources() instanceof d1)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || d1.c();
    }

    public static Context b(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f1350c) {
            ArrayList<WeakReference<u0>> arrayList = f1351d;
            if (arrayList == null) {
                f1351d = new ArrayList<>();
            } else {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    WeakReference<u0> weakReference = f1351d.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f1351d.remove(size);
                    }
                }
                for (int size2 = f1351d.size() - 1; size2 >= 0; size2--) {
                    WeakReference<u0> weakReference2 = f1351d.get(size2);
                    u0 u0Var = weakReference2 != null ? weakReference2.get() : null;
                    if (u0Var != null && u0Var.getBaseContext() == context) {
                        return u0Var;
                    }
                }
            }
            u0 u0Var2 = new u0(context);
            f1351d.add(new WeakReference<>(u0Var2));
            return u0Var2;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f1352a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f1352a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1353b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i10) {
        Resources.Theme theme = this.f1353b;
        if (theme == null) {
            super.setTheme(i10);
        } else {
            theme.applyStyle(i10, true);
        }
    }
}
