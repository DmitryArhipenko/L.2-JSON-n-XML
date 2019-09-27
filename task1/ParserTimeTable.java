package com.company;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ParserTimeTable {
    public static void parse(String path) throws ParserConfigurationException, SAXException, IOException {
        List<Train> list = new ArrayList<>();

        DefaultHandler handler = new DefaultHandler() {

            Train train = new Train();
            String element;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                element = qName;
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                element = "";

                if (qName.equals("train")) {
                    list.add(new Train(train));
                }
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                String value = new String(ch, start, length);
                if (element.equalsIgnoreCase("from"))
                    train.setFrom(value);
                if (element.equalsIgnoreCase("to"))
                    train.setTo(value);
                if (element.equalsIgnoreCase("date")) {
                    SimpleDateFormat formatDate = new SimpleDateFormat("DD.MM.YYYY");
                    try {
                        train.setDate(formatDate.parse(value));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                if (element.equalsIgnoreCase("departure")) {
                    SimpleDateFormat formatDeparture = new SimpleDateFormat("HH:MM");
                    try {
                        train.setDeparture(formatDeparture.parse(value));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(path, handler);

        timeOutput(list);
    }

    private static void timeOutput(List<Train> list) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:MM");

        Date startDate = null;
        Date endDate = null;

        boolean checkOut = true;

        while (checkOut) {
            try {
                System.out.println("Input the time period like 'HH:HH' ");
                startDate = dateFormat.parse(scanner.nextLine());
                endDate = dateFormat.parse(scanner.nextLine());
            } catch (ParseException e) {
                System.out.println("Input again like 'HH:HH' \n");
            }

            if (startDate != null && endDate != null)
                checkOut = false;
        }

        for (Train train : list) {
            Date date = train.getDeparture();

            if (!(date.before(startDate) || date.after(endDate))) {
                System.out.println(train);
            }
        }


    }
}