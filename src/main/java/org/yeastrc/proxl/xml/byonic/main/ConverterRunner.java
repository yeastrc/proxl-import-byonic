package org.yeastrc.proxl.xml.byonic.main;

import org.yeastrc.proxl.xml.byonic.builder.XMLBuilder;

import java.io.File;

public class ConverterRunner {

    public static void convert(File mzidFile, File outFile) {

        // load data, gather results and linkers




        XMLBuilder builder = new XMLBuilder();
        builder.buildAndSaveXML(analysis, new File( outFilePath ) );

    }

}
