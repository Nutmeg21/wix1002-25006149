public class Q2c {
    public static void main(String[] args) {
        Playable[] instruments = new Playable[2];
        instruments[0] = new Guitar();
        instruments[1] = new Piano();
        for (Playable instrument : instruments)
        {
            instrument.play();
        }
    }
}

interface Playable {
    public void play();
}

class Guitar implements Playable {
    public void play()
    {
        System.out.println("Playing Guitar");
    }
}

class Piano implements Playable {
    public void play()
    {
        System.out.println("Playing Piano");
    }
}