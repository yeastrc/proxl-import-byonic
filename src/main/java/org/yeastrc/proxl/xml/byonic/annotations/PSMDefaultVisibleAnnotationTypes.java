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

import org.yeastrc.proxl.xml.byonic.constants.SearchConstants;
import org.yeastrc.proxl_import.api.xml_dto.SearchAnnotation;

import java.util.ArrayList;
import java.util.List;

public class PSMDefaultVisibleAnnotationTypes {

	/**
	 * Get the default visibile annotation types for byonic data
	 * @return
	 */
	public static List<SearchAnnotation> getDefaultVisibleAnnotationTypes() {
		List<SearchAnnotation> annotations = new ArrayList<SearchAnnotation>();
		
		
		{
			SearchAnnotation annotation = new SearchAnnotation();
			annotation.setAnnotationName( PSMAnnotationTypes.BYONIC_ANNOTATION_TYPE_SCORE);
			annotation.setSearchProgram( SearchConstants.SEARCH_PROGRAM_NAME );
			annotations.add( annotation );
		}

		{
			SearchAnnotation annotation = new SearchAnnotation();
			annotation.setAnnotationName( PSMAnnotationTypes.BYONIC_ANNOTATION_TYPE_DELTA_SCORE);
			annotation.setSearchProgram( SearchConstants.SEARCH_PROGRAM_NAME );
			annotations.add( annotation );
		}

		{
			SearchAnnotation annotation = new SearchAnnotation();
			annotation.setAnnotationName( PSMAnnotationTypes.BYONIC_ANNOTATION_TYPE_DELTAMOD_SCORE);
			annotation.setSearchProgram( SearchConstants.SEARCH_PROGRAM_NAME );
			annotations.add( annotation );
		}

		{
			SearchAnnotation annotation = new SearchAnnotation();
			annotation.setAnnotationName( PSMAnnotationTypes.BYONIC_ANNOTATION_TYPE_ABSLOGPROB2D);
			annotation.setSearchProgram( SearchConstants.SEARCH_PROGRAM_NAME );
			annotations.add( annotation );
		}


		return annotations;
	}
	
}
