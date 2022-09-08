package com.wpollock.search.data;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;

import com.wpollock.search.DocPos;

public class InvertedIndex {
    private static Map<String, SortedSet<DocPos>> invertedIndex = new HashMap<>();

    public void loadIndex(String indexJSON) {

    }

    public String exportIndex() {
        return null; // returns Map data as JSON
    }
}
