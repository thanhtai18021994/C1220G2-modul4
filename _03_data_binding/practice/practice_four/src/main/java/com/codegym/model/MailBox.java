package com.codegym.model;

public class MailBox {
    private String language;
    private int pageSize;
    private boolean spamFiller;
    private String sigNature;

    public MailBox(String language, int pageSize, boolean spamFillter, String sigNature) {
        this.language = language;
        this.pageSize = pageSize;
        this.spamFiller = spamFillter;
        this.sigNature = sigNature;
    }

    public MailBox() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpamFiller() {
        return spamFiller;
    }

    public void setSpamFiller(boolean spamFiller) {
        this.spamFiller = spamFiller;
    }

    public String getSigNature() {
        return sigNature;
    }

    public void setSigNature(String sigNature) {
        this.sigNature = sigNature;
    }
}
