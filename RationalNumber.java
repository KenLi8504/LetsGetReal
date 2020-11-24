public class RationalNumber extends RealNumber{
  private int numerator, denominator;

  public RationalNumber(int nume, int deno){
    super(0.0);
    if ( deno == 0){
      numerator = 0;
      denominator = 1;
    }
    else {
      numerator = nume;
      denominator = deno;
      reduce ();
      if (denominator < 0){
        numerator = numerator * -1;
        denominator = denominator * -1;
      }
    }
    /*
    else if ( deno < 0){
      numerator = nume * -1;
      denominator = deno * -1;
      reduce ();
    }
    else{
      numerator = nume;
      denominator = deno;
      reduce ();
    }
    */
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
    if ( a == 0 || b == 0){
      return 1;
    }
    int pos = 0;
    if (a * b >= 0){
      pos = 1;
    }
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
    if (pos == 0){
      smaller = smaller * -1;
    }
    return smaller;
  }

  private void reduce(){
    int gcd = gcd(numerator,denominator);
      numerator = numerator / gcd;
      denominator = denominator / gcd;
  }

  public RationalNumber multiply(RationalNumber other){
    RationalNumber product = new RationalNumber(this.getNumerator() * other.getNumerator(),this.getDenominator()*other.getDenominator());
    return product;
  }

  public RationalNumber divide(RationalNumber other){
    RationalNumber quotient = new RationalNumber(this.getNumerator() * other.getDenominator(),this.getDenominator()*other.getNumerator());
    return quotient;
  }

  public RationalNumber add(RationalNumber other){
    RationalNumber sum = new RationalNumber ( (this.getNumerator() * other.getDenominator() + this.getDenominator()* other.getNumerator()) , (this.getDenominator() * other.getDenominator() ) );
    return sum;
  }

  public RationalNumber subtract(RationalNumber other){
    RationalNumber difference = new RationalNumber ( (this.getNumerator() * other.getDenominator() - this.getDenominator()*other.getNumerator()) , (this.getDenominator() * other.getDenominator() ) );
    return difference;
  }
}
