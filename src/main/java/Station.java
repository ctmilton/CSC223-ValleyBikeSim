public class Station {
    private int id;
    private int bike;
    private String name;
    private int pedelecs;
    private int availableDocks;
    private int maintainenceReq;
    private int capacity;
    private boolean kiosk;
    private String address;
    
    
    public Station(int id,String name,int bike, int pedelecs,int availableDocks,int maintainenceReq,int capacity,boolean kiosk,String address) {
        this.id = id;
        this.bike = bike;
        this.name = name;
        this.pedelecs = pedelecs;
        this.availableDocks = availableDocks;
        this.maintainenceReq = maintainenceReq;
        this.capacity = capacity;
        this.kiosk = kiosk;
        this.address = address;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getBike() {
        return bike;
    }
    public void setBike(int bike) {
        this.bike = bike;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPedelecs() {
        return pedelecs;
    }
    public void setPedelecs(int pedelecs) {
        this.pedelecs = pedelecs;
    }
    public int getAvailableDocks() {
        return availableDocks;
    }
    public void setAvailableDocks(int availableDocks) {
        this.availableDocks = availableDocks;
    }
    public int getMaintainenceReq() {
        return maintainenceReq;
    }
    public void setMaintainenceReq(int maintainenceReq) {
        this.maintainenceReq = maintainenceReq;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public boolean isKiosk() {
        return kiosk;
    }
    public void setKiosk(boolean kiosk) {
        this.kiosk = kiosk;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
       public static String padString(String str, int leng) {
           for (int i = str.length(); i <= leng; i++)
               str += " ";
           return str;
       }
      public String printStation() {
        System.out.println(id+" | "+padString(name,32)+" | "+bike+"   |"+pedelecs+"         | "+availableDocks+"              | "+maintainenceReq+"              | "+capacity+"           | "+kiosk+"          | "+address);
        return(id+name+bike+pedelecs+availableDocks+maintainenceReq+capacity+kiosk+address);
      }
    
}
