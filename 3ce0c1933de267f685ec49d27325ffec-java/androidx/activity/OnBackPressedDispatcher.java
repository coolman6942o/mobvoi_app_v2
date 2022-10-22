package androidx.activity;

import android.annotation.SuppressLint;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.n;
import androidx.lifecycle.p;
import java.util.ArrayDeque;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f308a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayDeque<e> f309b = new ArrayDeque<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class LifecycleOnBackPressedCancellable implements n, androidx.activity.a {

        /* renamed from: a  reason: collision with root package name */
        private final Lifecycle f310a;

        /* renamed from: b  reason: collision with root package name */
        private final e f311b;

        /* renamed from: c  reason: collision with root package name */
        private androidx.activity.a f312c;

        LifecycleOnBackPressedCancellable(Lifecycle lifecycle, e eVar) {
            this.f310a = lifecycle;
            this.f311b = eVar;
            lifecycle.a(this);
        }

        @Override // androidx.lifecycle.n
        public void c(p pVar, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_START) {
                this.f312c = OnBackPressedDispatcher.this.b(this.f311b);
            } else if (event == Lifecycle.Event.ON_STOP) {
                androidx.activity.a aVar = this.f312c;
                if (aVar != null) {
                    aVar.cancel();
                }
            } else if (event == Lifecycle.Event.ON_DESTROY) {
                cancel();
            }
        }

        @Override // androidx.activity.a
        public void cancel() {
            this.f310a.c(this);
            this.f311b.e(this);
            androidx.activity.a aVar = this.f312c;
            if (aVar != null) {
                aVar.cancel();
                this.f312c = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements androidx.activity.a {

        /* renamed from: a  reason: collision with root package name */
        private final e f314a;

        a(e eVar) {
            this.f314a = eVar;
        }

        @Override // androidx.activity.a
        public void cancel() {
            OnBackPressedDispatcher.this.f309b.remove(this.f314a);
            this.f314a.e(this);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f308a = runnable;
    }

    @SuppressLint({"LambdaLast"})
    public void a(p pVar, e eVar) {
        Lifecycle lifecycle = pVar.getLifecycle();
        if (lifecycle.b() != Lifecycle.State.DESTROYED) {
            eVar.a(new LifecycleOnBackPressedCancellable(lifecycle, eVar));
        }
    }

    androidx.activity.a b(e eVar) {
        this.f309b.add(eVar);
        a aVar = new a(eVar);
        eVar.a(aVar);
        return aVar;
    }

    public void c() {
        Iterator<e> descendingIterator = this.f309b.descendingIterator();
        while (descendingIterator.hasNext()) {
            e next = descendingIterator.next();
            if (next.c()) {
                next.b();
                return;
            }
        }
        Runnable runnable = this.f308a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
