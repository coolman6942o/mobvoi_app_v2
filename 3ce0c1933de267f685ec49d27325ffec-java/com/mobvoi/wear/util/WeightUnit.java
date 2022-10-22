package com.mobvoi.wear.util;
/* loaded from: classes2.dex */
public enum WeightUnit {
    MILLIGRAMS { // from class: com.mobvoi.wear.util.WeightUnit.1
        @Override // com.mobvoi.wear.util.WeightUnit
        public float toGrams(float f10) {
            return f10 / WeightUnit.C1;
        }

        @Override // com.mobvoi.wear.util.WeightUnit
        public float toKilograms(float f10) {
            return f10 / WeightUnit.C2;
        }

        @Override // com.mobvoi.wear.util.WeightUnit
        public float toMilligrams(float f10) {
            return f10;
        }

        @Override // com.mobvoi.wear.util.WeightUnit
        public float toOunces(float f10) {
            return f10 / WeightUnit.E1;
        }

        @Override // com.mobvoi.wear.util.WeightUnit
        public float toPounds(float f10) {
            return f10 / WeightUnit.E2;
        }
    },
    GRAMS { // from class: com.mobvoi.wear.util.WeightUnit.2
        @Override // com.mobvoi.wear.util.WeightUnit
        public float toGrams(float f10) {
            return f10;
        }

        @Override // com.mobvoi.wear.util.WeightUnit
        public float toKilograms(float f10) {
            return f10 / WeightUnit.C1;
        }

        @Override // com.mobvoi.wear.util.WeightUnit
        public float toMilligrams(float f10) {
            return WeightUnit.x(f10, WeightUnit.C1, 3.4028234E35f);
        }

        @Override // com.mobvoi.wear.util.WeightUnit
        public float toOunces(float f10) {
            return f10 / 28.349524f;
        }

        @Override // com.mobvoi.wear.util.WeightUnit
        public float toPounds(float f10) {
            return f10 / 453.59238f;
        }
    },
    KILOGRAMS { // from class: com.mobvoi.wear.util.WeightUnit.3
        @Override // com.mobvoi.wear.util.WeightUnit
        public float toGrams(float f10) {
            return WeightUnit.x(f10, WeightUnit.C1, 3.4028234E35f);
        }

        @Override // com.mobvoi.wear.util.WeightUnit
        public float toKilograms(float f10) {
            return f10;
        }

        @Override // com.mobvoi.wear.util.WeightUnit
        public float toMilligrams(float f10) {
            return WeightUnit.x(f10, WeightUnit.C2, 3.4028233E32f);
        }

        @Override // com.mobvoi.wear.util.WeightUnit
        public float toOunces(float f10) {
            return f10 / 0.028349524f;
        }

        @Override // com.mobvoi.wear.util.WeightUnit
        public float toPounds(float f10) {
            return f10 / 0.4535924f;
        }
    },
    OUNCES { // from class: com.mobvoi.wear.util.WeightUnit.4
        @Override // com.mobvoi.wear.util.WeightUnit
        public float toGrams(float f10) {
            return WeightUnit.x(f10, 28.349524f, 1.2003106E37f);
        }

        @Override // com.mobvoi.wear.util.WeightUnit
        public float toKilograms(float f10) {
            return WeightUnit.x(f10, 0.028349524f, WeightUnit.MAX);
        }

        @Override // com.mobvoi.wear.util.WeightUnit
        public float toMilligrams(float f10) {
            return WeightUnit.x(f10, WeightUnit.E1, 1.2003106E34f);
        }

        @Override // com.mobvoi.wear.util.WeightUnit
        public float toOunces(float f10) {
            return f10;
        }

        @Override // com.mobvoi.wear.util.WeightUnit
        public float toPounds(float f10) {
            return f10 / 16.0f;
        }
    },
    POUNDS { // from class: com.mobvoi.wear.util.WeightUnit.5
        @Override // com.mobvoi.wear.util.WeightUnit
        public float toGrams(float f10) {
            return WeightUnit.x(f10, 453.59238f, 7.501941E35f);
        }

        @Override // com.mobvoi.wear.util.WeightUnit
        public float toKilograms(float f10) {
            return WeightUnit.x(f10, 0.4535924f, WeightUnit.MAX);
        }

        @Override // com.mobvoi.wear.util.WeightUnit
        public float toMilligrams(float f10) {
            return WeightUnit.x(f10, WeightUnit.E2, 7.5019414E32f);
        }

        @Override // com.mobvoi.wear.util.WeightUnit
        public float toOunces(float f10) {
            return WeightUnit.x(f10, 16.0f, 2.1267647E37f);
        }

        @Override // com.mobvoi.wear.util.WeightUnit
        public float toPounds(float f10) {
            return f10;
        }
    };
    
    static final float C0 = 1.0f;
    static final float C1 = 1000.0f;
    static final float C2 = 1000000.0f;
    static final float E1 = 28349.523f;
    static final float E2 = 453592.38f;
    static final float MAX = Float.MAX_VALUE;

    static float x(float f10, float f11, float f12) {
        if (f10 > f12) {
            return MAX;
        }
        if (f10 < (-f12)) {
            return Float.MIN_VALUE;
        }
        return f10 * f11;
    }

    public float toGrams(float f10) {
        throw new AbstractMethodError();
    }

    public float toKilograms(float f10) {
        throw new AbstractMethodError();
    }

    public float toMilligrams(float f10) {
        throw new AbstractMethodError();
    }

    public float toOunces(float f10) {
        throw new AbstractMethodError();
    }

    public float toPounds(float f10) {
        throw new AbstractMethodError();
    }
}
