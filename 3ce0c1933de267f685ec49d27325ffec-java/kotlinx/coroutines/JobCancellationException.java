package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.i;
/* compiled from: Exceptions.kt */
/* loaded from: classes3.dex */
public final class JobCancellationException extends CancellationException implements e0<JobCancellationException> {
    public final j1 job;

    public JobCancellationException(String str, Throwable th2, j1 j1Var) {
        super(str);
        this.job = j1Var;
        if (th2 != null) {
            initCause(th2);
        }
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof JobCancellationException) {
                JobCancellationException jobCancellationException = (JobCancellationException) obj;
                if (!i.b(jobCancellationException.getMessage(), getMessage()) || !i.b(jobCancellationException.job, this.job) || !i.b(jobCancellationException.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        if (n0.c()) {
            return super.fillInStackTrace();
        }
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        i.d(message);
        int hashCode = ((message.hashCode() * 31) + this.job.hashCode()) * 31;
        Throwable cause = getCause();
        return hashCode + (cause == null ? 0 : cause.hashCode());
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.job;
    }

    @Override // kotlinx.coroutines.e0
    public JobCancellationException createCopy() {
        if (!n0.c()) {
            return null;
        }
        String message = getMessage();
        i.d(message);
        return new JobCancellationException(message, this, this.job);
    }
}
