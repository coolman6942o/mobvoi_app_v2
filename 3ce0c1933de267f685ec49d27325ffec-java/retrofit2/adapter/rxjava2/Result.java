package retrofit2.adapter.rxjava2;

import java.util.Objects;
import retrofit2.Response;
/* loaded from: classes3.dex */
public final class Result<T> {
    private final Throwable error;
    private final Response<T> response;

    private Result(Response<T> response, Throwable th2) {
        this.response = response;
        this.error = th2;
    }

    public static <T> Result<T> error(Throwable th2) {
        Objects.requireNonNull(th2, "error == null");
        return new Result<>(null, th2);
    }

    public static <T> Result<T> response(Response<T> response) {
        Objects.requireNonNull(response, "response == null");
        return new Result<>(response, null);
    }

    public boolean isError() {
        return this.error != null;
    }

    public Throwable error() {
        return this.error;
    }

    public Response<T> response() {
        return this.response;
    }
}
