public abstract class Number{
  public abstract double getValue();

  public boolean equals(Number other){
    if (this.getValue() == 0){
      if (other.getValue() == 0){
        return true;
      }
    }
    if ( (Math.abs(this.getValue()*1.00001) >= Math.abs(other.getValue())) && (Math.abs(this.getValue()*.99999) <= Math.abs(other.getValue())) ){
      return true;
    }
    return false;
  }

  public int compareTo (Number other){
    if (this.equals(other) ) {
      return 0;
    }
    else if (this.getValue() < other.getValue() ){
      return -1;
    }
    return 1;
  }
}
