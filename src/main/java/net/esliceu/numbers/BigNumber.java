package net.esliceu.numbers;



public class BigNumber implements BigNumberOperator {
    String numero;
    // Constructor 1
    public BigNumber(String s) {
        char c;
        boolean zero = false;
        for (int i = 0; s.length() > i; i++) {

            c = s.charAt(i);
            if (c == '0' & !zero) {
                s = s.substring(1);
                i--;
            } else {
                zero = true;
            }
        }
        this.numero = s;
    }

    // Suma
    public BigNumber add(BigNumber other) {
        String numero1 = this.numero;
        String numero2 = other.toString();
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
        return new BigNumber(resSuma);

    }
    // Resta
    BigNumber sub(BigNumber other) {

        String numero2 = other.toString();
        if (numero.equals(numero2)) return new BigNumber("0");
        boolean menora0 = false;
        String resResta = "";
        String zeros = "";
        int longitud;
        if (this.numero.length() == numero2.length()){
            longitud = this.numero.length();
        } else if (this.numero.length() > numero2.length()){
            longitud = this.numero.length();
        } else longitud = numero2.length();
        if (this.numero.length() < numero2.length()){
            for (int i = 0; i < longitud - this.numero.length(); i++) {
                zeros += "0";
            }
            this.numero = zeros + this.numero;
        } else if (this.numero.length() > numero2.length()){
            for (int i = 0; i < longitud - numero2.length(); i++) {
                zeros += "0";
            }
            numero2 = zeros + numero2;
        }

        for (int i = longitud - 1; i > -1; i--) {
            int num1 = Character.getNumericValue(this.numero.charAt(i));
            int num2 = Character.getNumericValue(numero2.charAt(i));
            if (menora0){
                num1 -= 1;
                menora0 = false;
            }
            num1 -= num2;
            if (num1 < 0){
                num1 += 10;
                menora0 = true;
            }
            resResta = num1 + resResta;
        }
//        if (menora0) resResta = "1" + resResta;
        return new BigNumber(resResta);

    }
    // Multiplica
    BigNumber mult(BigNumber other) {
        String numero1 = this.numero;
        String numero2 = other.toString();
        boolean mayora9 = false;
        String suma = "";
        int temp = 0;
        String zeros = "";
        BigNumber res = new BigNumber("");
        for (int i = numero1.length() -1 ; i >= 0; i--) {
            for (int j = numero2.length() - 1; j >= 0; j--) {
                int num1  = Character.getNumericValue(numero1.charAt(i));
                int num2 = Character.getNumericValue(numero2.charAt(j));

                num1 *= num2;
                if (mayora9){
                    num1 += temp;
                    mayora9 = false;
                }
                if (num1 > 9){
                    temp = num1/10;
                    num1 %= 10;
                    mayora9 = true;

                }
                suma = num1 + suma ;

            }
            suma += zeros;
            if (mayora9) suma = temp + suma;
            res = (new BigNumber(suma).add(res));
            zeros += "0";
            suma = "";
            temp = 0;
        }

        return res;
    }
    // Divideix
    BigNumber div(BigNumber other)  {
        if (new BigNumber(this.numero).compareTo(new BigNumber(other.toString())) < 0){
            return new BigNumber("0");
        } else if (new BigNumber(this.numero).compareTo(new BigNumber(other.toString())) == 0){
            return new BigNumber("1");
        }
        String res = "";
        String temp = "";
        BigNumber resMult ;
        for (int i = 0; i < this.numero.length() ; i++) {
            int numero1 = Character.getNumericValue(this.numero.charAt(i));
            temp += numero1;

            if (new BigNumber(temp).compareTo(other) >= 0){
                for (int j = 1; j <= 10; j++) {
                    resMult = (other.mult(new BigNumber(String.valueOf(j))));

                    if ((resMult).compareTo(new BigNumber(temp)) > 0){
                        res += j-1;
                        temp = String.valueOf(new BigNumber(temp).sub((other.mult(new BigNumber(String.valueOf(j-1))))));

                        break;
                    }
                }

            } else {
                if (res != ""){
                    res += "0";
                }
            }

        }
        return new BigNumber(res);
    }
    // Arrel quadrada
    BigNumber sqrt() {
        BigNumber temp;

        BigNumber sr = (new BigNumber(this.numero).div(new BigNumber("2")));
        do {
            temp = sr;
            BigNumber a = (new BigNumber(numero).div((temp)));
            BigNumber b = (temp.add(a));
            sr = ((b).div(new BigNumber("2")));
        } while (!String.valueOf((temp).sub((sr))).equals(""));

        return (sr);
    }
    // Potència
    BigNumber power(int n) {
        String res = this.numero;
        for (int i = 0; i < n-1; i++) {
            res = String.valueOf(new BigNumber(res).mult(new BigNumber(this.numero)));
        }
        return new BigNumber(res);
    }
    // Factorial
    BigNumber factorial() {
        BigNumber res = new BigNumber("1");
        for (int i = 1; i <= Integer.parseInt(numero); i++) {
            res = res.mult(new BigNumber(String.valueOf(i)));
        }
        return res;
    }
    // MCD. Torna el Màxim comú divisor
    BigNumber mcd(BigNumber other) {

        BigNumber temp;
        BigNumber num1 = new BigNumber(this.numero);
        BigNumber num2 = other;
        while (!String.valueOf(num2).equals("")){
            temp = num2;
            num2 = num1.sub(num1.div(num2).mult(num2));
            num1 = temp;
        }

        return num1;
    }
    // Compara dos BigNumber. Torna 0 si són iguals, -1
// si el primer és menor i torna 1 si el segon és menor
    public int compareTo(BigNumber other) {
        if (this.numero.length() < other.toString().length()) return -1;
        if (this.numero.length() > other.toString().length()) return 1;
        for (int i = 0; i < other.toString().length(); i++) {
            if (this.numero.charAt(i) < other.toString().charAt(i)) return -1;
            if (this.numero.charAt(i) > other.toString().charAt(i)) return 1;
        }

        return 0;
    }
    // Torna un String representant el número
    public String toString() {
        return this.numero;
    }
    // Mira si dos objectes BigNumber són iguals
    public boolean equals(Object other) {
        return this.numero.equals(other.toString());
    }
}