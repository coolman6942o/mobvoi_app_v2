package retrofit2.converter.gson;

import com.google.gson.e;
import com.google.gson.q;
import com.google.gson.stream.b;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.a0;
import okhttp3.w;
import okio.c;
import retrofit2.Converter;
/* loaded from: classes3.dex */
final class GsonRequestBodyConverter<T> implements Converter<T, a0> {
    private static final w MEDIA_TYPE = w.f("application/json; charset=UTF-8");
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final q<T> adapter;
    private final e gson;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GsonRequestBodyConverter(e eVar, q<T> qVar) {
        this.gson = eVar;
        this.adapter = qVar;
    }

    @Override // retrofit2.Converter
    /* renamed from: convert  reason: avoid collision after fix types in other method */
    public a0 convert2(T t10) throws IOException {
        c cVar = new c();
        b q5 = this.gson.q(new OutputStreamWriter(cVar.E(), UTF_8));
        this.adapter.d(q5, t10);
        q5.close();
        return a0.create(MEDIA_TYPE, cVar.d0());
    }
}
