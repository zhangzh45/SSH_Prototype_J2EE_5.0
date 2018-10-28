package com.util;

import com.util.Matrix.Matrix;

import java.util.Random;

//层次分析法，用于确定QoS各属性的权重
public class AHP{
    int n;
    String preferredTarget;
    Matrix judgeMatrix = new Matrix(n, n);

    public AHP(int n, String preferredTarget, Matrix judgeMatrix) {
        this.n = n;
        this.preferredTarget = preferredTarget;
        this.judgeMatrix = judgeMatrix;
    }

    public AHP(int n, String preferredTarget) {
        this.n = n;
        this.preferredTarget = preferredTarget;
        this.judgeMatrix = new Matrix(n, n);
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getPreferredTarget() {
        return preferredTarget;
    }

    public void setPreferredTarget(String preferredTarget) {
        this.preferredTarget = preferredTarget;
    }

    public Matrix getJudgeMatrix() {
        return judgeMatrix;
    }

    public void setJudgeMatrix(Matrix judgeMatrix) {
        this.judgeMatrix = judgeMatrix;
    }

    /**
     * 返回用户偏好指标对应的下标
     * @return
     */
    public int getPreferredIndex(){
        int preferredIndex = 0;
        if(preferredTarget == null){
            preferredIndex = 0;
        }
        else if(preferredTarget.equalsIgnoreCase("ServiceReliability")){
            preferredIndex = 1;
        }
        else if(preferredTarget.equalsIgnoreCase("ServiceAvailability")){
            preferredIndex = 2;
        }
        else if(preferredTarget.equalsIgnoreCase("ServiceTime")){
            preferredIndex = 3;
        }
        else if(preferredTarget.equalsIgnoreCase("ServiceCost")){
            preferredIndex = 4;
        }
        else if(preferredTarget.equalsIgnoreCase("ServiceLoadDegree")){
            preferredIndex = 5;
        }
        else if(preferredTarget.equalsIgnoreCase("UserAvgEvaluation")){
            preferredIndex = 6;
        }
        //若没有选择偏好指标，下标为-1<0
        return preferredIndex - 1;
    }

    /**
     * 初始化一个判断矩阵
     * preferredTarget    //需要偏好的下标
     * @return
     */
    public Matrix getMatrix(){
        double[][] temp = judgeMatrix.getData();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                temp[i][j] = 0;
            }
        }

        int preferredIndex = getPreferredIndex();  //需要偏好的下标
        if(preferredIndex < 0){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    temp[i][j] = 1;
                }
            }
        }
        else{
            Random rand = new Random();
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(i == preferredIndex){
                        temp[i][j] = rand.nextInt(9) + 1;  //1-9的随机数
                    }
                    if(i == j){
                        temp[i][j] = 1;
                    }
                }
            }
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(temp[i][j] == 0){
                        if(temp[j][i] != 0){
                            temp[i][j] = 1 / temp[j][i];
                        }
                        else{
                            temp[i][j] = rand.nextInt(9) + 1;  //1-9的随机数
                            temp[j][i] = 1 / temp[i][j];
                        }
                    }
                }
            }
        }

        judgeMatrix.setData(temp);
        return judgeMatrix;
    }

    /**
     * 重新构造判断矩阵
     * @return
     */
    public Matrix correctMatrix(){
        return getMatrix();
    }

    /**
     * 检查判断矩阵的一致性
     * @return
     */
    public boolean checkConsistency(){
        Matrix featureVector = judgeMatrix.featureVector(judgeMatrix);
        double featureRoot = judgeMatrix.featureRoot(judgeMatrix, featureVector);
        double ci = (featureRoot - n) / (n - 1);
        double ri = ConstantUtil.getRi();//矩阵维数n为6时，平均随机一致性指标的取值
        double cr = ci / ri;
        if(cr > 0.1){
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * 获取权重矩阵
     * @return
     */
    public Matrix getWeights(){
        getMatrix();
        Matrix featureVector = new Matrix(n, 1); //特征向量即为属性权重

        int maxCorrect = 5, count = 0;  //(设置一个最大的修正次数)
        while(count <= maxCorrect){
            if(checkConsistency()){
                featureVector = judgeMatrix.featureVector(judgeMatrix); //特征向量即为属性权重
                return featureVector;
            }
            else{
                //需要对判断矩阵进行修正
                correctMatrix();
                count++;
            }
        }

        //找不到合适的判断矩阵，采取属性权重平均，偏好属性取0.5；若没有偏好属性，就全部平均权重
        double[][] temp = featureVector.getData();
        int preferredIndex = getPreferredIndex();
        if(preferredIndex < 0){
            for(int i = 0; i < n; i++){
                temp[i][0] = 1 / n;
            }
        }
        else{
            for(int i = 0; i < n; i++){
                temp[i][0] = (1 - 0.5) / (n - 1);
            }
            temp[preferredIndex][0] = 0.5;
        }
        featureVector.setData(temp);

        return featureVector;
    }

}
