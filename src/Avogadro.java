/******************************************************************************
 * Name: Justin Tran 
 * NetID: jctran 
 * Precept: P09
 * 
 * Description: Calculates a self diffusion constant from a read in text file of
 * radial displacements. Calculates a self diffusion constant which is then used
 * to approximate the Boltzmann constant and Avogadro's number.
 ******************************************************************************/
public class Avogadro 
{
    // Constants for calculating Boltzmann constant
    private static final int ABSOLUTE_TEMP = 297;
    private static final double VISCOSITY = 9.135E-4;
    private static final double BEAD_RADIUS = 0.5E-6;
    private static final double GAS_CONSTANT = 8.31446;

    public static void main(String[] args) 
    {
        double selfDiffConst = 0; // To be calc'd from radial displacements
        int displacements = 0; // Number of displacements read in
        
        // Reads in radial displacements and calculates self diffusion constant
        // based on given equation
        while (!StdIn.isEmpty()) 
        {
            double radialDisp = StdIn.readDouble() * 0.175E-6; // Convert to m
            selfDiffConst += Math.pow(radialDisp, 2);
            displacements++;
        }
        selfDiffConst /= (2 * displacements);

        // Approximates boltzmann constant from constants and our self diffusion
        double boltzmann = (6 * Math.PI * VISCOSITY * BEAD_RADIUS
                * selfDiffConst) / ABSOLUTE_TEMP;
        
        // Approximates avogadro's number from gas const and our boltzmann const
        double avogadro = GAS_CONSTANT / boltzmann;

        // Prints our approximated boltzmann constant and avogadro's number
        StdOut.printf("Boltzmann = %.4e\n", boltzmann);
        StdOut.printf("Avogadro  = %.4e", avogadro);
    }
}
