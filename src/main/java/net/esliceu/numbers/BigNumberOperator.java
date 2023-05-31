package net.esliceu.numbers;

public interface BigNumberOperator {


    default <BigNumber> String add(BigNumber secondBigNumber){
            String numero1 = this.toString();
            String numero2 = secondBigNumber.toString();
            boolean mayora9 = false;
            String zeros = "";
            String resSuma = "";
            int longitud;
            if (numero1.length() > numero2.length()){
                longitud = numero1.length();
            } else longitud = numero2.length();

            if (numero1.length() < numero2.length()){
                for (int i = 0; i < longitud - numero1.length(); i++) {
                    zeros += "0";
                }
                numero1 = zeros + numero1;
            } else if (numero1.length() > numero2.length()){
                for (int i = 0; i < longitud - numero2.length(); i++) {
                    zeros += "0";
                }
                numero2 = zeros + numero2;
            }

            for (int i = longitud - 1; i > -1; i--) {
                int num1  = Character.getNumericValue(numero1.charAt(i));
                int num2 = Character.getNumericValue(numero2.charAt(i));
                if (mayora9){
                    num1 += 1;
                    mayora9 = false;
                }
                num1 += num2;
                if (num1 > 9){
                    num1 -= 10;
                    mayora9 = true;
                }
                resSuma = num1 + resSuma;
            }
            if (mayora9) resSuma = "1" + resSuma;
            return  (resSuma);


    };

   default <BigNumber> String subtract(BigNumber secondBigNumber){

       return null;
   };
}
