package by.losik.Lab1sem4aois;

import java.util.HashMap;

public class FloatingPoint extends BinaryNumber{
    protected HashMap<Integer, Integer> exponent = new HashMap<>();
    @Override
    public void setSign(int sign) {
        super.setSign(sign);
    }

    protected HashMap<Integer, Integer> mantissa = new HashMap<>();

    public void setMantissa(HashMap<Integer, Integer> mantissa) {
        this.mantissa = mantissa;
    }

    public void setExponent(HashMap<Integer, Integer> exponent) {this.exponent = exponent;}
    @Override
    public double getDecimal() {
        int exponent = this.exponent.entrySet().stream().mapToInt(x -> (int) (x.getValue() * Math.pow(2, x.getKey()))).sum();
        double mantissaForCalc = this.mantissa.entrySet().stream().mapToDouble(x -> x.getValue() * Math.pow(2, x.getKey())).sum();

        System.out.println(mantissaForCalc + " " + exponent);
        return sign == 0 ? mantissaForCalc*Math.pow(2, exponent) : -mantissaForCalc*Math.pow(2, exponent);
    }

    public FloatingPoint convertBinaryFixedToFloating(BinaryNumber binaryNumber){
        FloatingPoint floatingPoint = new FloatingPoint();
        int exp = 15;
        while(binaryNumber.getBinaryNumber().get(exp) != 1) {
            --exp;
        }
        int shift = exp;
        if(exp < 0){
            exp = 127 - Math.abs(exp);
        }

        int index = 0;
        while(exp != 0 && index <= 7){
            floatingPoint.exponent.put(index++,Math.floorMod(exp, 2));
            exp = Math.floorDiv(exp,2);
        }

        for(int i =7;i>=0;--i){
            floatingPoint.exponent.putIfAbsent(i, 0);
        }
        for(int i = 0; i > -33; i--){
            floatingPoint.mantissa.put(i,binaryNumber.getBinaryNumber().getOrDefault(shift--, 0));
        }
        for (int i = 0; i > -33; i--){
            floatingPoint.mantissa.putIfAbsent(i,0);
        }
        floatingPoint.setSign(binaryNumber.getSign());
        return floatingPoint;
    }

    @Override
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[" + sign + " ");
        StringBuffer stringBuffer1 = new StringBuffer();
        exponent.entrySet().stream().forEach(x -> stringBuffer1.append(x.getValue()));
        stringBuffer.append(stringBuffer1.reverse()+" ");
        for(int i =0;i> -33;--i){
            stringBuffer.append(mantissa.get(i));
        }
        stringBuffer.append("]");
        return String.valueOf(stringBuffer);
    }
}
