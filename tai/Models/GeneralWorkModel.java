package Models;

import java.util.Date;
import java.util.Optional;

public class GeneralWorkModel {
    private String no;
    private String iletilenIhtiyac;
    private Date ihtiyacTarihi;
    private String ihtiyacSahibi;
    private String ihtiyacBolumu;
    private Status statu;
    private String notlar;
    private Date durumGuncellemeTarihi;
    private String isPaydasPersoneli;
    private String isMetrikPersoneli;
    private String isAnalitikPersoneli;
    private Optional<Date> tamamlanmaTarihi;
    private boolean aktiflik;
    private String aciklama;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getIletilenIhtiyac() {
        return iletilenIhtiyac;
    }

    public void setIletilenIhtiyac(String iletilenIhtiyac) {
        this.iletilenIhtiyac = iletilenIhtiyac;
    }

    public Date getIhtiyacTarihi() {
        return ihtiyacTarihi;
    }

    public void setIhtiyacTarihi(Date ihtiyacTarihi) {
        this.ihtiyacTarihi = ihtiyacTarihi;
    }

    public String getIhtiyacSahibi() {
        return ihtiyacSahibi;
    }

    public void setIhtiyacSahibi(String ihtiyacSahibi) {
        this.ihtiyacSahibi = ihtiyacSahibi;
    }

    public String getIhtiyacBolumu() {
        return ihtiyacBolumu;
    }

    public void setIhtiyacBolumu(String ihtiyacBolumu) {
        this.ihtiyacBolumu = ihtiyacBolumu;
    }

    public Status getStatu() {
        return statu;
    }

    public void setStatu(Status statu) {
        this.statu = statu;
    }

    public String getNotlar() {
        return notlar;
    }

    public void setNotlar(String notlar) {
        this.notlar = notlar;
    }

    public Date getDurumGuncellemeTarihi() {
        return durumGuncellemeTarihi;
    }
    
    public void setDurumGuncellemeTarihi(Date durumGuncellemeTarihi) {
        this.durumGuncellemeTarihi = durumGuncellemeTarihi;
    }

    public String getIsPaydasPersoneli() {
        return isPaydasPersoneli;
    }

    public void setIsPaydasPersoneli(String isPaydasPersoneli) {
        this.isPaydasPersoneli = isPaydasPersoneli;
    }

    public String getIsMetrikPersoneli() {
        return isMetrikPersoneli;
    }

    public void setIsMetrikPersoneli(String isMetrikPersoneli) {
        this.isMetrikPersoneli = isMetrikPersoneli;
    }

    public String getIsAnalitikPersoneli() {
        return isAnalitikPersoneli;
    }

    public void setIsAnalitikPersoneli(String isAnalitikPersoneli) {
        this.isAnalitikPersoneli = isAnalitikPersoneli;
    }

    public Optional<Date> getTamamlanmaTarihi() {
        return tamamlanmaTarihi;
    }

    public void setTamamlanmaTarihi(Optional<Date> tamamlanmaTarihi) {
        this.tamamlanmaTarihi = tamamlanmaTarihi;
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