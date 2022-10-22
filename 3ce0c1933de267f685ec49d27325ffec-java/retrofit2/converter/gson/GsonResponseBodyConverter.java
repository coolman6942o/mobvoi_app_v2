package retrofit2.converter.gson;

import com.google.gson.e;
import com.google.gson.q;
import java.io.IOException;
import okhttp3.c0;
import retrofit2.Converter;
/* loaded from: classes3.dex */
final class GsonResponseBodyConverter<T> implements Converter<c0, T> {
    private final q<T> adapter;
    private final e gson;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GsonResponseBodyConverter(e eVar, q<T> qVar) {
        this.gson = eVar;
        this.adapter = qVar;
    }

    public T convert(c0 c0Var) throws IOException {
        try {
            return this.adapter.b(this.gson.p(c0Var.charStream()));
        } finally {
            c0Var.close();
        }
    }
}
