package gn;

import android.util.Log;
import cn.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/* loaded from: classes2.dex */
public class k {
    private int C;
    private int D;
    private int X;
    private int Y;

    /* renamed from: o  reason: collision with root package name */
    private double f27562o;

    /* renamed from: p  reason: collision with root package name */
    double f27563p;

    /* renamed from: q  reason: collision with root package name */
    double f27564q;

    /* renamed from: r  reason: collision with root package name */
    double f27565r;

    /* renamed from: s  reason: collision with root package name */
    double f27566s;

    /* renamed from: t  reason: collision with root package name */
    double f27567t;

    /* renamed from: u  reason: collision with root package name */
    double f27568u;

    /* renamed from: z  reason: collision with root package name */
    private int f27573z;

    /* renamed from: a  reason: collision with root package name */
    private int f27547a = 2;

    /* renamed from: b  reason: collision with root package name */
    private int f27549b = 3;

    /* renamed from: c  reason: collision with root package name */
    private int f27550c = 4;

    /* renamed from: d  reason: collision with root package name */
    private int f27551d = 2;

    /* renamed from: e  reason: collision with root package name */
    private boolean f27552e = false;

    /* renamed from: f  reason: collision with root package name */
    private int f27553f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f27554g = 5;

    /* renamed from: h  reason: collision with root package name */
    private int f27555h = 6;

    /* renamed from: i  reason: collision with root package name */
    private int f27556i = 7;

    /* renamed from: j  reason: collision with root package name */
    private int f27557j = 61;

    /* renamed from: k  reason: collision with root package name */
    private ArrayList<Double> f27558k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    private ArrayList<Double> f27559l = new ArrayList<>();

    /* renamed from: m  reason: collision with root package name */
    private ArrayList<Double> f27560m = new ArrayList<>();

    /* renamed from: n  reason: collision with root package name */
    private double f27561n = -1000000.0d;

    /* renamed from: v  reason: collision with root package name */
    private int f27569v = 0;

    /* renamed from: w  reason: collision with root package name */
    private int f27570w = 100;

    /* renamed from: x  reason: collision with root package name */
    private boolean f27571x = false;

    /* renamed from: y  reason: collision with root package name */
    private int f27572y = 0;
    private int A = 42;
    private int B = 200;
    private int E = 6;
    private ArrayList<Integer> F = new ArrayList<>();
    private ArrayList<Double> G = new ArrayList<>();
    private ArrayList<Integer> H = new ArrayList<>();
    private int I = 2;
    private int J = 1;
    private int K = 0;
    private double L = -1000000.0d;
    private double M = 0.2d;
    private double N = 0.3d;
    private double O = 0.125d;
    private int P = 1;
    private boolean Q = false;
    private int R = 0;
    private int S = 0;
    private double T = 0.0d;
    private int U = -10000;
    private int V = -30000;
    private int W = -20000;
    private int Z = 0;

    /* renamed from: a0  reason: collision with root package name */
    private boolean f27548a0 = false;

    public k() {
        int i10 = 100 * 60;
        this.f27573z = i10;
        this.C = i10 / 42;
        this.D = i10 / 200;
        double d10 = this.f27570w;
        this.X = (int) (0.13d * d10);
        this.Y = (int) (d10 * 0.03d);
    }

    private double a(ArrayList<Integer> arrayList, double d10) {
        int i10 = 0;
        if (arrayList.size() < this.E) {
            int i11 = 0;
            while (i10 < arrayList.size()) {
                i11 = (int) (i11 + ((arrayList.get(i10).intValue() - d10) * (arrayList.get(i10).intValue() - d10)));
                i10++;
            }
            if (arrayList.size() > 0) {
                return (i11 * 1.0d) / arrayList.size();
            }
            return 0.0d;
        }
        int size = arrayList.size();
        while (true) {
            size--;
            int size2 = arrayList.size();
            int i12 = this.E;
            if (size < size2 - i12) {
                return (i10 * 1.0d) / i12;
            }
            i10 = (int) (i10 + ((arrayList.get(size).intValue() - d10) * (arrayList.get(size).intValue() - d10)));
        }
    }

    private double b(ArrayList<Double> arrayList, int i10) {
        double doubleValue;
        int i11;
        if (i10 == this.f27554g) {
            doubleValue = ((arrayList.get(0).doubleValue() * (-2.0d)) - arrayList.get(1).doubleValue()) + arrayList.get(3).doubleValue();
            i11 = 4;
        } else if (i10 != this.f27557j) {
            return 0.0d;
        } else {
            doubleValue = ((arrayList.get(28).doubleValue() * (-2.0d)) - arrayList.get(29).doubleValue()) + arrayList.get(31).doubleValue();
            i11 = 32;
        }
        return doubleValue + (arrayList.get(i11).doubleValue() * 2.0d);
    }

    private double c(ArrayList<Double> arrayList, boolean z10) {
        if (arrayList.size() <= 0) {
            return 0.0d;
        }
        ArrayList arrayList2 = z10 ? new ArrayList(arrayList) : arrayList.size() > this.f27555h ? new ArrayList(arrayList.subList(arrayList.size() - this.f27555h, arrayList.size())) : new ArrayList(arrayList);
        Collections.sort(arrayList2);
        int size = arrayList2.size();
        if (size % 2 == 1) {
            return ((Double) arrayList2.get((size - 1) / 2)).doubleValue();
        }
        int i10 = size / 2;
        return ((((Double) arrayList2.get(i10 - 1)).doubleValue() + ((Double) arrayList2.get(i10)).doubleValue()) + 0.0d) / 2.0d;
    }

    private int d(ArrayList<Integer> arrayList) {
        int i10 = 0;
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            i10 += arrayList.get(i11).intValue();
        }
        if (arrayList.size() <= 0) {
            return 0;
        }
        return (this.f27570w * 60) / (i10 / arrayList.size());
    }

    private o e(ArrayList<Double> arrayList, int i10, int i11) {
        double d10 = -Math.pow(10.0d, 7.0d);
        int i12 = i10 + 1;
        int i13 = -1;
        while (i12 <= i11 - 1) {
            double doubleValue = arrayList.get(i12).doubleValue() - arrayList.get(i12 - 1).doubleValue();
            int i14 = i12 + 1;
            double doubleValue2 = arrayList.get(i14).doubleValue() - arrayList.get(i12).doubleValue();
            if (doubleValue >= 0.0d && doubleValue2 <= 0.0d && arrayList.get(i12).doubleValue() > d10) {
                d10 = arrayList.get(i12).doubleValue();
                i13 = i12;
            }
            i12 = i14;
        }
        return new o(d10, i13);
    }

    private ArrayList<Double> f(ArrayList<Double> arrayList, double d10, double d11) {
        ArrayList<Double> arrayList2 = new ArrayList<>();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            arrayList2.add(Double.valueOf(Math.exp((-((arrayList.get(i10).doubleValue() - d10) * (arrayList.get(i10).doubleValue() - d10))) / (2.0d * d11))));
        }
        return arrayList2;
    }

    private ArrayList<Double> g(ArrayList<Double> arrayList, ArrayList<Double> arrayList2) {
        ArrayList<Double> arrayList3 = new ArrayList<>();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            arrayList3.add(Double.valueOf(arrayList.get(i10).doubleValue() + arrayList2.get(i10).doubleValue()));
        }
        return arrayList3;
    }

    private void h(double d10) {
        this.f27559l.add(0, Double.valueOf(d10));
        if (this.f27559l.size() > this.f27556i) {
            ArrayList<Double> arrayList = this.f27559l;
            arrayList.remove(arrayList.size() - 1);
        }
    }

    private double i(ArrayList<Double> arrayList, double d10) {
        double d11 = 0.0d;
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            d11 += (arrayList.get(i10).doubleValue() - d10) * (arrayList.get(i10).doubleValue() - d10);
        }
        if (arrayList.size() > 0) {
            return d11 / arrayList.size();
        }
        return 0.0d;
    }

    private int j(ArrayList<Integer> arrayList) {
        int i10 = 0;
        for (int i11 = 1; i11 < arrayList.size(); i11++) {
            int intValue = arrayList.get(i11).intValue() - arrayList.get(i11 - 1).intValue();
            i10 += intValue * intValue;
        }
        if (arrayList.size() <= 1) {
            return 0;
        }
        int sqrt = (((int) Math.sqrt(i10 / (arrayList.size() - 1))) * 1000) / this.f27570w;
        return sqrt > 110 ? ((((int) Math.sqrt(i10)) / (arrayList.size() - 1)) * 1000) / this.f27570w : sqrt;
    }

    private int k(ArrayList<Integer> arrayList, boolean z10) {
        if (arrayList.size() <= 0) {
            return 0;
        }
        ArrayList arrayList2 = z10 ? new ArrayList(arrayList) : arrayList.size() > this.f27555h ? new ArrayList(arrayList.subList(arrayList.size() - this.f27555h, arrayList.size())) : new ArrayList(arrayList);
        Collections.sort(arrayList2);
        int size = arrayList2.size();
        if (size % 2 == 1) {
            return ((Integer) arrayList2.get((size - 1) / 2)).intValue();
        }
        int i10 = size / 2;
        return (((Integer) arrayList2.get(i10 - 1)).intValue() + ((Integer) arrayList2.get(i10)).intValue()) / 2;
    }

    private o l(ArrayList<Double> arrayList, int i10, int i11) {
        double pow = Math.pow(10.0d, 7.0d);
        int i12 = i10 + 1;
        int i13 = -1;
        while (i12 <= i11 - 1) {
            double doubleValue = arrayList.get(i12).doubleValue() - arrayList.get(i12 - 1).doubleValue();
            int i14 = i12 + 1;
            double doubleValue2 = arrayList.get(i14).doubleValue() - arrayList.get(i12).doubleValue();
            if (doubleValue <= 0.0d && doubleValue2 >= 0.0d && arrayList.get(i12).doubleValue() < pow) {
                pow = arrayList.get(i12).doubleValue();
                i13 = i12;
            }
            i12 = i14;
        }
        return new o(pow, i13);
    }

    private double m(ArrayList<Double> arrayList, double d10) {
        double d11 = 0.0d;
        if (arrayList.size() < this.E) {
            double d12 = 0.0d;
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                d12 += (Math.abs(arrayList.get(i10).doubleValue()) - d10) * (Math.abs(arrayList.get(i10).doubleValue()) - d10);
            }
            if (arrayList.size() > 0) {
                return d12 / arrayList.size();
            }
            return 0.0d;
        }
        int size = arrayList.size();
        while (true) {
            size--;
            int size2 = arrayList.size();
            int i11 = this.E;
            if (size < size2 - i11) {
                return d11 / i11;
            }
            d11 += (Math.abs(arrayList.get(size).doubleValue()) - d10) * (Math.abs(arrayList.get(size).doubleValue()) - d10);
        }
    }

    private int n(ArrayList<Double> arrayList) {
        int i10 = 0;
        double doubleValue = arrayList.get(0).doubleValue();
        for (int i11 = 1; i11 < arrayList.size(); i11++) {
            if (arrayList.get(i11).doubleValue() > doubleValue) {
                doubleValue = arrayList.get(i11).doubleValue();
                i10 = i11;
            }
        }
        return i10;
    }

    private double q(ArrayList<Double> arrayList) {
        double d10 = 0.0d;
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            d10 += arrayList.get(i10).doubleValue();
        }
        return d10;
    }

    private double r(ArrayList<Double> arrayList) {
        if (arrayList.size() > 0) {
            return q(arrayList) / arrayList.size();
        }
        return 0.0d;
    }

    private double s(ArrayList<Integer> arrayList) {
        double d10;
        double d11;
        int i10;
        int i11 = 0;
        if (arrayList.size() < this.E) {
            int i12 = 0;
            while (i11 < arrayList.size()) {
                i12 += arrayList.get(i11).intValue();
                i11++;
            }
            if (arrayList.size() <= 0) {
                return 0.0d;
            }
            d11 = i12 * 1.0d;
            d10 = arrayList.size();
        } else {
            int size = arrayList.size();
            while (true) {
                size--;
                int size2 = arrayList.size();
                i10 = this.E;
                if (size < size2 - i10) {
                    break;
                }
                i11 += arrayList.get(size).intValue();
            }
            d11 = i11 * 1.0d;
            d10 = i10;
        }
        return d11 / d10;
    }

    private double t(ArrayList<Double> arrayList) {
        double d10 = 0.0d;
        if (arrayList.size() < this.E) {
            double d11 = 0.0d;
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                d11 += Math.abs(arrayList.get(i10).doubleValue());
            }
            if (arrayList.size() > 0) {
                return (d11 * 1.0d) / arrayList.size();
            }
            return 0.0d;
        }
        int size = arrayList.size();
        while (true) {
            size--;
            int size2 = arrayList.size();
            int i11 = this.E;
            if (size < size2 - i11) {
                return (d10 * 1.0d) / i11;
            }
            d10 += Math.abs(arrayList.get(size).doubleValue());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x007a, code lost:
        if (java.lang.Math.abs(r28.V - r1) < r28.X) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int w(ArrayList<Double> arrayList) {
        int i10;
        int i11;
        String str;
        StringBuilder sb2;
        int i12;
        this.Z++;
        this.K++;
        double b10 = b(arrayList, this.f27557j);
        if (b10 > this.L) {
            this.L = b10;
        }
        if (b10 > this.f27564q) {
            int i13 = this.Z;
            this.V = i13;
            if (Math.abs(i13 - this.W) >= this.X) {
                if (Math.abs(this.V - this.U) < this.Y) {
                    this.f27572y = 2;
                }
                this.f27572y = 1;
            }
            i12 = this.f27572y + 2;
            this.f27572y = i12;
        } else {
            if (b10 > this.f27563p) {
                int i14 = this.Z;
                this.U = i14;
                if (Math.abs(i14 - this.W) < this.X) {
                    i12 = this.f27572y + 1;
                    this.f27572y = i12;
                }
            } else if (b10 < 0.0d && Math.abs(b10) > this.f27565r) {
                int i15 = this.Z;
                this.W = i15;
            }
            this.f27572y = 1;
        }
        if (this.f27572y > 2) {
            this.f27572y = 0;
            int i16 = this.f27557j - 1;
            o e10 = e(arrayList, 0, i16);
            o l10 = l(arrayList, 0, i16);
            int a10 = e10.a();
            double b11 = e10.b();
            int a11 = l10.a();
            double b12 = l10.b();
            if (a10 != -1) {
                if (a11 != -1 && b11 < Math.abs(b12)) {
                    a10 = a11;
                }
                if (!this.f27552e) {
                    this.f27552e = true;
                } else {
                    int size = this.G.size();
                    double s10 = s(this.F);
                    this.f27548a0 = false;
                    int k10 = k(this.F, false);
                    if ((size <= 0 || this.f27553f >= this.D) && (size <= 1 || this.f27553f >= k10 * 0.6d)) {
                        this.G.add(arrayList.get(a10));
                        if (this.G.size() > 1) {
                            this.H.add(Integer.valueOf(this.f27553f));
                            int i17 = this.f27553f;
                            if (i17 < this.C && this.D < i17) {
                                this.F.add(Integer.valueOf(i17));
                                i11 = (int) (this.f27573z / s(this.F));
                                sb2 = new StringBuilder();
                                str = "validHr2=";
                                sb2.append(str);
                                sb2.append(i11);
                                Log.i("realTimeHr", sb2.toString());
                            }
                        }
                        i11 = 0;
                    } else if (size > 1) {
                        int i18 = this.f27553f;
                        ArrayList<Integer> arrayList2 = this.H;
                        int intValue = i18 + arrayList2.get(arrayList2.size() - 1).intValue();
                        ArrayList<Integer> arrayList3 = this.H;
                        int intValue2 = arrayList3.get(arrayList3.size() - 1).intValue();
                        int i19 = intValue - k10;
                        double a12 = a(this.F, s10) * 2.0d;
                        double exp = Math.exp((-(i19 * i19)) / a12);
                        int i20 = intValue2 - k10;
                        double exp2 = Math.exp((-(i20 * i20)) / a12);
                        double t10 = t(this.G);
                        double c10 = c(this.G, this.f27548a0);
                        double m10 = m(this.G, t10) * 2.0d;
                        int i21 = size - 1;
                        int i22 = a10;
                        if ((exp * 0.3d) + (Math.exp((-((Math.abs(arrayList.get(a10).doubleValue()) - c10) * (Math.abs(arrayList.get(a10).doubleValue()) - c10))) / m10) * 0.7d) > (exp2 * 0.3d) + (Math.exp((-((Math.abs(this.G.get(i21).doubleValue()) - c10) * (Math.abs(this.G.get(i21).doubleValue()) - c10))) / m10) * 0.7d)) {
                            ArrayList<Integer> arrayList4 = this.H;
                            arrayList4.remove(arrayList4.size() - 1);
                            this.H.add(Integer.valueOf(intValue));
                            ArrayList<Double> arrayList5 = this.G;
                            arrayList5.remove(arrayList5.size() - 1);
                            this.G.add(arrayList.get(i22));
                            if (this.F.size() >= 1 && intValue < this.C && this.D < intValue) {
                                ArrayList<Integer> arrayList6 = this.F;
                                arrayList6.remove(arrayList6.size() - 1);
                                this.F.add(Integer.valueOf(intValue));
                                i11 = (int) (this.f27573z / s(this.F));
                                sb2 = new StringBuilder();
                                str = "validHr1=";
                                sb2.append(str);
                                sb2.append(i11);
                                Log.i("realTimeHr", sb2.toString());
                            }
                            i11 = 0;
                        }
                    } else {
                        int i23 = a10;
                        if (Math.abs(arrayList.get(i23).doubleValue()) > Math.abs(this.G.get(size - 1).doubleValue())) {
                            ArrayList<Double> arrayList7 = this.G;
                            arrayList7.remove(arrayList7.size() - 1);
                            this.G.add(arrayList.get(i23));
                            this.f27553f = 0;
                        }
                    }
                    this.f27553f = 0;
                    i10 = i11;
                    if (this.K >= this.I * this.f27570w) {
                        new ArrayList(Arrays.asList(Double.valueOf(1.0d), Double.valueOf(0.9d), Double.valueOf(0.8d), Double.valueOf(0.7d), Double.valueOf(0.6d), Double.valueOf(0.5d), Double.valueOf(0.4d)));
                        h(this.L);
                        ArrayList arrayList8 = new ArrayList(Arrays.asList(Double.valueOf(1.0d), Double.valueOf(0.98d), Double.valueOf(0.96d), Double.valueOf(0.94d), Double.valueOf(0.92d), Double.valueOf(0.9d), Double.valueOf(0.88d)));
                        int i24 = this.P + 1;
                        this.P = i24;
                        this.f27548a0 = true;
                        if (i24 > 7) {
                            double doubleValue = this.f27559l.get(n(g(new ArrayList<>(arrayList8), f(this.f27559l, c(this.f27559l, this.f27548a0), i(this.f27559l, r(this.f27559l)))))).doubleValue();
                            this.f27562o = doubleValue;
                            this.f27563p = (this.M * doubleValue) + this.f27566s;
                            this.f27564q = (this.N * doubleValue) + this.f27567t;
                            this.f27565r = (this.O * doubleValue) + this.f27568u;
                            if (this.P % 3 == 0) {
                                double d10 = doubleValue * 0.1d;
                                this.f27566s = d10;
                                this.f27567t = d10 + 2.0d;
                                this.f27568u = d10;
                                this.P = 9;
                            }
                        } else {
                            double doubleValue2 = this.f27559l.get(n(g(new ArrayList<>(arrayList8.subList(0, this.f27559l.size())), f(this.f27559l, c(this.f27559l, this.f27548a0), i(this.f27559l, r(this.f27559l)))))).doubleValue();
                            this.f27562o = doubleValue2;
                            double d11 = 0.1d * doubleValue2;
                            this.f27566s = d11;
                            double d12 = 2.0d + d11;
                            this.f27567t = d12;
                            this.f27568u = d11;
                            this.f27563p = (this.M * doubleValue2) + d11;
                            this.f27564q = (this.N * doubleValue2) + d12;
                            this.f27565r = (this.O * doubleValue2) + d11;
                        }
                        this.K = 0;
                        this.L = -1.0E8d;
                    }
                    return i10;
                }
            }
        }
        i10 = 0;
        if (this.K >= this.I * this.f27570w) {
        }
        return i10;
    }

    public int o(short s10) {
        if (!this.Q) {
            int i10 = this.R + s10;
            this.R = i10;
            int i11 = this.S + 1;
            this.S = i11;
            int i12 = this.f27570w * 2;
            if (i11 != i12) {
                return 0;
            }
            this.T = (i10 * 1.0d) / i12;
            this.R = 0;
            this.S = 0;
            this.Q = true;
            return 0;
        }
        double d10 = this.T;
        double d11 = s10 - d10;
        int i13 = this.R + s10;
        this.R = i13;
        int i14 = this.S + 1;
        this.S = i14;
        int i15 = this.f27570w * 2;
        if (i14 == i15) {
            this.T = (d10 * 0.3d) + (((i13 * 1.0d) / i15) * 0.7d);
            this.S = 0;
            this.R = 0;
        }
        if (this.f27552e) {
            this.f27553f++;
        }
        int i16 = this.f27551d;
        int i17 = this.f27550c;
        if (i16 != i17) {
            if (i16 == this.f27547a) {
                this.f27558k.add(Double.valueOf(d11));
                int size = this.f27558k.size();
                int i18 = this.f27554g;
                if (size != i18) {
                    return 0;
                }
                this.f27551d = this.f27549b;
                double b10 = b(this.f27558k, i18);
                if (b10 > this.f27561n) {
                    this.f27561n = b10;
                }
                this.f27569v++;
                return 0;
            }
            this.f27558k.remove(0);
            this.f27558k.add(Double.valueOf(d11));
            double b11 = b(this.f27558k, this.f27554g);
            if (b11 > this.f27561n) {
                this.f27561n = b11;
            }
            int i19 = this.f27569v + 1;
            this.f27569v = i19;
            if (i19 != this.I * this.f27570w) {
                return 0;
            }
            this.f27569v = 0;
            this.f27559l.add(Double.valueOf(this.f27561n));
            if (this.f27559l.size() == this.J) {
                this.f27551d = this.f27550c;
                double d12 = this.f27561n;
                this.f27562o = d12;
                this.f27563p = this.M * d12;
                this.f27564q = (this.N * d12) + 2.0d;
                this.f27565r = this.O * d12;
                double d13 = d12 * 0.10000000149011612d;
                this.f27566s = d13;
                this.f27567t = 2.0d + d13;
                this.f27568u = d13;
                this.f27560m.addAll(this.f27558k);
                return 0;
            }
            this.f27551d = this.f27547a;
            this.f27558k.clear();
            this.f27561n = -1000000.0d;
            return 0;
        } else if (i16 != i17) {
            return 0;
        } else {
            if (!this.f27571x) {
                this.f27560m.add(Double.valueOf(d11));
                if (this.f27560m.size() != this.f27557j) {
                    return 0;
                }
                int w10 = w(this.f27560m);
                this.f27571x = true;
                return w10;
            }
            this.f27560m.remove(0);
            this.f27560m.add(Double.valueOf(d11));
            return w(this.f27560m);
        }
    }

    public void p() {
        this.Q = false;
        this.R = 0;
        this.S = 0;
        this.T = 0.0d;
        this.f27551d = this.f27547a;
        this.f27569v = 0;
        this.f27561n = -1.0E8d;
        this.f27559l.clear();
        this.f27558k.clear();
        this.f27560m.clear();
        this.f27571x = false;
        this.f27572y = 0;
        this.f27552e = false;
        this.f27553f = 0;
        this.F.clear();
        this.G.clear();
        this.H.clear();
        this.K = 0;
        this.L = -1.0E8d;
        this.P = 1;
    }

    public int u() {
        int d10 = d(this.F);
        Log.i("RTHR", "AverageHR=" + d10 + ",recRR.size=" + this.F.size() + ",recRR.toString=" + this.F.toString());
        return d10;
    }

    public int v() {
        int j10 = j(this.F);
        Log.i("RTHR", "HRV=" + j10 + ",recRR.size=" + this.F.size());
        return j10;
    }
}
