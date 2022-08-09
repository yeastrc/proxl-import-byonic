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

import org.yeastrc.proxl.xml.byonic.annotations.PSMAnnotationTypes;
import org.yeastrc.proxl.xml.byonic.annotations.PSMDefaultVisibleAnnotationTypes;
import org.yeastrc.proxl.xml.byonic.constants.SearchConstants;
import org.yeastrc.proxl.xml.byonic.linkers.ByonicLinker;
import org.yeastrc.proxl.xml.byonic.linkers.ByonicLinkerEnd;
import org.yeastrc.proxl.xml.byonic.objects.ByonicPSM;
import org.yeastrc.proxl.xml.byonic.objects.ByonicPeptide;
import org.yeastrc.proxl.xml.byonic.objects.ByonicReportedPeptide;
import org.yeastrc.proxl.xml.byonic.objects.ByonicResults;
import org.yeastrc.proxl.xml.byonic.utils.ModUtils;
import org.yeastrc.proxl_import.api.xml_dto.*;
import org.yeastrc.proxl_import.api.xml_dto.SearchProgram.PsmAnnotationTypes;
import org.yeastrc.proxl_import.create_import_file_from_java_objects.main.CreateImportFileFromJavaObjectsMain;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class XMLBuilder {

	/**
	 * Build and save the proxl XML file
	 * 
	 * @param results
	 * @param outfile
	 * @throws Exception
	 */
	public void buildAndSaveXML(
								 ByonicResults results,
			                     File outfile
			                    ) throws Exception {

		
		// root node of the XML
		ProxlInput proxlInputRoot = new ProxlInput();

		proxlInputRoot.setFastaFilename( results.getFastaFile() );
		
		SearchProgramInfo searchProgramInfo = new SearchProgramInfo();
		proxlInputRoot.setSearchProgramInfo( searchProgramInfo );
		
		//
		// Define the sort order
		//
		AnnotationSortOrder annotationSortOrder = new AnnotationSortOrder();
		searchProgramInfo.setAnnotationSortOrder( annotationSortOrder );
		
		PsmAnnotationSortOrder psmAnnotationSortOrder = new PsmAnnotationSortOrder();
		annotationSortOrder.setPsmAnnotationSortOrder( psmAnnotationSortOrder );
		
		psmAnnotationSortOrder.getSearchAnnotation().addAll( org.yeastrc.proxl.xml.byonic.annotations.PSMAnnotationTypeSortOrder.getPSMAnnotationTypeSortOrder() );
		
		
		SearchPrograms searchPrograms = new SearchPrograms();
		searchProgramInfo.setSearchPrograms( searchPrograms );
		
		SearchProgram searchProgram = new SearchProgram();
		searchPrograms.getSearchProgram().add( searchProgram );
		
		// add metamorpheus
		searchProgram.setName( SearchConstants.SEARCH_PROGRAM_NAME );
		searchProgram.setDisplayName( SearchConstants.SEARCH_PROGRAM_NAME );
		searchProgram.setVersion( results.getByonicVersion() );

		{
			PsmAnnotationTypes psmAnnotationTypes = new PsmAnnotationTypes();
			searchProgram.setPsmAnnotationTypes( psmAnnotationTypes );
			
			FilterablePsmAnnotationTypes filterablePsmAnnotationTypes = new FilterablePsmAnnotationTypes();
			psmAnnotationTypes.setFilterablePsmAnnotationTypes( filterablePsmAnnotationTypes );
			filterablePsmAnnotationTypes.getFilterablePsmAnnotationType().addAll( PSMAnnotationTypes.getFilterablePsmAnnotationTypes( SearchConstants.SEARCH_PROGRAM_NAME ) );
			
		}
		
		//
		// Define which annotation types are visible by default
		//
		DefaultVisibleAnnotations xmlDefaultVisibleAnnotations = new DefaultVisibleAnnotations();
		searchProgramInfo.setDefaultVisibleAnnotations( xmlDefaultVisibleAnnotations );
		
		VisiblePsmAnnotations xmlVisiblePsmAnnotations = new VisiblePsmAnnotations();
		xmlDefaultVisibleAnnotations.setVisiblePsmAnnotations( xmlVisiblePsmAnnotations );

		xmlVisiblePsmAnnotations.getSearchAnnotation().addAll( PSMDefaultVisibleAnnotationTypes.getDefaultVisibleAnnotationTypes() );
		
		//
		// Define the linker information
		//
		Linkers linkers = new Linkers();
		proxlInputRoot.setLinkers( linkers );

		for(ByonicLinker byonicLinker : results.getLinkers()) {
			Linker linker = new Linker();
			linkers.getLinker().add(linker);

			linker.setName(byonicLinker.getByonicName());

			LinkedEnds xLinkedEnds = new LinkedEnds();
			linker.setLinkedEnds(xLinkedEnds);

			for (ByonicLinkerEnd metaLinkerEnd : byonicLinker.getLinkerEnds()) {

				LinkedEnd xLinkedEnd = new LinkedEnd();
				xLinkedEnds.getLinkedEnd().add(xLinkedEnd);

				Residues xResidues = new Residues();
				xResidues.getResidue().addAll(metaLinkerEnd.getLinkableResidues());

				xLinkedEnd.setResidues(xResidues);
			}

			CrosslinkMasses masses = new CrosslinkMasses();
			linker.setCrosslinkMasses(masses);

			for (Double mass : byonicLinker.getCrosslinkMasses()) {
				CrosslinkMass xlinkMass = new CrosslinkMass();
				linker.getCrosslinkMasses().getCrosslinkMass().add(xlinkMass);

				// set the mass for this crosslinker to the calculated mass for the crosslinker, as defined in the properties file
				xlinkMass.setMass(BigDecimal.valueOf(mass));
			}

			if (byonicLinker.isCleavable()) {

				for (Double mass : byonicLinker.getCleavedCrosslinkMasses()) {
					CleavedCrosslinkMass cleavedXlinkMass = new CleavedCrosslinkMass();
					linker.getCrosslinkMasses().getCleavedCrosslinkMass().add(cleavedXlinkMass);

					// set the mass for this crosslinker to the calculated mass for the crosslinker, as defined in the properties file
					cleavedXlinkMass.setMass(BigDecimal.valueOf(mass));
				}
			}
		}
		
		
		// parse the data from the pepXML into a java data structure suitable for writing as ProXL XML
		Map<ByonicReportedPeptide, Collection<ByonicPSM>> resultsByReportedPeptide = results.getPeptidePsmMap();
		
		// remove the static mods and capture those here.

		// TODO: find example data with static mods
//		System.err.print( "\tFinding static mods..." );
//		Map<String, BigDecimal> staticMods = StaticModProcessor.createInstance().processStaticModsFromResults( resultsByReportedPeptide );
//		System.err.println( "Done." );
		
//		if( staticMods.keySet().size() < 1 ) {
//			System.err.println( "\t\tFound no static mods." );
//		} else {
//			System.err.println( "\t\tFound: " );
//			for( String residue : staticMods.keySet() ) {
//				System.err.println( "\t\t\t" + residue + " : " + staticMods.get( residue ) );
//			}
//		}
		
		
//		//
//		// Define the static mods
//		//
//		if( staticMods.keySet().size() > 1 ) {
//			StaticModifications smods = new StaticModifications();
//			proxlInputRoot.setStaticModifications( smods );
//
//			for( String moddedResidue : staticMods.keySet() ) {
//
//					StaticModification xmlSmod = new StaticModification();
//					xmlSmod.setAminoAcid( moddedResidue );
//					xmlSmod.setMassChange( staticMods.get( moddedResidue ) );
//
//					smods.getStaticModification().add( xmlSmod );
//			}
//		}

		// always set static mods to be empty for now
		Map<String,BigDecimal> staticMods = new HashMap<>();
		
		//
		// Define the peptide and PSM data
		//
		ReportedPeptides reportedPeptides = new ReportedPeptides();
		proxlInputRoot.setReportedPeptides( reportedPeptides );
		
		
		// create a unique set of peptides found, to ensure each one is found in at least 
		// one of the reported proteins
		Collection<String> peptides = new HashSet<>();
		
		// iterate over each distinct reported peptide
		for( ByonicReportedPeptide rp : resultsByReportedPeptide.keySet() ) {
			
			peptides.add( rp.getPeptide1().getSequence() );
			if( rp.getPeptide2() != null ) peptides.add( rp.getPeptide2().getSequence() );
			
			ReportedPeptide xmlReportedPeptide = new ReportedPeptide();
			reportedPeptides.getReportedPeptide().add( xmlReportedPeptide );
			
			xmlReportedPeptide.setReportedPeptideString( rp.toString() );
			
			if( rp.getType() == SearchConstants.LINK_TYPE_CROSSLINK )
				xmlReportedPeptide.setType( LinkType.CROSSLINK );
			else if( rp.getType() == SearchConstants.LINK_TYPE_LOOPLINK )
				xmlReportedPeptide.setType( LinkType.LOOPLINK );
			else
				xmlReportedPeptide.setType( LinkType.UNLINKED );
			
			Peptides xmlPeptides = new Peptides();
			xmlReportedPeptide.setPeptides( xmlPeptides );
			
			// add in the 1st parsed peptide
			{
				
				ByonicPeptide byonicPeptide = rp.getPeptide1();
				
				Peptide xmlPeptide = new Peptide();
				xmlPeptides.getPeptide().add( xmlPeptide );
				
				xmlPeptide.setSequence( byonicPeptide.getSequence() );
				
				// add in the mods for this peptide
				if( ModUtils.peptideHasNonStaticMods( byonicPeptide, staticMods) ) {
					
					Modifications xmlModifications = new Modifications();
					xmlPeptide.setModifications( xmlModifications );
					
					for( int position : rp.getPeptide1().getModifications().keySet() ) {
						for( BigDecimal modMass : rp.getPeptide1().getModifications().get( position ) ) {
	
							if( !ModUtils.isStaticMod( ModUtils.getResidueAtPosition( byonicPeptide, position), modMass, staticMods ) ) {
								
								Modification xmlModification = new Modification();
								xmlModifications.getModification().add( xmlModification );

								xmlModification.setMass( modMass );
								xmlModification.setIsMonolink( ModUtils.isDeadEndMod( modMass.doubleValue(), results.getLinkers() ) );

								if(position == 0) {
									xmlModification.setIsNTerminal(true);
								} else if(position == rp.getPeptide1().getSequence().length() + 1) {
									xmlModification.setIsCTerminal(true);
								} else {
									xmlModification.setPosition( new BigInteger( String.valueOf( position ) ) );
								}

							}
						}
					}
				}
				
				// add in the linked position(s) in this peptide
				if( rp.getType() == SearchConstants.LINK_TYPE_CROSSLINK || rp.getType() == SearchConstants.LINK_TYPE_LOOPLINK ) {
					
					LinkedPositions xmlLinkedPositions = new LinkedPositions();
					xmlPeptide.setLinkedPositions( xmlLinkedPositions );
					
					LinkedPosition xmlLinkedPosition = new LinkedPosition();
					xmlLinkedPositions.getLinkedPosition().add( xmlLinkedPosition );
					xmlLinkedPosition.setPosition( new BigInteger( String.valueOf( rp.getPosition1() ) ) );
					
					if( rp.getType() == SearchConstants.LINK_TYPE_LOOPLINK ) {
						
						xmlLinkedPosition = new LinkedPosition();
						xmlLinkedPositions.getLinkedPosition().add( xmlLinkedPosition );
						xmlLinkedPosition.setPosition( new BigInteger( String.valueOf( rp.getPosition2() ) ) );
						
					}
				}
				
			}
			
			
			// add in the 2nd parsed peptide, if it exists
			if( rp.getPeptide2() != null ) {
				
				ByonicPeptide metaMorphPeptide = rp.getPeptide2();
				
				Peptide xmlPeptide = new Peptide();
				xmlPeptides.getPeptide().add( xmlPeptide );
				
				xmlPeptide.setSequence( metaMorphPeptide.getSequence() );
				
				// add in the mods for this peptide
				if( ModUtils.peptideHasNonStaticMods( metaMorphPeptide, staticMods) ) {
					
					Modifications xmlModifications = new Modifications();
					xmlPeptide.setModifications( xmlModifications );
					
					for( int position : metaMorphPeptide.getModifications().keySet() ) {
						for( BigDecimal modMass : metaMorphPeptide.getModifications().get( position ) ) {
							
							if( !ModUtils.isStaticMod( ModUtils.getResidueAtPosition( metaMorphPeptide, position), modMass, staticMods ) ) {

								Modification xmlModification = new Modification();
								xmlModifications.getModification().add( xmlModification );
								
								xmlModification.setMass( modMass );
								xmlModification.setIsMonolink( ModUtils.isDeadEndMod( modMass.doubleValue(), results.getLinkers() ) );

								if(position == 0) {
									xmlModification.setIsNTerminal(true);
								} else if(position == rp.getPeptide2().getSequence().length() + 1) {
									xmlModification.setIsCTerminal(true);
								} else {
									xmlModification.setPosition( new BigInteger( String.valueOf( position ) ) );
								}

							}
						}
					}
				}
				
				// add in the linked position in this peptide
				if( rp.getType() == SearchConstants.LINK_TYPE_CROSSLINK ) {
					
					LinkedPositions xmlLinkedPositions = new LinkedPositions();
					xmlPeptide.setLinkedPositions( xmlLinkedPositions );
					
					LinkedPosition xmlLinkedPosition = new LinkedPosition();
					xmlLinkedPositions.getLinkedPosition().add( xmlLinkedPosition );
					xmlLinkedPosition.setPosition( new BigInteger( String.valueOf( rp.getPosition2() ) ) );
				}
			}
			
			
			// add in the PSMs and annotations
			Psms xmlPsms = new Psms();
			xmlReportedPeptide.setPsms( xmlPsms );
			
			// iterate over all PSMs for this reported peptide
			for( ByonicPSM byonicPsm : resultsByReportedPeptide.get( rp ) ) {
				Psm xmlPsm = new Psm();
				xmlPsms.getPsm().add( xmlPsm );
				
				xmlPsm.setScanNumber( new BigInteger( String.valueOf( byonicPsm.getScanNumber() ) ) );
				xmlPsm.setPrecursorCharge( new BigInteger( String.valueOf( byonicPsm.getCharge() ) ) );
				xmlPsm.setScanFileName(byonicPsm.getScanFilename());

				if( rp.getType() == SearchConstants.LINK_TYPE_CROSSLINK || rp.getType() == SearchConstants.LINK_TYPE_LOOPLINK )
					xmlPsm.setLinkerMass( byonicPsm.getLinkerMass() );
				
				// add in the filterable PSM annotations (e.g., score)
				FilterablePsmAnnotations xmlFilterablePsmAnnotations = new FilterablePsmAnnotations();
				xmlPsm.setFilterablePsmAnnotations( xmlFilterablePsmAnnotations );

				// handle scores
				{
					FilterablePsmAnnotation xmlFilterablePsmAnnotation = new FilterablePsmAnnotation();
					xmlFilterablePsmAnnotations.getFilterablePsmAnnotation().add( xmlFilterablePsmAnnotation );
					
					xmlFilterablePsmAnnotation.setAnnotationName( PSMAnnotationTypes.BYONIC_ANNOTATION_TYPE_SCORE );
					xmlFilterablePsmAnnotation.setSearchProgram( SearchConstants.SEARCH_PROGRAM_NAME );
					xmlFilterablePsmAnnotation.setValue( byonicPsm.getScore());
				}

				{
					FilterablePsmAnnotation xmlFilterablePsmAnnotation = new FilterablePsmAnnotation();
					xmlFilterablePsmAnnotations.getFilterablePsmAnnotation().add( xmlFilterablePsmAnnotation );

					xmlFilterablePsmAnnotation.setAnnotationName( PSMAnnotationTypes.BYONIC_ANNOTATION_TYPE_DELTA_SCORE );
					xmlFilterablePsmAnnotation.setSearchProgram( SearchConstants.SEARCH_PROGRAM_NAME );
					xmlFilterablePsmAnnotation.setValue( byonicPsm.getDeltaScore());
				}

				{
					FilterablePsmAnnotation xmlFilterablePsmAnnotation = new FilterablePsmAnnotation();
					xmlFilterablePsmAnnotations.getFilterablePsmAnnotation().add( xmlFilterablePsmAnnotation );

					xmlFilterablePsmAnnotation.setAnnotationName( PSMAnnotationTypes.BYONIC_ANNOTATION_TYPE_DELTAMOD_SCORE );
					xmlFilterablePsmAnnotation.setSearchProgram( SearchConstants.SEARCH_PROGRAM_NAME );
					xmlFilterablePsmAnnotation.setValue( byonicPsm.getDeltaModScore());
				}

				{
					FilterablePsmAnnotation xmlFilterablePsmAnnotation = new FilterablePsmAnnotation();
					xmlFilterablePsmAnnotations.getFilterablePsmAnnotation().add( xmlFilterablePsmAnnotation );

					xmlFilterablePsmAnnotation.setAnnotationName( PSMAnnotationTypes.BYONIC_ANNOTATION_TYPE_ABSLOGPROB2D );
					xmlFilterablePsmAnnotation.setSearchProgram( SearchConstants.SEARCH_PROGRAM_NAME );
					xmlFilterablePsmAnnotation.setValue( byonicPsm.getAbsLogProb2D());
				}

			}//end iterating over all PSMs for a reported peptide
			
			
		}// end iterating over distinct reported peptides


		// add in the matched proteins section
		MatchedProteinsBuilder.getInstance().buildMatchedProteins(
				                                                   proxlInputRoot,
				                                                   results.getProteins()
				                                                  );		
		
		
		// add in the config file(s)
//		ConfigurationFiles xmlConfigurationFiles = new ConfigurationFiles();
//		proxlInputRoot.setConfigurationFiles( xmlConfigurationFiles );
//
//		ConfigurationFile xmlConfigurationFile = new ConfigurationFile();
//		xmlConfigurationFiles.getConfigurationFile().add( xmlConfigurationFile );
//
//		xmlConfigurationFile.setSearchProgram( SearchConstants.SEARCH_PROGRAM_NAME_METAMORPH );
//		xmlConfigurationFile.setFileName( ( new File( analysis.getConfFilePath() ) ).getName() );
//		xmlConfigurationFile.setFileContent( Files.readAllBytes( FileSystems.getDefault().getPath( analysis.getConfFilePath() ) ) );

		//make the xml file
		CreateImportFileFromJavaObjectsMain.getInstance().createImportFileFromJavaObjectsMain(outfile, proxlInputRoot);
		
	}
	

	
	
}
