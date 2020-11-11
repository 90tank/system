package com.kaide.system.pdf;


import java.io.*;

import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;
import com.lowagie.text.pdf.BaseFont;




/**
 * html转pdf
 *
 */
public class Html2Pdf {

    public static void main(String[] args) throws Exception {

        String originHtml = "E:\\csi\\system\\src\\main\\resources\\static\\wordTest\\html\\test.html";

        //读取html的流
//        InputStream inputStream = Html2Pdf.class.getResourceAsStream(originHtml);
        InputStream inputStream = new FileInputStream(new File(originHtml));

        //流转换成字符串
        StringBuffer out = new StringBuffer();
        byte[] b = new byte[4096];
        for (int n; (n = inputStream.read(b)) != -1;) {
            out.append(new String(b, 0, n));
        }

        String html = out.toString();
        String pdffile = "E:\\csi\\system\\src\\main\\resources\\static\\wordTest\\pdf" + File.separator+ "test.pdf";

        OutputStream os = new FileOutputStream(pdffile);
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);

        // writer.setPageEvent(header);
        ITextFontResolver fontResolver = renderer.getFontResolver();
        // 添加字体支持,路径可以自身项目的实际情况设置，我这里是本地项目，而且为了方便测试，就写成固定的了
        // 实际项目中，可以获取改字体所在真实的服务器的路径,这个方法是本地地址和网络地址都支持的
        // 这里面添加的是宋体
        fontResolver.addFont("E:\\csi\\system\\src\\main\\resources\\static\\fonts\\simsun.ttc",
                BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);


        renderer.layout();
        renderer.createPDF(os);
        os.flush();
        os.close();
    }
}