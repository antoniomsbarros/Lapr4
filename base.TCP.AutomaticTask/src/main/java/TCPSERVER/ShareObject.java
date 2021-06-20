package TCPSERVER;

public class ShareObject {
    private int contthread1;
    private int contthread2;
    private int contthread3;
    private int contthread4;
    private int contthread5;

    public synchronized int getContthread1() {
        return contthread1;
    }

    public synchronized void setContthread1(int contthread1) {
        this.contthread1 = contthread1;
    }

    public synchronized int getContthread2() {
        return contthread2;
    }

    public synchronized void setContthread2(int contthread2) {
        this.contthread2 = contthread2;
    }

    public synchronized int getContthread3() {
        return contthread3;
    }

    public synchronized void setContthread3(int contthread3) {
        this.contthread3 = contthread3;
    }

    public synchronized int getContthread4() {
        return contthread4;
    }

    public synchronized void setContthread4(int contthread4) {
        this.contthread4 = contthread4;
    }

    public synchronized int getContthread5() {
        return contthread5;
    }

    public synchronized void setContthread5(int contthread5) {
        this.contthread5 = contthread5;
    }
}
