import java.math.BigInteger;

public class Main {
    public static Boolean fermatTest(BigInteger P){
        boolean pass = false;
        BigInteger two = new BigInteger("2");
        if (two.modPow(P.subtract(BigInteger.ONE),P).compareTo(BigInteger.ONE) == 0){
            pass = true;
        } else{
            pass = false;
        }
        return pass;
    }

    public static void main(String[] args) {
        final long startTime = System.nanoTime();
        BigInteger p = BigInteger.ONE;
        BigInteger k = new BigInteger("1");

        //BigInteger eleven = new BigInteger("11");
        BigInteger two = new BigInteger("2");
        int exp = 150;
        p = BigInteger.TEN.pow(exp).add(BigInteger.ONE);
        //k = k.add(BigInteger.ONE);
        BigInteger div = (p.subtract(BigInteger.ONE)).divide(two);


        Boolean pass = false;
        while (!pass) {
            if (fermatTest(p) == false){
                p = p.add(two);
                k = k.add(two);
                div = p.subtract(BigInteger.ONE).divide(two);
            }
            else if (fermatTest(div) == false){
                p = p.add(two);
                k = k.add(two);
                div = (p.subtract(BigInteger.ONE).divide(two));
            } else{
                pass = true;
            }

            //count--;
        }
        final long duration = System.nanoTime() - startTime;
        System.out.println("p = " + p);
        System.out.println("k = "+ k);
        System.out.println("Running Time = " + duration/1000000000 + " seconds or " + duration + " nanoseconds");

    }
}
