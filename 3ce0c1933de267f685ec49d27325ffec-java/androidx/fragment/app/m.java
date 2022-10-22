package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentLifecycleCallbacksDispatcher.java */
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private final CopyOnWriteArrayList<a> f3151a = new CopyOnWriteArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final FragmentManager f3152b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FragmentLifecycleCallbacksDispatcher.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final FragmentManager.k f3153a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f3154b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FragmentManager fragmentManager) {
        this.f3152b = fragmentManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Fragment fragment, Bundle bundle, boolean z10) {
        Fragment x02 = this.f3152b.x0();
        if (x02 != null) {
            x02.getParentFragmentManager().w0().a(fragment, bundle, true);
        }
        Iterator<a> it = this.f3151a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f3154b) {
                FragmentManager.k kVar = next.f3153a;
                throw null;
            }
            while (it.hasNext()) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(Fragment fragment, boolean z10) {
        this.f3152b.u0().f();
        Fragment x02 = this.f3152b.x0();
        if (x02 != null) {
            x02.getParentFragmentManager().w0().b(fragment, true);
        }
        Iterator<a> it = this.f3151a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f3154b) {
                FragmentManager.k kVar = next.f3153a;
                throw null;
            }
            while (it.hasNext()) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(Fragment fragment, Bundle bundle, boolean z10) {
        Fragment x02 = this.f3152b.x0();
        if (x02 != null) {
            x02.getParentFragmentManager().w0().c(fragment, bundle, true);
        }
        Iterator<a> it = this.f3151a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f3154b) {
                FragmentManager.k kVar = next.f3153a;
                throw null;
            }
            while (it.hasNext()) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(Fragment fragment, boolean z10) {
        Fragment x02 = this.f3152b.x0();
        if (x02 != null) {
            x02.getParentFragmentManager().w0().d(fragment, true);
        }
        Iterator<a> it = this.f3151a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f3154b) {
                FragmentManager.k kVar = next.f3153a;
                throw null;
            }
            while (it.hasNext()) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(Fragment fragment, boolean z10) {
        Fragment x02 = this.f3152b.x0();
        if (x02 != null) {
            x02.getParentFragmentManager().w0().e(fragment, true);
        }
        Iterator<a> it = this.f3151a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f3154b) {
                FragmentManager.k kVar = next.f3153a;
                throw null;
            }
            while (it.hasNext()) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(Fragment fragment, boolean z10) {
        Fragment x02 = this.f3152b.x0();
        if (x02 != null) {
            x02.getParentFragmentManager().w0().f(fragment, true);
        }
        Iterator<a> it = this.f3151a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f3154b) {
                FragmentManager.k kVar = next.f3153a;
                throw null;
            }
            while (it.hasNext()) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(Fragment fragment, boolean z10) {
        this.f3152b.u0().f();
        Fragment x02 = this.f3152b.x0();
        if (x02 != null) {
            x02.getParentFragmentManager().w0().g(fragment, true);
        }
        Iterator<a> it = this.f3151a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f3154b) {
                FragmentManager.k kVar = next.f3153a;
                throw null;
            }
            while (it.hasNext()) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h(Fragment fragment, Bundle bundle, boolean z10) {
        Fragment x02 = this.f3152b.x0();
        if (x02 != null) {
            x02.getParentFragmentManager().w0().h(fragment, bundle, true);
        }
        Iterator<a> it = this.f3151a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f3154b) {
                FragmentManager.k kVar = next.f3153a;
                throw null;
            }
            while (it.hasNext()) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void i(Fragment fragment, boolean z10) {
        Fragment x02 = this.f3152b.x0();
        if (x02 != null) {
            x02.getParentFragmentManager().w0().i(fragment, true);
        }
        Iterator<a> it = this.f3151a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f3154b) {
                FragmentManager.k kVar = next.f3153a;
                throw null;
            }
            while (it.hasNext()) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void j(Fragment fragment, Bundle bundle, boolean z10) {
        Fragment x02 = this.f3152b.x0();
        if (x02 != null) {
            x02.getParentFragmentManager().w0().j(fragment, bundle, true);
        }
        Iterator<a> it = this.f3151a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f3154b) {
                FragmentManager.k kVar = next.f3153a;
                throw null;
            }
            while (it.hasNext()) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void k(Fragment fragment, boolean z10) {
        Fragment x02 = this.f3152b.x0();
        if (x02 != null) {
            x02.getParentFragmentManager().w0().k(fragment, true);
        }
        Iterator<a> it = this.f3151a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f3154b) {
                FragmentManager.k kVar = next.f3153a;
                throw null;
            }
            while (it.hasNext()) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l(Fragment fragment, boolean z10) {
        Fragment x02 = this.f3152b.x0();
        if (x02 != null) {
            x02.getParentFragmentManager().w0().l(fragment, true);
        }
        Iterator<a> it = this.f3151a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f3154b) {
                FragmentManager.k kVar = next.f3153a;
                throw null;
            }
            while (it.hasNext()) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m(Fragment fragment, View view, Bundle bundle, boolean z10) {
        Fragment x02 = this.f3152b.x0();
        if (x02 != null) {
            x02.getParentFragmentManager().w0().m(fragment, view, bundle, true);
        }
        Iterator<a> it = this.f3151a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f3154b) {
                FragmentManager.k kVar = next.f3153a;
                throw null;
            }
            while (it.hasNext()) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n(Fragment fragment, boolean z10) {
        Fragment x02 = this.f3152b.x0();
        if (x02 != null) {
            x02.getParentFragmentManager().w0().n(fragment, true);
        }
        Iterator<a> it = this.f3151a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z10 || next.f3154b) {
                FragmentManager.k kVar = next.f3153a;
                throw null;
            }
            while (it.hasNext()) {
            }
        }
    }
}
