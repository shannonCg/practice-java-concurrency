package com.deadLock;

public class PairTool {
    private final Tool lefthand;
    private final Tool righthand;

    public PairTool(Tool lefthand, Tool righthand){
        this.lefthand = lefthand;
        this.righthand = righthand;
    }

    public String toString(){
        return "[ "+lefthand+" and "+righthand+" ]";
    }
}
