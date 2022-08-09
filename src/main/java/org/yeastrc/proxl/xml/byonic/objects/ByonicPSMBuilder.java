package org.yeastrc.proxl.xml.byonic.objects;

import java.math.BigDecimal;

public class ByonicPSMBuilder {
    private BigDecimal score;
    private BigDecimal deltaScore;
    private BigDecimal deltaModScore;
    private BigDecimal absLogProb2D;
    private BigDecimal linkerMass;
    private Integer scanNumber;
    private BigDecimal obsMz;
    private int charge;
    private String scanFilename;

    public ByonicPSMBuilder setScore(BigDecimal score) {
        this.score = score;
        return this;
    }

    public ByonicPSMBuilder setDeltaScore(BigDecimal deltaScore) {
        this.deltaScore = deltaScore;
        return this;
    }

    public ByonicPSMBuilder setDeltaModScore(BigDecimal deltaModScore) {
        this.deltaModScore = deltaModScore;
        return this;
    }

    public ByonicPSMBuilder setAbsLogProb2D(BigDecimal absLogProb2D) {
        this.absLogProb2D = absLogProb2D;
        return this;
    }

    public ByonicPSMBuilder setLinkerMass(BigDecimal linkerMass) {
        this.linkerMass = linkerMass;
        return this;
    }

    public ByonicPSMBuilder setScanNumber(Integer scanNumber) {
        this.scanNumber = scanNumber;
        return this;
    }

    public ByonicPSMBuilder setObsMz(BigDecimal obsMz) {
        this.obsMz = obsMz;
        return this;
    }

    public ByonicPSMBuilder setCharge(int charge) {
        this.charge = charge;
        return this;
    }

    public ByonicPSMBuilder setScanFilename(String scanFilename) {
        this.scanFilename = scanFilename;
        return this;
    }

    public ByonicPSM createByonicPSM() {
        return new ByonicPSM(score, deltaScore, deltaModScore, absLogProb2D, linkerMass, scanNumber, obsMz, charge, scanFilename);
    }
}