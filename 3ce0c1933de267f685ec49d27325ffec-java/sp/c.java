package sp;

import kotlin.jvm.internal.i;
import okio.SegmentedByteString;
/* compiled from: SegmentedByteString.kt */
/* loaded from: classes3.dex */
public final class c {
    public static final int a(int[] binarySearch, int i10, int i11, int i12) {
        i.f(binarySearch, "$this$binarySearch");
        int i13 = i12 - 1;
        while (i11 <= i13) {
            int i14 = (i11 + i13) >>> 1;
            int i15 = binarySearch[i14];
            if (i15 < i10) {
                i11 = i14 + 1;
            } else if (i15 <= i10) {
                return i14;
            } else {
                i13 = i14 - 1;
            }
        }
        return (-i11) - 1;
    }

    public static final int b(SegmentedByteString segment, int i10) {
        i.f(segment, "$this$segment");
        int a10 = a(segment.getDirectory$okio(), i10 + 1, 0, segment.getSegments$okio().length);
        return a10 >= 0 ? a10 : ~a10;
    }
}
