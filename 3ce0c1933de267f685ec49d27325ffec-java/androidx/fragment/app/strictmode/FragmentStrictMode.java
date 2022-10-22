package androidx.fragment.app.strictmode;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.d0;
import kotlin.collections.i0;
import kotlin.collections.u;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: FragmentStrictMode.kt */
/* loaded from: classes.dex */
public final class FragmentStrictMode {

    /* renamed from: a  reason: collision with root package name */
    public static final FragmentStrictMode f3169a = new FragmentStrictMode();

    /* renamed from: b  reason: collision with root package name */
    private static b f3170b = b.f3171d;

    /* compiled from: FragmentStrictMode.kt */
    /* loaded from: classes.dex */
    public enum Flag {
        PENALTY_LOG,
        PENALTY_DEATH,
        DETECT_FRAGMENT_REUSE,
        DETECT_FRAGMENT_TAG_USAGE,
        DETECT_RETAIN_INSTANCE_USAGE,
        DETECT_SET_USER_VISIBLE_HINT,
        DETECT_TARGET_FRAGMENT_USAGE,
        DETECT_WRONG_FRAGMENT_CONTAINER
    }

    /* compiled from: FragmentStrictMode.kt */
    /* loaded from: classes.dex */
    public interface a {
        void a(Violation violation);
    }

    /* compiled from: FragmentStrictMode.kt */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: d  reason: collision with root package name */
        public static final b f3171d;

        /* renamed from: a  reason: collision with root package name */
        private final Set<Flag> f3172a;

        /* renamed from: b  reason: collision with root package name */
        private final a f3173b;

        /* renamed from: c  reason: collision with root package name */
        private final Map<Class<? extends Fragment>, Set<Class<? extends Violation>>> f3174c;

        /* compiled from: FragmentStrictMode.kt */
        /* loaded from: classes.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(f fVar) {
                this();
            }
        }

        static {
            Set b10;
            Map e10;
            new a(null);
            b10 = i0.b();
            e10 = d0.e();
            f3171d = new b(b10, null, e10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Set<? extends Flag> flags, a aVar, Map<Class<? extends Fragment>, ? extends Set<Class<? extends Violation>>> allowedViolations) {
            i.f(flags, "flags");
            i.f(allowedViolations, "allowedViolations");
            this.f3172a = flags;
            this.f3173b = aVar;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Class<? extends Fragment>, ? extends Set<Class<? extends Violation>>> entry : allowedViolations.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
            this.f3174c = linkedHashMap;
        }

        public final Set<Flag> a() {
            return this.f3172a;
        }

        public final a b() {
            return this.f3173b;
        }

        public final Map<Class<? extends Fragment>, Set<Class<? extends Violation>>> c() {
            return this.f3174c;
        }
    }

    private FragmentStrictMode() {
    }

    private final b c(Fragment fragment) {
        while (fragment != null) {
            if (fragment.isAdded()) {
                FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
                i.e(parentFragmentManager, "declaringFragment.parentFragmentManager");
                if (parentFragmentManager.A0() != null) {
                    b A0 = parentFragmentManager.A0();
                    i.d(A0);
                    i.e(A0, "fragmentManager.strictModePolicy!!");
                    return A0;
                }
            }
            fragment = fragment.getParentFragment();
        }
        return f3170b;
    }

    private final void d(final b bVar, final Violation violation) {
        Fragment fragment = violation.getFragment();
        final String name = fragment.getClass().getName();
        if (bVar.a().contains(Flag.PENALTY_LOG)) {
            Log.d("FragmentStrictMode", i.n("Policy violation in ", name), violation);
        }
        if (bVar.b() != null) {
            q(fragment, new Runnable() { // from class: w0.a
                @Override // java.lang.Runnable
                public final void run() {
                    FragmentStrictMode.e(FragmentStrictMode.b.this, violation);
                }
            });
        }
        if (bVar.a().contains(Flag.PENALTY_DEATH)) {
            q(fragment, new Runnable() { // from class: w0.b
                @Override // java.lang.Runnable
                public final void run() {
                    FragmentStrictMode.f(name, violation);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(b policy, Violation violation) {
        i.f(policy, "$policy");
        i.f(violation, "$violation");
        policy.b().a(violation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String str, Violation violation) {
        i.f(violation, "$violation");
        Log.e("FragmentStrictMode", i.n("Policy violation with PENALTY_DEATH in ", str), violation);
        throw violation;
    }

    private final void g(Violation violation) {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", i.n("StrictMode violation in ", violation.getFragment().getClass().getName()), violation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void h(Fragment fragment, String previousFragmentId) {
        i.f(fragment, "fragment");
        i.f(previousFragmentId, "previousFragmentId");
        FragmentReuseViolation fragmentReuseViolation = new FragmentReuseViolation(fragment, previousFragmentId);
        FragmentStrictMode fragmentStrictMode = f3169a;
        fragmentStrictMode.g(fragmentReuseViolation);
        b c10 = fragmentStrictMode.c(fragment);
        if (c10.a().contains(Flag.DETECT_FRAGMENT_REUSE) && fragmentStrictMode.r(c10, fragment.getClass(), fragmentReuseViolation.getClass())) {
            fragmentStrictMode.d(c10, fragmentReuseViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void i(Fragment fragment, ViewGroup viewGroup) {
        i.f(fragment, "fragment");
        FragmentTagUsageViolation fragmentTagUsageViolation = new FragmentTagUsageViolation(fragment, viewGroup);
        FragmentStrictMode fragmentStrictMode = f3169a;
        fragmentStrictMode.g(fragmentTagUsageViolation);
        b c10 = fragmentStrictMode.c(fragment);
        if (c10.a().contains(Flag.DETECT_FRAGMENT_TAG_USAGE) && fragmentStrictMode.r(c10, fragment.getClass(), fragmentTagUsageViolation.getClass())) {
            fragmentStrictMode.d(c10, fragmentTagUsageViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void j(Fragment fragment) {
        i.f(fragment, "fragment");
        GetRetainInstanceUsageViolation getRetainInstanceUsageViolation = new GetRetainInstanceUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f3169a;
        fragmentStrictMode.g(getRetainInstanceUsageViolation);
        b c10 = fragmentStrictMode.c(fragment);
        if (c10.a().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && fragmentStrictMode.r(c10, fragment.getClass(), getRetainInstanceUsageViolation.getClass())) {
            fragmentStrictMode.d(c10, getRetainInstanceUsageViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void k(Fragment fragment) {
        i.f(fragment, "fragment");
        GetTargetFragmentRequestCodeUsageViolation getTargetFragmentRequestCodeUsageViolation = new GetTargetFragmentRequestCodeUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f3169a;
        fragmentStrictMode.g(getTargetFragmentRequestCodeUsageViolation);
        b c10 = fragmentStrictMode.c(fragment);
        if (c10.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.r(c10, fragment.getClass(), getTargetFragmentRequestCodeUsageViolation.getClass())) {
            fragmentStrictMode.d(c10, getTargetFragmentRequestCodeUsageViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void l(Fragment fragment) {
        i.f(fragment, "fragment");
        GetTargetFragmentUsageViolation getTargetFragmentUsageViolation = new GetTargetFragmentUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f3169a;
        fragmentStrictMode.g(getTargetFragmentUsageViolation);
        b c10 = fragmentStrictMode.c(fragment);
        if (c10.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.r(c10, fragment.getClass(), getTargetFragmentUsageViolation.getClass())) {
            fragmentStrictMode.d(c10, getTargetFragmentUsageViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void m(Fragment fragment) {
        i.f(fragment, "fragment");
        SetRetainInstanceUsageViolation setRetainInstanceUsageViolation = new SetRetainInstanceUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f3169a;
        fragmentStrictMode.g(setRetainInstanceUsageViolation);
        b c10 = fragmentStrictMode.c(fragment);
        if (c10.a().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && fragmentStrictMode.r(c10, fragment.getClass(), setRetainInstanceUsageViolation.getClass())) {
            fragmentStrictMode.d(c10, setRetainInstanceUsageViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void n(Fragment violatingFragment, Fragment targetFragment, int i10) {
        i.f(violatingFragment, "violatingFragment");
        i.f(targetFragment, "targetFragment");
        SetTargetFragmentUsageViolation setTargetFragmentUsageViolation = new SetTargetFragmentUsageViolation(violatingFragment, targetFragment, i10);
        FragmentStrictMode fragmentStrictMode = f3169a;
        fragmentStrictMode.g(setTargetFragmentUsageViolation);
        b c10 = fragmentStrictMode.c(violatingFragment);
        if (c10.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.r(c10, violatingFragment.getClass(), setTargetFragmentUsageViolation.getClass())) {
            fragmentStrictMode.d(c10, setTargetFragmentUsageViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void o(Fragment fragment, boolean z10) {
        i.f(fragment, "fragment");
        SetUserVisibleHintViolation setUserVisibleHintViolation = new SetUserVisibleHintViolation(fragment, z10);
        FragmentStrictMode fragmentStrictMode = f3169a;
        fragmentStrictMode.g(setUserVisibleHintViolation);
        b c10 = fragmentStrictMode.c(fragment);
        if (c10.a().contains(Flag.DETECT_SET_USER_VISIBLE_HINT) && fragmentStrictMode.r(c10, fragment.getClass(), setUserVisibleHintViolation.getClass())) {
            fragmentStrictMode.d(c10, setUserVisibleHintViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void p(Fragment fragment, ViewGroup container) {
        i.f(fragment, "fragment");
        i.f(container, "container");
        WrongFragmentContainerViolation wrongFragmentContainerViolation = new WrongFragmentContainerViolation(fragment, container);
        FragmentStrictMode fragmentStrictMode = f3169a;
        fragmentStrictMode.g(wrongFragmentContainerViolation);
        b c10 = fragmentStrictMode.c(fragment);
        if (c10.a().contains(Flag.DETECT_WRONG_FRAGMENT_CONTAINER) && fragmentStrictMode.r(c10, fragment.getClass(), wrongFragmentContainerViolation.getClass())) {
            fragmentStrictMode.d(c10, wrongFragmentContainerViolation);
        }
    }

    private final void q(Fragment fragment, Runnable runnable) {
        if (fragment.isAdded()) {
            Handler g10 = fragment.getParentFragmentManager().u0().g();
            i.e(g10, "fragment.parentFragmentManager.host.handler");
            if (i.b(g10.getLooper(), Looper.myLooper())) {
                runnable.run();
            } else {
                g10.post(runnable);
            }
        } else {
            runnable.run();
        }
    }

    private final boolean r(b bVar, Class<? extends Fragment> cls, Class<? extends Violation> cls2) {
        boolean C;
        Set<Class<? extends Violation>> set = bVar.c().get(cls);
        if (set == null) {
            return true;
        }
        if (!i.b(cls2.getSuperclass(), Violation.class)) {
            C = u.C(set, cls2.getSuperclass());
            if (C) {
                return false;
            }
        }
        return !set.contains(cls2);
    }
}
