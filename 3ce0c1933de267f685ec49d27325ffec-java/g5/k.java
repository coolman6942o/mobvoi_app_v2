package g5;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.c;
import com.bumptech.glide.h;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* compiled from: RequestManagerFragment.java */
@Deprecated
/* loaded from: classes.dex */
public class k extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private final g5.a f27269a;

    /* renamed from: b  reason: collision with root package name */
    private final m f27270b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<k> f27271c;

    /* renamed from: d  reason: collision with root package name */
    private h f27272d;

    /* renamed from: e  reason: collision with root package name */
    private k f27273e;

    /* renamed from: f  reason: collision with root package name */
    private Fragment f27274f;

    /* compiled from: RequestManagerFragment.java */
    /* loaded from: classes.dex */
    private class a implements m {
        a() {
        }

        @Override // g5.m
        public Set<h> a() {
            Set<k> b10 = k.this.b();
            HashSet hashSet = new HashSet(b10.size());
            for (k kVar : b10) {
                if (kVar.e() != null) {
                    hashSet.add(kVar.e());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + k.this + "}";
        }
    }

    public k() {
        this(new g5.a());
    }

    private void a(k kVar) {
        this.f27271c.add(kVar);
    }

    @TargetApi(17)
    private Fragment d() {
        Fragment parentFragment = Build.VERSION.SDK_INT >= 17 ? getParentFragment() : null;
        return parentFragment != null ? parentFragment : this.f27274f;
    }

    @TargetApi(17)
    private boolean g(Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private void h(Activity activity) {
        l();
        k i10 = c.c(activity).k().i(activity);
        this.f27273e = i10;
        if (!equals(i10)) {
            this.f27273e.a(this);
        }
    }

    private void i(k kVar) {
        this.f27271c.remove(kVar);
    }

    private void l() {
        k kVar = this.f27273e;
        if (kVar != null) {
            kVar.i(this);
            this.f27273e = null;
        }
    }

    @TargetApi(17)
    Set<k> b() {
        if (equals(this.f27273e)) {
            return Collections.unmodifiableSet(this.f27271c);
        }
        if (this.f27273e == null || Build.VERSION.SDK_INT < 17) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (k kVar : this.f27273e.b()) {
            if (g(kVar.getParentFragment())) {
                hashSet.add(kVar);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g5.a c() {
        return this.f27269a;
    }

    public h e() {
        return this.f27272d;
    }

    public m f() {
        return this.f27270b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(Fragment fragment) {
        this.f27274f = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            h(fragment.getActivity());
        }
    }

    public void k(h hVar) {
        this.f27272d = hVar;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            h(activity);
        } catch (IllegalStateException e10) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e10);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f27269a.c();
        l();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        l();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f27269a.d();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f27269a.e();
    }

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + d() + "}";
    }

    @SuppressLint({"ValidFragment"})
    k(g5.a aVar) {
        this.f27270b = new a();
        this.f27271c = new HashSet();
        this.f27269a = aVar;
    }
}
