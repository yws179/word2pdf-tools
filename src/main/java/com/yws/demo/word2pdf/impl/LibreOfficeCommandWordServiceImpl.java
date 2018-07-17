package com.yws.demo.word2pdf.impl;

import com.yws.demo.word2pdf.WordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * 通过命令调用libreOffice的soffice工具转换
 * @author Felix Yan
 * @data 2018/07/16
 */
@Service("commandWordService")
public class LibreOfficeCommandWordServiceImpl implements WordService {

	private static final Logger logger = LoggerFactory.getLogger(LibreOfficeCommandWordServiceImpl.class);

	@Value("${soffice-dir:/usr/bin}")
	private String sofficeDir;

	@Override
	public void word2pdf(String inPath, String outPath) throws Exception {
		if (!new File(inPath).exists()) {
			throw new FileNotFoundException();
		}
		String command = String.format("%s/soffice --convert-to pdf:writer_pdf_Export %s --outdir %s", sofficeDir, inPath, outPath);
		String output = this.executeCommand(command);
		logger.info("exec command:[{}]\noutput: [{}]", command, output);
	}

	protected String executeCommand(String command) throws IOException, InterruptedException {
		StringBuffer output = new StringBuffer();
		Process p;
		p = Runtime.getRuntime().exec(command);
		p.waitFor();
		try (
				InputStreamReader inputStreamReader = new InputStreamReader(p.getInputStream(), "UTF-8");
				BufferedReader reader = new BufferedReader(inputStreamReader)
		) {
			String line = "";
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}
		}
		p.destroy();
		return output.toString();
	}
}
