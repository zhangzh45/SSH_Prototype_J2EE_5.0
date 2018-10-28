package com.util.Matrix;

import java.io.*;


public class Matrix {

    private int row,column;
    private double[][] data;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public double[][] getData() {
        return data;
    }

    public void setData(double[][] data) {
        this.data = data;
    }

    public Matrix(int m, int n, String filename) {

        row=m; column=n;

        data=new double[m][n];

        File f= new File(filename);

        try{

            BufferedReader bin = new BufferedReader(new FileReader(f));

            for(int i=0;i<m;i++) {

                String line = bin.readLine();



                String[] words=line.split(" ");

                for(int j=0;j<n;j++) {

                    data[i][j]=Double.parseDouble(words[j]);

                }

            }

            bin.close();

            f.exists();

        }catch(IOException e) {

            e.printStackTrace();

        }

    }



    public Matrix(int m,int n) {

        row=m;column=n;

        data=new double[m][n];

    }



    public Matrix plus(Matrix a) {

        if(a.row!=row||a.column!=column) {

            System.out.println("The matrixes to be computed must be the same in terms with size");

            return null;

        }

        Matrix result=new Matrix(row,column);

        for(int i=0;i<row;i++) {

            for(int j=0;j<column;j++) {

                result.data[i][j]=data[i][j]+a.data[i][j];

            }

        }

        return result;

    }



    public Matrix multiByNum(double a) {

        Matrix result=new Matrix(row,column);

        for(int i=0;i<row;i++) {

            for(int j=0;j<column;j++) {

                result.data[i][j]=a*data[i][j];

            }

        }

        return result;

    }



    public Matrix multiByMatrix(Matrix a){//右乘一个矩阵

        int m=a.row,n=a.column;

        if(column!=m) {

            System.out.println("size unmatched");

            return null;

        }

        Matrix result = new Matrix(row,n);

        for(int i=0;i<row;i++) {

            for(int j=0;j<n;j++) {

                Thread t=new Thread(new Multi(this,a,result,i,j));

                t.start();

            }

        }

        return result;

    }



    public Matrix multiMatrix(Matrix a){//左乘一个矩阵

        int m=a.row,n=a.column;

        if(n!=row) {

            System.out.println("size unmatched");

            return null;

        }

        Matrix result = new Matrix(m,column);

        for(int i=0;i<m;i++) {

            for(int j=0;j<column;j++) {

                Thread t=new Thread(new Multi(a,this,result,i,j));

                t.start();

            }

        }

        return result;

    }



    public void print() {

        for(int i=0;i<row;i++) {

            for(int j=0;j<column;j++) {

                System.out.print(data[i][j]+" ");

            }

            System.out.print("\n");

        }

        System.out.println(" ");

    }

    //利用方根法求特征向量
    public Matrix featureVector(Matrix a){
        row = a.row;
        column = a.column;

        Matrix result = new Matrix(row,1);
        Matrix temp = new Matrix(row,1);
        double sum = 0.0;
        for(int i=0;i<row;i++) {
            temp.data[i][0] = 1.0;
            for(int j=0;j<column;j++) {
                temp.data[i][0] *= a.data[i][j];
            }
            temp.data[i][0] = Math.pow(temp.data[i][0], 1.0 / column);
            sum += temp.data[i][0];
        }
        for(int i=0;i<row;i++) {
            result.data[i][0] = temp.data[i][0] / sum;
        }
        return result;
    }

    //利用方根法求最大特征根
    public double featureRoot(Matrix a, Matrix b){
        row = a.row;
        column = a.column;
        double result = 0.0;
        for(int i=0;i<row;i++) {
            result += a.multiByMatrix(b).data[i][0] / (row * b.data[i][0]);
        }
        return result;
    }

}