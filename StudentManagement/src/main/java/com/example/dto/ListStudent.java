package com.example.dto;

import com.example.model.TblStudent;

import java.util.List;

public class ListStudent {
    private List<TblStudent> data;

    public List<TblStudent> getData() {
        return data;
    }

    public void setData(List<TblStudent> data) {
        this.data = data;
    }
}
