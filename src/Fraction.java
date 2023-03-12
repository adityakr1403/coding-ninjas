public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator == 0) {
//            todo error
        }
        this.denominator = denominator;
        simplify();
    }

    private void simplify() {
        int gcd = getGCD(Math.abs(this.numerator), Math.abs(this.denominator));
        this.numerator = this.numerator / gcd;
        this.denominator = this.denominator / gcd;
    }

    private int getGCD(int numerator, int denominator) {
        if (denominator == 0) {
            return numerator;
        }
        int smaller = Math.min(numerator, denominator);
        int larger = Math.max(numerator, denominator);
        int remainder = larger % smaller;
        return getGCD(smaller, remainder);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
        simplify();
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
        simplify();
    }

    public void print() {
        System.out.println(this.numerator + "/" + this.denominator);
    }

    public void add(Fraction f2) {
        this.numerator = this.numerator * f2.denominator + this.denominator * f2.numerator;
        this.denominator = this.denominator * f2.denominator;
        simplify();

    }

    public void multiply(Fraction f2) {
        this.numerator = this.numerator * f2.numerator;
        this.denominator = this.denominator * f2.denominator;
        simplify();
    }
}
