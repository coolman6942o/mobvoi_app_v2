package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.j;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.d;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: ConstraintSet.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f1861d = {0, 4, 8};

    /* renamed from: e  reason: collision with root package name */
    private static SparseIntArray f1862e = new SparseIntArray();

    /* renamed from: f  reason: collision with root package name */
    private static SparseIntArray f1863f = new SparseIntArray();

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, ConstraintAttribute> f1864a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private boolean f1865b = true;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<Integer, a> f1866c = new HashMap<>();

    /* compiled from: ConstraintSet.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f1867a;

        /* renamed from: b  reason: collision with root package name */
        public final d f1868b = new d();

        /* renamed from: c  reason: collision with root package name */
        public final C0013c f1869c = new C0013c();

        /* renamed from: d  reason: collision with root package name */
        public final b f1870d = new b();

        /* renamed from: e  reason: collision with root package name */
        public final e f1871e = new e();

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, ConstraintAttribute> f1872f = new HashMap<>();

        /* renamed from: g  reason: collision with root package name */
        C0012a f1873g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ConstraintSet.java */
        /* renamed from: androidx.constraintlayout.widget.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0012a {

            /* renamed from: a  reason: collision with root package name */
            int[] f1874a = new int[10];

            /* renamed from: b  reason: collision with root package name */
            int[] f1875b = new int[10];

            /* renamed from: c  reason: collision with root package name */
            int f1876c = 0;

            /* renamed from: d  reason: collision with root package name */
            int[] f1877d = new int[10];

            /* renamed from: e  reason: collision with root package name */
            float[] f1878e = new float[10];

            /* renamed from: f  reason: collision with root package name */
            int f1879f = 0;

            /* renamed from: g  reason: collision with root package name */
            int[] f1880g = new int[5];

            /* renamed from: h  reason: collision with root package name */
            String[] f1881h = new String[5];

            /* renamed from: i  reason: collision with root package name */
            int f1882i = 0;

            /* renamed from: j  reason: collision with root package name */
            int[] f1883j = new int[4];

            /* renamed from: k  reason: collision with root package name */
            boolean[] f1884k = new boolean[4];

            /* renamed from: l  reason: collision with root package name */
            int f1885l = 0;

            C0012a() {
            }

            void a(int i10, float f10) {
                int i11 = this.f1879f;
                int[] iArr = this.f1877d;
                if (i11 >= iArr.length) {
                    this.f1877d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.f1878e;
                    this.f1878e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.f1877d;
                int i12 = this.f1879f;
                iArr2[i12] = i10;
                float[] fArr2 = this.f1878e;
                this.f1879f = i12 + 1;
                fArr2[i12] = f10;
            }

            void b(int i10, int i11) {
                int i12 = this.f1876c;
                int[] iArr = this.f1874a;
                if (i12 >= iArr.length) {
                    this.f1874a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.f1875b;
                    this.f1875b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.f1874a;
                int i13 = this.f1876c;
                iArr3[i13] = i10;
                int[] iArr4 = this.f1875b;
                this.f1876c = i13 + 1;
                iArr4[i13] = i11;
            }

            void c(int i10, String str) {
                int i11 = this.f1882i;
                int[] iArr = this.f1880g;
                if (i11 >= iArr.length) {
                    this.f1880g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.f1881h;
                    this.f1881h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.f1880g;
                int i12 = this.f1882i;
                iArr2[i12] = i10;
                String[] strArr2 = this.f1881h;
                this.f1882i = i12 + 1;
                strArr2[i12] = str;
            }

            void d(int i10, boolean z10) {
                int i11 = this.f1885l;
                int[] iArr = this.f1883j;
                if (i11 >= iArr.length) {
                    this.f1883j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.f1884k;
                    this.f1884k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.f1883j;
                int i12 = this.f1885l;
                iArr2[i12] = i10;
                boolean[] zArr2 = this.f1884k;
                this.f1885l = i12 + 1;
                zArr2[i12] = z10;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(int i10, ConstraintLayout.b bVar) {
            this.f1867a = i10;
            b bVar2 = this.f1870d;
            bVar2.f1901h = bVar.f1790d;
            bVar2.f1903i = bVar.f1792e;
            bVar2.f1905j = bVar.f1794f;
            bVar2.f1907k = bVar.f1796g;
            bVar2.f1909l = bVar.f1798h;
            bVar2.f1911m = bVar.f1800i;
            bVar2.f1913n = bVar.f1802j;
            bVar2.f1915o = bVar.f1804k;
            bVar2.f1917p = bVar.f1806l;
            bVar2.f1918q = bVar.f1808m;
            bVar2.f1919r = bVar.f1810n;
            bVar2.f1920s = bVar.f1818r;
            bVar2.f1921t = bVar.f1819s;
            bVar2.f1922u = bVar.f1820t;
            bVar2.f1923v = bVar.f1821u;
            bVar2.f1924w = bVar.D;
            bVar2.f1925x = bVar.E;
            bVar2.f1926y = bVar.F;
            bVar2.f1927z = bVar.f1812o;
            bVar2.A = bVar.f1814p;
            bVar2.B = bVar.f1816q;
            bVar2.C = bVar.S;
            bVar2.D = bVar.T;
            bVar2.E = bVar.U;
            bVar2.f1899g = bVar.f1788c;
            bVar2.f1895e = bVar.f1784a;
            bVar2.f1897f = bVar.f1786b;
            bVar2.f1891c = ((ViewGroup.MarginLayoutParams) bVar).width;
            bVar2.f1893d = ((ViewGroup.MarginLayoutParams) bVar).height;
            bVar2.F = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
            bVar2.G = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
            bVar2.H = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
            bVar2.I = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
            bVar2.L = bVar.C;
            bVar2.T = bVar.H;
            bVar2.U = bVar.G;
            bVar2.W = bVar.J;
            bVar2.V = bVar.I;
            bVar2.f1910l0 = bVar.V;
            bVar2.f1912m0 = bVar.W;
            bVar2.X = bVar.K;
            bVar2.Y = bVar.L;
            bVar2.Z = bVar.O;
            bVar2.f1888a0 = bVar.P;
            bVar2.f1890b0 = bVar.M;
            bVar2.f1892c0 = bVar.N;
            bVar2.f1894d0 = bVar.Q;
            bVar2.f1896e0 = bVar.R;
            bVar2.f1908k0 = bVar.X;
            bVar2.N = bVar.f1823w;
            bVar2.P = bVar.f1825y;
            bVar2.M = bVar.f1822v;
            bVar2.O = bVar.f1824x;
            bVar2.R = bVar.f1826z;
            bVar2.Q = bVar.A;
            bVar2.S = bVar.B;
            bVar2.f1916o0 = bVar.Y;
            if (Build.VERSION.SDK_INT >= 17) {
                bVar2.J = bVar.getMarginEnd();
                this.f1870d.K = bVar.getMarginStart();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(int i10, d.a aVar) {
            f(i10, aVar);
            this.f1868b.f1946d = aVar.f1964r0;
            e eVar = this.f1871e;
            eVar.f1950b = aVar.f1967u0;
            eVar.f1951c = aVar.f1968v0;
            eVar.f1952d = aVar.f1969w0;
            eVar.f1953e = aVar.f1970x0;
            eVar.f1954f = aVar.f1971y0;
            eVar.f1955g = aVar.f1972z0;
            eVar.f1956h = aVar.A0;
            eVar.f1958j = aVar.B0;
            eVar.f1959k = aVar.C0;
            eVar.f1960l = aVar.D0;
            eVar.f1962n = aVar.f1966t0;
            eVar.f1961m = aVar.f1965s0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(androidx.constraintlayout.widget.a aVar, int i10, d.a aVar2) {
            g(i10, aVar2);
            if (aVar instanceof Barrier) {
                b bVar = this.f1870d;
                bVar.f1902h0 = 1;
                Barrier barrier = (Barrier) aVar;
                bVar.f1898f0 = barrier.getType();
                this.f1870d.f1904i0 = barrier.getReferencedIds();
                this.f1870d.f1900g0 = barrier.getMargin();
            }
        }

        public void d(ConstraintLayout.b bVar) {
            b bVar2 = this.f1870d;
            bVar.f1790d = bVar2.f1901h;
            bVar.f1792e = bVar2.f1903i;
            bVar.f1794f = bVar2.f1905j;
            bVar.f1796g = bVar2.f1907k;
            bVar.f1798h = bVar2.f1909l;
            bVar.f1800i = bVar2.f1911m;
            bVar.f1802j = bVar2.f1913n;
            bVar.f1804k = bVar2.f1915o;
            bVar.f1806l = bVar2.f1917p;
            bVar.f1808m = bVar2.f1918q;
            bVar.f1810n = bVar2.f1919r;
            bVar.f1818r = bVar2.f1920s;
            bVar.f1819s = bVar2.f1921t;
            bVar.f1820t = bVar2.f1922u;
            bVar.f1821u = bVar2.f1923v;
            ((ViewGroup.MarginLayoutParams) bVar).leftMargin = bVar2.F;
            ((ViewGroup.MarginLayoutParams) bVar).rightMargin = bVar2.G;
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = bVar2.H;
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = bVar2.I;
            bVar.f1826z = bVar2.R;
            bVar.A = bVar2.Q;
            bVar.f1823w = bVar2.N;
            bVar.f1825y = bVar2.P;
            bVar.D = bVar2.f1924w;
            bVar.E = bVar2.f1925x;
            bVar.f1812o = bVar2.f1927z;
            bVar.f1814p = bVar2.A;
            bVar.f1816q = bVar2.B;
            bVar.F = bVar2.f1926y;
            bVar.S = bVar2.C;
            bVar.T = bVar2.D;
            bVar.H = bVar2.T;
            bVar.G = bVar2.U;
            bVar.J = bVar2.W;
            bVar.I = bVar2.V;
            bVar.V = bVar2.f1910l0;
            bVar.W = bVar2.f1912m0;
            bVar.K = bVar2.X;
            bVar.L = bVar2.Y;
            bVar.O = bVar2.Z;
            bVar.P = bVar2.f1888a0;
            bVar.M = bVar2.f1890b0;
            bVar.N = bVar2.f1892c0;
            bVar.Q = bVar2.f1894d0;
            bVar.R = bVar2.f1896e0;
            bVar.U = bVar2.E;
            bVar.f1788c = bVar2.f1899g;
            bVar.f1784a = bVar2.f1895e;
            bVar.f1786b = bVar2.f1897f;
            ((ViewGroup.MarginLayoutParams) bVar).width = bVar2.f1891c;
            ((ViewGroup.MarginLayoutParams) bVar).height = bVar2.f1893d;
            String str = bVar2.f1908k0;
            if (str != null) {
                bVar.X = str;
            }
            bVar.Y = bVar2.f1916o0;
            if (Build.VERSION.SDK_INT >= 17) {
                bVar.setMarginStart(bVar2.K);
                bVar.setMarginEnd(this.f1870d.J);
            }
            bVar.a();
        }

        /* renamed from: e */
        public a clone() {
            a aVar = new a();
            aVar.f1870d.a(this.f1870d);
            aVar.f1869c.a(this.f1869c);
            aVar.f1868b.a(this.f1868b);
            aVar.f1871e.a(this.f1871e);
            aVar.f1867a = this.f1867a;
            aVar.f1873g = this.f1873g;
            return aVar;
        }
    }

    /* compiled from: ConstraintSet.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: p0  reason: collision with root package name */
        private static SparseIntArray f1886p0;

        /* renamed from: c  reason: collision with root package name */
        public int f1891c;

        /* renamed from: d  reason: collision with root package name */
        public int f1893d;

        /* renamed from: i0  reason: collision with root package name */
        public int[] f1904i0;

        /* renamed from: j0  reason: collision with root package name */
        public String f1906j0;

        /* renamed from: k0  reason: collision with root package name */
        public String f1908k0;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1887a = false;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1889b = false;

        /* renamed from: e  reason: collision with root package name */
        public int f1895e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f1897f = -1;

        /* renamed from: g  reason: collision with root package name */
        public float f1899g = -1.0f;

        /* renamed from: h  reason: collision with root package name */
        public int f1901h = -1;

        /* renamed from: i  reason: collision with root package name */
        public int f1903i = -1;

        /* renamed from: j  reason: collision with root package name */
        public int f1905j = -1;

        /* renamed from: k  reason: collision with root package name */
        public int f1907k = -1;

        /* renamed from: l  reason: collision with root package name */
        public int f1909l = -1;

        /* renamed from: m  reason: collision with root package name */
        public int f1911m = -1;

        /* renamed from: n  reason: collision with root package name */
        public int f1913n = -1;

        /* renamed from: o  reason: collision with root package name */
        public int f1915o = -1;

        /* renamed from: p  reason: collision with root package name */
        public int f1917p = -1;

        /* renamed from: q  reason: collision with root package name */
        public int f1918q = -1;

        /* renamed from: r  reason: collision with root package name */
        public int f1919r = -1;

        /* renamed from: s  reason: collision with root package name */
        public int f1920s = -1;

        /* renamed from: t  reason: collision with root package name */
        public int f1921t = -1;

        /* renamed from: u  reason: collision with root package name */
        public int f1922u = -1;

        /* renamed from: v  reason: collision with root package name */
        public int f1923v = -1;

        /* renamed from: w  reason: collision with root package name */
        public float f1924w = 0.5f;

        /* renamed from: x  reason: collision with root package name */
        public float f1925x = 0.5f;

        /* renamed from: y  reason: collision with root package name */
        public String f1926y = null;

        /* renamed from: z  reason: collision with root package name */
        public int f1927z = -1;
        public int A = 0;
        public float B = 0.0f;
        public int C = -1;
        public int D = -1;
        public int E = -1;
        public int F = 0;
        public int G = 0;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = Integer.MIN_VALUE;
        public int N = Integer.MIN_VALUE;
        public int O = Integer.MIN_VALUE;
        public int P = Integer.MIN_VALUE;
        public int Q = Integer.MIN_VALUE;
        public int R = Integer.MIN_VALUE;
        public int S = Integer.MIN_VALUE;
        public float T = -1.0f;
        public float U = -1.0f;
        public int V = 0;
        public int W = 0;
        public int X = 0;
        public int Y = 0;
        public int Z = 0;

        /* renamed from: a0  reason: collision with root package name */
        public int f1888a0 = 0;

        /* renamed from: b0  reason: collision with root package name */
        public int f1890b0 = 0;

        /* renamed from: c0  reason: collision with root package name */
        public int f1892c0 = 0;

        /* renamed from: d0  reason: collision with root package name */
        public float f1894d0 = 1.0f;

        /* renamed from: e0  reason: collision with root package name */
        public float f1896e0 = 1.0f;

        /* renamed from: f0  reason: collision with root package name */
        public int f1898f0 = -1;

        /* renamed from: g0  reason: collision with root package name */
        public int f1900g0 = 0;

        /* renamed from: h0  reason: collision with root package name */
        public int f1902h0 = -1;

        /* renamed from: l0  reason: collision with root package name */
        public boolean f1910l0 = false;

        /* renamed from: m0  reason: collision with root package name */
        public boolean f1912m0 = false;

        /* renamed from: n0  reason: collision with root package name */
        public boolean f1914n0 = true;

        /* renamed from: o0  reason: collision with root package name */
        public int f1916o0 = 0;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1886p0 = sparseIntArray;
            sparseIntArray.append(h.Y4, 24);
            f1886p0.append(h.Z4, 25);
            f1886p0.append(h.f1990b5, 28);
            f1886p0.append(h.f1998c5, 29);
            f1886p0.append(h.f2038h5, 35);
            f1886p0.append(h.f2030g5, 34);
            f1886p0.append(h.I4, 4);
            f1886p0.append(h.H4, 3);
            f1886p0.append(h.F4, 1);
            f1886p0.append(h.f2084n5, 6);
            f1886p0.append(h.f2091o5, 7);
            f1886p0.append(h.P4, 17);
            f1886p0.append(h.Q4, 18);
            f1886p0.append(h.R4, 19);
            f1886p0.append(h.f2090o4, 26);
            f1886p0.append(h.f2006d5, 31);
            f1886p0.append(h.f2014e5, 32);
            f1886p0.append(h.O4, 10);
            f1886p0.append(h.N4, 9);
            f1886p0.append(h.f2111r5, 13);
            f1886p0.append(h.f2132u5, 16);
            f1886p0.append(h.f2118s5, 14);
            f1886p0.append(h.f2098p5, 11);
            f1886p0.append(h.f2125t5, 15);
            f1886p0.append(h.q5, 12);
            f1886p0.append(h.f2062k5, 38);
            f1886p0.append(h.W4, 37);
            f1886p0.append(h.V4, 39);
            f1886p0.append(h.f2054j5, 40);
            f1886p0.append(h.U4, 20);
            f1886p0.append(h.f2046i5, 36);
            f1886p0.append(h.M4, 5);
            f1886p0.append(h.X4, 76);
            f1886p0.append(h.f2022f5, 76);
            f1886p0.append(h.f1982a5, 76);
            f1886p0.append(h.G4, 76);
            f1886p0.append(h.E4, 76);
            f1886p0.append(h.f2110r4, 23);
            f1886p0.append(h.f2124t4, 27);
            f1886p0.append(h.f2138v4, 30);
            f1886p0.append(h.f2145w4, 8);
            f1886p0.append(h.f2117s4, 33);
            f1886p0.append(h.f2131u4, 2);
            f1886p0.append(h.f2097p4, 22);
            f1886p0.append(h.f2104q4, 21);
            f1886p0.append(h.f2070l5, 41);
            f1886p0.append(h.S4, 42);
            f1886p0.append(h.D4, 41);
            f1886p0.append(h.C4, 42);
            f1886p0.append(h.f2139v5, 97);
            f1886p0.append(h.J4, 61);
            f1886p0.append(h.L4, 62);
            f1886p0.append(h.K4, 63);
            f1886p0.append(h.f2077m5, 69);
            f1886p0.append(h.T4, 70);
            f1886p0.append(h.A4, 71);
            f1886p0.append(h.f2159y4, 72);
            f1886p0.append(h.f2166z4, 73);
            f1886p0.append(h.B4, 74);
            f1886p0.append(h.f2152x4, 75);
        }

        public void a(b bVar) {
            this.f1887a = bVar.f1887a;
            this.f1891c = bVar.f1891c;
            this.f1889b = bVar.f1889b;
            this.f1893d = bVar.f1893d;
            this.f1895e = bVar.f1895e;
            this.f1897f = bVar.f1897f;
            this.f1899g = bVar.f1899g;
            this.f1901h = bVar.f1901h;
            this.f1903i = bVar.f1903i;
            this.f1905j = bVar.f1905j;
            this.f1907k = bVar.f1907k;
            this.f1909l = bVar.f1909l;
            this.f1911m = bVar.f1911m;
            this.f1913n = bVar.f1913n;
            this.f1915o = bVar.f1915o;
            this.f1917p = bVar.f1917p;
            this.f1918q = bVar.f1918q;
            this.f1919r = bVar.f1919r;
            this.f1920s = bVar.f1920s;
            this.f1921t = bVar.f1921t;
            this.f1922u = bVar.f1922u;
            this.f1923v = bVar.f1923v;
            this.f1924w = bVar.f1924w;
            this.f1925x = bVar.f1925x;
            this.f1926y = bVar.f1926y;
            this.f1927z = bVar.f1927z;
            this.A = bVar.A;
            this.B = bVar.B;
            this.C = bVar.C;
            this.D = bVar.D;
            this.E = bVar.E;
            this.F = bVar.F;
            this.G = bVar.G;
            this.H = bVar.H;
            this.I = bVar.I;
            this.J = bVar.J;
            this.K = bVar.K;
            this.L = bVar.L;
            this.M = bVar.M;
            this.N = bVar.N;
            this.O = bVar.O;
            this.P = bVar.P;
            this.Q = bVar.Q;
            this.R = bVar.R;
            this.S = bVar.S;
            this.T = bVar.T;
            this.U = bVar.U;
            this.V = bVar.V;
            this.W = bVar.W;
            this.X = bVar.X;
            this.Y = bVar.Y;
            this.Z = bVar.Z;
            this.f1888a0 = bVar.f1888a0;
            this.f1890b0 = bVar.f1890b0;
            this.f1892c0 = bVar.f1892c0;
            this.f1894d0 = bVar.f1894d0;
            this.f1896e0 = bVar.f1896e0;
            this.f1898f0 = bVar.f1898f0;
            this.f1900g0 = bVar.f1900g0;
            this.f1902h0 = bVar.f1902h0;
            this.f1908k0 = bVar.f1908k0;
            int[] iArr = bVar.f1904i0;
            if (iArr == null || bVar.f1906j0 != null) {
                this.f1904i0 = null;
            } else {
                this.f1904i0 = Arrays.copyOf(iArr, iArr.length);
            }
            this.f1906j0 = bVar.f1906j0;
            this.f1910l0 = bVar.f1910l0;
            this.f1912m0 = bVar.f1912m0;
            this.f1914n0 = bVar.f1914n0;
            this.f1916o0 = bVar.f1916o0;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.f2083n4);
            this.f1889b = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                int i11 = f1886p0.get(index);
                if (i11 == 80) {
                    this.f1910l0 = obtainStyledAttributes.getBoolean(index, this.f1910l0);
                } else if (i11 == 81) {
                    this.f1912m0 = obtainStyledAttributes.getBoolean(index, this.f1912m0);
                } else if (i11 != 97) {
                    switch (i11) {
                        case 1:
                            this.f1917p = c.o(obtainStyledAttributes, index, this.f1917p);
                            continue;
                        case 2:
                            this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                            continue;
                        case 3:
                            this.f1915o = c.o(obtainStyledAttributes, index, this.f1915o);
                            continue;
                        case 4:
                            this.f1913n = c.o(obtainStyledAttributes, index, this.f1913n);
                            continue;
                        case 5:
                            this.f1926y = obtainStyledAttributes.getString(index);
                            continue;
                        case 6:
                            this.C = obtainStyledAttributes.getDimensionPixelOffset(index, this.C);
                            continue;
                        case 7:
                            this.D = obtainStyledAttributes.getDimensionPixelOffset(index, this.D);
                            continue;
                        case 8:
                            if (Build.VERSION.SDK_INT >= 17) {
                                this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                                break;
                            } else {
                                continue;
                            }
                        case 9:
                            this.f1923v = c.o(obtainStyledAttributes, index, this.f1923v);
                            continue;
                        case 10:
                            this.f1922u = c.o(obtainStyledAttributes, index, this.f1922u);
                            continue;
                        case 11:
                            this.P = obtainStyledAttributes.getDimensionPixelSize(index, this.P);
                            continue;
                        case 12:
                            this.Q = obtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                            continue;
                        case 13:
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            continue;
                        case 14:
                            this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                            continue;
                        case 15:
                            this.R = obtainStyledAttributes.getDimensionPixelSize(index, this.R);
                            continue;
                        case 16:
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            continue;
                        case 17:
                            this.f1895e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1895e);
                            continue;
                        case 18:
                            this.f1897f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1897f);
                            continue;
                        case 19:
                            this.f1899g = obtainStyledAttributes.getFloat(index, this.f1899g);
                            continue;
                        case 20:
                            this.f1924w = obtainStyledAttributes.getFloat(index, this.f1924w);
                            continue;
                        case 21:
                            this.f1893d = obtainStyledAttributes.getLayoutDimension(index, this.f1893d);
                            continue;
                        case 22:
                            this.f1891c = obtainStyledAttributes.getLayoutDimension(index, this.f1891c);
                            continue;
                        case 23:
                            this.F = obtainStyledAttributes.getDimensionPixelSize(index, this.F);
                            continue;
                        case 24:
                            this.f1901h = c.o(obtainStyledAttributes, index, this.f1901h);
                            continue;
                        case 25:
                            this.f1903i = c.o(obtainStyledAttributes, index, this.f1903i);
                            continue;
                        case 26:
                            this.E = obtainStyledAttributes.getInt(index, this.E);
                            continue;
                        case 27:
                            this.G = obtainStyledAttributes.getDimensionPixelSize(index, this.G);
                            continue;
                        case 28:
                            this.f1905j = c.o(obtainStyledAttributes, index, this.f1905j);
                            continue;
                        case 29:
                            this.f1907k = c.o(obtainStyledAttributes, index, this.f1907k);
                            continue;
                        case 30:
                            if (Build.VERSION.SDK_INT >= 17) {
                                this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                                break;
                            } else {
                                continue;
                            }
                        case 31:
                            this.f1920s = c.o(obtainStyledAttributes, index, this.f1920s);
                            continue;
                        case 32:
                            this.f1921t = c.o(obtainStyledAttributes, index, this.f1921t);
                            continue;
                        case 33:
                            this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
                            continue;
                        case 34:
                            this.f1911m = c.o(obtainStyledAttributes, index, this.f1911m);
                            continue;
                        case 35:
                            this.f1909l = c.o(obtainStyledAttributes, index, this.f1909l);
                            continue;
                        case 36:
                            this.f1925x = obtainStyledAttributes.getFloat(index, this.f1925x);
                            continue;
                        case 37:
                            this.U = obtainStyledAttributes.getFloat(index, this.U);
                            continue;
                        case 38:
                            this.T = obtainStyledAttributes.getFloat(index, this.T);
                            continue;
                        case 39:
                            this.V = obtainStyledAttributes.getInt(index, this.V);
                            continue;
                        case 40:
                            this.W = obtainStyledAttributes.getInt(index, this.W);
                            continue;
                        case 41:
                            c.p(this, obtainStyledAttributes, index, 0);
                            continue;
                        case 42:
                            c.p(this, obtainStyledAttributes, index, 1);
                            continue;
                        default:
                            switch (i11) {
                                case 54:
                                    this.X = obtainStyledAttributes.getInt(index, this.X);
                                    continue;
                                case 55:
                                    this.Y = obtainStyledAttributes.getInt(index, this.Y);
                                    continue;
                                case 56:
                                    this.Z = obtainStyledAttributes.getDimensionPixelSize(index, this.Z);
                                    continue;
                                case 57:
                                    this.f1888a0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f1888a0);
                                    continue;
                                case 58:
                                    this.f1890b0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f1890b0);
                                    continue;
                                case 59:
                                    this.f1892c0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f1892c0);
                                    continue;
                                default:
                                    switch (i11) {
                                        case 61:
                                            this.f1927z = c.o(obtainStyledAttributes, index, this.f1927z);
                                            continue;
                                        case 62:
                                            this.A = obtainStyledAttributes.getDimensionPixelSize(index, this.A);
                                            continue;
                                        case 63:
                                            this.B = obtainStyledAttributes.getFloat(index, this.B);
                                            continue;
                                        default:
                                            switch (i11) {
                                                case 69:
                                                    this.f1894d0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    continue;
                                                case 70:
                                                    this.f1896e0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    continue;
                                                case 71:
                                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                                    continue;
                                                case 72:
                                                    this.f1898f0 = obtainStyledAttributes.getInt(index, this.f1898f0);
                                                    continue;
                                                case 73:
                                                    this.f1900g0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f1900g0);
                                                    continue;
                                                case 74:
                                                    this.f1906j0 = obtainStyledAttributes.getString(index);
                                                    continue;
                                                case 75:
                                                    this.f1914n0 = obtainStyledAttributes.getBoolean(index, this.f1914n0);
                                                    continue;
                                                case 76:
                                                    String hexString = Integer.toHexString(index);
                                                    int i12 = f1886p0.get(index);
                                                    StringBuilder sb2 = new StringBuilder(String.valueOf(hexString).length() + 33);
                                                    sb2.append("unused attribute 0x");
                                                    sb2.append(hexString);
                                                    sb2.append("   ");
                                                    sb2.append(i12);
                                                    Log.w("ConstraintSet", sb2.toString());
                                                    continue;
                                                case 77:
                                                    this.f1908k0 = obtainStyledAttributes.getString(index);
                                                    continue;
                                                default:
                                                    switch (i11) {
                                                        case 91:
                                                            this.f1918q = c.o(obtainStyledAttributes, index, this.f1918q);
                                                            continue;
                                                        case 92:
                                                            this.f1919r = c.o(obtainStyledAttributes, index, this.f1919r);
                                                            continue;
                                                        case 93:
                                                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                                                            continue;
                                                        case 94:
                                                            this.S = obtainStyledAttributes.getDimensionPixelSize(index, this.S);
                                                            continue;
                                                        default:
                                                            String hexString2 = Integer.toHexString(index);
                                                            int i13 = f1886p0.get(index);
                                                            StringBuilder sb3 = new StringBuilder(String.valueOf(hexString2).length() + 34);
                                                            sb3.append("Unknown attribute 0x");
                                                            sb3.append(hexString2);
                                                            sb3.append("   ");
                                                            sb3.append(i13);
                                                            Log.w("ConstraintSet", sb3.toString());
                                                            continue;
                                                            continue;
                                                            continue;
                                                            continue;
                                                            continue;
                                                    }
                                            }
                                    }
                            }
                    }
                } else {
                    this.f1916o0 = obtainStyledAttributes.getInt(index, this.f1916o0);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: ConstraintSet.java */
    /* renamed from: androidx.constraintlayout.widget.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0013c {

        /* renamed from: o  reason: collision with root package name */
        private static SparseIntArray f1928o;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1929a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f1930b = -1;

        /* renamed from: c  reason: collision with root package name */
        public int f1931c = 0;

        /* renamed from: d  reason: collision with root package name */
        public String f1932d = null;

        /* renamed from: e  reason: collision with root package name */
        public int f1933e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f1934f = 0;

        /* renamed from: g  reason: collision with root package name */
        public float f1935g = Float.NaN;

        /* renamed from: h  reason: collision with root package name */
        public int f1936h = -1;

        /* renamed from: i  reason: collision with root package name */
        public float f1937i = Float.NaN;

        /* renamed from: j  reason: collision with root package name */
        public float f1938j = Float.NaN;

        /* renamed from: k  reason: collision with root package name */
        public int f1939k = -1;

        /* renamed from: l  reason: collision with root package name */
        public String f1940l = null;

        /* renamed from: m  reason: collision with root package name */
        public int f1941m = -3;

        /* renamed from: n  reason: collision with root package name */
        public int f1942n = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1928o = sparseIntArray;
            sparseIntArray.append(h.A5, 1);
            f1928o.append(h.C5, 2);
            f1928o.append(h.G5, 3);
            f1928o.append(h.f2167z5, 4);
            f1928o.append(h.f2160y5, 5);
            f1928o.append(h.f2153x5, 6);
            f1928o.append(h.B5, 7);
            f1928o.append(h.F5, 8);
            f1928o.append(h.E5, 9);
            f1928o.append(h.D5, 10);
        }

        public void a(C0013c cVar) {
            this.f1929a = cVar.f1929a;
            this.f1930b = cVar.f1930b;
            this.f1932d = cVar.f1932d;
            this.f1933e = cVar.f1933e;
            this.f1934f = cVar.f1934f;
            this.f1937i = cVar.f1937i;
            this.f1935g = cVar.f1935g;
            this.f1936h = cVar.f1936h;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.f2146w5);
            this.f1929a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                switch (f1928o.get(index)) {
                    case 1:
                        this.f1937i = obtainStyledAttributes.getFloat(index, this.f1937i);
                        break;
                    case 2:
                        this.f1933e = obtainStyledAttributes.getInt(index, this.f1933e);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            this.f1932d = obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            this.f1932d = s.b.f34203c[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        this.f1934f = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f1930b = c.o(obtainStyledAttributes, index, this.f1930b);
                        break;
                    case 6:
                        this.f1931c = obtainStyledAttributes.getInteger(index, this.f1931c);
                        break;
                    case 7:
                        this.f1935g = obtainStyledAttributes.getFloat(index, this.f1935g);
                        break;
                    case 8:
                        this.f1939k = obtainStyledAttributes.getInteger(index, this.f1939k);
                        break;
                    case 9:
                        this.f1938j = obtainStyledAttributes.getFloat(index, this.f1938j);
                        break;
                    case 10:
                        int i11 = obtainStyledAttributes.peekValue(index).type;
                        if (i11 != 1) {
                            if (i11 == 3) {
                                String string = obtainStyledAttributes.getString(index);
                                this.f1940l = string;
                                if (string.indexOf("/") > 0) {
                                    this.f1942n = obtainStyledAttributes.getResourceId(index, -1);
                                    this.f1941m = -2;
                                    break;
                                } else {
                                    this.f1941m = -1;
                                    break;
                                }
                            } else {
                                this.f1941m = obtainStyledAttributes.getInteger(index, this.f1942n);
                                break;
                            }
                        } else {
                            int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                            this.f1942n = resourceId;
                            if (resourceId != -1) {
                                this.f1941m = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: ConstraintSet.java */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1943a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f1944b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f1945c = 0;

        /* renamed from: d  reason: collision with root package name */
        public float f1946d = 1.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f1947e = Float.NaN;

        public void a(d dVar) {
            this.f1943a = dVar.f1943a;
            this.f1944b = dVar.f1944b;
            this.f1946d = dVar.f1946d;
            this.f1947e = dVar.f1947e;
            this.f1945c = dVar.f1945c;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.K5);
            this.f1943a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == h.M5) {
                    this.f1946d = obtainStyledAttributes.getFloat(index, this.f1946d);
                } else if (index == h.L5) {
                    this.f1944b = obtainStyledAttributes.getInt(index, this.f1944b);
                    this.f1944b = c.f1861d[this.f1944b];
                } else if (index == h.O5) {
                    this.f1945c = obtainStyledAttributes.getInt(index, this.f1945c);
                } else if (index == h.N5) {
                    this.f1947e = obtainStyledAttributes.getFloat(index, this.f1947e);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: ConstraintSet.java */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: o  reason: collision with root package name */
        private static SparseIntArray f1948o;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1949a = false;

        /* renamed from: b  reason: collision with root package name */
        public float f1950b = 0.0f;

        /* renamed from: c  reason: collision with root package name */
        public float f1951c = 0.0f;

        /* renamed from: d  reason: collision with root package name */
        public float f1952d = 0.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f1953e = 1.0f;

        /* renamed from: f  reason: collision with root package name */
        public float f1954f = 1.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f1955g = Float.NaN;

        /* renamed from: h  reason: collision with root package name */
        public float f1956h = Float.NaN;

        /* renamed from: i  reason: collision with root package name */
        public int f1957i = -1;

        /* renamed from: j  reason: collision with root package name */
        public float f1958j = 0.0f;

        /* renamed from: k  reason: collision with root package name */
        public float f1959k = 0.0f;

        /* renamed from: l  reason: collision with root package name */
        public float f1960l = 0.0f;

        /* renamed from: m  reason: collision with root package name */
        public boolean f1961m = false;

        /* renamed from: n  reason: collision with root package name */
        public float f1962n = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1948o = sparseIntArray;
            sparseIntArray.append(h.Z5, 1);
            f1948o.append(h.f1983a6, 2);
            f1948o.append(h.f1991b6, 3);
            f1948o.append(h.X5, 4);
            f1948o.append(h.Y5, 5);
            f1948o.append(h.T5, 6);
            f1948o.append(h.U5, 7);
            f1948o.append(h.V5, 8);
            f1948o.append(h.W5, 9);
            f1948o.append(h.f1999c6, 10);
            f1948o.append(h.f2007d6, 11);
            f1948o.append(h.f2015e6, 12);
        }

        public void a(e eVar) {
            this.f1949a = eVar.f1949a;
            this.f1950b = eVar.f1950b;
            this.f1951c = eVar.f1951c;
            this.f1952d = eVar.f1952d;
            this.f1953e = eVar.f1953e;
            this.f1954f = eVar.f1954f;
            this.f1955g = eVar.f1955g;
            this.f1956h = eVar.f1956h;
            this.f1957i = eVar.f1957i;
            this.f1958j = eVar.f1958j;
            this.f1959k = eVar.f1959k;
            this.f1960l = eVar.f1960l;
            this.f1961m = eVar.f1961m;
            this.f1962n = eVar.f1962n;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.S5);
            this.f1949a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                switch (f1948o.get(index)) {
                    case 1:
                        this.f1950b = obtainStyledAttributes.getFloat(index, this.f1950b);
                        break;
                    case 2:
                        this.f1951c = obtainStyledAttributes.getFloat(index, this.f1951c);
                        break;
                    case 3:
                        this.f1952d = obtainStyledAttributes.getFloat(index, this.f1952d);
                        break;
                    case 4:
                        this.f1953e = obtainStyledAttributes.getFloat(index, this.f1953e);
                        break;
                    case 5:
                        this.f1954f = obtainStyledAttributes.getFloat(index, this.f1954f);
                        break;
                    case 6:
                        this.f1955g = obtainStyledAttributes.getDimension(index, this.f1955g);
                        break;
                    case 7:
                        this.f1956h = obtainStyledAttributes.getDimension(index, this.f1956h);
                        break;
                    case 8:
                        this.f1958j = obtainStyledAttributes.getDimension(index, this.f1958j);
                        break;
                    case 9:
                        this.f1959k = obtainStyledAttributes.getDimension(index, this.f1959k);
                        break;
                    case 10:
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.f1960l = obtainStyledAttributes.getDimension(index, this.f1960l);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.f1961m = true;
                            this.f1962n = obtainStyledAttributes.getDimension(index, this.f1962n);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        this.f1957i = c.o(obtainStyledAttributes, index, this.f1957i);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    static {
        f1862e.append(h.f2025g0, 25);
        f1862e.append(h.f2033h0, 26);
        f1862e.append(h.f2049j0, 29);
        f1862e.append(h.f2057k0, 30);
        f1862e.append(h.f2100q0, 36);
        f1862e.append(h.f2093p0, 35);
        f1862e.append(h.N, 4);
        f1862e.append(h.M, 3);
        f1862e.append(h.I, 1);
        f1862e.append(h.K, 91);
        f1862e.append(h.J, 92);
        f1862e.append(h.f2162z0, 6);
        f1862e.append(h.A0, 7);
        f1862e.append(h.U, 17);
        f1862e.append(h.V, 18);
        f1862e.append(h.W, 19);
        f1862e.append(h.f1984b, 27);
        f1862e.append(h.f2065l0, 32);
        f1862e.append(h.f2072m0, 33);
        f1862e.append(h.T, 10);
        f1862e.append(h.S, 9);
        f1862e.append(h.D0, 13);
        f1862e.append(h.G0, 16);
        f1862e.append(h.E0, 14);
        f1862e.append(h.B0, 11);
        f1862e.append(h.F0, 15);
        f1862e.append(h.C0, 12);
        f1862e.append(h.f2120t0, 40);
        f1862e.append(h.f2009e0, 39);
        f1862e.append(h.f2001d0, 41);
        f1862e.append(h.f2113s0, 42);
        f1862e.append(h.f1993c0, 20);
        f1862e.append(h.f2106r0, 37);
        f1862e.append(h.R, 5);
        f1862e.append(h.f2017f0, 87);
        f1862e.append(h.f2086o0, 87);
        f1862e.append(h.f2041i0, 87);
        f1862e.append(h.L, 87);
        f1862e.append(h.H, 87);
        f1862e.append(h.f2024g, 24);
        f1862e.append(h.f2040i, 28);
        f1862e.append(h.f2126u, 31);
        f1862e.append(h.f2133v, 8);
        f1862e.append(h.f2032h, 34);
        f1862e.append(h.f2048j, 2);
        f1862e.append(h.f2008e, 23);
        f1862e.append(h.f2016f, 21);
        f1862e.append(h.f2127u0, 95);
        f1862e.append(h.X, 96);
        f1862e.append(h.f2000d, 22);
        f1862e.append(h.f2056k, 43);
        f1862e.append(h.f2147x, 44);
        f1862e.append(h.f2112s, 45);
        f1862e.append(h.f2119t, 46);
        f1862e.append(h.f2105r, 60);
        f1862e.append(h.f2092p, 47);
        f1862e.append(h.f2099q, 48);
        f1862e.append(h.f2064l, 49);
        f1862e.append(h.f2071m, 50);
        f1862e.append(h.f2078n, 51);
        f1862e.append(h.f2085o, 52);
        f1862e.append(h.f2140w, 53);
        f1862e.append(h.f2134v0, 54);
        f1862e.append(h.Y, 55);
        f1862e.append(h.f2141w0, 56);
        f1862e.append(h.Z, 57);
        f1862e.append(h.f2148x0, 58);
        f1862e.append(h.f1977a0, 59);
        f1862e.append(h.O, 61);
        f1862e.append(h.Q, 62);
        f1862e.append(h.P, 63);
        f1862e.append(h.f2154y, 64);
        f1862e.append(h.Q0, 65);
        f1862e.append(h.E, 66);
        f1862e.append(h.R0, 67);
        f1862e.append(h.J0, 79);
        f1862e.append(h.f1992c, 38);
        f1862e.append(h.I0, 68);
        f1862e.append(h.f2155y0, 69);
        f1862e.append(h.f1985b0, 70);
        f1862e.append(h.H0, 97);
        f1862e.append(h.C, 71);
        f1862e.append(h.A, 72);
        f1862e.append(h.B, 73);
        f1862e.append(h.D, 74);
        f1862e.append(h.f2161z, 75);
        f1862e.append(h.K0, 76);
        f1862e.append(h.f2079n0, 77);
        f1862e.append(h.S0, 78);
        f1862e.append(h.G, 80);
        f1862e.append(h.F, 81);
        f1862e.append(h.L0, 82);
        f1862e.append(h.P0, 83);
        f1862e.append(h.O0, 84);
        f1862e.append(h.N0, 85);
        f1862e.append(h.M0, 86);
        SparseIntArray sparseIntArray = f1863f;
        int i10 = h.f2130u3;
        sparseIntArray.append(i10, 6);
        f1863f.append(i10, 7);
        f1863f.append(h.f2095p2, 27);
        f1863f.append(h.f2151x3, 13);
        f1863f.append(h.A3, 16);
        f1863f.append(h.f2158y3, 14);
        f1863f.append(h.f2137v3, 11);
        f1863f.append(h.f2165z3, 15);
        f1863f.append(h.f2144w3, 12);
        f1863f.append(h.f2089o3, 40);
        f1863f.append(h.f2036h3, 39);
        f1863f.append(h.f2028g3, 41);
        f1863f.append(h.f2082n3, 42);
        f1863f.append(h.f2020f3, 20);
        f1863f.append(h.f2075m3, 37);
        f1863f.append(h.Z2, 5);
        f1863f.append(h.f2044i3, 87);
        f1863f.append(h.f2068l3, 87);
        f1863f.append(h.f2052j3, 87);
        f1863f.append(h.W2, 87);
        f1863f.append(h.V2, 87);
        f1863f.append(h.f2129u2, 24);
        f1863f.append(h.f2143w2, 28);
        f1863f.append(h.I2, 31);
        f1863f.append(h.J2, 8);
        f1863f.append(h.f2136v2, 34);
        f1863f.append(h.f2150x2, 2);
        f1863f.append(h.f2115s2, 23);
        f1863f.append(h.f2122t2, 21);
        f1863f.append(h.f2096p3, 95);
        f1863f.append(h.f1980a3, 96);
        f1863f.append(h.f2108r2, 22);
        f1863f.append(h.f2157y2, 43);
        f1863f.append(h.L2, 44);
        f1863f.append(h.G2, 45);
        f1863f.append(h.H2, 46);
        f1863f.append(h.F2, 60);
        f1863f.append(h.D2, 47);
        f1863f.append(h.E2, 48);
        f1863f.append(h.f2164z2, 49);
        f1863f.append(h.A2, 50);
        f1863f.append(h.B2, 51);
        f1863f.append(h.C2, 52);
        f1863f.append(h.K2, 53);
        f1863f.append(h.f2103q3, 54);
        f1863f.append(h.f1988b3, 55);
        f1863f.append(h.f2109r3, 56);
        f1863f.append(h.f1996c3, 57);
        f1863f.append(h.f2116s3, 58);
        f1863f.append(h.f2004d3, 59);
        f1863f.append(h.Y2, 62);
        f1863f.append(h.X2, 63);
        f1863f.append(h.M2, 64);
        f1863f.append(h.L3, 65);
        f1863f.append(h.S2, 66);
        f1863f.append(h.M3, 67);
        f1863f.append(h.D3, 79);
        f1863f.append(h.f2102q2, 38);
        f1863f.append(h.E3, 98);
        f1863f.append(h.C3, 68);
        f1863f.append(h.f2123t3, 69);
        f1863f.append(h.f2012e3, 70);
        f1863f.append(h.Q2, 71);
        f1863f.append(h.O2, 72);
        f1863f.append(h.P2, 73);
        f1863f.append(h.R2, 74);
        f1863f.append(h.N2, 75);
        f1863f.append(h.F3, 76);
        f1863f.append(h.f2060k3, 77);
        f1863f.append(h.N3, 78);
        f1863f.append(h.U2, 80);
        f1863f.append(h.T2, 81);
        f1863f.append(h.G3, 82);
        f1863f.append(h.K3, 83);
        f1863f.append(h.J3, 84);
        f1863f.append(h.I3, 85);
        f1863f.append(h.H3, 86);
        f1863f.append(h.B3, 97);
    }

    private int[] j(View view, String str) {
        int i10;
        Object p10;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i11 = 0;
        for (String str2 : split) {
            String trim = str2.trim();
            try {
                i10 = g.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i10 = 0;
            }
            if (i10 == 0) {
                i10 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i10 == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (p10 = ((ConstraintLayout) view.getParent()).p(0, trim)) != null && (p10 instanceof Integer)) {
                i10 = ((Integer) p10).intValue();
            }
            i11++;
            iArr[i11] = i10;
        }
        return i11 != split.length ? Arrays.copyOf(iArr, i11) : iArr;
    }

    private a k(Context context, AttributeSet attributeSet, boolean z10) {
        a aVar = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z10 ? h.f2088o2 : h.f1976a);
        s(context, aVar, obtainStyledAttributes, z10);
        obtainStyledAttributes.recycle();
        return aVar;
    }

    private a l(int i10) {
        if (!this.f1866c.containsKey(Integer.valueOf(i10))) {
            this.f1866c.put(Integer.valueOf(i10), new a());
        }
        return this.f1866c.get(Integer.valueOf(i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int o(TypedArray typedArray, int i10, int i11) {
        int resourceId = typedArray.getResourceId(i10, i11);
        return resourceId == -1 ? typedArray.getInt(i10, -1) : resourceId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void p(Object obj, TypedArray typedArray, int i10, int i11) {
        if (obj != null) {
            int i12 = typedArray.peekValue(i10).type;
            if (i12 != 3) {
                int i13 = -2;
                boolean z10 = false;
                if (i12 != 5) {
                    int i14 = typedArray.getInt(i10, 0);
                    if (i14 != -4) {
                        i13 = (i14 == -3 || !(i14 == -2 || i14 == -1)) ? 0 : i14;
                    } else {
                        z10 = true;
                    }
                } else {
                    i13 = typedArray.getDimensionPixelSize(i10, 0);
                }
                if (obj instanceof ConstraintLayout.b) {
                    ConstraintLayout.b bVar = (ConstraintLayout.b) obj;
                    if (i11 == 0) {
                        ((ViewGroup.MarginLayoutParams) bVar).width = i13;
                        bVar.V = z10;
                        return;
                    }
                    ((ViewGroup.MarginLayoutParams) bVar).height = i13;
                    bVar.W = z10;
                } else if (obj instanceof b) {
                    b bVar2 = (b) obj;
                    if (i11 == 0) {
                        bVar2.f1891c = i13;
                        bVar2.f1910l0 = z10;
                        return;
                    }
                    bVar2.f1893d = i13;
                    bVar2.f1912m0 = z10;
                } else if (obj instanceof a.C0012a) {
                    a.C0012a aVar = (a.C0012a) obj;
                    if (i11 == 0) {
                        aVar.b(23, i13);
                        aVar.d(80, z10);
                        return;
                    }
                    aVar.b(21, i13);
                    aVar.d(81, z10);
                }
            } else {
                q(obj, typedArray.getString(i10), i11);
            }
        }
    }

    static void q(Object obj, String str, int i10) {
        if (str != null) {
            int indexOf = str.indexOf(61);
            int length = str.length();
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                String substring2 = str.substring(indexOf + 1);
                if (substring2.length() > 0) {
                    String trim = substring.trim();
                    String trim2 = substring2.trim();
                    if (!"ratio".equalsIgnoreCase(trim)) {
                        try {
                            if ("weight".equalsIgnoreCase(trim)) {
                                float parseFloat = Float.parseFloat(trim2);
                                if (obj instanceof ConstraintLayout.b) {
                                    ConstraintLayout.b bVar = (ConstraintLayout.b) obj;
                                    if (i10 == 0) {
                                        ((ViewGroup.MarginLayoutParams) bVar).width = 0;
                                        bVar.G = parseFloat;
                                    } else {
                                        ((ViewGroup.MarginLayoutParams) bVar).height = 0;
                                        bVar.H = parseFloat;
                                    }
                                } else if (obj instanceof b) {
                                    b bVar2 = (b) obj;
                                    if (i10 == 0) {
                                        bVar2.f1891c = 0;
                                        bVar2.U = parseFloat;
                                    } else {
                                        bVar2.f1893d = 0;
                                        bVar2.T = parseFloat;
                                    }
                                } else if (obj instanceof a.C0012a) {
                                    a.C0012a aVar = (a.C0012a) obj;
                                    if (i10 == 0) {
                                        aVar.b(23, 0);
                                        aVar.a(39, parseFloat);
                                    } else {
                                        aVar.b(21, 0);
                                        aVar.a(40, parseFloat);
                                    }
                                }
                            } else if ("parent".equalsIgnoreCase(trim)) {
                                float max = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(trim2)));
                                if (obj instanceof ConstraintLayout.b) {
                                    ConstraintLayout.b bVar3 = (ConstraintLayout.b) obj;
                                    if (i10 == 0) {
                                        ((ViewGroup.MarginLayoutParams) bVar3).width = 0;
                                        bVar3.Q = max;
                                        bVar3.K = 2;
                                    } else {
                                        ((ViewGroup.MarginLayoutParams) bVar3).height = 0;
                                        bVar3.R = max;
                                        bVar3.L = 2;
                                    }
                                } else if (obj instanceof b) {
                                    b bVar4 = (b) obj;
                                    if (i10 == 0) {
                                        bVar4.f1891c = 0;
                                        bVar4.f1894d0 = max;
                                        bVar4.X = 2;
                                    } else {
                                        bVar4.f1893d = 0;
                                        bVar4.f1896e0 = max;
                                        bVar4.Y = 2;
                                    }
                                } else if (obj instanceof a.C0012a) {
                                    a.C0012a aVar2 = (a.C0012a) obj;
                                    if (i10 == 0) {
                                        aVar2.b(23, 0);
                                        aVar2.b(54, 2);
                                    } else {
                                        aVar2.b(21, 0);
                                        aVar2.b(55, 2);
                                    }
                                }
                            }
                        } catch (NumberFormatException unused) {
                        }
                    } else if (obj instanceof ConstraintLayout.b) {
                        ConstraintLayout.b bVar5 = (ConstraintLayout.b) obj;
                        if (i10 == 0) {
                            ((ViewGroup.MarginLayoutParams) bVar5).width = 0;
                        } else {
                            ((ViewGroup.MarginLayoutParams) bVar5).height = 0;
                        }
                        r(bVar5, trim2);
                    } else if (obj instanceof b) {
                        ((b) obj).f1926y = trim2;
                    } else if (obj instanceof a.C0012a) {
                        ((a.C0012a) obj).c(5, trim2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void r(ConstraintLayout.b bVar, String str) {
        if (str != null) {
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i10 = 0;
            int i11 = -1;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (!substring.equalsIgnoreCase("W")) {
                    i10 = substring.equalsIgnoreCase("H") ? 1 : -1;
                }
                i10 = indexOf + 1;
                i11 = i10;
            }
            int indexOf2 = str.indexOf(58);
            try {
                if (indexOf2 < 0 || indexOf2 >= length - 1) {
                    String substring2 = str.substring(i10);
                    if (substring2.length() > 0) {
                        Float.parseFloat(substring2);
                    }
                } else {
                    String substring3 = str.substring(i10, indexOf2);
                    String substring4 = str.substring(indexOf2 + 1);
                    if (substring3.length() > 0 && substring4.length() > 0) {
                        float parseFloat = Float.parseFloat(substring3);
                        float parseFloat2 = Float.parseFloat(substring4);
                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                            if (i11 == 1) {
                                Math.abs(parseFloat2 / parseFloat);
                            } else {
                                Math.abs(parseFloat / parseFloat2);
                            }
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        bVar.F = str;
    }

    private void s(Context context, a aVar, TypedArray typedArray, boolean z10) {
        if (z10) {
            t(context, aVar, typedArray);
            return;
        }
        int indexCount = typedArray.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArray.getIndex(i10);
            if (!(index == h.f1992c || h.f2126u == index || h.f2133v == index)) {
                aVar.f1869c.f1929a = true;
                aVar.f1870d.f1889b = true;
                aVar.f1868b.f1943a = true;
                aVar.f1871e.f1949a = true;
            }
            switch (f1862e.get(index)) {
                case 1:
                    b bVar = aVar.f1870d;
                    bVar.f1917p = o(typedArray, index, bVar.f1917p);
                    break;
                case 2:
                    b bVar2 = aVar.f1870d;
                    bVar2.I = typedArray.getDimensionPixelSize(index, bVar2.I);
                    break;
                case 3:
                    b bVar3 = aVar.f1870d;
                    bVar3.f1915o = o(typedArray, index, bVar3.f1915o);
                    break;
                case 4:
                    b bVar4 = aVar.f1870d;
                    bVar4.f1913n = o(typedArray, index, bVar4.f1913n);
                    break;
                case 5:
                    aVar.f1870d.f1926y = typedArray.getString(index);
                    break;
                case 6:
                    b bVar5 = aVar.f1870d;
                    bVar5.C = typedArray.getDimensionPixelOffset(index, bVar5.C);
                    break;
                case 7:
                    b bVar6 = aVar.f1870d;
                    bVar6.D = typedArray.getDimensionPixelOffset(index, bVar6.D);
                    break;
                case 8:
                    if (Build.VERSION.SDK_INT >= 17) {
                        b bVar7 = aVar.f1870d;
                        bVar7.J = typedArray.getDimensionPixelSize(index, bVar7.J);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    b bVar8 = aVar.f1870d;
                    bVar8.f1923v = o(typedArray, index, bVar8.f1923v);
                    break;
                case 10:
                    b bVar9 = aVar.f1870d;
                    bVar9.f1922u = o(typedArray, index, bVar9.f1922u);
                    break;
                case 11:
                    b bVar10 = aVar.f1870d;
                    bVar10.P = typedArray.getDimensionPixelSize(index, bVar10.P);
                    break;
                case 12:
                    b bVar11 = aVar.f1870d;
                    bVar11.Q = typedArray.getDimensionPixelSize(index, bVar11.Q);
                    break;
                case 13:
                    b bVar12 = aVar.f1870d;
                    bVar12.M = typedArray.getDimensionPixelSize(index, bVar12.M);
                    break;
                case 14:
                    b bVar13 = aVar.f1870d;
                    bVar13.O = typedArray.getDimensionPixelSize(index, bVar13.O);
                    break;
                case 15:
                    b bVar14 = aVar.f1870d;
                    bVar14.R = typedArray.getDimensionPixelSize(index, bVar14.R);
                    break;
                case 16:
                    b bVar15 = aVar.f1870d;
                    bVar15.N = typedArray.getDimensionPixelSize(index, bVar15.N);
                    break;
                case 17:
                    b bVar16 = aVar.f1870d;
                    bVar16.f1895e = typedArray.getDimensionPixelOffset(index, bVar16.f1895e);
                    break;
                case 18:
                    b bVar17 = aVar.f1870d;
                    bVar17.f1897f = typedArray.getDimensionPixelOffset(index, bVar17.f1897f);
                    break;
                case 19:
                    b bVar18 = aVar.f1870d;
                    bVar18.f1899g = typedArray.getFloat(index, bVar18.f1899g);
                    break;
                case 20:
                    b bVar19 = aVar.f1870d;
                    bVar19.f1924w = typedArray.getFloat(index, bVar19.f1924w);
                    break;
                case 21:
                    b bVar20 = aVar.f1870d;
                    bVar20.f1893d = typedArray.getLayoutDimension(index, bVar20.f1893d);
                    break;
                case 22:
                    d dVar = aVar.f1868b;
                    dVar.f1944b = typedArray.getInt(index, dVar.f1944b);
                    d dVar2 = aVar.f1868b;
                    dVar2.f1944b = f1861d[dVar2.f1944b];
                    break;
                case 23:
                    b bVar21 = aVar.f1870d;
                    bVar21.f1891c = typedArray.getLayoutDimension(index, bVar21.f1891c);
                    break;
                case 24:
                    b bVar22 = aVar.f1870d;
                    bVar22.F = typedArray.getDimensionPixelSize(index, bVar22.F);
                    break;
                case 25:
                    b bVar23 = aVar.f1870d;
                    bVar23.f1901h = o(typedArray, index, bVar23.f1901h);
                    break;
                case 26:
                    b bVar24 = aVar.f1870d;
                    bVar24.f1903i = o(typedArray, index, bVar24.f1903i);
                    break;
                case 27:
                    b bVar25 = aVar.f1870d;
                    bVar25.E = typedArray.getInt(index, bVar25.E);
                    break;
                case 28:
                    b bVar26 = aVar.f1870d;
                    bVar26.G = typedArray.getDimensionPixelSize(index, bVar26.G);
                    break;
                case 29:
                    b bVar27 = aVar.f1870d;
                    bVar27.f1905j = o(typedArray, index, bVar27.f1905j);
                    break;
                case 30:
                    b bVar28 = aVar.f1870d;
                    bVar28.f1907k = o(typedArray, index, bVar28.f1907k);
                    break;
                case 31:
                    if (Build.VERSION.SDK_INT >= 17) {
                        b bVar29 = aVar.f1870d;
                        bVar29.K = typedArray.getDimensionPixelSize(index, bVar29.K);
                        break;
                    } else {
                        break;
                    }
                case 32:
                    b bVar30 = aVar.f1870d;
                    bVar30.f1920s = o(typedArray, index, bVar30.f1920s);
                    break;
                case 33:
                    b bVar31 = aVar.f1870d;
                    bVar31.f1921t = o(typedArray, index, bVar31.f1921t);
                    break;
                case 34:
                    b bVar32 = aVar.f1870d;
                    bVar32.H = typedArray.getDimensionPixelSize(index, bVar32.H);
                    break;
                case 35:
                    b bVar33 = aVar.f1870d;
                    bVar33.f1911m = o(typedArray, index, bVar33.f1911m);
                    break;
                case 36:
                    b bVar34 = aVar.f1870d;
                    bVar34.f1909l = o(typedArray, index, bVar34.f1909l);
                    break;
                case 37:
                    b bVar35 = aVar.f1870d;
                    bVar35.f1925x = typedArray.getFloat(index, bVar35.f1925x);
                    break;
                case 38:
                    aVar.f1867a = typedArray.getResourceId(index, aVar.f1867a);
                    break;
                case 39:
                    b bVar36 = aVar.f1870d;
                    bVar36.U = typedArray.getFloat(index, bVar36.U);
                    break;
                case 40:
                    b bVar37 = aVar.f1870d;
                    bVar37.T = typedArray.getFloat(index, bVar37.T);
                    break;
                case 41:
                    b bVar38 = aVar.f1870d;
                    bVar38.V = typedArray.getInt(index, bVar38.V);
                    break;
                case 42:
                    b bVar39 = aVar.f1870d;
                    bVar39.W = typedArray.getInt(index, bVar39.W);
                    break;
                case 43:
                    d dVar3 = aVar.f1868b;
                    dVar3.f1946d = typedArray.getFloat(index, dVar3.f1946d);
                    break;
                case 44:
                    if (Build.VERSION.SDK_INT >= 21) {
                        e eVar = aVar.f1871e;
                        eVar.f1961m = true;
                        eVar.f1962n = typedArray.getDimension(index, eVar.f1962n);
                        break;
                    } else {
                        break;
                    }
                case 45:
                    e eVar2 = aVar.f1871e;
                    eVar2.f1951c = typedArray.getFloat(index, eVar2.f1951c);
                    break;
                case 46:
                    e eVar3 = aVar.f1871e;
                    eVar3.f1952d = typedArray.getFloat(index, eVar3.f1952d);
                    break;
                case 47:
                    e eVar4 = aVar.f1871e;
                    eVar4.f1953e = typedArray.getFloat(index, eVar4.f1953e);
                    break;
                case 48:
                    e eVar5 = aVar.f1871e;
                    eVar5.f1954f = typedArray.getFloat(index, eVar5.f1954f);
                    break;
                case 49:
                    e eVar6 = aVar.f1871e;
                    eVar6.f1955g = typedArray.getDimension(index, eVar6.f1955g);
                    break;
                case 50:
                    e eVar7 = aVar.f1871e;
                    eVar7.f1956h = typedArray.getDimension(index, eVar7.f1956h);
                    break;
                case 51:
                    e eVar8 = aVar.f1871e;
                    eVar8.f1958j = typedArray.getDimension(index, eVar8.f1958j);
                    break;
                case 52:
                    e eVar9 = aVar.f1871e;
                    eVar9.f1959k = typedArray.getDimension(index, eVar9.f1959k);
                    break;
                case 53:
                    if (Build.VERSION.SDK_INT >= 21) {
                        e eVar10 = aVar.f1871e;
                        eVar10.f1960l = typedArray.getDimension(index, eVar10.f1960l);
                        break;
                    } else {
                        break;
                    }
                case 54:
                    b bVar40 = aVar.f1870d;
                    bVar40.X = typedArray.getInt(index, bVar40.X);
                    break;
                case 55:
                    b bVar41 = aVar.f1870d;
                    bVar41.Y = typedArray.getInt(index, bVar41.Y);
                    break;
                case 56:
                    b bVar42 = aVar.f1870d;
                    bVar42.Z = typedArray.getDimensionPixelSize(index, bVar42.Z);
                    break;
                case 57:
                    b bVar43 = aVar.f1870d;
                    bVar43.f1888a0 = typedArray.getDimensionPixelSize(index, bVar43.f1888a0);
                    break;
                case 58:
                    b bVar44 = aVar.f1870d;
                    bVar44.f1890b0 = typedArray.getDimensionPixelSize(index, bVar44.f1890b0);
                    break;
                case 59:
                    b bVar45 = aVar.f1870d;
                    bVar45.f1892c0 = typedArray.getDimensionPixelSize(index, bVar45.f1892c0);
                    break;
                case 60:
                    e eVar11 = aVar.f1871e;
                    eVar11.f1950b = typedArray.getFloat(index, eVar11.f1950b);
                    break;
                case 61:
                    b bVar46 = aVar.f1870d;
                    bVar46.f1927z = o(typedArray, index, bVar46.f1927z);
                    break;
                case 62:
                    b bVar47 = aVar.f1870d;
                    bVar47.A = typedArray.getDimensionPixelSize(index, bVar47.A);
                    break;
                case 63:
                    b bVar48 = aVar.f1870d;
                    bVar48.B = typedArray.getFloat(index, bVar48.B);
                    break;
                case 64:
                    C0013c cVar = aVar.f1869c;
                    cVar.f1930b = o(typedArray, index, cVar.f1930b);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        aVar.f1869c.f1932d = typedArray.getString(index);
                        break;
                    } else {
                        aVar.f1869c.f1932d = s.b.f34203c[typedArray.getInteger(index, 0)];
                        break;
                    }
                case 66:
                    aVar.f1869c.f1934f = typedArray.getInt(index, 0);
                    break;
                case 67:
                    C0013c cVar2 = aVar.f1869c;
                    cVar2.f1937i = typedArray.getFloat(index, cVar2.f1937i);
                    break;
                case 68:
                    d dVar4 = aVar.f1868b;
                    dVar4.f1947e = typedArray.getFloat(index, dVar4.f1947e);
                    break;
                case 69:
                    aVar.f1870d.f1894d0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    aVar.f1870d.f1896e0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    b bVar49 = aVar.f1870d;
                    bVar49.f1898f0 = typedArray.getInt(index, bVar49.f1898f0);
                    break;
                case 73:
                    b bVar50 = aVar.f1870d;
                    bVar50.f1900g0 = typedArray.getDimensionPixelSize(index, bVar50.f1900g0);
                    break;
                case 74:
                    aVar.f1870d.f1906j0 = typedArray.getString(index);
                    break;
                case 75:
                    b bVar51 = aVar.f1870d;
                    bVar51.f1914n0 = typedArray.getBoolean(index, bVar51.f1914n0);
                    break;
                case 76:
                    C0013c cVar3 = aVar.f1869c;
                    cVar3.f1933e = typedArray.getInt(index, cVar3.f1933e);
                    break;
                case 77:
                    aVar.f1870d.f1908k0 = typedArray.getString(index);
                    break;
                case 78:
                    d dVar5 = aVar.f1868b;
                    dVar5.f1945c = typedArray.getInt(index, dVar5.f1945c);
                    break;
                case 79:
                    C0013c cVar4 = aVar.f1869c;
                    cVar4.f1935g = typedArray.getFloat(index, cVar4.f1935g);
                    break;
                case 80:
                    b bVar52 = aVar.f1870d;
                    bVar52.f1910l0 = typedArray.getBoolean(index, bVar52.f1910l0);
                    break;
                case 81:
                    b bVar53 = aVar.f1870d;
                    bVar53.f1912m0 = typedArray.getBoolean(index, bVar53.f1912m0);
                    break;
                case 82:
                    C0013c cVar5 = aVar.f1869c;
                    cVar5.f1931c = typedArray.getInteger(index, cVar5.f1931c);
                    break;
                case 83:
                    e eVar12 = aVar.f1871e;
                    eVar12.f1957i = o(typedArray, index, eVar12.f1957i);
                    break;
                case 84:
                    C0013c cVar6 = aVar.f1869c;
                    cVar6.f1939k = typedArray.getInteger(index, cVar6.f1939k);
                    break;
                case 85:
                    C0013c cVar7 = aVar.f1869c;
                    cVar7.f1938j = typedArray.getFloat(index, cVar7.f1938j);
                    break;
                case 86:
                    int i11 = typedArray.peekValue(index).type;
                    if (i11 != 1) {
                        if (i11 == 3) {
                            aVar.f1869c.f1940l = typedArray.getString(index);
                            if (aVar.f1869c.f1940l.indexOf("/") > 0) {
                                aVar.f1869c.f1942n = typedArray.getResourceId(index, -1);
                                aVar.f1869c.f1941m = -2;
                                break;
                            } else {
                                aVar.f1869c.f1941m = -1;
                                break;
                            }
                        } else {
                            C0013c cVar8 = aVar.f1869c;
                            cVar8.f1941m = typedArray.getInteger(index, cVar8.f1942n);
                            break;
                        }
                    } else {
                        aVar.f1869c.f1942n = typedArray.getResourceId(index, -1);
                        C0013c cVar9 = aVar.f1869c;
                        if (cVar9.f1942n != -1) {
                            cVar9.f1941m = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 87:
                    String hexString = Integer.toHexString(index);
                    int i12 = f1862e.get(index);
                    StringBuilder sb2 = new StringBuilder(String.valueOf(hexString).length() + 33);
                    sb2.append("unused attribute 0x");
                    sb2.append(hexString);
                    sb2.append("   ");
                    sb2.append(i12);
                    Log.w("ConstraintSet", sb2.toString());
                    break;
                case 88:
                case 89:
                case 90:
                default:
                    String hexString2 = Integer.toHexString(index);
                    int i13 = f1862e.get(index);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(hexString2).length() + 34);
                    sb3.append("Unknown attribute 0x");
                    sb3.append(hexString2);
                    sb3.append("   ");
                    sb3.append(i13);
                    Log.w("ConstraintSet", sb3.toString());
                    break;
                case 91:
                    b bVar54 = aVar.f1870d;
                    bVar54.f1918q = o(typedArray, index, bVar54.f1918q);
                    break;
                case 92:
                    b bVar55 = aVar.f1870d;
                    bVar55.f1919r = o(typedArray, index, bVar55.f1919r);
                    break;
                case 93:
                    b bVar56 = aVar.f1870d;
                    bVar56.L = typedArray.getDimensionPixelSize(index, bVar56.L);
                    break;
                case 94:
                    b bVar57 = aVar.f1870d;
                    bVar57.S = typedArray.getDimensionPixelSize(index, bVar57.S);
                    break;
                case 95:
                    p(aVar.f1870d, typedArray, index, 0);
                    break;
                case 96:
                    p(aVar.f1870d, typedArray, index, 1);
                    break;
                case 97:
                    b bVar58 = aVar.f1870d;
                    bVar58.f1916o0 = typedArray.getInt(index, bVar58.f1916o0);
                    break;
            }
        }
        b bVar59 = aVar.f1870d;
        if (bVar59.f1906j0 != null) {
            bVar59.f1904i0 = null;
        }
    }

    private static void t(Context context, a aVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        a.C0012a aVar2 = new a.C0012a();
        aVar.f1873g = aVar2;
        aVar.f1869c.f1929a = false;
        aVar.f1870d.f1889b = false;
        aVar.f1868b.f1943a = false;
        aVar.f1871e.f1949a = false;
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArray.getIndex(i10);
            switch (f1863f.get(index)) {
                case 2:
                    aVar2.b(2, typedArray.getDimensionPixelSize(index, aVar.f1870d.I));
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 25:
                case 26:
                case 29:
                case 30:
                case 32:
                case 33:
                case 35:
                case 36:
                case 61:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                default:
                    String hexString = Integer.toHexString(index);
                    int i11 = f1862e.get(index);
                    StringBuilder sb2 = new StringBuilder(String.valueOf(hexString).length() + 34);
                    sb2.append("Unknown attribute 0x");
                    sb2.append(hexString);
                    sb2.append("   ");
                    sb2.append(i11);
                    Log.w("ConstraintSet", sb2.toString());
                    break;
                case 5:
                    aVar2.c(5, typedArray.getString(index));
                    break;
                case 6:
                    aVar2.b(6, typedArray.getDimensionPixelOffset(index, aVar.f1870d.C));
                    break;
                case 7:
                    aVar2.b(7, typedArray.getDimensionPixelOffset(index, aVar.f1870d.D));
                    break;
                case 8:
                    if (Build.VERSION.SDK_INT >= 17) {
                        aVar2.b(8, typedArray.getDimensionPixelSize(index, aVar.f1870d.J));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    aVar2.b(11, typedArray.getDimensionPixelSize(index, aVar.f1870d.P));
                    break;
                case 12:
                    aVar2.b(12, typedArray.getDimensionPixelSize(index, aVar.f1870d.Q));
                    break;
                case 13:
                    aVar2.b(13, typedArray.getDimensionPixelSize(index, aVar.f1870d.M));
                    break;
                case 14:
                    aVar2.b(14, typedArray.getDimensionPixelSize(index, aVar.f1870d.O));
                    break;
                case 15:
                    aVar2.b(15, typedArray.getDimensionPixelSize(index, aVar.f1870d.R));
                    break;
                case 16:
                    aVar2.b(16, typedArray.getDimensionPixelSize(index, aVar.f1870d.N));
                    break;
                case 17:
                    aVar2.b(17, typedArray.getDimensionPixelOffset(index, aVar.f1870d.f1895e));
                    break;
                case 18:
                    aVar2.b(18, typedArray.getDimensionPixelOffset(index, aVar.f1870d.f1897f));
                    break;
                case 19:
                    aVar2.a(19, typedArray.getFloat(index, aVar.f1870d.f1899g));
                    break;
                case 20:
                    aVar2.a(20, typedArray.getFloat(index, aVar.f1870d.f1924w));
                    break;
                case 21:
                    aVar2.b(21, typedArray.getLayoutDimension(index, aVar.f1870d.f1893d));
                    break;
                case 22:
                    aVar2.b(22, f1861d[typedArray.getInt(index, aVar.f1868b.f1944b)]);
                    break;
                case 23:
                    aVar2.b(23, typedArray.getLayoutDimension(index, aVar.f1870d.f1891c));
                    break;
                case 24:
                    aVar2.b(24, typedArray.getDimensionPixelSize(index, aVar.f1870d.F));
                    break;
                case 27:
                    aVar2.b(27, typedArray.getInt(index, aVar.f1870d.E));
                    break;
                case 28:
                    aVar2.b(28, typedArray.getDimensionPixelSize(index, aVar.f1870d.G));
                    break;
                case 31:
                    if (Build.VERSION.SDK_INT >= 17) {
                        aVar2.b(31, typedArray.getDimensionPixelSize(index, aVar.f1870d.K));
                        break;
                    } else {
                        break;
                    }
                case 34:
                    aVar2.b(34, typedArray.getDimensionPixelSize(index, aVar.f1870d.H));
                    break;
                case 37:
                    aVar2.a(37, typedArray.getFloat(index, aVar.f1870d.f1925x));
                    break;
                case 38:
                    int resourceId = typedArray.getResourceId(index, aVar.f1867a);
                    aVar.f1867a = resourceId;
                    aVar2.b(38, resourceId);
                    break;
                case 39:
                    aVar2.a(39, typedArray.getFloat(index, aVar.f1870d.U));
                    break;
                case 40:
                    aVar2.a(40, typedArray.getFloat(index, aVar.f1870d.T));
                    break;
                case 41:
                    aVar2.b(41, typedArray.getInt(index, aVar.f1870d.V));
                    break;
                case 42:
                    aVar2.b(42, typedArray.getInt(index, aVar.f1870d.W));
                    break;
                case 43:
                    aVar2.a(43, typedArray.getFloat(index, aVar.f1868b.f1946d));
                    break;
                case 44:
                    if (Build.VERSION.SDK_INT >= 21) {
                        aVar2.d(44, true);
                        aVar2.a(44, typedArray.getDimension(index, aVar.f1871e.f1962n));
                        break;
                    } else {
                        break;
                    }
                case 45:
                    aVar2.a(45, typedArray.getFloat(index, aVar.f1871e.f1951c));
                    break;
                case 46:
                    aVar2.a(46, typedArray.getFloat(index, aVar.f1871e.f1952d));
                    break;
                case 47:
                    aVar2.a(47, typedArray.getFloat(index, aVar.f1871e.f1953e));
                    break;
                case 48:
                    aVar2.a(48, typedArray.getFloat(index, aVar.f1871e.f1954f));
                    break;
                case 49:
                    aVar2.a(49, typedArray.getDimension(index, aVar.f1871e.f1955g));
                    break;
                case 50:
                    aVar2.a(50, typedArray.getDimension(index, aVar.f1871e.f1956h));
                    break;
                case 51:
                    aVar2.a(51, typedArray.getDimension(index, aVar.f1871e.f1958j));
                    break;
                case 52:
                    aVar2.a(52, typedArray.getDimension(index, aVar.f1871e.f1959k));
                    break;
                case 53:
                    if (Build.VERSION.SDK_INT >= 21) {
                        aVar2.a(53, typedArray.getDimension(index, aVar.f1871e.f1960l));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    aVar2.b(54, typedArray.getInt(index, aVar.f1870d.X));
                    break;
                case 55:
                    aVar2.b(55, typedArray.getInt(index, aVar.f1870d.Y));
                    break;
                case 56:
                    aVar2.b(56, typedArray.getDimensionPixelSize(index, aVar.f1870d.Z));
                    break;
                case 57:
                    aVar2.b(57, typedArray.getDimensionPixelSize(index, aVar.f1870d.f1888a0));
                    break;
                case 58:
                    aVar2.b(58, typedArray.getDimensionPixelSize(index, aVar.f1870d.f1890b0));
                    break;
                case 59:
                    aVar2.b(59, typedArray.getDimensionPixelSize(index, aVar.f1870d.f1892c0));
                    break;
                case 60:
                    aVar2.a(60, typedArray.getFloat(index, aVar.f1871e.f1950b));
                    break;
                case 62:
                    aVar2.b(62, typedArray.getDimensionPixelSize(index, aVar.f1870d.A));
                    break;
                case 63:
                    aVar2.a(63, typedArray.getFloat(index, aVar.f1870d.B));
                    break;
                case 64:
                    aVar2.b(64, o(typedArray, index, aVar.f1869c.f1930b));
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        aVar2.c(65, typedArray.getString(index));
                        break;
                    } else {
                        aVar2.c(65, s.b.f34203c[typedArray.getInteger(index, 0)]);
                        break;
                    }
                case 66:
                    aVar2.b(66, typedArray.getInt(index, 0));
                    break;
                case 67:
                    aVar2.a(67, typedArray.getFloat(index, aVar.f1869c.f1937i));
                    break;
                case 68:
                    aVar2.a(68, typedArray.getFloat(index, aVar.f1868b.f1947e));
                    break;
                case 69:
                    aVar2.a(69, typedArray.getFloat(index, 1.0f));
                    break;
                case 70:
                    aVar2.a(70, typedArray.getFloat(index, 1.0f));
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    aVar2.b(72, typedArray.getInt(index, aVar.f1870d.f1898f0));
                    break;
                case 73:
                    aVar2.b(73, typedArray.getDimensionPixelSize(index, aVar.f1870d.f1900g0));
                    break;
                case 74:
                    aVar2.c(74, typedArray.getString(index));
                    break;
                case 75:
                    aVar2.d(75, typedArray.getBoolean(index, aVar.f1870d.f1914n0));
                    break;
                case 76:
                    aVar2.b(76, typedArray.getInt(index, aVar.f1869c.f1933e));
                    break;
                case 77:
                    aVar2.c(77, typedArray.getString(index));
                    break;
                case 78:
                    aVar2.b(78, typedArray.getInt(index, aVar.f1868b.f1945c));
                    break;
                case 79:
                    aVar2.a(79, typedArray.getFloat(index, aVar.f1869c.f1935g));
                    break;
                case 80:
                    aVar2.d(80, typedArray.getBoolean(index, aVar.f1870d.f1910l0));
                    break;
                case 81:
                    aVar2.d(81, typedArray.getBoolean(index, aVar.f1870d.f1912m0));
                    break;
                case 82:
                    aVar2.b(82, typedArray.getInteger(index, aVar.f1869c.f1931c));
                    break;
                case 83:
                    aVar2.b(83, o(typedArray, index, aVar.f1871e.f1957i));
                    break;
                case 84:
                    aVar2.b(84, typedArray.getInteger(index, aVar.f1869c.f1939k));
                    break;
                case 85:
                    aVar2.a(85, typedArray.getFloat(index, aVar.f1869c.f1938j));
                    break;
                case 86:
                    int i12 = typedArray.peekValue(index).type;
                    if (i12 != 1) {
                        if (i12 == 3) {
                            aVar.f1869c.f1940l = typedArray.getString(index);
                            aVar2.c(90, aVar.f1869c.f1940l);
                            if (aVar.f1869c.f1940l.indexOf("/") > 0) {
                                aVar.f1869c.f1942n = typedArray.getResourceId(index, -1);
                                aVar2.b(89, aVar.f1869c.f1942n);
                                aVar.f1869c.f1941m = -2;
                                aVar2.b(88, -2);
                                break;
                            } else {
                                aVar.f1869c.f1941m = -1;
                                aVar2.b(88, -1);
                                break;
                            }
                        } else {
                            C0013c cVar = aVar.f1869c;
                            cVar.f1941m = typedArray.getInteger(index, cVar.f1942n);
                            aVar2.b(88, aVar.f1869c.f1941m);
                            break;
                        }
                    } else {
                        aVar.f1869c.f1942n = typedArray.getResourceId(index, -1);
                        aVar2.b(89, aVar.f1869c.f1942n);
                        C0013c cVar2 = aVar.f1869c;
                        if (cVar2.f1942n != -1) {
                            cVar2.f1941m = -2;
                            aVar2.b(88, -2);
                            break;
                        } else {
                            break;
                        }
                    }
                case 87:
                    String hexString2 = Integer.toHexString(index);
                    int i13 = f1862e.get(index);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(hexString2).length() + 33);
                    sb3.append("unused attribute 0x");
                    sb3.append(hexString2);
                    sb3.append("   ");
                    sb3.append(i13);
                    Log.w("ConstraintSet", sb3.toString());
                    break;
                case 93:
                    aVar2.b(93, typedArray.getDimensionPixelSize(index, aVar.f1870d.L));
                    break;
                case 94:
                    aVar2.b(94, typedArray.getDimensionPixelSize(index, aVar.f1870d.S));
                    break;
                case 95:
                    p(aVar2, typedArray, index, 0);
                    break;
                case 96:
                    p(aVar2, typedArray, index, 1);
                    break;
                case 97:
                    aVar2.b(97, typedArray.getInt(index, aVar.f1870d.f1916o0));
                    break;
                case 98:
                    if (!j.A0) {
                        if (typedArray.peekValue(index).type == 3) {
                            typedArray.getString(index);
                            break;
                        } else {
                            aVar.f1867a = typedArray.getResourceId(index, aVar.f1867a);
                            break;
                        }
                    } else {
                        int resourceId2 = typedArray.getResourceId(index, aVar.f1867a);
                        aVar.f1867a = resourceId2;
                        if (resourceId2 == -1) {
                            typedArray.getString(index);
                            break;
                        } else {
                            break;
                        }
                    }
            }
        }
    }

    public void c(ConstraintLayout constraintLayout) {
        d(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(ConstraintLayout constraintLayout, boolean z10) {
        View findViewById;
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f1866c.keySet());
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            int id2 = childAt.getId();
            if (!this.f1866c.containsKey(Integer.valueOf(id2))) {
                String valueOf = String.valueOf(androidx.constraintlayout.motion.widget.a.b(childAt));
                Log.w("ConstraintSet", valueOf.length() != 0 ? "id unknown ".concat(valueOf) : new String("id unknown "));
            } else if (this.f1865b && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (id2 != -1) {
                if (this.f1866c.containsKey(Integer.valueOf(id2))) {
                    hashSet.remove(Integer.valueOf(id2));
                    a aVar = this.f1866c.get(Integer.valueOf(id2));
                    if (aVar != null) {
                        if (childAt instanceof Barrier) {
                            aVar.f1870d.f1902h0 = 1;
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id2);
                            barrier.setType(aVar.f1870d.f1898f0);
                            barrier.setMargin(aVar.f1870d.f1900g0);
                            barrier.setAllowsGoneWidget(aVar.f1870d.f1914n0);
                            b bVar = aVar.f1870d;
                            int[] iArr = bVar.f1904i0;
                            if (iArr != null) {
                                barrier.setReferencedIds(iArr);
                            } else {
                                String str = bVar.f1906j0;
                                if (str != null) {
                                    bVar.f1904i0 = j(barrier, str);
                                    barrier.setReferencedIds(aVar.f1870d.f1904i0);
                                }
                            }
                        }
                        ConstraintLayout.b bVar2 = (ConstraintLayout.b) childAt.getLayoutParams();
                        bVar2.a();
                        aVar.d(bVar2);
                        if (z10) {
                            ConstraintAttribute.d(childAt, aVar.f1872f);
                        }
                        childAt.setLayoutParams(bVar2);
                        d dVar = aVar.f1868b;
                        if (dVar.f1945c == 0) {
                            childAt.setVisibility(dVar.f1944b);
                        }
                        int i11 = Build.VERSION.SDK_INT;
                        if (i11 >= 17) {
                            childAt.setAlpha(aVar.f1868b.f1946d);
                            childAt.setRotation(aVar.f1871e.f1950b);
                            childAt.setRotationX(aVar.f1871e.f1951c);
                            childAt.setRotationY(aVar.f1871e.f1952d);
                            childAt.setScaleX(aVar.f1871e.f1953e);
                            childAt.setScaleY(aVar.f1871e.f1954f);
                            e eVar = aVar.f1871e;
                            if (eVar.f1957i != -1) {
                                if (((View) childAt.getParent()).findViewById(aVar.f1871e.f1957i) != null) {
                                    float top = (findViewById.getTop() + findViewById.getBottom()) / 2.0f;
                                    float left = (findViewById.getLeft() + findViewById.getRight()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        childAt.setPivotX(left - childAt.getLeft());
                                        childAt.setPivotY(top - childAt.getTop());
                                    }
                                }
                            } else {
                                if (!Float.isNaN(eVar.f1955g)) {
                                    childAt.setPivotX(aVar.f1871e.f1955g);
                                }
                                if (!Float.isNaN(aVar.f1871e.f1956h)) {
                                    childAt.setPivotY(aVar.f1871e.f1956h);
                                }
                            }
                            childAt.setTranslationX(aVar.f1871e.f1958j);
                            childAt.setTranslationY(aVar.f1871e.f1959k);
                            if (i11 >= 21) {
                                childAt.setTranslationZ(aVar.f1871e.f1960l);
                                e eVar2 = aVar.f1871e;
                                if (eVar2.f1961m) {
                                    childAt.setElevation(eVar2.f1962n);
                                }
                            }
                        }
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder(43);
                    sb2.append("WARNING NO CONSTRAINTS for view ");
                    sb2.append(id2);
                    Log.v("ConstraintSet", sb2.toString());
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            a aVar2 = this.f1866c.get(num);
            if (aVar2 != null) {
                if (aVar2.f1870d.f1902h0 == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    b bVar3 = aVar2.f1870d;
                    int[] iArr2 = bVar3.f1904i0;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = bVar3.f1906j0;
                        if (str2 != null) {
                            bVar3.f1904i0 = j(barrier2, str2);
                            barrier2.setReferencedIds(aVar2.f1870d.f1904i0);
                        }
                    }
                    barrier2.setType(aVar2.f1870d.f1898f0);
                    barrier2.setMargin(aVar2.f1870d.f1900g0);
                    ConstraintLayout.b h10 = constraintLayout.generateDefaultLayoutParams();
                    barrier2.s();
                    aVar2.d(h10);
                    constraintLayout.addView(barrier2, h10);
                }
                if (aVar2.f1870d.f1887a) {
                    View guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.b h11 = constraintLayout.generateDefaultLayoutParams();
                    aVar2.d(h11);
                    constraintLayout.addView(guideline, h11);
                }
            }
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = constraintLayout.getChildAt(i12);
            if (childAt2 instanceof androidx.constraintlayout.widget.a) {
                ((androidx.constraintlayout.widget.a) childAt2).i(constraintLayout);
            }
        }
    }

    public void e(int i10, int i11) {
        a aVar;
        if (this.f1866c.containsKey(Integer.valueOf(i10)) && (aVar = this.f1866c.get(Integer.valueOf(i10))) != null) {
            switch (i11) {
                case 1:
                    b bVar = aVar.f1870d;
                    bVar.f1903i = -1;
                    bVar.f1901h = -1;
                    bVar.F = -1;
                    bVar.M = Integer.MIN_VALUE;
                    return;
                case 2:
                    b bVar2 = aVar.f1870d;
                    bVar2.f1907k = -1;
                    bVar2.f1905j = -1;
                    bVar2.G = -1;
                    bVar2.O = Integer.MIN_VALUE;
                    return;
                case 3:
                    b bVar3 = aVar.f1870d;
                    bVar3.f1911m = -1;
                    bVar3.f1909l = -1;
                    bVar3.H = 0;
                    bVar3.N = Integer.MIN_VALUE;
                    return;
                case 4:
                    b bVar4 = aVar.f1870d;
                    bVar4.f1913n = -1;
                    bVar4.f1915o = -1;
                    bVar4.I = 0;
                    bVar4.P = Integer.MIN_VALUE;
                    return;
                case 5:
                    b bVar5 = aVar.f1870d;
                    bVar5.f1917p = -1;
                    bVar5.f1918q = -1;
                    bVar5.f1919r = -1;
                    bVar5.L = 0;
                    bVar5.S = Integer.MIN_VALUE;
                    return;
                case 6:
                    b bVar6 = aVar.f1870d;
                    bVar6.f1920s = -1;
                    bVar6.f1921t = -1;
                    bVar6.K = 0;
                    bVar6.R = Integer.MIN_VALUE;
                    return;
                case 7:
                    b bVar7 = aVar.f1870d;
                    bVar7.f1922u = -1;
                    bVar7.f1923v = -1;
                    bVar7.J = 0;
                    bVar7.Q = Integer.MIN_VALUE;
                    return;
                case 8:
                    b bVar8 = aVar.f1870d;
                    bVar8.B = -1.0f;
                    bVar8.A = -1;
                    bVar8.f1927z = -1;
                    return;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
        }
    }

    public void f(Context context, int i10) {
        g((ConstraintLayout) LayoutInflater.from(context).inflate(i10, (ViewGroup) null));
    }

    public void g(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f1866c.clear();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            ConstraintLayout.b bVar = (ConstraintLayout.b) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (!this.f1865b || id2 != -1) {
                if (!this.f1866c.containsKey(Integer.valueOf(id2))) {
                    this.f1866c.put(Integer.valueOf(id2), new a());
                }
                a aVar = this.f1866c.get(Integer.valueOf(id2));
                if (aVar != null) {
                    aVar.f1872f = ConstraintAttribute.b(this.f1864a, childAt);
                    aVar.f(id2, bVar);
                    aVar.f1868b.f1944b = childAt.getVisibility();
                    int i11 = Build.VERSION.SDK_INT;
                    if (i11 >= 17) {
                        aVar.f1868b.f1946d = childAt.getAlpha();
                        aVar.f1871e.f1950b = childAt.getRotation();
                        aVar.f1871e.f1951c = childAt.getRotationX();
                        aVar.f1871e.f1952d = childAt.getRotationY();
                        aVar.f1871e.f1953e = childAt.getScaleX();
                        aVar.f1871e.f1954f = childAt.getScaleY();
                        float pivotX = childAt.getPivotX();
                        float pivotY = childAt.getPivotY();
                        if (!(pivotX == 0.0d && pivotY == 0.0d)) {
                            e eVar = aVar.f1871e;
                            eVar.f1955g = pivotX;
                            eVar.f1956h = pivotY;
                        }
                        aVar.f1871e.f1958j = childAt.getTranslationX();
                        aVar.f1871e.f1959k = childAt.getTranslationY();
                        if (i11 >= 21) {
                            aVar.f1871e.f1960l = childAt.getTranslationZ();
                            e eVar2 = aVar.f1871e;
                            if (eVar2.f1961m) {
                                eVar2.f1962n = childAt.getElevation();
                            }
                        }
                    }
                    if (childAt instanceof Barrier) {
                        Barrier barrier = (Barrier) childAt;
                        aVar.f1870d.f1914n0 = barrier.getAllowsGoneWidget();
                        aVar.f1870d.f1904i0 = barrier.getReferencedIds();
                        aVar.f1870d.f1898f0 = barrier.getType();
                        aVar.f1870d.f1900g0 = barrier.getMargin();
                    }
                }
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void h(androidx.constraintlayout.widget.d dVar) {
        int childCount = dVar.getChildCount();
        this.f1866c.clear();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = dVar.getChildAt(i10);
            d.a aVar = (d.a) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (!this.f1865b || id2 != -1) {
                if (!this.f1866c.containsKey(Integer.valueOf(id2))) {
                    this.f1866c.put(Integer.valueOf(id2), new a());
                }
                a aVar2 = this.f1866c.get(Integer.valueOf(id2));
                if (aVar2 != null) {
                    if (childAt instanceof androidx.constraintlayout.widget.a) {
                        aVar2.h((androidx.constraintlayout.widget.a) childAt, id2, aVar);
                    }
                    aVar2.g(id2, aVar);
                }
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void i(int i10, int i11, int i12, float f10) {
        b bVar = l(i10).f1870d;
        bVar.f1927z = i11;
        bVar.A = i12;
        bVar.B = f10;
    }

    public void m(Context context, int i10) {
        XmlResourceParser xml = context.getResources().getXml(i10);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a k10 = k(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        k10.f1870d.f1887a = true;
                    }
                    this.f1866c.put(Integer.valueOf(k10.f1867a), k10);
                }
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x01cd, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n(Context context, XmlPullParser xmlPullParser) {
        a aVar;
        try {
            int eventType = xmlPullParser.getEventType();
            a aVar2 = null;
            while (eventType != 1) {
                if (eventType != 0) {
                    char c10 = 65535;
                    if (eventType == 2) {
                        String name = xmlPullParser.getName();
                        switch (name.hashCode()) {
                            case -2025855158:
                                if (name.equals("Layout")) {
                                    c10 = 6;
                                    break;
                                }
                                break;
                            case -1984451626:
                                if (name.equals("Motion")) {
                                    c10 = 7;
                                    break;
                                }
                                break;
                            case -1962203927:
                                if (name.equals("ConstraintOverride")) {
                                    c10 = 1;
                                    break;
                                }
                                break;
                            case -1269513683:
                                if (name.equals("PropertySet")) {
                                    c10 = 4;
                                    break;
                                }
                                break;
                            case -1238332596:
                                if (name.equals("Transform")) {
                                    c10 = 5;
                                    break;
                                }
                                break;
                            case -71750448:
                                if (name.equals("Guideline")) {
                                    c10 = 2;
                                    break;
                                }
                                break;
                            case 366511058:
                                if (name.equals("CustomMethod")) {
                                    c10 = '\t';
                                    break;
                                }
                                break;
                            case 1331510167:
                                if (name.equals("Barrier")) {
                                    c10 = 3;
                                    break;
                                }
                                break;
                            case 1791837707:
                                if (name.equals("CustomAttribute")) {
                                    c10 = '\b';
                                    break;
                                }
                                break;
                            case 1803088381:
                                if (name.equals("Constraint")) {
                                    c10 = 0;
                                    break;
                                }
                                break;
                        }
                        switch (c10) {
                            case 0:
                                aVar = k(context, Xml.asAttributeSet(xmlPullParser), false);
                                aVar2 = aVar;
                                break;
                            case 1:
                                aVar = k(context, Xml.asAttributeSet(xmlPullParser), true);
                                aVar2 = aVar;
                                break;
                            case 2:
                                aVar = k(context, Xml.asAttributeSet(xmlPullParser), false);
                                b bVar = aVar.f1870d;
                                bVar.f1887a = true;
                                bVar.f1889b = true;
                                aVar2 = aVar;
                                break;
                            case 3:
                                aVar = k(context, Xml.asAttributeSet(xmlPullParser), false);
                                aVar.f1870d.f1902h0 = 1;
                                aVar2 = aVar;
                                break;
                            case 4:
                                if (aVar2 != null) {
                                    aVar2.f1868b.b(context, Xml.asAttributeSet(xmlPullParser));
                                    break;
                                } else {
                                    int lineNumber = xmlPullParser.getLineNumber();
                                    StringBuilder sb2 = new StringBuilder(56);
                                    sb2.append("XML parser error must be within a Constraint ");
                                    sb2.append(lineNumber);
                                    throw new RuntimeException(sb2.toString());
                                }
                            case 5:
                                if (aVar2 != null) {
                                    aVar2.f1871e.b(context, Xml.asAttributeSet(xmlPullParser));
                                    break;
                                } else {
                                    int lineNumber2 = xmlPullParser.getLineNumber();
                                    StringBuilder sb3 = new StringBuilder(56);
                                    sb3.append("XML parser error must be within a Constraint ");
                                    sb3.append(lineNumber2);
                                    throw new RuntimeException(sb3.toString());
                                }
                            case 6:
                                if (aVar2 != null) {
                                    aVar2.f1870d.b(context, Xml.asAttributeSet(xmlPullParser));
                                    break;
                                } else {
                                    int lineNumber3 = xmlPullParser.getLineNumber();
                                    StringBuilder sb4 = new StringBuilder(56);
                                    sb4.append("XML parser error must be within a Constraint ");
                                    sb4.append(lineNumber3);
                                    throw new RuntimeException(sb4.toString());
                                }
                            case 7:
                                if (aVar2 != null) {
                                    aVar2.f1869c.b(context, Xml.asAttributeSet(xmlPullParser));
                                    break;
                                } else {
                                    int lineNumber4 = xmlPullParser.getLineNumber();
                                    StringBuilder sb5 = new StringBuilder(56);
                                    sb5.append("XML parser error must be within a Constraint ");
                                    sb5.append(lineNumber4);
                                    throw new RuntimeException(sb5.toString());
                                }
                            case '\b':
                            case '\t':
                                if (aVar2 != null) {
                                    ConstraintAttribute.c(context, xmlPullParser, aVar2.f1872f);
                                    break;
                                } else {
                                    int lineNumber5 = xmlPullParser.getLineNumber();
                                    StringBuilder sb6 = new StringBuilder(56);
                                    sb6.append("XML parser error must be within a Constraint ");
                                    sb6.append(lineNumber5);
                                    throw new RuntimeException(sb6.toString());
                                }
                        }
                    } else if (eventType == 3) {
                        String lowerCase = xmlPullParser.getName().toLowerCase(Locale.ROOT);
                        switch (lowerCase.hashCode()) {
                            case -2075718416:
                                if (lowerCase.equals("guideline")) {
                                    c10 = 3;
                                    break;
                                }
                                break;
                            case -190376483:
                                if (lowerCase.equals("constraint")) {
                                    c10 = 1;
                                    break;
                                }
                                break;
                            case 426575017:
                                if (lowerCase.equals("constraintoverride")) {
                                    c10 = 2;
                                    break;
                                }
                                break;
                            case 2146106725:
                                if (lowerCase.equals("constraintset")) {
                                    c10 = 0;
                                    break;
                                }
                                break;
                        }
                        if (c10 == 0) {
                            return;
                        }
                        if (c10 == 1 || c10 == 2 || c10 == 3) {
                            this.f1866c.put(Integer.valueOf(aVar2.f1867a), aVar2);
                            aVar2 = null;
                        }
                    }
                } else {
                    xmlPullParser.getName();
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
        }
    }

    public void u(int i10, float f10) {
        l(i10).f1870d.f1924w = f10;
    }

    public void v(int i10, float f10) {
        l(i10).f1870d.f1925x = f10;
    }
}
