package org.yeastrc.proxl.xml.byonic.objects;

import org.yeastrc.proxl.xml.byonic.linkers.ByonicLinker;

public class ByonicLinkedPosition {
    public ByonicLinkedPosition(int position, ByonicLinker linker) {
        this.position = position;
        this.linker = linker;
    }

    public int getPosition() {
        return position;
    }

    public ByonicLinker getLinker() {
        return linker;
    }

    private int position;
    private ByonicLinker linker;
}
