package com.yws.demo.word2pdf.impl;

import com.sun.star.beans.PropertyValue;
import com.sun.star.frame.XComponentLoader;
import com.sun.star.frame.XDesktop;
import com.sun.star.frame.XStorable;
import com.sun.star.lang.XComponent;
import com.sun.star.lang.XMultiComponentFactory;
import com.sun.star.uno.UnoRuntime;
import com.sun.star.uno.XComponentContext;
import com.yws.demo.word2pdf.WordService;
import ooo.connector.BootstrapSocketConnector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Felix Yan
 * @data 2018/07/19
 */
@Service("unoWordService")
public class LibreOfficeUnoWordServiceImpl implements WordService {

    @Value("${soffice-dir:/usr/bin}")
    private String sofficeDir;

    @Override
    public void word2pdf(String inPath, String outPath) throws Exception {

        if (!outPath.endsWith(".pdf")) {
            outPath += "_result.pdf";
        }

        XComponentContext xContext = BootstrapSocketConnector.bootstrap(sofficeDir);

        XMultiComponentFactory xMCF = xContext.getServiceManager();

        Object oDesktop = xMCF.createInstanceWithContext("com.sun.star.frame.Desktop", xContext);

        XDesktop xDesktop = UnoRuntime.queryInterface(XDesktop.class, oDesktop);

        XComponentLoader xCompLoader = UnoRuntime.queryInterface(XComponentLoader.class, xDesktop);

        XComponent xComp = xCompLoader.loadComponentFromURL(
                "file:///" + inPath, "_blank", 0, new PropertyValue[0]);

        XStorable xStorable = UnoRuntime.queryInterface(XStorable.class, xComp);

        PropertyValue[] propertyValue = new PropertyValue[2];
        propertyValue[0] = new PropertyValue();
        propertyValue[0].Name = "Overwrite";
        propertyValue[0].Value = Boolean.TRUE;
        propertyValue[1] = new PropertyValue();
        propertyValue[1].Name = "FilterName";
        propertyValue[1].Value = "writer_pdf_Export";
        xStorable.storeToURL("file:///" + outPath, propertyValue);

        xDesktop.terminate();
    }

}
