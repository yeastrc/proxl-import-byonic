package org.yeastrc.proxl.xml.byonic.linkers;

import java.util.Collection;
import java.util.Objects;

public class ByonicLinkerEnd {

    @Override
    public String toString() {
        return "MetaMorphLinkerEnd{" +
                "linkableResidues=" + linkableResidues +
                ", linksNTerminus=" + linksNTerminus +
                ", linksCTerminus=" + linksCTerminus +
                '}';
    }

    public ByonicLinkerEnd(Collection<String> linkableResidues, boolean linksNTerminus, boolean linksCTerminus) {
        this.linkableResidues = linkableResidues;
        this.linksNTerminus = linksNTerminus;
        this.linksCTerminus = linksCTerminus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ByonicLinkerEnd that = (ByonicLinkerEnd) o;
        return linksNTerminus == that.linksNTerminus &&
                linksCTerminus == that.linksCTerminus &&
                linkableResidues.equals(that.linkableResidues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(linkableResidues, linksNTerminus, linksCTerminus);
    }

    public Collection<String> getLinkableResidues() {
        return linkableResidues;
    }

    public boolean isLinksNTerminus() {
        return linksNTerminus;
    }

    public boolean isLinksCTerminus() {
        return linksCTerminus;
    }

    private Collection<String> linkableResidues;
    private boolean linksNTerminus;
    private boolean linksCTerminus;
}
