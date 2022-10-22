package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.mobvoi.wear.lpa.LpaConstants;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentStore.java */
/* loaded from: classes.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Fragment> f3189a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, t> f3190b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, FragmentState> f3191c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private p f3192d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(p pVar) {
        this.f3192d = pVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentState B(String str, FragmentState fragmentState) {
        if (fragmentState != null) {
            return this.f3191c.put(str, fragmentState);
        }
        return this.f3191c.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment) {
        if (!this.f3189a.contains(fragment)) {
            synchronized (this.f3189a) {
                this.f3189a.add(fragment);
            }
            fragment.mAdded = true;
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f3190b.values().removeAll(Collections.singleton(null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(String str) {
        return this.f3190b.get(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i10) {
        for (t tVar : this.f3190b.values()) {
            if (tVar != null) {
                tVar.u(i10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f3190b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (t tVar : this.f3190b.values()) {
                printWriter.print(str);
                if (tVar != null) {
                    Fragment k10 = tVar.k();
                    printWriter.println(k10);
                    k10.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println(LpaConstants.VALUE_NULL);
                }
            }
        }
        int size = this.f3189a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i10 = 0; i10 < size; i10++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(this.f3189a.get(i10).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment f(String str) {
        t tVar = this.f3190b.get(str);
        if (tVar != null) {
            return tVar.k();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment g(int i10) {
        for (int size = this.f3189a.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f3189a.get(size);
            if (fragment != null && fragment.mFragmentId == i10) {
                return fragment;
            }
        }
        for (t tVar : this.f3190b.values()) {
            if (tVar != null) {
                Fragment k10 = tVar.k();
                if (k10.mFragmentId == i10) {
                    return k10;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment h(String str) {
        if (str != null) {
            for (int size = this.f3189a.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f3189a.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (t tVar : this.f3190b.values()) {
            if (tVar != null) {
                Fragment k10 = tVar.k();
                if (str.equals(k10.mTag)) {
                    return k10;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment i(String str) {
        Fragment findFragmentByWho;
        for (t tVar : this.f3190b.values()) {
            if (!(tVar == null || (findFragmentByWho = tVar.k().findFragmentByWho(str)) == null)) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j(Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            return -1;
        }
        int indexOf = this.f3189a.indexOf(fragment);
        for (int i10 = indexOf - 1; i10 >= 0; i10--) {
            Fragment fragment2 = this.f3189a.get(i10);
            if (fragment2.mContainer == viewGroup && (view2 = fragment2.mView) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            indexOf++;
            if (indexOf >= this.f3189a.size()) {
                return -1;
            }
            Fragment fragment3 = this.f3189a.get(indexOf);
            if (fragment3.mContainer == viewGroup && (view = fragment3.mView) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<t> k() {
        ArrayList arrayList = new ArrayList();
        for (t tVar : this.f3190b.values()) {
            if (tVar != null) {
                arrayList.add(tVar);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Fragment> l() {
        ArrayList arrayList = new ArrayList();
        for (t tVar : this.f3190b.values()) {
            if (tVar != null) {
                arrayList.add(tVar.k());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<FragmentState> m() {
        return new ArrayList<>(this.f3191c.values());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t n(String str) {
        return this.f3190b.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Fragment> o() {
        ArrayList arrayList;
        if (this.f3189a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f3189a) {
            arrayList = new ArrayList(this.f3189a);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p p() {
        return this.f3192d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentState q(String str) {
        return this.f3191c.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(t tVar) {
        Fragment k10 = tVar.k();
        if (!c(k10.mWho)) {
            this.f3190b.put(k10.mWho, tVar);
            if (k10.mRetainInstanceChangedWhileDetached) {
                if (k10.mRetainInstance) {
                    this.f3192d.a(k10);
                } else {
                    this.f3192d.k(k10);
                }
                k10.mRetainInstanceChangedWhileDetached = false;
            }
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Added fragment to active set " + k10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(t tVar) {
        Fragment k10 = tVar.k();
        if (k10.mRetainInstance) {
            this.f3192d.k(k10);
        }
        if (this.f3190b.put(k10.mWho, null) != null && FragmentManager.H0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + k10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t() {
        Iterator<Fragment> it = this.f3189a.iterator();
        while (it.hasNext()) {
            t tVar = this.f3190b.get(it.next().mWho);
            if (tVar != null) {
                tVar.m();
            }
        }
        for (t tVar2 : this.f3190b.values()) {
            if (tVar2 != null) {
                tVar2.m();
                Fragment k10 = tVar2.k();
                if (k10.mRemoving && !k10.isInBackStack()) {
                    if (k10.mBeingSaved && !this.f3191c.containsKey(k10.mWho)) {
                        tVar2.s();
                    }
                    s(tVar2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(Fragment fragment) {
        synchronized (this.f3189a) {
            this.f3189a.remove(fragment);
        }
        fragment.mAdded = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v() {
        this.f3190b.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(List<String> list) {
        this.f3189a.clear();
        if (list != null) {
            for (String str : list) {
                Fragment f10 = f(str);
                if (f10 != null) {
                    if (FragmentManager.H0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + f10);
                    }
                    a(f10);
                } else {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(ArrayList<FragmentState> arrayList) {
        this.f3191c.clear();
        Iterator<FragmentState> it = arrayList.iterator();
        while (it.hasNext()) {
            FragmentState next = it.next();
            this.f3191c.put(next.f3028b, next);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<String> y() {
        ArrayList<String> arrayList = new ArrayList<>(this.f3190b.size());
        for (t tVar : this.f3190b.values()) {
            if (tVar != null) {
                Fragment k10 = tVar.k();
                tVar.s();
                arrayList.add(k10.mWho);
                if (FragmentManager.H0(2)) {
                    Log.v("FragmentManager", "Saved state of " + k10 + ": " + k10.mSavedFragmentState);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<String> z() {
        synchronized (this.f3189a) {
            if (this.f3189a.isEmpty()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(this.f3189a.size());
            Iterator<Fragment> it = this.f3189a.iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                arrayList.add(next.mWho);
                if (FragmentManager.H0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + next.mWho + "): " + next);
                }
            }
            return arrayList;
        }
    }
}
