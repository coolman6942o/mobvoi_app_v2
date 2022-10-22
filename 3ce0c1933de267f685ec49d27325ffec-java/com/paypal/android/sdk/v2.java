package com.paypal.android.sdk;

import android.util.Log;
import com.unionpay.tsmservice.data.Constant;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class v2 {

    /* renamed from: a  reason: collision with root package name */
    private static List f22032a = Arrays.asList(Constant.KEY_CURRENCYTYPE_AUD, "BRL", "CAD", "CHF", "CZK", "DKK", Constant.KEY_CURRENCYTYPE_EUR, Constant.KEY_CURRENCYTYPE_GBP, "HKD", "HUF", "ILS", Constant.KEY_CURRENCYTYPE_JPY, "MXN", "MYR", "NOK", "NZD", "PHP", "PLN", "RUB", "SEK", "SGD", "THB", "TWD", "TRY", Constant.KEY_CURRENCYTYPE_USD);

    /* renamed from: b  reason: collision with root package name */
    private static String f22033b = "JPY, HUF, TWD";

    /* renamed from: c  reason: collision with root package name */
    private static final Locale f22034c = Locale.US;

    /* renamed from: d  reason: collision with root package name */
    private static final Locale f22035d = Locale.GERMANY;

    /* renamed from: e  reason: collision with root package name */
    private static List f22036e = null;

    /* renamed from: f  reason: collision with root package name */
    private static NumberFormat f22037f = null;

    public static String a(double d10, String str) {
        return b(d10, str, (DecimalFormat) NumberFormat.getInstance(f22034c));
    }

    private static String b(double d10, String str, DecimalFormat decimalFormat) {
        decimalFormat.applyPattern(f22033b.indexOf(str.toUpperCase(Locale.US)) == -1 ? "#####0.00" : "#######0");
        return decimalFormat.format(d10);
    }

    public static String c(double d10, Currency currency) {
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(d(currency).equals(",") ? f22035d : f22034c);
        decimalFormat.applyPattern(f22033b.indexOf(currency.getCurrencyCode().toUpperCase(Locale.US)) == -1 ? "#####0.00" : "#######0");
        return decimalFormat.format(d10);
    }

    private static String d(Currency currency) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setCurrency(currency);
        return decimalFormat.format(1.56d).indexOf(".") > 0 ? "." : ",";
    }

    public static String e(Locale locale, String str, double d10, String str2, boolean z10) {
        String str3;
        String symbol = Currency.getInstance(str2).getSymbol();
        Currency currency = Currency.getInstance(str2);
        if (f22037f == null) {
            f22037f = NumberFormat.getCurrencyInstance(locale);
        }
        f22037f.setCurrency(currency);
        boolean z11 = !(f22037f.format(1234.56d).indexOf("1") == 0);
        StringBuilder sb2 = new StringBuilder();
        String str4 = "";
        if (z11) {
            str3 = symbol + " ";
        } else {
            str3 = str4;
        }
        sb2.append(str3);
        boolean equalsIgnoreCase = str.equalsIgnoreCase("AU");
        String str5 = Constant.KEY_CURRENCYTYPE_GBP;
        str5 = Constant.KEY_CURRENCYTYPE_EUR;
        if (equalsIgnoreCase) {
            str5 = Constant.KEY_CURRENCYTYPE_AUD;
        } else if (!str.equalsIgnoreCase("GB") && !str.equalsIgnoreCase("UK")) {
            if (str.equalsIgnoreCase("CA")) {
                str5 = "CAD";
            } else if (!str.equalsIgnoreCase("AT")) {
                if (str.equalsIgnoreCase("CZ")) {
                    str5 = "CZK";
                } else if (str.equalsIgnoreCase("DK")) {
                    str5 = "DKK";
                } else if (!str.equalsIgnoreCase("FR") && !str.equalsIgnoreCase("DE")) {
                    if (str.equalsIgnoreCase("HU")) {
                        str5 = "HUF";
                    } else if (!str.equalsIgnoreCase("IE") && !str.equalsIgnoreCase("IT") && !str.equalsIgnoreCase("NL")) {
                        if (str.equalsIgnoreCase("PL")) {
                            str5 = "PLN";
                        } else if (!str.equalsIgnoreCase("PT") && !str.equalsIgnoreCase("ES")) {
                            if (str.equalsIgnoreCase("SE")) {
                                str5 = "SEK";
                            } else {
                                if (!str.equalsIgnoreCase("ZA")) {
                                    if (str.equalsIgnoreCase("NZ")) {
                                        str5 = "NZD";
                                    } else if (!str.equalsIgnoreCase("LT")) {
                                        if (str.equalsIgnoreCase("JP")) {
                                            str5 = Constant.KEY_CURRENCYTYPE_JPY;
                                        } else if (str.equalsIgnoreCase("BR")) {
                                            str5 = "BRL";
                                        } else if (str.equalsIgnoreCase("MY")) {
                                            str5 = "MYR";
                                        } else if (str.equalsIgnoreCase("MX")) {
                                            str5 = "MXN";
                                        } else if (str.equalsIgnoreCase("RU")) {
                                            str5 = "RUB";
                                        }
                                    }
                                }
                                str5 = Constant.KEY_CURRENCYTYPE_USD;
                            }
                        }
                    }
                }
            }
        }
        sb2.append(b(d10, str2, (DecimalFormat) NumberFormat.getInstance(d(Currency.getInstance(str5)).equals(",") ? f22035d : f22034c)));
        if (!z11) {
            str4 = " " + symbol;
        }
        sb2.append(str4);
        return sb2.toString();
    }

    public static boolean f(String str) {
        if (str == null) {
            return false;
        }
        try {
            Currency currency = Currency.getInstance(str);
            if (f22036e == null) {
                f22036e = new ArrayList();
                for (String str2 : f22032a) {
                    f22036e.add(Currency.getInstance(str2));
                }
                Collections.sort(f22036e, new w2());
            }
            return f22036e.contains(currency);
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public static boolean g(BigDecimal bigDecimal, String str, boolean z10) {
        String str2;
        if (bigDecimal == null) {
            str2 = "The specified amount is null.";
        } else if (z10 && BigDecimal.ZERO.compareTo(bigDecimal) != -1) {
            str2 = "The specified amount must be greater than zero.";
        } else if (!f(str) || !Arrays.asList("HUF", Constant.KEY_CURRENCYTYPE_JPY, "TWD").contains(str) || bigDecimal.scale() <= 0) {
            return true;
        } else {
            str2 = "The specified currency (" + str + ") does not support fractional amounts.";
        }
        Log.e("paypal.sdk", str2);
        return false;
    }
}
