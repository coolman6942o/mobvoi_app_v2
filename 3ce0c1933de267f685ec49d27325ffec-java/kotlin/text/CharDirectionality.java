package kotlin.text;

import io.d;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.c0;
import kotlin.jvm.internal.Lambda;
import vo.f;
/* compiled from: CharDirectionality.kt */
/* loaded from: classes3.dex */
public enum CharDirectionality {
    UNDEFINED(-1),
    LEFT_TO_RIGHT(0),
    RIGHT_TO_LEFT(1),
    RIGHT_TO_LEFT_ARABIC(2),
    EUROPEAN_NUMBER(3),
    EUROPEAN_NUMBER_SEPARATOR(4),
    EUROPEAN_NUMBER_TERMINATOR(5),
    ARABIC_NUMBER(6),
    COMMON_NUMBER_SEPARATOR(7),
    NONSPACING_MARK(8),
    BOUNDARY_NEUTRAL(9),
    PARAGRAPH_SEPARATOR(10),
    SEGMENT_SEPARATOR(11),
    WHITESPACE(12),
    OTHER_NEUTRALS(13),
    LEFT_TO_RIGHT_EMBEDDING(14),
    LEFT_TO_RIGHT_OVERRIDE(15),
    RIGHT_TO_LEFT_EMBEDDING(16),
    RIGHT_TO_LEFT_OVERRIDE(17),
    POP_DIRECTIONAL_FORMAT(18);
    
    public static final b Companion = new b(null);
    private static final d directionalityMap$delegate;
    private final int value;

    /* compiled from: CharDirectionality.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements qo.a<Map<Integer, ? extends CharDirectionality>> {
        public static final a INSTANCE = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final Map<Integer, CharDirectionality> invoke() {
            int b10;
            int c10;
            CharDirectionality[] values = CharDirectionality.values();
            b10 = c0.b(values.length);
            c10 = f.c(b10, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(c10);
            for (CharDirectionality charDirectionality : values) {
                linkedHashMap.put(Integer.valueOf(charDirectionality.getValue()), charDirectionality);
            }
            return linkedHashMap;
        }
    }

    /* compiled from: CharDirectionality.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    static {
        d a10;
        a10 = io.f.a(a.INSTANCE);
        directionalityMap$delegate = a10;
    }

    CharDirectionality(int i10) {
        this.value = i10;
    }

    public final int getValue() {
        return this.value;
    }
}
