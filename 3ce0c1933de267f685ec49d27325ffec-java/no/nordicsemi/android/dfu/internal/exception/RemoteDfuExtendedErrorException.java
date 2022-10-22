package no.nordicsemi.android.dfu.internal.exception;
/* loaded from: classes3.dex */
public class RemoteDfuExtendedErrorException extends RemoteDfuException {
    private static final long serialVersionUID = -6901728550661937942L;
    private final int mError;

    public RemoteDfuExtendedErrorException(String str, int i10) {
        super(str, 11);
        this.mError = i10;
    }

    public int getExtendedErrorNumber() {
        return this.mError;
    }

    @Override // no.nordicsemi.android.dfu.internal.exception.RemoteDfuException, java.lang.Throwable
    public String getMessage() {
        return super.getMessage() + " (extended error " + this.mError + ")";
    }
}
