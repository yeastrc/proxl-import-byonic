package org.yeastrc.proxl.xml.byonic.objects;

import org.yeastrc.proxl.xml.byonic.linkers.ByonicLinker;

import java.math.BigDecimal;

public class ByonicPSMBuilder {
    private BigDecimal score;
    private BigDecimal deltaScore;
    private BigDecimal deltaModScore;
    private BigDecimal absLogProb2D;
    private ByonicLinker linker;
    private Integer scanNumber;
    private BigDecimal obsMz;
    private int charge;

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

    public ByonicPSMBuilder setLinker(ByonicLinker linker) {
        this.linker = linker;
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

    public ByonicPSM createByonicPSM() {
        return new ByonicPSM(score, deltaScore, deltaModScore, absLogProb2D, linker, scanNumber, obsMz, charge);
    }
}