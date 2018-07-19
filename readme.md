# WORD2PDF DEMO
> 原本项目中使用了Microsoft Office来进行docx文件转换为pdf文件，但由于Microsoft Office是一款收费软件，且收费方式还是以人头计算的，在产品开发使用中存在版权问题。所以近日就收集网上的一些方案，并加以优化整合到了这个demo项目，进行对比，替换掉原本的方案。    
  author : Felix Yan (严伟森)  

#### 方案一： Aspose库
Aspose库是一款处理office文档都非常方便的库，支持多种语言，收费，支持免费试用（会在开头有红色版权标注）

- [实现](https://github.com/yws179/word2pdf-demo/blob/master/src/main/java/com/yws/demo/word2pdf/impl/AsposeWordServiceImpl.java)
- [运行](https://github.com/yws179/word2pdf-demo/blob/master/src/test/java/com/yws/demo/word2pdf/WordServiceTests.java)

#### 方案二： 使用LibreOffice免费办公软件自带的soffice工具
LibreOffice自带的soffice工具支持以命令的方式进行文件类型转换，所以本例子通过java执行命令来调用soffice完成word到pdf的转换

- [实现](https://github.com/yws179/word2pdf-demo/blob/master/src/main/java/com/yws/demo/word2pdf/impl/LibreOfficeCommandWordServiceImpl.java)
- [运行](https://github.com/yws179/word2pdf-demo/blob/master/src/test/java/com/yws/demo/word2pdf/WordServiceTests.java)

#### 方案三：使用LibreOffice官网Api文档的方式（通过UNO）

- [实现](https://github.com/yws179/word2pdf-demo/blob/master/src/main/java/com/yws/demo/word2pdf/impl/LibreOfficeUnoWordServiceImpl.java)
- [运行](https://github.com/yws179/word2pdf-demo/blob/master/src/test/java/com/yws/demo/word2pdf/WordServiceTests.java)

#### 方案四: 使用Jacob库（待实现）（仅支持windows）
此方法可通过调用 `Microsoft Office` / `WPS` 来实现转换
