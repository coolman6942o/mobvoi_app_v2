package kotlin.text;

import kotlin.jvm.internal.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Appendable.kt */
/* loaded from: classes3.dex */
public class l {
    public static <T> void a(Appendable appendElement, T t10, qo.l<? super T, ? extends CharSequence> lVar) {
        i.f(appendElement, "$this$appendElement");
        if (lVar != null) {
            appendElement.append(lVar.invoke(t10));
            return;
        }
        if (t10 != null ? t10 instanceof CharSequence : true) {
            appendElement.append((CharSequence) t10);
        } else if (t10 instanceof Character) {
            appendElement.append(((Character) t10).charValue());
        } else {
            appendElement.append(String.valueOf(t10));
        }
    }
}
