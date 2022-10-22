package com.google.gson;
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* loaded from: classes.dex */
public abstract class LongSerializationPolicy extends Enum<LongSerializationPolicy> {
    private static final /* synthetic */ LongSerializationPolicy[] $VALUES;
    public static final LongSerializationPolicy DEFAULT;
    public static final LongSerializationPolicy STRING;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* loaded from: classes.dex */
    static class a extends LongSerializationPolicy {
        a(String str, int i10) {
            super(str, i10, null);
        }

        @Override // com.google.gson.LongSerializationPolicy
        public k serialize(Long l10) {
            return new n(l10);
        }
    }

    static {
        a aVar = new a("DEFAULT", 0);
        DEFAULT = aVar;
        LongSerializationPolicy bVar = new LongSerializationPolicy("STRING", 1) { // from class: com.google.gson.LongSerializationPolicy.b
            @Override // com.google.gson.LongSerializationPolicy
            public k serialize(Long l10) {
                return new n(String.valueOf(l10));
            }
        };
        STRING = bVar;
        $VALUES = new LongSerializationPolicy[]{aVar, bVar};
    }

    private LongSerializationPolicy(String str, int i10) {
    }

    public static LongSerializationPolicy valueOf(String str) {
        return (LongSerializationPolicy) Enum.valueOf(LongSerializationPolicy.class, str);
    }

    public static LongSerializationPolicy[] values() {
        return (LongSerializationPolicy[]) $VALUES.clone();
    }

    public abstract k serialize(Long l10);

    /* synthetic */ LongSerializationPolicy(String str, int i10, a aVar) {
        this(str, i10);
    }
}
