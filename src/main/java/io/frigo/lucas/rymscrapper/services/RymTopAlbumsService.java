package io.frigo.lucas.rymscrapper.services;

import io.frigo.lucas.rymscrapper.models.AlbumStats;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RymTopAlbumsService {
    private String URL = "https://rateyourmusic.com/customchart?page=1&chart_type=top&type=album&year=alltime&genre_include=1&include_child_genres=1&genres=punk&include_child_genres_chk=1&include=both&origin_countries=&limit=none&countries=";
    List<AlbumStats> allStats = new ArrayList<>();

    public List<AlbumStats> getAllStats() {
        return allStats;
    }

    @PostConstruct
    public void getTopAlbumsFromGenre() throws IOException {
        Document doc = Jsoup.connect(URL).get();
        Elements artistNames = doc.getElementsByClass("artist");
        Elements albumNames = doc.getElementsByClass("album");
        Elements albumCovers = doc.getElementsByClass("delayloadimg");

        List<AlbumStats> newStats = new ArrayList<>();

        //TODO: Arrumar esse loop. A tabela exibe todos os artistas e depois os respectivos nomes dos albums.

        //for(int i = 0; i < artistNames.size(); i++){
            for(Element artist : artistNames){
                AlbumStats albumStats = new AlbumStats();
                albumStats.setArtist(artist.text());
                newStats.add(albumStats);

            }

            for(Element album : albumNames ){
                AlbumStats albumStats = new AlbumStats();
                albumStats.setName(album.text());
                newStats.add(albumStats);
            }

            for(Element cover : albumCovers){
                AlbumStats albumStats = new AlbumStats();
                String url = cover.attr("src");
                albumStats.setImgUrl(url);
                newStats.add(albumStats);
            }

       // }

        this.allStats = newStats;
    }

}
