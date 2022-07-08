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


package org.yeastrc.proxl.xml.byonic.builder;


import org.yeastrc.proxl.xml.byonic.objects.ByonicProtein;
import org.yeastrc.proxl_import.api.xml_dto.MatchedProteins;
import org.yeastrc.proxl_import.api.xml_dto.Protein;
import org.yeastrc.proxl_import.api.xml_dto.ProteinAnnotation;
import org.yeastrc.proxl_import.api.xml_dto.ProxlInput;

import java.util.Collection;

/**
 * Build the MatchedProteins section of the emozi XML docs. This is done by finding all proteins in the FASTA
 * file that contains any of the peptide sequences found in the experiment. 
 * 
 * This is generalized enough to be usable by any pipeline
 * 
 * @author mriffle
 *
 */
public class MatchedProteinsBuilder {

	public static MatchedProteinsBuilder getInstance() { return new MatchedProteinsBuilder(); }

	public void buildMatchedProteins(ProxlInput proxlInputRoot, Collection<ByonicProtein> proteins) throws Exception {

		System.err.print( " Matching peptides to proteins..." );

		MatchedProteins xmlMatchedProteins = new MatchedProteins();
		proxlInputRoot.setMatchedProteins( xmlMatchedProteins );

		for( ByonicProtein protein :  proteins) {

			Protein xmlProtein = new Protein();
			xmlMatchedProteins.getProtein().add( xmlProtein );

			xmlProtein.setSequence( protein.getSequence() );

			ProteinAnnotation xmlProteinAnnotation = new ProteinAnnotation();
			xmlProteinAnnotation.setName(protein.getAccession());
			xmlProtein.getProteinAnnotation().add(xmlProteinAnnotation);

		}
	}
	
}
