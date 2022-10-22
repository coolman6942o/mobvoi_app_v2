package kotlin.text;

import kotlin.jvm.internal.f;
/* compiled from: Regex.kt */
/* loaded from: classes3.dex */
public enum RegexOption implements f {
    IGNORE_CASE(2, 0, 2, null),
    MULTILINE(8, 0, 2, null),
    LITERAL(16, 0, 2, null),
    UNIX_LINES(1, 0, 2, null),
    COMMENTS(4, 0, 2, null),
    DOT_MATCHES_ALL(32, 0, 2, null),
    CANON_EQ(128, 0, 2, null);
    
    private final int mask;
    private final int value;

    RegexOption(int i10, int i11) {
        this.value = i10;
        this.mask = i11;
    }

    @Override // kotlin.text.f
    public int getMask() {
        return this.mask;
    }

    @Override // kotlin.text.f
    public int getValue() {
        return this.value;
    }

    /* synthetic */ RegexOption(int i10, int i11, int i12, f fVar) {
        this(i10, (i12 & 2) != 0 ? i10 : i11);
    }
}
