package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import v0.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentLayoutInflaterFactory.java */
/* loaded from: classes.dex */
public class l implements LayoutInflater.Factory2 {

    /* renamed from: a  reason: collision with root package name */
    final FragmentManager f3148a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentLayoutInflaterFactory.java */
    /* loaded from: classes.dex */
    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f3149a;

        a(t tVar) {
            this.f3149a = tVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Fragment k10 = this.f3149a.k();
            this.f3149a.m();
            d0.n((ViewGroup) k10.mView.getParent(), l.this.f3148a).j();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FragmentManager fragmentManager) {
        this.f3148a = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        t tVar;
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.f3148a);
        }
        Fragment fragment = null;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.f35563a);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(c.f35564b);
        }
        int resourceId = obtainStyledAttributes.getResourceId(c.f35565c, -1);
        String string = obtainStyledAttributes.getString(c.f35566d);
        obtainStyledAttributes.recycle();
        if (attributeValue == null || !j.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id2 = view != null ? view.getId() : 0;
        if (id2 == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        if (resourceId != -1) {
            fragment = this.f3148a.f0(resourceId);
        }
        if (fragment == null && string != null) {
            fragment = this.f3148a.g0(string);
        }
        if (fragment == null && id2 != -1) {
            fragment = this.f3148a.f0(id2);
        }
        if (fragment == null) {
            fragment = this.f3148a.s0().a(context.getClassLoader(), attributeValue);
            fragment.mFromLayout = true;
            fragment.mFragmentId = resourceId != 0 ? resourceId : id2;
            fragment.mContainerId = id2;
            fragment.mTag = string;
            fragment.mInLayout = true;
            FragmentManager fragmentManager = this.f3148a;
            fragment.mFragmentManager = fragmentManager;
            fragment.mHost = fragmentManager.u0();
            fragment.onInflate(this.f3148a.u0().f(), attributeSet, fragment.mSavedFragmentState);
            tVar = this.f3148a.f(fragment);
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Fragment " + fragment + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else if (!fragment.mInLayout) {
            fragment.mInLayout = true;
            FragmentManager fragmentManager2 = this.f3148a;
            fragment.mFragmentManager = fragmentManager2;
            fragment.mHost = fragmentManager2.u0();
            fragment.onInflate(this.f3148a.u0().f(), attributeSet, fragment.mSavedFragmentState);
            tVar = this.f3148a.t(fragment);
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Retained Fragment " + fragment + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id2) + " with another fragment for " + attributeValue);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        FragmentStrictMode.i(fragment, viewGroup);
        fragment.mContainer = viewGroup;
        tVar.m();
        tVar.j();
        View view2 = fragment.mView;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (fragment.mView.getTag() == null) {
                fragment.mView.setTag(string);
            }
            fragment.mView.addOnAttachStateChangeListener(new a(tVar));
            return fragment.mView;
        }
        throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
    }
}
