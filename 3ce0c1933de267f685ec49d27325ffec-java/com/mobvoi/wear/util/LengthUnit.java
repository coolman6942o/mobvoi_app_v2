package com.mobvoi.wear.util;
/* loaded from: classes2.dex */
public enum LengthUnit {
    NANOMETERS { // from class: com.mobvoi.wear.util.LengthUnit.1
        @Override // com.mobvoi.wear.util.LengthUnit
        public float toCentis(float f10) {
            return f10 / LengthUnit.C3;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toDecis(float f10) {
            return f10 / LengthUnit.C4;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toFoots(float f10) {
            return f10 / LengthUnit.E2;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toInchs(float f10) {
            return f10 / LengthUnit.E1;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toKilos(float f10) {
            return f10 / LengthUnit.C6;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMeters(float f10) {
            return f10 / LengthUnit.C5;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMicros(float f10) {
            return f10 / LengthUnit.C1;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMiles(float f10) {
            return f10 / LengthUnit.E3;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMillis(float f10) {
            return f10 / LengthUnit.C2;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toNanos(float f10) {
            return f10;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toNauticals(float f10) {
            return f10 / LengthUnit.N;
        }
    },
    MICROMETERS { // from class: com.mobvoi.wear.util.LengthUnit.2
        @Override // com.mobvoi.wear.util.LengthUnit
        public float toCentis(float f10) {
            return f10 / 10000.0f;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toDecis(float f10) {
            return f10 / 100000.0f;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toFoots(float f10) {
            return f10 / 304800.0f;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toInchs(float f10) {
            return f10 / 25400.0f;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toKilos(float f10) {
            return f10 / LengthUnit.C5;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMeters(float f10) {
            return f10 / LengthUnit.C2;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMicros(float f10) {
            return f10;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMiles(float f10) {
            return f10 / 1.609344E9f;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMillis(float f10) {
            return f10 / LengthUnit.C1;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toNanos(float f10) {
            return LengthUnit.x(f10, LengthUnit.C1, 3.4028234E35f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toNauticals(float f10) {
            return f10 / 1.852E9f;
        }
    },
    MILLIMETERS { // from class: com.mobvoi.wear.util.LengthUnit.3
        @Override // com.mobvoi.wear.util.LengthUnit
        public float toCentis(float f10) {
            return f10 / 10.0f;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toDecis(float f10) {
            return f10 / 100.0f;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toFoots(float f10) {
            return f10 / 304.8f;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toInchs(float f10) {
            return f10 / 25.4f;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toKilos(float f10) {
            return f10 / LengthUnit.C2;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMeters(float f10) {
            return f10 / LengthUnit.C1;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMicros(float f10) {
            return LengthUnit.x(f10, LengthUnit.C1, 3.4028234E35f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMiles(float f10) {
            return f10 / 1609344.0f;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMillis(float f10) {
            return f10;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toNanos(float f10) {
            return LengthUnit.x(f10, LengthUnit.C2, 3.4028233E32f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toNauticals(float f10) {
            return f10 / 1852000.0f;
        }
    },
    CENTIMETERS { // from class: com.mobvoi.wear.util.LengthUnit.4
        @Override // com.mobvoi.wear.util.LengthUnit
        public float toCentis(float f10) {
            return f10;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toDecis(float f10) {
            return f10 / 10.0f;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toFoots(float f10) {
            return f10 / 30.48f;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toInchs(float f10) {
            return f10 / 2.54f;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toKilos(float f10) {
            return f10 / 100000.0f;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMeters(float f10) {
            return f10 / 100.0f;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMicros(float f10) {
            return LengthUnit.x(f10, 10000.0f, 3.4028236E34f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMiles(float f10) {
            return f10 / 160934.39f;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMillis(float f10) {
            return LengthUnit.x(f10, 10.0f, 3.4028235E37f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toNanos(float f10) {
            return LengthUnit.x(f10, LengthUnit.C3, 3.4028235E31f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toNauticals(float f10) {
            return f10 / 185200.0f;
        }
    },
    DECIMETERS { // from class: com.mobvoi.wear.util.LengthUnit.5
        @Override // com.mobvoi.wear.util.LengthUnit
        public float toCentis(float f10) {
            return LengthUnit.x(f10, 10.0f, 3.4028235E37f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toDecis(float f10) {
            return f10;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toFoots(float f10) {
            return f10 / 3.048f;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toInchs(float f10) {
            return f10 / 0.254f;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toKilos(float f10) {
            return f10 / 10000.0f;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMeters(float f10) {
            return f10 / 10.0f;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMicros(float f10) {
            return LengthUnit.x(f10, 100000.0f, 3.4028236E33f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMiles(float f10) {
            return f10 / 16093.439f;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMillis(float f10) {
            return LengthUnit.x(f10, 100.0f, 3.4028236E36f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toNanos(float f10) {
            return LengthUnit.x(f10, LengthUnit.C4, 3.4028233E30f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toNauticals(float f10) {
            return f10 / 18520.0f;
        }
    },
    METERS { // from class: com.mobvoi.wear.util.LengthUnit.6
        @Override // com.mobvoi.wear.util.LengthUnit
        public float toCentis(float f10) {
            return LengthUnit.x(f10, 100.0f, 3.4028236E36f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toDecis(float f10) {
            return LengthUnit.x(f10, 10.0f, 3.4028235E37f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toFoots(float f10) {
            return f10 / 0.3048f;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toInchs(float f10) {
            return f10 / 0.0254f;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toKilos(float f10) {
            return f10 / LengthUnit.C1;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMeters(float f10) {
            return f10;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMicros(float f10) {
            return LengthUnit.x(f10, LengthUnit.C2, 3.4028233E32f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMiles(float f10) {
            return f10 / 1609.344f;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMillis(float f10) {
            return LengthUnit.x(f10, LengthUnit.C1, 3.4028234E35f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toNanos(float f10) {
            return LengthUnit.x(f10, LengthUnit.C5, 3.4028236E29f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toNauticals(float f10) {
            return f10 / 1852.0f;
        }
    },
    KILOMETERS { // from class: com.mobvoi.wear.util.LengthUnit.7
        @Override // com.mobvoi.wear.util.LengthUnit
        public float toCentis(float f10) {
            return LengthUnit.x(f10, 100000.0f, 3.4028236E33f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toDecis(float f10) {
            return LengthUnit.x(f10, 10000.0f, 3.4028236E34f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toFoots(float f10) {
            return f10 / 3.048E-4f;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toInchs(float f10) {
            return f10 / 2.54E-5f;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toKilos(float f10) {
            return f10;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMeters(float f10) {
            return LengthUnit.x(f10, LengthUnit.C1, 3.4028234E35f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMicros(float f10) {
            return LengthUnit.x(f10, LengthUnit.C5, 3.4028236E29f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMiles(float f10) {
            return f10 / 1.609344f;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMillis(float f10) {
            return LengthUnit.x(f10, LengthUnit.C2, 3.4028233E32f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toNanos(float f10) {
            return LengthUnit.x(f10, LengthUnit.C6, 3.4028237E26f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toNauticals(float f10) {
            return f10 / 1.852f;
        }
    },
    INCHS { // from class: com.mobvoi.wear.util.LengthUnit.8
        @Override // com.mobvoi.wear.util.LengthUnit
        public float toCentis(float f10) {
            return LengthUnit.x(f10, 2.54f, 1.3396943E38f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toDecis(float f10) {
            return LengthUnit.x(f10, 0.254f, LengthUnit.MAX);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toFoots(float f10) {
            return f10 / 12.0f;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toInchs(float f10) {
            return f10;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toKilos(float f10) {
            return LengthUnit.x(f10, 2.54E-5f, LengthUnit.MAX);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMeters(float f10) {
            return LengthUnit.x(f10, 0.0254f, LengthUnit.MAX);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMicros(float f10) {
            return LengthUnit.x(f10, 25400.0f, 1.3396943E34f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMiles(float f10) {
            return f10 / 63360.0f;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMillis(float f10) {
            return LengthUnit.x(f10, 25.4f, 1.3396944E37f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toNanos(float f10) {
            return LengthUnit.x(f10, LengthUnit.E1, 1.3396942E31f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toNauticals(float f10) {
            return f10 / 72913.39f;
        }
    },
    FOOTS { // from class: com.mobvoi.wear.util.LengthUnit.9
        @Override // com.mobvoi.wear.util.LengthUnit
        public float toCentis(float f10) {
            return LengthUnit.x(f10, 30.48f, 1.1164119E37f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toDecis(float f10) {
            return LengthUnit.x(f10, 3.048f, 1.1164119E38f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toFoots(float f10) {
            return f10;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toInchs(float f10) {
            return LengthUnit.x(f10, 12.0f, 2.8356862E37f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toKilos(float f10) {
            return LengthUnit.x(f10, 3.048E-4f, LengthUnit.MAX);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMeters(float f10) {
            return LengthUnit.x(f10, 0.3048f, LengthUnit.MAX);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMicros(float f10) {
            return LengthUnit.x(f10, 304800.0f, 1.1164119E33f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMiles(float f10) {
            return f10 / 5280.0f;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMillis(float f10) {
            return LengthUnit.x(f10, 304.8f, 1.116412E36f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toNanos(float f10) {
            return LengthUnit.x(f10, LengthUnit.E2, 1.1164119E30f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toNauticals(float f10) {
            return f10 / 6076.1157f;
        }
    },
    MILES { // from class: com.mobvoi.wear.util.LengthUnit.10
        @Override // com.mobvoi.wear.util.LengthUnit
        public float toCentis(float f10) {
            return LengthUnit.x(f10, 160934.39f, 2.1144166E33f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toDecis(float f10) {
            return LengthUnit.x(f10, 16093.439f, 2.1144164E34f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toFoots(float f10) {
            return LengthUnit.x(f10, 5280.0f, 6.4447416E34f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toInchs(float f10) {
            return LengthUnit.x(f10, 63360.0f, 5.370618E33f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toKilos(float f10) {
            return LengthUnit.x(f10, 1.609344f, 2.1144165E38f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMeters(float f10) {
            return LengthUnit.x(f10, 1609.344f, 2.1144164E35f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMicros(float f10) {
            return LengthUnit.x(f10, 1.609344E9f, 2.1144165E29f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMiles(float f10) {
            return f10;
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMillis(float f10) {
            return LengthUnit.x(f10, 1609344.0f, 2.1144165E32f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toNanos(float f10) {
            return LengthUnit.x(f10, LengthUnit.E3, 2.1144165E26f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toNauticals(float f10) {
            return f10 / 1.1507795f;
        }
    },
    NAUTICALMILES { // from class: com.mobvoi.wear.util.LengthUnit.11
        @Override // com.mobvoi.wear.util.LengthUnit
        public float toCentis(float f10) {
            return LengthUnit.x(f10, 185200.0f, 1.8373777E33f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toDecis(float f10) {
            return LengthUnit.x(f10, 18520.0f, 1.8373777E34f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toFoots(float f10) {
            return LengthUnit.x(f10, 6076.1157f, 5.600327E34f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toInchs(float f10) {
            return LengthUnit.x(f10, 72913.39f, 4.666939E33f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toKilos(float f10) {
            return LengthUnit.x(f10, 1.852f, 1.8373776E38f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMeters(float f10) {
            return LengthUnit.x(f10, 1852.0f, 1.8373777E35f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMicros(float f10) {
            return LengthUnit.x(f10, 1.852E9f, 1.8373776E29f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMiles(float f10) {
            return LengthUnit.x(f10, 1.1507795f, 2.9569727E38f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toMillis(float f10) {
            return LengthUnit.x(f10, 1852000.0f, 1.8373777E32f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toNanos(float f10) {
            return LengthUnit.x(f10, LengthUnit.N, 1.8373776E26f);
        }

        @Override // com.mobvoi.wear.util.LengthUnit
        public float toNauticals(float f10) {
            return f10;
        }
    };
    
    static final float C0 = 1.0f;
    static final float C1 = 1000.0f;
    static final float C2 = 1000000.0f;
    static final float C3 = 1.0E7f;
    static final float C4 = 1.0E8f;
    static final float C5 = 1.0E9f;
    static final float C6 = 1.0E12f;
    static final float E1 = 2.54E7f;
    static final float E2 = 3.048E8f;
    static final float E3 = 1.60934396E12f;
    static final float MAX = Float.MAX_VALUE;
    static final float N = 1.85200004E12f;

    static float x(float f10, float f11, float f12) {
        if (f10 > f12) {
            return MAX;
        }
        if (f10 < (-f12)) {
            return Float.MIN_VALUE;
        }
        return f10 * f11;
    }

    public float toCentis(float f10) {
        throw new AbstractMethodError();
    }

    public float toDecis(float f10) {
        throw new AbstractMethodError();
    }

    public float toFoots(float f10) {
        throw new AbstractMethodError();
    }

    public float toInchs(float f10) {
        throw new AbstractMethodError();
    }

    public float toKilos(float f10) {
        throw new AbstractMethodError();
    }

    public float toMeters(float f10) {
        throw new AbstractMethodError();
    }

    public float toMicros(float f10) {
        throw new AbstractMethodError();
    }

    public float toMiles(float f10) {
        throw new AbstractMethodError();
    }

    public float toMillis(float f10) {
        throw new AbstractMethodError();
    }

    public float toNanos(float f10) {
        throw new AbstractMethodError();
    }

    public float toNauticals(float f10) {
        throw new AbstractMethodError();
    }
}
