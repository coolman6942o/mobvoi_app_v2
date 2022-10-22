package kotlin.text;

import com.mobvoi.wear.common.base.WearPath;
import io.h;
import io.m;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.collections.k;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import qo.l;
import qo.p;
import xo.e;
import xo.g;
/* compiled from: Regex.kt */
/* loaded from: classes3.dex */
public final class Regex implements Serializable {
    public static final a Companion = new a(null);
    private Set<? extends RegexOption> _options;
    private final Pattern nativePattern;

    /* compiled from: Regex.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int b(int i10) {
            return (i10 & 2) != 0 ? i10 | 64 : i10;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Regex.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements qo.a<h> {
        final /* synthetic */ CharSequence $input;
        final /* synthetic */ int $startIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(CharSequence charSequence, int i10) {
            super(0);
            this.$input = charSequence;
            this.$startIndex = i10;
        }

        /* renamed from: a */
        public final h invoke() {
            return Regex.this.find(this.$input, this.$startIndex);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Regex.kt */
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class c extends FunctionReferenceImpl implements l<h, h> {
        public static final c INSTANCE = new c();

        c() {
            super(1, h.class, WearPath.MediaControls.CONTROLL_COMMAND_NEXT, "next()Lkotlin/text/MatchResult;", 0);
        }

        /* renamed from: g */
        public final h invoke(h p12) {
            i.f(p12, "p1");
            return p12.next();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Regex.kt */
    @kotlin.coroutines.jvm.internal.d(c = "kotlin.text.Regex$splitToSequence$1", f = "Regex.kt", l = {243, 251, 255}, m = "invokeSuspend")
    /* loaded from: classes3.dex */
    public static final class d extends RestrictedSuspendLambda implements p<g<? super String>, kotlin.coroutines.c<? super m>, Object> {
        final /* synthetic */ CharSequence $input;
        final /* synthetic */ int $limit;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(CharSequence charSequence, int i10, kotlin.coroutines.c cVar) {
            super(2, cVar);
            this.$input = charSequence;
            this.$limit = i10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.c<m> create(Object obj, kotlin.coroutines.c<?> completion) {
            i.f(completion, "completion");
            d dVar = new d(this.$input, this.$limit, completion);
            dVar.L$0 = obj;
            return dVar;
        }

        @Override // qo.p
        public final Object invoke(g<? super String> gVar, kotlin.coroutines.c<? super m> cVar) {
            return ((d) create(gVar, cVar)).invokeSuspend(m.f28349a);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0072 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x009e A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0070 -> B:20:0x0073). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            d dVar;
            g gVar;
            Matcher matcher;
            int i10;
            String obj2;
            String obj3;
            Object d10 = kotlin.coroutines.intrinsics.a.d();
            int i11 = this.label;
            int end = 0;
            if (i11 == 0) {
                h.b(obj);
                g gVar2 = (g) this.L$0;
                Matcher matcher2 = Regex.this.nativePattern.matcher(this.$input);
                if (this.$limit == 1 || !matcher2.find()) {
                    String obj4 = this.$input.toString();
                    this.label = 1;
                    if (gVar2.d(obj4, this) == d10) {
                        return d10;
                    }
                } else {
                    dVar = this;
                    gVar = gVar2;
                    matcher = matcher2;
                    i10 = 0;
                    obj3 = dVar.$input.subSequence(end, matcher.start()).toString();
                    dVar.L$0 = gVar;
                    dVar.L$1 = matcher;
                    dVar.I$0 = i10;
                    dVar.label = 2;
                    if (gVar.d(obj3, dVar) == d10) {
                    }
                    end = matcher.end();
                    i10++;
                    if (i10 != dVar.$limit - 1) {
                    }
                    CharSequence charSequence = dVar.$input;
                    obj2 = charSequence.subSequence(end, charSequence.length()).toString();
                    dVar.L$0 = null;
                    dVar.L$1 = null;
                    dVar.label = 3;
                    if (gVar.d(obj2, dVar) == d10) {
                    }
                    return m.f28349a;
                }
            } else if (i11 == 1) {
                h.b(obj);
            } else if (i11 == 2) {
                i10 = this.I$0;
                matcher = (Matcher) this.L$1;
                gVar = (g) this.L$0;
                h.b(obj);
                dVar = this;
                end = matcher.end();
                i10++;
                if (i10 != dVar.$limit - 1 || !matcher.find()) {
                    CharSequence charSequence2 = dVar.$input;
                    obj2 = charSequence2.subSequence(end, charSequence2.length()).toString();
                    dVar.L$0 = null;
                    dVar.L$1 = null;
                    dVar.label = 3;
                    if (gVar.d(obj2, dVar) == d10) {
                        return d10;
                    }
                    return m.f28349a;
                }
                obj3 = dVar.$input.subSequence(end, matcher.start()).toString();
                dVar.L$0 = gVar;
                dVar.L$1 = matcher;
                dVar.I$0 = i10;
                dVar.label = 2;
                if (gVar.d(obj3, dVar) == d10) {
                    return d10;
                }
                end = matcher.end();
                i10++;
                if (i10 != dVar.$limit - 1) {
                }
                CharSequence charSequence22 = dVar.$input;
                obj2 = charSequence22.subSequence(end, charSequence22.length()).toString();
                dVar.L$0 = null;
                dVar.L$1 = null;
                dVar.label = 3;
                if (gVar.d(obj2, dVar) == d10) {
                }
                return m.f28349a;
            } else if (i11 == 3) {
                h.b(obj);
                return m.f28349a;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return m.f28349a;
        }
    }

    public Regex(Pattern nativePattern) {
        i.f(nativePattern, "nativePattern");
        this.nativePattern = nativePattern;
    }

    public static /* synthetic */ h find$default(Regex regex, CharSequence charSequence, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return regex.find(charSequence, i10);
    }

    public static /* synthetic */ e findAll$default(Regex regex, CharSequence charSequence, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return regex.findAll(charSequence, i10);
    }

    public static /* synthetic */ List split$default(Regex regex, CharSequence charSequence, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return regex.split(charSequence, i10);
    }

    public static /* synthetic */ e splitToSequence$default(Regex regex, CharSequence charSequence, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return regex.splitToSequence(charSequence, i10);
    }

    public final boolean containsMatchIn(CharSequence input) {
        i.f(input, "input");
        return this.nativePattern.matcher(input).find();
    }

    public final h find(CharSequence input, int i10) {
        i.f(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        i.e(matcher, "nativePattern.matcher(input)");
        return j.a(matcher, i10, input);
    }

    public final e<h> findAll(CharSequence input, int i10) {
        i.f(input, "input");
        if (i10 >= 0 && i10 <= input.length()) {
            return xo.h.e(new b(input, i10), c.INSTANCE);
        }
        throw new IndexOutOfBoundsException("Start index out of bounds: " + i10 + ", input length: " + input.length());
    }

    public final Set<RegexOption> getOptions() {
        Set set = this._options;
        if (set != null) {
            return set;
        }
        int flags = this.nativePattern.flags();
        EnumSet allOf = EnumSet.allOf(RegexOption.class);
        k.v(allOf, new Regex$fromInt$$inlined$apply$lambda$1(flags));
        Set<RegexOption> unmodifiableSet = Collections.unmodifiableSet(allOf);
        i.e(unmodifiableSet, "Collections.unmodifiable…mask == it.value }\n    })");
        this._options = unmodifiableSet;
        return unmodifiableSet;
    }

    public final String getPattern() {
        String pattern = this.nativePattern.pattern();
        i.e(pattern, "nativePattern.pattern()");
        return pattern;
    }

    public final h matchAt(CharSequence input, int i10) {
        i.f(input, "input");
        Matcher region = this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(i10, input.length());
        if (!region.lookingAt()) {
            return null;
        }
        i.e(region, "this");
        return new i(region, input);
    }

    public final h matchEntire(CharSequence input) {
        i.f(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        i.e(matcher, "nativePattern.matcher(input)");
        return j.b(matcher, input);
    }

    public final boolean matches(CharSequence input) {
        i.f(input, "input");
        return this.nativePattern.matcher(input).matches();
    }

    public final boolean matchesAt(CharSequence input, int i10) {
        i.f(input, "input");
        return this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(i10, input.length()).lookingAt();
    }

    public final String replace(CharSequence input, String replacement) {
        i.f(input, "input");
        i.f(replacement, "replacement");
        String replaceAll = this.nativePattern.matcher(input).replaceAll(replacement);
        i.e(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    public final String replaceFirst(CharSequence input, String replacement) {
        i.f(input, "input");
        i.f(replacement, "replacement");
        String replaceFirst = this.nativePattern.matcher(input).replaceFirst(replacement);
        i.e(replaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        return replaceFirst;
    }

    public final List<String> split(CharSequence input, int i10) {
        i.f(input, "input");
        u.j0(i10);
        Matcher matcher = this.nativePattern.matcher(input);
        if (i10 == 1 || !matcher.find()) {
            return k.b(input.toString());
        }
        int i11 = 10;
        if (i10 > 0) {
            i11 = vo.d.f(i10, 10);
        }
        ArrayList arrayList = new ArrayList(i11);
        int i12 = 0;
        int i13 = i10 - 1;
        do {
            arrayList.add(input.subSequence(i12, matcher.start()).toString());
            i12 = matcher.end();
            if (i13 >= 0 && arrayList.size() == i13) {
                break;
            }
        } while (matcher.find());
        arrayList.add(input.subSequence(i12, input.length()).toString());
        return arrayList;
    }

    public final e<String> splitToSequence(CharSequence input, int i10) {
        i.f(input, "input");
        u.j0(i10);
        return xo.h.b(new d(input, i10, null));
    }

    public final Pattern toPattern() {
        return this.nativePattern;
    }

    public String toString() {
        String pattern = this.nativePattern.toString();
        i.e(pattern, "nativePattern.toString()");
        return pattern;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Regex(String pattern) {
        this(r2);
        i.f(pattern, "pattern");
        Pattern compile = Pattern.compile(pattern);
        i.e(compile, "Pattern.compile(pattern)");
    }

    public final String replace(CharSequence input, l<? super h, ? extends CharSequence> transform) {
        i.f(input, "input");
        i.f(transform, "transform");
        int i10 = 0;
        h find$default = find$default(this, input, 0, 2, null);
        if (find$default == null) {
            return input.toString();
        }
        int length = input.length();
        StringBuilder sb2 = new StringBuilder(length);
        do {
            i.d(find$default);
            sb2.append(input, i10, find$default.a().h().intValue());
            sb2.append(transform.invoke(find$default));
            i10 = find$default.a().g().intValue() + 1;
            find$default = find$default.next();
            if (i10 >= length) {
                break;
            }
        } while (find$default != null);
        if (i10 < length) {
            sb2.append(input, i10, length);
        }
        String sb3 = sb2.toString();
        i.e(sb3, "sb.toString()");
        return sb3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Regex(String pattern, RegexOption option) {
        this(r2);
        i.f(pattern, "pattern");
        i.f(option, "option");
        Pattern compile = Pattern.compile(pattern, Companion.b(option.getValue()));
        i.e(compile, "Pattern.compile(pattern,…nicodeCase(option.value))");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Regex(String pattern, Set<? extends RegexOption> options) {
        this(r2);
        i.f(pattern, "pattern");
        i.f(options, "options");
        Pattern compile = Pattern.compile(pattern, Companion.b(j.e(options)));
        i.e(compile, "Pattern.compile(pattern,…odeCase(options.toInt()))");
    }
}
