package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONStreamAware;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.util.IdentityHashMap;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class SerializeConfig {
    public static final SerializeConfig globalInstance = new SerializeConfig();
    public PropertyNamingStrategy propertyNamingStrategy;
    private final IdentityHashMap<ObjectSerializer> serializers;
    protected String typeKey = JSON.DEFAULT_TYPE_KEY;

    public SerializeConfig() {
        IdentityHashMap<ObjectSerializer> identityHashMap = new IdentityHashMap<>(1024);
        this.serializers = identityHashMap;
        identityHashMap.put(Boolean.class, BooleanCodec.instance);
        MiscCodec miscCodec = MiscCodec.instance;
        identityHashMap.put(Character.class, miscCodec);
        identityHashMap.put(Byte.class, IntegerCodec.instance);
        identityHashMap.put(Short.class, IntegerCodec.instance);
        identityHashMap.put(Integer.class, IntegerCodec.instance);
        identityHashMap.put(Long.class, IntegerCodec.instance);
        NumberCodec numberCodec = NumberCodec.instance;
        identityHashMap.put(Float.class, numberCodec);
        identityHashMap.put(Double.class, numberCodec);
        identityHashMap.put(Number.class, numberCodec);
        BigDecimalCodec bigDecimalCodec = BigDecimalCodec.instance;
        identityHashMap.put(BigDecimal.class, bigDecimalCodec);
        identityHashMap.put(BigInteger.class, bigDecimalCodec);
        identityHashMap.put(String.class, StringCodec.instance);
        identityHashMap.put(Object[].class, ArrayCodec.instance);
        identityHashMap.put(Class.class, miscCodec);
        identityHashMap.put(SimpleDateFormat.class, miscCodec);
        identityHashMap.put(Locale.class, miscCodec);
        identityHashMap.put(Currency.class, miscCodec);
        identityHashMap.put(TimeZone.class, miscCodec);
        identityHashMap.put(UUID.class, miscCodec);
        identityHashMap.put(URI.class, miscCodec);
        identityHashMap.put(URL.class, miscCodec);
        identityHashMap.put(Pattern.class, miscCodec);
        identityHashMap.put(Charset.class, miscCodec);
    }

    public static final SerializeConfig getGlobalInstance() {
        return globalInstance;
    }

    public ObjectSerializer get(Class<?> cls) {
        Class<? super Object> superclass;
        boolean z10;
        ObjectSerializer objectSerializer = this.serializers.get(cls);
        if (objectSerializer != null) {
            return objectSerializer;
        }
        if (Map.class.isAssignableFrom(cls)) {
            this.serializers.put(cls, new MapSerializer());
        } else if (List.class.isAssignableFrom(cls)) {
            this.serializers.put(cls, new ListSerializer());
        } else if (Collection.class.isAssignableFrom(cls)) {
            this.serializers.put(cls, CollectionCodec.instance);
        } else if (Date.class.isAssignableFrom(cls)) {
            this.serializers.put(cls, DateCodec.instance);
        } else if (JSONAware.class.isAssignableFrom(cls)) {
            this.serializers.put(cls, MiscCodec.instance);
        } else if (JSONSerializable.class.isAssignableFrom(cls)) {
            this.serializers.put(cls, MiscCodec.instance);
        } else if (JSONStreamAware.class.isAssignableFrom(cls)) {
            this.serializers.put(cls, MiscCodec.instance);
        } else if (cls.isEnum() || !((superclass = cls.getSuperclass()) == null || superclass == Object.class || !superclass.isEnum())) {
            this.serializers.put(cls, new EnumSerializer());
        } else if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            this.serializers.put(cls, new ArraySerializer(componentType, get(componentType)));
        } else if (Throwable.class.isAssignableFrom(cls)) {
            JavaBeanSerializer javaBeanSerializer = new JavaBeanSerializer(cls, this.propertyNamingStrategy);
            javaBeanSerializer.features |= SerializerFeature.WriteClassName.mask;
            this.serializers.put(cls, javaBeanSerializer);
        } else if (TimeZone.class.isAssignableFrom(cls)) {
            this.serializers.put(cls, MiscCodec.instance);
        } else if (Charset.class.isAssignableFrom(cls)) {
            this.serializers.put(cls, MiscCodec.instance);
        } else if (Enumeration.class.isAssignableFrom(cls)) {
            this.serializers.put(cls, MiscCodec.instance);
        } else if (Calendar.class.isAssignableFrom(cls)) {
            this.serializers.put(cls, DateCodec.instance);
        } else {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            boolean z11 = false;
            int i10 = 0;
            while (true) {
                z10 = true;
                if (i10 >= length) {
                    z10 = false;
                    break;
                }
                Class<?> cls2 = interfaces[i10];
                if (cls2.getName().equals("net.sf.cglib.proxy.Factory") || cls2.getName().equals("org.springframework.cglib.proxy.Factory")) {
                    break;
                } else if (cls2.getName().equals("javassist.util.proxy.ProxyObject")) {
                    break;
                } else {
                    i10++;
                }
            }
            z10 = false;
            z11 = true;
            if (z11 || z10) {
                ObjectSerializer objectSerializer2 = get(cls.getSuperclass());
                this.serializers.put(cls, objectSerializer2);
                return objectSerializer2;
            }
            this.serializers.put(cls, new JavaBeanSerializer(cls, this.propertyNamingStrategy));
        }
        return this.serializers.get(cls);
    }

    public String getTypeKey() {
        return this.typeKey;
    }

    public boolean put(Type type, ObjectSerializer objectSerializer) {
        return this.serializers.put(type, objectSerializer);
    }

    public ObjectSerializer registerIfNotExists(Class<?> cls) {
        return registerIfNotExists(cls, cls.getModifiers(), false, true, true, true);
    }

    public void setTypeKey(String str) {
        this.typeKey = str;
    }

    public ObjectSerializer registerIfNotExists(Class<?> cls, int i10, boolean z10, boolean z11, boolean z12, boolean z13) {
        ObjectSerializer objectSerializer = this.serializers.get(cls);
        if (objectSerializer != null) {
            return objectSerializer;
        }
        JavaBeanSerializer javaBeanSerializer = new JavaBeanSerializer(cls, i10, null, z10, z11, z12, z13, this.propertyNamingStrategy);
        this.serializers.put(cls, javaBeanSerializer);
        return javaBeanSerializer;
    }
}
