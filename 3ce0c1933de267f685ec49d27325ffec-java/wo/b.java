package wo;

import java.util.List;
import java.util.Map;
import kotlin.reflect.KVisibility;
/* compiled from: KCallable.kt */
/* loaded from: classes3.dex */
public interface b<R> extends a {
    R call(Object... objArr);

    R callBy(Map<Object, ? extends Object> map);

    List<Object> getParameters();

    n getReturnType();

    List<Object> getTypeParameters();

    KVisibility getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
