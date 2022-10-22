package androidx.emoji2.text;

import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.emoji2.text.d;
import androidx.emoji2.text.l;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EmojiProcessor.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final d.i f2824a;

    /* renamed from: b  reason: collision with root package name */
    private final l f2825b;

    /* renamed from: c  reason: collision with root package name */
    private d.AbstractC0028d f2826c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f2827d;

    /* renamed from: e  reason: collision with root package name */
    private final int[] f2828e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EmojiProcessor.java */
    /* loaded from: classes.dex */
    public static final class a {
        static int a(CharSequence charSequence, int i10, int i11) {
            int length = charSequence.length();
            if (i10 < 0 || length < i10 || i11 < 0) {
                return -1;
            }
            while (true) {
                boolean z10 = false;
                while (i11 != 0) {
                    i10--;
                    if (i10 < 0) {
                        return z10 ? -1 : 0;
                    }
                    char charAt = charSequence.charAt(i10);
                    if (z10) {
                        if (!Character.isHighSurrogate(charAt)) {
                            return -1;
                        }
                        i11--;
                    } else if (!Character.isSurrogate(charAt)) {
                        i11--;
                    } else if (Character.isHighSurrogate(charAt)) {
                        return -1;
                    } else {
                        z10 = true;
                    }
                }
                return i10;
            }
        }

        static int b(CharSequence charSequence, int i10, int i11) {
            int length = charSequence.length();
            if (i10 < 0 || length < i10 || i11 < 0) {
                return -1;
            }
            boolean z10 = false;
            while (true) {
                while (i11 != 0) {
                    if (i10 < length) {
                        char charAt = charSequence.charAt(i10);
                        if (z10) {
                            if (!Character.isLowSurrogate(charAt)) {
                                return -1;
                            }
                            i11--;
                            i10++;
                        } else if (!Character.isSurrogate(charAt)) {
                            i11--;
                            i10++;
                        } else if (Character.isLowSurrogate(charAt)) {
                            return -1;
                        } else {
                            i10++;
                            z10 = true;
                        }
                    } else if (z10) {
                        return -1;
                    } else {
                        return length;
                    }
                }
                return i10;
            }
        }
    }

    /* compiled from: EmojiProcessor.java */
    /* loaded from: classes.dex */
    public static class b implements d.AbstractC0028d {

        /* renamed from: b  reason: collision with root package name */
        private static final ThreadLocal<StringBuilder> f2829b = new ThreadLocal<>();

        /* renamed from: a  reason: collision with root package name */
        private final TextPaint f2830a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
            TextPaint textPaint = new TextPaint();
            this.f2830a = textPaint;
            textPaint.setTextSize(10.0f);
        }

        private static StringBuilder b() {
            ThreadLocal<StringBuilder> threadLocal = f2829b;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            return threadLocal.get();
        }

        @Override // androidx.emoji2.text.d.AbstractC0028d
        public boolean a(CharSequence charSequence, int i10, int i11, int i12) {
            int i13 = Build.VERSION.SDK_INT;
            if (i13 < 23 && i12 > i13) {
                return false;
            }
            StringBuilder b10 = b();
            b10.setLength(0);
            while (i10 < i11) {
                b10.append(charSequence.charAt(i10));
                i10++;
            }
            return b0.c.a(this.f2830a, b10.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EmojiProcessor.java */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private int f2831a = 1;

        /* renamed from: b  reason: collision with root package name */
        private final l.a f2832b;

        /* renamed from: c  reason: collision with root package name */
        private l.a f2833c;

        /* renamed from: d  reason: collision with root package name */
        private l.a f2834d;

        /* renamed from: e  reason: collision with root package name */
        private int f2835e;

        /* renamed from: f  reason: collision with root package name */
        private int f2836f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f2837g;

        /* renamed from: h  reason: collision with root package name */
        private final int[] f2838h;

        c(l.a aVar, boolean z10, int[] iArr) {
            this.f2832b = aVar;
            this.f2833c = aVar;
            this.f2837g = z10;
            this.f2838h = iArr;
        }

        private static boolean d(int i10) {
            return i10 == 65039;
        }

        private static boolean f(int i10) {
            return i10 == 65038;
        }

        private int g() {
            this.f2831a = 1;
            this.f2833c = this.f2832b;
            this.f2836f = 0;
            return 1;
        }

        private boolean h() {
            if (this.f2833c.b().j() || d(this.f2835e)) {
                return true;
            }
            if (this.f2837g) {
                if (this.f2838h == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.f2838h, this.f2833c.b().b(0)) < 0) {
                    return true;
                }
            }
            return false;
        }

        int a(int i10) {
            l.a a10 = this.f2833c.a(i10);
            int i11 = 3;
            if (this.f2831a == 2) {
                if (a10 != null) {
                    this.f2833c = a10;
                    this.f2836f++;
                } else if (f(i10)) {
                    i11 = g();
                } else if (!d(i10)) {
                    if (this.f2833c.b() == null) {
                        i11 = g();
                    } else if (this.f2836f != 1) {
                        this.f2834d = this.f2833c;
                        g();
                    } else if (h()) {
                        this.f2834d = this.f2833c;
                        g();
                    } else {
                        i11 = g();
                    }
                }
                i11 = 2;
            } else if (a10 == null) {
                i11 = g();
            } else {
                this.f2831a = 2;
                this.f2833c = a10;
                this.f2836f = 1;
                i11 = 2;
            }
            this.f2835e = i10;
            return i11;
        }

        f b() {
            return this.f2833c.b();
        }

        f c() {
            return this.f2834d.b();
        }

        boolean e() {
            return this.f2831a == 2 && this.f2833c.b() != null && (this.f2836f > 1 || h());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(l lVar, d.i iVar, d.AbstractC0028d dVar, boolean z10, int[] iArr) {
        this.f2824a = iVar;
        this.f2825b = lVar;
        this.f2826c = dVar;
        this.f2827d = z10;
        this.f2828e = iArr;
    }

    private void a(Spannable spannable, f fVar, int i10, int i11) {
        spannable.setSpan(this.f2824a.a(fVar), i10, i11, 33);
    }

    private static boolean b(Editable editable, KeyEvent keyEvent, boolean z10) {
        h[] hVarArr;
        if (g(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!f(selectionStart, selectionEnd) && (hVarArr = (h[]) editable.getSpans(selectionStart, selectionEnd, h.class)) != null && hVarArr.length > 0) {
            for (h hVar : hVarArr) {
                int spanStart = editable.getSpanStart(hVar);
                int spanEnd = editable.getSpanEnd(hVar);
                if ((z10 && spanStart == selectionStart) || ((!z10 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(InputConnection inputConnection, Editable editable, int i10, int i11, boolean z10) {
        int i12;
        int i13;
        if (editable != null && inputConnection != null && i10 >= 0 && i11 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (f(selectionStart, selectionEnd)) {
                return false;
            }
            if (z10) {
                i13 = a.a(editable, selectionStart, Math.max(i10, 0));
                i12 = a.b(editable, selectionEnd, Math.max(i11, 0));
                if (i13 == -1 || i12 == -1) {
                    return false;
                }
            } else {
                i13 = Math.max(selectionStart - i10, 0);
                i12 = Math.min(selectionEnd + i11, editable.length());
            }
            h[] hVarArr = (h[]) editable.getSpans(i13, i12, h.class);
            if (hVarArr != null && hVarArr.length > 0) {
                for (h hVar : hVarArr) {
                    int spanStart = editable.getSpanStart(hVar);
                    int spanEnd = editable.getSpanEnd(hVar);
                    i13 = Math.min(spanStart, i13);
                    i12 = Math.max(spanEnd, i12);
                }
                int max = Math.max(i13, 0);
                int min = Math.min(i12, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(max, min);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(Editable editable, int i10, KeyEvent keyEvent) {
        boolean z10;
        if (i10 != 67) {
            z10 = i10 != 112 ? false : b(editable, keyEvent, true);
        } else {
            z10 = b(editable, keyEvent, false);
        }
        if (!z10) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    private boolean e(CharSequence charSequence, int i10, int i11, f fVar) {
        if (fVar.d() == 0) {
            fVar.k(this.f2826c.a(charSequence, i10, i11, fVar.h()));
        }
        return fVar.d() == 2;
    }

    private static boolean f(int i10, int i11) {
        return i10 == -1 || i11 == -1 || i10 != i11;
    }

    private static boolean g(KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x010f, code lost:
        ((androidx.emoji2.text.m) r10).d();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0042 A[Catch: all -> 0x0116, TryCatch #0 {all -> 0x0116, blocks: (B:7:0x000d, B:10:0x0012, B:12:0x0016, B:14:0x0025, B:15:0x002b, B:18:0x0031, B:20:0x003b, B:22:0x003e, B:24:0x0042, B:26:0x004e, B:27:0x0051, B:29:0x005e, B:35:0x006d, B:36:0x007b, B:40:0x0096, B:48:0x00a6, B:51:0x00b2, B:52:0x00b7, B:53:0x00c1, B:55:0x00c8, B:56:0x00cd, B:58:0x00d8, B:60:0x00df, B:64:0x00e9, B:67:0x00f5, B:68:0x00fb), top: B:81:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f5 A[Catch: all -> 0x0116, TryCatch #0 {all -> 0x0116, blocks: (B:7:0x000d, B:10:0x0012, B:12:0x0016, B:14:0x0025, B:15:0x002b, B:18:0x0031, B:20:0x003b, B:22:0x003e, B:24:0x0042, B:26:0x004e, B:27:0x0051, B:29:0x005e, B:35:0x006d, B:36:0x007b, B:40:0x0096, B:48:0x00a6, B:51:0x00b2, B:52:0x00b7, B:53:0x00c1, B:55:0x00c8, B:56:0x00cd, B:58:0x00d8, B:60:0x00df, B:64:0x00e9, B:67:0x00f5, B:68:0x00fb), top: B:81:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0107 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00cd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x009d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CharSequence h(CharSequence charSequence, int i10, int i11, int i12, boolean z10) {
        c cVar;
        int codePointAt;
        SpannableString spannableString;
        int i13;
        int a10;
        h[] hVarArr;
        boolean z11 = charSequence instanceof m;
        if (z11) {
            ((m) charSequence).a();
        }
        Spannable spannable = null;
        if (!z11) {
            try {
                if (!(charSequence instanceof Spannable)) {
                    if ((charSequence instanceof Spanned) && ((Spanned) charSequence).nextSpanTransition(i10 - 1, i11 + 1, h.class) <= i11) {
                        spannable = new SpannableString(charSequence);
                    }
                    if (!(spannable == null || (hVarArr = (h[]) spannable.getSpans(i10, i11, h.class)) == null || hVarArr.length <= 0)) {
                        for (h hVar : hVarArr) {
                            int spanStart = spannable.getSpanStart(hVar);
                            int spanEnd = spannable.getSpanEnd(hVar);
                            if (spanStart != i11) {
                                spannable.removeSpan(hVar);
                            }
                            i10 = Math.min(spanStart, i10);
                            i11 = Math.max(spanEnd, i11);
                        }
                    }
                    if (i10 != i11 && i10 < charSequence.length()) {
                        if (!(i12 == Integer.MAX_VALUE || spannable == null)) {
                            i12 -= ((h[]) spannable.getSpans(0, spannable.length(), h.class)).length;
                        }
                        cVar = new c(this.f2825b.f(), this.f2827d, this.f2828e);
                        codePointAt = Character.codePointAt(charSequence, i10);
                        int i14 = 0;
                        spannableString = spannable;
                        loop1: while (true) {
                            i13 = i10;
                            while (i10 < i11 && i14 < i12) {
                                a10 = cVar.a(codePointAt);
                                if (a10 != 1) {
                                    i13 += Character.charCount(Character.codePointAt(charSequence, i13));
                                    if (i13 < i11) {
                                        codePointAt = Character.codePointAt(charSequence, i13);
                                    }
                                    i10 = i13;
                                } else if (a10 == 2) {
                                    i10 += Character.charCount(codePointAt);
                                    if (i10 < i11) {
                                        codePointAt = Character.codePointAt(charSequence, i10);
                                    }
                                } else if (a10 == 3) {
                                    if (z10 || !e(charSequence, i13, i10, cVar.c())) {
                                        if (spannableString == null) {
                                            spannableString = new SpannableString(charSequence);
                                        }
                                        a(spannableString, cVar.c(), i13, i10);
                                        i14++;
                                    }
                                }
                            }
                        }
                        if (cVar.e() && i14 < i12 && (z10 || !e(charSequence, i13, i10, cVar.b()))) {
                            if (spannableString == null) {
                                spannableString = new SpannableString(charSequence);
                            }
                            a(spannableString, cVar.b(), i13, i10);
                        }
                        if (spannableString == null) {
                            spannableString = charSequence;
                        }
                        return spannableString;
                    }
                    return charSequence;
                }
            } finally {
                if (z11) {
                    ((m) charSequence).d();
                }
            }
        }
        spannable = (Spannable) charSequence;
        if (spannable == null) {
            while (r5 < r4) {
            }
        }
        if (i10 != i11) {
            if (i12 == Integer.MAX_VALUE) {
                i12 -= ((h[]) spannable.getSpans(0, spannable.length(), h.class)).length;
            }
            cVar = new c(this.f2825b.f(), this.f2827d, this.f2828e);
            codePointAt = Character.codePointAt(charSequence, i10);
            int i142 = 0;
            spannableString = spannable;
            loop1: while (true) {
                i13 = i10;
                while (i10 < i11) {
                    a10 = cVar.a(codePointAt);
                    if (a10 != 1) {
                    }
                }
            }
            if (cVar.e()) {
                if (spannableString == null) {
                }
                a(spannableString, cVar.b(), i13, i10);
            }
            if (spannableString == null) {
            }
            return spannableString;
        }
        return charSequence;
    }
}
