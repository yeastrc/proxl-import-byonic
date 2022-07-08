package org.yeastrc.proxl.xml.byonic.objects;

import org.yeastrc.proxl.xml.byonic.linkers.ByonicLinker;

import java.util.Collection;
import java.util.Map;

public class ByonicResults {

    public Map<ByonicReportedPeptide, Collection<ByonicPSM>> getPeptidePsmMap() {
        return peptidePsmMap;
    }

    public void setPeptidePsmMap(Map<ByonicReportedPeptide, Collection<ByonicPSM>> peptidePsmMap) {
        this.peptidePsmMap = peptidePsmMap;
    }

    public Collection<ByonicLinker> getLinkers() {
        return linkers;
    }

    public void setLinkers(Collection<ByonicLinker> linkers) {
        this.linkers = linkers;
    }

    public String getByonicVersion() {
        return byonicVersion;
    }

    public void setByonicVersion(String byonicVersion) {
        this.byonicVersion = byonicVersion;
    }

    public String getFastaFile() {
        return fastaFile;
    }

    public void setFastaFile(String fastaFile) {
        this.fastaFile = fastaFile;
    }

    public Collection<ByonicProtein> getProteins() {
        return proteins;
    }

    public void setProteins(Collection<ByonicProtein> proteins) {
        this.proteins = proteins;
    }

    private Map<ByonicReportedPeptide, Collection<ByonicPSM>> peptidePsmMap;
    private Collection<ByonicLinker> linkers;
    private Collection<ByonicProtein> proteins;
    private String byonicVersion;
    private String fastaFile;

}
