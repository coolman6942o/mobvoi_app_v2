package org.greenrobot.eventbus;
/* loaded from: classes3.dex */
public class EventBusException extends RuntimeException {
    private static final long serialVersionUID = -2912559384646531479L;

    public EventBusException(String str) {
        super(str);
    }

    public EventBusException(Throwable th2) {
        super(th2);
    }

    public EventBusException(String str, Throwable th2) {
        super(str, th2);
    }
}
