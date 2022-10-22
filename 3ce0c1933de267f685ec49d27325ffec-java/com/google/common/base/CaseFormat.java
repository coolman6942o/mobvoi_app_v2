package com.google.common.base;

import java.io.Serializable;
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* loaded from: classes.dex */
public abstract class CaseFormat extends Enum<CaseFormat> {
    private final com.google.common.base.d wordBoundary;
    private final String wordSeparator;
    public static final CaseFormat LOWER_HYPHEN = new a("LOWER_HYPHEN", 0, com.google.common.base.d.e('-'), "-");
    public static final CaseFormat LOWER_UNDERSCORE = new CaseFormat("LOWER_UNDERSCORE", 1, com.google.common.base.d.e('_'), "_") { // from class: com.google.common.base.CaseFormat.b
        @Override // com.google.common.base.CaseFormat
        String c(CaseFormat caseFormat, String str) {
            if (caseFormat == CaseFormat.LOWER_HYPHEN) {
                return str.replace('_', '-');
            }
            if (caseFormat == CaseFormat.UPPER_UNDERSCORE) {
                return com.google.common.base.c.e(str);
            }
            return CaseFormat.super.c(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        String h(String str) {
            return com.google.common.base.c.c(str);
        }
    };
    public static final CaseFormat LOWER_CAMEL = new CaseFormat("LOWER_CAMEL", 2, com.google.common.base.d.c('A', 'Z'), "") { // from class: com.google.common.base.CaseFormat.c
        @Override // com.google.common.base.CaseFormat
        String g(String str) {
            return com.google.common.base.c.c(str);
        }

        @Override // com.google.common.base.CaseFormat
        String h(String str) {
            return CaseFormat.d(str);
        }
    };
    public static final CaseFormat UPPER_CAMEL = new CaseFormat("UPPER_CAMEL", 3, com.google.common.base.d.c('A', 'Z'), "") { // from class: com.google.common.base.CaseFormat.d
        @Override // com.google.common.base.CaseFormat
        String h(String str) {
            return CaseFormat.d(str);
        }
    };
    public static final CaseFormat UPPER_UNDERSCORE = new CaseFormat("UPPER_UNDERSCORE", 4, com.google.common.base.d.e('_'), "_") { // from class: com.google.common.base.CaseFormat.e
        @Override // com.google.common.base.CaseFormat
        String c(CaseFormat caseFormat, String str) {
            if (caseFormat == CaseFormat.LOWER_HYPHEN) {
                return com.google.common.base.c.c(str.replace('_', '-'));
            }
            if (caseFormat == CaseFormat.LOWER_UNDERSCORE) {
                return com.google.common.base.c.c(str);
            }
            return CaseFormat.super.c(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        String h(String str) {
            return com.google.common.base.c.e(str);
        }
    };
    private static final /* synthetic */ CaseFormat[] $VALUES = a();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* loaded from: classes.dex */
    final class a extends CaseFormat {
        a(String str, int i10, com.google.common.base.d dVar, String str2) {
            super(str, i10, dVar, str2, null);
        }

        @Override // com.google.common.base.CaseFormat
        String c(CaseFormat caseFormat, String str) {
            if (caseFormat == CaseFormat.LOWER_UNDERSCORE) {
                return str.replace('-', '_');
            }
            if (caseFormat == CaseFormat.UPPER_UNDERSCORE) {
                return com.google.common.base.c.e(str.replace('-', '_'));
            }
            return CaseFormat.super.c(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        String h(String str) {
            return com.google.common.base.c.c(str);
        }
    }

    /* loaded from: classes.dex */
    private static final class f extends com.google.common.base.e<String, String> implements Serializable {
        private static final long serialVersionUID = 0;
        private final CaseFormat sourceFormat;
        private final CaseFormat targetFormat;

        f(CaseFormat caseFormat, CaseFormat caseFormat2) {
            this.sourceFormat = (CaseFormat) p.o(caseFormat);
            this.targetFormat = (CaseFormat) p.o(caseFormat2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d */
        public String c(String str) {
            return this.sourceFormat.to(this.targetFormat, str);
        }

        @Override // com.google.common.base.e, com.google.common.base.h
        public boolean equals(Object obj) {
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.sourceFormat.equals(fVar.sourceFormat) && this.targetFormat.equals(fVar.targetFormat);
        }

        public int hashCode() {
            return this.sourceFormat.hashCode() ^ this.targetFormat.hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(this.sourceFormat);
            String valueOf2 = String.valueOf(this.targetFormat);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 14 + valueOf2.length());
            sb2.append(valueOf);
            sb2.append(".converterTo(");
            sb2.append(valueOf2);
            sb2.append(")");
            return sb2.toString();
        }
    }

    /* synthetic */ CaseFormat(String str, int i10, com.google.common.base.d dVar, String str2, a aVar) {
        this(str, i10, dVar, str2);
    }

    private static /* synthetic */ CaseFormat[] a() {
        return new CaseFormat[]{LOWER_HYPHEN, LOWER_UNDERSCORE, LOWER_CAMEL, UPPER_CAMEL, UPPER_UNDERSCORE};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(String str) {
        if (str.isEmpty()) {
            return str;
        }
        char d10 = com.google.common.base.c.d(str.charAt(0));
        String c10 = com.google.common.base.c.c(str.substring(1));
        StringBuilder sb2 = new StringBuilder(String.valueOf(c10).length() + 1);
        sb2.append(d10);
        sb2.append(c10);
        return sb2.toString();
    }

    public static CaseFormat valueOf(String str) {
        return (CaseFormat) Enum.valueOf(CaseFormat.class, str);
    }

    public static CaseFormat[] values() {
        return (CaseFormat[]) $VALUES.clone();
    }

    String c(CaseFormat caseFormat, String str) {
        StringBuilder sb2 = null;
        int i10 = 0;
        int i11 = -1;
        while (true) {
            i11 = this.wordBoundary.d(str, i11 + 1);
            if (i11 == -1) {
                break;
            }
            if (i10 == 0) {
                sb2 = new StringBuilder(str.length() + (caseFormat.wordSeparator.length() * 4));
                sb2.append(caseFormat.g(str.substring(i10, i11)));
            } else {
                sb2.append(caseFormat.h(str.substring(i10, i11)));
            }
            sb2.append(caseFormat.wordSeparator);
            i10 = this.wordSeparator.length() + i11;
        }
        if (i10 == 0) {
            return caseFormat.g(str);
        }
        sb2.append(caseFormat.h(str.substring(i10)));
        return sb2.toString();
    }

    public com.google.common.base.e<String, String> converterTo(CaseFormat caseFormat) {
        return new f(this, caseFormat);
    }

    String g(String str) {
        return h(str);
    }

    abstract String h(String str);

    public final String to(CaseFormat caseFormat, String str) {
        p.o(caseFormat);
        p.o(str);
        return caseFormat == this ? str : c(caseFormat, str);
    }

    private CaseFormat(String str, int i10, com.google.common.base.d dVar, String str2) {
        this.wordBoundary = dVar;
        this.wordSeparator = str2;
    }
}
