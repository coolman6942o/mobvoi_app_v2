package no.nordicsemi.android.dfu.internal.exception;
/* loaded from: classes3.dex */
public class RemoteDfuException extends Exception {
    private static final long serialVersionUID = -6901728550661937942L;
    private final int mState;

    public RemoteDfuException(String str, int i10) {
        super(str);
        this.mState = i10;
    }

    public int getErrorNumber() {
        return this.mState;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return super.getMessage() + " (error " + this.mState + ")";
    }
}
