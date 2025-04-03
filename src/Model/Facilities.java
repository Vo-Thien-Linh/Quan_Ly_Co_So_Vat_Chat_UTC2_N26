package Model;
<<<<<<< HEAD

public abstract class Facilities {
    private String id;
    private String status;
    private static int idCounter = 0;

    public Facilities(String status) {
        this.id = "VC" + (++idCounter);
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public abstract void displayInformation();
}
=======
 
 public abstract class Facilities {
     private String id;
     private String status;
     private static int idCounter = 0;
 
     public Facilities(String status) {
         this.id = "VC" + (++idCounter);
         this.status = status;
     }
 
     public String getId() {
         return id;
     }
 
     public String getStatus() {
         return status;
     }
 
     public void setStatus(String status) {
         this.status = status;
     }
 
     public abstract void displayInformation();
 }
>>>>>>> Tinh-nang-dang-nhap
