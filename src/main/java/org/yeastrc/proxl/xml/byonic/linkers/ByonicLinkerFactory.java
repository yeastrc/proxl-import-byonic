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

import java.util.*;

public class ByonicLinkerFactory {

	private static Map<String, ByonicLinker> _LINKER_MAP;
	
	static {
		
		_LINKER_MAP = new HashMap<>();

		{
			ByonicLinker linker = new ByonicLinker();

			linker.setByonicName( "Disulfide" );
			linker.setProxlName( "Disulfide" );
			linker.setCleavable( false );

			linker.getCrosslinkMasses().add( -2.015650 );
			linker.setFormula("-2H");

			List<ByonicLinkerEnd> linkerEnds = new ArrayList<>(2);
			Collection<String> linkableResidues = new HashSet<>();
			linkableResidues.add( "C" );

			linkerEnds.add( new ByonicLinkerEnd( linkableResidues, false, false ) );
			linkerEnds.add( new ByonicLinkerEnd( linkableResidues, false, false ) );
			linker.setLinkerEnds( linkerEnds );

			_LINKER_MAP.put( "Disulfide", linker );
		}

		{
			ByonicLinker linker = new ByonicLinker();

			linker.setByonicName( "Disulfide x 2" );
			linker.setProxlName( "Disulfide x 2" );
			linker.setCleavable( false );

			linker.getCrosslinkMasses().add( -4.031300 );
			linker.setFormula("-4H");

			List<ByonicLinkerEnd> linkerEnds = new ArrayList<>(2);
			Collection<String> linkableResidues = new HashSet<>();
			linkableResidues.add( "C" );

			linkerEnds.add( new ByonicLinkerEnd( linkableResidues, false, false ) );
			linkerEnds.add( new ByonicLinkerEnd( linkableResidues, false, false ) );
			linker.setLinkerEnds( linkerEnds );

			_LINKER_MAP.put( "Disulfide x 2", linker );
		}

		{
			ByonicLinker linker = new ByonicLinker();

			linker.setByonicName( "Trisulfide" );
			linker.setProxlName( "Trisulfide" );
			linker.setCleavable( false );

			linker.getCrosslinkMasses().add( 29.956421 );
			linker.setFormula("(-4H)S");

			List<ByonicLinkerEnd> linkerEnds = new ArrayList<>(2);
			Collection<String> linkableResidues = new HashSet<>();
			linkableResidues.add( "C" );

			linkerEnds.add( new ByonicLinkerEnd( linkableResidues, false, false ) );
			linkerEnds.add( new ByonicLinkerEnd( linkableResidues, false, false ) );
			linker.setLinkerEnds( linkerEnds );

			_LINKER_MAP.put( "Trisulfide", linker );
		}
		
	}
	
	public static ByonicLinker getLinker(String name ) {
		return _LINKER_MAP.get( name );		
	}
	
}
