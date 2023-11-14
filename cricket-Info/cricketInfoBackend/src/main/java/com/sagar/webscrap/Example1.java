package com.sagar.webscrap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Example1 {
    public static void main(String[] args) throws IOException {
        String url= "https://www.cricbuzz.com/cricket-series/6732/icc-cricket-world-cup-2023/points-table";
        Document document = Jsoup.connect(url).get();
        //System.out.println(document.title());
        //System.out.println(document.documentType());
        Elements table = document.select("table.cb-srs-pnts");
       // System.out.println(table);
        Elements tableHeads = table.select("thead>tr>*");
        List<String> headers = tableHeads.stream()
                .map(element -> element.text())
                .collect(Collectors.toList());

        System.out.println(headers);


    }
}
