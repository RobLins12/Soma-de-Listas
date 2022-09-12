package br.unicap.ed1.desafio02;

public class SinglyListNode {

    private SinglyListNode next;
    private Integer value;    


    public SinglyListNode(Integer value, SinglyListNode next) {
        this.next = next;
        this.value = value;

    }

    public SinglyListNode getNext() {
        return next;
    }

    
    public void setNext(SinglyListNode next) {
        this.next = next;
    }

    
    public Integer getValue() {
        return value;
    }

   
    public void setValue(Integer value) {
        this.value = value;
    }

}