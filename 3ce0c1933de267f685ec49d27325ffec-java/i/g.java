package i;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.widget.g0;
import androidx.appcompat.widget.x0;
import androidx.core.view.m;
import d.j;
import j.c;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: SupportMenuInflater.java */
/* loaded from: classes.dex */
public class g extends MenuInflater {

    /* renamed from: e  reason: collision with root package name */
    static final Class<?>[] f27925e;

    /* renamed from: f  reason: collision with root package name */
    static final Class<?>[] f27926f;

    /* renamed from: a  reason: collision with root package name */
    final Object[] f27927a;

    /* renamed from: b  reason: collision with root package name */
    final Object[] f27928b;

    /* renamed from: c  reason: collision with root package name */
    Context f27929c;

    /* renamed from: d  reason: collision with root package name */
    private Object f27930d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SupportMenuInflater.java */
    /* loaded from: classes.dex */
    public static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c  reason: collision with root package name */
        private static final Class<?>[] f27931c = {MenuItem.class};

        /* renamed from: a  reason: collision with root package name */
        private Object f27932a;

        /* renamed from: b  reason: collision with root package name */
        private Method f27933b;

        public a(Object obj, String str) {
            this.f27932a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f27933b = cls.getMethod(str, f27931c);
            } catch (Exception e10) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e10);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f27933b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f27933b.invoke(this.f27932a, menuItem)).booleanValue();
                }
                this.f27933b.invoke(this.f27932a, menuItem);
                return true;
            } catch (Exception e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SupportMenuInflater.java */
    /* loaded from: classes.dex */
    public class b {
        androidx.core.view.b A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;

        /* renamed from: a  reason: collision with root package name */
        private Menu f27934a;

        /* renamed from: b  reason: collision with root package name */
        private int f27935b;

        /* renamed from: c  reason: collision with root package name */
        private int f27936c;

        /* renamed from: d  reason: collision with root package name */
        private int f27937d;

        /* renamed from: e  reason: collision with root package name */
        private int f27938e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f27939f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f27940g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f27941h;

        /* renamed from: i  reason: collision with root package name */
        private int f27942i;

        /* renamed from: j  reason: collision with root package name */
        private int f27943j;

        /* renamed from: k  reason: collision with root package name */
        private CharSequence f27944k;

        /* renamed from: l  reason: collision with root package name */
        private CharSequence f27945l;

        /* renamed from: m  reason: collision with root package name */
        private int f27946m;

        /* renamed from: n  reason: collision with root package name */
        private char f27947n;

        /* renamed from: o  reason: collision with root package name */
        private int f27948o;

        /* renamed from: p  reason: collision with root package name */
        private char f27949p;

        /* renamed from: q  reason: collision with root package name */
        private int f27950q;

        /* renamed from: r  reason: collision with root package name */
        private int f27951r;

        /* renamed from: s  reason: collision with root package name */
        private boolean f27952s;

        /* renamed from: t  reason: collision with root package name */
        private boolean f27953t;

        /* renamed from: u  reason: collision with root package name */
        private boolean f27954u;

        /* renamed from: v  reason: collision with root package name */
        private int f27955v;

        /* renamed from: w  reason: collision with root package name */
        private int f27956w;

        /* renamed from: x  reason: collision with root package name */
        private String f27957x;

        /* renamed from: y  reason: collision with root package name */
        private String f27958y;

        /* renamed from: z  reason: collision with root package name */
        private String f27959z;

        public b(Menu menu) {
            this.f27934a = menu;
            h();
        }

        private char c(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private <T> T e(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f27929c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e10) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e10);
                return null;
            }
        }

        private void i(MenuItem menuItem) {
            boolean z10 = false;
            menuItem.setChecked(this.f27952s).setVisible(this.f27953t).setEnabled(this.f27954u).setCheckable(this.f27951r >= 1).setTitleCondensed(this.f27945l).setIcon(this.f27946m);
            int i10 = this.f27955v;
            if (i10 >= 0) {
                menuItem.setShowAsAction(i10);
            }
            if (this.f27959z != null) {
                if (!g.this.f27929c.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new a(g.this.b(), this.f27959z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.f27951r >= 2) {
                if (menuItem instanceof androidx.appcompat.view.menu.g) {
                    ((androidx.appcompat.view.menu.g) menuItem).t(true);
                } else if (menuItem instanceof c) {
                    ((c) menuItem).h(true);
                }
            }
            String str = this.f27957x;
            if (str != null) {
                menuItem.setActionView((View) e(str, g.f27925e, g.this.f27927a));
                z10 = true;
            }
            int i11 = this.f27956w;
            if (i11 > 0) {
                if (!z10) {
                    menuItem.setActionView(i11);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            androidx.core.view.b bVar = this.A;
            if (bVar != null) {
                m.a(menuItem, bVar);
            }
            m.c(menuItem, this.B);
            m.g(menuItem, this.C);
            m.b(menuItem, this.f27947n, this.f27948o);
            m.f(menuItem, this.f27949p, this.f27950q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                m.e(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                m.d(menuItem, colorStateList);
            }
        }

        public void a() {
            this.f27941h = true;
            i(this.f27934a.add(this.f27935b, this.f27942i, this.f27943j, this.f27944k));
        }

        public SubMenu b() {
            this.f27941h = true;
            SubMenu addSubMenu = this.f27934a.addSubMenu(this.f27935b, this.f27942i, this.f27943j, this.f27944k);
            i(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean d() {
            return this.f27941h;
        }

        public void f(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.f27929c.obtainStyledAttributes(attributeSet, j.f24946s1);
            this.f27935b = obtainStyledAttributes.getResourceId(j.f24956u1, 0);
            this.f27936c = obtainStyledAttributes.getInt(j.f24966w1, 0);
            this.f27937d = obtainStyledAttributes.getInt(j.f24971x1, 0);
            this.f27938e = obtainStyledAttributes.getInt(j.f24976y1, 0);
            this.f27939f = obtainStyledAttributes.getBoolean(j.f24961v1, true);
            this.f27940g = obtainStyledAttributes.getBoolean(j.f24951t1, true);
            obtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            x0 u10 = x0.u(g.this.f27929c, attributeSet, j.f24981z1);
            this.f27942i = u10.n(j.C1, 0);
            this.f27943j = (u10.k(j.F1, this.f27936c) & (-65536)) | (u10.k(j.G1, this.f27937d) & 65535);
            this.f27944k = u10.p(j.H1);
            this.f27945l = u10.p(j.I1);
            this.f27946m = u10.n(j.A1, 0);
            this.f27947n = c(u10.o(j.J1));
            this.f27948o = u10.k(j.Q1, 4096);
            this.f27949p = c(u10.o(j.K1));
            this.f27950q = u10.k(j.U1, 4096);
            int i10 = j.L1;
            if (u10.s(i10)) {
                this.f27951r = u10.a(i10, false) ? 1 : 0;
            } else {
                this.f27951r = this.f27938e;
            }
            this.f27952s = u10.a(j.D1, false);
            this.f27953t = u10.a(j.E1, this.f27939f);
            this.f27954u = u10.a(j.B1, this.f27940g);
            this.f27955v = u10.k(j.V1, -1);
            this.f27959z = u10.o(j.M1);
            this.f27956w = u10.n(j.N1, 0);
            this.f27957x = u10.o(j.P1);
            String o10 = u10.o(j.O1);
            this.f27958y = o10;
            boolean z10 = o10 != null;
            if (z10 && this.f27956w == 0 && this.f27957x == null) {
                this.A = (androidx.core.view.b) e(o10, g.f27926f, g.this.f27928b);
            } else {
                if (z10) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = u10.p(j.R1);
            this.C = u10.p(j.W1);
            int i11 = j.T1;
            if (u10.s(i11)) {
                this.E = g0.e(u10.k(i11, -1), this.E);
            } else {
                this.E = null;
            }
            int i12 = j.S1;
            if (u10.s(i12)) {
                this.D = u10.c(i12);
            } else {
                this.D = null;
            }
            u10.w();
            this.f27941h = false;
        }

        public void h() {
            this.f27935b = 0;
            this.f27936c = 0;
            this.f27937d = 0;
            this.f27938e = 0;
            this.f27939f = true;
            this.f27940g = true;
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f27925e = clsArr;
        f27926f = clsArr;
    }

    public g(Context context) {
        super(context);
        this.f27929c = context;
        Object[] objArr = {context};
        this.f27927a = objArr;
        this.f27928b = objArr;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    private void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 2) {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
            }
        }
        String str = null;
        boolean z10 = false;
        boolean z11 = false;
        while (!z10) {
            if (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3) {
                        String name2 = xmlPullParser.getName();
                        if (z11 && name2.equals(str)) {
                            str = null;
                            z11 = false;
                        } else if (name2.equals("group")) {
                            bVar.h();
                        } else if (name2.equals("item")) {
                            if (!bVar.d()) {
                                androidx.core.view.b bVar2 = bVar.A;
                                if (bVar2 == null || !bVar2.a()) {
                                    bVar.a();
                                } else {
                                    bVar.b();
                                }
                            }
                        } else if (name2.equals("menu")) {
                            z10 = true;
                        }
                    }
                } else if (!z11) {
                    String name3 = xmlPullParser.getName();
                    if (name3.equals("group")) {
                        bVar.f(attributeSet);
                    } else if (name3.equals("item")) {
                        bVar.g(attributeSet);
                    } else if (name3.equals("menu")) {
                        c(xmlPullParser, attributeSet, bVar.b());
                    } else {
                        str = name3;
                        z11 = true;
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    Object b() {
        if (this.f27930d == null) {
            this.f27930d = a(this.f27929c);
        }
        return this.f27930d;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i10, Menu menu) {
        if (!(menu instanceof d0.a)) {
            super.inflate(i10, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.f27929c.getResources().getLayout(i10);
                    c(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                } catch (XmlPullParserException e10) {
                    throw new InflateException("Error inflating menu XML", e10);
                }
            } catch (IOException e11) {
                throw new InflateException("Error inflating menu XML", e11);
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }
}
