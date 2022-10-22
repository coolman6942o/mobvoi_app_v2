package com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* loaded from: classes.dex */
public abstract class FieldNamingPolicy extends Enum<FieldNamingPolicy> implements com.google.gson.d {
    private static final /* synthetic */ FieldNamingPolicy[] $VALUES;
    public static final FieldNamingPolicy IDENTITY;
    public static final FieldNamingPolicy LOWER_CASE_WITH_DASHES;
    public static final FieldNamingPolicy LOWER_CASE_WITH_DOTS;
    public static final FieldNamingPolicy LOWER_CASE_WITH_UNDERSCORES;
    public static final FieldNamingPolicy UPPER_CAMEL_CASE;
    public static final FieldNamingPolicy UPPER_CAMEL_CASE_WITH_SPACES;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* loaded from: classes.dex */
    static class a extends FieldNamingPolicy {
        a(String str, int i10) {
            super(str, i10, null);
        }

        @Override // com.google.gson.FieldNamingPolicy, com.google.gson.d
        public String translateName(Field field) {
            return field.getName();
        }
    }

    static {
        a aVar = new a("IDENTITY", 0);
        IDENTITY = aVar;
        FieldNamingPolicy bVar = new FieldNamingPolicy("UPPER_CAMEL_CASE", 1) { // from class: com.google.gson.FieldNamingPolicy.b
            @Override // com.google.gson.FieldNamingPolicy, com.google.gson.d
            public String translateName(Field field) {
                return FieldNamingPolicy.c(field.getName());
            }
        };
        UPPER_CAMEL_CASE = bVar;
        FieldNamingPolicy cVar = new FieldNamingPolicy("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: com.google.gson.FieldNamingPolicy.c
            @Override // com.google.gson.FieldNamingPolicy, com.google.gson.d
            public String translateName(Field field) {
                return FieldNamingPolicy.c(FieldNamingPolicy.b(field.getName(), " "));
            }
        };
        UPPER_CAMEL_CASE_WITH_SPACES = cVar;
        FieldNamingPolicy dVar = new FieldNamingPolicy("LOWER_CASE_WITH_UNDERSCORES", 3) { // from class: com.google.gson.FieldNamingPolicy.d
            @Override // com.google.gson.FieldNamingPolicy, com.google.gson.d
            public String translateName(Field field) {
                return FieldNamingPolicy.b(field.getName(), "_").toLowerCase(Locale.ENGLISH);
            }
        };
        LOWER_CASE_WITH_UNDERSCORES = dVar;
        FieldNamingPolicy eVar = new FieldNamingPolicy("LOWER_CASE_WITH_DASHES", 4) { // from class: com.google.gson.FieldNamingPolicy.e
            @Override // com.google.gson.FieldNamingPolicy, com.google.gson.d
            public String translateName(Field field) {
                return FieldNamingPolicy.b(field.getName(), "-").toLowerCase(Locale.ENGLISH);
            }
        };
        LOWER_CASE_WITH_DASHES = eVar;
        FieldNamingPolicy fVar = new FieldNamingPolicy("LOWER_CASE_WITH_DOTS", 5) { // from class: com.google.gson.FieldNamingPolicy.f
            @Override // com.google.gson.FieldNamingPolicy, com.google.gson.d
            public String translateName(Field field) {
                return FieldNamingPolicy.b(field.getName(), ".").toLowerCase(Locale.ENGLISH);
            }
        };
        LOWER_CASE_WITH_DOTS = fVar;
        $VALUES = new FieldNamingPolicy[]{aVar, bVar, cVar, dVar, eVar, fVar};
    }

    private FieldNamingPolicy(String str, int i10) {
    }

    private static String a(char c10, String str, int i10) {
        if (i10 >= str.length()) {
            return String.valueOf(c10);
        }
        return c10 + str.substring(i10);
    }

    static String b(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (Character.isUpperCase(charAt) && sb2.length() != 0) {
                sb2.append(str2);
            }
            sb2.append(charAt);
        }
        return sb2.toString();
    }

    static String c(String str) {
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        char charAt = str.charAt(0);
        int length = str.length();
        while (i10 < length - 1 && !Character.isLetter(charAt)) {
            sb2.append(charAt);
            i10++;
            charAt = str.charAt(i10);
        }
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        sb2.append(a(Character.toUpperCase(charAt), str, i10 + 1));
        return sb2.toString();
    }

    public static FieldNamingPolicy valueOf(String str) {
        return (FieldNamingPolicy) Enum.valueOf(FieldNamingPolicy.class, str);
    }

    public static FieldNamingPolicy[] values() {
        return (FieldNamingPolicy[]) $VALUES.clone();
    }

    @Override // com.google.gson.d
    public abstract /* synthetic */ String translateName(Field field);

    /* synthetic */ FieldNamingPolicy(String str, int i10, a aVar) {
        this(str, i10);
    }
}
