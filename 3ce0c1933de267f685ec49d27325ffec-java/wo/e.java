package wo;

import io.c;
/* compiled from: KFunction.kt */
/* loaded from: classes3.dex */
public interface e<R> extends b<R>, c<R> {
    boolean isExternal();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    @Override // wo.b
    boolean isSuspend();
}
