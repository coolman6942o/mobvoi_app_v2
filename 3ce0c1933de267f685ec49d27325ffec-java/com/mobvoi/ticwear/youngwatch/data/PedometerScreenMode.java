package com.mobvoi.ticwear.youngwatch.data;
/* loaded from: classes2.dex */
public enum PedometerScreenMode {
    HORIZONTAL(0),
    VERTICAL(1);
    
    private int command;

    PedometerScreenMode(int i10) {
        this.command = i10;
    }

    public int getCommand() {
        return this.command;
    }
}
