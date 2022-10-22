package kotlin.text;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import vo.c;
import vo.f;
/* compiled from: Regex.kt */
/* loaded from: classes3.dex */
public final class j {
    public static final /* synthetic */ h a(Matcher matcher, int i10, CharSequence charSequence) {
        return f(matcher, i10, charSequence);
    }

    public static final /* synthetic */ h b(Matcher matcher, CharSequence charSequence) {
        return g(matcher, charSequence);
    }

    public static final /* synthetic */ int e(Iterable iterable) {
        return j(iterable);
    }

    public static final h f(Matcher matcher, int i10, CharSequence charSequence) {
        if (!matcher.find(i10)) {
            return null;
        }
        return new i(matcher, charSequence);
    }

    public static final h g(Matcher matcher, CharSequence charSequence) {
        if (!matcher.matches()) {
            return null;
        }
        return new i(matcher, charSequence);
    }

    public static final c h(MatchResult matchResult) {
        c k10;
        k10 = f.k(matchResult.start(), matchResult.end());
        return k10;
    }

    public static final c i(MatchResult matchResult, int i10) {
        c k10;
        k10 = f.k(matchResult.start(i10), matchResult.end(i10));
        return k10;
    }

    public static final int j(Iterable<? extends f> iterable) {
        int i10 = 0;
        for (f fVar : iterable) {
            i10 |= fVar.getValue();
        }
        return i10;
    }
}
