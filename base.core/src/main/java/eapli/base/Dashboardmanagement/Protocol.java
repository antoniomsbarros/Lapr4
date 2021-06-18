package eapli.base.DashboardManagement;

import eapli.base.taskmanagement.domain.Pair;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Protocol {

    private static final int VERSION = 3;

    static private String read(DataInputStream in, int length) throws IOException {
        String ret="";
        int val;
        for(int i = 0; i < length; i++) {
            val=in.read();
            ret=ret+(char)val;
        }
        return ret;
    }

    static private void write(DataOutputStream out, String line, int code) throws IOException {
        out.write(VERSION); out.write(code); out.write(line.length());
        out.write(line.getBytes(), 0, line.length());
    }


    //// NON-STATIC (INSTANCE) ELEMENTS

    private Integer version;
    private Integer code;
    private Integer num_bytes;
    private String data;


    public Protocol(DataInputStream in) throws IOException {
        num_bytes = 0;
        StringBuilder tempData = new StringBuilder();
        int bytesToRead;
        do {
            if(in.read() != VERSION) {
                throw new IllegalArgumentException("Version different from protocol!");
            }
            code = in.read();
            bytesToRead = in.read();
            num_bytes += bytesToRead;
            if (bytesToRead == 0) {
                data = null;
            } else {
                tempData.append(read(in, bytesToRead));
            }
        } while(code == 255);
        data = tempData.toString();
        version = VERSION;

    }

    public Protocol(int intCode) {
        version = VERSION;
        code = intCode;
        num_bytes = null;
        data = null;
    }


    public void setCode(int intCode) {
        this.code = intCode;
    }


    public boolean send(DataOutputStream out, String strData) throws IOException {
        this.data = strData;
        this.num_bytes = strData.length();
        if(num_bytes > 255) {
            List<Pair<Integer, String>> separatedData = separateData(this.data);
            for(Pair<Integer, String> p : separatedData) {
                if(p.getFirst() == 255) write(out, p.getSegund(), 255);
                else write(out, p.getSegund(), code);
            }
            return true;
        }
        write(out, strData, code);

        return true;
    }

    private List<Pair<Integer, String>> separateData(String data) {
        List<Pair<Integer, String>> sepData = new ArrayList<>();
        String str;
        int endcut;
        for(int i = 0; i < data.length(); i += 255) {
            endcut = Math.min(i + 255, data.length());
            str = data.substring(i, endcut);
            sepData.add(new Pair<>(str.length(), str));
        }
        return sepData;
    }
    public int getVersion() { return version; }
    public int getCode() { return code; }
    public String getData() { return data; }


}
