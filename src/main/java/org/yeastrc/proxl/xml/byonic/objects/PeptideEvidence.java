package org.yeastrc.proxl.xml.byonic.objects;

/**
 * Corresponds to a peptideevidence element in mzID file
 */
public class PeptideEvidence {

    public PeptideEvidence(String peptideRef, String dbSequenceRef, int start, int end, String pre, String post, boolean isDecoy) {
        this.peptideRef = peptideRef;
        this.dbSequenceRef = dbSequenceRef;
        this.start = start;
        this.end = end;
        this.pre = pre;
        this.post = post;
        this.isDecoy = isDecoy;
    }

    public String getPeptideRef() {
        return peptideRef;
    }

    public String getDbSequenceRef() {
        return dbSequenceRef;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public String getPre() {
        return pre;
    }

    public String getPost() {
        return post;
    }

    public boolean isDecoy() {
        return isDecoy;
    }

    private String peptideRef;
    private String dbSequenceRef;
    private int start;
    private int end;
    private String pre;
    private String post;
    private boolean isDecoy;
}
