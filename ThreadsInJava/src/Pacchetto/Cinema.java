package Pacchetto;

public class Cinema {
    // Definiamo il cinema con 15 file da 46 posti
    private final int rows = 15;
    private final int seatsPerRow = 46;
    
    // Creiamo una matrice per tenere traccia dei posti prenotati
    private boolean[][] seats = new boolean[rows][seatsPerRow];

    // Metodo sincronizzato per prenotare un posto, partendo dall'inizio perchè dal centro è difficile :(
    public synchronized boolean bookSeat(int spectatorId) {
        for (int row = 0; row < rows; row++) {
            for (int seat = 0; seat < seatsPerRow; seat++) {
                if (!seats[row][seat]) { 
                    seats[row][seat] = true; 
                    System.out.println("Thread numero " + spectatorId + " ha prenotato il"+(seat + 1)+"° posto " +   ", fila " + (row + 1) );
                    return true;  
                }
            }
        }
        return false; 
    }

    public synchronized int availableSeats() {
        int count = 0;
        
        for (int row = 0; row < rows; row++) {
            for (int seat = 0; seat < seatsPerRow; seat++) {
                if (!seats[row][seat]) {
                    count++;  
                }
            }
        }
        return count;
    }

    // Metodo sincronizzato per visualizzare la matrice dei posti
    public synchronized void displaySeats() {
        System.out.println("\nRappresentazione grafica posti: (1 sta per occupato, 0 per libero):");
        for (int row = 0; row < rows; row++) {
            for (int seat = 0; seat < seatsPerRow; seat++) {
                // Stampa 1 se il posto è occupato, 0 se è libero
            	
                System.out.print((seats[row][seat] ? 1  : 0 ) + " ");
            }
            System.out.println();  
        }
    }}