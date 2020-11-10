package com.kaide.system;

import org.docx4j.Docx4J;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;

import java.util.List;

public class TestDocx4J {
    public static void main(String[] args) throws Docx4JException {

        String inputfilepath = "E:\\csi\\system\\src\\main\\resources\\static\\centos8.docx";

        WordprocessingMLPackage wordMLPackage =
                Docx4J.load(new java.io.File(inputfilepath));
        MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();
        System.out.println(documentPart);
        List<Object> ObjLis = documentPart.getContent();
        System.out.println(ObjLis);

    }



}
