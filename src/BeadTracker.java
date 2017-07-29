/******************************************************************************
 * Name: Justin Tran 
 * NetID: jctran 
 * Precept: P09
 * 
 * Description: Tracks beads and their movement from one frame of a video to
 * the next. Prints the distance change of each bead after each frame change.
 ******************************************************************************/
public class BeadTracker 
{
    public static void main(String[] args) 
    {
        // Inputs for min mass, brightness and greatest distance change (delta)
        int min = Integer.parseInt(args[0]);
        double tau = Double.parseDouble(args[1]);
        double delta = Double.parseDouble(args[2]);

        // Prints distance from bead in the first frame to the next frame
        for (int i = 3; i < args.length - 1; i++) 
        {
            // Frame at time t and the next frame
            Picture frame = new Picture(args[i]);
            Picture framePlus = new Picture(args[i + 1]);
            
            // Beads from time t and the next frame with minimum brightness tau
            BeadFinder frameBeadFinder = new BeadFinder(frame, tau);
            BeadFinder framePlusBeadFinder = new BeadFinder(framePlus, tau);
            
            // Arrays of blobs from first frame and the next frame
            Blob[] frameBeads = frameBeadFinder.getBeads(min);
            Blob[] framePlusBeads = framePlusBeadFinder.getBeads(min);
            
            // Determines smallest dist from every bead in next frame to current 
            // frame. Prints distance that each bead moves between frames
            for (Blob framePlusB : framePlusBeads)
            {
                double smallDist = Double.POSITIVE_INFINITY;
                
                // If dist between beads is smaller, sets that as smallest dist
                for (Blob frameB : frameBeads) 
                {
                    double dist = framePlusB.distanceTo(frameB);
                    if (dist < smallDist && dist <= delta)
                        smallDist = dist; 
                }
                // Prints dist change between frames if smaller than delta
                if (smallDist <= delta)
                    StdOut.printf("%.4f\n", smallDist);
            }         
        }
    }
}
