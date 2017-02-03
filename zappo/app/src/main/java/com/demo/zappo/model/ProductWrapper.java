package com.demo.zappo.model;

import java.util.ArrayList;

/**
 * Created by ashishbulchandani on 01/02/17.
 * This class holds the list of product request by user
 * in correspondence to search text entered in homescreen
 * In addition, it contain infomation such as 'totalResultCount', etc.
 */

public class ProductWrapper {

    int totalResultCount;
    int currentResultCount;
    String originalTerm;
    String term;
    ArrayList<Product> results = new ArrayList<>();

    public int getTotalResultCount() {
        return totalResultCount;
    }

    public void setTotalResultCount(int totalResultCount) {
        this.totalResultCount = totalResultCount;
    }

    public int getCurrentResultCount() {
        return currentResultCount;
    }

    public void setCurrentResultCount(int currentResultCount) {
        this.currentResultCount = currentResultCount;
    }

    public String getOriginalTerm() {
        return originalTerm;
    }

    public void setOriginalTerm(String originalTerm) {
        this.originalTerm = originalTerm;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public ArrayList<Product> getResults() {
        return results;
    }

    public void setResults(ArrayList<Product> results) {
        this.results = results;
    }
}
