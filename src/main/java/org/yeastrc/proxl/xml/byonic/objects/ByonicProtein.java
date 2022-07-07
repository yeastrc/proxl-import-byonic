package org.yeastrc.proxl.xml.byonic.objects;

public class ByonicProtein {

    public ByonicProtein(String sequence, String id, String accession, String searchDatabaseRef) {
        this.sequence = sequence;
        this.id = id;
        this.accession = accession;
        this.searchDatabaseRef = searchDatabaseRef;
    }

    public String getSequence() {
        return sequence;
    }

    public String getId() {
        return id;
    }

    public String getAccession() {
        return accession;
    }

    public String getSearchDatabaseRef() {
        return searchDatabaseRef;
    }

    private String sequence;
    private String id;
    private String accession;
    private String searchDatabaseRef;

}
