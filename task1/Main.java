package com.company;


import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        ParserTimeTable.parse("src\\main\\resources\\timetable.xml");
    }
}