/******************************************************************************
 * Name: Justin Tran 
 * NetID: jctran 
 * Precept: P09
 * 
 * Description: Representation of a set of pixels (connected or unconnected) 
 * defined as a complete set representing a "blob". Has a defined mass and 
 * center of mass coordinates in the x-y plane. Can add to the blob's size.
 ******************************************************************************/
public class Blob 
{
    private int pixCount; // Number of pixels in each blob
    private double xCent; // Center of mass x coordinate of blob
    private double yCent; // Center of mass y coordinate of blob

    // Initializes each blob to be empty and centered at the origin
    public Blob() 
    {
        pixCount = 0;
        xCent = 0.0;
        yCent = 0.0;
    }

    // Adds new pixel to blob and recalculates center of mass coordinates
    public void add(int x, int y) 
    {
        double xSum = xCent * pixCount + x; // Calculates new x coordinates sum
        double ySum = yCent * pixCount + y; // Calculates new y coordinates sum

        pixCount++; // Increment number of pixels after adding new pixel

        xCent = xSum / pixCount; // X center calc'd from Y sum and num of pixels
        yCent = ySum / pixCount; // y center calc'd from Y sum and num of pixels
    }

    // Returns mass of blob
    public int mass() 
    {
        return pixCount; // Blob mass is number of pixels in blob
    }

    // Calculates distance between two blobs using Euclidean distance
    public double distanceTo(Blob that) 
    {
        double xDist = Math.pow(that.xCent - this.xCent, 2);
        double yDist = Math.pow(that.yCent - this.yCent, 2);

        return Math.sqrt(xDist + yDist);
    }

    // Prints blob with mass, X center of mass, Y center of mass all in order
    public String toString() 
    {
        return String.format("%2d (%8.4f, %8.4f)", mass(), xCent, yCent);
    }

    // Tests each instance method by creating two blobs
    public static void main(String[] args) 
    {
        // First blob with four pixels with printed mass and center coordinates
        Blob blobOne = new Blob();
        blobOne.add(100, 100);
        blobOne.add(300, 100);
        blobOne.add(500, 100);
        blobOne.add(1000, 100);
        StdOut.println("First blob mass: " + blobOne.mass());
        StdOut.println("First blob info: " + blobOne);
        
        // Second blob with five pixels with printed mass and center coordinates
        Blob blobTwo = new Blob();
        blobTwo.add(-50, -50);
        blobTwo.add(50, 50);
        blobTwo.add(150, 50);
        blobTwo.add(250, 50);
        blobTwo.add(500, 50);
        StdOut.println("Second blob mass: " + blobTwo.mass());
        StdOut.println("Second blob info: " + blobTwo + "\n");

        // Verify distance between blobs using Pythagorean theorem
        StdOut.println("Dist. between blobs: " + blobOne.distanceTo(blobTwo));
        StdOut.println("Verifying distance using the Pythagorean theorem:");
        double xSquare = Math.pow(blobTwo.xCent - blobOne.xCent, 2);
        double ySquare = Math.pow(blobTwo.yCent - blobOne.yCent, 2);
        double pythDist = Math.sqrt(xSquare + ySquare);
        StdOut.println("X squared distance: " + xSquare);
        StdOut.println("Y squared distance: " + ySquare);
        StdOut.println("Square root of (X + Y) or Distance: " + pythDist);
    }
}