public class Exercise_16_17 {
    public static class Rational {
        private int Numerator;
        private int Denominator;

        public Rational(int numerator, int denominator) {
            if (denominator == 0)
                throw new ArithmeticException("denominator is zero");

            int gcd = gcd(numerator, denominator);
            Numerator = numerator / gcd;
            Denominator = denominator / gcd;

            if (denominator < 0) {
                Denominator = -Denominator;
                Numerator = -Numerator;
            }
        }

        public int getNumerator() {
            return Numerator;
        }

        public int getDenominator() {
            return Denominator;
        }

        // sum of this number and b
        public Rational plus(Rational b) {
            assert isPlusOverflow(Numerator * b.Denominator, Denominator * b.Numerator) : "plus  overflow";
            assert isTimesOverflow(Denominator, b.Denominator) : "times overflow";

            int Den = Denominator * b.Denominator;
            int Num = Numerator * b.Denominator + Denominator * b.Numerator;
            Rational temp = new Rational(Num, Den);
            return temp;
        }

        // difference of this number and b
        public Rational minus(Rational b) {
            int Den = this.Denominator * b.Denominator;
            int Num = this.Numerator * b.Denominator - this.Denominator * b.Numerator;

            Rational temp = new Rational(Num, Den);

            return temp;
        }

        // product of this number and b
        public Rational times(Rational b) {
            assert isTimesOverflow(Denominator, b.Denominator) : "times overflow";
            assert isTimesOverflow(Numerator, b.Numerator) : "times overflow";
            int Den = Denominator * b.Denominator;
            int Num = Numerator * b.Numerator;
            Rational temp = new Rational(Num, Den);
            return temp;
        }

        // quotient of this number and b
        public Rational divides(Rational b) {
            Rational remainder = new Rational(b.Denominator, b.Numerator);
            Rational temp = this.times(remainder);
            return temp;
        }


        // is this number equal to that ?
        public Boolean equals(Rational that) {
            if (that == null) return false;
            if (that.getClass() != this.getClass()) return false;
            return this.compareTo(that) == 0;
        }


        private int compareTo(Rational that) {
            long lhs = (long) this.Numerator * that.Denominator;
            long rhs = (long) this.Denominator * that.Numerator;
            return Long.compare(lhs, rhs);
        }

        private int gcd(int a, int b) {
            if (b < 0) b = -b;
            if (a < 0) a = -a;
            if (a % b == 0) return b;
            else return gcd(b, a % b);
        }

        /**
         * @return true if the program continues, false if an exception is thrown
         */
        private boolean isPlusOverflow(int a, int b) {
            if (a > 0 && b > 0)
                return !(a + b < 0);
            else if (a < 0 && b < 0) {
                return !(a + b > 0);
            }
            return true;
        }

        /**
         * @return true The program goes smoothly without starting, assert false Start assertion
         */
        private boolean isTimesOverflow(int a, int b) {
            if (a < 0) {
                a = -a;
            }
            if (b < 0) {
                b = -b;
            }
            if (a == 0 || b == 0) {
                return true;
            } else {
                return !(a * b < 0);
            }
        }

        @Override
        public String toString() {
            if (getDenominator() == 1) return getNumerator() + "";
            else return getNumerator() + "/" + getDenominator();

        }
    }

    public static void main(String[] args) {
        int a = -2147483647;
        int b = 1;
        Rational rational = new Rational(a, b);
        Rational rational1 = new Rational(2, b);
        Rational rational2 = new Rational(3, 5);
        Rational temp = rational.plus(rational1);
        System.out.println(temp);
        temp = rational.minus(rational1);
        System.out.println(temp);
        temp = rational.times(rational1);
        System.out.println(temp);
        temp = rational.divides(rational2);
        System.out.println(temp);
    }
}
