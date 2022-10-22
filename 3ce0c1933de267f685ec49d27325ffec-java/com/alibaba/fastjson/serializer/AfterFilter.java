package com.alibaba.fastjson.serializer;
/* loaded from: classes.dex */
public abstract class AfterFilter implements SerializeFilter {
    private static final ThreadLocal<JSONSerializer> serializerLocal = new ThreadLocal<>();
    private static final ThreadLocal<Character> seperatorLocal = new ThreadLocal<>();
    private static final Character COMMA = ',';

    /* JADX INFO: Access modifiers changed from: package-private */
    public final char writeAfter(JSONSerializer jSONSerializer, Object obj, char c10) {
        ThreadLocal<JSONSerializer> threadLocal = serializerLocal;
        threadLocal.set(jSONSerializer);
        ThreadLocal<Character> threadLocal2 = seperatorLocal;
        threadLocal2.set(Character.valueOf(c10));
        writeAfter(obj);
        threadLocal.set(null);
        return threadLocal2.get().charValue();
    }

    public abstract void writeAfter(Object obj);

    protected final void writeKeyValue(String str, Object obj) {
        ThreadLocal<Character> threadLocal = seperatorLocal;
        char charValue = threadLocal.get().charValue();
        serializerLocal.get().writeKeyValue(charValue, str, obj);
        if (charValue != ',') {
            threadLocal.set(COMMA);
        }
    }
}
