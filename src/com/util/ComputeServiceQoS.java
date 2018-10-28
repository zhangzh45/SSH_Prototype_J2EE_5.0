package com.util;

import com.bean.Service;

//计算服务的QoS
public class ComputeServiceQoS {
    String construct;
    Service aSer = new Service();
    Service bSer = new Service();
    ServiceQos qos = new ServiceQos();

    public String construct(){

    }

    //均一化各项指标
    public double getReliability(){
        double reliability = 0.0;
        if(construct != null){
            if(construct.equalsIgnoreCase("sequence")){
                reliability = aSer.getServiceReliability() * bSer.getServiceReliability();
            }
            else if(construct.equalsIgnoreCase("parallel split")){
                reliability = aSer.getServiceReliability() * bSer.getServiceReliability();
            }
            else if(construct.equalsIgnoreCase("synchronization")){
                reliability = aSer.getServiceReliability() * bSer.getServiceReliability();
            }
            else if(construct.equalsIgnoreCase("arbitrary cycles")){
                reliability = aSer.getServiceReliability() * aSer.getServiceReliability();
            }
            else if(construct.equalsIgnoreCase("exclusive choice")){
                reliability = aSer.getServiceReliability() * bSer.getServiceReliability();
            }
            else if(construct.equalsIgnoreCase("synchronizing merge")){
                reliability = aSer.getServiceReliability() * bSer.getServiceReliability();
            }
            else if(construct.equalsIgnoreCase("multiple merge")){
                reliability = aSer.getServiceReliability() * bSer.getServiceReliability();
            }
        }
        return reliability;
    }

    /**
     * 目前无法获得可用性数据
     * @return
     */
    public double getAvailability(){
        double availability = 0.0;
        if(construct != null){
            if(construct.equalsIgnoreCase("sequence")){
                availability = aSer.get() * bSer.getServiceReliability();
            }
            else if(construct.equalsIgnoreCase("parallel split")){
                availability = aSer.getServiceReliability() * bSer.getServiceReliability();
            }
            else if(construct.equalsIgnoreCase("synchronization")){
                availability = aSer.getServiceReliability() * bSer.getServiceReliability();
            }
            else if(construct.equalsIgnoreCase("arbitrary cycles")){
                availability = aSer.getServiceReliability() * aSer.getServiceReliability();
            }
            else if(construct.equalsIgnoreCase("exclusive choice")){
                availability = aSer.getServiceReliability() * bSer.getServiceReliability();
            }
            else if(construct.equalsIgnoreCase("synchronizing merge")){
                availability = aSer.getServiceReliability() * bSer.getServiceReliability();
            }
            else if(construct.equalsIgnoreCase("multiple merge")){
                availability = aSer.getServiceReliability() * bSer.getServiceReliability();
            }
        }
        return availability;
    }

    public double getTime(){
        double time = 0.0;
        if(construct != null){
            double aTime = Double.parseDouble(aSer.getServiceTime());
            double bTime = Double.parseDouble(bSer.getServiceTime());
            if(construct.equalsIgnoreCase("sequence")){
                time = aTime + bTime;
            }
            else if(construct.equalsIgnoreCase("parallel split")){
                time = aTime + bTime;
            }
            else if(construct.equalsIgnoreCase("synchronization")){
                time = aTime + bTime;
            }
            else if(construct.equalsIgnoreCase("arbitrary cycles")){
                time = aTime + bTime;
            }
            else if(construct.equalsIgnoreCase("exclusive choice")){
                time = aTime + bTime;
            }
            else if(construct.equalsIgnoreCase("synchronizing merge")){
                time = aTime + bTime;
            }
            else if(construct.equalsIgnoreCase("multiple merge")){
                time = aTime + bTime;
            }
        }
        return time;
    }

    public double getCost(){
        double cost = 0.0;
        if(construct != null){
            if(construct.equalsIgnoreCase("sequence")){
                cost = aSer.getServiceCost() + bSer.getServiceCost();
            }
            else if(construct.equalsIgnoreCase("parallel split")){
                cost = aSer.getServiceCost() + bSer.getServiceCost();
            }
            else if(construct.equalsIgnoreCase("synchronization")){
                cost = aSer.getServiceCost() + bSer.getServiceCost();
            }
            else if(construct.equalsIgnoreCase("arbitrary cycles")){
                cost = aSer.getServiceCost() + aSer.getServiceCost();
            }
            else if(construct.equalsIgnoreCase("exclusive choice")){
                cost = aSer.getServiceCost() + bSer.getServiceCost();
            }
            else if(construct.equalsIgnoreCase("synchronizing merge")){
                cost = aSer.getServiceCost() + bSer.getServiceCost();
            }
            else if(construct.equalsIgnoreCase("multiple merge")){
                cost = aSer.getServiceCost() + bSer.getServiceCost();
            }
        }
        return cost;
    }

    public double getLoadDegree(){

    }

    public double getUserAvgEvaluation(){

    }
}
