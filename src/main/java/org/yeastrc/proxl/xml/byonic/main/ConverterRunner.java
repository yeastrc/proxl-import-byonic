package org.yeastrc.proxl.xml.byonic.main;

import org.yeastrc.proxl.xml.byonic.builder.XMLBuilder;
import org.yeastrc.proxl.xml.byonic.objects.ByonicResults;
import org.yeastrc.proxl.xml.byonic.reader.ByonicResultsParser;

import javax.xml.bind.JAXBException;
import java.io.File;

public class ConverterRunner {

    public static void convert(File mzidFile, File outFile) throws Exception {

        // load data, gather results and linkers
        ByonicResults results = ByonicResultsParser.getByonicResults(mzidFile);


        XMLBuilder builder = new XMLBuilder();
        builder.buildAndSaveXML(results, outFile );

    }

}
