package com.mobvoi.wear.util;
/* loaded from: classes2.dex */
public class LocationUtil {
    private static double DEF_2PI = 6.28318530712d;
    private static double DEF_PI = 3.14159265359d;
    private static double DEF_PI180 = 0.01745329252d;
    private static double DEF_R = 6370693.5d;

    public static double getDistance(double d10, double d11, double d12, double d13) {
        double sqrt;
        double d14;
        double atan2;
        double d15;
        double d16;
        double d17;
        double d18;
        double radians = Math.toRadians(d13 - d11);
        double atan = Math.atan(Math.tan(Math.toRadians(d10)) * 0.9966471893352525d);
        double atan3 = Math.atan(0.9966471893352525d * Math.tan(Math.toRadians(d12)));
        double sin = Math.sin(atan);
        double cos = Math.cos(atan);
        double sin2 = Math.sin(atan3);
        double cos2 = Math.cos(atan3);
        double d19 = 100.0d;
        double d20 = radians;
        while (true) {
            double sin3 = Math.sin(d20);
            double cos3 = Math.cos(d20);
            double d21 = (cos * sin2) - ((sin * cos2) * cos3);
            double d22 = cos2 * sin3;
            double d23 = d19;
            sqrt = Math.sqrt((d22 * d22) + (d21 * d21));
            if (sqrt != 0.0d) {
                double d24 = cos * cos2;
                cos = cos;
                d14 = (sin * sin2) + (cos3 * d24);
                atan2 = Math.atan2(sqrt, d14);
                double d25 = (d24 * sin3) / sqrt;
                d15 = 1.0d - (d25 * d25);
                d16 = d14 - (((sin * 2.0d) * sin2) / d15);
                double d26 = 2.0955066654671753E-4d * d15 * (((4.0d - (3.0d * d15)) * 0.0033528106647474805d) + 4.0d);
                d17 = ((2.0d * d16) * d16) - 1.0d;
                double d27 = radians + ((1.0d - d26) * 0.0033528106647474805d * d25 * (atan2 + (d26 * sqrt * (d16 + (d26 * d14 * d17)))));
                if (Math.abs(d27 - d20) <= 1.0E-12d) {
                    d18 = d23;
                    break;
                }
                d18 = d23 - 1.0d;
                if (d18 <= 0.0d) {
                    break;
                }
                d19 = d18;
                d20 = d27;
            } else {
                return 0.0d;
            }
        }
        if (d18 == 0.0d) {
            return 0.0d;
        }
        double d28 = (d15 * 2.7233160610984375E11d) / 4.040829998465916E13d;
        double d29 = (d28 / 1024.0d) * ((d28 * (((74.0d - (47.0d * d28)) * d28) - 128.0d)) + 256.0d);
        return 6356752.314245d * (((d28 / 16384.0d) * (((((320.0d - (175.0d * d28)) * d28) - 768.0d) * d28) + 4096.0d)) + 1.0d) * (atan2 - ((d29 * sqrt) * (d16 + ((d29 / 4.0d) * ((d14 * d17) - ((((d29 / 6.0d) * d16) * (((sqrt * 4.0d) * sqrt) - 3.0d)) * (((4.0d * d16) * d16) - 3.0d)))))));
    }

    public static double getShortDistance(double d10, double d11, double d12, double d13) {
        double d14 = DEF_PI180;
        double d15 = d11 * d14;
        double d16 = d13 * d14;
        double d17 = (d10 * d14) - (d12 * d14);
        double d18 = DEF_PI;
        if (d17 > d18) {
            d17 = DEF_2PI - d17;
        } else if (d17 < (-d18)) {
            d17 += DEF_2PI;
        }
        double cos = DEF_R * Math.cos(d15) * d17;
        double d19 = DEF_R * (d15 - d16);
        return Math.sqrt((cos * cos) + (d19 * d19));
    }
}
