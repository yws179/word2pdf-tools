package com.yws.demo.word2pdf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WordToPdfDemoApplicationTests {

	@Test
	public void contextLoads() {
	}

//	@Test
//	public void word2pdf() throws FileNotFoundException {
//		String LibreOffice_HOME = "/usr/lib/libreoffice/program";
//		File file = ResourceUtils.getFile("classpath:dsi_fonts_test.docx");
//
//		DefaultOfficeManagerConfiguration configuration = new DefaultOfficeManagerConfiguration();
//		configuration.setOfficeHome(new File(LibreOffice_HOME));
//		configuration.setPortNumber(8100);
//		configuration.setTaskExecutionTimeout(1000 * 60 * 25L);
//		configuration.setTaskQueueTimeout(1000 * 60 * 60 * 24L);
//		OfficeManager officeManager = configuration.buildOfficeManager();
//		officeManager.start();
//		OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);
//		converter.getFormatRegistry();
//		try {
//			converter.convert(file, new File("./target.pdf"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			officeManager.stop();
//		}
//	}

}
