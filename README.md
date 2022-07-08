Byonic to Proxl XML Converter
=============================

Use this program to convert the results of a Byonic cross-linking analysis to
proxl XML suitable for import into the proxl web application.

Notes
-----

1. The results must be saved by Byonic in mzIdentML (mzId) format.
2. Currently, only the following cross-linkers are supported. If you are using a different cross-linker,
   please email us at mriffle .at. uw.edu and we will work with you to support your cross-linker. 
   1. Disulfied
   2. Trisulfied
   3. Disulfied x 2
3. The `Disulfied x 2` cross-link reports a crosslink between 1 position in peptide 1 to 2 positions in peptide 2.
This type of link is not currently supported by proxl or proxl XML. In proxl XML this is represented as a single
cross-link between the two peptides with a linker mass equal to `Disulfied x 2`'s delta mass. The site of
the 2nd cross-link in peptide two is marked as having a modification of mass 0.
4. Static mods are currently fully supported. If you have static mods in your search, please email us at mriffle .at. uw.edu.

How To Run
-------------
1. Download the `byonic2ProxlXML.jar` from the [latest release](https://github.com/yeastrc/proxl-import-metamorpheus/releases).
2. Run the program ``java -jar byonic2ProxlXML.jar`` with no arguments to see the possible parameters.

For more information on importing data into Proxl, please see the [Proxl Import Documentation](http://proxl-web-app.readthedocs.io/en/latest/using/upload_data.html).

More Information About Proxl
-----------------------------
For more information about Proxl, visit http://proxl-ms.org/.


Command line documentation
---------------------------
```
java -jar byonic2ProxlXML.jar [-hvV] -m=<mzidFile> -o=<outFile>

Description:

Convert the results of a Byonic XL analysis to a ProXL XML file suitable for
import into ProXL.

More info at: https://github.com/yeastrc/proxl-import-byonic

Options:
  -m, --mzid=<mzidFile>      Full path to the mzID (mzIdentML) file output by Byonic.
  -o, --out-file=<outFile>   Full path to use for the ProXL XML output file
                               (including file name).
  -v, --verbose              If present, complete error messages will be printed.
                               Useful for debugging errors.
  -h, --help                 Show this help message and exit.
  -V, --version              Print version information and exit.
```

