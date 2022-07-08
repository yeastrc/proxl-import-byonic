package org.yeastrc.proxl.xml.byonic.objects;

public class ByonicVariableModPosition {
    public ByonicVariableModPosition(int position, ByonicVariableMod variableMod) {
        this.position = position;
        this.variableMod = variableMod;
    }

    public int getPosition() {
        return position;
    }

    public ByonicVariableMod getVariableMod() {
        return variableMod;
    }

    private int position;
    private ByonicVariableMod variableMod;
}
