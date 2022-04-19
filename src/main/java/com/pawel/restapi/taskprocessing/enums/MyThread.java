package com.pawel.restapi.taskprocessing.enums;

public class MyThread implements Runnable {

    private static int count = 0;
    private int id;
    private double base;
    private double exponent;
    private int result;
    private int progress;
    private String status;

    public MyThread(int base, int exponent) {
        this.status = "running";
        this.base = base;
        this.exponent = exponent;
        this.progress = 1;
        this.id = ++count;
    }

    public MyThread() {
    }

    @Override
    public void run() {
        while (progress < 100) {
            try {
                Thread.sleep(1000);
                progress++;
                if (progress == 100) {
                    this.result = (int) Math.pow(base, exponent);
                    this.setStatus("finished");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getExponent() {
        return exponent;
    }

    public void setExponent(double exponent) {
        this.exponent = exponent;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "TheThread{" +
                "base=" + base +
                ", exponent=" + exponent +
                ", result=" + result +
                '}';
    }
}
