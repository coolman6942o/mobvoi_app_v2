package retrofit2.converter.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import okhttp3.a0;
import okhttp3.w;
import retrofit2.Converter;
/* loaded from: classes3.dex */
final class FastJsonRequestBodyConverter<T> implements Converter<T, a0> {
    private static final w MEDIA_TYPE = w.f("application/json; charset=UTF-8");
    private SerializeConfig serializeConfig;
    private SerializerFeature[] serializerFeatures;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FastJsonRequestBodyConverter(SerializeConfig serializeConfig, SerializerFeature... serializerFeatureArr) {
        this.serializeConfig = serializeConfig;
        this.serializerFeatures = serializerFeatureArr;
    }

    @Override // retrofit2.Converter
    /* renamed from: convert  reason: avoid collision after fix types in other method */
    public a0 convert2(T t10) throws IOException {
        byte[] bArr;
        SerializeConfig serializeConfig = this.serializeConfig;
        if (serializeConfig != null) {
            SerializerFeature[] serializerFeatureArr = this.serializerFeatures;
            if (serializerFeatureArr != null) {
                bArr = JSON.toJSONBytes(t10, serializeConfig, serializerFeatureArr);
            } else {
                bArr = JSON.toJSONBytes(t10, serializeConfig, new SerializerFeature[0]);
            }
        } else {
            SerializerFeature[] serializerFeatureArr2 = this.serializerFeatures;
            if (serializerFeatureArr2 != null) {
                bArr = JSON.toJSONBytes(t10, serializerFeatureArr2);
            } else {
                bArr = JSON.toJSONBytes(t10, new SerializerFeature[0]);
            }
        }
        return a0.create(MEDIA_TYPE, bArr);
    }
}
