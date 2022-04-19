/******************************************************************************
 *  Compilation:  javac MM1Queue.java
 *  Execution:    java MM1Queue lambda mu
 *  Dependencies: Queue.java Histogram.java
 *
 *  Simulate an M/M/1 queue where arrivals and departures are Poisson
 *  processes with arrival rate lambda and service rate mu.
 *
 *  % java MM1Queue .20 .33
 *
 *  % java MM1Queue .20 .25 
 *
 *  % java MM1Queue .20 .21
 *
 *
 *  Remarks
 *  -------
 *   - We assume the interrarrival and service times are independent.
 * 
 *
 ******************************************************************************/

public class MM1Queue { 

    public static void main(String[] args) { 
        double lambda = Double.parseDouble(args[0]);  // arrival rate
        double mu     = Double.parseDouble(args[1]);  // service rate

        Queue<Double> queue  = new Queue<Double>();       // arrival times of customers
        double nextArrival   = StdRandom.exp(lambda);     // time of next arrival
        double nextDeparture = Double.POSITIVE_INFINITY;  // time of next departure

        // double expectedWait = 1.0 / (mu - lambda);        // W = expected time in system

        double totalWait = 0.0;
        long customersServiced = 0;

        // histogram object
        Histogram hist = new Histogram(60 + 1);

        StdDraw.setCanvasSize(1000, 600);
        StdDraw.enableDoubleBuffering();

        // simulate an M/M/1 queue
        while (true) {

            // it's an arrival
            if (nextArrival <= nextDeparture) {
                if (queue.isEmpty()) nextDeparture = nextArrival + StdRandom.exp(mu);
                queue.enqueue(nextArrival);
                nextArrival += StdRandom.exp(lambda);
            }

            // it's a departure
            else {
                double wait = nextDeparture - queue.dequeue();
                hist.addDataPoint(Math.min(60,  (int) (Math.round(wait))));
                totalWait += wait;
                customersServiced++;
                StdDraw.clear();
                hist.draw();
                StdDraw.show();
                StdDraw.pause(30);
                if (queue.isEmpty()) nextDeparture = Double.POSITIVE_INFINITY;
                else                 nextDeparture += StdRandom.exp(mu);
                
            }
        }

    }

}

