package retrofit2;

import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.z;
/* loaded from: classes3.dex */
public final class Response<T> {
    private final T body;
    private final c0 errorBody;
    private final b0 rawResponse;

    private Response(b0 b0Var, T t10, c0 c0Var) {
        this.rawResponse = b0Var;
        this.body = t10;
        this.errorBody = c0Var;
    }

    public static <T> Response<T> error(int i10, c0 c0Var) {
        if (i10 >= 400) {
            return error(c0Var, new b0.a().g(i10).m("Response.error()").p(Protocol.HTTP_1_1).s(new z.a().p("http://localhost/").b()).c());
        }
        throw new IllegalArgumentException("code < 400: " + i10);
    }

    public static <T> Response<T> success(T t10) {
        return success(t10, new b0.a().g(200).m("OK").p(Protocol.HTTP_1_1).s(new z.a().p("http://localhost/").b()).c());
    }

    public T body() {
        return this.body;
    }

    public int code() {
        return this.rawResponse.n();
    }

    public c0 errorBody() {
        return this.errorBody;
    }

    public Headers headers() {
        return this.rawResponse.x();
    }

    public boolean isSuccessful() {
        return this.rawResponse.E();
    }

    public String message() {
        return this.rawResponse.I();
    }

    public b0 raw() {
        return this.rawResponse;
    }

    public String toString() {
        return this.rawResponse.toString();
    }

    public static <T> Response<T> success(T t10, Headers headers) {
        Utils.checkNotNull(headers, "headers == null");
        return success(t10, new b0.a().g(200).m("OK").p(Protocol.HTTP_1_1).k(headers).s(new z.a().p("http://localhost/").b()).c());
    }

    public static <T> Response<T> error(c0 c0Var, b0 b0Var) {
        Utils.checkNotNull(c0Var, "body == null");
        Utils.checkNotNull(b0Var, "rawResponse == null");
        if (!b0Var.E()) {
            return new Response<>(b0Var, null, c0Var);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public static <T> Response<T> success(T t10, b0 b0Var) {
        Utils.checkNotNull(b0Var, "rawResponse == null");
        if (b0Var.E()) {
            return new Response<>(b0Var, t10, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }
}
