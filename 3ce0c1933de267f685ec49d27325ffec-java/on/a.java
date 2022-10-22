package on;

import android.content.Context;
import java.util.Set;
import mn.b;
import tn.c;
/* compiled from: FragmentGetContextFix.java */
/* loaded from: classes2.dex */
public final class a {

    /* compiled from: FragmentGetContextFix.java */
    /* renamed from: on.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface AbstractC0446a {
        Set<Boolean> c();
    }

    public static boolean a(Context context) {
        Set<Boolean> c10 = ((AbstractC0446a) b.a(context, AbstractC0446a.class)).c();
        c.c(c10.size() <= 1, "Cannot bind the flag @DisableFragmentGetContextFix more than once.", new Object[0]);
        if (c10.isEmpty()) {
            return true;
        }
        return c10.iterator().next().booleanValue();
    }
}
