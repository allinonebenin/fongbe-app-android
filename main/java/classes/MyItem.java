package classes;

/**
 * Created by Marie-Parisius D. HOUESSOU on 04/11/2016.
 */

public class MyItem {
    public MyItem(int image, String nameFrench, String nameFon, int audio) {
        this.image = image;
        this.nameFrench = nameFrench;
        this.nameFon = nameFon;
        this.audio = audio;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNameFrench() {
        return nameFrench;
    }

    public void setNameFrench(String nameFrench) {
        this.nameFrench = nameFrench;
    }

    public String getNameFon() {
        return nameFon;
    }

    public void setNameFon(String nameFon) {
        this.nameFon = nameFon;
    }

    private int image;
    private String nameFrench;
    private String nameFon;

    public int getAudio() {
        return audio;
    }

    public void setAudio(int audio) {
        this.audio = audio;
    }

    private int audio;
}
