package com.mobvoi.wear.info;

import u9.b;
/* loaded from: classes2.dex */
public class AwSkuInfo {
    private static final String SKU_COLOR_BLACK = "black";
    private static final String SKU_COLOR_GOLDEN = "golden";
    public static final String SKU_COLOR_KEY = "ro.oem.tw.color";
    private static final String SKU_COLOR_SILVER = "silver";
    private static final String SKU_COLOR_WHITE = "white";
    private static final String SKU_COLOR_YELLOW = "yellow";
    public static final String SKU_THEME_GREEN = "Green";
    public static final String SKU_THEME_INDIGO = "Indigo";
    public static final String SKU_THEME_KEY = "ro.oem.tw.theme";
    private static final DeviceColor sSkuColor;

    /* loaded from: classes2.dex */
    public enum DeviceColor {
        BLACK,
        WHITE,
        YELLOW,
        SILVER,
        GOLDEN,
        UNKNOWN
    }

    static {
        String a10 = b.a(SKU_COLOR_KEY, "");
        if (SKU_COLOR_WHITE.equals(a10)) {
            sSkuColor = DeviceColor.WHITE;
        } else if (SKU_COLOR_BLACK.equals(a10)) {
            sSkuColor = DeviceColor.BLACK;
        } else if (SKU_COLOR_YELLOW.equals(a10)) {
            sSkuColor = DeviceColor.YELLOW;
        } else if (SKU_COLOR_SILVER.equals(a10)) {
            sSkuColor = DeviceColor.SILVER;
        } else if (SKU_COLOR_GOLDEN.equals(a10)) {
            sSkuColor = DeviceColor.GOLDEN;
        } else {
            sSkuColor = DeviceColor.UNKNOWN;
        }
    }

    public static DeviceColor getColor() {
        return sSkuColor;
    }
}
