package Pacchetto;
public class main{
static class Spectator implements Runnable {
    private int id;
    private Cinema cinema;
    
    public Spectator(int id, Cinema cinema) {
        this.id = id;  
        this.cinema = cinema; 
    }

    @Override
    public void run() {
        // si prova a prenotare un posto
        boolean success = cinema.bookSeat(id);
        if (!success) {
            System.out.println("Spettatore " + id + " non ha trovato posti disponibili.");
        }
    }
}

public static void main(String[] args) throws InterruptedException {
    
    Cinema cinema = new Cinema();

    // Si creano 7 spettatori (thread)
    Thread[] spectators = new Thread[7];
    for (int i = 0; i < spectators.length; i++) {
        spectators[i] = new Thread(new Spectator(i + 1, cinema)); 
        spectators[i].start();  
    }
    Thread.sleep(10000);  
    // Si mostra la matrice finale dei posti
    cinema.displaySeats();

    
    for (Thread spectator : spectators) {
        spectator.join();  // Si aspettiamo che ogni thread finisca
    }
}
}