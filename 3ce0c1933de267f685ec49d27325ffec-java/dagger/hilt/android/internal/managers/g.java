package dagger.hilt.android.internal.managers;

import android.app.Application;
import android.app.Service;
import qn.d;
import tn.b;
import tn.c;
/* compiled from: ServiceComponentManager.java */
/* loaded from: classes2.dex */
public final class g implements b<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final Service f25598a;

    /* renamed from: b  reason: collision with root package name */
    private Object f25599b;

    /* compiled from: ServiceComponentManager.java */
    /* loaded from: classes2.dex */
    public interface a {
        d a();
    }

    public g(Service service) {
        this.f25598a = service;
    }

    private Object a() {
        Application application = this.f25598a.getApplication();
        c.c(application instanceof b, "Hilt service must be attached to an @AndroidEntryPoint Application. Found: %s", application.getClass());
        return ((a) ln.a.a(application, a.class)).a().a(this.f25598a).build();
    }

    @Override // tn.b
    public Object h() {
        if (this.f25599b == null) {
            this.f25599b = a();
        }
        return this.f25599b;
    }
}
