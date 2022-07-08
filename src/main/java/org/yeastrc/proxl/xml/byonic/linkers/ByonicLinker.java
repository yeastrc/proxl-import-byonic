/*
 * Original author: Michael Riffle <mriffle .at. uw.edu>
 *                  
 * Copyright 2018 University of Washington - Seattle, WA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.yeastrc.proxl.xml.byonic.linkers;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class ByonicLinker {

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ByonicLinker that = (ByonicLinker) o;
		return byonicName.equals(that.byonicName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(byonicName);
	}

	/**
	 * @return the crosslinkMasses
	 */
	public Collection<Double> getCrosslinkMasses() {
		return crosslinkMasses;
	}
	/**
	 * @param crosslinkMasses the crosslinkMasses to set
	 */
	public void setCrosslinkMasses(Collection<Double> crosslinkMasses) {
		this.crosslinkMasses = crosslinkMasses;
	}
	/**
	 * @return the monolinkMasses
	 */
	public Collection<Double> getMonolinkMasses() {
		return monolinkMasses;
	}
	/**
	 * @param monolinkMasses the monolinkMasses to set
	 */
	public void setMonolinkMasses(Collection<Double> monolinkMasses) {
		this.monolinkMasses = monolinkMasses;
	}
	/**
	 * @return the metaMorphName
	 */
	public String getByonicName() {
		return byonicName;
	}
	/**
	 * @param byonicName the metaMorphName to set
	 */
	public void setByonicName(String byonicName) {
		this.byonicName = byonicName;
	}
	/**
	 * @return the proxlName
	 */
	public String getProxlName() {
		return proxlName;
	}
	/**
	 * @param proxlName the proxlName to set
	 */
	public void setProxlName(String proxlName) {
		this.proxlName = proxlName;
	}

	public Collection<Double> getCleavedCrosslinkMasses() {
		return cleavedCrosslinkMasses;
	}

	public void setCleavedCrosslinkMasses(Collection<Double> cleavedCrosslinkMasses) {
		this.cleavedCrosslinkMasses = cleavedCrosslinkMasses;
	}

	public boolean isCleavable() {
		return isCleavable;
	}

	public void setCleavable(boolean cleavable) {
		isCleavable = cleavable;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	@Override
	public String toString() {
		return "ByonicLinker{" +
				"crosslinkMasses=" + crosslinkMasses +
				", cleavedCrosslinkMasses=" + cleavedCrosslinkMasses +
				", monolinkMasses=" + monolinkMasses +
				", byonicName='" + byonicName + '\'' +
				", proxlName='" + proxlName + '\'' +
				", isCleavable=" + isCleavable +
				", linkerEnds=" + linkerEnds +
				", formula='" + formula + '\'' +
				'}';
	}

	public List<ByonicLinkerEnd> getLinkerEnds() {
		return linkerEnds;
	}

	public void setLinkerEnds(List<ByonicLinkerEnd> linkerEnds) {
		this.linkerEnds = linkerEnds;
	}

	private Collection<Double> crosslinkMasses = new HashSet<>();
	private Collection<Double> cleavedCrosslinkMasses = new HashSet<>();
	private Collection<Double> monolinkMasses = new HashSet<>();
	private String byonicName;
	private String proxlName;
	private boolean isCleavable;
	private List<ByonicLinkerEnd> linkerEnds;
	private String formula;
	
}
