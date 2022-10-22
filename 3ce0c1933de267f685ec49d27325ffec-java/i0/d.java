package i0;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import j0.c;
/* compiled from: PrecomputedTextCompat.java */
/* loaded from: classes.dex */
public class d implements Spannable {

    /* renamed from: a  reason: collision with root package name */
    private final Spannable f27989a;

    /* renamed from: b  reason: collision with root package name */
    private final a f27990b;

    /* renamed from: c  reason: collision with root package name */
    private final PrecomputedText f27991c;

    public a a() {
        return this.f27990b;
    }

    public PrecomputedText b() {
        Spannable spannable = this.f27989a;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i10) {
        return this.f27989a.charAt(i10);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f27989a.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f27989a.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f27989a.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i10, int i11, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 29) {
            return (T[]) this.f27991c.getSpans(i10, i11, cls);
        }
        return (T[]) this.f27989a.getSpans(i10, i11, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f27989a.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i10, int i11, Class cls) {
        return this.f27989a.nextSpanTransition(i10, i11, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.f27991c.removeSpan(obj);
        } else {
            this.f27989a.removeSpan(obj);
        }
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i10, int i11, int i12) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.f27991c.setSpan(obj, i10, i11, i12);
        } else {
            this.f27989a.setSpan(obj, i10, i11, i12);
        }
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i10, int i11) {
        return this.f27989a.subSequence(i10, i11);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f27989a.toString();
    }

    /* compiled from: PrecomputedTextCompat.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final TextPaint f27992a;

        /* renamed from: b  reason: collision with root package name */
        private final TextDirectionHeuristic f27993b;

        /* renamed from: c  reason: collision with root package name */
        private final int f27994c;

        /* renamed from: d  reason: collision with root package name */
        private final int f27995d;

        /* compiled from: PrecomputedTextCompat.java */
        /* renamed from: i0.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0305a {

            /* renamed from: a  reason: collision with root package name */
            private final TextPaint f27996a;

            /* renamed from: b  reason: collision with root package name */
            private TextDirectionHeuristic f27997b;

            /* renamed from: c  reason: collision with root package name */
            private int f27998c;

            /* renamed from: d  reason: collision with root package name */
            private int f27999d;

            public C0305a(TextPaint textPaint) {
                this.f27996a = textPaint;
                int i10 = Build.VERSION.SDK_INT;
                if (i10 >= 23) {
                    this.f27998c = 1;
                    this.f27999d = 1;
                } else {
                    this.f27999d = 0;
                    this.f27998c = 0;
                }
                if (i10 >= 18) {
                    this.f27997b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.f27997b = null;
                }
            }

            public a a() {
                return new a(this.f27996a, this.f27997b, this.f27998c, this.f27999d);
            }

            public C0305a b(int i10) {
                this.f27998c = i10;
                return this;
            }

            public C0305a c(int i10) {
                this.f27999d = i10;
                return this;
            }

            public C0305a d(TextDirectionHeuristic textDirectionHeuristic) {
                this.f27997b = textDirectionHeuristic;
                return this;
            }
        }

        a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i10, int i11) {
            if (Build.VERSION.SDK_INT >= 29) {
                new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i10).setHyphenationFrequency(i11).setTextDirection(textDirectionHeuristic).build();
            }
            this.f27992a = textPaint;
            this.f27993b = textDirectionHeuristic;
            this.f27994c = i10;
            this.f27995d = i11;
        }

        public boolean a(a aVar) {
            int i10 = Build.VERSION.SDK_INT;
            if ((i10 >= 23 && (this.f27994c != aVar.b() || this.f27995d != aVar.c())) || this.f27992a.getTextSize() != aVar.e().getTextSize() || this.f27992a.getTextScaleX() != aVar.e().getTextScaleX() || this.f27992a.getTextSkewX() != aVar.e().getTextSkewX()) {
                return false;
            }
            if ((i10 >= 21 && (this.f27992a.getLetterSpacing() != aVar.e().getLetterSpacing() || !TextUtils.equals(this.f27992a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()))) || this.f27992a.getFlags() != aVar.e().getFlags()) {
                return false;
            }
            if (i10 >= 24) {
                if (!this.f27992a.getTextLocales().equals(aVar.e().getTextLocales())) {
                    return false;
                }
            } else if (i10 >= 17 && !this.f27992a.getTextLocale().equals(aVar.e().getTextLocale())) {
                return false;
            }
            return this.f27992a.getTypeface() == null ? aVar.e().getTypeface() == null : this.f27992a.getTypeface().equals(aVar.e().getTypeface());
        }

        public int b() {
            return this.f27994c;
        }

        public int c() {
            return this.f27995d;
        }

        public TextDirectionHeuristic d() {
            return this.f27993b;
        }

        public TextPaint e() {
            return this.f27992a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!a(aVar)) {
                return false;
            }
            return Build.VERSION.SDK_INT < 18 || this.f27993b == aVar.d();
        }

        public int hashCode() {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 24) {
                return c.b(Float.valueOf(this.f27992a.getTextSize()), Float.valueOf(this.f27992a.getTextScaleX()), Float.valueOf(this.f27992a.getTextSkewX()), Float.valueOf(this.f27992a.getLetterSpacing()), Integer.valueOf(this.f27992a.getFlags()), this.f27992a.getTextLocales(), this.f27992a.getTypeface(), Boolean.valueOf(this.f27992a.isElegantTextHeight()), this.f27993b, Integer.valueOf(this.f27994c), Integer.valueOf(this.f27995d));
            }
            if (i10 >= 21) {
                return c.b(Float.valueOf(this.f27992a.getTextSize()), Float.valueOf(this.f27992a.getTextScaleX()), Float.valueOf(this.f27992a.getTextSkewX()), Float.valueOf(this.f27992a.getLetterSpacing()), Integer.valueOf(this.f27992a.getFlags()), this.f27992a.getTextLocale(), this.f27992a.getTypeface(), Boolean.valueOf(this.f27992a.isElegantTextHeight()), this.f27993b, Integer.valueOf(this.f27994c), Integer.valueOf(this.f27995d));
            }
            if (i10 >= 18) {
                return c.b(Float.valueOf(this.f27992a.getTextSize()), Float.valueOf(this.f27992a.getTextScaleX()), Float.valueOf(this.f27992a.getTextSkewX()), Integer.valueOf(this.f27992a.getFlags()), this.f27992a.getTextLocale(), this.f27992a.getTypeface(), this.f27993b, Integer.valueOf(this.f27994c), Integer.valueOf(this.f27995d));
            }
            if (i10 >= 17) {
                return c.b(Float.valueOf(this.f27992a.getTextSize()), Float.valueOf(this.f27992a.getTextScaleX()), Float.valueOf(this.f27992a.getTextSkewX()), Integer.valueOf(this.f27992a.getFlags()), this.f27992a.getTextLocale(), this.f27992a.getTypeface(), this.f27993b, Integer.valueOf(this.f27994c), Integer.valueOf(this.f27995d));
            }
            return c.b(Float.valueOf(this.f27992a.getTextSize()), Float.valueOf(this.f27992a.getTextScaleX()), Float.valueOf(this.f27992a.getTextSkewX()), Integer.valueOf(this.f27992a.getFlags()), this.f27992a.getTypeface(), this.f27993b, Integer.valueOf(this.f27994c), Integer.valueOf(this.f27995d));
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("{");
            sb2.append("textSize=" + this.f27992a.getTextSize());
            sb2.append(", textScaleX=" + this.f27992a.getTextScaleX());
            sb2.append(", textSkewX=" + this.f27992a.getTextSkewX());
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 21) {
                sb2.append(", letterSpacing=" + this.f27992a.getLetterSpacing());
                sb2.append(", elegantTextHeight=" + this.f27992a.isElegantTextHeight());
            }
            if (i10 >= 24) {
                sb2.append(", textLocale=" + this.f27992a.getTextLocales());
            } else if (i10 >= 17) {
                sb2.append(", textLocale=" + this.f27992a.getTextLocale());
            }
            sb2.append(", typeface=" + this.f27992a.getTypeface());
            if (i10 >= 26) {
                sb2.append(", variationSettings=" + this.f27992a.getFontVariationSettings());
            }
            sb2.append(", textDir=" + this.f27993b);
            sb2.append(", breakStrategy=" + this.f27994c);
            sb2.append(", hyphenationFrequency=" + this.f27995d);
            sb2.append("}");
            return sb2.toString();
        }

        public a(PrecomputedText.Params params) {
            this.f27992a = params.getTextPaint();
            this.f27993b = params.getTextDirection();
            this.f27994c = params.getBreakStrategy();
            this.f27995d = params.getHyphenationFrequency();
        }
    }
}
