package com.android.apps.ashu.alberticipher;

import java.util.ArrayList;

public class EncriptionDecriptionFunctions {

    public static void help(){
        System.out.println("\n****************************************************************");
        System.out.println("**This is a cipher application based on Alberti disk.         **");
        System.out.println("**You can Encript and decript with the help of the disk       **");
        System.out.println("**NOTE. You can only encript CAPITAL letters and 1-4          **");
        System.out.println("**If you give small letters it will be considerd as Upper case**");
        System.out.println("**To decript you can only use small letters and &             **");
        System.out.println("**Other characters are scaped.                                **");
        System.out.println("****************************************************************\n");
    }
    public static ArrayList<String> textToArrayList(String text){
        ArrayList<String> charArray = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            charArray.add(String.valueOf(text.charAt(i)));
        }
        return charArray;
    }

    public static ArrayList<String> removeHJKUWY(ArrayList<String> charArray){
        ArrayList<String> newMessage = new ArrayList<>();
        for (String temporary : charArray) {
            switch(temporary){
                case "H":
                    newMessage.add("F");
                    newMessage.add("F");
                    break;
                case "J":
                    newMessage.add("I");
                    newMessage.add("I");
                    break;
                case "K":
                    newMessage.add("Q");
                    newMessage.add("Q");
                    break;
                case "U":
                    newMessage.add("V");
                    newMessage.add("V");
                    break;
                case "W":
                    newMessage.add("X");
                    newMessage.add("X");
                    break;
                case "Y":
                    newMessage.add("Z");
                    newMessage.add("Z");
                    break;
                default:
                    newMessage.add(temporary);
                    break;
            }
        }
        return newMessage;
    }

    public static String[] setInnerAlberCipherDisk(String initialIndex){
        int size = CircleLetters.InnerCircle.length;
        String[] newInnerCircle = new String[size];
        for (int i = 0; i < size; i++) {
            if(CircleLetters.InnerCircle[i].equals(initialIndex)){
                for (int j = 0; j < (size - i); j++) {
                    newInnerCircle[j] = CircleLetters.InnerCircle[j+i];
                }
                for (int j = 0; j < i ; j++) {
                    newInnerCircle[size-i+j] = CircleLetters.InnerCircle[j];
                }
            }
        }
        return newInnerCircle;
    }

    public static String[] setOutterAlberCipherDisk(String initialIndex){
        int size = CircleLetters.OutterCircle.length;
        String[] newOutterCircle = new String[size];
        for (int i = 0; i < size; i++) {
            if(CircleLetters.OutterCircle[i].equals(initialIndex)){
                for (int j = 0; j < (size - i); j++) {
                    newOutterCircle[j] = CircleLetters.OutterCircle[j+i];
                }
                for (int j = 0; j < i ; j++) {
                    newOutterCircle[size-i+j] = CircleLetters.OutterCircle[j];
                }
            }
        }
        return newOutterCircle;
    }

    public static String getEncryptedTextWithOneKey(String message, String initialIndex, String encryptingKey){
        ArrayList<String> finalEncryped = new ArrayList<>();
        ArrayList<String> myWorkingArrayList = textToArrayList(message);
        myWorkingArrayList = removeHJKUWY(myWorkingArrayList);
        String[] innerCircle = setInnerAlberCipherDisk(initialIndex);
        String[] outterCircle = setOutterAlberCipherDisk(encryptingKey);
        finalEncryped.add(encryptingKey);
        for (String character : myWorkingArrayList) {
            for (int i = 0; i < outterCircle.length; i++) {
                if(outterCircle[i].equals(character)){
                    finalEncryped.add(innerCircle[i]);
                }
            }
        }
        return arrayListToString(finalEncryped);
    }

    public static String getEncryptedTextWithMultipleKey(String message, String initialIndex, String[] encryptingKeys,int howMuchCharToJump){
        ArrayList<String> finalEncryped = new ArrayList<>();
        ArrayList<String> myWorkingArrayList = textToArrayList(message);
        myWorkingArrayList = removeHJKUWY(myWorkingArrayList);
        String[] innerCircle = setInnerAlberCipherDisk(initialIndex);
        String[] outterCircle = setOutterAlberCipherDisk(encryptingKeys[0]);
        finalEncryped.add(encryptingKeys[0]);
        int noOfJumps = 0;
        int currentKey=0;
        for (int j = 0; j < myWorkingArrayList.size(); j++) {

//        }
//        r
//        for (String character : myWorkingArrayList) {
            if(noOfJumps==howMuchCharToJump){
                if((myWorkingArrayList.size() > j+1) && (myWorkingArrayList.get(j).equals(myWorkingArrayList.get(j+1)))){
                    //TODO
                }
                else if((j!=0) && (myWorkingArrayList.get(j).equals(myWorkingArrayList.get(j-1)))){
                    //TODO
                }
                else{
                    noOfJumps=0;
                    if((currentKey+1)==encryptingKeys.length){
                        currentKey=0;
                    }
                    else{
                        currentKey++;
                    }
//                currentKey+=1;
                    outterCircle = setOutterAlberCipherDisk(encryptingKeys[currentKey]);
                    finalEncryped.add(encryptingKeys[currentKey]);
                }

            }
            else{
                noOfJumps++;
            }
            for (int i = 0; i < outterCircle.length; i++) {
                if(outterCircle[i].equals(myWorkingArrayList.get(j))){
                    finalEncryped.add(innerCircle[i]);
                }
            }
        }
        //finalEncryped.add(encryptingKey);
//        for (String character : myWorkingArrayList) {
//            for (int i = 0; i < outterCircle.length; i++) {
//                if(outterCircle[i].equals(character)){
//                    finalEncryped.add(innerCircle[i]);
//                }
//            }
//        }
        return arrayListToString(finalEncryped);
    }

    public static String getDecryptedTextWithOneKey(String message, String initialIndex){
        ArrayList<String> finalDecryped = new ArrayList<>();
        ArrayList<String> myWorkingArrayList = textToArrayList(message);
        String[] innerCircle = setInnerAlberCipherDisk(initialIndex);
        String[] outterCircle = setOutterAlberCipherDisk(myWorkingArrayList.get(0));
        System.out.println(myWorkingArrayList);
        for (int i = 0; i < myWorkingArrayList.size(); i++) {
            System.out.println(myWorkingArrayList.get(i));
            if(Character.isUpperCase(myWorkingArrayList.get(i).charAt(0))){
                outterCircle = setOutterAlberCipherDisk(myWorkingArrayList.get(i));
                System.out.println("My cap: "+myWorkingArrayList.get(i));
            }
            else if((i+1)<myWorkingArrayList.size() && myWorkingArrayList.get(i).equals(myWorkingArrayList.get(i+1))){
                for (int j = 0; j < innerCircle.length; j++) {
                    if(innerCircle[j].equals(myWorkingArrayList.get(i))){
                        switch(outterCircle[j]){
                            case "F":
                                finalDecryped.add("H");
                                break;
                            case "I":
                                finalDecryped.add("J");
                                break;
                            case "Q":
                                finalDecryped.add("K");
                                break;
                            case "V":
                                finalDecryped.add("U");
                                break;
                            case "X":
                                finalDecryped.add("W");
                                break;
                            case "Z":
                                finalDecryped.add("Y");
                                break;
                            default:
                                finalDecryped.add(outterCircle[j]);
                                break;
                        }
                    }
                }
            }
            else if(myWorkingArrayList.get(i).equals(myWorkingArrayList.get(i-1))){
                for (int j = 0; j < innerCircle.length; j++) {
                    if(innerCircle[j].equals(myWorkingArrayList.get(i))){
                        switch(outterCircle[j]){
                            case "F":
                                break;
                            case "I":
                                break;
                            case "Q":
                                break;
                            case "V":
                                break;
                            case "X":
                                break;
                            case "Z":
                                break;
                            default:
                                finalDecryped.add(outterCircle[j]);
                                break;
                        }
                    }
                }
            }
            else{
                for (int j = 0; j < innerCircle.length; j++) {
                    if(innerCircle[j].equals(myWorkingArrayList.get(i))){
                        finalDecryped.add(outterCircle[j]);
                        System.out.println(outterCircle[j]);
                    }
                }
            }

        }
        return arrayListToString(finalDecryped);
    }

    public static String arrayListToString(ArrayList<String> arrayListToCovert){
        String textToReturn;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayListToCovert.size(); i++) {
            sb.append(arrayListToCovert.get(i));
        }
        textToReturn= sb.toString();
        return textToReturn;
    }

}

