/******************************************************************************
 *  Name:    Justin Tran
 *  NetID:   jctran
 *  Precept: P09
 * 
 *  Description: Designates a blob of a minimum designated number of pixels as 
 *  a bead. Takes in a picture containing blobs and determines which blobs can
 *  be considered beads using a recursive depth-first search algorithm.
 ******************************************************************************/
import java.awt.Color;

public class BeadFinder 
{
    private Queue<Blob> blobs; // Queue containing all blobs found in image
    private int picHeight; // Height of picture in pixels
    private int picWidth; // Width of picture in pixels
    // Marks all pixels above minimum luminance and have not been visited by DFS
    private boolean[][] brightUnvisited; 
    
    // Creates BeadFinder object of all blobs found in image
    public BeadFinder(Picture picture, double tau) 
    {
        blobs = new Queue<Blob>();
        picHeight = picture.height();
        picWidth = picture.width();
        // Rows of 2D array is vertical pixels and columns are horizontal pixels
        brightUnvisited = new boolean[picHeight][picWidth];

        // Go through all pixels to see if they're above minimum tau luminance
        for (int h = 0; h < picHeight; h++)
            for (int w = 0; w < picWidth; w++) 
            {
                Color pixelClr = picture.get(w, h); // Color of single pixel
                if (Luminance.intensity(pixelClr) >= tau)
                    brightUnvisited[h][w] = true; // true if above minimum tau
                else
                    brightUnvisited[h][w] = false; // false if below minimum tau
            }

        // Goes through each pixel and if bright enough, constructs a new blob
        // using DFS before adding blob to list of potential beads
        for (int i = 0; i < picHeight; i++)
            for (int j = 0; j < picWidth; j++)
                if (brightUnvisited[i][j]) // If pixel was marked true before
                {
                    Blob current = new Blob(); // Make new blob
                    this.dfs(current, i, j); // Recursively constructs blob
                    blobs.enqueue(current); // Add blob to list of possible bead
                }
    }
    
    // Recursive depth first search adds pixel to blob if unvisited and bright
    private void dfs(Blob current, int x, int y)
    {
        if (x < 0 || x >= picHeight || y < 0 || y >= picWidth)
            return; // Stops searching if out of bounds of picture's dimensions
        if (!brightUnvisited[x][y])
            return; // Stops searching if pixel is not bright or already visited

        current.add(y, x); // Adds current pixel to given blob
        brightUnvisited[x][y] = false; // Marks pixel as now being visited

        // Searches all adjacent pixels in four cardinal directions recursively
        dfs(current, x, y + 1);
        dfs(current, x, y - 1);
        dfs(current, x + 1, y);
        dfs(current, x - 1, y);
    }

    // Returns all blobs that qualify as beads (>= min mass)
    public Blob[] getBeads(int min) 
    {
        // Determine number of beads of minimum size
        int size = 0; 
        for (Blob b : blobs)
            if (b.mass() >= min)
                size++;

        Blob[] beads = new Blob[size]; // Will hold blobs that qualify as beads

        // If blob in queue is min size or greater, add it to an array
        int i = 0;
        for (Blob b : blobs)
            if (b.mass() >= min) 
            {
                beads[i] = b;
                i++;
            }

        return beads; // Return the array of beads in the image
    }

    // Tests creation of a new BeadFinder and the getBeads method
    public static void main(String[] args) 
    {
        // Minimum mass, minimum brightness, and picture file from command line
        int min = Integer.parseInt(args[0]);
        double tau = Double.parseDouble(args[1]);
        Picture img = new Picture(args[2]);

        // dfs() called and tested in constructor
        BeadFinder picBlobs = new BeadFinder(img, tau); 
        for (Blob bead : picBlobs.getBeads(min)) // Prints all beads from image
            StdOut.println(bead);
    }
}
