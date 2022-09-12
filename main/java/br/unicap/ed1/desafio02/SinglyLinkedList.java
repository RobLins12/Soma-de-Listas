package br.unicap.ed1.desafio02;

public class SinglyLinkedList {
    private SinglyListNode head;

    public SinglyListNode getHead() {
        return head;
    }

    public void setHead(SinglyListNode newHead) {
        this.head = newHead;

    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }

        return false;
    }

    public void addFirst(Integer value) {
        SinglyListNode newNode = new SinglyListNode(value, head);
        setHead(newNode);

    }

    public SinglyListNode search(Integer valueSearched) {
        SinglyListNode currentNodeToSearch = head;

        while (currentNodeToSearch != null && currentNodeToSearch.getValue() != valueSearched) {
            currentNodeToSearch = currentNodeToSearch.getNext();

        }

        return currentNodeToSearch;
    }

    public int size() {
        SinglyListNode currentNode = head;
        int size = 0;

        while (currentNode != null) {
            size++;
            currentNode = currentNode.getNext();

        }
        return size;

    }

    public void addLast(Integer value) {
        if (isEmpty()) {
            addFirst(value);
        }

        else {
            SinglyListNode currentNode = head;
            boolean isTail = currentNode.getNext() == null;
            SinglyListNode lastNode = new SinglyListNode(value, null);

            while (!isTail) {
                currentNode = currentNode.getNext();
                isTail = currentNode.getNext() == null;

            }

            currentNode.setNext(lastNode);
        }
    }

    public boolean isOrdered(boolean ascending) {
        SinglyListNode currentNodeVerify = head;

        if (head == null) {
            return true;
        }

        int currentValue;
        boolean isNotAscending;
        boolean isNotDescending;

        int lowerToHigherOrHigherToLowerValue = currentNodeVerify.getValue();
        while (currentNodeVerify != null) {
            currentValue = currentNodeVerify.getValue();
            isNotAscending = (lowerToHigherOrHigherToLowerValue > currentValue && ascending);
            isNotDescending = (lowerToHigherOrHigherToLowerValue < currentValue && !ascending);

            if (isNotAscending || isNotDescending) {
                return false;
            }

            lowerToHigherOrHigherToLowerValue = currentValue;
            currentNodeVerify = currentNodeVerify.getNext();

        }

        return true;

    }

    public void reverse() {
        SinglyLinkedList newReverseSinglyLinkedList = new SinglyLinkedList();
        SinglyListNode currentNodeInMainSinglyLinkedList = head;
        Integer currentValueInNode;

        while (currentNodeInMainSinglyLinkedList != null) {
            currentValueInNode = currentNodeInMainSinglyLinkedList.getValue();
            newReverseSinglyLinkedList.addFirst(currentValueInNode);
            currentNodeInMainSinglyLinkedList = currentNodeInMainSinglyLinkedList.getNext();
        }

        setHead(newReverseSinglyLinkedList.head);
    }

    public void delete(SinglyListNode nodeDelete) {
        SinglyListNode currentNode = head;

        if(head == null){
            return;
        }

        if (currentNode == nodeDelete) {
            setHead(currentNode.getNext());
            return;
        }

        while (currentNode.getNext() != null) {
            if (currentNode.getNext() == nodeDelete) {

                currentNode.setNext(nodeDelete.getNext());
                return;
            }

            currentNode = currentNode.getNext();
        }

    }
    public Integer[] toArray(){
        Integer[] array = new Integer[this.size()];
        SinglyListNode currentNode = this.getHead();

        for (int index = 0; index < array.length; index++) {
            array[index] = currentNode.getValue();
            currentNode = currentNode.getNext();
        }

        return array;
    }

}