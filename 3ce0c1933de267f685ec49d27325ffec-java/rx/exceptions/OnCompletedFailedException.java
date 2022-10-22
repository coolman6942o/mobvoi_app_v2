package rx.exceptions;
/* loaded from: classes3.dex */
public final class OnCompletedFailedException extends RuntimeException {
    private static final long serialVersionUID = 8622579378868820554L;

    public OnCompletedFailedException(Throwable th2) {
        super(th2 == null ? new NullPointerException() : th2);
    }

    public OnCompletedFailedException(String str, Throwable th2) {
        super(str, th2 == null ? new NullPointerException() : th2);
    }
}
