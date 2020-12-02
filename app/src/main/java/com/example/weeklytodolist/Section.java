package com.example.weeklytodolist;

import java.util.ArrayList;

public class Section {

    private String sectionName;
    private ArrayList<String> sectionItems;

    public Section(String sectionName, ArrayList<String> sectionItems) {
        this.sectionName = sectionName;
        this.sectionItems = sectionItems;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public ArrayList<String> getSectionItems() {
        return sectionItems;
    }

    public void setSectionItems(ArrayList<String> sectionItems) {
        this.sectionItems = sectionItems;
    }

    @Override
    public String toString() {
        return "Section{" +
                "sectionName='" + sectionName + '\'' +
                ", sectionItems=" + sectionItems +
                '}';
    }
}
