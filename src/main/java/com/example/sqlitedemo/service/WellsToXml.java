package com.example.sqlitedemo.service;

import com.example.sqlitedemo.entity.Well;
import com.example.sqlitedemo.repository.WellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class WellsToXml {
    private List<Well> list;
    @Autowired
    private  WellRepository wellRepository;
    public WellsToXml(WellRepository wellRepository) {
        this.wellRepository = wellRepository;

        Optional opt = Optional.ofNullable(wellRepository.findAll());
        if(opt.isPresent()){
            list = wellRepository.findAll();
        }else{
            list = new ArrayList<>();
        }
    }

    public void convert(String path){
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            //root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("dbinfo");
            doc.appendChild(rootElement);
            for(int i=0;i< list.size();i++){
                Well well = list.get(i);
                Element wellElement = doc.createElement("well");
                wellElement.setAttribute("name",well.getName());
                System.out.print(well.getEquipments());
                for(int j =0;j<well.getEquipments().size();j++){
                    Element equipmentElement = doc.createElement("equipment");
                    equipmentElement.setAttribute("name",well.getEquipments().get(j).getName());
                    wellElement.appendChild(equipmentElement);
                }
                rootElement.appendChild(wellElement);
            }
            //write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(path));
            transformer.transform(source, result);
        } catch (ParserConfigurationException | TransformerConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}

