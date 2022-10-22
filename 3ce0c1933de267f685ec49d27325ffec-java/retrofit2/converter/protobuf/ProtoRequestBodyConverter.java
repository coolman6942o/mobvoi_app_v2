package retrofit2.converter.protobuf;

import com.google.protobuf.e0;
import java.io.IOException;
import okhttp3.a0;
import okhttp3.w;
import retrofit2.Converter;
/* loaded from: classes3.dex */
final class ProtoRequestBodyConverter<T extends e0> implements Converter<T, a0> {
    private static final w MEDIA_TYPE = w.f("application/x-protobuf");

    /* JADX WARN: Multi-variable type inference failed */
    @Override // retrofit2.Converter
    public /* bridge */ /* synthetic */ a0 convert(Object obj) throws IOException {
        return convert((ProtoRequestBodyConverter<T>) ((e0) obj));
    }

    public a0 convert(T t10) throws IOException {
        return a0.create(MEDIA_TYPE, t10.toByteArray());
    }
}
