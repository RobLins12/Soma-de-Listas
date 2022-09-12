package br.unicap.ed1.desafio02;

public class Utils {
    public static SinglyLinkedList sum(SinglyLinkedList listAddendOne, SinglyLinkedList listAddendTwo){
        SinglyListNode currentListOne = listAddendOne.getHead();
        SinglyListNode currentListTwo = listAddendTwo.getHead();
        SinglyLinkedList resultSumList = new SinglyLinkedList();

        int carry = 0;
        boolean listOneIsFinished = (currentListOne == null);
        boolean listTwoIsFinished = (currentListTwo == null); 
        while(!(listOneIsFinished) || !(listTwoIsFinished) ){
            int sum = 0;
            if(!listOneIsFinished){
                sum += currentListOne.getValue();    
            }
            if(!listTwoIsFinished){
                sum += currentListTwo.getValue();    
            }

            sum += carry;
            carry = 0;

            if(sum > 9){
                carry = 1;
                sum = sum%10;
            }

            resultSumList.addLast(sum);
            if(!listOneIsFinished){
                currentListOne = currentListOne.getNext();
            }
            if(!listTwoIsFinished){
                currentListTwo = currentListTwo.getNext();    
            }

            listOneIsFinished = (currentListOne == null);
            listTwoIsFinished = (currentListTwo == null);

        }

        if(carry == 1){
            resultSumList.addLast(1);
        }

        return resultSumList;




    }

    

}
