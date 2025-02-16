public class Main {
    public static void main(String[] args) {
        String s1 = "toned";
        String s2 = "roses";
        int tavolsag = Hamming.hammingDist(s1, s2);
        if (tavolsag == -1) {
            System.out.println("A ket sztring hossza nem egyezik meg, nem szamithato ki a Hamming-tavolsag.");
        } else {
            System.out.println("A Hamming-tavolsag: " + tavolsag);
        }
    }
}
