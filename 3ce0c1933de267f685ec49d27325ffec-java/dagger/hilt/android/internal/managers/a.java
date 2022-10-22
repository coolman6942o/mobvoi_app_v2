package dagger.hilt.android.internal.managers;

import android.app.Activity;
import android.app.Application;
import androidx.activity.ComponentActivity;
import tn.b;
/* compiled from: ActivityComponentManager.java */
/* loaded from: classes2.dex */
public class a implements b<Object> {

    /* renamed from: a  reason: collision with root package name */
    private volatile Object f25582a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f25583b = new Object();

    /* renamed from: c  reason: collision with root package name */
    protected final Activity f25584c;

    /* renamed from: d  reason: collision with root package name */
    private final b<nn.b> f25585d;

    /* compiled from: ActivityComponentManager.java */
    /* renamed from: dagger.hilt.android.internal.managers.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface AbstractC0271a {
        qn.a b();
    }

    public a(Activity activity) {
        this.f25584c = activity;
        this.f25585d = new b((ComponentActivity) activity);
    }

    protected Object a() {
        if (this.f25584c.getApplication() instanceof b) {
            return ((AbstractC0271a) ln.a.a(this.f25585d, AbstractC0271a.class)).b().a(this.f25584c).build();
        }
        if (Application.class.equals(this.f25584c.getApplication().getClass())) {
            throw new IllegalStateException("Hilt Activity must be attached to an @HiltAndroidApp Application. Did you forget to specify your Application's class name in your manifest's <application />'s android:name attribute?");
        }
        throw new IllegalStateException("Hilt Activity must be attached to an @AndroidEntryPoint Application. Found: " + this.f25584c.getApplication().getClass());
    }

    @Override // tn.b
    public Object h() {
        if (this.f25582a == null) {
            synchronized (this.f25583b) {
                if (this.f25582a == null) {
                    this.f25582a = a();
                }
            }
        }
        return this.f25582a;
    }
}
