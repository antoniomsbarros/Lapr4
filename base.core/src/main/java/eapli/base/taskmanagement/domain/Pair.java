package eapli.base.taskmanagement.domain;

public class Pair<H,S> {

    private H first;
    private S segund;

    public Pair(H first, S segund) {
        this.first = first;
        this.segund = segund;
    }

    public Pair() {
    }

    public H getFirst() {
        return first;
    }

    public void setFirst(H first) {
        this.first = first;
    }

    public S getSegund() {
        return segund;
    }

    public void setSegund(S segund) {
        this.segund = segund;
    }
}
