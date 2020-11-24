public class RationalNumber extends RealNumber{
  private int numerator, denominator;

  public RationalNumber(int nume, int deno){
    super(0.0);
    if ( deno == 0){
      numerator = 0;
      denominator = 1;
    }
    else if (nume < 0 && deno <0){
      numerator = nume * -1;
      denominator = deno * -1;
    }
    else{
      numerator = nume;
      denominator = deno;
    }
    reduce ();
  }

  public double getValue(){
    return numerator * 1.0 / denominator;
  }

  public int getNumerator(){
    return numerator;
  }

  public int getDenominator(){
    return denominator;
  }

  public RationalNumber reciprocal(){
    RationalNumber FlipTheNum = new RationalNumber(this.getDenominator(),this.getNumerator());
    return FlipTheNum;
  }

  public boolean equals(RationalNumber other){
    if ( (this.getNumerator() == other.getNumerator() ) && (this.getDenominator() == other.getDenominator() ) ) {
      return true;
    }
    else{
      return false;
    }
  }

  public String toString(){
    return "" + this.getNumerator() + "/" + this.getDenominator();
  }

  private static int gcd(int a, int b){
    int greater = 0;
    int smaller = 0;
    if (a > b){
      greater = a;
      smaller = b;
    }
    else{
      greater = b;
      smaller = a;
    }
    while (greater % smaller != 0){
      int divisor = greater/smaller;
      int remainder = greater - (smaller * divisor);
      greater = smaller;
      smaller = remainder;
    }
    return smaller;
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    int gcd = gcd(numerator,denominator);
    numerator = numerator / gcd;
    denominator = denominator / gcd;
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    return null;
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    return null;
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    return null;
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    return null;
  }
}
