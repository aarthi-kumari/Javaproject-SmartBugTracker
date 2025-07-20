package com.smartbugtracker.util;

import com.smartbugtracker.model.Bug;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BugParser {

    public static List<Bug> parseBugsFromXml(String xmlPath) {
        List<Bug> bugList = new ArrayList<>();

        try {
            File inputFile = new File(xmlPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            
            // Namespace aware to support PMD XML with xmlns
            dbFactory.setNamespaceAware(true);

            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Use namespace-aware methods
            NodeList fileNodes = doc.getElementsByTagNameNS("*", "file");

            for (int i = 0; i < fileNodes.getLength(); i++) {
                Element fileElement = (Element) fileNodes.item(i);
                String fileName = fileElement.getAttribute("name");

                NodeList violationNodes = fileElement.getElementsByTagNameNS("*", "violation");

                for (int j = 0; j < violationNodes.getLength(); j++) {
                    Element violationElement = (Element) violationNodes.item(j);

                    Bug bug = new Bug();
                    bug.setFile(fileName);
                    bug.setRule(violationElement.getAttribute("rule"));
                    bug.setPriority(violationElement.getAttribute("priority"));
                    bug.setMessage(violationElement.getTextContent().trim());

                    // ✅ Set line number from XML
                    bug.setLine(Integer.parseInt(violationElement.getAttribute("beginline")));

                    bugList.add(bug);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bugList;
    }
}
