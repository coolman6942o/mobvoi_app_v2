package com.bjleisen.iface.sdk.util;

import java.util.List;
/* loaded from: classes.dex */
public class CardTemplateInfo {
    private List<ApdusBean> apdus;
    private List<ParserTemplateBean> parserTemplate;

    /* loaded from: classes.dex */
    public static class ApdusBean {
        private String apdu;
        private int index;
        private String sw;

        public String getApdu() {
            return this.apdu;
        }

        public int getIndex() {
            return this.index;
        }

        public String getSw() {
            return this.sw;
        }

        public void setApdu(String str) {
            this.apdu = str;
        }

        public void setIndex(int i10) {
            this.index = i10;
        }

        public void setSw(String str) {
            this.sw = str;
        }
    }

    /* loaded from: classes.dex */
    public static class ParserTemplateBean {
        private String functionDesc;
        private String functionName;
        private ParserMethodBean parserMethod;
        private SubDatasBean subDatas;

        /* loaded from: classes.dex */
        public static class ParserMethodBean {
            private boolean isTransferDecimalSystem;
            private boolean isTransferLittleEndian;

            public boolean isTransferDecimalSystem() {
                return this.isTransferDecimalSystem;
            }

            public boolean isTransferLittleEndian() {
                return this.isTransferLittleEndian;
            }

            public void setTransferDecimalSystem(boolean z10) {
                this.isTransferDecimalSystem = z10;
            }

            public void setTransferLittleEndian(boolean z10) {
                this.isTransferLittleEndian = z10;
            }
        }

        /* loaded from: classes.dex */
        public static class SubDatasBean {
            private int apduIndex;
            private int endIndex;
            private boolean isSwRefer;
            private int startIndex;

            public int getApduIndex() {
                return this.apduIndex;
            }

            public int getEndIndex() {
                return this.endIndex;
            }

            public int getStartIndex() {
                return this.startIndex;
            }

            public boolean isSwRefer() {
                return this.isSwRefer;
            }

            public void setApduIndex(int i10) {
                this.apduIndex = i10;
            }

            public void setEndIndex(int i10) {
                this.endIndex = i10;
            }

            public void setStartIndex(int i10) {
                this.startIndex = i10;
            }

            public void setSwRefer(boolean z10) {
                this.isSwRefer = z10;
            }
        }

        public String getFunctionDesc() {
            return this.functionDesc;
        }

        public String getFunctionName() {
            return this.functionName;
        }

        public ParserMethodBean getParserMethod() {
            return this.parserMethod;
        }

        public SubDatasBean getSubDatas() {
            return this.subDatas;
        }

        public void setFunctionDesc(String str) {
            this.functionDesc = str;
        }

        public void setFunctionName(String str) {
            this.functionName = str;
        }

        public void setParserMethod(ParserMethodBean parserMethodBean) {
            this.parserMethod = parserMethodBean;
        }

        public void setSubDatas(SubDatasBean subDatasBean) {
            this.subDatas = subDatasBean;
        }
    }

    public List<ApdusBean> getApdus() {
        return this.apdus;
    }

    public List<ParserTemplateBean> getParserTemplate() {
        return this.parserTemplate;
    }

    public void setApdus(List<ApdusBean> list) {
        this.apdus = list;
    }

    public void setParserTemplate(List<ParserTemplateBean> list) {
        this.parserTemplate = list;
    }
}
