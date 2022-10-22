package com.google.thirdparty.publicsuffix;
/* loaded from: classes.dex */
public enum PublicSuffixType {
    PRIVATE(':', ','),
    REGISTRY('!', '?');
    
    private final char innerNodeCode;
    private final char leafNodeCode;

    PublicSuffixType(char c10, char c11) {
        this.innerNodeCode = c10;
        this.leafNodeCode = c11;
    }
}
