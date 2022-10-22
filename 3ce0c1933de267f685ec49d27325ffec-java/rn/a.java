package rn;

import android.app.Application;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.c0;
import androidx.lifecycle.h0;
import java.util.Set;
import qn.e;
/* compiled from: DefaultViewModelFactories.java */
/* loaded from: classes2.dex */
public final class a {

    /* compiled from: DefaultViewModelFactories.java */
    /* renamed from: rn.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface AbstractC0464a {
        c a();
    }

    /* compiled from: DefaultViewModelFactories.java */
    /* loaded from: classes2.dex */
    public interface b {
        c a();
    }

    /* compiled from: DefaultViewModelFactories.java */
    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final Application f33644a;

        /* renamed from: b  reason: collision with root package name */
        private final Set<String> f33645b;

        /* renamed from: c  reason: collision with root package name */
        private final e f33646c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(Application application, Set<String> set, e eVar) {
            this.f33644a = application;
            this.f33645b = set;
            this.f33646c = eVar;
        }

        private h0.b c(androidx.savedstate.c cVar, Bundle bundle, h0.b bVar) {
            if (bVar == null) {
                bVar = new c0(this.f33644a, cVar, bundle);
            }
            return new rn.c(cVar, bundle, this.f33645b, bVar, this.f33646c);
        }

        h0.b a(ComponentActivity componentActivity, h0.b bVar) {
            return c(componentActivity, componentActivity.getIntent() != null ? componentActivity.getIntent().getExtras() : null, bVar);
        }

        h0.b b(Fragment fragment, h0.b bVar) {
            return c(fragment, fragment.getArguments(), bVar);
        }
    }

    public static h0.b a(ComponentActivity componentActivity, h0.b bVar) {
        return ((AbstractC0464a) ln.a.a(componentActivity, AbstractC0464a.class)).a().a(componentActivity, bVar);
    }

    public static h0.b b(Fragment fragment, h0.b bVar) {
        return ((b) ln.a.a(fragment, b.class)).a().b(fragment, bVar);
    }
}
