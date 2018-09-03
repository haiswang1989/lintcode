package com.lintcode.common;

import java.util.List;

/**
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年7月5日 上午10:38:53
 */
public class NestedIntegerImpl implements NestedInteger {
    
    private boolean isInteger;
    private Integer integer;
    private List<NestedInteger> listNestedInteger;
    
    public NestedIntegerImpl(boolean isIntegerArgs, Integer integerArgs, List<NestedInteger> listNestedIntegerArgs) {
        this.isInteger = isIntegerArgs;
        this.integer = integerArgs;
        this.listNestedInteger = listNestedIntegerArgs;
    }
    
    @Override
    public boolean isInteger() {
        // TODO Auto-generated method stub
        return isInteger;
    }

    @Override
    public Integer getInteger() {
        // TODO Auto-generated method stub
        return integer;
    }

    @Override
    public List<NestedInteger> getList() {
        // TODO Auto-generated method stub
        return listNestedInteger;
    }

}
