public class BilleteraParque {
    private int tickets;
    private static boolean festivo = false;

    

    public BilleteraParque(){
        tickets = 0;
    }

    public BilleteraParque(int tickets) {
        if(tickets >= 0){
            this.tickets = tickets;
        }else{
            this.tickets = 0;
        }
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        if(tickets >= 0){
            this.tickets = tickets;
        }
        
    }
    public static boolean getFestivo() {
        return festivo;
    }

    public static void setFestivo() {
        festivo = !festivo;
    }


    public void agregarTickets(int cantidadTickets){
        if(cantidadTickets >= 0){
            tickets += cantidadTickets;
        }
    }


    public boolean removerTickets(int cantidadTickets){
        if (cantidadTickets >= 0 && tickets >= cantidadTickets) {
            tickets -= cantidadTickets;
            return true;
            
        } else {
            return false;
        }
    }

}
