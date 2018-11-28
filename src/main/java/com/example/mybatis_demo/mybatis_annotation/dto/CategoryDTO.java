package com.example.mybatis_demo.mybatis_annotation.dto;

import com.example.mybatis_demo.mybatis_annotation.entity.Category;

import java.util.Arrays;

public class CategoryDTO extends Category {

    public String[] queryfields;
    public String[] editfields;
    public String[] addfields;
    public String[] getQueryfields() {
        return queryfields;
    }
    public void setQueryfields(String[] queryfields) {
        this.queryfields = queryfields;
    }
    public String[] getEditfields() {
        return editfields;
    }
    public void setEditfields(String[] editfields) {
        this.editfields = editfields;
    }
    public String[] getAddfields() {
        return addfields;
    }
    public void setAddfields(String[] addfields) {
        this.addfields = addfields;
    }


    @Override
    public String toString() {
        return "CategoryDTO{" +
                "queryfields=" + Arrays.toString(queryfields) +
                ", editfields=" + Arrays.toString(editfields) +
                ", addfields=" + Arrays.toString(addfields) +
                '}';
    }
}
