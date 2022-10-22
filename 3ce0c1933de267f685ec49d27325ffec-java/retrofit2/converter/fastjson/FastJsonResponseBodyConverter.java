package retrofit2.converter.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import java.io.IOException;
import java.lang.reflect.Type;
import okhttp3.c0;
import retrofit2.Converter;
/* loaded from: classes3.dex */
final class FastJsonResponseBodyConverter<T> implements Converter<c0, T> {
    private static final Feature[] EMPTY_SERIALIZER_FEATURES = new Feature[0];
    private ParserConfig config;
    private int featureValues;
    private Feature[] features;
    private Type mType;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FastJsonResponseBodyConverter(Type type, ParserConfig parserConfig, int i10, Feature... featureArr) {
        this.mType = type;
        this.config = parserConfig;
        this.featureValues = i10;
        this.features = featureArr;
    }

    public T convert(c0 c0Var) throws IOException {
        try {
            String string = c0Var.string();
            Type type = this.mType;
            ParserConfig parserConfig = this.config;
            int i10 = this.featureValues;
            Feature[] featureArr = this.features;
            if (featureArr == null) {
                featureArr = EMPTY_SERIALIZER_FEATURES;
            }
            return (T) JSON.parseObject(string, type, parserConfig, i10, featureArr);
        } finally {
            c0Var.close();
        }
    }
}
