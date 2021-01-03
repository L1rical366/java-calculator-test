package org.itstep;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void kata1() {
        Assert.assertEquals(String.valueOf(0), Calculator.add(null));
        Assert.assertEquals(String.valueOf(0), Calculator.add(""));
        Assert.assertEquals(String.valueOf(1), Calculator.add("1"));
        Assert.assertEquals(String.valueOf(3), Calculator.add("1,2"));
        Assert.assertEquals(String.valueOf(4), Calculator.add("4,"));
    }

    @Test
    public void kata2(){
        Assert.assertEquals(String.valueOf(6), Calculator.add("1,2,3"));
        Assert.assertEquals(String.valueOf(4), Calculator.add("1,1,1,1"));
        Assert.assertEquals(String.valueOf(3), Calculator.add(" 1,2 "));
        Assert.assertEquals(String.valueOf(66), Calculator.add("11,22,33"));
    }

    @Test
    public void kata3(){
        Assert.assertEquals(String.valueOf(6), Calculator.add("1 \n2,3"));
        Assert.assertEquals(String.valueOf(15), Calculator.add("4\n5\n6"));
        Assert.assertEquals(String.valueOf(77), Calculator.add("77\n"));
    }

    @Test
    public void kata4() {
        Assert.assertEquals(String.valueOf(1), Calculator.add("1, 1001"));
        Assert.assertEquals(String.valueOf(2), Calculator.add("1002 \n 2"));
        Assert.assertEquals(String.valueOf(1001), Calculator.add("1, 1000"));
        Assert.assertEquals(String.valueOf(2000), Calculator.add("1000, 1000"));
        Assert.assertEquals(String.valueOf(0), Calculator.add("1001, 1001"));
    }

    @Test
    public void kata5(){
        Assert.assertEquals(String.valueOf(3), Calculator.add("//;\n1; 2"));
        Assert.assertEquals(String.valueOf(5), Calculator.add("//* \n2,3"));
        Assert.assertEquals(String.valueOf(7), Calculator.add("//#\n3# 4"));
        Assert.assertEquals(String.valueOf("throw SpliterFormatException"), Calculator.add("//1\n1 1 1"));
        Assert.assertEquals(String.valueOf("throw SpliterFormatException"), Calculator.add("//;\n1#2"));
    }

    @Test
    public void kata6(){
        Assert.assertEquals(String.valueOf(6), Calculator.add("//[***]\n1 *** 2 *** 3"));
        Assert.assertEquals(String.valueOf(20), Calculator.add("//[xy]\n3xy4xy5xy8"));
    }

    @Test
    public void kata7(){
        Assert.assertEquals(String.valueOf(6), Calculator.add("// [*] [%] \n1*2%3"));
        Assert.assertEquals(String.valueOf(8), Calculator.add("// [&&] [|||] \n3|||2&&3"));
    }

    @Test
    public void kata8(){
        Assert.assertEquals(String.valueOf(14), Calculator.add("//[#$]\n1#$2 #$ 3", "// [&&] [|||] \n3 |||2 &&3"));
        Assert.assertEquals(String.valueOf(10), Calculator.add("1", "1,2", "1\n2,3"));
    }

    @Test
    public void kata9(){
        Assert.assertEquals(String.valueOf("throw NumberNegativException"), Calculator.add("1, – 1"));
        Assert.assertEquals(String.valueOf("throw NumberNegativException"), Calculator.add(" – 1, 1"));
        Assert.assertEquals(String.valueOf("throw NumberNegativException"), Calculator.add(" – 1, – 1"));
        Assert.assertEquals(String.valueOf("throw NumberNegativException"), Calculator.add(" – 1,1\n – 1"));
    }

    @Test
    public void kata10() {
        Assert.assertEquals(String.valueOf(6), Calculator.add("// [*] [%] \n1 * 2% 3"));
        Assert.assertEquals(String.valueOf(8), Calculator.add("// [&&] [|||]\n3 |||2 &&3"));
        Assert.assertEquals(String.valueOf(7), Calculator.add("// [//] \n 1//2//4"));
        Assert.assertEquals(String.valueOf(1998), Calculator.add("999,999"));
        Assert.assertEquals(String.valueOf(3), Calculator.add("3,1001"));
        Assert.assertEquals(String.valueOf(6), Calculator.add("// [*] [%][] \n1 * 2% 3"));
    }

    @Test
    public void kata11(){
        Assert.assertEquals(String.valueOf(6), Calculator.add("2^, 2"));
        Assert.assertEquals(String.valueOf(10), Calculator.add("3^\n1"));
        Assert.assertEquals(String.valueOf(8), Calculator.add("2^2, 2^2"));
    }

    @Test
    public void kata12(){
        Assert.assertEquals(String.valueOf(10), Calculator.add("2^3, 2"));
        Assert.assertEquals(String.valueOf(31), Calculator.add("3^3\n2^2"));
        Assert.assertEquals(String.valueOf(257), Calculator.add("//;\n1; 2^8"));
    }
}
