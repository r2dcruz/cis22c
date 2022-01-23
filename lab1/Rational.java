package lab1;


/**
 * A class that represents a rational number. 
 * 
 * @author Charles Hoot 
 * @version 4.0
*/

public class Rational
{
    // PUT PRIVATE DATA FIELDS HERE
	// instance variables 
	private int num; // numerator
	private int den; // denominator

    /**
     * The default constructor for objects of class Rational.  Creates the rational number 1.
     */
    public Rational()
    {       
    	num = 1;
    	den = 1;
    } 

    
    /**
     * The alternate constructor for objects of class Rational.  Creates a rational number equivalent to n/d.
     * @param n The numerator of the rational number.
     * @param d The denominator of the rational number.
     */    
    // William & Yimeng
    public Rational(int n, int d)
    {
    	if (d == 0)
    	{
    		throw new ZeroDenominatorException("Denominator is Zero");
    	}
    	
    	else
    	{
    		num = n;
    		den = d;
    	}
    	
    	normalize();
    } // end of constructor
    
    
    /**
     * Get the value of the Numerator
     *
     * @return     the value of the numerator
     */
    public int getNumerator()
    {
        return num;
    }
  
    
    /**
     * Get the value of the Denominator
     *
     * @return     the value of the denominator
     */
    public int getDenominator()
    {
        return den;
    }


    /**
     * Negate a rational number r
     * 
     * @return a new rational number that is negation of this number -r
     */    
    // William
    public Rational negate()
    {               
    	return new Rational(-num, den);
        
    }


    /**
     * Invert a rational number r 
     * 
     * @return a new rational number that is 1/r.
     */ 
    // William
    public Rational invert()
    {               
    	return new Rational(den, num);
    }

    /**
     * Add two rational numbers
     *
     * @param other the second argument of the add
     * @return a new rational number that is the sum of this and the other rational
     */    
    public Rational add(Rational other) // Yimeng
    {
        Rational newRational = new Rational(); // Yimeng
        
        int newNum = (this.num * other.den) + (other.num * this.den); // Yimeng
        int newDen = this.den * other.den;
        
        newRational.num = newNum; // Yimeng
        newRational.den = newDen; // Yimeng
        // normalizing of newRational
        newRational.normalize(); // William
        
        return newRational; // Yimeng
    }
    
     /**
     * Subtract a rational number t from this one r
     *
     * @param other the second argument of subtract
     * @return a new rational number that is r-t
     */    
    public Rational subtract(Rational other) // Yimeng
    {               
        Rational newRational = new Rational(); // Yimeng
        
        int newNum = (this.num * other.den) - (other.num * this.den); // Yimeng
        int newDen = this.den * other.den; // Yimeng
        
        newRational.num = newNum; // Yimeng
        newRational.den = newDen; // Yimeng
        // normalizing the newRational
        newRational.normalize(); // William
        
        return newRational; // Yimeng
    }

    /**
     * Multiply two rational numbers
     *
     * @param other the second argument of multiply
     * @return a new rational number that is the sum of this object and the other rational.
     */    
    public Rational multiply(Rational other) // Yimeng
    {       
        Rational newRational = new Rational(); // Yimeng
        
        int newNum = this.num * other.num; // Yimeng
        int newDen = this.den * other.den; // Yimeng
        
        newRational.num = newNum; // Yimeng
        newRational.den = newDen; // Yimeng
        // normalizing the newRational
        newRational.normalize(); // William
        
        return newRational; // Yimeng
    }
        
 
     /**
     * Divide this rational number r by another one t
     *
     * @param other the second argument of divide
     * @return a new rational number that is r/t
     */    
    
    public Rational divide(Rational other) // William
    {               
        Rational newRational = new Rational(); // Yimeng
       
        newRational = multiply (other.invert()); // William
       
        return newRational; // William
    }
 
 
    /**
     * Put the rational number in normal form where the numerator
     * and the denominator share no common factors.  Guarantee that only the numerator
     * is negative.
     *
     */
    // William
    private void normalize()
    {
    	if (den < 0)
    	{
    		num = num * -1;
    		den = den * -1;
    	}
    	if (num != 0)
    	{
    		// When num is negative value it will throw StackOverflowError if ABS is not used.
    		int norm = gcd(Math.abs(num), den);
    		num = num / norm;
    		den = den / norm;
    	}
    	if (num == 0)
    	{
    		den = 1;
    	}
    }
    		
    
    /**
     * Recursively compute the greatest common divisor of two positive integers
     *
     * @param a the first argument of gcd
     * @param b the second argument of gcd
     * @return the gcd of the two arguments
     */
    private int gcd(int a, int b)
    {
        int result = 0;
        if(a<b)
            result = gcd(b,a);
        else if(b==0)
            result = a;
        else
        {
            int remainder = a % b;
            result = gcd(b, remainder);
        }
        return result;
    }
   

}
