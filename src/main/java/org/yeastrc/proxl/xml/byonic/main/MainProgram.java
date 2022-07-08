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

package org.yeastrc.proxl.xml.byonic.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import org.yeastrc.proxl.xml.byonic.constants.Constants;

import picocli.CommandLine;

@CommandLine.Command(name = "java -jar " + Constants.CONVERSION_PROGRAM_NAME,
		mixinStandardHelpOptions = true,
		version = Constants.CONVERSION_PROGRAM_NAME + " " + Constants.CONVERSION_PROGRAM_VERSION,
		sortOptions = false,
		synopsisHeading = "%n",
		descriptionHeading = "%n@|bold,underline Description:|@%n%n",
		optionListHeading = "%n@|bold,underline Options:|@%n",
		description = "Convert the results of a Byonic XL analysis to a ProXL XML file suitable for import into ProXL.\n\n" +
				"More info at: " + Constants.CONVERSION_PROGRAM_URI
)
public class MainProgram implements Runnable {

	@CommandLine.Option(names = { "-m", "--mzid" }, required = true, description = "Full path to the mzID (mzIdentML) file output by Byonic.")
	private File mzidFile;

	@CommandLine.Option(names = { "-o", "--out-file" }, required = true, description = "Full path to use for the ProXL XML output file (including file name).")
	private File outFile;

	@CommandLine.Option(names = { "-v", "--verbose" }, required = false, description = "If present, complete error messages will be printed. Useful for debugging errors.")
	private boolean verboseRequested = false;

	public void run()  {

		printRuntimeInfo();

		if( !mzidFile.exists() ) {
        	System.err.println( "The mzID (mzIdentML) file: " + mzidFile.getAbsolutePath() + " does not exist." );
        	System.exit( 1 );
        }
        
        if( !mzidFile.canRead() ) {
        	System.err.println( "Can not read mzID (mzIdentML) file: " + mzidFile.getAbsolutePath() );
        	System.exit( 1 );
        }
        
        
        /*
         * Parse the output file option
         */
        if( outFile.exists() ) {
        	System.err.println( "The output file: " + outFile.getAbsolutePath() + " already exists." );
        	System.exit( 1 );
        }
        

        
        // get the user supplied linker name

        System.err.println( "Converting MetaMorpheus to ProXL XML with the following parameters:" );
        System.err.println( "\tmzID (mzIdentML) path: " + mzidFile.getAbsolutePath() );
        System.err.println( "\toutput file path: " + outFile.getAbsolutePath() );

        /*
         * Run the conversion
         */
        try {
			ConverterRunner.convert(mzidFile, outFile);

			System.err.println("Done.");
			System.exit(0);
		} catch( Throwable t ) {

        	System.out.println( "\nError encountered:" );
        	System.out.println( t.getMessage() );

        	if(verboseRequested) {
        		t.printStackTrace();
			}

        	System.exit( 1 );

		}
	}

	public static void main( String[] args ) {

		CommandLine.run(new MainProgram(), args);

	}

	/**
	 * Print runtime info to STD ERR
	 * @throws Exception
	 */
	public void printRuntimeInfo() {

		try( BufferedReader br = new BufferedReader( new InputStreamReader( MainProgram.class.getResourceAsStream( "run.txt" ) ) ) ) {

			String line = null;
			while ( ( line = br.readLine() ) != null ) {

				line = line.replace( "{{URL}}", Constants.CONVERSION_PROGRAM_URI );
				line = line.replace( "{{VERSION}}", Constants.CONVERSION_PROGRAM_VERSION );

				System.err.println( line );

			}

			System.err.println( "" );

		} catch ( Exception e ) {
			System.out.println( "Error printing runtime information." );
		}
	}
}
