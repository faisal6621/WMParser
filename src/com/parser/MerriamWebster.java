package com.parser;

import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class MerriamWebster {

	public static StringTokenizer getMeanings(String inWord) {
		StringTokenizer tokenizer = null;
		String url = "http://www.merriam-webster.com/dictionary/" + inWord;
		Document document;
		try {
			document = Jsoup.connect(url).get();
			// System.out.println(document.select("div.ld_on_collegiate").text());
			String meanings = document.select("div.ld_on_collegiate").text();
			tokenizer = new StringTokenizer(meanings, ":");
			while (tokenizer.hasMoreTokens()) {
				System.out.println(tokenizer.nextToken());
			}
		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println("Exception:: " + e.getMessage());
		}
		return tokenizer;
	}

	public static void main(String[] s) {
		getMeanings("word");
	}
}
