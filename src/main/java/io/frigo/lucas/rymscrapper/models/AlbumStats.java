package io.frigo.lucas.rymscrapper.models;

public class AlbumStats {
    private String name;
    private String artist;
    private String imgUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "AlbumStats{" +
                "name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
