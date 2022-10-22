package j0;

import com.mobvoi.wear.lpa.LpaConstants;
/* compiled from: DebugUtils.java */
/* loaded from: classes.dex */
public class b {
    public static void a(Object obj, StringBuilder sb2) {
        int lastIndexOf;
        if (obj == null) {
            sb2.append(LpaConstants.VALUE_NULL);
            return;
        }
        String simpleName = obj.getClass().getSimpleName();
        if (simpleName.length() <= 0 && (lastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
            simpleName = simpleName.substring(lastIndexOf + 1);
        }
        sb2.append(simpleName);
        sb2.append('{');
        sb2.append(Integer.toHexString(System.identityHashCode(obj)));
    }
}
