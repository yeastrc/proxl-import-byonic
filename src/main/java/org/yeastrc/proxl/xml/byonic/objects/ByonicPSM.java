package org.yeastrc.proxl.xml.byonic.objects;

import org.yeastrc.proxl.xml.byonic.linkers.ByonicLinker;

import java.math.BigDecimal;

public class ByonicPSM {


    public ByonicPSM(BigDecimal score, BigDecimal deltaScore, BigDecimal deltaModScore, BigDecimal absLogProb2D, BigDecimal linkerMass, Integer scanNumber, BigDecimal obsMz, int charge) {
        this.score = score;
        this.deltaScore = deltaScore;
        this.deltaModScore = deltaModScore;
        this.absLogProb2D = absLogProb2D;
        this.linkerMass = linkerMass;
        this.scanNumber = scanNumber;
        this.obsMz = obsMz;
        this.charge = charge;
    }

    public BigDecimal getLinkerMass() {
        return linkerMass;
    }

    public BigDecimal getScore() {
        return score;
    }

    public BigDecimal getDeltaScore() {
        return deltaScore;
    }

    public BigDecimal getDeltaModScore() {
        return deltaModScore;
    }

    public BigDecimal getAbsLogProb2D() {
        return absLogProb2D;
    }


    public Integer getScanNumber() {
        return scanNumber;
    }

    public BigDecimal getObsMz() {
        return obsMz;
    }

    public int getCharge() {
        return charge;
    }

    private BigDecimal score;
    private BigDecimal deltaScore;
    private BigDecimal deltaModScore;
    private BigDecimal absLogProb2D;
    private BigDecimal linkerMass;
    private Integer scanNumber;
    private BigDecimal obsMz;
    private int charge;

}
