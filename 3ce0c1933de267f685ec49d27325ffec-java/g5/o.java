package g5;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.c;
import com.bumptech.glide.h;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* compiled from: SupportRequestManagerFragment.java */
/* loaded from: classes.dex */
public class o extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private final g5.a f27285a;

    /* renamed from: b  reason: collision with root package name */
    private final m f27286b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<o> f27287c;

    /* renamed from: d  reason: collision with root package name */
    private o f27288d;

    /* renamed from: e  reason: collision with root package name */
    private h f27289e;

    /* renamed from: f  reason: collision with root package name */
    private Fragment f27290f;

    /* compiled from: SupportRequestManagerFragment.java */
    /* loaded from: classes.dex */
    private class a implements m {
        a() {
        }

        @Override // g5.m
        public Set<h> a() {
            Set<o> Z = o.this.Z();
            HashSet hashSet = new HashSet(Z.size());
            for (o oVar : Z) {
                if (oVar.c0() != null) {
                    hashSet.add(oVar.c0());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + o.this + "}";
        }
    }

    public o() {
        this(new g5.a());
    }

    private void Y(o oVar) {
        this.f27287c.add(oVar);
    }

    private Fragment b0() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f27290f;
    }

    private static FragmentManager e0(Fragment fragment) {
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment.getFragmentManager();
    }

    private boolean f0(Fragment fragment) {
        Fragment b02 = b0();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                return false;
            }
            if (parentFragment.equals(b02)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private void g0(Context context, FragmentManager fragmentManager) {
        k0();
        o k10 = c.c(context).k().k(context, fragmentManager);
        this.f27288d = k10;
        if (!equals(k10)) {
            this.f27288d.Y(this);
        }
    }

    private void h0(o oVar) {
        this.f27287c.remove(oVar);
    }

    private void k0() {
        o oVar = this.f27288d;
        if (oVar != null) {
            oVar.h0(this);
            this.f27288d = null;
        }
    }

    Set<o> Z() {
        o oVar = this.f27288d;
        if (oVar == null) {
            return Collections.emptySet();
        }
        if (equals(oVar)) {
            return Collections.unmodifiableSet(this.f27287c);
        }
        HashSet hashSet = new HashSet();
        for (o oVar2 : this.f27288d.Z()) {
            if (f0(oVar2.b0())) {
                hashSet.add(oVar2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g5.a a0() {
        return this.f27285a;
    }

    public h c0() {
        return this.f27289e;
    }

    public m d0() {
        return this.f27286b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i0(Fragment fragment) {
        FragmentManager e02;
        this.f27290f = fragment;
        if (fragment != null && fragment.getContext() != null && (e02 = e0(fragment)) != null) {
            g0(fragment.getContext(), e02);
        }
    }

    public void j0(h hVar) {
        this.f27289e = hVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        FragmentManager e02 = e0(this);
        if (e02 != null) {
            try {
                g0(getContext(), e02);
            } catch (IllegalStateException e10) {
                if (Log.isLoggable("SupportRMFragment", 5)) {
                    Log.w("SupportRMFragment", "Unable to register fragment with root", e10);
                }
            }
        } else if (Log.isLoggable("SupportRMFragment", 5)) {
            Log.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f27285a.c();
        k0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f27290f = null;
        k0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f27285a.d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f27285a.e();
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + b0() + "}";
    }

    @SuppressLint({"ValidFragment"})
    public o(g5.a aVar) {
        this.f27286b = new a();
        this.f27287c = new HashSet();
        this.f27285a = aVar;
    }
}
