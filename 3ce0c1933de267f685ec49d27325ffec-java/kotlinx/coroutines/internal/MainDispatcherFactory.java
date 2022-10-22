package kotlinx.coroutines.internal;

import java.util.List;
import kotlinx.coroutines.s1;
/* compiled from: MainDispatcherFactory.kt */
/* loaded from: classes3.dex */
public interface MainDispatcherFactory {
    s1 createDispatcher(List<? extends MainDispatcherFactory> list);

    int getLoadPriority();

    String hintOnError();
}
