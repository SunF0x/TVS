package org.example;

import javax.xml.crypto.Data;
import java.util.Date;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Serial {
    private String title;
    private String character;
    private Integer seasons;
    private Integer episodes;
    private Date year;
    public Serial() {
    }
    public Serial(String title, String character, Integer seasons, Integer episodes, Date year) {
        this.title = title;
        this.character = character;
        this.seasons = seasons;
        this.episodes = episodes;
        this.year = year;
    }

    @XmlElement
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement
    public String getCharacter() {
        return character;
    }
    public void setCharacter(String character) {
        this.character = character;
    }

    @XmlElement
    public Integer getSeasons() {
        return seasons;
    }
    public void setSeasons(Integer seasons) {
        this.seasons = seasons;
    }

    @XmlElement
    public Integer getEpisodes() {
        return episodes;
    }
    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }

    @XmlElement
    public Date getYear() {
        return year;
    }
    public void setYear(Date year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "org.example.Serial {" + "title=" + title + ", character=" + character + ", episodes=" + episodes +
                ", seasons=" + seasons + ", year=" + year + '}';
    }
}
