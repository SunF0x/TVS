package com.labs.client.serial_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;


/**
 * <p>Java class for serial complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="serial">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="character" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="episodes" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="seasons" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="year" type="{http://tx.wsdl.java/}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "serial", propOrder = {
        "character",
        "episodes",
        "seasons",
        "title",
        "year"
})
public class Serial {

    protected String character;
    protected Integer episodes;
    protected Integer seasons;
    protected String title;
    protected Date year;

    /**
     * Gets the value of the character property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCharacter() {
        return character;
    }

    /**
     * Sets the value of the character property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCharacter(String value) {
        this.character = value;
    }

    /**
     * Gets the value of the episodes property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getEpisodes() {
        return episodes;
    }

    /**
     * Sets the value of the episodes property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setEpisodes(Integer value) {
        this.episodes = value;
    }

    /**
     * Gets the value of the seasons property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getSeasons() {
        return seasons;
    }

    /**
     * Sets the value of the seasons property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setSeasons(Integer value) {
        this.seasons = value;
    }

    /**
     * Gets the value of the title property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the year property.
     *
     * @return
     *     possible object is
     *     {@link Date }
     *
     */
    public Date getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     *
     * @param value
     *     allowed object is
     *     {@link Date }
     *
     */
    public void setYear(Date value) {
        this.year = value;
    }

}
