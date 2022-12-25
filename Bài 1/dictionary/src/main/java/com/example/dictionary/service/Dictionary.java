package com.example.dictionary.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class Dictionary {
    private static List<String> vn = new ArrayList<>();
    private static List<String> en = new ArrayList<>();

    static {
        vn.add("Chuoi");
        vn.add("Tao");
        vn.add("Dua hau");
        vn.add("Xoai");
        vn.add("Cam");
        en.add("Banana");
        en.add("Apple");
        en.add("Water melon");
        en.add("Mango");
        en.add("Orange");
    }

    public Dictionary() {
    }

    public List<String> findVN() {
        return vn;
    }

    public List<String> findEng() {
        return en;
    }

    public int getIndex(String vni) {
        for (int i = 0; i < vn.size(); i++) {
            if (vn.get(i).equals(vni)) {
                return i;
            }
        }
        return -1;
    }
}
