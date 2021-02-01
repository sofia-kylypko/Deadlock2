package com.test.deadlock2;

public class Thread1 implements Runnable {
    public static int number2=0;

    @Override
    public void run() {
        if(number2==0){
            number2--;
        }
        if(number2<=-1 && number2>=-5){
            number2--;
        }
        if(number2==-5) {
            if(Thread2.number1==-5){
                number2++;
            }else{
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
