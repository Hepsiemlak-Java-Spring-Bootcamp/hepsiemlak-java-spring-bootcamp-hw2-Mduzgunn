package com.md;

public class EstateFactory {
    public EstateSupplier createEstate(String type){
        if (type==null || type.isEmpty()) {
            return null;
        }
        if ("ev".equals(type)){
            return new GayrimenkulEv();
        }
        else if("araba".equals(type)){
            return new GayrimenkulAraba();
        }
        return null;
    }
}
