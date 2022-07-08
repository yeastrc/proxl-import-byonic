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

package org.yeastrc.proxl.xml.byonic.annotations;

import org.yeastrc.proxl_import.api.xml_dto.FilterDirectionType;
import org.yeastrc.proxl_import.api.xml_dto.FilterablePsmAnnotationType;

import java.util.ArrayList;
import java.util.List;

public class PSMAnnotationTypes {

	// byonic scores
	public static final String BYONIC_ANNOTATION_TYPE_SCORE = "Byonic score";
	public static final String BYONIC_ANNOTATION_TYPE_DELTA_SCORE = "Delta Score";
	public static final String BYONIC_ANNOTATION_TYPE_DELTAMOD_SCORE = "DeltaMod Score";
	public static final String BYONIC_ANNOTATION_TYPE_ABSLOGPROB2D = "Peptide AbsLogProb2D";

	/**
	 * Get the list of filterable PSM annotation types in Byonic data
	 * @return
	 */
	public static List<FilterablePsmAnnotationType> getFilterablePsmAnnotationTypes( String programName ) {
		List<FilterablePsmAnnotationType> types = new ArrayList<FilterablePsmAnnotationType>();

		{
			FilterablePsmAnnotationType type = new FilterablePsmAnnotationType();
			type.setName( BYONIC_ANNOTATION_TYPE_SCORE );
			type.setDescription( "Byonic score, the primary indicator of PSM correctness" );
			type.setFilterDirection( FilterDirectionType.ABOVE );
			type.setDefaultFilter( false );

			types.add( type );
		}

		{
			FilterablePsmAnnotationType type = new FilterablePsmAnnotationType();
			type.setName( BYONIC_ANNOTATION_TYPE_DELTA_SCORE );
			type.setDescription( "The drop in Byonic score from the top-scoring peptide to the next distinct peptide." );
			type.setFilterDirection( FilterDirectionType.ABOVE );
			type.setDefaultFilter( false );

			types.add( type );
		}

		{
			FilterablePsmAnnotationType type = new FilterablePsmAnnotationType();
			type.setName( BYONIC_ANNOTATION_TYPE_DELTAMOD_SCORE );
			type.setDescription( "The drop in Byonic score from the top-scoring peptide to the next peptide different in any way, including placement of modifications." );
			type.setFilterDirection( FilterDirectionType.ABOVE );
			type.setDefaultFilter( false );

			types.add( type );
		}

		{
			FilterablePsmAnnotationType type = new FilterablePsmAnnotationType();
			type.setName( BYONIC_ANNOTATION_TYPE_ABSLOGPROB2D );
			type.setDescription( "The log p-value of the PSM. This is the log of the probability that the PSM with such a score and delta would arise by chance in a search of this size (size of the protein database, as expanded by the modification rules)." );
			type.setFilterDirection( FilterDirectionType.ABOVE );
			type.setDefaultFilter( false );

			types.add( type );
		}

		return types;
	}
	
}
