/* * AllBinary Open License Version 1 * Copyright (c) 2006 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.pathfinding;

import org.allbinary.logic.string.StringMaker;
import org.allbinary.string.CommonLabels;

@groovy.transform.CompileStatic
public class PathFindingNodeCostInfo implements Comparable<PathFindingNodeCostInfo> {
    private final PathFindingNodeCostInfoData pathFindingNodeCostInfoData = PathFindingNodeCostInfoData.getInstance();

    public long costFromStartP;

    public long costToEndP;

    //Add coming from costing
    public long totalCostP;

    public PathFindingNodeCostInfo(final long costFromStart, final long costToGoal) throws Exception {
        this.costFromStartP = costFromStart;
        this.costToEndP = costToGoal;
        //this.setTotalCost(totalCost);
        this.setCalculatedTotalCost();
    }

    public void setCostToEnd(final long costToEnd) {
        this.costToEndP = costToEnd;
    }

    public void setTotalCost(final long totalCost) {
        this.totalCostP = totalCost;
    }

    public void setCalculatedTotalCost() throws Exception {
        this.totalCostP = this.costFromStartP + this.costToEndP;
        if (this.totalCostP > this.pathFindingNodeCostInfoData.@MAX_NODE_COST) {
            throw new Exception('Max Cost Exceeded');
        }
    }

    //older library check this method
    public void setCostFromStart(final long cost) {
        //this.costFromStart += cost;
        this.costFromStartP = cost;
    }

    public void addCostFromStart(final long cost) {
        this.costFromStartP += cost;
    }

    @Override
    public int compareTo(PathFindingNodeCostInfo pathFindingNodeCostInfo) {
        //java.lang.Long.compare is not available to the JS build
        if (this.totalCostP < pathFindingNodeCostInfo.@totalCostP) {
            return -1;
        } else if (this.totalCostP > pathFindingNodeCostInfo.@totalCostP) {
            return 1;
        }
        return 0;
    }

    public String toString() {
        final StringMaker stringBuffer = new StringMaker();
        stringBuffer.append(this.getClass().getName());
        stringBuffer.append(CommonLabels.getInstance().@COLON_SEP);
        stringBuffer.append('CostFromStart: ');
        stringBuffer.appendlong(this.costFromStartP);
        stringBuffer.append(' CostToEnd: ');
        stringBuffer.appendlong(this.costToEndP);
        stringBuffer.append(' TotalCost: ');
        stringBuffer.appendlong(this.totalCostP);
        return stringBuffer.toString();
    }

}


