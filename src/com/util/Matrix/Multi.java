package com.util.Matrix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Multi implements Runnable{

        Matrix mtx1,mtx2,result;

        int m,n;

        Multi(Matrix mt1,Matrix mt2,Matrix res,int i,int j){

        mtx1=mt1;mtx2=mt2;result=res;

        m=i;n=j;

        }



    @Override

    public void run() {

        // TODO Auto-generated method stub

        int temp=0, count=mtx1.getColumn();

        for(int i=0;i<count;i++) {

        temp+=mtx1.getData()[m][i]*mtx2.getData()[i][n];

        }

        double[][] tmp = result.getData();
        tmp[m][n]=temp;
        result.setData(tmp);

        }

        }
