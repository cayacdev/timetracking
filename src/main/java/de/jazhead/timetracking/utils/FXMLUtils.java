/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.jazhead.timetracking.utils;

import de.jazhead.timetracking.controller.TimeTrackingController;
import javafx.fxml.FXMLLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;

@Component
public class FXMLUtils {

    @Autowired
    ApplicationContext applicationContext;

    public FXMLLoader getFxmlLoader(final String fxmlPath) {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        loader.setControllerFactory(aClass -> loadScreenController(fxmlPath));

        return loader;
    }

    private TimeTrackingController loadScreenController(final String fxmlPath) {
        final Class controllerClass = getControllerClass(fxmlPath);

        return (TimeTrackingController) applicationContext.getBean(controllerClass);
    }

    public Class getControllerClass(final String fxmlPath) {
        try {
            final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder builder;
            builder = factory.newDocumentBuilder();
            final URL location = FXMLUtils.class.getResource(fxmlPath);
            final Document document = builder.parse(location.openStream());
            final NamedNodeMap attributes = document.getDocumentElement().getAttributes();
            String fxControllerClassName = null;
            for (int i = 0; i < attributes.getLength(); i++) {
                final Node item = attributes.item(i);
                if (item.getNodeName().equals(FXMLLoader.FX_NAMESPACE_PREFIX + ":" + FXMLLoader.CONTROLLER_KEYWORD)) {
                    fxControllerClassName = item.getNodeValue();
                }
            }
            if (fxControllerClassName != null)
                return ClassLoader.getSystemClassLoader().loadClass(fxControllerClassName);
        } catch (ParserConfigurationException | SAXException | IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
