package e7;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import androidx.collection.f;
import java.util.ArrayList;
import java.util.List;
/* compiled from: MotionSpec.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private final f<String, i> f25846a = new f<>();

    /* renamed from: b  reason: collision with root package name */
    private final f<String, PropertyValuesHolder[]> f25847b = new f<>();

    private static void a(h hVar, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            hVar.h(objectAnimator.getPropertyName(), objectAnimator.getValues());
            hVar.i(objectAnimator.getPropertyName(), i.b(objectAnimator));
            return;
        }
        throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
    }

    public static h b(Context context, TypedArray typedArray, int i10) {
        int resourceId;
        if (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0) {
            return null;
        }
        return c(context, resourceId);
    }

    public static h c(Context context, int i10) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i10);
            if (loadAnimator instanceof AnimatorSet) {
                return d(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(loadAnimator);
            return d(arrayList);
        } catch (Exception e10) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i10), e10);
            return null;
        }
    }

    private static h d(List<Animator> list) {
        h hVar = new h();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            a(hVar, list.get(i10));
        }
        return hVar;
    }

    public i e(String str) {
        if (g(str)) {
            return this.f25846a.get(str);
        }
        throw new IllegalArgumentException();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        return this.f25846a.equals(((h) obj).f25846a);
    }

    public long f() {
        int size = this.f25846a.size();
        long j10 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            i n10 = this.f25846a.n(i10);
            j10 = Math.max(j10, n10.c() + n10.d());
        }
        return j10;
    }

    public boolean g(String str) {
        return this.f25846a.get(str) != null;
    }

    public void h(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.f25847b.put(str, propertyValuesHolderArr);
    }

    public int hashCode() {
        return this.f25846a.hashCode();
    }

    public void i(String str, i iVar) {
        this.f25846a.put(str, iVar);
    }

    public String toString() {
        return '\n' + h.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f25846a + "}\n";
    }
}
