import javax.xml.crypto.Data;
import java.util.Date;

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
    public String getTitle() {
        return title;
    }
    public String getCharacter() {
        return character;
    }
    public Integer getSeasons() {
        return seasons;
    }
    public Integer getEpisodes() {
        return episodes;
    }
    public Date getYear() {
        return year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public void setSeasons(Integer seasons) {
        this.seasons = seasons;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Serial {" + "title=" + title + ", character=" + character + ", episodes=" + episodes +
                ", seasons=" + seasons + ", year=" + year + '}';
    }
}
