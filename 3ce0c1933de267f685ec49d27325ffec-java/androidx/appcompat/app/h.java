package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.b0;
import androidx.appcompat.widget.c;
import androidx.appcompat.widget.e;
import androidx.appcompat.widget.g;
import androidx.appcompat.widget.k;
import androidx.appcompat.widget.o;
import androidx.appcompat.widget.q;
import androidx.appcompat.widget.r;
import androidx.appcompat.widget.u;
import androidx.appcompat.widget.u0;
import androidx.appcompat.widget.v;
import androidx.appcompat.widget.x;
import androidx.collection.f;
import androidx.core.view.d0;
import d.j;
import i.d;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: AppCompatViewInflater.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?>[] f524b = {Context.class, AttributeSet.class};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f525c = {16843375};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f526d = {16844160};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f527e = {16844156};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f528f = {16844148};

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f529g = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: h  reason: collision with root package name */
    private static final f<String, Constructor<? extends View>> f530h = new f<>();

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f531a = new Object[2];

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AppCompatViewInflater.java */
    /* loaded from: classes.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        private final View f532a;

        /* renamed from: b  reason: collision with root package name */
        private final String f533b;

        /* renamed from: c  reason: collision with root package name */
        private Method f534c;

        /* renamed from: d  reason: collision with root package name */
        private Context f535d;

        public a(View view, String str) {
            this.f532a = view;
            this.f533b = str;
        }

        private void a(Context context) {
            int id2;
            String str;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f533b, View.class)) != null) {
                        this.f534c = method;
                        this.f535d = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            if (this.f532a.getId() == -1) {
                str = "";
            } else {
                str = " with id '" + this.f532a.getContext().getResources().getResourceEntryName(id2) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f533b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f532a.getClass() + str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f534c == null) {
                a(this.f532a.getContext());
            }
            try {
                this.f534c.invoke(this.f535d, view);
            } catch (IllegalAccessException e10) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e10);
            } catch (InvocationTargetException e11) {
                throw new IllegalStateException("Could not execute method for android:onClick", e11);
            }
        }
    }

    private void a(Context context, View view, AttributeSet attributeSet) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 19 && i10 <= 28) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f526d);
            if (obtainStyledAttributes.hasValue(0)) {
                d0.u0(view, obtainStyledAttributes.getBoolean(0, false));
            }
            obtainStyledAttributes.recycle();
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, f527e);
            if (obtainStyledAttributes2.hasValue(0)) {
                d0.w0(view, obtainStyledAttributes2.getString(0));
            }
            obtainStyledAttributes2.recycle();
            TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f528f);
            if (obtainStyledAttributes3.hasValue(0)) {
                d0.J0(view, obtainStyledAttributes3.getBoolean(0, false));
            }
            obtainStyledAttributes3.recycle();
        }
    }

    private void b(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (!(context instanceof ContextWrapper)) {
            return;
        }
        if (Build.VERSION.SDK_INT < 15 || d0.S(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f525c);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new a(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    private View s(Context context, String str, String str2) throws ClassNotFoundException, InflateException {
        String str3;
        f<String, Constructor<? extends View>> fVar = f530h;
        Constructor<? extends View> constructor = fVar.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f524b);
            fVar.put(str, constructor);
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.f531a);
    }

    private View t(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            Object[] objArr = this.f531a;
            objArr[0] = context;
            objArr[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return s(context, str, null);
            }
            int i10 = 0;
            while (true) {
                String[] strArr = f529g;
                if (i10 >= strArr.length) {
                    return null;
                }
                View s10 = s(context, str, strArr[i10]);
                if (s10 != null) {
                    return s10;
                }
                i10++;
            }
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr2 = this.f531a;
            objArr2[0] = null;
            objArr2[1] = null;
        }
    }

    private static Context u(Context context, AttributeSet attributeSet, boolean z10, boolean z11) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.M3, 0, 0);
        int resourceId = z10 ? obtainStyledAttributes.getResourceId(j.N3, 0) : 0;
        if (z11 && resourceId == 0 && (resourceId = obtainStyledAttributes.getResourceId(j.O3, 0)) != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        obtainStyledAttributes.recycle();
        return resourceId != 0 ? (!(context instanceof d) || ((d) context).c() != resourceId) ? new d(context, resourceId) : context : context;
    }

    private void v(View view, String str) {
        if (view == null) {
            throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
        }
    }

    protected c c(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    protected e d(Context context, AttributeSet attributeSet) {
        return new e(context, attributeSet);
    }

    protected androidx.appcompat.widget.f e(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.f(context, attributeSet);
    }

    protected g f(Context context, AttributeSet attributeSet) {
        return new g(context, attributeSet);
    }

    protected k g(Context context, AttributeSet attributeSet) {
        return new k(context, attributeSet);
    }

    protected o h(Context context, AttributeSet attributeSet) {
        return new o(context, attributeSet);
    }

    protected q i(Context context, AttributeSet attributeSet) {
        return new q(context, attributeSet);
    }

    protected r j(Context context, AttributeSet attributeSet) {
        return new r(context, attributeSet);
    }

    protected u k(Context context, AttributeSet attributeSet) {
        return new u(context, attributeSet);
    }

    protected v l(Context context, AttributeSet attributeSet) {
        return new v(context, attributeSet);
    }

    protected x m(Context context, AttributeSet attributeSet) {
        return new x(context, attributeSet);
    }

    protected AppCompatSpinner n(Context context, AttributeSet attributeSet) {
        return new AppCompatSpinner(context, attributeSet);
    }

    protected b0 o(Context context, AttributeSet attributeSet) {
        return new b0(context, attributeSet);
    }

    protected androidx.appcompat.widget.d0 p(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.d0(context, attributeSet);
    }

    protected View q(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final View r(View view, String str, Context context, AttributeSet attributeSet, boolean z10, boolean z11, boolean z12, boolean z13) {
        View view2;
        Context context2 = (!z10 || view == null) ? context : view.getContext();
        if (z11 || z12) {
            context2 = u(context2, attributeSet, z11, z12);
        }
        if (z13) {
            context2 = u0.b(context2);
        }
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    c10 = 2;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    c10 = 3;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    c10 = 4;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    c10 = 5;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    c10 = 6;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    c10 = 7;
                    break;
                }
                break;
            case 799298502:
                if (str.equals("ToggleButton")) {
                    c10 = '\b';
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    c10 = '\t';
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    c10 = '\n';
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    c10 = 11;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    c10 = '\f';
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    c10 = '\r';
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                view2 = l(context2, attributeSet);
                v(view2, str);
                break;
            case 1:
                view2 = f(context2, attributeSet);
                v(view2, str);
                break;
            case 2:
                view2 = j(context2, attributeSet);
                v(view2, str);
                break;
            case 3:
                view2 = o(context2, attributeSet);
                v(view2, str);
                break;
            case 4:
                view2 = h(context2, attributeSet);
                v(view2, str);
                break;
            case 5:
                view2 = m(context2, attributeSet);
                v(view2, str);
                break;
            case 6:
                view2 = n(context2, attributeSet);
                v(view2, str);
                break;
            case 7:
                view2 = k(context2, attributeSet);
                v(view2, str);
                break;
            case '\b':
                view2 = p(context2, attributeSet);
                v(view2, str);
                break;
            case '\t':
                view2 = i(context2, attributeSet);
                v(view2, str);
                break;
            case '\n':
                view2 = c(context2, attributeSet);
                v(view2, str);
                break;
            case 11:
                view2 = e(context2, attributeSet);
                v(view2, str);
                break;
            case '\f':
                view2 = g(context2, attributeSet);
                v(view2, str);
                break;
            case '\r':
                view2 = d(context2, attributeSet);
                v(view2, str);
                break;
            default:
                view2 = q(context2, str, attributeSet);
                break;
        }
        if (view2 == null && context != context2) {
            view2 = t(context2, str, attributeSet);
        }
        if (view2 != null) {
            b(view2, attributeSet);
            a(context2, view2, attributeSet);
        }
        return view2;
    }
}
