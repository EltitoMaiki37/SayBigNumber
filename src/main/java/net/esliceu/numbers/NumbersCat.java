package net.esliceu.numbers;

public class NumbersCat implements Numbers{
    private  final String[] UNITATS = {"Zero", "Un", "Dos", "Tres", "Quatre", "Cinc", "Sis", "Set", "Vuit", "Nou"};
    private  final String[] DECENES = {"Deu", "Vint", "Trenta", "Quaranta", "Cinquanta", "Seixanta", "Setanta", "Vuitanta", "Noranta"};
    private  final String[] MENORSQUEVINT = {"Onze", "Dotze", "Tretze", "Catorze", "Quinze", "Setze", "Disset", "Divuit", "Dinou"};


    public  String say(long n) {

        if (n < 0) {
            return "Menys " + say(-n).toLowerCase();
        }

        if (n < 10) {
            return UNITATS[(int) n];
        }

        if (n < 20 && n != 10) {
            return MENORSQUEVINT[(int) n - 11];
        }

        if (n < 100) {
            int unitat = (int) n % 10;
            int desena = (int) n / 10;
            if (unitat == 0) {
                return  DECENES[desena - 1];
            }
            if (n < 30) return String.format("%s-i-%s", DECENES[desena-1], UNITATS[unitat].toLowerCase());
            return String.format("%s-%s", DECENES[desena-1], UNITATS[unitat].toLowerCase());
        }

        if (n < 1000){
            return calculaNombre(n, 100, "Cent", "-cents");
        }
        if (n < 1000000){
            return calculaNombre(n, 1000, "Mil", " mil");
        }

        return null;
    }


    private  String calculaNombre(long n, int divisor, String singular, String plural) {
        int quocient = (int) (n / divisor);
        int resto = (int) (n % divisor);
        String espai = " ";

        String resultat;
        if (quocient == 1) {
            resultat = singular;
        } else {
            resultat = say(quocient) + plural;
        }

        if (resto == 0) {
            return resultat;
        }
        return String.format("%s%s%s", resultat, espai, say(resto).toLowerCase());
    }

}