package i0;

import android.text.SpannableStringBuilder;
import java.util.Locale;
/* compiled from: BidiFormatter.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    static final e f27970d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f27971e = Character.toString(8206);

    /* renamed from: f  reason: collision with root package name */
    private static final String f27972f = Character.toString(8207);

    /* renamed from: g  reason: collision with root package name */
    static final a f27973g;

    /* renamed from: h  reason: collision with root package name */
    static final a f27974h;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f27975a;

    /* renamed from: b  reason: collision with root package name */
    private final int f27976b;

    /* renamed from: c  reason: collision with root package name */
    private final e f27977c;

    /* compiled from: BidiFormatter.java */
    /* renamed from: i0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0304a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f27978a;

        /* renamed from: b  reason: collision with root package name */
        private int f27979b;

        /* renamed from: c  reason: collision with root package name */
        private e f27980c;

        public C0304a() {
            c(a.e(Locale.getDefault()));
        }

        private static a b(boolean z10) {
            return z10 ? a.f27974h : a.f27973g;
        }

        private void c(boolean z10) {
            this.f27978a = z10;
            this.f27980c = a.f27970d;
            this.f27979b = 2;
        }

        public a a() {
            if (this.f27979b == 2 && this.f27980c == a.f27970d) {
                return b(this.f27978a);
            }
            return new a(this.f27978a, this.f27979b, this.f27980c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BidiFormatter.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: f  reason: collision with root package name */
        private static final byte[] f27981f = new byte[1792];

        /* renamed from: a  reason: collision with root package name */
        private final CharSequence f27982a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f27983b;

        /* renamed from: c  reason: collision with root package name */
        private final int f27984c;

        /* renamed from: d  reason: collision with root package name */
        private int f27985d;

        /* renamed from: e  reason: collision with root package name */
        private char f27986e;

        static {
            for (int i10 = 0; i10 < 1792; i10++) {
                f27981f[i10] = Character.getDirectionality(i10);
            }
        }

        b(CharSequence charSequence, boolean z10) {
            this.f27982a = charSequence;
            this.f27983b = z10;
            this.f27984c = charSequence.length();
        }

        private static byte c(char c10) {
            return c10 < 1792 ? f27981f[c10] : Character.getDirectionality(c10);
        }

        private byte f() {
            char charAt;
            int i10 = this.f27985d;
            do {
                int i11 = this.f27985d;
                if (i11 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f27982a;
                int i12 = i11 - 1;
                this.f27985d = i12;
                charAt = charSequence.charAt(i12);
                this.f27986e = charAt;
                if (charAt == '&') {
                    return (byte) 12;
                }
            } while (charAt != ';');
            this.f27985d = i10;
            this.f27986e = ';';
            return (byte) 13;
        }

        private byte g() {
            char charAt;
            do {
                int i10 = this.f27985d;
                if (i10 >= this.f27984c) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.f27982a;
                this.f27985d = i10 + 1;
                charAt = charSequence.charAt(i10);
                this.f27986e = charAt;
            } while (charAt != ';');
            return (byte) 12;
        }

        private byte h() {
            char charAt;
            int i10 = this.f27985d;
            while (true) {
                int i11 = this.f27985d;
                if (i11 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f27982a;
                int i12 = i11 - 1;
                this.f27985d = i12;
                char charAt2 = charSequence.charAt(i12);
                this.f27986e = charAt2;
                if (charAt2 == '<') {
                    return (byte) 12;
                }
                if (charAt2 == '>') {
                    break;
                } else if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i13 = this.f27985d;
                        if (i13 > 0) {
                            CharSequence charSequence2 = this.f27982a;
                            int i14 = i13 - 1;
                            this.f27985d = i14;
                            charAt = charSequence2.charAt(i14);
                            this.f27986e = charAt;
                        }
                    } while (charAt != charAt2);
                }
            }
            this.f27985d = i10;
            this.f27986e = '>';
            return (byte) 13;
        }

        private byte i() {
            char charAt;
            int i10 = this.f27985d;
            while (true) {
                int i11 = this.f27985d;
                if (i11 < this.f27984c) {
                    CharSequence charSequence = this.f27982a;
                    this.f27985d = i11 + 1;
                    char charAt2 = charSequence.charAt(i11);
                    this.f27986e = charAt2;
                    if (charAt2 == '>') {
                        return (byte) 12;
                    }
                    if (charAt2 == '\"' || charAt2 == '\'') {
                        do {
                            int i12 = this.f27985d;
                            if (i12 < this.f27984c) {
                                CharSequence charSequence2 = this.f27982a;
                                this.f27985d = i12 + 1;
                                charAt = charSequence2.charAt(i12);
                                this.f27986e = charAt;
                            }
                        } while (charAt != charAt2);
                    }
                } else {
                    this.f27985d = i10;
                    this.f27986e = '<';
                    return (byte) 13;
                }
            }
        }

        byte a() {
            char charAt = this.f27982a.charAt(this.f27985d - 1);
            this.f27986e = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.f27982a, this.f27985d);
                this.f27985d -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f27985d--;
            byte c10 = c(this.f27986e);
            if (!this.f27983b) {
                return c10;
            }
            char c11 = this.f27986e;
            if (c11 == '>') {
                return h();
            }
            return c11 == ';' ? f() : c10;
        }

        byte b() {
            char charAt = this.f27982a.charAt(this.f27985d);
            this.f27986e = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.f27982a, this.f27985d);
                this.f27985d += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f27985d++;
            byte c10 = c(this.f27986e);
            if (!this.f27983b) {
                return c10;
            }
            char c11 = this.f27986e;
            if (c11 == '<') {
                return i();
            }
            return c11 == '&' ? g() : c10;
        }

        int d() {
            this.f27985d = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            while (this.f27985d < this.f27984c && i10 == 0) {
                byte b10 = b();
                if (b10 != 0) {
                    if (b10 == 1 || b10 == 2) {
                        if (i12 == 0) {
                            return 1;
                        }
                    } else if (b10 != 9) {
                        switch (b10) {
                            case 14:
                            case 15:
                                i12++;
                                i11 = -1;
                                break;
                            case 16:
                            case 17:
                                i12++;
                                i11 = 1;
                                break;
                            case 18:
                                i12--;
                                i11 = 0;
                                break;
                        }
                    }
                } else if (i12 == 0) {
                    return -1;
                }
                i10 = i12;
            }
            if (i10 == 0) {
                return 0;
            }
            if (i11 != 0) {
                return i11;
            }
            while (this.f27985d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i10 == i12) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i10 == i12) {
                            return 1;
                        }
                        break;
                    case 18:
                        i12++;
                        continue;
                }
                i12--;
            }
            return 0;
        }

        int e() {
            this.f27985d = this.f27984c;
            int i10 = 0;
            while (true) {
                int i11 = i10;
                while (this.f27985d > 0) {
                    byte a10 = a();
                    if (a10 != 0) {
                        if (a10 == 1 || a10 == 2) {
                            if (i10 == 0) {
                                return 1;
                            }
                            if (i11 == 0) {
                                break;
                            }
                        } else if (a10 != 9) {
                            switch (a10) {
                                case 14:
                                case 15:
                                    if (i11 == i10) {
                                        return -1;
                                    }
                                    i10--;
                                    break;
                                case 16:
                                case 17:
                                    if (i11 == i10) {
                                        return 1;
                                    }
                                    i10--;
                                    break;
                                case 18:
                                    i10++;
                                    break;
                                default:
                                    if (i11 != 0) {
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        } else {
                            continue;
                        }
                    } else if (i10 == 0) {
                        return -1;
                    } else {
                        if (i11 == 0) {
                            break;
                        }
                    }
                }
                return 0;
            }
        }
    }

    static {
        e eVar = f.f28002c;
        f27970d = eVar;
        f27973g = new a(false, 2, eVar);
        f27974h = new a(true, 2, eVar);
    }

    a(boolean z10, int i10, e eVar) {
        this.f27975a = z10;
        this.f27976b = i10;
        this.f27977c = eVar;
    }

    private static int a(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    private static int b(CharSequence charSequence) {
        return new b(charSequence, false).e();
    }

    public static a c() {
        return new C0304a().a();
    }

    static boolean e(Locale locale) {
        return g.b(locale) == 1;
    }

    private String f(CharSequence charSequence, e eVar) {
        boolean a10 = eVar.a(charSequence, 0, charSequence.length());
        if (this.f27975a || (!a10 && b(charSequence) != 1)) {
            return this.f27975a ? (!a10 || b(charSequence) == -1) ? f27972f : "" : "";
        }
        return f27971e;
    }

    private String g(CharSequence charSequence, e eVar) {
        boolean a10 = eVar.a(charSequence, 0, charSequence.length());
        if (this.f27975a || (!a10 && a(charSequence) != 1)) {
            return this.f27975a ? (!a10 || a(charSequence) == -1) ? f27972f : "" : "";
        }
        return f27971e;
    }

    public boolean d() {
        return (this.f27976b & 2) != 0;
    }

    public CharSequence h(CharSequence charSequence) {
        return i(charSequence, this.f27977c, true);
    }

    public CharSequence i(CharSequence charSequence, e eVar, boolean z10) {
        if (charSequence == null) {
            return null;
        }
        boolean a10 = eVar.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z10) {
            spannableStringBuilder.append((CharSequence) g(charSequence, a10 ? f.f28001b : f.f28000a));
        }
        if (a10 != this.f27975a) {
            spannableStringBuilder.append(a10 ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z10) {
            spannableStringBuilder.append((CharSequence) f(charSequence, a10 ? f.f28001b : f.f28000a));
        }
        return spannableStringBuilder;
    }

    public String j(String str) {
        return k(str, this.f27977c, true);
    }

    public String k(String str, e eVar, boolean z10) {
        if (str == null) {
            return null;
        }
        return i(str, eVar, z10).toString();
    }
}
