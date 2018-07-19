package com.yws.demo.word2pdf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resource;
import java.io.File;

/**
 * @author Felix Yan
 * @data 2018/07/16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WordServiceTests {

    @Resource
    private WordService commandWordService;

    @Resource
    private WordService asposeWordService;

    @Resource
    private WordService unoWordService;

    @Test
    public void testAsposeWord2Pdf() throws Exception {
        test(asposeWordService);
    }

    @Test
    public void testLibreOfficeCommandWord2Pdf() throws Exception {
        test(commandWordService);
    }

    @Test
    public void testLibreOfficeUnoWord2Pdf() throws Exception {
        test(unoWordService);
    }

    public void test(WordService wordService) throws Exception {
        File file = ResourceUtils.getFile("classpath:test.docx");
        File outFile = new File("./test.pdf");
        wordService.word2pdf(file.getAbsolutePath(), outFile.getAbsolutePath());
    }

}
