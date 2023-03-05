package Models;

import java.util.Date;

public class SoftwareWorkModel {
    private String no;
    private String isMaddesi;
    private Date talepTarihi;
    private String kullanici;
    private String kullaniciBolumu;
    private Status statu;
    private Date sonDurumTarihi;
    private String analist;
    private String gelistirici;
    private String eta;
    private boolean aktiflik;
    private String aciklama;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getIsMaddesi() {
        return isMaddesi;
    }

    public void setIsMaddesi(String isMaddesi) {
        this.isMaddesi = isMaddesi;
    }

    public Date getTalepTarihi() {
        return talepTarihi;
    }

    public void setTalepTarihi(Date talepTarihi) {
        this.talepTarihi = talepTarihi;
    }

    public String getKullanici() {
        return kullanici;
    }

    public void setKullanici(String kullanici) {
        this.kullanici = kullanici;
    }

    public String getKullaniciBolumu() {
        return kullaniciBolumu;
    }

    public void setKullaniciBolumu(String kullaniciBolumu) {
        this.kullaniciBolumu = kullaniciBolumu;
    }

    public Status getStatu() {
        return statu;
    }

    public void setStatu(Status statu) {
        this.statu = statu;
    }

    public Date getSonDurumTarihi() {
        return sonDurumTarihi;
    }

    public void setSonDurumTarihi(Date sonDurumTarihi) {
        this.sonDurumTarihi = sonDurumTarihi;
    }

    public String getAnalist() {
        return analist;
    }

    public void setAnalist(String analist) {
        this.analist = analist;
    }

    public String getGelistirici() {
        return gelistirici;
    }

    public void setGelistirici(String gelistirici) {
        this.gelistirici = gelistirici;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public boolean isAktiflik() {
        return aktiflik;
    }

    public void setAktiflik(boolean aktiflik) {
        this.aktiflik = aktiflik;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }
    
    public enum Status {
        BEKLEYEN("Bekleyen"),
        DEVAM_EDEN("Devam Eden"),
        TAMAMLANDI("Tamamlandı"),
        IPTAL("İptal");

        private final String value;

        Status(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}