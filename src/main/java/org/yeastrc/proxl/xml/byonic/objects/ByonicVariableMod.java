package org.yeastrc.proxl.xml.byonic.objects;

import java.math.BigDecimal;
import java.util.Objects;

public class ByonicVariableMod {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ByonicVariableMod that = (ByonicVariableMod) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public ByonicVariableMod(String name, BigDecimal deltaMass) {
        this.name = name;
        this.deltaMass = deltaMass;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getDeltaMass() {
        return deltaMass;
    }

    private String name;
    private BigDecimal deltaMass;
}
