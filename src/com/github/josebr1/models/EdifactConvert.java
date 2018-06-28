package com.github.josebr1.models;

import java.io.*;

import com.github.josebr1.utils.PathOutput;
import org.apache.ws.commons.serialize.XMLWriter;
import org.apache.ws.commons.serialize.XMLWriterImpl;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.appliedmodels.edifact.parser.EdifactParser;

public class EdifactConvert {

    public void toXML(File[] files) throws FileNotFoundException, IOException, SAXException, InterruptedException {
        for (File file : files) {
            File newPathFile = new File("temp\\"+ System.currentTimeMillis() + "_" + PathOutput.format(file.getName()) + ".xml");

            Thread.sleep(500);

            OutputStream stream = new FileOutputStream(newPathFile);

            Writer out = new OutputStreamWriter(stream);
            try {
                XMLReader edifactParser = new EdifactParser();
                XMLWriter handler = new XMLWriterImpl();
                handler.setWriter(out);
                edifactParser.setContentHandler(handler);
                edifactParser.parse(new InputSource(new FileReader(file)));
            } finally {
                out.flush();
                out.close();
            }
        }
    }
}
