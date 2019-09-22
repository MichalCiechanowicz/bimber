package model;

public class Product {

    public int ID_BIMBER;
    private String rodzaj;
    private String nazwa;
    private String moc;
    private String region;
    private double price;


    public Product(){

    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getMoc() {
        return moc;
    }

    public void setMoc(String moc) {
        this.moc = moc;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(String price) {
     this.price = Double.parseDouble(price);
    }

    public int getIdbimber() {
        return ID_BIMBER;
    }
    public void setIdbimber(String idbimber) {
        this.ID_BIMBER = Integer.parseInt(idbimber);
    }


    @Override
    public String toString() {
        return "Product{" +
                "ID_BIMBER='" + ID_BIMBER + '\'' +
                ", rodzaj='" + rodzaj + '\'' +
                ", nazwa='" + nazwa + '\'' +
                ", moc='" + moc + '\'' +
                ", region='" + region + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

}
