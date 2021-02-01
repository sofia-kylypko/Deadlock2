package com.test.deadlock2;

public class Thread2 implements Runnable{
    public static int number1=0;

    @Override
    public void run() {
        if(number1==0){
            number1++;
        }
        if(number1>=1 && number1<5){
            number1++;
        }
        if(number1==5) {
            if(Thread1.number2==5){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
