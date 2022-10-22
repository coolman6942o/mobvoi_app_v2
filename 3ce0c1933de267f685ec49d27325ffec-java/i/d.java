package i;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import d.i;
/* compiled from: ContextThemeWrapper.java */
/* loaded from: classes.dex */
public class d extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    private int f27908a;

    /* renamed from: b  reason: collision with root package name */
    private Resources.Theme f27909b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f27910c;

    /* renamed from: d  reason: collision with root package name */
    private Configuration f27911d;

    /* renamed from: e  reason: collision with root package name */
    private Resources f27912e;

    public d() {
        super(null);
    }

    private Resources b() {
        if (this.f27912e == null) {
            Configuration configuration = this.f27911d;
            if (configuration == null) {
                this.f27912e = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                this.f27912e = createConfigurationContext(configuration).getResources();
            } else {
                Resources resources = super.getResources();
                Configuration configuration2 = new Configuration(resources.getConfiguration());
                configuration2.updateFrom(this.f27911d);
                this.f27912e = new Resources(resources.getAssets(), resources.getDisplayMetrics(), configuration2);
            }
        }
        return this.f27912e;
    }

    private void d() {
        boolean z10 = this.f27909b == null;
        if (z10) {
            this.f27909b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f27909b.setTo(theme);
            }
        }
        e(this.f27909b, this.f27908a, z10);
    }

    public void a(Configuration configuration) {
        if (this.f27912e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        } else if (this.f27911d == null) {
            this.f27911d = new Configuration(configuration);
        } else {
            throw new IllegalStateException("Override configuration has already been set");
        }
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public int c() {
        return this.f27908a;
    }

    protected void e(Resources.Theme theme, int i10, boolean z10) {
        theme.applyStyle(i10, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f27910c == null) {
            this.f27910c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f27910c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f27909b;
        if (theme != null) {
            return theme;
        }
        if (this.f27908a == 0) {
            this.f27908a = i.f24853e;
        }
        d();
        return this.f27909b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i10) {
        if (this.f27908a != i10) {
            this.f27908a = i10;
            d();
        }
    }

    public d(Context context, int i10) {
        super(context);
        this.f27908a = i10;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f27909b = theme;
    }
}
