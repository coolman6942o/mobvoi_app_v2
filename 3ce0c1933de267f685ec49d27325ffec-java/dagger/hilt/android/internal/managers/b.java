package dagger.hilt.android.internal.managers;

import android.content.Context;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.f0;
import androidx.lifecycle.h0;
import androidx.lifecycle.j0;
import java.util.HashSet;
import java.util.Set;
import mn.a;
/* compiled from: ActivityRetainedComponentManager.java */
/* loaded from: classes2.dex */
final class b implements tn.b<nn.b> {

    /* renamed from: a  reason: collision with root package name */
    private final h0 f25586a;

    /* renamed from: b  reason: collision with root package name */
    private volatile nn.b f25587b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f25588c = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActivityRetainedComponentManager.java */
    /* loaded from: classes2.dex */
    public class a implements h0.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f25589a;

        a(b bVar, Context context) {
            this.f25589a = context;
        }

        @Override // androidx.lifecycle.h0.b
        public <T extends f0> T a(Class<T> cls) {
            return new c(((AbstractC0272b) mn.b.a(this.f25589a, AbstractC0272b.class)).d().build());
        }
    }

    /* compiled from: ActivityRetainedComponentManager.java */
    /* renamed from: dagger.hilt.android.internal.managers.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface AbstractC0272b {
        qn.b d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActivityRetainedComponentManager.java */
    /* loaded from: classes2.dex */
    public static final class c extends f0 {

        /* renamed from: a  reason: collision with root package name */
        private final nn.b f25590a;

        c(nn.b bVar) {
            this.f25590a = bVar;
        }

        nn.b a() {
            return this.f25590a;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.lifecycle.f0
        public void onCleared() {
            super.onCleared();
            ((e) ((d) ln.a.a(this.f25590a, d.class)).a()).a();
        }
    }

    /* compiled from: ActivityRetainedComponentManager.java */
    /* loaded from: classes2.dex */
    public interface d {
        mn.a a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActivityRetainedComponentManager.java */
    /* loaded from: classes2.dex */
    public static final class e implements mn.a {

        /* renamed from: a  reason: collision with root package name */
        private final Set<a.AbstractC0400a> f25591a = new HashSet();

        void a() {
            pn.b.a();
            for (a.AbstractC0400a aVar : this.f25591a) {
                aVar.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ComponentActivity componentActivity) {
        this.f25586a = c(componentActivity, componentActivity);
    }

    private nn.b a() {
        return ((c) this.f25586a.a(c.class)).a();
    }

    private h0 c(j0 j0Var, Context context) {
        return new h0(j0Var, new a(this, context));
    }

    /* renamed from: b */
    public nn.b h() {
        if (this.f25587b == null) {
            synchronized (this.f25588c) {
                if (this.f25587b == null) {
                    this.f25587b = a();
                }
            }
        }
        return this.f25587b;
    }
}
