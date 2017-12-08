package com.company;

public class ReaderWrite {

    private String filename;

    ReaderWrite(){

    }

    public boolean write(String data){
        return true;
    }

    public boolean write(String... data){

        return true;
    }

    public String[] read(){
        String[] airports = new String[1];

        return airports;
    }

    public void setFilename(String filename){
        this.filename = filename;
    }

    public String[] filelist(){
        String[] filelist = new String[1];

        return filelist;
    }
}
